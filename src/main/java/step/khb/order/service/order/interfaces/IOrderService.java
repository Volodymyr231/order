package step.khb.order.service.order.interfaces;

import step.khb.order.model.Customer;
import step.khb.order.model.Order;

import java.util.List;

public interface IOrderService {
    List<Order> getAll();
    Order get(String id);
    Order create(Order order);
    Order delete(String id);

}
