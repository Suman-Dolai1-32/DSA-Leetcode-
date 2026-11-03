class Solution {
    public boolean isPalindrome(String s) {
        String w = s.toLowerCase().replaceAll("[^a-z]", "");
        int left = 0;
        int right = w.length() - 1;
        while(left < right)
        {
            if(w.charAt(left) != w.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
}