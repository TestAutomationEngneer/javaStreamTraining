import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Slf4j
public class Run {

    //Training for java stream

    public static void main(String[] args) {


        // 1. Lista Pracowników
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

        //2. Lista Integerów
        List<Integer> intsList = Arrays.asList(4, 2, 5, 33, 112, 545, 5453, 32, 13, 3);

        //3. Lista Stringów
        List<String> stringList = Arrays.asList("dhga", "arere", "ameryka", "arabia", "bdgwjhg", "cueqi", "opuytr", "pofsdfsdfsdfssdfsdfsdfsdfssdtol");


        //Run.stream5(employeeList).forEach(System.out::println);

        zadadnie14(employeeList);

    }


    //IntStream oraz anyMatch()
    public static void zadadnie1() {

        //1. Mam tablice z intami
        //2. robie z niej stream intów
        //3. pobieram skanerem jakąś liczbe
        //4.  robie ifa który sprawdza czy liczba ze skanera jest w tablicy


        int tablicaIntow[] = {5, 10, 15, 20};
        Scanner scanrer = new Scanner(System.in);
        int mojaLiczba = scanrer.nextInt();
        if (IntStream.of(tablicaIntow).anyMatch(x -> x == mojaLiczba)) {
            log.info("trafione");
        } else {
            log.info("nie trafione");
        }
    }


    //anyMatch - do poprawy
    public static void zadadnie2() {

        String[] sensualKeys = {"login", "password"};

        Map<String, Object> mojaMapa = new HashMap();
        mojaMapa.put("login", "darek");
        mojaMapa.put("password", "darek");
        mojaMapa.put("title", "darek");
        mojaMapa.put("url", "www.darek");

        if (Arrays.stream(sensualKeys).anyMatch(mojaMapa.keySet().toString()::contains)) {
            log.info("Loaded environment property: " + mojaMapa.keySet().toString() + " = " + "***********");
        } else {
            log.info("Loaded environment property: " + mojaMapa.keySet().toString() + " = " + mojaMapa.get(mojaMapa.keySet().toString()));
        }
    }

    // stream, filter()
    public static void zadadnie3(List<Employee> employeeList) {

        //wypisać imie i id pracowników
        // co mają salary większe niż 5000

        employeeList.stream()
                .filter(pracownik -> pracownik.salary()  > 5000.00)
                .map(pracownik -> pracownik.id() + " " + pracownik.firstName())
                .forEach(System.out::println);

    }

    // stream, filter()
    public static void zadadnie4(List<Employee> employeeList) {

        //wypisać imie pracowników oraz departament
        // co mają salary większe niż 5000 oraz sa managerami

        employeeList.stream()
                .filter(pracownik -> pracownik.salary() > 5000.00)
                .filter(pracownik -> pracownik.departament().equals(Departament.MANAGER))
                .map(pracownik -> pracownik.firstName() + " " + pracownik.departament())
                .forEach(System.out::println);
    }

    //count();
    public static void zadadnie5(List<Employee> employeeList) {

        // policzyć ilu jest Testerów

        var counter =  employeeList.stream()
                .filter(pracownik -> pracownik.departament().equals(Departament.TESTER))
                .count();

        log.info("Counter of Testers = {}", counter);
    }

    // .sorted() dla listy intów
    public static void zadadnie6(List<Integer> intsList) {

        // posortować kolekcję intów

        log.info("Oryginalna lista ");
        intsList.forEach(System.out::println);

        List<Integer> sortedList = intsList.stream()
                //.sorted()
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList());
        log.info("Posortowana lista ");
        sortedList.forEach(System.out::println);

    }

    // .sorted() dla Employee
    public static void zadadnie7(List<Employee> employeeList) {

        // posortować po salary Employee
        log.info("Posortowana lista Employee");
         employeeList.stream().
                sorted(Comparator.comparing(Employee::salary))
                //sorted(Comparator.comparing(Employee::salary).reversed())
                .collect(Collectors.toList())
                 .forEach(System.out::println);
    }


    //startsWith("a")
    public static void zadadnie8(List<String> stringList) {

        // znaleźć słowa zaczynające sie na a w liście

        stringList.stream()
                .filter(a -> a.startsWith("a"))
                .forEach(System.out::println);

    }

    //allMatch() - czy wszystkie elementy kolekcji spełniają warunek, zwraca boolean
    public static void zadadnie9(List<String> stringList) {

        // czy wszystkie słowa zaczynają sie na "a"

        boolean resultAllMatch = stringList.stream()
                .allMatch(s -> s.startsWith("b"));


        log.info("czy są same wyrazy na b = " + resultAllMatch);
    }

    //allMatch() - czy wszystkie elementy kolekcji spełniają warunek, zwraca boolean
    public static void zadadnie10(List<String> stringList) {

        // czy wszystkie słowa mają length większy niż 2 - true

        boolean resultAllMatch = stringList.stream()
                .allMatch(s -> s.length()>2);


        log.info("czy są dłuższe niż 2 = " + resultAllMatch);
    }

    //anyMatch() - czy jakikolwike elementy kolekcji spełniają warunek, zwraca boolean
    public static void zadadnie11(List<String> stringList) {

        // czy wszystkie słowa mają length większy niż 12 - true

        boolean resultAllMatch = stringList.stream()
                .anyMatch(s -> s.length()>12);

        log.info("czy są dłuższe niż 12 = " + resultAllMatch);
    }

    //min() - minimum z kolekcji
    public static void zadadnie12(List<Employee> employeeList) {

        // pracownik z najmniejszym salary

        log.info("Pracownik z najmniejszą salary to: ");
        employeeList.stream()
                        .min(Comparator.comparing(Employee::salary))
        .ifPresent(System.out::println);

    }

    //max() - maximum z kolekcji
    public static void zadadnie13(List<Employee> employeeList) {

        // pracownik z największą salary

        log.info("Pracownik z największą salary to: ");
        employeeList.stream()
                .max(Comparator.comparing(Employee::salary))
                .ifPresent(System.out::println);

    }

    //group() - grupuje po jakiejść kategorii
    public static void zadadnie14(List<Employee> employeeList) {

        // pogrupuj pracowników po departamencie

        log.info("Wszystkie departamenty:");
        Map<Departament, List<Employee>> pracownicyWDepartamentach = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::departament));

        pracownicyWDepartamentach.forEach(((departament, pracownicy) ->
        {
            System.out.println(departament);
            pracownicy.forEach(System.out::println);
        }));

    }

    }


