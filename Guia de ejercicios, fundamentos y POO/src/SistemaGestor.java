/**
 * Esta clase representa un sistema básico para la gestión de usuarios y 
 * configuraciones globales dentro de la aplicación.
 * Permite manejar constantes de conexión y visualizar datos de estado.
 */

public class SistemaGestor {
    int usuario = 5; // Variable local que representa la cantidad de usuarios logueados actualmente
    
    /*
     * Bloque de configuración inicial:
     * Aquí se definen las constantes del sistema.
     * MAX_CONEXIONES define el límite de usuarios simultáneos.
     */
    
    public static final int MAX_CONEXIONES = 10; //Es static porque pertenece a la clase, es final porque su valor no cambia

    public void mostrarDatos (){
        System.out.println("El valor Máximo de conexiones es: " + MAX_CONEXIONES);
    }
}