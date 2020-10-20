package demo.model;

public class ReporteGastosCliente {

	private Long id;
	
	private Cliente cliente;
	
	private int gastos;

	public ReporteGastosCliente() {
		this.id = (long) 0;
		this.cliente = null;
		this.gastos = 0;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public int getGastos() {
		return gastos;
	}

	public void setGastos(int gasto) {
		this.gastos = gasto;
	}
	
	
	
	
	
	
	
}
