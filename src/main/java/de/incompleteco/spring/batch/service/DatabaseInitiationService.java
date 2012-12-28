package de.incompleteco.spring.batch.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import de.incompleteco.spring.batch.domain.BaseEntity;
import de.incompleteco.spring.batch.domain.BaseEntityRepository;

@Service("databaseInitiationService")
public class DatabaseInitiationService {

	@Autowired
	private BaseEntityRepository repository;
	
	public void setupService() {
		List<BaseEntity> entities = new ArrayList<BaseEntity>();
		//setup the data
		for (int i=0;i<1000;i++) {
			BaseEntity baseEntity = new BaseEntity();
			baseEntity.setBaseValue(i);
			//add
			entities.add(baseEntity);
		}//end for
		Assert.notNull(repository,"repo is null?");
		//persist
		repository.save(entities);
	}
	
}
