import java.util.*;

public class Puzzle {
    int row = 0;
    int col = 0;
    int[] firstLoc = new int[2];
    int[] lastLoc = new int[2];
    char[] curWord;
    public String puzzle;
    public String[] words;
    public int size;

    Puzzle() {
        puzzle = "";
        words = new String[12];
        size = 0;
    }


    public void Read(Scanner s) {
        String line;
        int i = 0;

        line = s.nextLine();
        size = line.length();
        puzzle += line;

        while (s.hasNextLine()) {

            line = s.nextLine();

            if (line.equals("")) {
                while (s.hasNextLine()) {
                    line = s.nextLine();
                    words[i] = line;
                    i++;
                }
                break;
            }
            puzzle += line;
        }
    }

    public void Find() {


        for (String s : words) {

            curWord = s.toCharArray();

            for (int i = 0; i < puzzle.length(); i++) {

                if (col == size) {
                    col = 0;
                    row++;
                }

                if (curWord[0] == puzzle.charAt(i)) {
                    firstLoc[0] = row;
                    firstLoc[1] = col;

                    if (searchW() || searchE() || searchN() || searchS() || searchSW() || searchNE() || searchSE() || searchNW()) {
                        System.out.println(new String(curWord) + " found at start: " + firstLoc[0] + ", " + firstLoc[1] + " end: " + lastLoc[0] + ", " + lastLoc[1]);
                        reset();
                        break;
                    } else {
                        col++;
                        continue;
                    }
                }

                if (i == puzzle.length() - 1) {
                    System.out.println(new String(curWord) + " not found");
                    reset();
                    break;
                }
                col++;
            }
            reset();
        }


    }

    public boolean searchW() {
        if (col == size - 1)
            return false;
        int index;
        if (row == 0)
            index = col;
        else
            index = (row * size) + col;

        for (int i = 1; i < curWord.length; i++) {
            if (curWord[i] != puzzle.charAt(index + i))
                return false;
            if (curWord.length == i + 1) {
                lastLoc[0] = row;
                lastLoc[1] = col + i;
                return true;
            }
            if (index - ((row * size) - 1) == size)
                return false;
        }

        return false;
    }

    private boolean searchE() {
        if (col == 0)
            return false;
        int index;
        if (row == 0)
            index = col;
        else
            index = (row * size) + col;

        for (int i = 1; i < curWord.length; i++) {
            if (curWord[i] != puzzle.charAt(index - i))
                return false;
            if (curWord.length == i + 1) {
                lastLoc[0] = row;
                lastLoc[1] = col - i;
                return true;
            }
        }
        return false;
    }

    private boolean searchN() {
        if (row == 0)
            return false;

        int index = (row * size) + col;

        for (int i = 1; i < curWord.length; i++) {
            index -= size;
            if (curWord[i] != puzzle.charAt(index))
                return false;
            if (curWord.length == i + 1) {
                lastLoc[0] = row - i;
                lastLoc[1] = col;
                return true;
            }
            if (index < size)
                return false;
        }
        return false;
    }

    private boolean searchS() {
        if (row == size - 1)
            return false;

        int index;
        if (row == 0)
            index = col;
        else
            index = (row * size) + col;

        for (int i = 1; i < curWord.length; i++) {
            index += size;
            if (curWord[i] != puzzle.charAt(index))
                return false;
            if (curWord.length == i + 1) {
                lastLoc[0] = row + i;
                lastLoc[1] = col;
                return true;
            }
            if (index > puzzle.length() - size)
                return false;
        }
        return false;
    }

    private boolean searchSE() {
        if (row == size - 1 || col == size - 1)
            return false;

        int index;
        if (row == 0)
            index = col;
        else
            index = (row * size) + col;

        for (int i = 1; i < curWord.length; i++) {
            index += 11;
            if (curWord[i] != puzzle.charAt(index))
                return false;
            if (curWord.length == i + 1) {
                lastLoc[0] = row + i;
                lastLoc[1] = col + i;
                return true;
            }
            if (index > puzzle.length() - size || index - ((row * size) - 1) == size)
                return false;
        }
        return false;
    }

    private boolean searchNW() {
        if (col == 0 || row == 0)
            return false;

        int index = (row * size) + col;

        for (int i = 1; i < curWord.length; i++) {
            index -= 11;
            if (curWord[i] != puzzle.charAt(index))
                return false;
            if (curWord.length == i + 1) {
                lastLoc[0] = row - i;
                lastLoc[1] = col - i;
                return true;
            }
            if (index < size) {
                return false;
            }
        }
        return false;
    }

    private void reset() {
        row = 0;
        col = 0;
    }


    private boolean searchSW() {
        if (col == 0 || row == size - 1)
            return false;

        int index;

        if (row == 0)
            index = col;
        else
            index = (row * size) + col;

        for (int i = 1; i < curWord.length; i++) {
            index += 9;
            if (curWord[i] != puzzle.charAt(index))
                return false;
            if (curWord.length == i + 1) {
                lastLoc[0] = row + i;
                lastLoc[1] = col - i;
                return true;
            }
            if (index < size) {
                return false;
            }
        }
        return false;
    }

    private boolean searchNE() {
        if (col == size - 1 || row == 0)
            return false;

        int index = (row * size) + col;

        for (int i = 1; i < curWord.length; i++) {
            index -= 9;
            if (curWord[i] != puzzle.charAt(index))
                return false;
            if (curWord.length == i + 1) {
                lastLoc[0] = row - i;
                lastLoc[1] = col + i;
                return true;
            }
            if (index < size) {
                return false;
            }
        }
        return false;
    }

}