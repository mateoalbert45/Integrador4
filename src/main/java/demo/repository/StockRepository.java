package demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import demo.model.Stock;

public interface StockRepository extends JpaRepository<Stock, Long> {

}
