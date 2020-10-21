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
    
    public Stock() {} 
    
	public Stock(Long id, Producto producto, int cantidad) {
		super();
		this.id = id;
		this.producto = producto;
		this.cantidad = cantidad;
	}
    
	
	public void add(Producto p) {
		producto = p;
	}
    
    
}
