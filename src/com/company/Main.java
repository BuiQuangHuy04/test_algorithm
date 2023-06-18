package com.company;

import java.io.File;
import java.util.*;

public class Main{

    public static void main(String[] args) {
//        int n = 6;
        while (true) {
            try {
                System.out.println("\n----------------------------------------------------------------");

                new Test6().wordFinderGame();

/*                System.out.println(
                        "\n----------------------------------------------------------------" +
                                "\n1. Square star matrix" +
                                "\n2. Triangular star matrix" +
                                "\n3. Matrix of triangular numbers" +
                                "\n4. Square spiral number matrix" +
                                "\n5. Triangular helix number matrix" +
                                "\n6. Words finder game" +
                                "\n7. Exit");

                n = Input.input("Pick a number");

                switch (n) {
                    case 1:
                        new Test1().test();
                        break;
                    case 2:
                        new Test2().test();
                        break;
                    case 3:
                        new Test3().test();
                        break;
                    case 4:
                        new Test4().test();
                        break;
                    case 5:
                        new Test5().test();
                        break;
                    case 6:
                        new Test6().wordFinderGame();
                        break;
                    default:
                        break;
                }*/
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
    public void test() {
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
    public void test() {
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
    public void test() {
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

    public void test() {
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
    public void test() {

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

class Test6 {private final int[] Row = {-1, -1, -1, 0, 1, 1, 1, 0};
    private final int[] Col = {-1, 0, 1, 1, 1, 0, -1, -1};
    private final List<int[]> listCells = new ArrayList<>();
    private final Random random = new Random();
    private int h;
    private int w;
    private String[] characters;
    private String[][] arr = new String[0][0];
    private int[] endWord;
//    private List<List<int[]>> listArr = new ArrayList<>();

    public void wordFinderGame() {

        System.out.println("\nGame nối chữ");

        h = Input.input("Enter height");
        w = Input.input("Enter length");

        List<Word> words = autoCreateEngWords();

        Collections.shuffle(words);

        System.out.println();
        for (Word word : words) {
            for (int i = 0; i < word.getValue().length; i++) {
                System.out.print(word.getValue()[i]);
            }
            System.out.println();
        }

        characters = new String[h * w];

        int iWord = 0;
        int iChar = 0;
        endWord = new int[words.size()];

        for (Word word:words) {
            for (int i = 0; i < word.getValue().length; i++) {
                characters[iChar] = word.getValue()[i];
                ++iChar;
            }
            endWord[iWord] = iChar-1;
            ++iWord;
        }

        arr = new String[h][w];

        int curRow;
        int curCol;

        curRow = random.nextInt(h);
        curCol = random.nextInt(w);

        arr[curRow][curCol] = characters[0];

        if (move(2, curRow, curCol, 0)) {
            System.out.println("\nWords table: ");
            display();
        }
    }

    //ham tao word tu dong
    private List<Word> autoCreateWords() {
        Scanner in = new Scanner(System.in);
        List<Word> words = new ArrayList<>();

        int cellsLeft = h * w;

        int val = 1;
        while (cellsLeft > 0) {
            try {
                System.out.print("Enter word length: ");
                int length = Integer.parseInt(in.nextLine());

                if (length > Math.min(h,w))
                    throw new Exception("This word is longer than table size! Please type a shorter word");

                if (cellsLeft - length < 0)
                    throw new Exception("Word's length is too long! Enter length shorter or equal to " + cellsLeft);

                String[] chars = new String[length];

                for (int j = 0; j < length; j++) {
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

    //load danh sach tu tieng anh
    private List<String> loadDictionary() {
        List<String> words = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File("english_words.txt"))) {
            while (scanner.hasNextLine()) {
                String word = scanner.nextLine().toLowerCase().replace("-","").replace(" ","");
                if (!words.contains(word)) words.add(word);
            }
        } catch (Exception e) {
            System.out.println("Error loading dictionary: " + e.getMessage());
        }
        return words;
    }

    //ham tao word tu dong
    private List<Word> autoCreateEngWords() {
        Scanner in = new Scanner(System.in);
        List<Word> words = new ArrayList<>();
        List<String> engWordsList = loadDictionary();

        int cellsLeft = h * w;
        int maxLength = 10;

        while (cellsLeft > 0) {
            try {
                System.out.print("Enter word length: ");
                int length = Integer.parseInt(in.nextLine());

                if (length < 2)
                    throw new Exception("Please type a longer length");

                if (length > maxLength)
                    throw new Exception("This length is longer than table size! Please type a shorter length");

                if (cellsLeft - length < 0)
                    throw new Exception("This length is too long! Enter length shorter or equal to " + cellsLeft);

                if (cellsLeft - length == 1 || cellsLeft - length == 2)
                    throw new Exception("Can you enter length equal to " + cellsLeft);

                String word = engWordsList.get(random.nextInt(engWordsList.size()));

                Word data = new Word(length, word.split(""));

                while (word.length() != length || words.contains(data)) {
                    word = engWordsList.get(random.nextInt(engWordsList.size()));
                }

                data.setValue(word.split(""));

                words.add(data);

                cellsLeft -= length;
            } catch (Exception e) {
                System.out.println("\n" + e.getMessage());
            }
        }

        return words;
    }

    //ham di chuyen
    private boolean move(int countStep, int curRow, int curCol, int iEndWord) {
        if (countStep > h * w) {
            return true;
        }

        if (countStep - 2 == endWord[iEndWord]) {
            iEndWord++;

            curRow = random.nextInt(h);
            curCol = random.nextInt(w);

            while (!validCell(curRow,curCol)) {
                curRow = random.nextInt(h);
                curCol = random.nextInt(w);
            }
        }

        for (int i = 0; i < 8; i++) {

            int dir = random.nextInt(8);

            int nextRow = curRow + Row[dir];
            int nextCol = curCol + Col[dir];

            if (validCell(nextRow, nextCol) && !hasDumpWay()) {

                arr[nextRow][nextCol] = characters[countStep - 1];

                if (move(countStep + 1, nextRow, nextCol, iEndWord)) {
                    return true;
                } else {
                    arr[nextRow][nextCol] = null;
                }

            }
        }
        return false;
    }

    //check o trong bound & o chua co du lieu
    private boolean validCell(int row, int col) {
        return row >= 0 && row < h && col >= 0 && col < w
                && arr[row][col] == null;
    }


    //ham tra ve danh sach tung mang lien thong
    private List<List<int[]>> checkConnectedArray() {

        List<List<int[]>> listNullCells = new ArrayList<>();

        boolean[] visited = new boolean[h * w];

        for (int row = 0; row < h; row++) {
            for (int col = 0; col < w; col++) {
                if (!visited[row * w + col] && arr[row][col] == null) {

                    List<int[]> copyList = new ArrayList<>();
                    copyList.add(new int[]{row,col});
                    copyList.addAll(checkConnectedCells(row, col, visited));

                    listNullCells.add(copyList);

                    listCells.clear();
                }
            }
        }

        return listNullCells;
    }

    //ham tra ve danh sach vi tri o trong trong 1 mang lien thong
    private List<int[]> checkConnectedCells(int row, int col, boolean[] visited) {

        visited[row * w + col] = true;

        for (int i = 0; i < 8; i++) {
            int newRow = row + Row[i];
            int newCol = col + Col[i];

            if (newRow >= 0 && newRow < h && newCol >= 0 && newCol < w
                    && arr[newRow][newCol] == null && !visited[newRow * w + newCol]) {
                listCells.add(new int[]{newRow,newCol});
                checkConnectedCells(newRow, newCol, visited);
            }
        }

        return listCells;
    }

    private boolean hasDumpWay() {
        return checkConnectedArray().size() > 1;
    }

    private void display() {
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
//                    while (cell.length() < maxLength) {
//                        cell = cell.concat(" ");
//                    }
                    System.out.print(cell + " | ");
                }
            }
            System.out.println();
        }
        System.out.println("------------------------------");
    }
}


class Word {
    int length;
    String[] value;

    public Word(int length, String[] value) {
        this.length = length;
        this.value = value;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String[] getValue() {
        return value;
    }

    public void setValue(String[] value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "length = " + length +
                ", value = " + Arrays.toString(value);
    }
}