package com.datasetstolinkeddata.dataset.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.datasetstolinkeddata.dataset.domain.*;
import com.datasetstolinkeddata.dataset.service.DatasetService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class DatasetControllerTest {

	private static final ObjectMapper mapper = new ObjectMapper();

	@InjectMocks
	private DatasetController datasetController;

	@Mock
	private DatasetService datasetService;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(datasetController).build();
	}

	@Test
	public void shouldGetDatasetByName() throws Exception {

		final Dataset dataset = new Dataset();
		dataset.setName("test");

		when(datasetService.findByName(dataset.getName())).thenReturn(dataset);

		mockMvc.perform(get("/" + dataset.getName()))
				.andExpect(jsonPath("$.name").value(dataset.getName()))
				.andExpect(status().isOk());
	}

	@Test
	public void shouldDeleteDataset() throws Exception {

		final Dataset dataset = new Dataset();
		dataset.setName("test");

		when(datasetService.findByName(dataset.getName())).thenReturn(dataset);

		mockMvc.perform(delete("/" + dataset.getName()))
				.andExpect(status().isOk());
	}

	@Test
	public void shouldCreateNewDataset() throws Exception {

		final Dataset dataset = new Dataset();
		dataset.setName("test");

		when(datasetService.create(dataset)).thenReturn(dataset);

		mockMvc.perform(post("/" )
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.param("name", "test")
				.param("url", "test"))
				.andExpect(status().isOk());
	}

	@Test
	public void shouldGetAllDatasets() throws Exception {

		final Dataset dataset = new Dataset();
		dataset.setName("test");

		Set<Dataset> datasetSet = new HashSet<Dataset>();
		datasetSet.add(dataset);

		when(datasetService.getAll()).thenReturn(datasetSet);

		mockMvc.perform(get("/"))
				.andExpect(status().isOk());

	}
}
