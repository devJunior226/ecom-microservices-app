package dev.juldas.ecommerce.mapper;

import dev.juldas.ecommerce.entity.Customer;
import dev.juldas.ecommerce.record.CustomerRequest;
import dev.juldas.ecommerce.record.CustomerResponse;
import org.springframework.stereotype.Service;

/**
 * Author: Juldas RAMDE
 * Since: 20/10/2024 at 13:14
 */
@Service
public class MapperService {

    /**
     * Maps CustomerRequest(dto) to Customer(entity)
     *
     * @param request
     * @return Customer
     */
    public Customer maps(CustomerRequest request) {
        if (request == null) {
            return null;
        }
        return Customer.builder()
                .id(request.id())
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .address(request.address())
                .build();
    }

    /**
     * Maps Customer(entity) to CustomerResponse(dto)
     *
     * @param customer
     * @return CustomerResponse
     */
    public CustomerResponse maps(Customer customer) {
        if (customer == null) {
            return null;
        }
        return new CustomerResponse(
                customer.getId(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getEmail(),
                customer.getAddress()
        );
    }
}














