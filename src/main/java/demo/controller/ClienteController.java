package demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.model.Cliente;
import demo.model.Compra;
import demo.model.Producto;
import demo.model.ReporteGastosCliente;
import demo.model.Stock;
import demo.repository.ClienteRepository;

@RestController
@RequestMapping("cliente")

/**
* Esta clase administra los servicios rest de los clientes.
* @author Grupo4
* @version Octubre 21, 2020
*/

public class ClienteController {
	 	@Qualifier("clienteRepository")
	    @Autowired
	    private final ClienteRepository repository;

		/**
		* Constructor de la clase ClienteController.
		*/
	
		public ClienteController(@Qualifier("clienteRepository") ClienteRepository repository) {
			this.repository = repository;
		}
	
			
		/**
		* Metodo que trae todos los clientes.
		* @return Iterador de clientes.
		*/ 
	
	    @GetMapping("/getAll")
	    public Iterable<Cliente> getClientes() {
	        return repository.findAll();
	    }
	    
		/**
		* Metodo que agrega un nuevo cliente.
		* @param c El parametro c es el objeto a agregar desde la web. 
		* @return Cliente.
		*/ 
	
	    @PostMapping("/add")
	    public Cliente newCliente(@RequestBody Cliente c) {
	        return repository.save(c);
	    }
	    
		/**
		* Metodo que modifica un cliente existente.
		* @param c El parametro c es el cliente a editar.
		* @param id El parametro id es el id del cliente a editar.
		* @return Cliente.
		*/
	
		 @PutMapping("/update/{id}") public Cliente updateCliente(@RequestBody Cliente c, @PathVariable Long id) {
		        return repository.findById(id)
		                .map(cliente -> {
		                	cliente.setNombre(c.getNombre());
		                    return repository.save(cliente);
		                })
		                .orElseGet(() -> {
		                    c.setId(id);
		                    return repository.save(c);
		                });
		 }
	
		/**
		* Metodo que elimina un cliente existente.
		* @param id El parametro id es el id del cliente a eliminar.
		*/
		 
		@DeleteMapping("/delete/{id}")
		 void deleteCliente(@PathVariable Long id) {
		        repository.deleteById(id);
		    }
		
		
		/**
		* Metodo que retorna las compras realizadas de un cliente.
		* @return Lista de reportes de los gastos realizados en compras.
		*/
	    @GetMapping("/reporteCompras")
	    public List<ReporteGastosCliente> getReporteCompras() {
	    	List<ReporteGastosCliente> reportes = new ArrayList<>();
	    	List<Cliente> clientes = repository.findAll();
	    	for(Cliente c : clientes) {
	    		ReporteGastosCliente reporte = new ReporteGastosCliente();
	    		reporte.setCliente(c);
	    		int gastos = repository.gastosSegunCliente(c.getId());
	    		reporte.setGastos(gastos);
	    		reportes.add(reporte);
	    	}
	        return reportes;
	    }
	    

		/**
		* Metodo que guarda una compra realizada por un cliente
		* @param idCompra El parametro idCompra es la compra realizada por el cliente.
		* @param id El parametro id es el id del cliente que realizo la compra.
		* @return ResponseEntity.
		*/
			@PostMapping("/comprar/{idCompra}/{idCliente}")
			public ResponseEntity compraCliente(@PathVariable Long  idCompra,@PathVariable Long idCliente) {
				
				Optional<Cliente> cliente = repository.findById(idCliente);
				Compra c = repository.getCompra(idCompra);
				System.out.println(c.getId());
				cliente.get().add(c);
				repository.save(cliente.get());
				List<Producto> productos = repository.getProductosSegunCompra(c.getId());
				System.out.println(productos);
				for(Producto p: productos) {
					System.out.println("cantidad para producto"+ p.getNombre() + repository.ventasProducto(p.getId(),c.getFechaDeCompra(),idCliente));
					if(repository.ventasProducto(p.getId(),c.getFechaDeCompra(),idCliente)>3) {
							cliente.get().remove(c);
							repository.save(cliente.get());
							return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Limite de productos al dia superado");
					}
				}
				
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Compra realizada");
			}
					


}
