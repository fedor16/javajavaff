import java.util.Scanner;

public class Task2 {

    public int abs(int x) { return (x < 0) ? -x : x; }

    public String makeDecision(int x, int y) {
        if (x > y) return x + " > " + y;
        if (x < y) return x + " < " + y;
        return x + " == " + y;
    }

    public int max3(int x, int y, int z) {
        int max = x;
        if (y > max) max = y;
        if (z > max) max = z;
        return max;
    }

    public String age(int x) {
        int lastDigit = x % 10;
        int lastTwoDigits = x % 100;

        if (lastTwoDigits >= 11 && lastTwoDigits <= 14) return x + " лет";
        if (lastDigit == 1) return x + " год";
        if (lastDigit >= 2 && lastDigit <= 4) return x + " года";
        return x + " лет";
    }

    public String day(int x) {
        switch (x) {
            case 1: return "понедельник";
            case 2: return "вторник";
            case 3: return "среда";
            case 4: return "четверг";
            case 5: return "пятница";
            case 6: return "суббота";
            case 7: return "воскресенье";
            default: return "это не день недели";
        }
    }

    private static int getInt(Scanner sc, String message) {
        System.out.print(message);
        while (!sc.hasNextInt()) {
            System.out.println("Введите целое число.");
            System.out.print(message);
            sc.next();
        }
        return sc.nextInt();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Task2 app = new Task2();
        boolean exit = false;

        System.out.println("Задание 2");

        while (!exit) {
            int choice = getInt(sc, "Выберите задачу 1, 4, 5, 8, 9 (или 0 для выхода): ");

            switch (choice) {
                case 1:
                    System.out.println("Результат: " + app.abs(getInt(sc, "Введите число: ")));
                    break;
                case 4:
                    System.out.println("Результат: " + app.makeDecision(getInt(sc, "x: "), getInt(sc, "y: ")));
                    break;
                case 5:
                    System.out.println("Результат: " + app.max3(getInt(sc, "x: "), getInt(sc, "y: "), getInt(sc, "z: ")));
                    break;
                case 8:
                    System.out.println("Результат: " + app.age(getInt(sc, "Введите возраст: ")));
                    break;
                case 9:
                    System.out.println("Результат: " + app.day(getInt(sc, "Введите номер дня: ")));
                    break;
                case 0:
                    exit = true;
                    break;
                default:
                    System.out.println("Задачи с таким номером нет");
            }
        }
        sc.close();
    }
}