package com.datasetstolinkeddata.dataset.controller;

import com.datasetstolinkeddata.dataset.domain.Dataset;
import com.datasetstolinkeddata.dataset.service.DatasetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

@RestController
public class DatasetController {

	@Autowired
	private DatasetService datasetService;

	@RequestMapping(path = "/{name}", method = RequestMethod.GET)
	public Dataset getDatasetByName(@PathVariable String name) {
		return datasetService.findByName(name);
	}

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public Set<Dataset> getAllDatasets() {
		return datasetService.getAll();
	}

	@RequestMapping(path = "/", method = RequestMethod.POST)
	public Dataset createNewDataset(@Valid @RequestBody Dataset dataset) {
		return datasetService.create(dataset);
	}

	@RequestMapping(path = "/{name}", method = RequestMethod.DELETE)
	public void deleteDataset(@PathVariable String name) {
		datasetService.delete(name);
	}
}
