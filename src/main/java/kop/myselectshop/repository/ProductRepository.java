package kop.myselectshop.repository;

import java.util.List;
import kop.myselectshop.entity.Product;
import kop.myselectshop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {

    List<Product> findAllByUser(User user);
}
