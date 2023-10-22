import java.util.ArrayList;
import java.util.Arrays;

/**
 * In this class the kata from https://www.codewars.com/kata/56cac350145912e68b0006f0 got solved.
 */
public class Updown {

    public static String arrange(String strng) {
        // 1. split the strings
        ArrayList<String> strings = new java.util.ArrayList<>(Arrays.stream(strng.split(" ")).toList());

        // 2. swap the strings according to the property:
        // P = length t(O) <= length t(1) >= length t(2) <= length t(3) >= length t(4) .... (P)
        for (int i = 0; i < strings.size()-1; i++) {
            if (!stringMatchesTheProperty(i, strings)) {
                String tempString = strings.get(i);
                strings.set(i, strings.get(i+1));
                strings.set(i+1, tempString);
            }
        }

        // 3. change the smaller substrings to lower and the other ones to upper case
        for (int i = 0; i < strings.size(); i++) {
            if (i%2==0) {
                strings.set(i, strings.get(i).toLowerCase());
            }
            else{
                strings.set(i, strings.get(i).toUpperCase());
            }
        }

        // 4. return the strings as one string
        return strings.subList(1, strings.size()).stream().reduce(strings.get(0), (s, s2) -> s + " " + s2);
    }

    private static boolean stringMatchesTheProperty(int index, ArrayList<String> strings){
        // P = length t(O) <= length t(1) >= length t(2) <= length t(3) >= length t(4) .... (P)
        // check if string s needs to be and is already smaller than the following string
        if(index%2==0 && strings.get(index).length() <= strings.get(index+1).length()){
            return true;
        }
        // check if string s needs to be and is already greater than the following string
        if(index%2==1 && strings.get(index).length() >= strings.get(index+1).length()){
            return true;
        }
        return false;
    }
}
