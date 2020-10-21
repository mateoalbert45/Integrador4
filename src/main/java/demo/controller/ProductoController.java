package demo.controller;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.model.Producto;
import demo.repository.ProductoRepository;


/**
* Esta clase administra los servicios rest de los productos
* @author grupo4
* @version Octubre 21, 2020
*/


@RestController
@RequestMapping("producto")
public class ProductoController {
	@Qualifier("productoRepository")
	@Autowired
	private final ProductoRepository repository;

	/**
	* Constructor de la clase ProductoController. Inicializa el repository
	*/
	
	public ProductoController(@Qualifier("productoRepository") ProductoRepository repository) {
		this.repository = repository;
	}

	/**
	* Metodo que devuelve todos los productos.
	* @return Iterable de objetos de tipo producto
	*/
	
	@GetMapping("/getAll")
	public Iterable<Producto> getProductos() {
		return repository.findAll();
	}
	
	/**
	* Metodo que devuelve un producto segun el id
	* @param id El parametro id es el id del producto a devolver 
	* @return Optional de objetos de tipo producto.
	*/
	
	@GetMapping("/get/{id}")
	public Optional<Producto> getProducto(@PathVariable Long id) {
		return repository.findById(id);
	}
	
	/**
	* Metodo que devuelve el producto que fue mas vendido
	* @return Producto.
	*/
	
	@GetMapping("/masVendido")
	public Producto getProductoMasVendido() {
		List<Producto> productos = repository.productos();
		Producto productoMasVendido = new Producto();
		productos = repository.cantidadProducto();
		productoMasVendido = productos.get(0);
		return productoMasVendido;
	}
	
	/**
	* Metodo que inserta un nuevo producto.
	* @param p El parametro p es el nuevo producto a guardar en la base de datos.
	* @return Producto.
	*/
	
	 @PostMapping("/add") public Producto newProducto(@RequestBody Producto p) {
	 return repository.save(p);
	 }
	
	/**
	* Metodo que actualiza un producto ya existente
	* @param p El parametro p es el producto actualizado
	* @param id El parametro id es el id del producto a actualizar
	* @return Producto.
	*/
	 
	 @PutMapping("/update/{id}") public Producto updateProducto(@RequestBody Producto p, @PathVariable Long id) {
	        return repository.findById(id)
	                .map(producto -> {
	                    producto.setNombre(p.getNombre());
	                    producto.setPrecio(p.getPrecio());
	                    return repository.save(producto);
	                })
	                .orElseGet(() -> {
	                    p.setId(id);
	                    return repository.save(p);
	                });
	 }
	 
//	@DeleteMapping("/delete/{id}")
//	 void deleteProducto(@PathVariable Long id) {
//		repository.deleteById(id);
//	       // repository.borrarStockProducto(id);
//	    }
	
	 
	 
}
