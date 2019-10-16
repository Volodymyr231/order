package step.khb.order.service.customer.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import step.khb.order.model.Customer;
import step.khb.order.repository.CustomerRepository;
import step.khb.order.service.customer.interfaces.ICustomerService;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Service
public class CustomerServiceImpls implements ICustomerService {
    List<Customer>customers= new ArrayList<>();
    @Autowired
    CustomerRepository repository;
    @PostConstruct
    void init() {
        customers = new ArrayList<>(
                Arrays.asList(
                        new Customer("Sasha", "Golovna204v str", "+380995383948"),
                        new Customer("Yura", "Suvorova15 str", "+380652345654"),
                        new Customer("Mattew", "Kobilanskaya24 str", "+380652323134")
                )
        );
        repository.deleteAll();
        repository.saveAll(customers);
    }
    @Override
    public List<Customer> getAll() {
        return repository.findAll();
    }

    @Override
    public Customer get(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Customer create(Customer customer) {
        return repository.save(customer);
    }

    @Override
    public Customer delete(String id) {
        Customer customer = this.get(id);
        repository.deleteById(id);
        return customer;
    }
}
