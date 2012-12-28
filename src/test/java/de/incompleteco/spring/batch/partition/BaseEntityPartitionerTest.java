package de.incompleteco.spring.batch.partition;

import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.partition.support.Partitioner;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.incompleteco.spring.batch.service.DatabaseInitiationService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:/META-INF/spring/*-context.xml"})
@ActiveProfiles(profiles="junit")
public class BaseEntityPartitionerTest {

	@Autowired
	private Partitioner partitioner;
	
	@Autowired
	private DatabaseInitiationService service;
		
	@Test
	public void test() {
		//call the service to build some records
		service.setupService();
		//lets have a look at the maps return
		Map<String,ExecutionContext> contexts = partitioner.partition(3);//divide by 3
		for (Entry<String,ExecutionContext> entry : contexts.entrySet()) {
			System.out.println(entry);
		}
	}

}
