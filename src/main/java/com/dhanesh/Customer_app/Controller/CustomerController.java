package com.dhanesh.Customer_app.Controller;

import com.dhanesh.Customer_app.Model.AuthRequest;
import com.dhanesh.Customer_app.Model.Customer;
import com.dhanesh.Customer_app.Model.Response.RequestResponse;
import com.dhanesh.Customer_app.Service.CustomerService;
import com.dhanesh.Customer_app.Service.JwtService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;




    @PostMapping("/customer")
    public ResponseEntity<String> createCustomer(@RequestBody Customer customer){
        return customerService.createCustomer(customer);
    }


    @PostMapping("/login")
    public String loginAndGenerateToken(@RequestBody AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(authRequest.getUsername());
        } else {
            throw new UsernameNotFoundException("invalid user request !");
        }
    }

    @GetMapping("customer/id")
    public ResponseEntity<Customer> getCustomerById(@RequestParam Integer id){
        return customerService.getCustomerById(id);
    }

    @PutMapping("customer/password/id/{id}")
    public ResponseEntity<RequestResponse> updateCustomerPassword(@PathVariable Integer id , @RequestParam String oldPassword , @RequestParam String newPassword){
        return customerService.updateCustomerPassword(id , oldPassword , newPassword);
    }

    @GetMapping("customers/page")
    public Page<Customer> getListOfCustomersByPage(Pageable pageable){
        return customerService.getListOfCustomersByPage(pageable);
    }

    @DeleteMapping("customer/id/{id}")
    public ResponseEntity<RequestResponse> deleteCustomer(@PathVariable Integer id){
        return customerService.deleteCustomer(id);
    }


}
