package com.company;

import java.io.File;
import java.sql.Time;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

import static com.company.test.autoCreateWords;

public class Main{

    public static void main(String[] args) {
        int n = 6;
        while (n!=7) {
            try {
                System.out.println("\n----------------------------------------------------------------");
                Test6.wordFinderGame();

//                System.out.println(
//                        "\n----------------------------------------------------------------" +
//                                "\n1. Square star matrix" +
//                                "\n2. Triangular star matrix" +
//                                "\n3. Matrix of triangular numbers" +
//                                "\n4. Square spiral number matrix" +
//                                "\n5. Triangular helix number matrix" +
//                                "\n6. Words finder game" +
//                                "\n7. Exit");
//
//                n = Input.input("Pick a number");
//
//                switch (n) {
//                    case 1:
//                        Test1.test();
//                        break;
//                    case 2:
//                        Test2.test();
//                        break;
//                    case 3:
//                        Test3.test();
//                        break;
//                    case 4:
//                        Test4.test();
//                        break;
//                    case 5:
//                        Test5.test();
//                        break;
//                    case 6:
//                        Test6.test();
//                        break;
//                    default:
//                        break;
//                }
            } catch (Exception e) {
                System.out.println();
                e.printStackTrace();
            }
        }
    }
}

abstract class Input {
    public static int input(String msg) {
        Scanner scanner = new Scanner(System.in);

        boolean checkInput = false;

        int size = 0;

        while (!checkInput) {
            try {
                System.out.print(msg + ": ");
                size = Integer.parseInt(scanner.nextLine());

                checkInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Input error!");
                checkInput = false;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return size;
    }
}

class Test1 {
    public static void test() {
        System.out.println("\n1. In ma trận sao vuông");
        int l = Input.input("Enter length");

        int row = 0;
        for (int i = 0; i < l; i++) {
            if (row == l)
                break;
            else if (i == l-1) {
                System.out.println("X ");
                i = -1;
                row++;
            } else
                System.out.print("X ");
        }
    }
}

class Test2 {
    public static void test() {
        System.out.println("\nIn ma trận sao tam giác");
        int h = Input.input("Enter height");
        int r = 1;
        int w = h*2-1;

        for (int i = 1; i <= w; i++) {

            if (r==h) {
                System.out.print("X");
                continue;
            }

            if (i > h-r && i < h+r) {
                System.out.print("X");
            } else {
                System.out.print(" ");
            }

            if (i >= h+r) {
                System.out.println();
                r++;
                i=0;
            }
        }
    }
}

class Test3 {
    public static void test() {
        System.out.println("\nIn ma trận số tam giác");
        int height = Input.input("Enter height");

        int r = 1;
        int c1 = height-2;
        int c2 = height+1;

        boolean iVal= true;

        int[][] arr = new int[height][height * 2 - 1];

        arr[0][height-1] = 1;

        for (int c = c1; c < c2; c++) {

            if (iVal) {

                if (r == height - 1 && c == 0) {
                    arr[r][c] = 1;
                    continue;
                }

                if (arr[r][c-1] == 0) {
                    arr[r][c] = arr[r][c - 1] + 1;
                }

                if (arr[r][c-1] >= 1 && c <= height - 1) {
                    arr[r][c] = arr[r][c - 1] + 1;
                }

                if (c > height - 1) {
                    arr[r][c] = arr[r][c - 1] - 1;
                }

                if (c+1 == c2) {
                    c1--;
                    c2++;
                    c = c1-1;
                    r++;
                    if (arr[height-1][(height-1)*2] != 0) {
                        iVal = false;
                        c = -1;
                        c2 = height;
                    }
                }
            } else {
                System.out.println(Arrays.toString(arr[c]));
            }
        }
    }
}

class Test4 {

    public static void test() {
        System.out.println("\nIn ma trận số xoắn ốc vuông");

        boolean iVal = true;

        int size = Input.input("Enter length");
        int
                r = 0,
                c = 0,
                bound = size-1,
                turn = 0;

        int val = 1;
        int count = 1;

        int[][] arr = new int[size][size];

        for (int i = 0; i < bound; i++) {

            if (iVal) {

                if (val > 9) val = 1;

                switch (turn) {
                    case 0:
                        arr[r][c] = val;
                        c++;
                        val++;
                        count++;
                        break;
                    case 1:
                        arr[r][c] = val;
                        r++;
                        val++;
                        count++;
                        break;
                    case 2:
                        arr[r][c] = val;
                        c--;
                        val++;
                        count++;
                        break;
                    case 3:
                        arr[r][c] = val;
                        r--;
                        val++;
                        count++;
                        break;
                    default:
                        break;
                }

                if (i == bound - 1) {
                    switch (turn) {
                        case 0:
                        case 1:
                        case 2:
                            turn++;
                            break;
                        case 3:
                            turn = 0;
                            bound -= 2;
                            if (size % 2 == 1 && bound == 0) {
                                bound++;
                            }
                            c++;
                            r++;
                            break;
                    }
                    i = -1;
                }

                if (count > size*size) {
                    iVal = false;
                    i = -1;
                    bound = size;
                }

            } else {
                System.out.println(Arrays.toString(arr[i]));
            }
        }
    }
}

class Test5 {
    public static void test() {

        System.out.println("\nIn ma trận số xoắn ốc tam giác");
        boolean iVal = true;

        int size = Input.input("Enter height");
        int
                bound = size - 2,
                turn = 0,
                r1 = 0,
                r2 = size - 1,
                c1 = 0,
                c2 = size * 2 - 1,
                r = 0,
                c = size - 1;

        int val = 1;
        int count = 1;

        int[][] arr = new int[size][size * 2 - 1];

        for (int i = 0; i <= bound; i++) {

            if (iVal) {

                if (val > 9) val = 1;

                arr[r][c] = val;

                if (turn == 0 && r < r2 && c < c2 && c >= size - 1) {
                    r++;
                    c++;
                } else if (turn == 1 && c > c1) {
                    c--;
                } else if (turn == 2 && r > r1 - 1 && c < size - 1) {
                    r--;
                    c++;
                }

                if (i == bound) {
                    turn++;
                    i = -1;

                    if (turn == 1) {
                        bound = bound * 2 + 1;
                        if (bound == 0) {
                            arr[r][c] = val+1;
                        }
                    } else if (turn == 2) {
                        bound = (bound - 1) / 2;
                        if (bound == 0) {
                            arr[r][c] = val+1;
                        }
                    } else if (turn == 3) {
                        turn = 0;
                        bound -= 2;
                        r1++;
                        r2--;
                        c1++;
                        c2--;
                        r = r1;
                        c = size - 1;
                    }
                }

                val++;
                count++;

                if (count >= size * (size * 2 - 1) - size * (size - 1)) {
                    iVal = false;
                    i = -1;
                    bound = size-1;
                    if (arr[r][c] == 0) arr[r][c] = val;
                }
            } else {
                System.out.println(Arrays.toString(arr[i]).replaceAll(String.valueOf(0)," "));
            }
        }
    }
}

class Test6 {
    private final static int[] Row = {-1, -1, -1, 0, 1, 1, 1, 0};
    private final static int[] Col = {-1, 0, 1, 1, 1, 0, -1, -1};
    private static final Random random = new Random();
    private static int h;
    private static int w;
    private static Set<String> englishDictionary;
    private static String[][] arr = new String[0][0];
    private static String[] characters;
    private static final List<int[]> stupidDir = new ArrayList<>();

    public static void wordFinderGame() {

        System.out.println("\nGame nối chữ");

        h = Input.input("Enter height");
        w = Input.input("Enter length");

        List<Word> words = autoCreateWords();

        Collections.shuffle(words);

        words.forEach(System.out::println);

        characters = new String[h * w];
        int n = 0;
        for (Word word:words) {
            for (int i = 0; i < word.getValue().length; i++) {
                characters[n] = word.getValue()[i];
                ++n;
            }
        }

        arr = new String[h][w];

        int curRow = random.nextInt(h);
        int curCol = random.nextInt(w);

        arr[curRow][curCol] = characters[0];

        if (move(2, curRow, curCol)) {
            System.out.println("\nWords table: ");
            display();
        } else System.out.println("err");
    }

    public static List<Word> autoCreateWords() {
        Scanner in = new Scanner(System.in);
        List<Word> words = new ArrayList<>();

        int cellsLeft = h * w;

        int val = 1;
        while (cellsLeft > 0) {
            try {
                System.out.print("\nEnter word length: ");
                int length = Integer.parseInt(in.nextLine());

                if (cellsLeft - length < 0) {
                    throw new Exception("Word's length is too long! Enter length shorter or equal to " + cellsLeft);
                }

                String[] chars = new String[length];

                for (int j = 0; j < length; j++) {
//                    if (val>9) val = 0;
                    chars[j] = String.valueOf(val);
                    val++;
                }

                cellsLeft -= length;
                words.add(new Word(length, chars));
            } catch (Exception e) {
                System.out.println("\n" + e.getMessage());
            }
        }

        return words;
    }

    private static Set<String> loadDictionary() {
        Set<String> words = new HashSet<>();

        try (Scanner scanner = new Scanner(new File("english_words.txt"))) {
            while (scanner.hasNextLine()) {
                String word = scanner.nextLine().toLowerCase();
                words.add(word);
            }
        } catch (Exception e) {
            System.out.println("Error loading dictionary: " + e.getMessage());
        }

        return words;
    }

    private static List<String> inputWords(int l, int w) {
        Scanner in = new Scanner(System.in);

        List<String> words = new ArrayList<>();

        int cellsLeft = l * w;

        System.out.println("\nEnter words list:");

        while (cellsLeft > 0) {
            System.out.print("Enter a word:");
            try {
                String word = in.next();

//                if (!isEnglishWord(word)) throw new Exception("Invalid word! Please type a meaningful word:");
                if (words.contains(word)) throw new Exception("This word has been added! Please type another word:");
                if (cellsLeft - word.length() < 0) throw new Exception("The word is too long! Please type word has length shorter or equal to " + cellsLeft + ":");
                if (cellsLeft - word.length() == 1) throw new Exception("Please type another word has more than it 1 unit:");

//                if (isEnglishWord(word) && !words.contains(word) && cellsLeft - word.length() >= 0) {
                if (!words.contains(word) && cellsLeft - word.length() >= 0) {
                    words.add(word);
                    cellsLeft -= word.length();
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        return words;
    }

    private static boolean isEnglishWord(String word) {
        return englishDictionary.contains(word) ||
                englishDictionary.contains(word.toLowerCase()) ||
                englishDictionary.contains(word.toUpperCase());
    }

    private static boolean move(int countStep, int curRow, int curCol) {
        if (countStep > h * w) {
            return true;
        }
        for (int i = 0; i < 8; i++) {
            i = random.nextInt(8);
            int nextRow = curRow + Row[i];
            int nextCol = curCol + Col[i];

            if (nextRow >= 0 && nextRow < h && nextCol >= 0 && nextCol < w
                    && arr[nextRow][nextCol] == null
                    && countConnectedArrays(arr) == 1
                    && hasDumpWay(arr).size() == 0) {

                arr[nextRow][nextCol] = characters[countStep-1];

                if (move(countStep + 1, nextRow, nextCol)) {
                    return true;
                } else {
                    arr[nextRow][nextCol] = null;
                }
            }
        }
        return false;
    }

    private static List<Boolean> hasDumpWay(String[][] array) {
        List<List<Integer>> nullDirsList = new ArrayList<>();
        List<Boolean> hasDumpWay = new ArrayList<>();

        for (int row = 1; row < h; row++) {
            for (int col = 1; col < w; col++) {
                if (array[row][col] == null) {

                    List<Integer> nullDis = new ArrayList<>();

                    for (int dir = 0; dir < 8; dir++) {
                        int nextRow = row + Row[dir];
                        int nextCol = col + Col[dir];
                        if (nextRow >= 0 && nextRow < h && nextCol >= 0 && nextCol < w
                                && array[nextRow][nextCol] == null) {
                            nullDis.add(dir);
                        }
                    }
                    nullDirsList.add(nullDis);
                }
            }
        }

        for (int i = 0; i < nullDirsList.size(); i++) {
            hasDumpWay.add(true);
        }

        for (int i = 0; i < nullDirsList.size(); i++) {
            if (nullDirsList.get(i).size() >= 3) {
                for (int j = 1; j < nullDirsList.get(i).size(); j++) {
                    if (nullDirsList.get(i).get(j) - nullDirsList.get(i).get(j - 1) != 2 &&
                            nullDirsList.get(i).get(j) - nullDirsList.get(i).get(j - 1) != 3) {
                        hasDumpWay.remove(0);
                        System.out.println("size dump way: " + hasDumpWay.size());
                        break;
                    }
                }
            } else hasDumpWay.remove(0);
        }

        return hasDumpWay;
    }

    private static int countConnectedArrays(String[][] array) {
        int count = 0;
        Set<Integer> visited = new HashSet<>();
        for (int row = 0; row < h; row++) {
            for (int col = 0; col < w; col++) {
                if (array[row][col] == null && !visited.contains(row * w + col)) {
                    count++;
                    checkConnectedCells(array, row, col, visited);
                }
            }
        }
        return count;
    }

    private static void checkConnectedCells(String[][] array, int row, int col, Set<Integer> visited) {
        visited.add(row * w + col);
        for (int dRow = -1; dRow <= 1; dRow++) {
            for (int dCol = -1; dCol <= 1; dCol++) {
                if (dRow != 0 || dCol != 0) {
                    int nextRow = row + dRow;
                    int nextCol = col + dCol;
                    if (nextRow >= 0 && nextRow < h && nextCol >= 0 && nextCol < w
                            && array[nextRow][nextCol] == null
                            && !visited.contains(nextRow * w + nextCol)) {
                        checkConnectedCells(array, nextRow, nextCol, visited);
                    }
                }
            }
        }
    }

    private static void display() {
        System.out.println("------------------------------");
        int maxLength = String.valueOf(h*w).length();
        for (String[] row : arr) {
            System.out.print("| ");
            for (String cell : row) {
                if (cell == null) {
                    String nullCell = "";
                    while (nullCell.length() < maxLength) {
                        nullCell = nullCell.concat(" ");
                    }
                    System.out.print(nullCell + " | ");
                } else {
                    while (cell.length() < maxLength) {
                        cell = cell.concat(" ");
                    }
                    System.out.print(cell + " | ");
                }
            }
            System.out.println();
        }
        System.out.println("------------------------------");
    }
}