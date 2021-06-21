package publicModule;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {
   int val;
   TreeNode left;
   TreeNode right;
   
   public TreeNode() {}
   public TreeNode(int val) {this.val = val;}
   public TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
   }
   
   public List<TreeNode> initTreeNodes(List<Integer> initArr) {
      List<TreeNode> treeNodes = new ArrayList<>();
      for (Integer i : initArr) {
          treeNodes.add(new TreeNode(i));
      }
     
      for (int i = 0; i < initArr.size() / 2 - 1; i++) {
          treeNodes.get(i).leftNode = treeNodes.get(i * 2 + 1);
          treeNodes.get(i).rightNode = treeNodes.get(i * 2 + 2);
      }

      int parentIndex = initArr.size() / 2 - 1;
      treeNodes.get(parentIndex).leftNode = treeNodes.get(parentIndex * 2 + 1);

      if (initArr.size() % 2 == 1) {
          treeNodes.get(parentIndex).rightNode = treeNodes.get(parentIndex * 2 + 2);
      }
      
      return treeNodes;
   }
}
