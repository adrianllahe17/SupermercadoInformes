package model;
/**
 * La clase Producto representa un artículo en un inventario.
 * Contiene información como código, nombre, precio y disponibilidad.
 */
public class Producto {

	private String codigo, nombre, precio;
	private int disponible;
	
	
	public Producto(String codigo, String nombre, String precio, int disponible) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.precio = precio;
		this.disponible = disponible;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public int getDisponible() {
		return disponible;
	}

	public void setDisponible(int disponible) {
		this.disponible = disponible;
	}
	
	
	
	
}
