package empresadb;

import java.sql.Connection; //"voy a usar conexiones a base de datos"
import java.sql.DriverManager; //Sirve para abrir la conexión con MySQL.
import java.sql.SQLException; //Sirve por si ocurre algún error.
                              //Como contraseña incorrecta, MySQL apagado, base inexistente, etc.

public class ConexionDB { //Ejercicio 3: sirve para abrir la conexión entre Java y la base de datos.
                          //"Java, conectate a esta base MySQL usando esta URL, este usuario y esta contraseña"
    private static final String URL = //tipo de conexión - localhost: mi propia PC. 3306 puerto donde escucha MySQL + la base que cree.
            "jdbc:mysql://localhost:3306/empresa_db";

    private static final String USUARIO =
            "root";

    private static final String PASSWORD =
            "123";

    public static Connection conectar() {

        Connection conexion = null; //se crea una variable donde se guardará la conexión.

        try {

            conexion = DriverManager.getConnection( //acá Java intenta conectarse.
                    URL,                            //Si todo sale bien: entra. Si algo falla: lanza error.
                    USUARIO,
                    PASSWORD
            );

            System.out.println("Conexión exitosa");

        } catch (SQLException e) {

            System.out.println(
                    "Error de conexión: " + e.getMessage()
            );

        }

        return conexion;
    }
}