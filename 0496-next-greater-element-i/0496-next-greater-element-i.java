class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int ans[] = new int[nums2.length];
        Stack<Integer> st = new Stack<>();
        st.push(nums2.length - 1);
        ans[ans.length - 1] = -1;
        for(int i = nums2.length - 2;i >= 0;i--)
        {
            while(!st.isEmpty() && nums2[i] > nums2[st.peek()])
                st.pop();
            if(st.isEmpty())
                ans[i] = -1;
            else
                ans[i] = nums2[st.peek()];
            st.push(i);
        }
        int a[] = new int[nums1.length];
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<nums2.length;i++)
            map.put(nums2[i],ans[i]);
        for(int i = 0;i<nums1.length;i++)
            a[i] = map.get(nums1[i]);
        return a;
    }
}