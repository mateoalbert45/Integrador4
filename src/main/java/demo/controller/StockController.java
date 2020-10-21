package demo.controller;

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
import demo.model.Stock;
import demo.repository.StockRepository;


/**
* Esta clase administra los servicios rest del stock de los productos
* @author grupo4.
* @version Octubre 21, 2020
*/

@RestController
@RequestMapping("stock")
public class StockController  {
	

	
	@Qualifier("stockRepository")
    @Autowired
    private final StockRepository repository;
	
	/**
	* Constructor de la clase StockController. Inicializa el repository
	*/
	
	public StockController(@Qualifier("stockRepository") StockRepository repository) {
		this.repository = repository;
	}
	
	
	
	/**
	* Metodo que devuelve todo el stock hasta el momento
	* @return Iterable de objetos de tipo Stock
	*/
	
    @GetMapping("/getAll")
    public Iterable<Stock> getStocks() {
        return repository.findAll();
    }
    
	/**
	* Metodo que agrega un nuevo stock de un producto
	* @param s El parametro s es el nuevo stock a guardar.
	* @param id El parametro id es el id del producto al que se le guarda el stock. 
	* @return Stock.
	*/
	
    @PostMapping("/add/{id}")
    public Stock newStock(@RequestBody Stock s, @PathVariable Long id) {
    	Producto p = repository.getProducto(id);
    	s.add(p);
        return repository.save(s);
    }
    
	/**
	* Metodo que actualiza el stock de un producto
	* @param s El parametro s es el nuevo stock actualizado.
	* @param id El parametro id es el id del stock a actualizar. 
	* @return Stock.
	*/
	
	 @PutMapping("/update/{id}") public Stock updateStock(@RequestBody Stock s, @PathVariable Long id) {
	        return repository.findById(id)
	                .map(stock -> {
	                	stock.setCantidad(s.getCantidad());
	                    return repository.save(stock);
	                })
	                .orElseGet(() -> {
	                    s.setId(id);
	                    return repository.save(s);
	                });
	 }
	 
	/**
	* Metodo que elimina el stock de un producto
	* @param id El parametro id es el id del stock a eliminar.
	*/
	
	@DeleteMapping("/delete/{id}")
	 void deleteStock(@PathVariable Long id) {
	        repository.deleteById(id);
	    }
	
	
	/**
	* Metodo que resetea el stock de un producto
	* @param id El parametro id es el parametro del stock a resetear.
	* @return Stock.
	*/
	
	 @PutMapping("/restarStock/{id}") public Stock restarStock(@PathVariable Long id) {
		 	Optional<Stock> stock = repository.findById(id);
		 	if(stock.get().getCantidad()>0) {
		 		stock.get().setCantidad(stock.get().getCantidad()-1);
		 		repository.save(stock.get());
		 	}
		 	return stock.get();
	 }
 
	

}
