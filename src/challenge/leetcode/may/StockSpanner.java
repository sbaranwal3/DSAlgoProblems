package challenge.leetcode.may;

/*
Write a class StockSpanner which collects daily price quotes for some stock, and returns the span of that stock's price for the current day.

The span of the stock's price today is defined as the maximum number of consecutive days (starting from today and going backwards) for which the price of the stock was less than or equal to today's price.

For example, if the price of a stock over the next 7 days were [100, 80, 60, 70, 60, 75, 85], then the stock spans would be [1, 1, 1, 2, 1, 4, 6].



Example 1:

Input: ["StockSpanner","next","next","next","next","next","next","next"], [[],[100],[80],[60],[70],[60],[75],[85]]
Output: [null,1,1,1,2,1,4,6]
Explanation:
First, S = StockSpanner() is initialized.  Then:
S.next(100) is called and returns 1,
S.next(80) is called and returns 1,
S.next(60) is called and returns 1,
S.next(70) is called and returns 2,
S.next(60) is called and returns 1,
S.next(75) is called and returns 4,
S.next(85) is called and returns 6.

Note that (for example) S.next(75) returned 4, because the last 4 prices
(including today's price of 75) were less than or equal to today's price.


Note:

Calls to StockSpanner.next(int price) will have 1 <= price <= 10^5.
There will be at most 10000 calls to StockSpanner.next per test case.
There will be at most 150000 calls to StockSpanner.next across all test cases.
The total time limit for this problem has been reduced by 75% for C++, and 50% for all other languages.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StockSpanner {
    List<Integer> spans;
    List<Integer> prices;

    public StockSpanner() {
        spans = new ArrayList<>();
        prices = new ArrayList<>();
    }

    public int next(int price) {
        int idx = prices.size() - 1;
        while (idx >= 0 && prices.get(idx) <= price) {
            int span = spans.get(idx);
            idx = idx - span;
        }
        prices.add(price);
        int span = prices.size() - 1 - idx;
        spans.add(span);
        return span;
    }

    public static void main(String[] args) {
        StockSpanner obj = new StockSpanner();
        System.out.println(obj.next(100));
        System.out.println(obj.next(80));
        System.out.println(obj.next(60));
        System.out.println(obj.next(70));
        System.out.println(obj.next(60));
        System.out.println(obj.next(75));
        System.out.println(obj.next(85));
    }
}

class StockSpannerUsingStack {
    Stack<Integer> weights;
    Stack<Integer> prices;

    public StockSpannerUsingStack() {
        weights = new Stack<>();
        prices = new Stack<>();
    }

    public int next(int price) {
        int count = 1;
        while (!prices.isEmpty() && prices.peek() <= price) {
            prices.pop();
            count += weights.pop();
        }
        prices.push(price);
        weights.push(count);
        return count;
    }

    public static void main(String[] args) {
        StockSpannerUsingStack obj = new StockSpannerUsingStack();
        System.out.println(obj.next(100));
        System.out.println(obj.next(80));
        System.out.println(obj.next(60));
        System.out.println(obj.next(70));
        System.out.println(obj.next(60));
        System.out.println(obj.next(75));
        System.out.println(obj.next(85));
    }
}