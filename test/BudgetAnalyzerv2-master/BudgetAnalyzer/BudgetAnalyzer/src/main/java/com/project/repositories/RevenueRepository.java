package com.project.repositories;

import com.project.entities.Revenue;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RevenueRepository extends CrudRepository<Revenue, Long> {

    @Query("SELECT SUM(value) AS ile FROM Revenue")
    int sumOfRevenues();
}
