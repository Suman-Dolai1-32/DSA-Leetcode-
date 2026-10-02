class Solution {
    public String reverseStr(String s, int k) 
    {
        StringBuilder sb = new StringBuilder("");
        StringBuilder ans = new StringBuilder("");
        for(int i = 0; i < s.length(); i += 2 * k)
        {
            sb = new StringBuilder("");
            int c = 0;
            while(c < k && i + c < s.length())
            {
                sb.append(s.charAt(i + c));
                c++;
            }
            ans.append(sb.reverse());
            c = k;
            while(c < 2 * k && i + c < s.length())
            {
                ans.append(s.charAt(i + c));
                c++;
            }
        }
    
        return ans.toString();
    }
}