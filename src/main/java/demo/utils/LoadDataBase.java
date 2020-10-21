package demo.utils;


import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import demo.model.Cliente;
import demo.model.Compra;
import demo.model.Producto;
import demo.model.Stock;
import demo.repository.ClienteRepository;
import demo.repository.CompraRepository;
import demo.repository.ProductoRepository;
import demo.repository.StockRepository;

/**
* Esta clase esta asociada a la carga de datos a la base de datos
* @author grupo4
* @version Octubre 21, 2020
*/

@Configuration
@Slf4j
class LoadDatabase {
//	  private ClienteRepository clienteRepository;
//	  private CompraRepository compraRepository;
//	  private StockRepository stockRepository;

	
	@Bean
    CommandLineRunner initDatabaseProducto(
    		@Qualifier("productoRepository") ProductoRepository repositoryProducto,
    		@Qualifier("compraRepository") CompraRepository repositoryCompra,
    		@Qualifier("stockRepository") StockRepository repositoryStock,
    		@Qualifier("clienteRepository") ClienteRepository repositoryCliente) {
	    	

	    	//c1.add(new Producto((Long) 1, "Cepita",(double) 75));	
		 return args -> {
		    	Producto p1 = new Producto(Long.valueOf("1"), "Cepita",(double) 75);
		    	Producto p2 = new Producto(Long.valueOf("2"), "Arroz",(double) 15);
//		    	Producto p3 = new Producto(Long.valueOf("3"), "Arroz",(double) 15);
		    	Compra c1 = new Compra(Long.valueOf("1"), "17-10-2020");
		    	Compra c2 = new Compra(Long.valueOf("2"), "17-10-2020");
		    	c1.add(p2);
		    	c1.add(p2);
		    	c2.add(p1);
//		    	c2.add(p2);
		    	Stock s1 = new Stock(Long.valueOf("1"), p1, 15);
		    	Stock s2 = new Stock(Long.valueOf("2"), p2, 10);
		    	Cliente cl1 = new Cliente(Long.valueOf("1"), "juan porongol");
		    	Cliente cl2 = new Cliente(Long.valueOf("2"), "julian porongol2");
		    	cl1.add(c1);
		    	cl2.add(c2);
            log.info("Preloading " + repositoryProducto.save(p1));
            log.info("Preloading " + repositoryProducto.save(p2));
//            log.info("Preloading " + repositoryProducto.save(p3));
//            log.info("Preloading " + repositoryProducto.save(new Producto((Long) 3, "Arroz", (double) 15)));
//            log.info("Preloading " + repositoryProducto.save(new Producto((Long) 4, "Cocacola", (double) 90)));
//            log.info("Preloading " + repositoryProducto.save(new Producto((Long) 5, "Porongol", (double) 55)));
//            log.info("Preloading " + repositoryProducto.save(new Producto((Long) 6, "Caramelo", (double) 2)));
            log.info("Preloading " + repositoryCompra.save(c1));
            log.info("Preloading " + repositoryCompra.save(c2));
            log.info("Preloading " + repositoryStock.save(s1));
            log.info("Preloading " + repositoryStock.save(s2));
            log.info("Preloading " + repositoryCliente.save(cl1));
            log.info("Preloading " + repositoryCliente.save(cl2));
            
        };
    }
    
		 
	 

}
