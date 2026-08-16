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
    public String func(TreeNode root,HashMap<String,Integer> map,List<TreeNode> lst)
    {
        if(root == null)
            return "null";
        String s = Integer.toString(root.val) + "," + func(root.left,map,lst) + "," + func(root.right,map,lst);
        map.put(s, map.getOrDefault(s, 0) + 1);
        if(map.get(s) == 2)
            lst.add(root);
        return s;
    }
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) 
    {
        HashMap<String,Integer> map = new HashMap<>();
        List<TreeNode> lst = new ArrayList<>();
        func(root,map,lst);
        return lst;
    }
}