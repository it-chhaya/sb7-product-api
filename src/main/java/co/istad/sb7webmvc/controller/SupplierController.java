package co.istad.sb7webmvc.controller;

import co.istad.sb7webmvc.model.Supplier;
import co.istad.sb7webmvc.service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/suppliers")
@RequiredArgsConstructor
public class SupplierController {

    private final SupplierService supplierService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void addNewSupplier(@RequestBody Supplier supplier) {
        supplierService.addNewSupplier(supplier);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void updateSupplierById(@PathVariable Integer id,
                                   @RequestBody Supplier supplier) {
        supplierService.updateSupplierById(id, supplier);
    }

}
