package com.company;

import java.io.File;
import java.util.*;

public class Main{

    public static void main(String[] args) {

        int n = 0;
        while (n!=7) {
            try {
                System.out.println(
                        "\n----------------------------------------------------------------" +
                                "\n1. In ma trận sao vuông" +
                                "\n2. In ma trận sao tam giác" +
                                "\n3. In ma trận số tam giác" +
                                "\n4. In ma trận số xoắn ốc vuông" +
                                "\n5. In ma trận số xoắn ốc tam giác" +
                                "\n6. Game nối chữ" +
                                "\n7. Exit");

                n = Input.input();

                switch (n) {
                    case 1:
                        Test1.test();
                        break;
                    case 2:
                        Test2.test();
                        break;
                    case 3:
                        Test3.test();
                        break;
                    case 4:
                        Test4.test();
                        break;
                    case 5:
                        Test5.test();
                        break;
                    case 6:
                        Test6.test();
                        break;
                    default:
                        break;
                }
            } catch (Exception e) {
                System.out.println();
                e.printStackTrace();
            }
        }
    }
}
//
abstract class Input {
    public static int input() {
        Scanner scanner = new Scanner(System.in);

        boolean checkInput = false;

        int size = 0;

        while (!checkInput) {
            try {
                System.out.print("Enter a number: ");
                size = Integer.parseInt(scanner.nextLine());

                checkInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Input error!");
                checkInput = false;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return size;
    }
}

class Test1 {
    public static void test() {
        System.out.println("\n1. In ma trận sao vuông");
        int l = Input.input();

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
        int h = Input.input();
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
        int height = Input.input();

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

        int size = Input.input();
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
                            turn++;
                            break;
                        case 1:
                            turn++;
                            break;
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

        int size = Input.input();
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

    private static Set<String> englishDictionary;

    public static void test() {

        System.out.println("\nGame nối chữ");

        int size = Input.input();

        englishDictionary = loadDictionary(size);

        List<String> words = inputWords(size);

        StringBuilder strWords = new StringBuilder();

        words.forEach(strWords::append);

        String[] letter = strWords.toString().split("");

        String[][] arr = new String[size][size];

        System.out.println(Arrays.toString(arr[0]));
        System.out.println(Arrays.toString(arr[1]));
        System.out.println(Arrays.toString(arr[2]));
        System.out.println(Arrays.toString(arr).contains("null"));

        int counter = size*size;

        Random random = new Random();

        int row = random.nextInt(size);
        int col = random.nextInt(size);

        arr[row][col] = letter[0];

        while (counter >= 0){

        }

    }

    private static Set<String> loadDictionary(int maxLength) {
        Set<String> words = new HashSet<>();

        try (Scanner scanner = new Scanner(new File("english_words.txt"))) {
            while (scanner.hasNextLine()) {
                String word = scanner.nextLine().toLowerCase();
                if (word.length() >= 3 && word.length() <= maxLength)
                    words.add(word);
            }
        } catch (Exception e) {
            System.out.println("Error loading dictionary: " + e.getMessage());
        }

        return words;
    }

    private static List<String> inputWords(int size) {
        Scanner in = new Scanner(System.in);

        List<String> words = new ArrayList<>();

        int cellsLeft = size*size;

        System.out.println("Enter words list:");

        while (cellsLeft > 0) {
            try {
                String word = in.next();
                word = word.replaceAll(" ","");

                if (isEnglishWord(word) && !words.contains(word) && cellsLeft - word.length() >= 0) {
                    words.add(word);
                    cellsLeft -= word.length();
                } else {
                    throw new Exception("\nInvalid word! Enter another word: ");
                }

            } catch (Exception e) {
                System.out.print(e.getMessage());
            }
        }

        return words;
    }

    private static boolean isEnglishWord(String word) {
        return englishDictionary.contains(word) ||
                englishDictionary.contains(word.toLowerCase()) ||
                englishDictionary.contains(word.toUpperCase());
    }

    private static int checkPos(int curRow, int curCol, int pos, int[][] arr) {
        int position = 0;



        return position;
    }

    private static void position() {

    }
}
