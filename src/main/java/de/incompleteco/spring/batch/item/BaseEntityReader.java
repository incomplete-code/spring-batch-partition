package de.incompleteco.spring.batch.item;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.batch.item.database.JpaPagingItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;

import de.incompleteco.spring.batch.domain.BaseEntity;
import de.incompleteco.spring.batch.domain.BaseEntityRepository;

public class BaseEntityReader extends JpaPagingItemReader<BaseEntity> {

	@Autowired
	private BaseEntityRepository repository;
	
	private Long startId;
	
	private Long endId;
	
	@Override
	protected void doReadPage() {
		List<BaseEntity> entities = repository.findByIdBetween(startId, endId, (new PageRequest(getPage(), getPageSize())));
		
		if (results == null) {
			results = new CopyOnWriteArrayList<BaseEntity>();
		}
		else {
			results.clear();
		}
		results.addAll(entities);		
	}

	public void setStartId(Long startId) {
		this.startId = startId;
	}

	public void setEndId(Long endId) {
		this.endId = endId;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		//ignore
	}

	@Override
	protected void doOpen() throws Exception {
		//ignore
	}

	@Override
	protected void doClose() throws Exception {
		//ignore
	}



}
