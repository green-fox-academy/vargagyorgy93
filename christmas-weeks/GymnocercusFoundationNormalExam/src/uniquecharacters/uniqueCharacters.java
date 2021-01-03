package uniquecharacters;

import java.util.*;

public class uniqueCharacters {
    public static void main(String[] args) {
        System.out.println(getuniqueCharacters("Anagram"));
    }

    public static List<Character> getuniqueCharacters(String givenString) {
        List<Character> result = new ArrayList<>();
        HashMap<Character, Integer> charactersAndOccurances = new HashMap<>();
        for (int i = 0; i < givenString.length(); i++) {
            if (!charactersAndOccurances.containsKey(givenString.charAt(i))) {
                charactersAndOccurances.put(givenString.charAt(i), 1);
            } else {
                charactersAndOccurances.put(givenString.charAt(i), charactersAndOccurances.get(givenString.charAt(i)) + 1);
            }
        }
        for (Map.Entry<Character, Integer> entry : charactersAndOccurances.entrySet()) {
            if (entry.getValue() < 2){
                result.add(entry.getKey());
            }
        }
        Collections.sort(result);
        return result;
    }
}
