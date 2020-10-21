package demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;


/**
* Esta clase define la entidad de un producto
* @author grupo4
* @version Octubre 21, 2020
*/

@Entity
@Data
public class Producto{
	@Id
	private Long id;
	@Column
	private String nombre;
	@Column
	private double precio;
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "idStock", referencedColumnName = "id")
//    private Stock stock;
	
	
	/**
	* Constructor de la clase Producto. Inicializa un producto vacio.
	*/
	
	public Producto() {}
	
	/**
	* Constructor de la clase Producto. Inicializa un producto con un id, un nombre y un precio.
	*/
	
	public Producto(Long id, String nombre, double precio) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
	}
	
	
//	public void setStock(Stock stock) {
//		
//	}
	
	/**
	* Metodo que setea el nombre de un producto
	* @param nombre El paremtro nombre es el nuevo nombre asignado.
	*/
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	* Metodo que devuelve el nombre del producto
	* @return String.
	*/
	
	public String getNombre() {
		return this.nombre;
	}
	
	/**
	* Metodo que setea el precio de un producto.
	* @param precio El parametro precio es el nuevo precio del producto.
	*/
	
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	/**
	* Metodo que devuelve el precio del producto.
	* @return Double.
	*/
	
	public double getPrecio() {
		return this.precio;
	}

	/**
	* Metodo que compara dos tipos de productos
	* @return True o False.
	*/
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (Double.doubleToLongBits(precio) != Double.doubleToLongBits(other.precio))
			return false;
		return true;
	}

}

