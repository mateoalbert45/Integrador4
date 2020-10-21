package demo.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

/**
* Esta clase define la entidad de una compra
* @author grupo4
* @version Octubre 21, 2020
*/

@Entity
@Table(name = "compra")
@Data
public class Compra{
	@Id
	private Long id;
	@Column
	private String fechaDeCompra;
	@JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "idProducto", referencedColumnName = "id")
	private List<Producto> productos;
	
	
	/**
	* Constructor de la clase Compra. Inicializa compra en vacio.
	*/
	
	public Compra() {}
	
	/**
	* Constructor de la clase Compra. Inicializa compra con un id, una fecha de cuando se realizo y la lista de los productos de esa compra.
	*/
	
	public Compra(Long id,String fechaDeCompra) {
		super();
		this.id = id;
		this.fechaDeCompra = fechaDeCompra;
		this.productos = new ArrayList<Producto>();
	}
	
	/**
	* Metodo que agrega un producto a la compra.
	* @param p El parametro p es el producto a agregar.
	*/
	
	public void add(Producto p) {
		productos.add(p);
	}
	
	/**
	* Metodo que compara dos productos
	* @param obj El parametro obj es el objeto con el cual se va a comparar
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
		Compra other = (Compra) obj;
		if (fechaDeCompra == null) {
			if (other.fechaDeCompra != null)
				return false;
		} else if (!fechaDeCompra.equals(other.fechaDeCompra))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (productos == null) {
			if (other.productos != null)
				return false;
		} else if (!productos.equals(other.productos))
			return false;
		return true;
	}

	/**
	* Metodo que devuelve la informacion de un producto.
	* @return hashCode.
	*/
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fechaDeCompra == null) ? 0 : fechaDeCompra.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((productos == null) ? 0 : productos.hashCode());
		return result;
	}
	
	
	

}
