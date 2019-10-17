package step.khb.order.controllers.customer.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import step.khb.order.forms.CustomerForm;
import step.khb.order.model.Customer;
import step.khb.order.service.customer.impls.CustomerServiceImpls;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequestMapping("/customer")
@CrossOrigin("*")
@Controller
public class CustomerWebController {
@Autowired
    CustomerServiceImpls service;
    @RequestMapping ("/list")
    String showAll(Model model){
        List<Customer> list = service.getAll();
        model.addAttribute("customers",list);
        return "customerList";
    }
    @RequestMapping ("/delete/{id}")
    RedirectView delete(Model model, @PathVariable(value = "id") String id){
        service.delete(id);
        return new RedirectView("/customer/list");
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String addCustomer(Model model){
        CustomerForm customerForm = new CustomerForm();
        Map<String, String> mavs = service.getAll().stream()
                .collect(Collectors.toMap(Customer::getId, Customer::getName));

        model.addAttribute("mavs", mavs);
        model.addAttribute("CustomerForm", customerForm);
        return "customerAdd";
    }
    @RequestMapping(value = "/create",method = RequestMethod.POST)
    String create(Model model, @ModelAttribute("customerForm")CustomerForm customerForm){
        Customer newCustomer = new Customer(customerForm.getName(),
                customerForm.getAddress(),customerForm.getPhoneNumber());

        service.create(newCustomer);
        return "redirect:/customer/list";
    }

}
