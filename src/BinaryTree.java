import apple.laf.JRSUIUtils;

/**
 * Created by sowmyaparameshwara on 11/16/16.
 */
public class BinaryTree {

    TreeNode root;
    int numberOfNodes=0;
    boolean isFound;

    public void insertNode(int value) {
        if(root==null){
            root = new TreeNode(value,null,null);
            numberOfNodes++;
        }else{
            TreeNode toBeInserted = new TreeNode(value,null,null);
            int height = getHeight(root);
            int numberOfNodesAtALevel = (1<<(height)) -1;
            if(numberOfNodes == numberOfNodesAtALevel){
                TreeNode temp = root;
                while(temp.leftNode!=null){
                    temp = temp.leftNode;
                }
                temp.leftNode = toBeInserted;
                numberOfNodes++;

            }else{
                traverseLevel(root,null,height,toBeInserted);
                isFound = false;

            }
        }
    }


    private void traverseLevel(TreeNode parent,TreeNode child, int level,TreeNode toBeInserted) {
        if(!isFound) {
            if (level == 1) {
                if (child == null) {
                    if (parent.leftNode == null) {
                        parent.leftNode = toBeInserted;
                    } else {
                        parent.rightNode = toBeInserted;
                    }
                    numberOfNodes++;
                    isFound = true;
                }
            } else {
                if (child == null) {
                    traverseLevel(parent, parent.leftNode, level - 1, toBeInserted);
                    traverseLevel(parent, parent.rightNode, level - 1, toBeInserted);
                } else {
                    traverseLevel(child, child.leftNode, level - 1, toBeInserted);
                    traverseLevel(child, child.rightNode, level - 1, toBeInserted);
                }

            }

        }

    }

    private static int getHeight(TreeNode temp){
        if(temp == null){
            return 0;
        }else{
            int lHeight = getHeight(temp.leftNode);
            int rHeight = getHeight(temp.rightNode);
            if(lHeight>rHeight){
                return lHeight+1;
            }else{
                return rHeight+1;
            }
        }
    }

    public void printLevelByLevel() {
        int height = getHeight(root);
        for(int i=1; i <= height; i++){
            printGivenLevel(root,i);
            System.out.println();

        }
    }

    private void printGivenLevel(TreeNode temp, int level) {
        if(temp == null ){
            return;
        }else if (level == 1){
            System.out.print(" "+temp.data);
        }else{
            printGivenLevel(temp.leftNode,level-1);
            printGivenLevel(temp.rightNode,level-1);
        }
    }

    public static boolean isIdentical(TreeNode rootTree1, TreeNode rootTree2){
        int height1 = getHeight(rootTree1);
        int height2 = getHeight(rootTree2);
        if(height1==height2){
            return identical(rootTree1,rootTree2);
        }else{
            return false;
        }
    }

    public static boolean identical(TreeNode rootTree1, TreeNode rootTree2){
        if (rootTree1==null && rootTree2==null)
        {
            return true;
        }
        else if (rootTree1!=null && rootTree2!=null)
        {
            return(rootTree1.data == rootTree2.data &&
                    identical(rootTree1.leftNode, rootTree2.leftNode) &&
                    identical(rootTree1.rightNode, rootTree2.rightNode));
        }
        else
            return false;

    }

    class TreeNode{
        int data;
        TreeNode leftNode;
        TreeNode rightNode;

        TreeNode(int data, TreeNode leftNode, TreeNode rightNode){
            this.data = data;
            this.leftNode = leftNode;
            this.rightNode = rightNode;
        }

    }
}
