package challenge.leetcode.days.thirty;
import java.util.*;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 *
 *
 * Example:
 *
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> Returns -3.
 * minStack.pop();
 * minStack.top();      --> Returns 0.
 * minStack.getMin();   --> Returns -2.
 */

// Java program to implement a stack that supports
// getMinimum() in O(1) time and O(1) extra space.

class MinStack
{
    Stack<Integer> s;
    int minEle;

    //Constructor
    public MinStack() {
        s = new Stack<>();
    }

    public void push(int x) {
        if (s.isEmpty())
        {
            minEle = x;
            s.push(x);
            return;
        }

        if (x < minEle)
        {
            if(x == Integer.MIN_VALUE){
                s.push(x);}
            else{
                s.push(2*x - minEle);
            }
            minEle = x;
        }

        else
            s.push(x);
    }

    public void pop() {
        if (s.isEmpty())
        {
            return;
        }
        int t = s.pop();

        if (t < minEle)
        {
            minEle = 2*minEle - t;
        }

    }

    public int top() {
        if (s.isEmpty())
         return 0;

        int t = s.peek();

        if (t < minEle){
            t = minEle;
        }

        return t;

    }

    public int getMin() {
        if (s.isEmpty())
            return 0;
        //If only 1 element is left in stack, minEle = that element
        else if(s.size()==1)
            return s.peek();
        else
            return minEle;

    }

    public static void main(String[] args)
    {
        MinStack s = new MinStack();
        s.push(2147483646);
        s.push(2147483646);
        s.push(2147483647);
        System.out.println("Topmost element is: "+s.top());
        s.pop();
        System.out.println("Element with minimum value is: "+s.getMin());
        s.pop();
        System.out.println("Element with minimum value is: "+s.getMin());
        s.pop();
        s.push(2147483647);
        System.out.println("Topmost element is: "+s.top());
        s.getMin();
        s.push(-2147483648);
        System.out.println("Topmost element is: "+s.top());
        System.out.println("Element with minimum value is: "+s.getMin());
        s.pop();
        System.out.println("Element with minimum value is: "+s.getMin());
    }
}
