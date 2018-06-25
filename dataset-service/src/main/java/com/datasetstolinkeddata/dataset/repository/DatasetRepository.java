package com.datasetstolinkeddata.dataset.repository;

import com.datasetstolinkeddata.dataset.domain.Dataset;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DatasetRepository extends CrudRepository<Dataset, String> {
	Dataset findByName(String name);
}
