public class Reporte {

    public Reporte(){}

    public void generarEncabezado(){
        System.out.println("=====ENCABEZADO=====");
    }

    public String obtenerCuerpo(){
        return "Este es el cuerpo del reporte";
    }

    public void mostrarSecciones(String... secciones){
        for (String s: secciones) {
            System.out.println(s);
        }
        if (secciones.length == 0){
            System.out.println("No hay Secciones");
        }
    }
}