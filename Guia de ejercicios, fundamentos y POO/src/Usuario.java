public class Usuario {
    private String nombre;
    private int edad;
    private String correo;
    private int telefono;

    //Constructor
    public Usuario () {
    }

    //Sobrecarga de constructor
    public Usuario (String nombre){
        this.nombre = nombre;
    }

    public Usuario (String nombre, int edad){
        this.nombre = nombre;
        this.edad = edad;
    }

    public void actualizarPerfil(String correo){
        System.out.println("Su correo es: " + correo);
    }

    public void actualizarPerfil(String correo, int telefono){
        System.out.println("Su correo es: " + correo);
        System.out.println("Su teléfono: " + telefono);
    }
}