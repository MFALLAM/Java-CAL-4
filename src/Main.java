import java.util.Random;
import java.util.Scanner;

public class Main {


    private static final int SIZE = 3;

    private static final char[][] TicTacToe = new char[SIZE][SIZE];
    private static final Scanner sc = new Scanner(System.in);

    private static final Random rand = new Random();

    private static final char DOT_X = 'X';
    private static final char DOT_O = 'O';
    private static final char DOT_EMPTY = '.';


    public static void main(String[] args) {
        titTicTacToe();
        printTicTacToe();


        while (true) {
            turn("human", DOT_X);

            printTicTacToe();

            if (checkWin(DOT_X)) {
                System.out.println("Player wins");
                break;
            }

            if (isMapFull()) {
                System.out.println("Draw");
                break;
            }

            turn("computer", DOT_O);
            //aiTurn();
            printTicTacToe();

            if (checkWin(DOT_O)) {
                System.out.println("Computer wins");
                break;
            }

            if (isMapFull()) {
                System.out.println("Draw");
                break;
            }
        }

    }


    private static void titTicTacToe() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                TicTacToe[i][j] = DOT_EMPTY;
            }
        }
    }


    public static void printTicTacToe() {
        for (int header = 0; header <= SIZE; header++) {
            System.out.print(header + "\t");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + "\t");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(TicTacToe[i][j] + "\t");
            }
            System.out.println();
        }
    }


    public static void turn(String type_player, char dote_player) {

        int x, y;
        do {
            if (type_player.equals("human")) {
                System.out.println("Enter coordinates in the format: X space Y");
                x = sc.nextInt() - 1;
                y = sc.nextInt() - 1;
            } else {
                x = rand.nextInt(SIZE);
                y = rand.nextInt(SIZE);
            }
        }
        while (!isCellEmpty(x, y));
        TicTacToe[y][x] = dote_player;
        System.out.println("Turn " + type_player + " (x = " + (x + 1) + ", y = " + (y + 1) + ")");
    }


    public static void humanTurn() {

        int x, y;
        do {
            System.out.println("Enter coordinates in the format: X space Y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        }
        while (!isCellEmpty(x, y));
        TicTacToe[y][x] = DOT_X;
    }


    public static void aiTurn() {
        int x, y;
        do {
            x = rand.nextInt(SIZE);
            y = rand.nextInt(SIZE);
        }
        while (!isCellEmpty(x, y));
        System.out.println("Computer entered coordinates : " + (x + 1) + " и " + (y + 1));
        TicTacToe[y][x] = DOT_O;
    }

    public static boolean isCellEmpty(int x, int y) {
        if (x < 0 || x > (SIZE - 1) || y < 0 || y > (SIZE - 1) || TicTacToe[y][x] != DOT_EMPTY) return false;
        return true;
    }

    public static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (TicTacToe[j][i] == DOT_EMPTY) return false;
            }
        }
        return true;
    }

    public static boolean checkWin(char ox) {

        int check = 0;
        int check_isDiagonal = 0;

        for (int i = 0; i < SIZE; i++) {
            check = 0;
            check_isDiagonal = 0;
            if (TicTacToe[i][i] == ox) {
                check_isDiagonal++;
            }


            if (check_isDiagonal == SIZE) {
                break;
            }

            for (int j = 0; j < SIZE; j++) {
                if (TicTacToe[j][i] == ox) {
                    check++;
                }
            }
            if (check == SIZE) {
                break;
            }

        }
        if (check == SIZE || check_isDiagonal == SIZE) {
            return true;
        } else {
            return false;
        }

    }


}