package com.JumiaServices.task.Repository;

import com.JumiaServices.task.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepo extends JpaRepository<Customer,Integer> {
//    @Query(value = "SELECT phone FROM customer")
//    public List<Integer> findAllNumbers();

}
