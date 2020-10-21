package demo.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import demo.model.Producto;
import demo.model.Stock;


/**
* Esta interface define las Query asociada a stock
* @author grupo4
* @version Octubre 21, 2020
*/

public interface StockRepository extends JpaRepository<Stock, Long> {
	
	/**
	* Metodo que devuelve un producto especifico
	* @param id El parametro id es el id del producto a solicitar.
	* @return Producto.
	*/
	
	   @Query("select p FROM Producto p where p.id =:id")
	    public Producto getProducto(Long id);

}
