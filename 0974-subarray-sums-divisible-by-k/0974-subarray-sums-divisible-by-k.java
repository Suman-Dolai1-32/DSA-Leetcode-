class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int sum = 0,rem = 0,ans = 0;
        map.put(0,1);
        for(int i : nums)
        {
            sum += i;
            rem = sum % k;
            if(rem < 0)
                rem = rem + k;
            if(map.containsKey(rem))
                ans += map.get(rem);
            map.put(rem,map.getOrDefault(rem,0)+1);
        }
        return ans;
    }
}