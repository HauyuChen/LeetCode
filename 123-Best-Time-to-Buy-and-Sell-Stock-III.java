123. Best Time to Buy and Sell Stock III

Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).


思路：
1. 只能进行两次交易，要求两次交易获利之和最大；
2. 第一次交易：从前往后遍历，计算每天的最大获利 left[] ， left[i] 表示第 i 天的最多能获利多少；
3. 第二次交易：从后往前遍历，计算每天的最大获利 right[] ， right[i] 表示第 i 天的最多能获利多少；
4. 最大获利：计算哪一天的 left[i] + right[i] 最大，即为两次交易的最大获利。



class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if(len<=1){
            return 0;
        }
        int left[] = new int[len];
        int right[] = new int[len];
        
        int min = prices[0];
        left[0] = 0;
        for(int i=1;i<len;i++){
            min = Math.min(prices[i],min);
            left[i] = Math.max(left[i-1],prices[i]-min);
        }
        
        int max = prices[len-1];
        right[len-1] = 0;
        for(int i=len-2;i>=0;i--){
            max = Math.max(prices[i],max);
            right[i] = Math.max(right[i+1],max-prices[i]);
        }
        
        int profit = 0;
        for(int i=0;i<len;i++){
            profit = Math.max(profit,left[i]+right[i]);
        }
        
        return profit;
    }
}