package edu.miu.cs.cs472.finalexam.srmwebapp.repository;

import edu.miu.cs.cs472.finalexam.srmwebapp.model.Product;
import edu.miu.cs.cs472.finalexam.srmwebapp.model.Supplier;

import java.util.Map;

public class SRMDataRepository {
    private Map<String, Supplier> suppliersDatastore;
    private Map<String, Product> productsDatastore;

    public SRMDataRepository(Map<String, Supplier> suppliersDatastore, Map<String, Product> productsDatastore) {
        this.suppliersDatastore = suppliersDatastore;
        this.productsDatastore = productsDatastore;
    }

    public SRMDataRepository() {
    }

    public Map<String, Supplier> getSuppliersDatastore() {
        return suppliersDatastore;
    }

    public Map<String, Product> getProductsDatastore() {
        return productsDatastore;
    }

    public Product addProduct(Product product) {
        this.productsDatastore.putIfAbsent(product.getProductId(), product);
        return product;
    }
}
