package edu.miu.cs.cs472.finalexam.srmwebapp.model;

import java.time.LocalDate;
import java.util.StringJoiner;

public class Product {
    private String productId;
    private String name;
    private double unitPrice;
    private int quantityInStock;
    private LocalDate dateSupplied;
    private Supplier supplier;

    public Product(String productId, String name, double unitPrice, int quantityInStock, LocalDate dateSupplied, Supplier supplier) {
        this.productId = productId;
        this.name = name;
        this.unitPrice = unitPrice;
        this.quantityInStock = quantityInStock;
        this.dateSupplied = dateSupplied;
        this.supplier = supplier;
    }

    public Product() {
        this(null, null, 0.0, 0, null, null);
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public LocalDate getDateSupplied() {
        return dateSupplied;
    }

    public void setDateSupplied(LocalDate dateSupplied) {
        this.dateSupplied = dateSupplied;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Product.class.getSimpleName() + "[", "]")
                .add("productId='" + productId + "'")
                .add("name='" + name + "'")
                .add("unitPrice=" + unitPrice)
                .add("quantityInStock=" + quantityInStock)
                .add("dateSupplied=" + dateSupplied)
                .add("supplier=" + supplier)
                .toString();
    }

}
