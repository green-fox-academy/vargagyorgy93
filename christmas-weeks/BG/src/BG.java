import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BG {
    public static void main(String[] args) {
//        List<Integer> numbers = new ArrayList<>();
//        numbers.add(1);
//        numbers.add(22);
//        numbers.add(93);
//        numbers.add(886);
        BG bg = new BG();
//        System.out.println(bg.getRightmostDigit(numbers));
//        System.out.println(Arrays.deepToString(bg.spiral(5)));
//        int[] numbers = {1, 2, 3, 8, 9, 3, 2, 1};
//        int[] numbers = {1, 2, 1, 4};
//        int[] numbers = new int[5];
//        numbers[0] = 1;
//        numbers[1] = 3;
//        numbers[2] = 5;
//        numbers[3] = 3;
//        numbers[4] = 1;
//        System.out.println(bg.isBalanced(numbers));
//        System.out.println(bg.getMirrorLength(numbers));
//        System.out.println(bg.sum("7 11"));
//        System.out.println(bg.getNUmberOfTripples("d"));
//        System.out.println(bg.removeElements("Hello there", "llo"));
//        bg.stringZIP("aaaabbbbcccccddddeeeef");
//        int[][] map = {
//                {1,1,0,0,0,0,0,1,1,1},
//                {1,0,0,0,0,0,0,1,1,1},
//                {0,0,0,0,0,0,0,1,1,1},
//                {0,0,1,0,0,0,1,0,0,0},
//                {0,0,0,0,0,1,1,1,0,0},
//                {0,0,0,0,1,1,1,1,1,0},
//                {0,0,0,1,1,1,1,1,1,1},
//                {1,0,0,0,1,1,1,1,1,0},
//                {1,1,0,0,0,1,1,1,0,0},
//                {1,1,1,0,0,0,1,0,0,0}
//        };
//        System.out.println(bg.islandCounter(map));


    }
//1.
//Given a list of non-negative integers, return an integer list of the rightmost digits.
//
//rightDigit([1, 22, 93]) → [1, 2, 3]
//rightDigit([16, 8, 886, 8, 1]) → [6, 8, 6, 8, 1]
//rightDigit([10, 0]) → [0, 0]


    public List<Integer> getRightmostDigit(List<Integer> numbers) {
        List<Integer> righmostNumbers = new ArrayList<>();
        for (Integer number : numbers) {
            righmostNumbers.add(number % 10);
        }
        return righmostNumbers;
    }

//2.
//Given a non-empty array, return true if there is a place to split the array so that the sum of the numbers on one side is equal to the sum of the numbers on the other side.
//canBalance([1, 1, 1, 2, 1]) → true
//canBalance([2, 1, 1, 2, 1]) → false
//canBalance([10, 10]) → true


    public boolean isBalanced(int[] numbers) {
        int counter = 0;
        int counter2 = 0;
        boolean result = false;
        for (int i = 0; i < numbers.length; i++) {
            counter += numbers[i];
            for (int j = i + 1; j < numbers.length; j++) {
                counter2 += numbers[j];
            }
            if (counter == counter2) {
                result = true;
            }
            counter2 = 0;
        }
        return result;
    }

// 3.
//We'll say that a "mirror" section in an array is a group of contiguous elements such that somewhere in the array, the same group appears in reverse order. For example, the largest mirror section in {1, 2, 3, 8, 9, 3, 2, 1} is length 3 (the {1, 2, 3} part). Return the size of the largest mirror section found in the given array.
//maxMirror([1, 2, 3, 8, 9, 3, 2, 1]) → 3
//maxMirror([1, 2, 1, 4]) → 3
//maxMirror([7, 1, 2, 9, 7, 2, 1]) → 2

    public int getMirrorLength(int[] givenNumbers) {
        int[] mirror = new int[givenNumbers.length];
        int counter = 0;
        int largest = 0;
        int k = 0;
        for (int i = 0; i < givenNumbers.length; i++) {
            mirror[i] = givenNumbers[givenNumbers.length - i - 1];
        }
        for (int i = 0; i < givenNumbers.length; i++) {
            for (int j = 0; j < mirror.length; j++) {
                if (givenNumbers[i] == mirror[j]) {
                    while (j + k < givenNumbers.length && i + k < mirror.length) {
                        if (givenNumbers[i + k] == mirror[j + k]) {
                            counter += 1;
                            if (counter > largest) {
                                largest = counter;
                            }
                        } else {
                            counter = 0;
                        }
                        k++;
                    }
                }
            }
        }
        return largest;
    }


//4.
//Given a string, return the sum of the numbers appearing in the string, ignoring all other characters. A number is a series of 1 or more digit chars in a row. (Note: Character.isDigit(char) tests if a char is one of the chars '0', '1', .. '9'. Integer.parseInt(string) converts a string to an int.)
//sumNumbers("abc123xyz") → 123
//sumNumbers("aa11b33") → 44
//sumNumbers("7 11") → 18


    public int sumNumber(String myString) {
        myString = myString.replaceAll("\\s", "a");
        int result = 0;
        String numbersAsString = "";
        for (int i = 0; i < myString.length(); i++) {
            if (myString.charAt(i) <= '9') {
                if (Character.isDigit(myString.charAt(i))) {
                    numbersAsString += myString.charAt(i);
                }
            } else {
                numbersAsString += ",";
            }
            if (myString.charAt(i) == ' ') {
                myString.replace(myString.charAt(i), ',');
            }
        }
        List<String> splitted = Arrays.asList(numbersAsString.split(","));
        for (int i = 0; i < splitted.size(); i++) {
            if (!splitted.get(i).equals("")) {
                result += Integer.parseInt(splitted.get(i));
            }
        }
        return result;
    }

//5.
//We'll say that a "triple" in a string is a char appearing three times in a row. Return the number of triples in the given string. The triples may overlap.
//countTriple("abcXXXabc") → 1
//countTriple("xxxabyyyycd") → 3
//countTriple("a") → 0


    public int getNUmberOfTripples(String myString) {
        int result = 0;
        char first = ' ';
        char secound = ' ';
        char third = ' ';
        for (int i = 0; i < myString.length(); i++) {
            if (i >= 2) {
                first = myString.charAt(i - 2);
                secound = myString.charAt(i - 1);
                third = myString.charAt(i);
            }
            if (first != ' ' && first == secound && first == third) {
                result += 1;
            }
        }
        return result;
    }

//6.
//Given two strings, base and remove, return a version of the base string where all instances of the remove string have been removed (not case sensitive). You may assume that the remove string is length 1 or more. Remove only non-overlapping instances, so with "xxx" removing "xx" leaves "x".
//withoutString("Hello there", "llo") → "He there"
//withoutString("Hello there", "e") → "Hllo thr"
//withoutString("Hello there", "x") → "Hello there"


    public String removeElements(String myString, String remove) {
        String result = "";
        List<Character> myCharacter = new ArrayList<>();
        List<Character> removableCharacters = new ArrayList<>();
        int counter = 0;
        List<Integer> indexOfCharToRemove = new ArrayList<>();
        List<Character> copyOfMyCharacter = new ArrayList<>();

        for (int i = 0; i < myString.length(); i++) {
            myCharacter.add(myString.charAt(i));
        }
        for (int i = 0; i < remove.length(); i++) {
            removableCharacters.add(remove.charAt(i));
        }
        for (int i = 0; i < myCharacter.size(); i++) {
            if ((i - 1) >= removableCharacters.size()) {
                for (int j = 0; j < removableCharacters.size(); j++) {
                    if (myCharacter.get(i - (removableCharacters.size() - (j + 1))).equals(removableCharacters.get(j))) {
                        counter += 1;
                    }
                }
                if (counter == removableCharacters.size()) {
                    for (int j = 0; j < counter; j++) {
                        indexOfCharToRemove.add(i);

                    }
                }
            }
        }
        copyOfMyCharacter = myCharacter;
        for (int i = 0; i < indexOfCharToRemove.size(); i++) {
            for (int j = 0; j < copyOfMyCharacter.size(); j++) {
                if (indexOfCharToRemove.get(i) != j) {
                    result += copyOfMyCharacter.get(i);
                }
            }

        }

//        result = myCharacter.toString();
        return result;
    }

//8.Write a Java program to create a spiral array of n * n sizes from a given integer n.
//Expected Output:
//Input a number:  5
//Spiral array becomes:
//1 2 3 4 5
//16 17 18 19 6
//15 24 25 20 7
//14 23 22 21 8
//13 12 11 10 9


    public int[][] spiral(int givenNumber) {
        int[][] result = new int[givenNumber][givenNumber];
        for (int i = 0; i < givenNumber; i++) {
            if (i == 0) {
                for (int j = 0; j < givenNumber; j++) {
                    result[i][j] = j + 1;
                }
            }
            if (i == 1) {
                for (int j = 1; j <  (2 * (givenNumber - i)) + 1; j++) {
                    if (j <= givenNumber - i) {
                        result[j][givenNumber - i] = givenNumber + j;
                    } else {
                        result[givenNumber - i][(givenNumber + 3) - j] = givenNumber + j;
                    }
                }
            }
            if (i == 2){
                for (int j = 1; j < (2 * (givenNumber - i)) + 1; j++) {
                    if (j <= givenNumber - i) {
                        result[(givenNumber - 1) - j][0] = ((2 * givenNumber) + (i + 1)) + j;
                    } else {
                        result[i - 1][j - (i + 1)] = ((2 * givenNumber) + (i + 1)) + j;
                    }
                }
            }
            if (i == 3){
                for (int j = 1; j < (2 * (givenNumber - i)) + 1; j++) {
                    if (j <= givenNumber - i){
                        result[j + 1][i] = ((4 * givenNumber) - 1) + j;
                    } else {
                        result[i][givenNumber - j] = ((4 * givenNumber) - 1) + j;
                    }
                }
            }
            if(i == 4){
                for (int j = 1; j < (2 * (givenNumber - i)) + 1; j++) {
                    result[i - 2][j] = (i * givenNumber) + ((i -1) + j);
                }
            }
        }
        return result;
    }

// 9.Enter a string (you can include space as well)
// aaaabbbbcccccddddeeeef
//The compressed string along with the counts of repeated characters is:
//a4b4c5d4e4

    public void stringZIP(String myString) {
        String result = "";
        int counter = 0;
        for (int i = 1; i < myString.length(); i++) {
            if (i == 1) {
                result += myString.charAt(0);
            }
            if (myString.charAt(i) == myString.charAt(i - 1)) {
                counter += 1;
            } else {
                result += (counter + 1);
                counter = 0;
                result += myString.charAt(i);
            }
            if (i == myString.length() - 1 && counter != 0) {
                result += counter + 1;
            }
        }
        System.out.println(result);
    }

//10.
//There are 10 vertical and horizontal squares on a plane. Each square is painted blue and green. Blue represents the sea, and green represents the land. When two green squares are in contact with the top and bottom, or right and left, they are said to be ground. The area created by only one green square is called "island". For example, there are five islands in the figure below.
//Write a Java program to read the mass data and find the number of islands. Go to the editor
//
//Input:
//A single data set is represented by 10 rows of 10 numbers representing green squares as 1 and blue squares as zeros.
//Output: For each data set, output the number of islands.
//
//Sample Output:
//
//Input 10 rows of 10 numbers representing green squares (island) as 1 and
//blue squares (sea) as zeros
//1100000111
//1000000111
//0000000111
//0010001000
//0000011100
//0000111110
//0001111111
//1000111110
//1100011100
//1110001000
//Number of islands:
//5


    public int islandCounter(int[][] map) {
        int result = 0;

        for (int i = 0; i < map.length; i++) {

            for (int j = 0; j < map.length; j++) {
                if (j == 0) {
                    if (map[i][j] - map[i][j + 1] == 1) {
                        result += 1;
                    }
                }
                if (j >= 1 && j < 9) {
                    if (map[i][j] - map[i][j - 1] - map[i][j + 1] == 1) {
                        result += 1;
                    }
                }
                if (j == map.length - 1) {
                    if (map[i][j] - map[i][j - 1] == 1) {
                        result += 1;
                    }
                }
            }
        }
        return result;
    }

}
