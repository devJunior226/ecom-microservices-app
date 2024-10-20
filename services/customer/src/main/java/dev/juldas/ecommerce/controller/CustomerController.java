package dev.juldas.ecommerce.controller;

import dev.juldas.ecommerce.record.CustomerRequest;
import dev.juldas.ecommerce.record.CustomerResponse;
import dev.juldas.ecommerce.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Author: Juldas RAMDE
 * Since: 20/10/2024 at 12:54
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/customers")
public class CustomerController {
    private final CustomerService service;

    @PostMapping()
    public ResponseEntity<String> postCustomer(@RequestBody @Valid CustomerRequest request) {
        return ResponseEntity.ok(service.createCustomer(request));
    }

    @PostMapping
    public ResponseEntity<Void> puCustomer(@RequestBody @Valid CustomerRequest request) {
        this.service.updateCustomer(request);
        return ResponseEntity.accepted().build();
    }

    @GetMapping
    public  ResponseEntity<List<CustomerResponse>> getCustomers() {
        return ResponseEntity.ok(service.fetchCutomers());
    }

    @GetMapping("/exists/{customer-id}")
    public ResponseEntity<Boolean> existsById(@PathVariable("customer-id") String customerId) {
        return ResponseEntity.ok(service.existsCustomer(customerId));
    }

    @GetMapping("/{customer-id}")
    public ResponseEntity<CustomerResponse> findById(@PathVariable("customer-id") String customerId) {
        return ResponseEntity.ok(service.findById(customerId));
    }

    @DeleteMapping("/{customer-id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable("customer-id") String customerId) {
        this.service.deleteCustomer(customerId);
        return ResponseEntity.noContent().build();
    }
}















