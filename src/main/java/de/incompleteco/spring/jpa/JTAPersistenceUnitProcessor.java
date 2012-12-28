package de.incompleteco.spring.jpa;

import javax.persistence.spi.PersistenceUnitTransactionType;

import org.springframework.orm.jpa.persistenceunit.MutablePersistenceUnitInfo;
import org.springframework.orm.jpa.persistenceunit.PersistenceUnitPostProcessor;

public class JTAPersistenceUnitProcessor implements PersistenceUnitPostProcessor {

	@Override
	public void postProcessPersistenceUnitInfo(MutablePersistenceUnitInfo persistenceUnitInfo) {
		persistenceUnitInfo.setJtaDataSource(persistenceUnitInfo.getNonJtaDataSource());
		persistenceUnitInfo.setNonJtaDataSource(null);
		persistenceUnitInfo.setTransactionType(PersistenceUnitTransactionType.JTA);
	}

}
