package com.niit.jap.controller;

import com.niit.jap.domain.Product;
import com.niit.jap.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/productdetails/app/")
public class ProductController {
    private final ProductService productService;
    @Autowired
    public  ProductController (ProductService productService){
        this.productService=productService;
    }
    @PostMapping("/product")
    public ResponseEntity<?>insertProduct(@RequestBody Product product){
        return new ResponseEntity<>(productService.saveProduct(product), HttpStatus.CREATED);
    }
    @GetMapping("/Products")
    public ResponseEntity<?>getProductDetails(){
        return new ResponseEntity<>(productService.getAllProducts(),HttpStatus.FOUND);

    }
    @DeleteMapping("/product/{productId}")
    public  ResponseEntity<?>deleteProduct(@PathVariable int productId){
        return new  ResponseEntity<>(productService.deleteProductByProductId(productId),HttpStatus.OK);
    }
    @GetMapping("/product/{productId}")
    public ResponseEntity<?>fetchByProduct(@PathVariable int productId){
        return new ResponseEntity<>(productService.getProductByProductId(productId),HttpStatus.FOUND);

    }

}
