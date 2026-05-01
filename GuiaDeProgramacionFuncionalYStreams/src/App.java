import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Guía de Ejercicios Prácticos: Programación Funcional y Streams");

//Ejercicio 1.1-----------------------------------------------------------------------------

//1.Predicate
        Predicate<Integer> esPar = n -> n % 2 == 0;
        System.out.println(esPar.test(2));
        System.out.println(esPar.test(3));

//2.Function
        Function<String,Integer> longitud = texto -> texto.length();
        System.out.println(longitud.apply("Clase de Programacion"));

//3.Consumer
        Consumer<Integer> imprimir = n -> System.out.println(n);
        imprimir.accept(6);

//4.Supplier
        Supplier<Double> aleatorio = () -> Math.random();
        System.out.println(aleatorio.get());

//Ejercicio 1.2-----------------------------------------------------------------------------
        List<String> textos = new ArrayList<>();

        textos.add("Momo");
        textos.add("Mila");
        textos.add("Dala");
        textos.add("Moro");

        textos.sort((a , b) -> a.length() - b.length());

        System.out.println(textos);

//Ejercicio 1.3-----------------------------------------------------------------------------

        ToIntFunction<String> longitud2 = texto2 -> texto2.length();
        System.out.println(longitud2.applyAsInt("Momo es el perrito de Lucia"));

        IntPredicate esPar2 = n -> n % 2 == 0;
        System.out.println(esPar2.test(4));
        System.out.println(esPar2.test(5));

//Ejercicio 2.1-----------------------------------------------------------------------------
        long cantidad = Stream.of(2, 5, 3, 3, 6, 2, 4)
        .distinct()
        .skip(1)
        .limit(3)
        .count();

        System.out.println("Cantidad de numeros: " + cantidad);

//Ejercicio 2.2-----------------------------------------------------------------------------
        long cantidad2 = Stream.of(2, 5, 3, 3, 6, 2, 4)
        .filter(s -> s > 3)
        .peek(n -> System.out.println(n))
        .count();

        System.out.println("Cantidad de numeros: " + cantidad2);

//Ejercicio 3.1-----------------------------------------------------------------------------
        Stream.of("Juan", "Maria", "Ana")
        .map(s -> s.toUpperCase())
        .forEach(System.out::println);

//Ejercicio 3.2-----------------------------------------------------------------------------
        int total = Stream.of("Juan", "Maria", "Ana")
        .mapToInt(s -> s.length())
        .sum();

        System.out.println("La suma de todas las letras de los nombres: " + total);

//Ejercicio 3.3-----------------------------------------------------------------------------
        List<List<String>> datos = List.of(
            List.of("Stefan","Damon"),
            List.of("Elena","Caroline")
        );

        long cantidadNombres = datos.stream()
        .flatMap(l -> l.stream())
        .filter(s -> s.length() > 4)
        .count();

        System.out.println("Cantidad de nombres con mas de 4 letras: " + cantidadNombres);

//Ejercicio 3.4-----------------------------------------------------------------------------
        System.out.println("Orden natural:");
        Stream.of("Pedro", "Ana", "Lucia", "Juan")
        .sorted()
        .forEach(System.out::println);

        System.out.println("Orden por longitud:");
        Stream.of("Pedro", "Ana", "Lucia", "Juan")
        .sorted((a, b) -> a.length() - b.length())
        .forEach(System.out::println);

//Ejercicio 4.1-----------------------------------------------------------------------------
        boolean hayMayores = Stream.of(2, 5, 7, 3, 6, 2, 3)
        .anyMatch(n -> n > 5);

        boolean todosMayores = Stream.of(2, 5, 7, 3, 6, 2, 3)
        .allMatch(n -> n > 1);

        boolean ningunoNegativo = Stream.of(2, 5, 7, 3, 6, 2, 3)
        .noneMatch(n -> n < 0);

        System.out.println("¿Hay algun numero mayor a 5?: " + hayMayores);
        System.out.println("¿Todos los numeros son mayores a 1?: " + todosMayores);
        System.out.println("¿No hay numeros negativos?: " + ningunoNegativo);

//Ejercicio 4.2-----------------------------------------------------------------------------
        Optional<Integer> numeroPar = Stream.of(5, 7, 9, 4, 3, 8)
        .filter(n -> n % 2 == 0)
        .findFirst();

        if (numeroPar.isPresent()) {
            System.out.println("Primer numero par encontrado: " + numeroPar.get());
        } else {
            System.out.println("No se encontro ningun numero par");
        }

//Ejercicio 4.3-----------------------------------------------------------------------------
        Optional<Integer> suma = Stream.of(2, 4, 6, 8)
        .reduce((a, b) -> a + b);

        System.out.println("La suma total es: " + suma.get());

//Ejercicio 4.4-----------------------------------------------------------------------------
        List<Integer> listaLimpia = Stream.of(2, 5, 2, 7, 3, 5, 7, 9)
        .distinct()
        .collect(Collectors.toList());

        System.out.println("Lista sin duplicados: " + listaLimpia);

        List<Persona> personas = List.of(
            new Persona(101, "Juan"),
            new Persona(102, "Maria"),
            new Persona(103, "Pedro")
        );

        Map<Integer, String> mapaPersonas = personas.stream()
        .collect(Collectors.toMap(
            p -> p.getDni(),
            p -> p.getNombre()
        ));

        System.out.println("Mapa de personas: " + mapaPersonas);
    }
}