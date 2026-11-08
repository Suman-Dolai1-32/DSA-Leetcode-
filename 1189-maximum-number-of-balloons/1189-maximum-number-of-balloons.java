class Solution {
    public int maxNumberOfBalloons(String text) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(char ch : text.toCharArray())
            map.put(ch,map.getOrDefault(ch,0) + 1);
        int times_b = map.getOrDefault('b',0)/1;
        int times_a = map.getOrDefault('a',0)/1;
        int times_l = map.getOrDefault('l',0)/2;
        int times_o = map.getOrDefault('o',0)/2;
        int times_n = map.getOrDefault('n',0)/1;
        return Math.min(times_b,Math.min(times_a,Math.min(times_l,Math.min(times_o,times_n))));

    }
}