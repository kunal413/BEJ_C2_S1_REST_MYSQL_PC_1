package com.niit.jap.services;

import com.niit.jap.domain.Product;
import com.niit.jap.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    private  final ProductRepository productRepository;
@Autowired
    public ProductServiceImpl (ProductRepository productRepository) {
       this.productRepository=productRepository;
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product UpdateProduct(Product product, int productId) {
        Optional<Product>optionalProduct = productRepository.findById(productId);
        if (optionalProduct.isEmpty()){
            return  null;
        }
        Product existInputProduct = optionalProduct.get();
        if (product.getProductId()!=0){
            existInputProduct.setProductId(product.getProductId());
        }
        return productRepository.save(existInputProduct);
    }

    @Override
    public boolean deleteProductByProductId(int productId) {
    productRepository.deleteById(productId);
        return true;
    }

    @Override
    public List<Product> getProductByProductId(int productId) {
        return productRepository.findByProductId(productId);
    }
}
