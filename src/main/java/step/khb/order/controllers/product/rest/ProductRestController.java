package step.khb.order.controllers.product.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import step.khb.order.model.Product;
import step.khb.order.service.product.impls.ProductServiceImpls;

import javax.validation.Valid;
import java.util.List;
@RequestMapping("api/product")
@CrossOrigin("*")
@RestController
public class ProductRestController {
    @Autowired
    ProductServiceImpls service;

    @RequestMapping("/list")
    List<Product> showAll(){
        return service.getAll();
    }

    @RequestMapping ("/delete/{id}")
    Product delete(@PathVariable(value = "id")String id){
        return service.delete(id);
    }

    @RequestMapping("/get/{id}")
    Product get(@PathVariable(value="id")String id){
        return service.get(id);
    }
    @PostMapping("/create")
    Product create(@Valid @RequestBody Product product){
        return service.create(product);
    }
    @PostMapping("/update")
    Product update(@Valid @RequestBody Product product){
        return service.update(product);
    }

}
