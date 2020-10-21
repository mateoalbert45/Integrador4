package demo.repository;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import demo.model.Cliente;

/**
* Esta interface define las Query asociada al cliente
* @author grupo4
* @version Octubre 21, 2020
*/

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
	/**
	* Metodo que devuelve el gasto segun su cliente
	* @param id El parametro id es el id del cliente a calcular sus gastos.
	* @return int.
	*/
	
	   @Query("select SUM(p.precio) from Cliente cl join cl.compras co join co.productos p where cl.id =:id")
	    public int  gastosSegunCliente(Long id);
	   
//	   @Query("select SUM(co.precio*cantidad) from cliente cl join cl.compra co join co.producto p where cl.id :=id ")
//	    public int  compraSegunCliente(Long id);
	
	/**
	* Metodo que devuelve el total de ventas de un producto
	* @param idProducto El parametro idProducto es el id del producto a calcular.
	* @param fecha El parametro fecha es la fecha del producto.
	* @param idCliente El parametro idCliente es el id del cliente a calculas sus compras.
	* @return int.
	*/
	   
		@Query("select count(p.id) FROM Cliente cl join cl.compras c join c.productos p where p.id =:idProducto and cl.id =:idCliente and c.fechaDeCompra =:fecha group by p")
		public int ventasProducto(Long idProducto,String fecha,Long idCliente);
		
	
	
	/**
	* Metodo que elimina una compra
	* @param idCompra El parametro idCompra es el id de la compra a eliminar.
	*/
		
		@Query("delete FROM Compra c where c.id =:idCompra")
		public void eliminarCompra(long idCompra);
}
