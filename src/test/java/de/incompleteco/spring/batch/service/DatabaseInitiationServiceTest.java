package de.incompleteco.spring.batch.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.incompleteco.spring.batch.domain.BaseEntityRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:/META-INF/spring/batch-context.xml",
	"classpath:/META-INF/spring/service-context.xml"})
@ActiveProfiles(profiles="junit")
public class DatabaseInitiationServiceTest {

	@Autowired
	private ApplicationContext context;
	
	@Autowired
	private DatabaseInitiationService service;
	
	@Autowired
	private BaseEntityRepository repo;
	
	@Test
	public void test() {
		for (String string : context.getBeanDefinitionNames()) {
			System.out.println(string);
		}//end for
		service.setupService();
		
		System.out.println(repo.count());
	}

}
