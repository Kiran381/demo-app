package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.domain.DataTemplates;

@Repository
public interface DataTemplatesRepository extends JpaRepository<DataTemplates, Long> {

	
}
