package de.incompleteco.spring.batch.partition;

import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.core.partition.support.Partitioner;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.beans.factory.annotation.Autowired;

import de.incompleteco.spring.batch.domain.BaseEntityRepository;

public class BaseEntityPartitioner implements Partitioner {

	private static final String PREFIX = "partitionedJob.step2:partition:";
	
	@Autowired
	private BaseEntityRepository repository;
	
	@Override
	public Map<String, ExecutionContext> partition(int gridSize) {
		Map<String,ExecutionContext> partitions = new HashMap<String,ExecutionContext>(gridSize);
		long count = repository.count();
		long recordCount = count / gridSize;
		//do the split
		for (int i=0;i<gridSize;i++) {
			ExecutionContext context = new ExecutionContext();
			context.putLong("paramB",count);
			count = count - recordCount;
			if (count != 1) {
				context.putLong("paramA",count + 1);
			} else {
				context.putLong("paramA",count);				
			}//end if
			partitions.put(PREFIX + i,context);
		}//end for
		//return
		return partitions;
	}
	

}
