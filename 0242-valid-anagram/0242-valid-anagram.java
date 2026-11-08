class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;
        int map1[] = new int[26];
        int map2[] = new int[26];
        for(char ch : s.toCharArray())
            map1[ch - 'a']++;
        for(char ch : t.toCharArray())
            map2[ch - 'a']++;
        for(int i = 0;i<26;i++)
        {
            if(map1[i] != map2[i])
                return false;
        }
        return true;
    }
}