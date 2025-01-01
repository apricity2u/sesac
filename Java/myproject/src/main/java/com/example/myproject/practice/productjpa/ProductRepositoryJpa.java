package com.example.myproject.practice.productjpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceUnit;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProductRepositoryJpa {
    private final EntityManager em;

    public ProductJpa save(ProductJpa newProduct){
        em.persist(newProduct);
        return newProduct;
    }

    public ProductJpa findById(Long id){
        ProductJpa productJpa = em.find(ProductJpa.class, id);
        return productJpa;
    }

    public List<ProductJpa> findAll(){
        return em.createQuery("SELECT p FROM ProductJpa p", ProductJpa.class)
                .getResultList();
    }

    public ProductJpa update(Long id, ProductJpa updatedProduct){
        ProductJpa productJpa = em.find(ProductJpa.class, id);

        String name = updatedProduct.getName();
        Integer price = updatedProduct.getPrice();

        productJpa.update(name, price);
        return productJpa;
    }

    public void delete(Long id){
        ProductJpa productJpa = em.find(ProductJpa.class, id);
        em.remove(productJpa);
    }

}
