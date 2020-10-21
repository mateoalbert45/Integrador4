package demo.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReporteVentasPorDia {

	private String fecha;
	
	private List<Compra> compras;

	public ReporteVentasPorDia() {
		this.fecha = null;
		this.compras = new ArrayList<>();
	}
	
	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public List<Compra> getCompra() {
		return compras;
	}
	
	public void addCompra(Compra c) {
		this.compras.add(c);
	}

}
