package DP;

public class Solution {
    public static void main(String[] args) {
        int[] a = {7,9,6,8,4};
        System.out.println(LIS(a));
    }

    public static int LIS(int[] a){
        int length = a.length;
        int[] dp = new int[length];
        int res = 0;
        for (int i = 0; i < length; i++){
            dp[i] = 1;
            for (int j = 0; j < i; j++){
                if (a[i] > a[j]) dp[i] = Math.max(dp[i], dp[j]  + 1);
            }
            res = Math.max(res, dp[i]);
        }

        return res;
    }
}
