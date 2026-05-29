package empresadb;

import java.sql.*;
import java.util.ArrayList;

public class EmpleadoDAO implements OperacionesDAO {

   @Override
public void insertar(Empleado empleado) {
    String sql = "INSERT INTO empleados(nombre, id_depto, foto) VALUES (?, ?, ?)";
    try (
        Connection conn = ConexionDB.conectar();
        PreparedStatement pstmt = conn.prepareStatement(sql)
    ) {
        pstmt.setString(1, empleado.getNombre());
        pstmt.setInt(2, empleado.getIdDepto());
        pstmt.setString(3, empleado.getFoto());

        pstmt.executeUpdate();

        System.out.println("Empleado insertado correctamente");

    } catch (SQLException e) {
        System.out.println("Error al insertar: " + e.getMessage());
    }
}

   @Override
public void actualizar(Empleado empleado) {
    String sql = "UPDATE empleados SET nombre=?, id_depto=?, foto=? WHERE id=?";
    try (
        Connection conn = ConexionDB.conectar();
        PreparedStatement pstmt = conn.prepareStatement(sql)
    ) {
        pstmt.setString(1, empleado.getNombre());
        pstmt.setInt(2, empleado.getIdDepto());
        pstmt.setString(3, empleado.getFoto()); // NUEVO
        pstmt.setInt(4, empleado.getId());

        pstmt.executeUpdate();

        System.out.println("Empleado actualizado");

    } catch (SQLException e) {
        System.out.println("Error al actualizar: " + e.getMessage());
    }
}


    @Override
    public void eliminar(int id) {

        String sql = "DELETE FROM empleados WHERE id=?";

        try (
            Connection conn = ConexionDB.conectar();
            PreparedStatement pstmt = conn.prepareStatement(sql)
        ) {

            pstmt.setInt(1, id);

            pstmt.executeUpdate();

            System.out.println("Empleado eliminado");

        } catch (SQLException e) {
            System.out.println("Error al eliminar: " + e.getMessage());
        }
    }

    @Override
    public ArrayList<Empleado> consultarTodos() {

        ArrayList<Empleado> lista = new ArrayList<>();

        String sql =
        "SELECT e.id, e.nombre, d.nombre_depto, e.foto  " +
        "FROM empleados e " +
        "INNER JOIN departamentos d ON e.id_depto = d.id_depto";

        try (
            Connection conn = ConexionDB.conectar();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery()
        ) {

            while (rs.next()) {

                Empleado empleado = new Empleado();

                empleado.setId(rs.getInt("id"));
                empleado.setNombre(rs.getString("nombre"));
                empleado.setDepartamento(rs.getString("nombre_depto"));
                empleado.setFoto(rs.getString("foto"));
                lista.add(empleado);
            }

        } catch (SQLException e) {
            System.out.println("Error al consultar: " + e.getMessage());
        }

        return lista;
    }
}