package edu.iu.p565.customerservice.repository;

import java.util.*;

import org.springframework.stereotype.Repository;

import edu.iu.p565.customerservice.model.Customer;

public class InMemoryCustomerRepository {
    
    private List<Customer> customers = new ArrayList<>();

    public List<Customer> findAll() {
        return customers;
    }

    public int create(Customer customer) {
        int id = customers.size() + 1;
        customer.setId(id);
        customers.add(customer);
        return id;
    }

    private Customer getCustomerById(int id) {
        for(Customer c : customers) {
            if(c.getId() == id) return c;
        }
        throw new IllegalStateException("Invalid id");
    }

    public void update(int id, Customer c) {
        Customer cust = getCustomerById(id);
        cust.setName(c.getName());
        cust.setEmail(c.getEmail());
    }

    public void delete(int id) {
        Customer c = getCustomerById(id);
        customers.remove(c);
    }

}
