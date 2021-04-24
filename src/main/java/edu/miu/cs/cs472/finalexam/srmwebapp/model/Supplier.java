package edu.miu.cs.cs472.finalexam.srmwebapp.model;

import java.util.StringJoiner;

public class Supplier {
    private String supplierId;
    private String name;

    public Supplier(String supplierId, String name) {
        this.supplierId = supplierId;
        this.name = name;
    }

    public Supplier() {
        this(null, null);
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Supplier.class.getSimpleName() + "[", "]")
                .add("supplierId='" + supplierId + "'")
                .add("name='" + name + "'")
                .toString();
    }
}
