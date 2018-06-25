package com.datasetstolinkeddata.dataset.service;

import com.datasetstolinkeddata.dataset.domain.*;
import com.datasetstolinkeddata.dataset.repository.DatasetRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Arrays;
import java.util.Date;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

public class DatasetServiceTest {

	@InjectMocks
	private DatasetServiceImpl datasetService;

	@Mock
	private DatasetRepository repository;

	@Before
	public void setup() {
		initMocks(this);
	}

	@Test
	public void shouldFindByName() {

		final Dataset dataset = new Dataset();
		dataset.setName("test");

		when(repository.findByName(dataset.getName())).thenReturn(dataset);
		Dataset found = datasetService.findByName(dataset.getName());

		assertEquals(dataset, found);
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldFailWhenNameIsEmpty() {
        datasetService.findByName("");
	}

	@Test
	public void shouldCreateNewDataset() {
		final Dataset dataset = getStubDataset();

		when(repository.findByName(dataset.getName())).thenReturn(null);
		when(repository.save(dataset)).thenReturn(null);

		Dataset found = datasetService.create(dataset);

		assertEquals(dataset, found);
	}

	@Test(expected = IllegalArgumentException.class)
	public void createShouldFailWhenDatasetAlreadyExists() {
		final Dataset dataset = getStubDataset();

		when(repository.findByName(dataset.getName())).thenReturn(dataset);
        when(repository.save(dataset)).thenReturn(null);

		datasetService.create(dataset);
	}

    @Test
    public void shouldDeleteExistingDataset() {
        final Dataset dataset = getStubDataset();

        when(repository.findByName(dataset.getName())).thenReturn(dataset);

        datasetService.delete(dataset.getName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void deleteShouldFailWhenDatasetDoesNotExist() {
        final Dataset dataset = getStubDataset();

        when(repository.findByName(dataset.getName())).thenReturn(null);

        datasetService.delete(dataset.getName());
    }

	@Test
	public void shouldFindAllDatasets() {
		final Dataset dataset = getStubDataset();
		Iterable<Dataset> iterableDataset = Arrays.asList(dataset);

		when(repository.findAll()).thenReturn(iterableDataset);

		Set<Dataset> response = datasetService.getAll();

		assertEquals(response.contains(dataset), true);
	}

	private Dataset getStubDataset() {
		Dataset dataset = new Dataset();
		dataset.setUrl("teste2");
		dataset.setCreatedDate(new Date());

		return dataset;
	}
}
