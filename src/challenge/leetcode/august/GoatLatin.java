package challenge.leetcode.august;

/*
A sentence S is given, composed of words separated by spaces. Each word consists of lowercase and uppercase letters only.

We would like to convert the sentence to "Goat Latin" (a made-up language similar to Pig Latin.)

The rules of Goat Latin are as follows:

If a word begins with a vowel (a, e, i, o, or u), append "ma" to the end of the word.
For example, the word 'apple' becomes 'applema'.

If a word begins with a consonant (i.e. not a vowel), remove the first letter and append it to the end, then add "ma".
For example, the word "goat" becomes "oatgma".

Add one letter 'a' to the end of each word per its word index in the sentence, starting with 1.
For example, the first word gets "a" added to the end, the second word gets "aa" added to the end and so on.
Return the final sentence representing the conversion from S to Goat Latin.



Example 1:

Input: "I speak Goat Latin"
Output: "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
Example 2:

Input: "The quick brown fox jumped over the lazy dog"
Output: "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"


Notes:

S contains only uppercase, lowercase and spaces. Exactly one space between each word.
1 <= S.length <= 150.
 */

public class GoatLatin {

    public static String toGoatLatin(String S) {
        StringBuilder newString= new StringBuilder();
        final char a='a',e='e',i='i',o='o',u='u';
        final char A='A',E='E',I='I',O='O',U='U';
        String ma="ma";
        int wordCount=1;
        StringBuilder end = new StringBuilder("");

        StringBuilder tempWord=new StringBuilder();
        for(int j=0;j<S.length();j++){
            if (j==0 || S.charAt(j-1)==' ') {

                if(S.charAt(j)==a||S.charAt(j)==A||
                        S.charAt(j)==e||S.charAt(j)==E||
                        S.charAt(j)==i||S.charAt(j)==I||
                        S.charAt(j)==o||S.charAt(j)==O||
                        S.charAt(j)==u||S.charAt(j)==U){
                    end.append(ma);
                    tempWord.append(S.charAt(j));
                }
                else{
                    end.append(S.charAt(j));
                    end.append(ma);

                }

                if (j == S.length() - 1) {

                    int As = wordCount;
                    while (As > 0) {
                        end.append('a');
                        As--;
                    }
                    wordCount++;

                    tempWord.append(end);

                    newString.append(tempWord.toString());
                    tempWord = new StringBuilder();
                    end = new StringBuilder();
                }

            }
            else if (j == S.length() - 1) {

                int As = wordCount;
                while (As > 0) {
                    end.append('a');
                    As--;
                }
                wordCount++;
                tempWord.append(S.charAt(j));
                tempWord.append(end);

                newString.append(tempWord.toString());
                tempWord = new StringBuilder();
                end = new StringBuilder();
            }

            else  if (S.charAt(j) == ' ') {
                int As = wordCount;
                while (As > 0) {
                    end.append('a');
                    As--;
                }
                wordCount++;

                tempWord.append(end);
                tempWord.append(S.charAt(j));
                newString.append(tempWord);
                tempWord = new StringBuilder();
                end = new StringBuilder();
            }


            else {
                tempWord.append(S.charAt(j));
            }
        }

        return newString.toString();
    }

    public static void main(String[] args) {
        String S = "The quick brown fox jumped over the lazy dog";
        System.out.println("String in goatlatin is: "+toGoatLatin(S));
    }
}
