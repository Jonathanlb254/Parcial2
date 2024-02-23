import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        long[] numbers = {16, 16, 8, 4, 2};

        System.out.print("Numeros originales: ");
        System.out.println(Arrays.toString(numbers));


        sortArray(numbers, numbers.length - 1);


        System.out.print("numeros divididos: ");
        System.out.println(Arrays.toString(numbers));
    }

    public static void sortArray(long[] numbers, int index) {
        if (index == 0) {
            return;
        }

        numbers[index] /= 2;

        sortArray(numbers, index - 1);


        System.out.print("total divididos: ");
        System.out.println(Arrays.toString(numbers));


        if (numbers[index] > numbers[index - 1]) {
            long temp = numbers[index];
            numbers[index] = numbers[index - 1];
            numbers[index - 1] = temp;
        }
    }
}
