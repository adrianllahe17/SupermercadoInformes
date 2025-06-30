package conexionBD;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * Clase para gestionar las propiedades de configuración de la base de datos.
 * Lee las propiedades desde el archivo "configuration.properties".
 */
public abstract class Propiedades {
    // Objeto para almacenar las propiedades de configuración
    private static Properties props = new Properties();

    // Bloque estático para cargar las propiedades al inicio de la aplicación
    static {
        try (FileInputStream input = new FileInputStream("configuration.properties")) {
            props.load(input);
        } catch (Exception e) {
            // Manejo de excepciones en caso de error al cargar las propiedades
            e.printStackTrace();
        }
    }

    /**
     * Obtiene el valor asociado a la clave proporcionada desde las propiedades de configuración.
     *
     * @param clave Clave para buscar el valor en las propiedades.
     * @return Valor asociado a la clave.
     * @throws RuntimeException Si la clave no está disponible en configuration.properties.
     */
    public static String getValor(String clave) {
        String valor = props.getProperty(clave);
        if (valor != null) {
            return valor;
        }
        // Lanzar una excepción si la clave no está disponible
        throw new RuntimeException("La clave solicitada en configuration.properties no está disponible");
    }
}
