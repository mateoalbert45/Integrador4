package demo.model;

/**
* Esta clase define la entidad del reporte de los gastos del cliente
* @author grupo4
* @version Octubre 21, 2020
*/

public class ReporteGastosCliente {

	private Long id;
	
	private Cliente cliente;
	
	private int gastos;

	
	/**
	* Constructor de la clase ReporteGastosCliente. Inicializa el reporte de los gastos del cliente con un id, un cliente y los gastos
	*/
	
	public ReporteGastosCliente() {
		this.id = (long) 0;
		this.cliente = null;
		this.gastos = 0;
	}

	/**
	* Metodo que devuelve el id del reporte
	* @return Long.
	*/
	
	public Long getId() {
		return id;
	}

	/**
	* Metodo que setea el id del reporte
	* @param id El parametro id es el id del reporte a actualizar
	*/
	
	public void setId(Long id) {
		this.id = id;
	}

	
	/**
	* Metodo que devuelve el cliente del reporte
	* @return Cliente.
	*/
	
	public Cliente getCliente() {
		return cliente;
	}

	
	/**
	* Metodo que setea el cliente del reporte
	* @param cliente El parametro cliente es el cliente a setear del reporte.
	*/
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	/**
	* Metodo que devuelve el gasto total del reporte
	* @return int.
	*/
	
	public int getGastos() {
		return gastos;
	}

	/**
	* Metodo que setea los gastos del reporte
	* @param gasto El parametro gasto es el nuevo gasto de reporte.
	*/
	
	public void setGastos(int gasto) {
		this.gastos = gasto;
	}
	
	
	
	
	
	
	
}
