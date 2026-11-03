class Solution {
    public void reverse(int arr[],int a,int b)
    {
        for(int i = a,j = b;i < j;i++,j--)
        {
            int t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
        }
    }
    public void rotate(int[] nums, int k) {
        if(k > nums.length)
            k = k % nums.length;
        reverse(nums,0,nums.length - 1);
        reverse(nums,0,k - 1);
        reverse(nums,k,nums.length - 1);
    }
}