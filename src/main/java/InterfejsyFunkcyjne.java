import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.function.*;
import java.util.stream.IntStream;

@Slf4j
public class InterfejsyFunkcyjne {
    public static void main(String[] args) {
        //  Lista Pracowników
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(1, "Katarzyna", 3000.00, Departament.TESTER));
        employeeList.add(new Employee(2, "Anna", 4000.00, Departament.TESTER));
        employeeList.add(new Employee(3, "Tomasz", 5000.00, Departament.PROGRAMMER));
        employeeList.add(new Employee(4, "Dariusz", 6000.00, Departament.PROGRAMMER));
        employeeList.add(new Employee(5, "Sandra", 7000.00, Departament.TESTER));
        employeeList.add(new Employee(6, "Marcin", 8000.00, Departament.MANAGER));
        employeeList.add(new Employee(7, "Wojciech", 9000.00, Departament.MANAGER));
        employeeList.add(new Employee(8, "Jan", 10000.00, Departament.MANAGER));
        employeeList.add(new Employee(9, "Grzegorz", 11000.00, Departament.PROGRAMMER));
        employeeList.add(new Employee(10, "Pani Basia", 500.00, Departament.MANAGER));



        // 1. IntStream operuje na prymitywnym tpie int
         //IntStream.range(0, 10).forEach(System.out::println);

        // 2. od 0-10
        //IntStream.rangeClosed(0, 10).forEach(System.out::println);

        //3.  tworzenie strama
        //IntStream intStream = IntStream.of(1, 2, 3);

        //4. iterate tworzy nieskończony stream, który trzema limitować metodą limit
//        IntStream limit = IntStream.iterate(0, i -> i + 2).limit(10);
//        limit.forEach(System.out::println);

        //5. generate tworzy nieskończony stram który trzeba limitować metodą limit.
        // Stream zawiera jednocyfrowe liczby randomowe.

//        IntStream stream = IntStream
//                .generate(() -> { return (int) (Math.random() * 10); });
//
//        stream.limit(109).forEach(System.out::println);


        //6. Liczby pierwsze, filtrowanie ze streamu 100 liczb
//        IntStream stream = IntStream.range(1, 100);
//
//        List<Integer> primes = stream.filter(InterfejsyFunkcyjne::isPrime)
//                .boxed()
//                .collect(Collectors.toList());
//
//
//        System.out.println(primes);

        //7. Interfejsy funkcyjne: Predicate, Function, Supplier, Consumer

       // zadanie3_Function(new Employee(4, "Dariusz", 6000.00, Departament.PROGRAMMER));
        zadanie4_Supplier();

    }

    //Predicate - przyjmuje dowolny parametr i zwraca boolean. Jest przyjmowany przez filter()
    public static void zadanie1_Predicate(List<Employee> employeeList)
    {
        Predicate<Employee> isSalaryGreaterThan5000 = employee -> employee.salary()>5000.00;
        Predicate<Employee> isSalaryGreaterThan10000 = employee -> employee.salary()>10000.00;

        employeeList.stream()
                .filter(isSalaryGreaterThan10000)
                .forEach(System.out::println);
    }

    //Function - przyjmuje dowolny parametr i produkuje resultat
    public static void zadanie2_Function(Employee employee)
    {
        //stwórz Function, który podanemu pracownikowi podnosi salary o 30%, czyli mnoży razy 1,3

        System.out.println("Pracownik przed podwyzką " + employee);

        //tworze definicje Function który daje podwyżki
        Function<Employee, Employee> giveBonus30 = employee1 -> {
            return new Employee(employee1.id(), employee1.firstName(), employee1.salary()*1.3, employee1.departament());
        };

        Function<Employee, Employee> giveReduce30 = employee1 -> {
            return new Employee(employee1.id(), employee1.firstName(), employee1.salary()*0.7, employee1.departament());
        };

        //stosuje podwyżki
        Employee pracownikPoPodwyzce = giveReduce30.apply(employee);
        System.out.println("Pracownik po podwyzce " + pracownikPoPodwyzce);
    }

    //Function - przyjmuje dowolny parametr i produkuje resultat + antThen()
    public static void zadanie3_Function(Employee employee)
    {
        //stwórz Function, który podanemu pracownikowi podnosi salary o 30% i daje premię roczną ryczałtem 1000zł = 8800 zl

        System.out.println("Pracownik przed podwyzką " + employee);

        //tworze definicje Function który daje podwyżki
        Function<Employee, Employee> giveBonus30 = employee1 -> {
            return new Employee(employee1.id(), employee1.firstName(), employee1.salary()*1.3, employee1.departament());
        };

        //tworze definicje Function który daje premię roczną 1000zł
        Function<Employee, Employee> giveAnnualBonus1000 = employee1 -> {
            return new Employee(employee1.id(), employee1.firstName(), employee1.salary()+1000.00, employee1.departament());
        };

        //stosuje podwyżki
        Employee pracownikPoPodwyzce = giveBonus30.andThen(giveAnnualBonus1000).apply(employee);
        System.out.println("Pracownik po podwyzce i premii rocznej" + pracownikPoPodwyzce);
        //zrobić odwrotną kolejność stosowania bonusów, result 9100
    }

    //Consumer - przyjmuje dowolny parametr i nic nie zwraca
    public static void zadanie4_Consumer(List<Employee> employeeList)
    {
        //stwórz Consumer, który drukuje na konsoli dowolną listę pracowników


        //tworze definicje Consumer który drukuje liste na konsoli
        Consumer<List<Employee>> printEmployeeList = list -> list.forEach(System.out::println);

        //stosuje Consumera
        log.info("Oto lista pracowników drukowana przez Interfejs Consumer");
        printEmployeeList.accept(employeeList);


    }

    //Supplier  - nic nie przyjmuje i zwraca dowolny obiekt
    public static void zadanie4_Supplier()
    {
        //stwórz Suplier, który zwraca nazwę firmy w której pracują pracownicy


        //tworze definicje Consumer który drukuje liste na konsoli
        Supplier<String> getCompanyName = () -> "The Best Company Ever.sp.z.o.o".toUpperCase();

        //stosuje Suppliera
        log.info("Oto nazwa naszej firmy");
        System.out.println(getCompanyName.get());
    }

    //anyMatch w ifie  -
    public static void zadanie5_anyMatch()
    {

    }




    public static boolean isPrime(int i)
    {
        IntPredicate isDivisible = index -> i % index == 0;
        return i > 1 && IntStream.range(2, i).noneMatch(isDivisible);
    }

    }

