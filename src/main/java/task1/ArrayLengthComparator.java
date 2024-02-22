package task1;
import java.util.Comparator;

/* Task 1
* 8) Имплементировать интерфейс Comparator, сравнивающий два
* массива с одинаковыми типами элементов по количеству элементов в данных
* массивах.
* */


public class ArrayLengthComparator<T> implements Comparator<T[]> {
    @Override
    public int compare(T[] arr1, T[] arr2) {
        return Integer.compare(arr1.length, arr2.length);
    }

    public static void main(String[] args) {
        // Пример использования компаратора
        Integer[] arr1 = {1, 2, 3};
        Integer[] arr2 = {4, 5, 6, 7};

        ArrayLengthComparator<Integer> comparator = new ArrayLengthComparator<>();
        int result = comparator.compare(arr1, arr2);

        if (result < 0) {
            System.out.println("Первый массив короче второго.");
        } else if (result > 0) {
            System.out.println("Первый массив длиннее второго.");
        } else {
            System.out.println("Оба массива имеют одинаковую длину.");
        }
    }
}

