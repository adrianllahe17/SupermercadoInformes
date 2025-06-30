package controller;

import java.util.ResourceBundle;

import javax.print.DocFlavor.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;


import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;


/**
 * Controlador para la interfaz gráfica de usuario asociada al visor de ayuda en línea.
 */
public class VisorAyudaOnlineController implements Initializable {
	@FXML
	private WebView visor;
	private WebEngine webEngine;

	//SE QUE HAY DOS METODOS IGUALES PERO SI BORRO UNO DE ELLOS LA AYUDA ONLINE NO FUNCIONA
	
	
	 /**
     * Método que se ejecuta automáticamente al inicializar el controlador de la interfaz gráfica.
     * Carga la página web de introducción a JavaFX desde la documentación oficial de Oracle.
     *
     * @param arg0 URL base para la ubicación del recurso.
     * @param arg1 Recursos específicos de la localización.
     */
	
	// Método que se ejecuta automáticamente al inicializar el controlador de la interfaz gráfica.
	public void initialize(URL arg0, ResourceBundle arg1) {
	    // Se obtiene la instancia del motor de navegación (webEngine) del WebView (visor).
	    webEngine = visor.getEngine();

	    // Se carga la página web de introducción a JavaFX desde la documentación oficial de Oracle.
	    webEngine.load("https://docs.oracle.com/javafx/2/get_started/hello_world.htm");
	}


	@Override
	public void initialize(java.net.URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		webEngine = visor.getEngine();
		webEngine.load("https://docs.oracle.com/javafx/2/get_started/hello_world.htm");	
	}


	
}


