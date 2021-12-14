public class BinarySearchTree {
    private TreeNode root;

    public BinarySearchTree() {
        root = null;
    }

    public TreeNode getRoot() {
        return root;
    }

    public class TreeNode {
        private Listing listing;
        private TreeNode leftChild;
        private TreeNode rightChild;

        public TreeNode() {
        }
    
        public TreeNode(Listing l) {
            listing = l;
        }

        public TreeNode(TreeNode left, TreeNode right) {
            leftChild = left;
            rightChild = right;
        }
    }

    public class TreeNodeWrapper {
        TreeNode ref = null;

        public TreeNodeWrapper() {
        }

        public TreeNodeWrapper(TreeNode n) {
            ref = n;
        }
        public TreeNode get() {
            return ref;
        }
        public void set(TreeNode n) {
            ref = n;
        }
    }

    public boolean findNode(String targetKey, TreeNodeWrapper p, TreeNodeWrapper c) {
        p.set(root);
        c.set(root);

        if(root == null)
            return true;
        while (c.get() != null) {
            if(c.get().listing.compareTo(targetKey) == 0) 
                return true;
            else {
                p.set(c.get());
                if(targetKey.compareTo(c.get().listing.getKey()) < 0) 
                    c.set(c.get().leftChild);
                
                else 
                    c.set(c.get().rightChild);              
            }
        }
        return false;
    }

    public boolean insert(Listing newListing) {
        TreeNodeWrapper p = new TreeNodeWrapper();
        TreeNodeWrapper c = new TreeNodeWrapper();
        TreeNode n = new TreeNode();
        n.listing = newListing.deepCopy();

        if(root == null) {
            root = n;
        }
        else {
            findNode(newListing.getKey(), p, c);

            if(newListing.getKey().compareTo(p.get().listing.getKey()) < 0)
                p.get().leftChild = n;
            else
                p.get().rightChild = n;
            }
            return true;      
    }

    public Listing fetch(String targetKey) {
        TreeNodeWrapper p = new TreeNodeWrapper();
        TreeNodeWrapper c = new TreeNodeWrapper();
        boolean found = findNode(targetKey, p, c);

        if(found)
            return c.get().listing.deepCopy();
        else
            return null;
    }

    public boolean update(String targetKey, Listing newListing) {
        if(!delete(targetKey))
            return false;
        else if(insert(newListing) == false)
            return false;
        return true;
    }

    public boolean delete(String targetKey) {
        TreeNodeWrapper p = new TreeNodeWrapper();
        TreeNodeWrapper c = new TreeNodeWrapper();
        TreeNode largest;
        TreeNode nextLargest;
        boolean found;
        found = findNode(targetKey, p, c);
        
        if(!found) {
            return false;
        }

        else {

            // case 1: node to be deleted is a leaf node(has no children)
            if(c.get().leftChild == null && c.get().rightChild == null) {
                if(p.get().leftChild == c.get()) 
                    p.get().leftChild = null;
                else {
                    p.get().rightChild = null;
                }
                return true;
            }

            // case 2: node to be deleted has one child or subtree
            else if(c.get().leftChild != null && c.get().rightChild == null  || c.get().rightChild != null && c.get().leftChild == null) {
                 
                if(p.get().leftChild == c.get()) {
                    if (c.get().leftChild != null) 
                        p.get().leftChild = c.get().leftChild; 
                    
                    else 
                    p.get().leftChild = c.get().rightChild;
                }
    
                else {
                    if(c.get().leftChild != null)
                        p.get().rightChild = c.get().leftChild;
                    else
                        p.get().rightChild = c.get().rightChild;
                }
                return true;  
            }


            // case 3: node to be deleted has two children
            else if(c.get().leftChild != null && c.get().rightChild != null) {
                nextLargest = c.get().leftChild;
                largest = nextLargest.rightChild;

                if(largest != null) {
                    while(largest.rightChild != null) {
                        nextLargest = largest;
                        largest = largest.rightChild;
                    }
                    c.get().listing = largest.listing;
                    nextLargest.rightChild = largest.leftChild;
                }

                else {
                    nextLargest.rightChild = c.get().rightChild;

                    if(p.get().leftChild == c.get()) 
                        p.get().leftChild = nextLargest;
                    
                    else 
                        p.get().rightChild =nextLargest;
                }                
            }
            return true;
        }
    }

    public void printTree(TreeNode startingNode) {
        if(startingNode == null) {
            return;
        }
        System.out.println(startingNode.listing.toString()+"\n"); 
        printTree(startingNode.leftChild);
        printTree(startingNode.rightChild);       
    } 
}