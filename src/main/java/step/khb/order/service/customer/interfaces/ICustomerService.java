package step.khb.order.service.customer.interfaces;

import step.khb.order.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> getAll();
    Customer get(String id);
    Customer create(Customer customer);
    Customer delete(String id);
}
