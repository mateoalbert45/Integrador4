package demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

/**
* Esta clase define la entidad del stock.
* @author grupo4
* @version Octubre 21, 2020
*/

@Entity
@Data
public class Stock {
	@Id
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idProducto", referencedColumnName = "id")
    private Producto producto;
    @Column
    private int cantidad;
    
	/**
	* Constructor de la clase Stock. Inicializa el stock en vacio.
	*/
	
    public Stock() {} 
    
	/**
	* Constructor de la clase Stock. Inicializa el stock con un id, un producto y la cantidad de ese producto.
	*/
	
	public Stock(Long id, Producto producto, int cantidad) {
		super();
		this.id = id;
		this.producto = producto;
		this.cantidad = cantidad;
	}
    
	
	/**
	* Metodo que agrega un producto
	* @param p El parametro p es el producto a agregar.
	*/
	
	public void add(Producto p) {
		producto = p;
	}
    
    
}
