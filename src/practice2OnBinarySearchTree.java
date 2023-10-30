public class practice2OnBinarySearchTree {
    static Node root;
    static void binaryTree(){
        root = null;
    }
    static void insert(int val){
        root = insert(root,val);
    }
    static Node insert(Node root,int val){
        if(root==null){
            root = new Node(val);
            return root;
        }
        if(val<root.val){
            root.left = insert(root.left,val);
        }else if(val>root.val){
            root.right  = insert(root.right,val);
        }
        return root;
    }

    static void deleteNode(int val){
        root = deleteNode(root,val);
    }
    static Node deleteNode(Node root,int val){
        if(root==null){
            root = new Node(val);
            return root;
        }
        if(val<root.val){
            root.left = deleteNode(root.left,val);
        }else if(val>root.val){
            root.right  = deleteNode(root.right,val);
        }else{
            if(root.left==null){
                return root.right;
            }else if(root.right==null){
                return root.left;
            }
            root.val = minVal(root.right);
            root.right = deleteNode(root.right,root.val);
        }
        return root;
    }

    static int minVal(Node root ){
        int min = root.val;
        while(root.left!=null){
            min = root.left.val;
            root = root.left;
        }
        return min;
    }


    static class Node{
        int val;
        Node right;
        Node left;
        public Node(int val){
            this.val = val;
            this.right = null;
        }
    }

    public static void main(String[] args) {

    }
}
