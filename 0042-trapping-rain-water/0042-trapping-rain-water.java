class Solution {
    public int trap(int[] height) {
        int l = 0,r = height.length - 1,trappedWater = 0,width = 1;
        int lmax = Integer.MIN_VALUE,rmax = Integer.MIN_VALUE;
        while(l < r)
        {
            lmax = Math.max(lmax,height[l]);
            rmax = Math.max(rmax,height[r]);
            if(height[l] < height[r])
            {
                trappedWater += (lmax - height[l]) * width;
                l++;
            }
            else
            {
                trappedWater += (rmax - height[r]) * width;
                r--;
            }
        }
        return trappedWater;
    }
}