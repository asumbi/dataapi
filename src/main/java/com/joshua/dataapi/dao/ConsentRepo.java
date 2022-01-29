package com.joshua.dataapi.dao;

import com.joshua.dataapi.model.Consent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// spring data JPA
public interface ConsentRepo extends JpaRepository<Consent, Integer>
{
    List<Consent> findById(String id);
}
