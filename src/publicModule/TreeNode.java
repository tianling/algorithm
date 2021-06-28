package publicModule;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
          treeNodes.get(i).left = treeNodes.get(i * 2 + 1);
          treeNodes.get(i).right = treeNodes.get(i * 2 + 2);
      }

      int parentIndex = initArr.size() / 2 - 1;
      treeNodes.get(parentIndex).left = treeNodes.get(parentIndex * 2 + 1);

      if (initArr.size() % 2 == 1) {
          treeNodes.get(parentIndex).right = treeNodes.get(parentIndex * 2 + 2);
      }
      
      return treeNodes;
   }

    public static TreeNode createAnyTreeByArr(Integer [] arr) {
      Queue<Integer> queueNum = new LinkedList<>();
      for (Integer i : arr) {
         queueNum.add(i);
      }

      if (queueNum.isEmpty()) {
         return null;
      }

      TreeNode root = new TreeNode(queueNum.poll());
      Queue<TreeNode> queueNode = new LinkedList<>();
      queueNode.offer(root);

      while (!queueNum.isEmpty() && !queueNode.isEmpty()) {
         TreeNode tmp = queueNode.poll();
         if (null != tmp) {
            Integer left = queueNum.poll();
            Integer right = queueNum.poll();

            if (left != null) {
               tmp.left = new TreeNode(left);
            }

            if (right != null) {
               tmp.right = new TreeNode(right);
            }
            if (null != left) {
               queueNode.offer(tmp.left);
            }

            if (null != right) {
               queueNode.offer(tmp.right);
            }
         }
      }

      return root;
   }
}
