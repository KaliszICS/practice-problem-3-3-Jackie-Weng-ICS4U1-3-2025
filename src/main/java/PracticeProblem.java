import java.util.ArrayList;
import java.util.Arrays; 
//cant sync work

public class PracticeProblem {
    private static String sortedInputString;
    private static ArrayList<String> generatedPermutations;

    public static void permutate(String currentPermutation, int visitedMask, boolean isUnique) {
        if (currentPermutation.length() == sortedInputString.length()) {
            generatedPermutations.add(currentPermutation);
            return;
        }
        
        boolean[] usedCharacters = new boolean[256];
        for (int i = 0; i < sortedInputString.length(); ++i) {
            int currentChar = sortedInputString.charAt(i);
            if ((visitedMask & (1 << i)) == 0) {
                if ((isUnique && !usedCharacters[currentChar]) || !isUnique) {
                    permutate(currentPermutation + sortedInputString.charAt(i), visitedMask | (1 << i), isUnique);
                } else {
                    continue;
                }
                if (isUnique) {
                    usedCharacters[currentChar] = true;
                }
            }
        }
    }

    public static ArrayList<String> perms(String inputString) {
        char[] charArray = inputString.toCharArray();
        Arrays.sort(charArray);
        sortedInputString = new String(charArray);
        generatedPermutations = new ArrayList<String>();
        permutate("", 0, false);
        return generatedPermutations;
    }

    public static ArrayList<String> permsUnique(String inputString) {
        char[] charArray = inputString.toCharArray();
        Arrays.sort(charArray);
        sortedInputString = new String(charArray);
        generatedPermutations = new ArrayList<String>();
        permutate("", 0, true);
        return generatedPermutations;
    }
}
