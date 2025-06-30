package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.input.MouseEvent;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import model.Help;

/**
 * Controlador para la interfaz gráfica de usuario asociada al visor de ayuda.
 */

public class VisorAyudaController implements Initializable {
	@FXML
	private TreeView<Help> arbol;
	@FXML
	private WebView visor;
	private WebEngine webEngine;

	 /**
     * Método que se ejecuta automáticamente al inicializar el controlador de la interfaz gráfica.
     * Configura el árbol de ayuda y el visor, mostrando el contenido inicial.
     *
     * @param arg0 URL base para la ubicación del recurso.
     * @param arg1 Recursos específicos de la localización.
     */
	@Override
	// Método que se ejecuta automáticamente al inicializar el controlador de la interfaz gráfica.
	public void initialize(URL arg0, ResourceBundle arg1) {
	    // Creamos el árbol del panel de la izquierda, el índice
	    TreeItem<Help> rItem = new TreeItem<Help>(new Help("Raiz", ""));
	    
	    // Creamos nodos secundarios para el árbol con información de ayuda.
	    TreeItem<Help> r1Item = new TreeItem<Help>(new Help("AdrianV1", "adrianv1.html"));
	    rItem.getChildren().add(r1Item);
	    
	    TreeItem<Help> r2Item = new TreeItem<Help>(new Help("AdrianV2", "adrianv2.html"));
	    rItem.getChildren().add(r2Item);

	    // Configuramos el árbol con la raíz y ocultamos el nodo raíz.
	    arbol.setRoot(rItem);
	    arbol.setShowRoot(false);

	    // Mostramos el contenido inicial en el visor de la derecha.
	    webEngine = visor.getEngine();
	    webEngine.load(getClass().getResource("/help/html/adrianv1.html").toExternalForm());

	    // Añadimos un evento para cambiar de html al pinchar en el árbol.
	    arbol.setOnMouseClicked(new EventHandler<MouseEvent>() {
	        @Override
	        public void handle(MouseEvent event) {
	            // Verificamos si se ha seleccionado un elemento en el árbol.
	            if (arbol.getSelectionModel().getSelectedItem() != null) {
	                Help elemento = (Help) arbol.getSelectionModel().getSelectedItem().getValue();
	                // Verificamos si el elemento tiene un archivo HTML asociado y lo cargamos en el visor.
	                if (elemento.getHtml() != null) {
	                    loadHelp(elemento.getHtml(), elemento.isLocal());
	                }
	            }
	        }
	    });
	}

	
	 /**
     * Método para cargar un archivo HTML en el visor.
     *
     * @param file  Nombre del archivo HTML.
     * @param local Indica si el archivo debe cargarse de manera local.
     */

	// Método para cargar un archivo HTML en el visor.
	private void loadHelp(String file, boolean local) {
	    // Verificamos si el visor es diferente de nulo.
	    if (visor != null) {
	        // Verificamos si se debe cargar el archivo de manera local o remota.
	        if (local) {
	            // Cargamos el archivo HTML desde el directorio local.
	            webEngine.load(getClass().getResource("/help/html/" + file).toExternalForm());
	        } else {
	            // Cargamos el archivo HTML desde una ubicación remota.
	            webEngine.load(file);
	        }
	    }
	}

}