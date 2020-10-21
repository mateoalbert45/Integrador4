package demo.repository;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import demo.model.Cliente;
import demo.model.Compra;
import demo.model.Producto;


public interface CompraRepository extends JpaRepository<Compra, Long> {
	   
	@Query("select c from Compra c order by c.fechaDeCompra")
	    public List<Compra>  comprasOrdenFecha();

	@Query("select c.compras from Cliente c where id =: id and fechaDeCompra =: fechaCompra ")
	public List<Compra> cantidadDeCompras(String fechaCompra, Long id);
	
	@Query("select count(p.id) FROM Cliente cl join cl.compras c join c.productos p where p.id =:idProducto and cl.id =:idCliente group by p")
	public int ventasProducto(Long idProducto,Long idCliente);

	@Query("select c FROM Cliente c where c.id =:idCliente ")
	public Cliente recuperarCLiente(Long idCliente);
	
	   @Query("select p FROM Producto p where p.id =:id")
	    public Producto getProducto(Long id);
}
