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
public class ClienteController {
	 	@Qualifier("clienteRepository")
	    @Autowired
	    private final ClienteRepository repository;

		public ClienteController(@Qualifier("clienteRepository") ClienteRepository repository) {
			this.repository = repository;
		}
	 	
	    @GetMapping("/getAll")
	    public Iterable<Cliente> getClientes() {
	        return repository.findAll();
	    }
	    
	    @PostMapping("/add")
	    public Cliente newCliente(@RequestBody Cliente c) {
	        return repository.save(c);
	    }
	    
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
		 
		@DeleteMapping("/delete/{id}")
		 void deleteCliente(@PathVariable Long id) {
		        repository.deleteById(id);
		    }
		
		
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
	    
	    
		@PostMapping("/comprar/{idCliente}")
		public ResponseEntity compraCliente(@RequestBody Compra  c,@PathVariable Long idCliente) {
			
			Long idCompra = c.getId();
			Optional<Cliente> cliente = repository.findById(idCliente);
			cliente.get().add(c);
			repository.save(cliente.get());
			for(Producto p: c.getProductos()) {
				
				
				System.out.println("cantidad para producto"+ p.getNombre() + repository.ventasProducto(p.getId(),c.getFechaDeCompra(),idCliente));
				if(repository.ventasProducto(p.getId(),c.getFechaDeCompra(),idCliente)>3) {
						cliente.get().remove(c);
						repository.save(cliente.get());
						//LLAMA UN DELETECOMPRA DESDE JS
						return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Limite de productos al dia superado");
				}
			}
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Compra realizada");
		}
		


}
