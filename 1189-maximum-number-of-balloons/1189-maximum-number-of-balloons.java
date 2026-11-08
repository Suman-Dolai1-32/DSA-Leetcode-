class Solution {
    public int maxNumberOfBalloons(String text) {
        int map[] = new int[26];
        for(char ch : text.toCharArray())
            map[ch - 'a']++;
        return Math.min(map['b' - 'a'],Math.min(map['a' - 'a'],Math.min(map['l' - 'a']/2,Math.min(map['o' - 'a']/2,map['n' - 'a']))));

    }
}