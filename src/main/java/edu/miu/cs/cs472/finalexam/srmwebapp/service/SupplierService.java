package edu.miu.cs.cs472.finalexam.srmwebapp.service;

import edu.miu.cs.cs472.finalexam.srmwebapp.model.Product;
import edu.miu.cs.cs472.finalexam.srmwebapp.model.Supplier;
import edu.miu.cs.cs472.finalexam.srmwebapp.repository.SRMDataRepository;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SupplierService {

    private SRMDataRepository srmDataRepository;

    public SupplierService(Map<String, Supplier> suppliersDatastore, Map<String, Product> productsDatastore) {
        this.srmDataRepository = new SRMDataRepository(suppliersDatastore, productsDatastore);
    }

    public List<Supplier> getAllSuppliersSorted() {
        return this.srmDataRepository.getSuppliersDatastore()
                .values()
                .stream()
                .sorted(Comparator.comparing(s -> s.getName()))
                .collect(Collectors.toList());
    }
}
