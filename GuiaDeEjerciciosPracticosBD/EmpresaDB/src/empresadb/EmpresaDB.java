package empresadb;
import java.util.ArrayList;

public class EmpresaDB {

    public static void main(String[] args) {

        EmpleadoDAO dao = new EmpleadoDAO();

        // INSERTAR Guarda el empleado en MySQL.
        Empleado emp1 = new Empleado();
        emp1.setNombre("Ana García");
        emp1.setIdDepto(1); // Recursos Humanos (ID real)
        dao.insertar(emp1);

        // CONSULTAR
        ArrayList<Empleado> lista = dao.consultarTodos();

        System.out.println("Lista de empleados:");

        for (Empleado e : lista) {
            System.out.println(
                e.getId() + " - " +
                e.getNombre() + " - " +
                e.getDepartamento()
            );
        }

        // ACTUALIZAR
        Empleado actualizado = new Empleado();
        actualizado.setId(1);
        actualizado.setNombre("Ana García");
        actualizado.setIdDepto(2); // Finanzas
        dao.actualizar(actualizado);
        dao.actualizar(actualizado);

        // ELIMINAR
        // dao.eliminar(1);
        
    }
}