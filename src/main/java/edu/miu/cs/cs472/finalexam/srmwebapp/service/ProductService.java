package edu.miu.cs.cs472.finalexam.srmwebapp.service;

import edu.miu.cs.cs472.finalexam.srmwebapp.model.Product;
import edu.miu.cs.cs472.finalexam.srmwebapp.model.Supplier;
import edu.miu.cs.cs472.finalexam.srmwebapp.repository.SRMDataRepository;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProductService {
    private SRMDataRepository srmDataRepository;

    public ProductService(Map<String, Supplier> suppliersDatastore, Map<String, Product> productsDatastore) {
        this.srmDataRepository = new SRMDataRepository(suppliersDatastore, productsDatastore);
    }

    public List<Product> getAllProductsSorted() {
        return this.srmDataRepository.getProductsDatastore()
                .values()
                .stream()
                .sorted(Comparator.comparing(p -> p.getName()))
                .collect(Collectors.toList());
    }

    public Product addProduct(Product product) {
        return this.srmDataRepository.addProduct(product);
    }
}
