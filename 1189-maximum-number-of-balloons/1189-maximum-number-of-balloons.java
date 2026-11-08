class Solution {
    public int maxNumberOfBalloons(String text) {
        int map[] = new int[26];
        for(char ch : text.toCharArray())
            map[ch - 'a']++;
        int times_b = map['b' - 'a'];
        int times_a = map['a' - 'a'];
        int times_l = map['l' - 'a']/2;
        int times_o = map['o' - 'a']/2;
        int times_n = map['n' - 'a'];
        return Math.min(times_b,Math.min(times_a,Math.min(times_l,Math.min(times_o,times_n))));

    }
}