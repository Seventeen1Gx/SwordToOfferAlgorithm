public class SixtyThree {
    // 股票的最大利润

    // 可以有一次买入和一次卖出，买入必须在前。求最大收益。

    // 贪心，在位置 i 处卖出股票，能得的最大利润为， price[i] - min(price[0,i-1])
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;
        int soFarMin = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            soFarMin = Math.min(soFarMin, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - soFarMin);
        }
        return maxProfit;
    }
}
