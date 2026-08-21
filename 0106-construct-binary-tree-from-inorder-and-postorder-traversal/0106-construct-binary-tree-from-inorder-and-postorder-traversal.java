/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    static int i = 0;
    static HashMap<Integer,Integer> map = new HashMap<>();
    public TreeNode bt(int postorder[],int left,int right)
    {
        if(left > right)
            return null;
        TreeNode root = new TreeNode(postorder[i--]);
        int idx = map.get(root.val);
        root.right = bt(postorder,idx + 1,right);
        root.left = bt(postorder,left,idx - 1);
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        i = postorder.length - 1;
        for(int j = 0;j<inorder.length;j++)
            map.put(inorder[j],j);
        return bt(postorder,0,inorder.length - 1);
    }
}