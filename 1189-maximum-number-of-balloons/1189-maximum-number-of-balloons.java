class Solution {
    public int maxNumberOfBalloons(String text) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(char ch : text.toCharArray())
            map.put(ch,map.getOrDefault(ch,0) + 1);
        int c = 0;
        while(true)
        {
            if(map.getOrDefault('b',0) >= 1 && map.getOrDefault('a',0) >= 1 && map.getOrDefault('l',0) >= 2 && map.getOrDefault('o',0) >= 2 && map.getOrDefault('n',0) >= 1)
            {
                c++;
                map.put('b',map.getOrDefault('b',0) - 1);
                map.put('a',map.getOrDefault('a',0) - 1);
                map.put('l',map.getOrDefault('l',0) - 2);
                map.put('o',map.getOrDefault('o',0) - 2);
                map.put('n',map.getOrDefault('n',0) - 1);
            }
            else
                break;
        }
        return c;
    }
}