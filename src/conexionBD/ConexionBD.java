package conexionBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.TimeZone;

/**
 * Clase para gestionar la conexión a la base de datos.
 */
public class ConexionBD {
    // Objeto de conexión a la base de datos
    private Connection conexion;

    /**
     * Constructor de la clase. Establece la conexión a la base de datos usando las propiedades configuradas.
     *
     * @throws SQLException Si hay algún problema durante la conexión.
     */
    public ConexionBD() throws SQLException {	
        // Obtener la URL de conexión desde las propiedades y ajustar la zona horaria
        String url = Propiedades.getValor("url") + "?serverTimezone=" + TimeZone.getDefault().getID();
        String user = Propiedades.getValor("user");
        String password = Propiedades.getValor("password");

        // Establecer la conexión a la base de datos
        conexion = DriverManager.getConnection(url, user, password);
        // Configurar la conexión para que realice auto commit
        conexion.setAutoCommit(true);
    }

    /**
     * Obtiene la conexión actual a la base de datos.
     *
     * @return Objeto de conexión a la base de datos.
     * @throws SQLException Si hay algún problema al obtener la conexión.
     */
    public Connection getConexion() throws SQLException {
        return conexion;
    }

    /**
     * Cierra la conexión a la base de datos.
     *
     * @throws SQLException Si hay algún problema al cerrar la conexión.
     */
    public void cerrarConexion() throws SQLException {
        conexion.close();
    }
}
