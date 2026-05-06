//ejercicio 3.2
public class Producto {
    String nombreProducto;
    double precio;

public Producto (String nombreProducto, double precio){
    this.nombreProducto = nombreProducto;
    this.precio = precio;
    
    if (precio <= 0 ){
         throw new ProductoInvalidoException("El precio del producto no puede ser negativo o 0.");
    }
}
}
