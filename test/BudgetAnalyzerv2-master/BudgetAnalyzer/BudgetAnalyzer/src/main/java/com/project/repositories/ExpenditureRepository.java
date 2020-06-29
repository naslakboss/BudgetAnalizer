package com.project.repositories;


import com.project.entities.Expenditure;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenditureRepository extends CrudRepository<Expenditure, Long> {

    @Override
    public Iterable<Expenditure> findAll();

    public Expenditure findByExpenditureId(long expenditureId);
    @Query(nativeQuery = true, value = "SELECT SUM(value)" +
            " FROM expenditure" +
            " WHERE expenditure.date BETWEEN '2020-06-1' AND '2020-06-30'")
    public int monthlyExpenses();

    @Query(nativeQuery = true, value = "SELECT SUM(value) AS ile FROM Expenditure")
    public int sumOfExpenditures();


}
