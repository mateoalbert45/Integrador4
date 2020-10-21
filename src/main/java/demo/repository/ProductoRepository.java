package demo.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import demo.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

//	   @Query("delete FROM Stock s join s.producto p where p.id =:idProducto")
//	    public void borrarStockProducto(long idProducto);
	   
	   @Query("select c.productos FROM Compra c")
	    public List<Producto> productos();
	 
	   
	   @Query("select p FROM Compra c join c.productos p group by p order by count(p.id)DESC ")
	    public List<Producto> cantidadProducto();
	   

}


