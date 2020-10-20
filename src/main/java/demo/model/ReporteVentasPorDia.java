package demo.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReporteVentasPorDia {

	private Date fecha;
	
	private List<Compra> compras;

	public ReporteVentasPorDia() {
		this.fecha = null;
		this.compras = new ArrayList<>();
	}
	
	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public List<Compra> getCompra() {
		return compras;
	}
	
	public void addCompra(Compra c) {
		this.compras.add(c);
	}

}
