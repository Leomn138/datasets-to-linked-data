package com.datasetstolinkeddata.dataset.service;

import com.datasetstolinkeddata.dataset.domain.Dataset;

import java.util.Set;

public interface DatasetService {

	Dataset findByName(String name);

	Dataset create(Dataset dataset);

	Set<Dataset> getAll();

	void delete(String name);

}
