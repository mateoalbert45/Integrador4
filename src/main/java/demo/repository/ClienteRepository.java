package demo.repository;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import demo.model.Cliente;
import demo.model.Compra;
import demo.model.Producto;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
	   @Query("select SUM(p.precio) from Cliente cl join cl.compras co join co.productos p where cl.id =:id")
	    public int  gastosSegunCliente(Long id);
	   
//	   @Query("select SUM(co.precio*cantidad) from cliente cl join cl.compra co join co.producto p where cl.id :=id ")
//	    public int  compraSegunCliente(Long id);
	   
		@Query("select count(p.id) FROM Cliente cl join cl.compras c join c.productos p where p.id =:idProducto and cl.id =:idCliente and c.fechaDeCompra =:fecha group by p")
		public int ventasProducto(Long idProducto,String fecha,Long idCliente);
		
		@Query("select c.productos FROM Compra c join c.productos p where c.id =:idCompra")
		public List<Producto> getProductosSegunCompra(Long idCompra);
		
		
		@Query("delete FROM Compra c where c.id =:idCompra")
		public void eliminarCompra(long idCompra);
		
		@Query("select c FROM Compra c where c.id =:idCompra")
		public Compra getCompra(long idCompra);
}
