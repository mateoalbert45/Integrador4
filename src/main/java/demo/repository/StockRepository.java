package demo.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import demo.model.Producto;
import demo.model.Stock;

public interface StockRepository extends JpaRepository<Stock, Long> {
	
	   @Query("select p FROM Producto p where p.id =:id")
	    public Producto getProducto(Long id);

}
