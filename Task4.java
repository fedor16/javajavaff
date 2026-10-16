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

    //ввод числа целого числа
    private int getInt(Scanner sc, String message) {
        System.out.print(message);
        while (!sc.hasNextInt()) {
            System.out.println("Введите целое число.");
            System.out.print(message);
            sc.next();
        }
        return sc.nextInt();
    }

    //ввод массива
    private int[] getArray(Scanner sc, String name) {
        int size;
        while (true) {
            size = getInt(sc, "Введите размер " + name + ": ");
            if (size >= 0) break;
            System.out.println("размер должен быть больше 0");
        }
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = getInt(sc, "Элемент [" + i + "]: ");
        }
        return arr;
    }

    //ввод позиции вставки в массив
    private int getValidPos(Scanner sc, int maxPos) {
        int pos;
        while (true) {
            pos = getInt(sc, "Введите позицию для вставки (от 0 до " + maxPos + "): ");
            if (pos >= 0 && pos <= maxPos) return pos;
            System.out.println("Позиция выходит за пределы массива.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Task4 app = new Task4();
        boolean exit = false;

        System.out.println("Задание 4");

        while (!exit) {
            System.out.println("\nДоступные задачи: 3, 4, 5, 6, 9 (0 - выход)");
            int choice = app.getInt(sc, "Выберите задачу: ");

            switch (choice) {
                case 3:
                    int[] arr3 = app.getArray(sc, "массива");
                    System.out.println("Массив: " + Arrays.toString(arr3));
                    System.out.println("Максимальный по модулю: " + app.maxAbs(arr3));
                    break;

                case 4:
                    int[] arr4 = app.getArray(sc, "исходного массива");
                    int x4 = app.getInt(sc, "Введите число для вставки: ");
                    int pos4 = app.getValidPos(sc, arr4.length);
                    System.out.println("Исходный: " + Arrays.toString(arr4));
                    System.out.println("Результат: " + Arrays.toString(app.add(arr4, x4, pos4)));
                    break;

                case 5:
                    int[] arr5 = app.getArray(sc, "исходного массива");
                    int[] ins5 = app.getArray(sc, "массива для вставки");
                    int pos5 = app.getValidPos(sc, arr5.length);
                    System.out.println("Исходный: " + Arrays.toString(arr5) + ", вставка: " + Arrays.toString(ins5));
                    System.out.println("Результат: " + Arrays.toString(app.add(arr5, ins5, pos5)));
                    break;

                case 6:
                    int[] revArr = app.getArray(sc, "массива");
                    System.out.println("Исходный: " + Arrays.toString(revArr));
                    app.reverse(revArr);
                    System.out.println("Результат: " + Arrays.toString(revArr));
                    break;

                case 9:
                    int[] findArr = app.getArray(sc, "массива");
                    int x9 = app.getInt(sc, "Введите искомое число x: ");
                    System.out.println("Массив: " + Arrays.toString(findArr));
                    System.out.println("Индекты вхождений: " + Arrays.toString(app.findAll(findArr, x9)));
                    break;

                case 0:
                    exit = true;
                    break;

                default:
                    System.out.println("такой задачи нет");
            }
        }
        sc.close();
    }
}