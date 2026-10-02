import java.util.Random;
import java.util.Scanner;

public class Task3 {

    public String reverseListNums(int x) {
        StringBuilder sb = new StringBuilder();
        for (int i = x; i >= 0; i--) sb.append(i);
        return sb.toString();
    }

    public String chet(int x) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= x; i += 2) sb.append(i);
        return sb.toString();
    }

    public void square(int x) {
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < x; j++) System.out.print("*");
            System.out.println();
        }
    }

    public void leftTriangle(int x) {
        for (int i = 1; i <= x; i++) {
            for (int j = 0; j < i; j++) System.out.print("*");
            System.out.println();
        }
    }

    public void guessGame(Scanner sc) {
        int target = new Random().nextInt(10);
        int attempts = 0, guess = -1;

        System.out.println("Введите число от 0 до 9:");
        while (guess != target) {
            guess = getInt(sc, "");
            attempts++;
            if (guess != target) System.out.println("Вы не угадали, введите число от 0 до 9:");
        }
        System.out.println("Вы угадали!\nВы отгадали число за " + attempts + " попытки(ок)");
    }

    private static int getInt(Scanner sc, String message) {
        if (!message.isEmpty()) System.out.print(message);
        while (!sc.hasNextInt()) {
            System.out.println("Введите целое число.");
            if (!message.isEmpty()) System.out.print(message);
            sc.next();
        }
        return sc.nextInt();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Task3 app = new Task3();
        boolean exit = false;

        System.out.println("Задание 3");

        while (!exit) {
            System.out.println("\nДоступные задачи: 2, 3, 7, 8, 10 (или 0 для выхода)");
            int choice = getInt(sc, "Выберите задачу: ");

            switch (choice) {
                case 2:
                    System.out.println("Результат: " + app.reverseListNums(getInt(sc, "Введите число x: ")));
                    break;
                case 3:
                    System.out.println("Результат: " + app.chet(getInt(sc, "Введите число x: ")));
                    break;
                case 7:
                    app.square(getInt(sc, "Введите размер квадрата: "));
                    break;
                case 8:
                    app.leftTriangle(getInt(sc, "Введите размер треугольника: "));
                    break;
                case 10:
                    app.guessGame(sc);
                    break;
                case 0:
                    exit = true;
                    break;
                default:
                    System.out.println("Такой задачи нет в варианте 5!");
            }
        }
        sc.close();
    }
}