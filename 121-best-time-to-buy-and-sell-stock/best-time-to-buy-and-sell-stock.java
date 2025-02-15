class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE; // To track the minimum price
        int maxProfit = 0;               // To track the maximum profit

        for (int price : prices) {
            // Update the minimum price if the current price is lower
            if (price < minPrice) {
                minPrice = price;
            } 
            // Calculate the profit if selling at the current price
            else {
                int profit = price - minPrice;
                // Update the maximum profit
                maxProfit = Math.max(maxProfit, profit);
            }
        }

        return maxProfit; // Return the maximum profit
    }
}
