package com.JumiaServices.task.Repository;

import com.JumiaServices.task.Entity.CountryProps;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CountryRepo extends JpaRepository<CountryProps,Integer> {
//    @Query(value = "SELECT phone FROM customer")
//    public List<Integer> findAllNumbers();

}
