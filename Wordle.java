import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Wordle {

    /* List of Functions:
     * 1. eachLetter(String word): separates a word into (int) letters
     * 2. orderedLetters(List<String> possible):
     *      gives five most common letters in List<String>
     * 3. placement(String word, List<String> possible): returns the words
     *      placement in the original list
     * 4. rank(String choice, List<String> possible): takes in array of five strings,
     *      gives rank based on number of most frequently used letters
     * 5. blankGoodLetters(List<String> possible, int blank):
            returns list containing blank or more of the most frequently used letters
     * 6. blankPlusVowels(int blank, List<String> possible):
     *       gives back list with blank or more vowels
     * 7. removeRepeats: narrows down list to words WITHOUT repeats
     * 8. hasLetter: narrows down list to words with letter
     * 9. removeLetter: narrows down to list to words WITHOUT letter
     * 10. noLettersAtIndex(int idx, int lt, List<String> possible): removes
     *      words from list with bad letter at given index
     * 11. hasLetterAtIndex(int idx, int lt, List<String> possible): removes words
     *      from list that DON'T have lt at specified index
     * 12. unique(int[] letters): returns boolean of whether all the letters
     *      in the word are unique
     * 13. narrowByYGB: returns List<String> that is narrowed down by yellow,
     *      green and grey data
     *
     * 14. Main function :)
     * */

    // 1
    public static int[] eachLetter(String word) {

        // Define array of letters (integers)
        int[] letters = new int[5];

        letters[0] = word.charAt(0) - 97;
        letters[1] = word.charAt(1) - 97;
        letters[2] = word.charAt(2) - 97;
        letters[3] = word.charAt(3) - 97;
        letters[4] = word.charAt(4) - 97;

        return letters;
    }

    // 2
    public static int[] orderedLetters(List<String> possible) {
        List<String> result = new ArrayList<>(possible);

        int[] count = new int[26];

        int[] list = new int[13];
        Arrays.fill(list, -1);


        for (String s : result) {

            // Count the most common letters
            int[] letters = eachLetter(s);

            count[letters[0]]++;
            count[letters[1]]++;
            count[letters[2]]++;
            count[letters[3]]++;
            count[letters[4]]++;
        }

        // Rank first half of letters
        int max = 0;
        for (int j = 0; j < count.length; j++) {
            if (count[j] >= max) {
                max = count[j];
                list[0] = j;
            }
        }

        max = 0;
        for (int j = 0; j < count.length; j++) {
            if ((count[j] >= max) && (j != list[0])) {
                max = count[j];
                list[1] = j;
            }
        }

        max = 0;
        for (int j = 0; j < count.length; j++) {
            if ((count[j] >= max) && (j != list[0])) {
                if (j != list[1]) {
                    max = count[j];
                    list[2] = j;
                }
            }
        }

        max = 0;
        for (int j = 0; j < count.length; j++) {
            if ((count[j] >= max) && (j != list[0])) {
                if (j != list[1] && j != list[2]) {
                    max = count[j];
                    list[3] = j;
                }
            }
        }

        max = 0;
        for (int j = 0; j < count.length; j++) {
            if ((count[j] >= max) && (j != list[0])) {
                if (j != list[1] && j != list[2]) {
                    if (j != list[3]) {
                        max = count[j];
                        list[4] = j;
                    }
                }
            }
        }

        max = 0;
        for (int j = 0; j < count.length; j++) {
            if ((count[j] >= max) && (j != list[0])) {
                if (j != list[1] && j != list[2]) {
                    if (j != list[3] && j != list[4]) {
                        max = count[j];
                        list[5] = j;
                    }
                }
            }
        }

        max = 0;
        for (int j = 0; j < count.length; j++) {
            if ((count[j] >= max) && (j != list[0])) {
                if (j != list[1] && j != list[2]) {
                    if (j != list[3] && j != list[4]) {
                        if (j != list[5]) {
                            max = count[j];
                            list[6] = j;
                        }
                    }
                }
            }
        }

        max = 0;
        for (int j = 0; j < count.length; j++) {
            if ((count[j] >= max) && (j != list[0])) {
                if (j != list[1] && j != list[2]) {
                    if (j != list[3] && j != list[4]) {
                        if (j != list[5] && j != list[6]) {
                            max = count[j];
                            list[7] = j;
                        }
                    }
                }
            }
        }

        max = 0;
        for (int j = 0; j < count.length; j++) {
            if ((count[j] >= max) && (j != list[0])) {
                if (j != list[1] && j != list[2]) {
                    if (j != list[3] && j != list[4]) {
                        if (j != list[5] && j != list[6]) {
                            if (j != list[7] && j != list[8]) {
                                max = count[j];
                                list[9] = j;
                            }
                        }
                    }
                }
            }
        }

        max = 0;
        for (int j = 0; j < count.length; j++) {
            if ((count[j] >= max) && (j != list[0])) {
                if (j != list[1] && j != list[2]) {
                    if (j != list[3] && j != list[4]) {
                        if (j != list[5] && j != list[6]) {
                            if (j != list[7] && j != list[8]) {
                                if (j != list[9]) {
                                    max = count[j];
                                    list[10] = j;
                                }
                            }
                        }
                    }
                }
            }
        }

        max = 0;
        for (int j = 0; j < count.length; j++) {
            if ((count[j] >= max) && (j != list[0])) {
                if (j != list[1] && j != list[2]) {
                    if (j != list[3] && j != list[4]) {
                        if (j != list[5] && j != list[6]) {
                            if (j != list[7] && j != list[8]) {
                                if (j != list[9] && j != list[10]) {
                                    max = count[j];
                                    list[11] = j;
                                }
                            }
                        }
                    }
                }
            }
        }

        max = 0;
        for (int j = 0; j < count.length; j++) {
            if ((count[j] >= max) && (j != list[0])) {
                if (j != list[1] && j != list[2]) {
                    if (j != list[3] && j != list[4]) {
                        if (j != list[5] && j != list[6]) {
                            if (j != list[7] && j != list[8]) {
                                if (j != list[9] && j != list[10]) {
                                    if (j != list[11]) {
                                        max = count[j];
                                        list[12] = j;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        return list;
    }


    // 3
    public static int placement(String word, List<String> possible) {

        int plac = -1;
        for (int i = 0; i < possible.size(); i++) {
            if (Objects.equals(word, possible.get(i))) {
                plac = i;
            }
        }

        return plac;
    }


    // 4
    public static int rank(String choice, List<String> possible) {

        int[] halfLetters = orderedLetters(possible);
        int[] bestLetters = {halfLetters[0], halfLetters[1], halfLetters[2],
                halfLetters[3], halfLetters[4]};

        int[] fineLetters = {halfLetters[5], halfLetters[6], halfLetters[7],
                halfLetters[8], halfLetters[9]};

        int[] okLetters = {halfLetters[10], halfLetters[11], halfLetters[12]};


        int[] letters = eachLetter(choice);

        int rank = 0;

        for (int k = 0; k < 5; k++) {
            // count best letters
            if (letters[k] == bestLetters[0]) {
                rank += 5;
            } else if (letters[k] == bestLetters[1]) {
                rank += 5;
            } else if (letters[k] == bestLetters[2]) {
                rank += 5;
            } else if (letters[k] == bestLetters[3]) {
                rank += 5;
            } else if (letters[k] == bestLetters[4]) {
                rank += 5;
            }

            if (letters[k] == fineLetters[0]) {
                rank += 2;
            } else if (letters[k] == fineLetters[1]) {
                rank += 2;
            } else if (letters[k] == fineLetters[2]) {
                rank += 2;
            } else if (letters[k] == fineLetters[3]) {
                rank += 2;
            } else if (letters[k] == fineLetters[4]) {
                rank += 2;
            }

            if (letters[k] == okLetters[0]) {
                rank += 1;
            } else if (letters[k] == okLetters[1]) {
                rank += 1;
            } else if (letters[k] == okLetters[2]) {
                rank += 1;
            }


        }

        // if placement is in second half of list, subtract 1 from rank
        if (placement(choice, possible) > possible.size() / 2) {
            rank -= 2;
        }

        // if placement is in third quarter, subtract 2 points from rank
        if ((placement(choice, possible) > (possible.size() * 3) / 4)) {
            rank -= 5;
        }

        return rank;
    }

    // 5
    public static List<String> blankGoodLetters(List<String> possible,
                                                int blank) {

        List<String> result = new ArrayList<>(possible);
        int[] goodLetters = new int[5];
        for (int i = 0; i < 5; i++) {
            goodLetters[i] = orderedLetters(result)[i];
        }
        // for each word in list:
        for (int m = 0; m < result.size(); m++) {
            int goodCount = 0;
            int[] letters = eachLetter(result.get(m));

            // First letter
            if (letters[0] == goodLetters[0] || letters[0] == goodLetters[1]) {
                goodCount++;
            } else if (letters[0] == goodLetters[2] || letters[0] == goodLetters[3]) {
                goodCount++;
            } else if (letters[0] == goodLetters[4]) {
                goodCount++;
            }

            // Second letter
            if (letters[1] == goodLetters[0] || letters[1] == goodLetters[1]) {
                goodCount++;
            } else if (letters[1] == goodLetters[2] || letters[1] == goodLetters[3]) {
                goodCount++;
            } else if (letters[1] == goodLetters[4]) {
                goodCount++;
            }

            // Third letter
            if (letters[2] == goodLetters[0] || letters[2] == goodLetters[1]) {
                goodCount++;
            } else if (letters[2] == goodLetters[2] || letters[2] == goodLetters[3]) {
                goodCount++;
            } else if (letters[2] == goodLetters[4]) {
                goodCount++;
            }

            // Fourth letter
            if (letters[3] == goodLetters[0] || letters[3] == goodLetters[1]) {
                goodCount++;
            } else if (letters[3] == goodLetters[2] || letters[3] == goodLetters[3]) {
                goodCount++;
            } else if (letters[3] == goodLetters[4]) {
                goodCount++;
            }

            // Fifth letter
            if (letters[4] == goodLetters[0] || letters[4] == goodLetters[1]) {
                goodCount++;
            } else if (letters[4] == goodLetters[2] || letters[4] == goodLetters[3]) {
                goodCount++;
            } else if (letters[4] == goodLetters[4]) {
                goodCount++;
            }

            if (goodCount < blank) {
                result.remove(m);
                m--;
            }
        }

        return result;
    }


    // 6
    public static List<String> blankPlusVowels(int blank, List<String> possible) {
        List<String> result = new ArrayList<>(possible);

        // for each word in list:
        for (int m = 0; m < result.size(); m++) {
            int vowelCount = 0;
            int[] letters = eachLetter(result.get(m));

            // First letter
            if (letters[0] == 0 || letters[0] == 4) {
                vowelCount++;
            } else if (letters[0] == 8 || letters[0] == 20) {
                vowelCount++;
            } else if (letters[0] == 24) {
                vowelCount++;
            }

            // Second letter
            if (letters[1] == 0 || letters[1] == 4) {
                vowelCount++;
            } else if (letters[1] == 8 || letters[1] == 20) {
                vowelCount++;
            } else if (letters[1] == 24) {
                vowelCount++;
            }

            // Third letter
            if (letters[2] == 0 || letters[2] == 4) {
                vowelCount++;
            } else if (letters[2] == 8 || letters[2] == 20) {
                vowelCount++;
            } else if (letters[2] == 24) {
                vowelCount++;
            }

            // Fourth letter
            if (letters[3] == 0 || letters[3] == 4) {
                vowelCount++;
            } else if (letters[3] == 8 || letters[3] == 20) {
                vowelCount++;
            } else if (letters[3] == 24) {
                vowelCount++;
            }

            // Fifth letter
            if (letters[4] == 0 || letters[4] == 4) {
                vowelCount++;
            } else if (letters[4] == 8 || letters[4] == 20) {
                vowelCount++;
            } else if (letters[4] == 24) {
                vowelCount++;
            }

            if (vowelCount < blank) {
                result.remove(m);
                m--;
            }
        }

        return result;
    }

    // 7
    public static List<String> removeRepeats(List<String> possible) {
        List<String> result = new ArrayList<>(possible);

        for (int m = 0; m < result.size(); m++) {
            int[] letters = eachLetter(result.get(m));
            boolean keep = isUnique(letters);

            if (!keep) {
                result.remove(m);
                m--;
            }
        }

        return result;
    }


    // 8
    public static List<String> hasLetter(int lt, List<String> possible) {
        List<String> result = new ArrayList<>(possible);

        for (int m = 0; m < result.size(); m++) {

            int[] letters = eachLetter(result.get(m));
            boolean keep = false;

            if (letters[0] == lt || letters[1] == lt) {
                keep = true;
            } else if (letters[2] == lt || letters[3] == lt) {
                keep = true;
            } else if (letters[4] == lt) {
                keep = true;
            }

            if (!keep) {
                result.remove(m);
                m--;
            }
        }
        return result;
    }

    // 9
    public static List<String> removeLetter(int lt, List<String> possible) {
        List<String> result = new ArrayList<>(possible);

        for (int m = 0; m < result.size(); m++) {

            int[] letters = eachLetter(result.get(m));
            boolean keep = true;

            if (letters[0] == lt || letters[1] == lt) {
                keep = false;
            } else if (letters[2] == lt || letters[3] == lt) {
                keep = false;
            } else if (letters[4] == lt) {
                keep = false;
            }

            if (!keep) {
                result.remove(m);
                m--;
            }
        }
        return result;
    }

    // 10
    public static List<String> noLettersAtIndex(int idx, int lt,
                                                List<String> possible) {

        List<String> result = new ArrayList<>(possible);

        for (int m = 0; m < result.size(); m++) {

            int[] letters = eachLetter(result.get(m));

            if (letters[idx] == lt) {
                result.remove(m);
                m--;
            }
        }

        return result;
    }

    // 11
    public static List<String> hasLetterAtIndex(int idx, int lt,
                                                List<String> possible) {

        List<String> result = new ArrayList<>(possible);

        for (int m = 0; m < result.size(); m++) {

            int[] letters = eachLetter(result.get(m));

            if (letters[idx] != lt) {
                result.remove(m);
                m--;
            }
        }

        return result;
    }

    // 12
    public static boolean isUnique(int[] letters) {
        boolean unique = true;

        if (letters[0] == letters[1]) {
            unique = false;
        } else if (letters[0] == letters[2]) {
            unique = false;
        } else if (letters[0] == letters[3]) {
            unique = false;
        } else if (letters[0] == letters[4]) {
            unique = false;
        }

        if (letters[1] == letters[2]) {
            unique = false;
        } else if (letters[1] == letters[3]) {
            unique = false;
        } else if (letters[1] == letters[4]) {
            unique = false;
        }

        if (letters[2] == letters[3]) {
            unique = false;
        } else if (letters[2] == letters[4]) {
            unique = false;
        }

        if (letters[3] == letters[4]) {
            unique = false;
        }

        return unique;
    }


    // 13
    public static List<String> narrowByYGB(List<String> possible, int[] guess) {
        List<String> result = new ArrayList<>(possible);

        StdOut.println();
        StdOut.println("How many letters were yellow? Include repeats.");
        int yellowCount = StdIn.readInt();

        int[] buffy = new int[5];
        int[] yellow = new int[5];
        // Default array to -1 values
        for (int i = 0; i < 5; i++) {
            buffy[i] = -1;
        }
        for (int i = 0; i < 5; i++) {
            yellow[i] = -1;
        }

        if (yellowCount != 0) {
            StdOut.println();
            StdOut.println("Which letters were yellow? Include repeat letters.");
            StdOut.println("List letters lowercase with no spaces.");

            StringBuilder buffer = new StringBuilder(StdIn.readString());
            while (buffer.length() < 5) {
                buffer.append(' ');
            }

            for (int i = 0; i < 5; i++) {
                if (buffer.charAt(i) != ' ') {
                    buffy[i] = (int) buffer.charAt(i) - 97;
                    StdOut.println("What is the index of yellow letter: "
                            + (char) (buffy[i] + 97) + "?");
                    int id = StdIn.readInt();
                    yellow[id] = buffy[i];
                }
            }
        }

        // Remove words that don't have the yellow letters, or have it at that index
        for (int i = 0; i < 5; i++) {
            if (yellow[i] != -1) {
                result = hasLetter(yellow[i], result);
                result = noLettersAtIndex(i, yellow[i], result);
            }
        }

        // Get green letters
        StdOut.println();
        StdOut.println("How many letters were green? Include repeats.");
        int greenCount = StdIn.readInt();

        int[] buffy2 = new int[5];
        int[] green = new int[5];
        // Default values to -1:
        for (int i = 0; i < 5; i++) {
            buffy2[i] = -1;
        }
        for (int i = 0; i < 5; i++) {
            green[i] = -1;
        }

        if (greenCount != 0) {
            StdOut.println();
            StdOut.println("Which letters were green? Include repeats.");
            StdOut.println("List letters lowercase with no spaces.");

            StringBuilder buff = new StringBuilder(StdIn.readString());
            while (buff.length() < 5) {
                buff.append(' ');
            }

            for (int i = 0; i < 5; i++) {
                if (buff.charAt(i) != ' ') {
                    buffy2[i] = (int) buff.charAt(i) - 97;
                    StdOut.println("What is the index of green letter: "
                            + (char) (buffy2[i] + 97) + "?");
                    int id2 = StdIn.readInt();
                    green[id2] = buffy2[i];
                }
            }

            // Reduce list to letters with green at specified index
            for (int i = 0; i < 5; i++) {
                if (green[i] != -1) {
                    result = hasLetterAtIndex(i, green[i], result);
                }
            }
        }


        // Determine grey letters:
        int[] grey = new int[5];

        for (int i = 0; i < 5; i++) {
            if (green[i] != -1 || yellow[i] != -1) {
                grey[i] = -1;
            } else {
                grey[i] = guess[i];
            }
        }

        // Remove words with grey letters at their index
        for (int i = 0; i < 5; i++) {
            result = noLettersAtIndex(i, grey[i], result);
        }


        boolean allDifferent = isUnique(guess);

        if (allDifferent) {

            // Remove all words with grey letters
            for (int i = 0; i < 5; i++) {
                result = removeLetter(grey[i], result);
            }
        }

        if (!allDifferent) {

            // Remove words with grey letters at their index
            for (int i = 0; i < 5; i++) {
                result = noLettersAtIndex(i, grey[i], result);
            }

            boolean greyAndGreen = false;
            for (int i = 0; i < 5; i++) {
                if (grey[i] != green[0] && grey[i] != yellow[0]) {
                    result = noLettersAtIndex(0, grey[i], result);
                } else {
                    greyAndGreen = true;
                }

                if (grey[i] == green[1] && grey[i] != yellow[1]) {
                    result = noLettersAtIndex(1, grey[i], result);
                } else {
                    greyAndGreen = true;
                }

                if (grey[i] == green[2] && grey[i] != yellow[2]) {
                    result = noLettersAtIndex(2, grey[i], result);
                } else {
                    greyAndGreen = true;
                }

                if (grey[i] == green[3] && grey[i] != yellow[3]) {
                    result = noLettersAtIndex(3, grey[i], result);
                } else {
                    greyAndGreen = true;
                }

                if (grey[i] == green[4] && grey[i] != yellow[4]) {
                    result = noLettersAtIndex(4, grey[i], result);
                } else {
                    greyAndGreen = true;
                }

                if (!greyAndGreen) {
                    result = removeLetter(grey[i], result);
                }
            }
        }

        if (result.size() < 1) {
            return possible;
        } else {
            return result;
        }
    }


    @SuppressFBWarnings("DM_DEFAULT_ENCODING")
    public static void main(String[] args) throws IOException {

        // Create file object to read
        File words = new File("words.txt");
        Scanner sc = new Scanner(words);


        // Create a list to take in all the words
        List<String> possibleWords = new ArrayList<>();

        // fill list with Wordle choice data
        while (sc.hasNextLine()) {
            possibleWords.add(sc.nextLine());
        }

        // Create arrays for best choices
        List<String> firstChoices = new ArrayList<>(possibleWords);
        List<String> nextChoices = new ArrayList<>(possibleWords);


        firstChoices = blankGoodLetters(firstChoices, 4);
        firstChoices = hasLetter(18, firstChoices);
        firstChoices = blankPlusVowels(3, firstChoices);
        firstChoices = removeRepeats(firstChoices);

        // Print first five choices (normal towards front
        StdOut.println("Your first five choices are:");
        String[] firstList = new String[5];
        for (int i = 0; i < 5; i++) {
            firstList[i] = firstChoices.get(i);

            StdOut.println(firstList[i] + " " + rank(firstList[i], possibleWords));
        }
        StdOut.println("(Higher number = better guess)");

        // Get word that was guessed
        StdOut.println();
        StdOut.println("Which word did you guess?");
        String guess1 = StdIn.readString();
        int[] firstGuess = eachLetter(guess1);

        // Call narrowYGK
        nextChoices = narrowByYGB(nextChoices, firstGuess);

        // Print first five results in nextChoices:
        StdOut.println();
        StdOut.println("Your next five choices are:");
        for (int i = 0; i < 5; i++) {
            StdOut.println(nextChoices.get(i) + " " +
                    rank(nextChoices.get(i), possibleWords));
        }
        StdOut.println("(Higher number = better guess)");

        // Get word guessed
        StdOut.println();
        StdOut.println("Which word did you choose?");
        String guess2 = StdIn.readString();
        int[] secondGuess = eachLetter(guess2);

        // Narrow down by YGB:
        nextChoices = narrowByYGB(nextChoices, secondGuess);

        // Print third choices:
        StdOut.println();
        StdOut.println("Your next choices are:");
        if (nextChoices.size() >= 5) {
            for (int i = 0; i < 5; i++) {
                StdOut.println(nextChoices.get(i) + " " +
                        rank(nextChoices.get(i), possibleWords));
            }
        } else {
            for (String nextChoice : nextChoices) {
                StdOut.println(nextChoice + " " +
                        rank(nextChoice, possibleWords));
            }
        }

        // Get word that was guessed
        StdOut.println();
        StdOut.println("Which word did you guess?");
        String guess3 = StdIn.readString();
        int[] thirdGuess = eachLetter(guess3);

        // Narrow down by YGB:
        nextChoices = narrowByYGB(nextChoices, thirdGuess);

        // Print fourth choices:
        StdOut.println();
        StdOut.println("Your next choices are:");
        if (nextChoices.size() >= 5) {
            for (int i = 0; i < 5; i++) {
                StdOut.println(nextChoices.get(i) + " " +
                        rank(nextChoices.get(i), possibleWords));
            }
        } else {
            for (String nextChoice : nextChoices) {
                StdOut.println(nextChoice + " " +
                        rank(nextChoice, possibleWords));
            }
        }

        // Get word that was guessed
        StdOut.println();
        StdOut.println("Which word did you guess?");
        String guess4 = StdIn.readString();
        int[] fourthGuess = eachLetter(guess4);

        // Narrow down by YGB:
        nextChoices = narrowByYGB(nextChoices, fourthGuess);

        // Print fifth choices:
        StdOut.println();
        StdOut.println("Your next choices are:");
        if (nextChoices.size() >= 5) {
            for (int i = 0; i < 5; i++) {
                StdOut.println(nextChoices.get(i) + " " +
                        rank(nextChoices.get(i), possibleWords));
            }
        } else {
            for (String nextChoice : nextChoices) {
                StdOut.println(nextChoice + " " +
                        rank(nextChoice, possibleWords));
            }
        }

        // Get word that was guessed
        StdOut.println();
        StdOut.println("Which word did you guess?");
        String guess5 = StdIn.readString();
        int[] fifthGuess = eachLetter(guess5);

        // Narrow down by YGB:
        nextChoices = narrowByYGB(nextChoices, fifthGuess);

        // Print last choices:
        StdOut.println();
        StdOut.println("Your last choices are:");
        if (nextChoices.size() >= 5) {
            for (int i = 0; i < 5; i++) {
                StdOut.println(nextChoices.get(i) + " " +
                        rank(nextChoices.get(i), possibleWords));
            }
        } else {
            for (String nextChoice : nextChoices) {
                StdOut.println(nextChoice + " " +
                        rank(nextChoice, possibleWords));
            }
        }


    }
}
