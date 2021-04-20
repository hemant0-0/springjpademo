package com.springjpa.springjpademo.repository;

import com.springjpa.springjpademo.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepo extends JpaRepository<Customer,Integer> {

    @Query(value = "select c.id,c.name,o.prod_id from customer c left join" +
            " cust_prod o on c.id=o.cust_id;",nativeQuery = true)
    List<Customer> allcustomer();


//    @Query("select c.id,c.name,o.prod_id from customer c left join" +
//            " cust_prod o on c.id=o.cust_id where c.id=1;")
//    public String onecust();
}
