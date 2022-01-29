package com.joshua.dataapi.dao;

import com.joshua.dataapi.model.CustomerData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

// spring data JPA
public interface CustomerDataRepo extends JpaRepository<CustomerData, Integer>
{
    List<CustomerData> findById(String id);
    List<CustomerData> findByText(String text);
    List<CustomerData> findByLanguage(String language);

    // JPA query, writing own custom queries
    @Query("from CustomerData where language=?1 order by language")
    List <CustomerData> findByLanguageSorted(String language);
}
