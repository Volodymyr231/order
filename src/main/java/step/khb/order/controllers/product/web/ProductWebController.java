package step.khb.order.controllers.product.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import step.khb.order.forms.CustomerForm;
import step.khb.order.forms.ProductForm;
import step.khb.order.model.Customer;
import step.khb.order.model.Product;
import step.khb.order.service.product.impls.ProductServiceImpls;
import step.khb.order.service.product.interfaces.IProductService;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequestMapping("/product")
@CrossOrigin("*")
@Controller
public class ProductWebController {
    @Autowired
    ProductServiceImpls service;
    @RequestMapping ("/list")
    String showAll(Model model){
        List<Product> list = service.getAll();
        model.addAttribute("products",list);
        return "productList";
    }
    @RequestMapping ("/delete/{id}")
    RedirectView delete(Model model, @PathVariable(value = "id") String id){
        service.delete(id);
        return new RedirectView("/product/list");
    }
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String addProduct(Model model){
        ProductForm productForm = new ProductForm();
        Map<String, String> mavs = service.getAll().stream()
                .collect(Collectors.toMap(Product::getId, Product::getName));

        model.addAttribute("mavs", mavs);
        model.addAttribute("ProductForm", productForm);
        return "productAdd";
    }
    @RequestMapping(value = "/create",method = RequestMethod.POST)
    String create(Model model, @ModelAttribute("productForm")ProductForm productForm){
        Product newProduct = new Product(productForm.getName(),
                productForm.getDescription(),productForm.getPrice(),productForm.isDelivery());

        service.create(newProduct);
        return "redirect:/product/list";
    }
    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String updateProduct(Model model,  @PathVariable("id") String id){
        Product productToUpdate = service.get(id);
        ProductForm productForm = new ProductForm();
        productForm.setName(productToUpdate.getName());
        productForm.setId(id);
        productForm.setDescription(productToUpdate.getDescription());
        productForm.setPrice(productToUpdate.getPrice());
        productForm.setDelivery(productToUpdate.isDelivery());
        Map<String, String> mavs = service.getAll().stream()
                .collect(Collectors.toMap(Product::getId, Product::getName));
        model.addAttribute("productForm", productForm);
        model.addAttribute("mavs", mavs);
        return "productUpdate";
    }
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    String update(Model model, @ModelAttribute("productForm") ProductForm productForm,
                  @PathVariable("id") String id) {
        String productId=productForm.getId();
        Product newProduct = new Product(productForm.getName(),
                productForm.getDescription(),
                productForm.getPrice(),
                productForm.isDelivery());

        newProduct.setId(id);
        service.update(newProduct);
        return "redirect:/product/list";

    }
}
