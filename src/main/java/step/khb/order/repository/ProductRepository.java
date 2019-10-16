package step.khb.order.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import step.khb.order.model.Product;

public interface ProductRepository extends MongoRepository<Product,String> {
}
