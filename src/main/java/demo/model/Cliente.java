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
	
    public Cliente() {} 
    
	public Cliente(Long id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.compras = new ArrayList<Compra>();
	} 
	
	public void add(Compra c) {
		compras.add(c);
	}
	
	public void remove(Compra c) {
		compras.remove(c);
	}
	
}
