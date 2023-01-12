import java.util.function.BiFunction;
import java.util.function.Function;

public class LambdaTraining {

    public static void main(String[] args) {

        // 1. Lambda w Interfejsie funkcyjnym. Przed strałką -> jest String, po strzałce Integer, czyli to co zwraca lambda
        // Tutaj Interfejs przyjmuje string i zwraca Integer
        Function<String, Integer> functionLambda = s-> s.length();

        System.out.println(functionLambda.apply("lambda"));

        //2. BiFunction - przyjmuje dwa argumenty String i String i zwraca Boolean
        // jeśli lambda ma dwa argumenty to trzeba dać je w nawiasach (string1, string2)

        BiFunction<String, String, Boolean> biFunctionLambda = (string1, string2) -> string1.startsWith(string2);

        System.out.println(biFunctionLambda.apply("Darek", "D"));

        //3. Jeśli w sekcji return jest jedna linijka to nie trzeba {} a jeśli dodajemy logikę to trzeba dodać {}
        Function<Integer, String> szukajParzystychLambda = numer->
        {
            if (numer % 2 == 0) {
                return "To parzysta liczba";
            }else
            return "To nieparzysta liczba";
        };

        System.out.println(szukajParzystychLambda.apply(446));

    }
}
