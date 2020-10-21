package demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

/**
* Esta clase define la entidad de un cliente
* @author grupo4
* @version Octubre 21, 2020
*/

@Entity
@Data
public class Cliente {
	@Id
	private Long id;
	@Column
	private String nombre;
	@JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "idCompra", referencedColumnName = "id")
	private List<Compra> compras;
	
	
	/**
	* Constructor de la clase Cliente. Inicializa un cliente vacio.
	*/
	
   	 public Cliente() {} 
    
	/**
	* Constructor de la clase Cliente. Inicializa un cliente con id, nombre y sus compras.
	*/
	
	public Cliente(Long id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.compras = new ArrayList<Compra>();
	} 
	
	
	/**
	* Metodo que agrega una compra al cliente
	* @param c El paramtro c es la compra que realizo el cliente.
	*/
	
	public void add(Compra c) {
		compras.add(c);
	}
	
	/**
	* Metodo que elimina una compra existente de la lista de compras del cliente
	* @param c El paramtro c es la compra a eliminar.
	*/
	
	public void remove(Compra c) {
		compras.remove(c);
	}
	
}
