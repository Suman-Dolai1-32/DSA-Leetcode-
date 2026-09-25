class Solution {
    int i = 0;
    public List<String> braceExpansionII(String expression) {
        Set<String> set = parse(expression);
        List<String> res = new ArrayList<>(set);
        Collections.sort(res);
        return res;
    }
    private Set<String> parse(String s) {
        Set<String> res = new HashSet<>();
        Set<String> curr = new HashSet<>();
        curr.add("");
        while (i < s.length() && s.charAt(i) != '}') {
            char ch = s.charAt(i);
            if (ch == '{') {
                i++;
                Set<String> inner = parse(s);
                i++; // skip '}'
                curr = multiply(curr, inner);
            } 
            else if (ch == ',') {
                res.addAll(curr);
                curr = new HashSet<>();
                curr.add("");
                i++;
            } 
            else {
                Set<String> letter = new HashSet<>();
                letter.add(String.valueOf(ch));
                curr = multiply(curr, letter);
                i++;
            }
        }
        res.addAll(curr);
        return res;
    }
    private Set<String> multiply(Set<String> a, Set<String> b) {
        Set<String> res = new HashSet<>();
        for (String x : a) {
            for (String y : b) {
                res.add(x + y);
            }
        }
        return res;
    }
}