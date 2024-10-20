package dev.juldas.ecommerce.service;

import dev.juldas.ecommerce.entity.Customer;
import dev.juldas.ecommerce.exception.CustomerNotFoundException;
import dev.juldas.ecommerce.mapper.MapperService;
import dev.juldas.ecommerce.record.CustomerRequest;
import dev.juldas.ecommerce.record.CustomerResponse;
import dev.juldas.ecommerce.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Author: Juldas RAMDE
 * Since: 20/10/2024 at 12:55
 */
@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository repository;
    private final MapperService mapper;

    public String createCustomer(CustomerRequest request) {
        var customer = mapper.maps(request);
        this.repository.save(customer);
        return customer.getId();
    }

    public void updateCustomer(CustomerRequest request) {
        var customer = this.repository.findById(request.id()).orElseThrow(() ->
                new CustomerNotFoundException(
                        String.format(
                                "Cannot update customer:: No customer found with the provided id:: %s",
                                request.id())
                ));
        mergeCustomer(customer, request);
        this.repository.save(customer);
    }

    private void mergeCustomer(Customer customer, CustomerRequest request) {
        if (StringUtils.isNotBlank(request.firstName())) {
            customer.setFirstName(request.firstName());
        }
        if (StringUtils.isNotBlank(request.lastName())) {
            customer.setFirstName(request.lastName());
        }
        if (StringUtils.isNotBlank(request.email())) {
            customer.setFirstName(request.email());
        }
        if (request.address() != null) {
            customer.setAddress(request.address());
        }
    }

    public List<CustomerResponse> fetchCutomers() {
        return this.repository.findAll()
                .stream()
                .map(mapper::maps)
                .collect(Collectors.toList());
    }

    public Boolean existsCustomer(String customerId) {
        return this.repository.findById(customerId).isPresent();
    }

    public CustomerResponse findById(String customerId) {
        return this.repository.findById(customerId)
                .map(mapper::maps)
                .orElseThrow(() -> new CustomerNotFoundException(
                        String.format("No customer found with the provided id:: %s", customerId)
                ));
    }

    public void deleteCustomer(String customerId) {
        this.repository.deleteById(customerId);
    }
}











