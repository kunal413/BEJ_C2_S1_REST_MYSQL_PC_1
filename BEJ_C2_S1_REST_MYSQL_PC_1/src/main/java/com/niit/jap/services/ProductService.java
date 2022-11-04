package com.niit.jap.services;

import com.niit.jap.domain.Product;


import java.util.List;

public interface ProductService {
    Product saveProduct(Product product);
   List<Product> getAllProducts();
   Product UpdateProduct(Product product,int productId);
   boolean deleteProductByProductId(int productId);
   List<Product>getProductByProductId(int productId);
}
