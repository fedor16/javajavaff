import java.util.Scanner;

public class Task1 {
    public double fraction(double x) {
        return x - (int) x;
    }
    public int sumLastNums(int x) {
        int absX = Math.abs(x);
        return (absX % 10) + ((absX / 10) % 10);
    }

    public boolean isUpperCase(char x) {
        return x >= 'A' && x <= 'Z';
    }

    public boolean isInRange(int a, int b, int num) {
        int min = Math.min(a,b);
        int max = Math.max(a,b);
        return num >= min && num <= max;
    }

    public int lastNumSum(int a, int b) {
        return (Math.abs(a) % 10) + (Math.abs(b) % 10);
    }

    private static int getInt(Scanner sc, String message) {
        System.out.print(message);
        while (!sc.hasNextInt()) {
            System.out.println("Введите целое число ");
            System.out.print(message);
            sc.next();
        }
        return sc.nextInt();
    }

    private static double getDouble(Scanner sc, String message) {
        System.out.print(message);
        while (!sc.hasNextDouble()) {
            System.out.println("Введите вещественное число ");
            System.out.print(message);
            sc.next();
        }
        return sc.nextDouble();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Task1 app = new Task1();
        boolean exit = false;

        System.out.println("Задание 1");
        while (!exit) {
            System.out.println("\nВыберите задание 1, 2, 6, 7, 10. Для выхода выберите 0:");
            int choice = getInt(sc, "Выберите задачу: ");
            switch (choice) {
                case 1:
                    double x1 = getDouble(sc, "Введите число (например 5,25): ");
                    System.out.println("Результат: " + app.fraction(x1));
                    break;
                case 2:
                    int x2 = getInt(sc, "Введите число (> 2 знаков): ");
                    System.out.println("Результат: " + app.sumLastNums(x2));
                    break;
                case 6:
                    System.out.print("Введите символ от A до Z: ");
                    char c = sc.next().charAt(0);
                    System.out.println("Результат: " + app.isUpperCase(c));
                    break;
                case 7:
                    int a = getInt(sc, "a: ");
                    int b = getInt(sc, "b: ");
                    int num = getInt(sc, "num: ");
                    System.out.println("Результат: " + app.isInRange(a, b, num));
                    break;
                case 10:
                    System.out.println("Введите 5 чисел:");
                    int n1 = getInt(sc, "1 - "); 
                    int n2 = getInt(sc, "2 - ");
                    int n3 = getInt(sc, "3 - "); 
                    int n4 = getInt(sc, "4 - ");
                    int n5 = getInt(sc, "5 - ");
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
                    System.out.println("Нет подходящего задания, есть 1,2,6,7,10");
            }
        }
        sc.close();
        
    }
    
}