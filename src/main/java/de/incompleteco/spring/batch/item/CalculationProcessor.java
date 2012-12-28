package de.incompleteco.spring.batch.item;

import org.springframework.batch.item.ItemProcessor;

import de.incompleteco.spring.batch.domain.BaseEntity;

public class CalculationProcessor implements ItemProcessor<BaseEntity, BaseEntity> {

	@Override
	public BaseEntity process(BaseEntity item) throws Exception {
		//calc
		item.setEndValue(item.getBaseValue() * 50.5);
		//set
		return item;
	}

}
