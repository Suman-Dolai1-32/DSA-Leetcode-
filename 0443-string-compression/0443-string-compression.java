class Solution {
    public int compress(char[] chars) {
        int i = 0, w = 0;
        while (i < chars.length) 
        {
            char ch = chars[i];
            int j = i;
            while (j < chars.length && chars[j] == ch)
                j++;
            chars[w++] = ch;
            int c = j - i;
            if(c > 1)
            {
                for(char x : String.valueOf(c).toCharArray())
                chars[w++] = x;
            }
            i = j;
        }
        return w;
    }
}