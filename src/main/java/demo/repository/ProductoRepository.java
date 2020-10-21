package demo.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import demo.model.Producto;

/**
* Esta interface define las Query asociada a producto
* @author grupo4
* @version Octubre 21, 2020
*/

public interface ProductoRepository extends JpaRepository<Producto, Long> {

//	   @Query("delete FROM Stock s join s.producto p where p.id =:idProducto")
//	    public void borrarStockProducto(long idProducto);
	   
	/**
	* Metodo que devuelve una lista de productos existentes
	* @return Una lista de objetos de tipo producto.
	*/
	
	   @Query("select c.productos FROM Compra c")
	    public List<Producto> productos();
	 
	   
	/**
	* Metodo que devuelve una lista de productos por cantidad
	* @return Una lista de objetos de tipo producto.
	*/
	
	   @Query("select p FROM Compra c join c.productos p group by p order by count(p.id)DESC ")
	    public List<Producto> cantidadProducto();
	   

}


