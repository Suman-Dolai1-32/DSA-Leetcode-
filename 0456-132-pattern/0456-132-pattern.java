class Solution {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        int two = Integer.MIN_VALUE;

        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] < two) return true;

            while (!st.isEmpty() && nums[i] > st.peek()) {
                two = st.pop();
            }

            st.push(nums[i]);
        }

        return false;
    }
}