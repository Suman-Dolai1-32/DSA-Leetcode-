import java.util.*;
class Solution {
    public String reverseWords(String s) {
        StringTokenizer st = new StringTokenizer(s);
        StringBuilder sb = new StringBuilder();
        ArrayList<String> lst = new ArrayList<>();
        while(st.hasMoreTokens())
            lst.add(st.nextToken());
        Collections.reverse(lst);
        for(int i = 0;i<lst.size();i++)
            if(i == lst.size() - 1)
                sb.append(lst.get(i));
            else
                sb.append(lst.get(i)).append(" ");
        return sb.toString();

    }
}