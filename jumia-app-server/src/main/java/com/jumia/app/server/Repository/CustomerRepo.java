package com.jumia.app.server.Repository;

import com.jumia.app.server.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends JpaRepository<Customer,Integer> {
//    @Query(value = "SELECT phone FROM customer")
//    public List<Integer> findAllNumbers();

}
