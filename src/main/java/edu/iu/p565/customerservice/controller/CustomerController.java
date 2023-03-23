package edu.iu.p565.customerservice.controller;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import edu.iu.p565.customerservice.model.Customer;
import edu.iu.p565.customerservice.repository.CustomerRepository;

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
        return repository.create(customer);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @Valid @RequestBody Customer customer) {
        repository.update(id, customer);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        repository.delete(id);
    }

}
