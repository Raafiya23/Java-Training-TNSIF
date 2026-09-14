package project.module;

import java.util.List;
import java.util.NoSuchElementException;

import jakarta.transaction.Transactional;

import org.springframework.stereotype.Service;

@Service
@Transactional
public class CustomerService {

    private final CustomerRepository repo;

    // Constructor
    CustomerService(CustomerRepository repo) {
        this.repo = repo;
    }

    // Get All List of Data
    public List<Customer> listAll() {
        return repo.findAll();
    }

    // Create / Update the data
    public void save(Customer customer) {
        repo.save(customer);
    }

    // Get data by ID
    public Customer get(Integer id) {
        return repo.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Customer not found"));
    }

    // Delete the data
    public void delete(Integer id) {
        repo.deleteById(id);
    }
}