class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(char ch : s.toCharArray())
            map.put(ch,map.getOrDefault(ch,0) + 1);
        int maxLength = 0;
        boolean flag = false;
        for(char ch : map.keySet())
        {
            if(map.get(ch) % 2 == 0)
                maxLength += map.get(ch);
            else
            {
                maxLength += map.get(ch) - 1;
                flag = true;
            }
        }
        if(flag)
            return maxLength + 1;
        return maxLength;
    }
}