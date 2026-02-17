import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseConexion {
    private String url = "jdbc:mysql://mysql-sdfm:27470/defaultdb?useSSL=true";
    private String user = "root"; // Tu usuario
    private String pass = ""; // Tu contraseña

    public List<Miembro> obtenerMiembros() {
        List<Miembro> lista = new ArrayList<>();
        String query = "SELECT * FROM miembros";

        try (Connection conn = DriverManager.getConnection(url, user, pass);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                lista.add(new Miembro(
                    rs.getInt("member_id"),
                    rs.getInt("age"),
                    rs.getString("gender"),
                    rs.getString("membership_type")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}