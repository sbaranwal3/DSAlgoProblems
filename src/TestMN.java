import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

class TestMN {
    public static void main(String[] args){
        String inputs[] = { "NN", "MM", "MN", "NM" };

        for(String input : inputs)
        {
            System.out.println(getMinNumberForPattern(input));
         //   System.out.println(getMinNumberForPatternUsingStack(input));

        }
    }

    static String getMinNumberForPattern(String seq)
    {
        int n = seq.length();

        if (n >= 9)
            return "-1";

        char result[] = new char[n + 1];

        int count = 1;

        for (int i = 0; i <= n; i++)
        {
            if (i == n || seq.charAt(i) == 'N')
            {
                for (int j = i - 1; j >= -1; j--)
                {
                    result[j + 1] = (char) ((int) '0' + count++);
                    if (j >= 0 && seq.charAt(j) == 'N')
                        break;
                }
            }
        }
        return new String(result);
    }

    static String getMinNumberForPatternUsingStack(String seq) {
        String result = "";

        Stack<Integer> stk = new Stack<>();

        for (int i = 0; i <= seq.length(); i++) {
            stk.push(i + 1);

            if (i == seq.length() || seq.charAt(i) == 'M') {
                while (!stk.empty()) {
                    result += String.valueOf(stk.peek());
                    stk.pop();
                }
            }
        }

       return new String(result);
    }
}

