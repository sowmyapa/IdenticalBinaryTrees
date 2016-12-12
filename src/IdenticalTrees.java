import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by sowmyaparameshwara on 11/16/16.
 */
public class IdenticalTrees {


    public static void main(String[] args) throws IOException {

        System.out.println("Enter details of tree 1");
        System.out.println("Enter number of nodes");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        BinaryTree tree1 = new BinaryTree();
        for(int i = 0;i < count; i++){
           System.out.println(" Enter node "+(i+1)+" value in int ");
            int value = Integer.parseInt(br.readLine());
            tree1.insertNode(value);
        }
        System.out.println("Tree 1 is as follows : ");
        tree1.printLevelByLevel();
        System.out.println("Enter details of tree 2");
        System.out.println("Enter number of nodes");
        count = Integer.parseInt(br.readLine());
        BinaryTree tree2 = new BinaryTree();
        for(int i = 0;i < count; i++){
            System.out.println(" Enter node "+(i+1)+" value in int ");
            int value = Integer.parseInt(br.readLine());
            tree2.insertNode(value);
        }
        System.out.println("Tree 2 is as follows : ");
        tree2.printLevelByLevel();
        boolean isIdentical = BinaryTree.isIdentical(tree1.root,tree2.root);
        if(isIdentical){
            System.out.println(" The two trees are identical");
        }else{
            System.out.println(" The two trees are not identical");
        }
    }
}
