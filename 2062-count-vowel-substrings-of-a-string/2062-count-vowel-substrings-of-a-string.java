class Solution {
    public boolean check(String s)
    {
        int c1 = 0,c2 = 0,c3 = 0,c4 = 0,c5 = 0;
        for(int i = 0;i<s.length();i++)
        {
            char ch = s.charAt(i);
            if(ch == 'a')
                c1++;
            else if(ch == 'e')
                c2++;
            else if(ch == 'i')
                c3++;
            else if(ch == 'o')
                c4++;
            else if(ch == 'u')
                c5++;
            else 
                return false;
        }
        return (c1 != 0 && c2 != 0 && c3 != 0 && c4 != 0 && c5 != 0);
    }
    public int countVowelSubstrings(String word) {
        int c = 0;
        for(int i = 0;i<word.length();i++)
        {
            for(int j = i;j<word.length();j++)
            {
                String s = word.substring(i,j + 1);
                if(check(s))
                    c++;
            }
        }
        return c;
    }
}