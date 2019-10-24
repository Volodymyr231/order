package step.khb.order.service.product.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import step.khb.order.model.Customer;
import step.khb.order.model.Product;
import step.khb.order.repository.ProductRepository;
import step.khb.order.service.product.interfaces.IProductService;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Service
public class ProductServiceImpls implements IProductService {
    List<Product> products = new ArrayList<>();
    @Autowired
    ProductRepository repository;
    @PostConstruct
    void init() {
        products = new ArrayList<>(
                Arrays.asList(
                        new Product("Desktop","Intelcore i7 Gtx1060ti ssd 256gb",25000,true),
                        new Product("Phone","Iphone x 64gb",20000,false),
                        new Product("Laptop","Lenovo Scrx5600",10000,true)

                )
        );
        repository.deleteAll();
        repository.saveAll(products);
    }

    @Override
    public List<Product> getAll() {
        return repository.findAll();
    }

    @Override
    public Product get(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Product create(Product product) {
        return repository.save(product);
    }

    @Override
    public Product update(Product product) {
        return repository.save(product);
    }

    @Override
    public Product delete(String id) {
        Product product = this.get(id);
        repository.deleteById(id);
        return product;
    }
}
