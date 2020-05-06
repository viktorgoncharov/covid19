package com.virhon.tests.covid19.dao;

import com.virhon.tests.covid19.domain.Summary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SummaryRepository extends JpaRepository<Summary, Long> {
}
