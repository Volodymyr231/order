package step.khb.order.controllers.order.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import step.khb.order.forms.OrderForm;
import step.khb.order.model.Customer;
import step.khb.order.model.Delivery;
import step.khb.order.model.Order;
import step.khb.order.model.Product;
import step.khb.order.service.customer.impls.CustomerServiceImpls;
import step.khb.order.service.order.impls.OrderServiceImpl;
import step.khb.order.service.product.impls.ProductServiceImpls;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequestMapping("/order")
@CrossOrigin("*")
@Controller
public class OrderWebController {
    @Autowired
    OrderServiceImpl service;
    @Autowired
    CustomerServiceImpls customerService;
    @Autowired
    ProductServiceImpls productService;
    @RequestMapping ("/list")
    String showAll(Model model){
        List<Order> list = service.getAll();
        model.addAttribute("orders",list);
        return "orderList";
    }
    @RequestMapping ("/search/{id}")
    String showOrdersByCustomer(Model model,@PathVariable(value = "id") String id){
        List<Order> orders = service.getByCustomerId(id);
        model.addAttribute("orders",orders);

        return ("orderList");
    }
    @RequestMapping ("/delete/{id}")
    RedirectView delete(@PathVariable(value = "id") String id){

        service.delete(id);
        return new  RedirectView ("/order/list");
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String addOrder(Model model){
        OrderForm orderForm = new OrderForm();
        Map<String, String> mavs = productService.getAll().stream()
                .collect(Collectors.toMap(Product::getId, Product::getName));
        Map<String, String> mavs1 = customerService.getAll().stream()
                .collect(Collectors.toMap(Customer::getId, Customer::getName));
        Map<String,Delivery> mavsDelivery = new HashMap<>();
        mavsDelivery.put("1",Delivery.NOVAPOSHTA);
        mavsDelivery.put("2",Delivery.UKRPOSHTA);
        mavsDelivery.put("3",Delivery.NONE);


        model.addAttribute("mavs", mavs);
        model.addAttribute("mavs1", mavs1);
        model.addAttribute("mavsDelivery", mavsDelivery);

        model.addAttribute("orderForm", orderForm);
        return "orderAdd";
    }
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    String create(@ModelAttribute("orderForm") OrderForm orderForm) {
        System.out.println("Method Create POST was called");
        Order order = new Order();
        order.setNumber(orderForm.getNumber());
        order.setPrice(orderForm.getPrice());
        Customer customer = customerService.get(orderForm.getCustomer());
        order.setCustomer(customer);
        Product product = productService.get(orderForm.getProduct());
        order.setProduct(product);
        String dateFromForm = orderForm.getDate();
        LocalDate date= LocalDate.parse(dateFromForm, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        order.setDate(date);

        if(orderForm.getDelivery().equals("1")) order.setDelivery(Delivery.NOVAPOSHTA);
        if(orderForm.getDelivery().equals("2")) order.setDelivery(Delivery.UKRPOSHTA);
        if(orderForm.getDelivery().equals("3")) order.setDelivery(Delivery.NONE);
        System.out.println(order.toString());
        service.create(order);


        return "redirect:/order/list";

    }


}
