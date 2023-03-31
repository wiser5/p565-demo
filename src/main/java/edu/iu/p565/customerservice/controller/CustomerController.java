package edu.iu.p565.customerservice.controller;

import edu.iu.p565.customerservice.repository.CustomerRepository;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import edu.iu.p565.customerservice.model.Customer;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private CustomerRepository repository;

    public CustomerController(CustomerRepository repository) {
        this.repository = repository;
    }
    
    @GetMapping
    public List<Customer> findAll() {
        return repository.findAll();
    }

    @PostMapping
    public int create(@Valid @RequestBody Customer customer) {
        Customer addedCustomer = repository.save(customer);
        return addedCustomer.getId();
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @Valid @RequestBody Customer customer) {
        customer.setId(id);
        repository.save(customer);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        Customer customer = new Customer();
        customer.setId(id);
        repository.delete(customer);
    }

}
