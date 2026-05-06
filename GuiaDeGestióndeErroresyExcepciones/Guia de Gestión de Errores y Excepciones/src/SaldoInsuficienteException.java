//Ejercicio 3.1
public class SaldoInsuficienteException extends Exception{
    String mensaje;

public SaldoInsuficienteException (String mensaje){
    super(mensaje);
}
}
