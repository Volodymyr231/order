package step.khb.order.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import step.khb.order.model.Order;

public interface OrderRepository extends MongoRepository<Order,String> {
}
