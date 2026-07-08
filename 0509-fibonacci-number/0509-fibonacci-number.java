class Solution {
    public int fibo(int n,int f[])
    {
        if(n <= 1)
            return n;
        if(f[n] != 0)
            return f[n];
        f[n] = fibo(n-1,f) + fibo(n-2,f);
        return f[n];
    }
    public int fib(int n) {
        int f[] = new int[n+1];
        return fibo(n,f);
    }
}