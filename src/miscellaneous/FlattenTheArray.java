package miscellaneous;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/*
Given an array consisting many inner arrays, flatten the array into one: example:
input: [[6,4,7,[9,5,4,[2,4,8]]],[2,2,7],[9,0,7,[9,3,1,8,5]]]
 output: [6,4,7,9,5,4,2,4,8,2,2,7,9,0,7,9,3,1,8,5]
 */
public class FlattenTheArray {


    //Approach1 using flatMap java8
    final static Stream<Object> flattenApproach1(Object[] array) {
        return Arrays.stream(array)
                .flatMap(o -> o instanceof Object[]? flattenApproach1((Object[])o): Stream.of(o));
    }

    //Approach2
    /**
     * Flatten an array of arbitrarily nested arrays of integers into a flat array of integers. e.g. [[1,2,[3]],4] -> [1,2,3,4].
     *
     * @param inputArray an array of Integers or nested arrays of Integers
     * @return flattened array of Integers or null if input is null
     * @throws IllegalArgumentException
     */
    public static Integer[] flattenApproach2(Object[] inputArray) throws IllegalArgumentException {

        if (inputArray == null) return null;

        List<Integer> flatList = new ArrayList<>();

        for (Object element : inputArray) {
            if (element instanceof Integer) {
                flatList.add((Integer) element);
            } else if (element instanceof Object[]) {
                flatList.addAll(Arrays.asList(flattenApproach2((Object[]) element)));
            } else {
                throw new IllegalArgumentException("Input must be an array of Integers or nested arrays of Integers");
            }
        }
        return flatList.toArray(new Integer[flatList.size()]);
    }

    public static void main(String[] args) {
        Object[] array = {new Object[]{6,4,7,new Object[]{9,5,4,new Object[]{2,4,8}}},new Object[]{2,2,7},new Object[]{9,0,7,new Object[]{9,3,1,8,5}}};
        System.out.println("original: "+ Arrays.deepToString(array));

        //Approach1
        Object[] flatUsingFLatMap = flattenApproach1(array).toArray();
        System.out.println("flat: "+Arrays.toString(flatUsingFLatMap));

        //Approach2
        Integer[] flatUsingArrayList = flattenApproach2(array);
        System.out.println("flatUsingArrayList: "+Arrays.toString(flatUsingArrayList));
    }
}
