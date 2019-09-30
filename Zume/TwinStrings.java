import java.util.HashSet;
import java.util.Set;
class GFG {
    static int MAX_CHAR = 26;

    static String encodeString(char[] str) {
        // hashEven stores the count of even indexed character 
        // for each string hashOdd stores the count of odd 
        // indexed characters for each string 
        int hashEven[] = new int[MAX_CHAR];
        int hashOdd[] = new int[MAX_CHAR];

        // creating hash for each string 
        for (int i = 0; i < str.length; i++) {
            char c = str[i];
            if ((i & 1) != 0) // If index of current character is odd 
                hashOdd[c-'a']++;
            else
                hashEven[c-'a']++;

        }

        // For every character from 'a' to 'z', we store its 
        // count at even position followed by a separator, 
        // followed by count at odd position. 
        String encoding = "";
        for (int i = 0; i < MAX_CHAR; i++) {
            encoding += (hashEven[i]);
            encoding += ('-');
            encoding += (hashOdd[i]);
            encoding += ('-');
        }
        return encoding;
    }

    // This function basically uses a hashing based set to 
    // store strings which are distinct according to accoding
    // to criteria given in question.
    static int countDistinct(String input[], int n) {
        int countDist = 0; // Initialize result 

        // Create an empty set and store all distinct 
        // strings in it. 
        Set<String> s = new HashSet<>();
        for (int i = 0; i < n; i++) {
            // If this encoding appears first time, increment 
            // count of distinct encodings. 
            if (!s.contains(encodeString(input[i].toCharArray()))) {
                s.add(encodeString(input[i].toCharArray()));
                countDist++;
            }
        }

        return countDist;
    }

    public static void main(String[] args) {
        String input[] = {"abcd", "acbd", "adcb", "cdba",
                "bcda", "badc"};
        int n = input.length;

        System.out.println(countDistinct(input, n));
    }
} 