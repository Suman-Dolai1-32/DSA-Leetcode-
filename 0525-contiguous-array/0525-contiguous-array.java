class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int cz = 0,co = 0,res = 0;
        for(int i = 0;i<nums.length;i++)
        {
            if(nums[i] == 1)
                co++;
            else
                cz++;
            int diff = cz - co;
            if(diff == 0)
                res = Math.max(res,i+1);
            else if(!map.containsKey(diff))
                map.put(diff,i);
            else
                res = Math.max(res, i - map.get(diff));
        }
        return res;
    }
}