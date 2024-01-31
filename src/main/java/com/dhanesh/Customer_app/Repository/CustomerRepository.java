package com.dhanesh.Customer_app.Repository;

import com.dhanesh.Customer_app.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer , Integer>{

    Customer findByUsername(String username);
}
