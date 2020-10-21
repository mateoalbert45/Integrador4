package demo.repository;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import demo.model.Cliente;
import demo.model.Compra;


/**
* Esta interface define las Query asociada a compra
* @author grupo4
* @version Octubre 21, 2020
*/

public interface CompraRepository extends JpaRepository<Compra, Long> {
	   
	/**
	* Metodo que devuelve una lista con los productos de esta compra
	* @return List con objetos de tipo compra
	*/
	
	@Query("select c from Compra c order by c.fechaDeCompra")
	    public List<Compra>  comprasOrdenFecha();

	/**
	* Metodo que devuelve las compras realizadas en el dia
	* @param fechaCompra El parametro fechaCompra es la fecha que se realizo la compra.
	* @param id El parametro id es el id del Cliente 
	* @return List con objetos de tipo compra
	*/
	
	@Query("select c.compras from Cliente c where id =: id and fechaDeCompra =: fechaCompra ")
	public List<Compra> cantidadDeCompras(String fechaCompra, Long id);
	
	/**
	* Metodo que devuelve el total de ventas de un producto
	* @param idProdcuto El parametro idProducto es el id del producto a calcular sus ventas.
	* @param idCliente El parametro idCliente es el id del cliente que realizo la compra. 
	* @return int.
	*/
	
	@Query("select count(p.id) FROM Cliente cl join cl.compras c join c.productos p where p.id =:idProducto and cl.id =:idCliente group by p")
	public int ventasProducto(Long idProducto,Long idCliente);

	
	/**
	* Metodo que devuelve un cliente
	* @param idCliente El parametro idCliente es el id del cliente a devolver. 
	* @return Cliente.
	*/
	
	@Query("select c FROM Cliente c where c.id =:idCliente ")
	public Cliente recuperarCLiente(Long idCliente);
}
