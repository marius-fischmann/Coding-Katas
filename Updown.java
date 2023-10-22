import java.util.Arrays;

/**
 * In this class the kata from https://www.codewars.com/kata/56cac350145912e68b0006f0 got solved.
 */
public class Updown {

    public static String arrange(String strng) {
        // 1. split the strings
        String[] strings = strng.split(" ");

        // 2. swap the strings according to the property:
        // P = length t(O) <= length t(1) >= length t(2) <= length t(3) >= length t(4) .... (P)
        for (int i = 0; i < strings.length-1; i++) {
            if (!stringMatchesTheProperty(i, strings)) {
                swapString(i, strings);
            }
        }

        // 3. change the smaller substrings to lower and the other ones to upper case
        for (int i = 0; i < strings.length; i++) {
            if (i%2==0) {
                strings[i] = strings[i].toLowerCase();
            }
            else{
                strings[i] = strings[i].toUpperCase();
            }
        }

        // 4. return the strings as one string
        return Arrays.stream(strings).filter(e1 -> !e1.equals(strings[0])).reduce(strings[0], (s, s2) -> s + " " + s2);
    }

    private static boolean stringMatchesTheProperty(int index, String[] strings){
        // check if string s needs to be and is already smaller than the following string
        if(index%2==0 && strings[index].length() <= strings[index+1].length()){
            return true;
        }
        // check if string s needs to be and is already greater than the following string
        if(index%2==1 && strings[index].length() >= strings[index+1].length()){
            return true;
        }
        return false;
    }

    /**
     * swaps the string in the given index of the String[] with the one of at index+1
     * @param index
     * @param strings
     * @return the given String[] with swaps strings at index and index+1
     */
    private static String[] swapString(int index, String[] strings){
        String tempString = strings[index];
        strings[index] = strings[index+1];
        strings[index+1] = tempString;
        return strings;
    }
}
