import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Various {

    public static void main(String[] args) {

        List<Integer> lista = new ArrayList<>();
        lista.add(12);
        lista.add(7);
        lista.add(2);  //min
        lista.add(16);
        lista.add(5);
        lista.add(22); //max
        lista.add(9);

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Darek", 10000.00, Departament.TESTER));
        employees.add(new Employee(2, "Barbara", 10000.00, Departament.PROGRAMMER));
        employees.add(new Employee(3, "Tomasz", 10000.00, Departament.TESTER));
        employees.add(new Employee(4, "Anna", 10000.00, Departament.PROGRAMMER));

        //1. Wartosc minimalna i maksymalna

        Optional<Integer> min = lista.stream().min(Integer::compare);
        if (min.isPresent()) {
            System.out.println("Minimalna wartosc to: " + min.get());
        }

        Optional<Integer> max = lista.stream().max(Integer::compare);
        if (max.isPresent()) {
            System.out.println("Maksymalna wartość " + max.get());
        }

        //2. sortowanie

        Stream<Integer> sorted = lista.stream().sorted();
        System.out.println("Lista posortowana: ");
        //sorted.forEach(System.out::println);
        sorted.forEach((n) -> System.out.print(n + ","));
        System.out.println();

        //3. count

        long count = lista.stream().count();
        System.out.println("Liczba elementów: " + count);

        //4. reduce() wykonuje dowolne operacje na elemtnach streama np suma elementów

        Optional<Integer> sum = lista.stream().reduce((a, b) -> a + b);
        if (sum.isPresent()) {
            System.out.println("Suma elementów " + sum.get());
        }

        //5. map() przekształcanie elemntów strumienia w inny typ
        //np: strumień zwykłych pracowników Employee zmieniony na Managerów i udzielono im podwyżki.

        List<Manager> managers = employees.stream().
                map(e -> new Manager(10, e.firstName(), e.salary() + 999, e.departament(), true)).
                collect(Collectors.toList());
        System.out.println("Nowi managerowie ");
        for (Manager manager : managers) {
            System.out.println(manager);
        }

        //6. Własny interfejs funkcyjny. Zobacz klase InterfejsBezLambdy żeby zobaczyć rożnicę.
        APIClient response;                             //1. Referencja do interfejsu
        response = () -> "This is response string";      //2. Zdefiniuj jak ma zadziałać jedyna metoda w interfejsie
        System.out.println(response.sendSomeRequest());      // 3. Uzyj metody odwołując sie do jej nazwy w interfejsie.

        //a teraz z InterfejsBezLambdy
        InterfejsBezLambdy interfejsBezLambdy = new InterfejsBezLambdy();
        String s = interfejsBezLambdy.sendSomeRequest();
        System.out.println(s);

    }
}
