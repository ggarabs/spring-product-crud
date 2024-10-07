package com.ggarabetti.basic_crud.services;

import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ggarabetti.basic_crud.domain.product.Product;
import com.ggarabetti.basic_crud.domain.product.ProductRepository;
import com.ggarabetti.basic_crud.domain.product.RequestProductDTO;
import com.ggarabetti.basic_crud.exceptions.ProductNotActiveException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<Product> getAllActiveProducts() {
        return repository.findAllByActiveTrue();
    }

    public Product registerProduct(RequestProductDTO data) {
        Product newProduct = new Product(data);
        return repository.save(newProduct);
    }

    public Product updateProduct(RequestProductDTO data) {
        Optional<Product> optionalProduct = repository.findById(data.id());
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();

            if (!product.getActive())
                throw new ProductNotActiveException();

            product.setName(data.name());
            product.setPrice_in_cents(data.price_in_cents());

            return product;
        }
        throw new EntityNotFoundException();
    }

    public Product deleteProduct(String id) {
        Optional<Product> optionalProduct = repository.findById(id);
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            product.setActive(false);
            return product;
        }
        throw new EntityNotFoundException();
    }

}
