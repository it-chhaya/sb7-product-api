package co.istad.sb7webmvc.service;

import co.istad.sb7webmvc.model.Supplier;

public interface SupplierService {
    void addNewSupplier(Supplier supplier);

    void updateSupplierById(Integer id, Supplier supplier);
}
