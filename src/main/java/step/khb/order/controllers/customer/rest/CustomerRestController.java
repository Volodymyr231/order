package step.khb.order.controllers.customer.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import step.khb.order.model.Customer;
import step.khb.order.model.Product;
import step.khb.order.service.customer.impls.CustomerServiceImpls;
import step.khb.order.service.product.impls.ProductServiceImpls;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("api/customer")
@CrossOrigin("*")
@RestController
public class CustomerRestController {
    @Autowired
    CustomerServiceImpls service;

    @RequestMapping("/list")
    List<Customer> showAll(){
        return service.getAll();
    }

    @RequestMapping ("/delete/{id}")
    Customer delete(@PathVariable(value = "id")String id){
        return service.delete(id);
    }

    @RequestMapping("/get/{id}")
    Customer get(@PathVariable(value="id")String id){
        return service.get(id);
    }
    @PostMapping("/create")
    Customer create(@Valid @RequestBody Customer customer){
        return service.create(customer);
    }

}
