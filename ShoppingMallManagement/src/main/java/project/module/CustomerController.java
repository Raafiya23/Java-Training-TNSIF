package project.module;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200") // Optional
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService service;

    // Constructor used instead of autowired
    CustomerController(CustomerService service) {
        this.service = service;
    }

    // Retrieve all customers
    @GetMapping
    public List<Customer> listAll() {
        return service.listAll();
    }

    // Retrieve a customer by ID
    @GetMapping("/{id}")
    public ResponseEntity<Customer> get(@PathVariable Integer id) {
        try {
            Customer customer = service.get(id);
            return new ResponseEntity<>(customer, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Create a new customer
    @PostMapping
    public ResponseEntity<Customer> add(@RequestBody Customer customer) {
        service.save(customer);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // Update an existing customer
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Customer customer, @PathVariable Integer id) {

        try {
            Customer existingCustomer = service.get(id);

            existingCustomer.setName(customer.getName());
            existingCustomer.setEmail(customer.getEmail());
            existingCustomer.setPhone(customer.getPhone());
            existingCustomer.setAddress(customer.getAddress());

            service.save(existingCustomer);

            return new ResponseEntity<>(HttpStatus.OK);

        } catch (NoSuchElementException e) {

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete a customer by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        try {
            service.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}