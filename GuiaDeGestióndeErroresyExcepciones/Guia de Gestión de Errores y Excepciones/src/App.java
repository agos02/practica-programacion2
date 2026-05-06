import java.io.BufferedReader; // para
import java.io.FileReader;     //ejercicio 
import java.io.IOException;    //4

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Guia de Gestión de Errores y Excepciones");

        //Ejercicio 1.1-----------------------------------------------------------------------------
        try {
            Integer.parseInt("Agos");
            
        } catch (NumberFormatException e) {
            System.out.println("Mensaje del error: " + e.getMessage());
            System.out.println("Tipo de excepcion: " + e.getClass().getName());
        }
    
        //1.2
        division();

        transformarStringEntero("Agostina");//1.3

        registrarUsuario("Cecilia", 30);//2.1
        registrarUsuario("Lola", 10);

        //2.2
        try {   
        registrarUsuario2("Liss", -5);
        }
        catch (IllegalArgumentException e) {
        System.out.println(e.getMessage());
        }

        //3.1
        CuentaBancaria cuenta = new CuentaBancaria(500); 
        try {
            cuenta.retirar(1000);
        } catch (SaldoInsuficienteException e) {
            System.out.println(e.getMessage());
        }


        //3.2
        Producto producto = new Producto("Lapicera", 2000);



        //Ejercicio 4
        try (BufferedReader br = new BufferedReader(new FileReader("src/Personas.txt"))) {

            String linea;

            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }

        } catch (IOException e) {
            System.out.println("Error al procesar el archivo.");
        }
        
    }
  


    //Ejercicio 1.2-----------------------------------------------------------------------------
        public static void division(){
        
            try {
                int resultado = 10/0;
                
            } catch (ArithmeticException e) {
                System.out.println("Mensaje del error: " + e.getMessage());
                System.out.println("Tipo de exception: " + e.getClass().getName());
               
            }
            finally{
                System.out.println("Limpieza final!");
            }
        }
    //Ejercicio 1.3-----------------------------------------------------------------------------
    public static void transformarStringEntero(String texto){
        try{
     
            int numero = Integer.parseInt(texto);
            int operacion = 100/numero;


        }
        catch(NumberFormatException | ArithmeticException e){
            System.out.println("Error de cálculo o conversión.");
        }
    }
    
    //Ejercicio 2.1-----------------------------------------------------------------------------
    public static void registrarUsuario(String nombre, int edad){
        if(nombre == null || nombre.isBlank()){
            throw new IllegalArgumentException("Nombre completado incorrectamente!!");
        }
        if(edad < 0){
            throw new IllegalArgumentException("Esa edad no es valida!!");
        }
        else{
            System.out.println("Usuario registrado con exito!");
        }
    }

    //Ejercicio 2.2-----------------------------------------------------------------------------
    public static void registrarUsuario2(String nombre, int edad){
        if(nombre == null || nombre.isBlank()){
            throw new IllegalArgumentException("El nombre de un usuario no puede estar vacio o contener espacios.");
        }
        if(edad < 0){
            throw new IllegalArgumentException("La edad de un usuario no puede ser negativa.");
        }
        else{
            System.out.println("Usuario registrado con exito!");
        }
    }
    }
