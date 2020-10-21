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
import demo.model.ReporteVentasPorDia;
import demo.model.Stock;
import demo.repository.CompraRepository;

@RestController
@RequestMapping("compra")

/**
* Esta clase administra los servicios rest de las compras
* @author grupo4
* @version Octubre 21, 2020
*/

public class CompraController {
	@Qualifier("compraRepository")
	@Autowired
	private final CompraRepository repository;

	/**
	* Constructor de la clase CompraController. Inicializa el repository.
	*/
	
	public CompraController(@Qualifier("compraRepository") CompraRepository repository) {
		this.repository = repository;
	}

	/**
	* Metodo que devuelve todas las compras
	* @return Un iterable de tipo Compra.
	*/
	
	@GetMapping("/getAll")
	public Iterable<Compra> getCompras() {
		return repository.findAll();
	}

	/**
	* Metodo que guarda una compra realizada
	* @param c El parametro c es la compra a guardar
	* @return Compra.
	*/
	
	@PostMapping("/")
	public Compra Comprar(@RequestBody Compra c, @PathVariable Long id) {
		List<Compra> compras = repository.cantidadDeCompras(c.getFechaDeCompra(),id);
		if(compras.size() > 0) {
			
		}
		return repository.save(c);
	}
	
	
	@PostMapping("/add")
	public Compra addCompra(@RequestBody Compra c) {
		return repository.save(c);
	}

	/**
	* Metodo que actualiza una compra ya existente
	* @param c El parametro c es la compra actualizada
	* @param id El parametro id es el id de la compra a actualizar
	* @return Compra.
	*/
	
	@PutMapping("/update/{id}")
	public Compra updateCompra(@RequestBody Compra c, @PathVariable Long id) {
		return repository.findById(id).map(compra -> {
			compra.setFechaDeCompra(c.getFechaDeCompra());
			return repository.save(compra);
		}).orElseGet(() -> {
			c.setId(id);
			return repository.save(c);
		});
	}
	
	@PutMapping("/addProducto/{idCompra}/{idProducto}")
	public Compra addProducto(@PathVariable Long idCompra, @PathVariable Long idProducto) {
		Producto p = repository.getProducto(idProducto);
		Optional<Compra> c = repository.findById(idCompra);

		return repository.findById(idCompra).map(compra -> {
			compra.add(p);
			return repository.save(compra);
		}).orElseGet(() -> {
			c.get().setId(idCompra);
			return repository.save(c.get());
		});
		

	}
	

	/**
	* Metodo que elimina una compra ya existente
	* @param id El parametro id es el id de la compra a eliminar
	*/
	
	@DeleteMapping("/delete/{id}")
	void deleteCompra(@PathVariable Long id) {
		repository.deleteById(id);
	}

	/**
	* Metodo que devuelve una lista con los reportes de las compras por dia
	* @return List de las compras por dia.
	*/
	
	@GetMapping("/reporteComprasPorDia")
	public List<ReporteVentasPorDia> getComprasPorDia() {
		boolean flag = false;
		List<ReporteVentasPorDia> reportes = new ArrayList<>();
		List<Compra> compras = repository.comprasOrdenFecha();
		for (Compra c : compras) {
			for (ReporteVentasPorDia r : reportes) {
				if (r.getFecha().equals(c.getFechaDeCompra())) {
					flag = true;
					r.addCompra(c);
				}
			}
			if (flag == false) {
				ReporteVentasPorDia reporte = new ReporteVentasPorDia();
				reporte.addCompra(c);
				reporte.setFecha(c.getFechaDeCompra());
				reportes.add(reporte);
			} else {
				flag = false;
			}
		}
		return reportes;
	}

}
