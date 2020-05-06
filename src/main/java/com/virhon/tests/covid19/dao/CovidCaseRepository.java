package com.virhon.tests.covid19.dao;

import com.virhon.tests.covid19.domain.CovidCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface CovidCaseRepository extends JpaRepository<CovidCase, Long> {
    List<CovidCase> findAllByDateOf(Date dateOf);
}
