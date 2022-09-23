package com.example.Productservicec2.controller;

import com.example.Productservicec2.entity.Product;
import com.example.Productservicec2.repository.ProductRepository;
import com.example.Productservicec2.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

// import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private ProductRepository productRepository;


    @PostMapping("/")
    public Product saveProduct(@RequestBody Product prod) {
        return productService.saveProduct(prod);
    }

    @GetMapping("/{id}")
    public Optional<Product> findProdById(@PathVariable("id") Long prodId) {
        return productService.findByProdId(prodId);
    }

    @PutMapping("/update_products/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") long id, @RequestBody Product product)
    {

        Optional<Product> ProductData = productRepository.findById(id);
        if (ProductData.isPresent()) {
            Product _product = ProductData.get();
            _product.setProdName(product.getProdName());
            _product.setProdQty(product.getProdQty());
            _product.setProdCost(product.getProdCost());

            return new ResponseEntity<>(productRepository.save(_product), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/delete_products/{id}")
    public ResponseEntity<HttpStatus> deleteProduct(@PathVariable("id") long id){
        try {
            productRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch(Exception ex) {
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
