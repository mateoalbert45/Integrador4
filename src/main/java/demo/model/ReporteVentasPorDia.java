package demo.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
* Esta clase define la entidad del reporte de ventas por dia
* @author grupo4
* @version Octubre 21, 2020
*/

public class ReporteVentasPorDia {

	private String fecha;
	
	private List<Compra> compras;

	/**
	* Constructor de la clase ReporteVentasPorDia. Inicializa el reporte de ventas por dia con una fecha en null y una lista de compras
	*/
	
	public ReporteVentasPorDia() {
		this.fecha = null;
		this.compras = new ArrayList<>();
	}
	
	/**
	* Metodo devuelve la fecha del reporte.
	* @return String.
	*/
	
	public String getFecha() {
		return fecha;
	}

	/**
	* Metodo setea la fecha del reporte.
	* @param fecha El parametro fecha es la nueva fecha del reporte.
	*/
	
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	/**
	* Metodo que devuelve una lsita con las compras realizadas en el dia.
	* @return List de objetos de tipo compra.
	*/

	public List<Compra> getCompra() {
		return compras;
	}
	
	/**
	* Metodo que agrega una nueva compra.
	* @param c El parametro c es compra a agregar en la lista.
	*/
	
	public void addCompra(Compra c) {
		this.compras.add(c);
	}

}
