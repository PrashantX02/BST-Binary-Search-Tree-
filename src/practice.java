public class practice {

    static Node root;
    static class Node{
        Node left;
        Node right;
        int data;
        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static void binarySearchTree(){
        root = null;
    }
    static void insert(int val){
        root = insert(root,val);
    }
    static Node insert(Node root,int val){
        if(root== null){
            root = new Node(val);
            return root;
        }

        if(val<root.data){
            root.left = insert(root.left,val);
        }else if(val>root.data){
            root.right = insert(root.right,val);
        }
        return root;
    }

    static void deleteNode(int val){
        deleteNode(root,val);
    }
    static Node deleteNode(Node root,int val){
        if(root==null){
            return root;
        }
        if(val<root.data){
            root.left = deleteNode(root.left,val);
        }else if(val>root.data){
            root.right = deleteNode(root.right,val);
        }else{
            if(root.left==null){
                return root.right;
            }else if(root.right==null){
                return root.left;
            }
            root.data = minValue(root.right);
            root.right = deleteNode(root.right,root.data);
        }
        return root;
    }

    static int minValue(Node root){
        int min = root.data;
        while(root.left!=null){
            min = root.left.data;
            root = root.left;
        }
        return min;
    }
    static int sum;
    static int traverse(Node root,int low,int high){
        if(root!=null){
            if(low<=root.data && root.data<=high){
                sum += root.data;
            }
            if(low<=root.data) {
                traverse(root.left, low, high);
            }
            if(root.data<=high) {
                traverse(root.right, low, high);
            }
        }
        return sum;
    }
    static public int rangeSumBST(Node root, int low, int high) {
        sum = 0;
        return traverse(root,low,high);
    }



    static Node temp;
    static void searchToNode(Node root, int val){
        if(root==null||root.data == val){
            temp = root;
            return ;
        }
        if(val<root.data){
            searchToNode(root.left,val);
        }else {
            searchToNode(root.right,val);
        }
    }
    static void PrintAll(int val){
        searchToNode(root,val);
        Print(temp);
    }
    static void Print(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            Print(root.left);
            Print(root.right);
        }
    }

    public static void main(String[] args) {

        insert(50);
        insert(30);
        insert(20);
        insert(40);
        insert(70);
        insert(60);
        insert(80);
    //    System.out.println(rangeSumBST(root,20,60));
      //  System.out.println(rangeSumBST(root,20,50));
        PrintAll(30);
    }
}
