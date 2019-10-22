package step.khb.order.service.order.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import step.khb.order.model.Customer;
import step.khb.order.model.Delivery;
import step.khb.order.model.Order;
import step.khb.order.model.Product;
import step.khb.order.repository.OrderRepository;
import step.khb.order.service.customer.impls.CustomerServiceImpls;
import step.khb.order.service.order.interfaces.IOrderService;
import step.khb.order.service.product.impls.ProductServiceImpls;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Service
public class OrderServiceImpl implements IOrderService {
    List<Order> orders = new ArrayList<>();
    @Autowired
    OrderRepository repository;
    @Autowired
    CustomerServiceImpls customerService;
    @Autowired
    ProductServiceImpls productService;

    @PostConstruct
    void init(){
        Product p1 = productService.getAll().get(0);
        Product p2 = productService.getAll().get(1);
        Customer c1 = customerService.getAll().get(0);
        Customer c2 = customerService.getAll().get(1);
        Order o1 = new Order(Delivery.NOVAPOSHTA,p1,c1, 25000, 3, LocalDate.now());
        Order o2 = new Order(Delivery.NOVAPOSHTA,p2,c2, 450000, 33, LocalDate.now());
        Order o3 = new Order(Delivery.NOVAPOSHTA,p2,c2, 100000, 10, LocalDate.now());
        orders.add(o1);
        orders.add(o2);
        orders.add(o3);
        repository.saveAll(orders);

    }

    @Override
    public List<Order> getAll() {
        return repository.findAll();
    }

    @Override
    public Order get(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Order create(Order order) {
        return repository.save(order);
    }

    @Override
    public Order delete(String id) {
        Order order = this.get(id);
        repository.deleteById(id);
        return order;
    }
}
