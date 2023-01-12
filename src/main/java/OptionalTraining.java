import java.util.Optional;

public class OptionalTraining {
    public static void main(String[] args) {

        //1. Tworzenie Optionala z domyślną wartoscia

//        var niespodzianka1 = Optional.ofNullable("willa").
//                orElseGet(() ->"nagroda pocieszenia");
//
//        var niespodzianka2 = Optional.ofNullable(null).
//                orElseGet(() ->"nagroda pocieszenia");
//
//        System.out.println(niespodzianka1);
//        System.out.println(niespodzianka2);

        //2. Tworzenie Optionala z błedem
//        var niespodzianka3 = Optional.ofNullable(null).
//                orElseThrow(()-> new IllegalArgumentException("wrong input provided"));
//
//        System.out.println(niespodzianka3);

        //3. Tworzenie Optionala z ifPresent

        Optional.ofNullable("mercedes").
        ifPresent(value -> {
            value = value + " dodaje do tego 10 tys $";
            System.out.println(value);
        });


    }
}
