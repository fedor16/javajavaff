import java.util.Arrays;
import java.util.Scanner;

public class Task4 {

    public int maxAbs(int[] arr) {
        if (arr.length == 0) return 0;
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (Math.abs(arr[i]) > Math.abs(max)) max = arr[i];
        }
        return max;
    }

    public int[] add(int[] arr, int x, int pos) {
        int[] result = new int[arr.length + 1];
        for (int i = 0; i < pos; i++) result[i] = arr[i];
        result[pos] = x;
        for (int i = pos; i < arr.length; i++) result[i + 1] = arr[i];
        return result;
    }

    public int[] add(int[] arr, int[] ins, int pos) {
        int[] result = new int[arr.length + ins.length];
        for (int i = 0; i < pos; i++) result[i] = arr[i];
        for (int i = 0; i < ins.length; i++) result[pos + i] = ins[i];
        for (int i = pos; i < arr.length; i++) result[ins.length + i] = arr[i];
        return result;
    }

    public void reverse(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[n - 1 - i];
            arr[n - 1 - i] = temp;
        }
    }

    public int[] findAll(int[] arr, int x) {
        int count = 0;
        for (int num : arr) if (num == x) count++;
        int[] result = new int[count];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) result[index++] = i;
        }
        return result;
    }
    
    private static int getInt(Scanner sc, String message) {
        System.out.print(message);
        while (!sc.hasNextInt()) {
            System.out.println("Ошибка! Введите целое число.");
            System.out.print(message);
            sc.next();
        }
        return sc.nextInt();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Task4 app = new Task4();
        boolean exit = false;
        
        int[] arr1 = {1, 2, 3, 4, 5}; 

        System.out.println("Задание 4");

        while (!exit) {
            System.out.println("\nДоступные задачи: 3, 4, 5, 6, 9 (или 0 для выхода)");
            int choice = getInt(sc, "Выберите задачу: ");

            switch (choice) {
                case 3:
                    int[] testArr = {1, -2, -7, 4, 2, 2, 5};
                    System.out.println("Массив: " + Arrays.toString(testArr) + "\nРезультат: " + app.maxAbs(testArr));
                    break;
                case 4:
                    System.out.println("Исходный: " + Arrays.toString(arr1) + ", вставляем x=9 на позицию pos=3");
                    System.out.println("Результат: " + Arrays.toString(app.add(arr1, 9, 3)));
                    break;
                case 5:
                    int[] ins = {7, 8, 9};
                    System.out.println("Исходный: " + Arrays.toString(arr1) + ", вставляем массив " + Arrays.toString(ins) + " на позицию pos=3");
                    System.out.println("Результат: " + Arrays.toString(app.add(arr1, ins, 3)));
                    break;
                case 6:
                    int[] revArr = {1, 2, 3, 4, 5};
                    app.reverse(revArr);
                    System.out.println("Исходный был [1, 2, 3, 4, 5]\nРезультат (после реверса): " + Arrays.toString(revArr));
                    break;
                case 9:
                    int[] findArr = {1, 2, 3, 8, 2, 2, 9};
                    System.out.println("Массив: " + Arrays.toString(findArr) + ", ищем x=2\nРезультаты (индексы): " + Arrays.toString(app.findAll(findArr, 2)));
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