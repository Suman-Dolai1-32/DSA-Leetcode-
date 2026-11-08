class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character,Integer> map = new HashMap<>();
        HashMap<Character,Integer> m = new HashMap<>();
        for(char i : ransomNote.toCharArray())
            map.put(i,map.getOrDefault(i,0) + 1);
        for(char i : magazine.toCharArray())
            m.put(i,m.getOrDefault(i,0) + 1);
        for(char ch : map.keySet())
        {
            if(!m.containsKey(ch) || map.get(ch) > m.get(ch))
                return false;
        }
        return true;
    }
}