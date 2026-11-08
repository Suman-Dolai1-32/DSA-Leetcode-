class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();
        List<List<String>> lst = new ArrayList<>();
        for(String st : strs)
        {
            char ch[] = st.toCharArray();
            Arrays.sort(ch);
            String key = new String(ch);
            if(!map.containsKey(key))
                map.put(key,new ArrayList<>());
            map.get(key).add(st);
        }
        return new ArrayList<>(map.values());
    }
}