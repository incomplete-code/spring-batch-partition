package de.incompleteco.spring.batch.domain;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseEntityRepository extends JpaRepository<BaseEntity, Long> {

	public List<BaseEntity> findByIdBetween(long start,long end,Pageable pageable);
	
}
