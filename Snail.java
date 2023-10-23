import java.util.Arrays;

/**
 * In this class the kata from https://www.codewars.com/kata/521c2db8ddc89b9b7a0000c1/train/java got solved.
 */
public class Snail {

    /**
     * example:
     * int[][] array
     *                 = {{1, 2, 3},
     *                   {4, 5, 6},
     *                   {7, 8, 9}};
     *         int[] r = {1, 2, 3, 6, 9, 8, 7, 4, 5};
     * @param array [outerIndex][innerIndex]
     * @return the values of the input array from outer values to inner values like a snake
     */
    public static int[] snail(int[][] array) {
        if (array==null){
            throw new NullPointerException("Please pass an array of int instead of null");
        }
        if (array[0].length == 0){
            return new int[0];
        }
        if(array.length == 1){
            return new int[]{array[0][0]};
        }
        if(array.length == 2){
            return new int[]{array[0][0], array[0][1], array[1][1], array[1][0]};
        }

        // initializing needed local variables
        int numberOfElements = array.length * array[0].length;
        int[] result = new int[numberOfElements];
        int outerArrayIndex = 0;
        int innerArrayIndex = 0;
        int resultIndex = 0;
        int reductionCounter = 0;
        int rightAndLeft = array.length;
        int downAndUp = array.length;

        while(!(resultIndex == result.length)){
            // action to do one step to the right:  innerArrayIndex++
            // do the steps to the right
            for (int k = 0; k < rightAndLeft - reductionCounter; k++) {
                result[resultIndex] = array[outerArrayIndex][innerArrayIndex];
                resultIndex++;
                innerArrayIndex++;
            }
            innerArrayIndex--;
            outerArrayIndex++;
            reductionCounter++;

            if (resultIndex!=0) {
                // action to do one step to the down:   outerArrayIndex++
                // do the steps down
                for (int k = 0; k < downAndUp - reductionCounter; k++) {
                    result[resultIndex] = array[outerArrayIndex][innerArrayIndex];
                    resultIndex++;
                    outerArrayIndex++;
                }
                outerArrayIndex--;
                innerArrayIndex--;
            }

            if (resultIndex!=0) {
                // action to do one step to the left:   innerArrayIndex--
                // do the steps to the left
                for (int k = 0; k < downAndUp - reductionCounter; k++) {
                    result[resultIndex] = array[outerArrayIndex][innerArrayIndex];
                    resultIndex++;
                    innerArrayIndex--;
                }
                innerArrayIndex++;
                outerArrayIndex--;
                reductionCounter++;
            }

            if (resultIndex!=0) {
                // action to do one step to the up:     outerArrayIndex--
                // do the steps up
                for (int k = 0; k < downAndUp - reductionCounter; k++) {
                    result[resultIndex] = array[outerArrayIndex][innerArrayIndex];
                    resultIndex++;
                    outerArrayIndex--;
                }
                outerArrayIndex++;
                innerArrayIndex++;
            }
        }
        return result;
    }

    /**
     * example:
     * int[][] array
     *                 = {{1, 2, 3},
     *                   {4, 5, 6},
     *                   {7, 8, 9}};
     *         int[] r = {1, 2, 3, 6, 9, 8, 7, 4, 5};
     * @param array [outerIndex][innerIndex]
     * @return the values of the input array from outer values to inner values like a snake
     */
    public static int[] snailLong(int[][] array) {
        if (array[0].length == 0){
            return new int[0];
        }
        if(array.length == 1){
            return new int[]{array[0][0]};
        }
        if(array.length == 2){
            return new int[]{array[0][0], array[0][1], array[1][1], array[1][0]};
        }

        // initializing needed local variables
        int numberOfElements = array.length * array[0].length;
        int[] result = new int[numberOfElements];
        int outerIndex = 0;
        int innerIndex = 0;
        int resultIndex = 0;
        int rounds = 1;

        // initial round
        // to the right
        for (int k = 0; k < array.length; k++) {
            result[resultIndex] = array[outerIndex][innerIndex];
            resultIndex++;
            innerIndex++;
        }
        innerIndex--;
        outerIndex++;

        // down
        for (int k = 0; k < array.length-1; k++) {
            result[resultIndex] = array[outerIndex][innerIndex];
            resultIndex++;
            outerIndex++;
        }
        innerIndex--;
        outerIndex--;

        // left
        for (int k = 0; k < array.length-1; k++) {
            result[resultIndex] = array[outerIndex][innerIndex];
            resultIndex++;
            innerIndex--;
        }
        innerIndex++;
        outerIndex--;



        int rightAndLeft = array.length-1;
        int downAndUp = array.length-1;

        // algorithmic part
        // end condition can only be true after a step to the right or left
        while(!(resultIndex == result.length)){
            // action to do one step to the up:     outerIndex--
            // do the steps up
            for (int k = 0; k < downAndUp - rounds; k++) {
                result[resultIndex] = array[outerIndex][innerIndex];
                resultIndex++;
                outerIndex--;
            }
            outerIndex++;
            innerIndex++;

            // action to do one step to the right:  innerIndex++
            // do the steps to the right
            for (int k = 0; k < rightAndLeft - rounds; k++) {
                result[resultIndex] = array[outerIndex][innerIndex];
                resultIndex++;
                innerIndex++;
            }
            innerIndex--;
            outerIndex++;

            // check for condition
            if(!(resultIndex == result.length)){
            rounds++;
            // action to do one step to the down:   outerIndex++
            // do the steps down
            for (int k = 0; k < downAndUp - rounds; k++) {
                result[resultIndex] = array[outerIndex][innerIndex];
                resultIndex++;
                outerIndex++;
            }
            outerIndex--;
            innerIndex--;

            // action to do one step to the left:   innerIndex--
            // do the steps to the left
             for (int k = 0; k < downAndUp - rounds; k++) {
                result[resultIndex] = array[outerIndex][innerIndex];
                resultIndex++;
                innerIndex--;
             }
             innerIndex++;
             outerIndex--;

            }
            rounds++;
        }
        return result;
    }
}