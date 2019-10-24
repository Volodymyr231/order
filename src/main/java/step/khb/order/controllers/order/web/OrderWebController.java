package step.khb.order.controllers.order.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import step.khb.order.model.Customer;
import step.khb.order.model.Order;
import step.khb.order.model.Product;
import step.khb.order.service.customer.impls.CustomerServiceImpls;
import step.khb.order.service.order.impls.OrderServiceImpl;
import step.khb.order.service.product.impls.ProductServiceImpls;

import java.util.List;

@RequestMapping("/order")
@CrossOrigin("*")
@Controller
public class OrderWebController {
    @Autowired
    OrderServiceImpl service;
    @Autowired
    CustomerServiceImpls customerService;
    @RequestMapping ("/list")
    String showAll(Model model){
        List<Order> list = service.getAll();
        model.addAttribute("orders",list);
        return "orderList";
    }
}
