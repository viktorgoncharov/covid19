package com.virhon.tests.covid19.dao;

import com.virhon.tests.covid19.domain.CountryCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryCaseRepository extends JpaRepository<CountryCase, Long> {
}
