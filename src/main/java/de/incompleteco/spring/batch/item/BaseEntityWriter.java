package de.incompleteco.spring.batch.item;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import de.incompleteco.spring.batch.domain.BaseEntity;
import de.incompleteco.spring.batch.domain.BaseEntityRepository;

public class BaseEntityWriter implements ItemWriter<BaseEntity> {

	@Autowired
	private BaseEntityRepository repository;
	
	@Override
	public void write(List<? extends BaseEntity> items) throws Exception {
		repository.save(items);
	}

}
