package com.datasetstolinkeddata.dataset.service;

import com.datasetstolinkeddata.dataset.domain.Dataset;
import com.datasetstolinkeddata.dataset.repository.DatasetRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class DatasetServiceImpl implements DatasetService {

	private final Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	private DatasetRepository repository;

	@Override
	public Dataset findByName(String name) {
		Assert.hasLength(name);
		return repository.findByName(name);
	}

	@Override
	public Dataset create(Dataset dataset) {
		Dataset existing = repository.findByName(dataset.getName());
		Assert.isNull(existing);

		repository.save(dataset);

		log.info("New dataset is being observed: " + dataset.getName());

		return dataset;
	}

	@Override
	public Set<Dataset> getAll() {
		Set<Dataset> datasetsSet = new HashSet<Dataset>((Collection)repository.findAll());

		return datasetsSet;
	}

	@Override
	public void delete(String name) {
		Dataset existing = repository.findByName(name);
		Assert.notNull(existing);

		repository.delete(existing);

		log.info("Dataset is deleted: " + name);
	}

}
