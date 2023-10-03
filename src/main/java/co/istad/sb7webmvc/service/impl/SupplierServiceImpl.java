package co.istad.sb7webmvc.service.impl;

import co.istad.sb7webmvc.model.Supplier;
import co.istad.sb7webmvc.repository.SupplierRepository;
import co.istad.sb7webmvc.service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class SupplierServiceImpl implements SupplierService {

    private final SupplierRepository supplierRepository;

    @Override
    public void addNewSupplier(Supplier supplier) {
        supplier.setSince(LocalDate.now());
        supplier.setStatus(true);
        supplierRepository.insert(supplier);
    }

    @Override
    public void updateSupplierById(Integer id, Supplier supplier) {
        supplier.setId(id);
        supplierRepository.update(supplier);
    }
}
