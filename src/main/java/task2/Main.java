package task2;

/* Task 2
8) Фильтрация по возрасту больше чем 20, сортировка по последней
букве имени, увеличение возраста каждого на 3, вычисление среднего
возраста всех элементов
* */

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public record Human(int age, String firstName, String lastName, LocalDate birthDate, int weight) {}

    public static void main(String[] args) {
        // Generate an array of Human objects
        List<Human> humans = Arrays.asList(
                new Human(25, "John", "Doe", LocalDate.of(1990, 5, 15), 70),
                new Human(30, "Alice", "Smith", LocalDate.of(1985, 8, 20), 65),
                new Human(22, "Bob", "Johnson", LocalDate.of(2000, 3, 10), 80),
                new Human(18, "Emily", "Brown", LocalDate.of(2005, 11, 25), 60)
        );

        // Log the original array
        System.out.println("Original array:");
        humans.forEach(System.out::println);

        // Filter humans with age greater than 20
        humans = humans.stream()
                .filter(human -> human.age() > 20)
                .collect(Collectors.toList());
        // Log the array after filtering
        System.out.println("\nArray after filtering by age > 20:");
        humans.forEach(System.out::println);

        // Sort by the last letter of the first name
        humans = humans.stream()
                .sorted((h1, h2) -> h1.firstName().substring(h1.firstName().length() - 1)
                        .compareToIgnoreCase(h2.firstName().substring(h2.firstName().length() - 1)))
                .collect(Collectors.toList());
        // Log the array after sorting
        System.out.println("\nArray after sorting by last letter of first name:");
        humans.forEach(System.out::println);

        // Increase age by 3 for each human
        humans = humans.stream()
                .map(human -> new Human(human.age() + 3, human.firstName(), human.lastName(), human.birthDate(), human.weight()))
                .collect(Collectors.toList());
        // Log the array after increasing age
        System.out.println("\nArray after increasing age by 3 years:");
        humans.forEach(System.out::println);

        // Calculate the average age of all humans
        double averageAge = humans.stream()
                .mapToInt(Human::age)
                .average()
                .orElse(0);
        // rounding to 3 digits after decimal point
        averageAge = Math.round(averageAge * 1000.0) / 1000.0;
        System.out.println("\nAverage age of all humans: " + averageAge);
    }
}

