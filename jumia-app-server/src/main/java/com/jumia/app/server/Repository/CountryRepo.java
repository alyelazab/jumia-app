package com.jumia.app.server.Repository;

import com.jumia.app.server.Entity.CountryProps;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CountryRepo extends JpaRepository<CountryProps, Integer> {

}
