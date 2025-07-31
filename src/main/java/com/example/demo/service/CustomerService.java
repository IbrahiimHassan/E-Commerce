package com.example.demo.service;

import com.example.demo.dto.CustomerDTO;
import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<CustomerDTO> getAllCustomerDTOs() {
        return customerRepository.findAll()
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public CustomerDTO getCustomerById(int id) {
        return customerRepository.findById(id)
                .map(this::convertToDto)
                .orElse(null);
    }

    public CustomerDTO saveCustomer(Customer customer) {
        Customer saved = customerRepository.save(customer);
        return convertToDto(saved);
    }

    public CustomerDTO updateCustomer(int id, Customer updatedCustomer) {
        return customerRepository.findById(id)
                .map(customer -> {
                    customer.setFirstName(updatedCustomer.getFirstName());
                    customer.setLastName(updatedCustomer.getLastName());
                    customer.setEmail(updatedCustomer.getEmail());
                    customer.setPhone(updatedCustomer.getPhone());
                    customer.setAddress(updatedCustomer.getAddress());
                    Customer saved = customerRepository.save(customer);
                    return convertToDto(saved);
                })
                .orElse(null);
    }

    public void deleteCustomer(int id) {
        customerRepository.deleteById(id);
    }

    private CustomerDTO convertToDto(Customer customer) {
        CustomerDTO dto = new CustomerDTO();
        dto.setCustomerId(customer.getCustomerId());
        dto.setFullName(customer.getFirstName() + " " + customer.getLastName());
        dto.setEmail(customer.getEmail());
        return dto;
    }
}
