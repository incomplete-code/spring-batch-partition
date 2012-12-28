package de.incompleteco.spring.batch;

import static com.jayway.awaitility.Awaitility.await;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.Callable;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.explore.JobExplorer;
import org.springframework.batch.core.launch.JobOperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.incompleteco.spring.batch.domain.BaseEntityRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:/META-INF/spring/*-context.xml"})
@ActiveProfiles(profiles="junit")
public class BatchTest {

	@Autowired
	private JobOperator jobOperator;
	
	@Autowired
	private JobExplorer jobExplorer;
	
	@Autowired
	private BaseEntityRepository repository;
	
	@Ignore
	@Test
	public void testSimpleServiceJob() throws Exception {
		//start the job
		long executionId = jobOperator.start("simpleServiceJob", "runtime=1");
		//monitor it
		await().until(finished(executionId));
		//check success
		JobExecution execution = jobExplorer.getJobExecution(executionId);
		assertEquals(ExitStatus.COMPLETED.getExitCode(),execution.getExitStatus().getExitCode());
	}

	@Test
	public void testPartitionedJob() throws Exception {
		//start the job
		long executionId = jobOperator.start("partitionedJob", "runtime=1");
		//monitor it
		await().until(finished(executionId));
		//check success
		JobExecution execution = jobExplorer.getJobExecution(executionId);
		assertEquals(ExitStatus.COMPLETED.getExitCode(),execution.getExitStatus().getExitCode());
		//check the count
		assertTrue(repository.count() > 1);
		//check the time
		System.out.println(execution.getEndTime().getTime() - execution.getStartTime().getTime());
	}	
	
	
	private Callable<Boolean> finished(final long executionId) {
		return new Callable<Boolean>() {
			public Boolean call() throws Exception {
				return jobExplorer.getJobExecution(executionId).isRunning() == false;
			}
		};
	}
	
}
