package step.khb.order.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import step.khb.order.model.Customer;
@Repository
public interface CustomerRepository extends MongoRepository<Customer,String> {

}
