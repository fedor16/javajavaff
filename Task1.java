import java.util.Scanner;

public class Task1 {
public double fraction(double x) { return x - (int) x; }

public int sumLastNums(int x) {
    return Math.abs((x % 10) + ((x / 10) % 10));
}

public boolean isUpperCase(char x) { return x >= 'A' && x <= 'Z'; }

public boolean isInRange(int a, int b, int num) {
    int min = Math.min(a, b);
    int max = Math.max(a, b);
    return num >= min && num <= max;
}

public int lastNumSum(int a, int b) { return (Math.abs(a) % 10) + (Math.abs(b) % 10); }


private int getInt(Scanner sc, String message) {
    System.out.print(message);
    while (!sc.hasNextInt()) {
        System.out.println("Ошибка, Введите целое число.");
        System.out.print(message);
        sc.next();
    }
    return sc.nextInt();
}


private double getDouble(Scanner sc, String message) {
    System.out.print(message);
    while (!sc.hasNextDouble()) {
        System.out.println("Ошибка, Введите вещественное число.");
        System.out.print(message);
        sc.next();
    }
    return sc.nextDouble();
}


public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Task1 app = new Task1();
    boolean exit = false;

    System.out.println("задание 1");

    while (!exit) {
        System.out.println("\nДоступные задачи: 1, 2, 6, 7, 10 (0 - выход)");
        
        int choice = app.getInt(sc, "Выберите задачу: ");

        switch (choice) {
            case 1:
                double x1 = app.getDouble(sc, "Введите число (например 5,25): ");
                System.out.println("Результат: " + app.fraction(x1));
                break;
            case 2:
                int x2 = app.getInt(sc, "Введите число (не менее 2 знаков): ");
                System.out.println("Результат: " + app.sumLastNums(x2));
                break;
            case 6:
                System.out.print("Введите один символ: ");
                char c = sc.next().charAt(0);
                System.out.println("Результат: " + app.isUpperCase(c));
                break;
            case 7:
                int a = app.getInt(sc, "Граница a: ");
                int b = app.getInt(sc, "Граница b: ");
                int num = app.getInt(sc, "Число num: ");
                System.out.println("Результат: " + app.isInRange(a, b, num));
                break;
            case 10:
                System.out.println("Введите 5 чисел:");
                int n1 = app.getInt(sc, "Число 1: "); 
                int n2 = app.getInt(sc, "Число 2: ");
                int n3 = app.getInt(sc, "Число 3: "); 
                int n4 = app.getInt(sc, "Число 4: ");
                int n5 = app.getInt(sc, "Число 5: ");
                int sum1 = app.lastNumSum(n1, n2); System.out.println(n1 + "+" + n2 + "=" + sum1);
                int sum2 = app.lastNumSum(sum1, n3); System.out.println(sum1 + "+" + n3 + "=" + sum2);
                int sum3 = app.lastNumSum(sum2, n4); System.out.println(sum2 + "+" + n4 + "=" + sum3);
                int sum4 = app.lastNumSum(sum3, n5); System.out.println(sum3 + "+" + n5 + "=" + sum4);
                System.out.println("Итого: " + sum4);
                break;
            case 0:
                exit = true;
                break;
            default:
                System.out.println("Такой задачи нет");
        }
    }
    sc.close();
}
}
