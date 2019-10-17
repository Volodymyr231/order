package step.khb.order.service.product.interfaces;

import step.khb.order.model.Customer;
import step.khb.order.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> getAll();
    Product get(String id);
    Product create(Product product);
    Product update(Product product);
    Product delete (String id);

}
