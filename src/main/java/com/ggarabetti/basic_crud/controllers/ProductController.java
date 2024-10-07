package com.ggarabetti.basic_crud.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ggarabetti.basic_crud.domain.product.Product;
import com.ggarabetti.basic_crud.domain.product.RequestProductDTO;
import com.ggarabetti.basic_crud.services.ProductService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity getAllProducts() {
        List<Product> allProducts = productService.getAllActiveProducts();
        return ResponseEntity.ok(allProducts);
    }

    @PostMapping
    public ResponseEntity registerProduct(@RequestBody @Valid RequestProductDTO data) {
        Product product = productService.registerProduct(data);
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

    @PutMapping()
    @Transactional // executar mais de um comando SQL em conjunto.
    public ResponseEntity updateProduct(@RequestBody @Valid RequestProductDTO data) {
        var updatedProduct = productService.updateProduct(data);
        return ResponseEntity.ok(updatedProduct);
    }

    @DeleteMapping("/{id}") // path variable
    @Transactional
    public ResponseEntity deleteProduct(@PathVariable String id) {
        var removedProduct = productService.deleteProduct(id);
        return ResponseEntity.ok(removedProduct);
    }

}
