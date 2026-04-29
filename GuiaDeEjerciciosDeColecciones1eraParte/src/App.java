import java.util.ArrayDeque;//para ejercicio 1.2
import java.util.ArrayList;//para ejercicio 2.1
import java.util.Arrays; //para ejercicio 2.2
import java.util.Collections; //para ejercicio 2.2
import java.util.HashMap; //para ejercicio 3.1
import java.util.HashSet; //para ejercicio 3..2
import java.util.LinkedList; //para ejercicio 4.1
import java.util.List; //para el ejercicio 4.2
import java.util.TreeMap; //para el ejercicio 5

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Guía de Ejercicios: Estructuras de Datos y Framework de Colecciones - Parte 1");

        //Ejercicio 1.1---------------------------------------------------------------------------

        int[] arrayNum = new int[5];

        arrayNum[0] = 1; 
        arrayNum[1] = 2;
        arrayNum[2] = 3;
        arrayNum[3] = 4;
        arrayNum[4] = 5;

        arrayNum[2] = 10;

        int ultimoNum;

        ultimoNum = arrayNum[arrayNum.length - 1];
        System.out.println("El utlimo numero del array es: "+ultimoNum);

        //Ejercicio 1.2---------------------------------------------------------------------------

        String[] arrayNombres = new String[]{"Lucia", "Agostina", "Lola"};
        
        Arrays.sort(arrayNombres); //ordena los nombres en orden ascendente (alfabeticamente)

        int posicion;
        posicion = Arrays.binarySearch(arrayNombres, "Agostina"); //busca la posicion de un nombre
        System.out.println("Agostina se encuentra en la posicion " + posicion + " del array");

        //Ejercicio 2.1---------------------------------------------------------------------------
        ArrayList<String> listaNombres = new ArrayList<>();

        listaNombres.add("Cassie"); //método add() para agregar tres elementos
        listaNombres.add("Suki");
        listaNombres.add("Luna");

        listaNombres.set(1, "Pepe"); //set() para actualizar el valor

        listaNombres.get(0); //get() para recuperar el primer valor
        System.out.println(listaNombres.get(0)); //para mostrar el valor recuperado

        listaNombres.remove( listaNombres.size() - 1 );


        //Ejercicio 2.2---------------------------------------------------------------------------
        List<String> listaInmutable = List.of("X", "Y" , "Z");

        //listaInmutable.add("W"); Se comenta para que no se rompa el programa, tira error como dice la consiga(lista inmutable)

        LinkedList<String> listaMutable = new LinkedList<>(listaInmutable);

        listaMutable.add(1, "A");

        System.out.println(listaMutable);

        //Ejercicio 3.1----------------------------------------------------------------------------
        HashSet<Integer> coleccionSet = new HashSet<>(); //No permite duplicados (set), no mantiene orden, es rapido para buscar

        coleccionSet.add(1);
        coleccionSet.add(1);
        coleccionSet.add(2);
        coleccionSet.add(2);

        System.out.println(coleccionSet.size());

        System.out.println(coleccionSet.contains(2));
        coleccionSet.remove(2);

        System.out.println(coleccionSet); //no se garantiza ningún orden de los elementos.

        //Ejercicio 3.2----------------------------------------------------------------------------
        ArrayDeque<Integer> cola = new ArrayDeque<>();        

        cola.addFirst(6);
        cola.addLast(7);
        cola.addFirst(2);
        cola.addLast(3);

        System.out.println(cola.removeFirst());
        System.out.println(cola.removeLast());

        System.out.println(cola);

        //Ejercicio 4.1----------------------------------------------------------------------------
        HashMap<Integer,String> usuarios = new HashMap<>();

        usuarios.put(1,"Cecilia");
        usuarios.put(2,"Daniela");
        usuarios.put(3,"Daniel");

        System.out.println("Usuario 1: "+ usuarios.get(1));

        usuarios.replace(2,"Salomon");

        usuarios.remove(1);

        System.out.println(usuarios);
 
        //Ejercicio 4.2----------------------------------------------------------------------------
        TreeMap <Integer,String> usuarios2 = new TreeMap<>();

        usuarios2.put(3,"Mariana");
        usuarios2.put(1,"Veronica");
        usuarios2.put(2,"Sebastian");
        usuarios2.put(4,"Lidia");

        System.out.println("EL usuario 1 es: " + usuarios2.get(1));

        usuarios2.replace(3, "Eliana");

        usuarios2.remove(4);

        System.out.println(usuarios2);

        usuarios2.keySet();

        for (Integer id : usuarios2.keySet()) {
            System.out.println(id);
            
        }

        //Ejercicio 5.1----------------------------------------------------------------------------
        ArrayList<Empleado> listaEmpleados = new ArrayList<>();

        listaEmpleados.add(new Empleado("Raul",55));
        listaEmpleados.add(new Empleado("Jorge", 32));
        listaEmpleados.add(new Empleado("Natalia",45));

        System.out.println("Lista de empleados: " + listaEmpleados);

        Collections.sort(listaEmpleados);

        listaEmpleados.toString();

        //Ejercicio 5.2----------------------------------------------------------------------------
        System.out.println("Lista original:");
        System.out.println(listaEmpleados);

        System.out.println("Orden por edad:");
        Collections.sort(listaEmpleados);
        System.out.println(listaEmpleados);

        System.out.println("Orden por nombre:");
        Collections.sort(listaEmpleados, new ComparadorNombre());
        System.out.println(listaEmpleados);

        
    } 
}
