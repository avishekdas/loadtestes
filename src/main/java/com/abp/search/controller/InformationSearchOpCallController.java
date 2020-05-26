package com.abp.search.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.abp.search.db.repository.MasterDataRepository;
import com.abp.search.db.repository.SampleDataRepository;
import com.abp.search.dto.PPUserInputDTO;
import com.abp.search.dto.UserInputDTO;
import com.abp.search.es.model.AbstractPPUserDAO;
import com.abp.search.es.model.AbstractUserDAO;
import com.abp.search.es.model.MasterData;
import com.abp.search.es.model.SampleData;
import com.abp.search.service.InformationSearchService;
import com.abp.search.service.MultiThreadedTrigger;
import com.abp.search.service.UserSearchService;

@RestController
@RequestMapping("/search")
public class InformationSearchOpCallController {

	@Autowired
	private InformationSearchService informationSearchService;
	@Autowired
	MasterDataRepository masterDataRepository;
	@Autowired
	SampleDataRepository sampleDataRepository;
	@Autowired
	MultiThreadedTrigger threadTrigger;
	@Autowired
	UserSearchService userSearchService;

	@PostMapping(value = "/elastic_search_master_data")
	public ResponseEntity<MasterData> elasticSearchMasterData(@RequestBody @Valid MasterData masterDate)
			throws Exception {
		return new ResponseEntity<MasterData>(informationSearchService.elasticSearchMasterData(masterDate),
				(HttpStatus.OK));
	}

	@GetMapping(value = "/elastic_search_master_data")
	public ResponseEntity<List<MasterData>> elasticSearchGetMasterDataList(
			@RequestParam(value = "searchString", required = true) String searchString) throws Exception {
		return new ResponseEntity<List<MasterData>>(informationSearchService.elasticSearchMasterData(searchString),
				(HttpStatus.OK));
	}

	@GetMapping(value = "/elastic_search_master_data/{searchType}/{searchString}")
	public ResponseEntity<List<MasterData>> elasticSearchGetMasterDataListByType(@PathVariable String searchType,
			@PathVariable String searchString) throws Exception {
		return new ResponseEntity<List<MasterData>>(
				informationSearchService.elasticSearchMasterData(searchType, searchString), (HttpStatus.OK));
	}

	@RequestMapping(value = "/elastic_search_master_data/{dataId}", method = RequestMethod.DELETE)
	public ResponseEntity<String> masterDataDelete(@PathVariable String dataId) {
		return new ResponseEntity<String>(informationSearchService.masterDataDelete(dataId), HttpStatus.OK);
	}

	@RequestMapping(value = "/elastic_search_master_data", method = RequestMethod.DELETE)
	public ResponseEntity<Void> masterDataDeleteAll() {
		masterDataRepository.deleteAll();
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	// Loadtest
	@PostMapping(value = "/elastic_search_sampledata")
	public ResponseEntity<SampleData> elasticSearchSampleData(@RequestBody @Valid SampleData sampleDate)
			throws Exception {
		return new ResponseEntity<SampleData>(informationSearchService.elasticSearchSampleData(sampleDate),
				(HttpStatus.OK));
	}

	@GetMapping(value = "/elastic_search_sampledata")
	public ResponseEntity<List<SampleData>> elasticSearchGeSampleData(
			@RequestParam(value = "searchString", required = true) String searchString) throws Exception {
		return new ResponseEntity<List<SampleData>>(informationSearchService.elasticSearchSampleData(searchString),
				(HttpStatus.OK));
	}

	@GetMapping(value = "/elastic_search_sampledata/{searchType}/{searchString}")
	public ResponseEntity<List<SampleData>> elasticSearchGetSampleDataByField(@PathVariable String searchType,
			@PathVariable String searchString) throws Exception {
		return new ResponseEntity<List<SampleData>>(
				informationSearchService.elasticSearchSampleData(searchType, searchString), (HttpStatus.OK));
	}

	@RequestMapping(value = "/elastic_search_sampledata/{dataId}", method = RequestMethod.DELETE)
	public ResponseEntity<String> sampleDataDelete(@PathVariable String dataId) {
		return new ResponseEntity<String>(informationSearchService.sampleDataDelete(dataId), HttpStatus.OK);
	}

	@RequestMapping(value = "/elastic_search_sampledata", method = RequestMethod.DELETE)
	public ResponseEntity<Void> sampleDataDeleteAll() {
		sampleDataRepository.deleteAll();
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@GetMapping(value = "/populate_data/{numberOfRequests}/{numberOfThreads}")
	public ResponseEntity<String> populateSampleData(@PathVariable String numberOfRequests,
			@PathVariable String numberOfThreads) throws Exception {
		try {
			threadTrigger.run(Integer.parseInt(numberOfRequests), Integer.parseInt(numberOfThreads));
			return new ResponseEntity<String>("Successfully triggered", (HttpStatus.OK));
		} catch (NumberFormatException e) {
			return new ResponseEntity<String>("Failed to triggered", (HttpStatus.BAD_REQUEST));
		}
	}

	@GetMapping(value = "/populate_user/{numberOfRequests}/{numberOfThreads}")
	public ResponseEntity<String> populateUserData(@PathVariable String numberOfRequests,
			@PathVariable String numberOfThreads) throws Exception {
		try {
			threadTrigger.run(Integer.parseInt(numberOfRequests), Integer.parseInt(numberOfThreads));
//			informationSearchService.fetchUserDataFromDB(Long.parseLong(userId));
			return new ResponseEntity<String>("Successfully triggered", (HttpStatus.OK));
		} catch (NumberFormatException e) {
			return new ResponseEntity<String>("Failed to triggered", (HttpStatus.BAD_REQUEST));
		}
	}

	@PostMapping(value = "/update_user")
	public ResponseEntity<String> updateUserData(@RequestBody @Valid UserInputDTO userData) throws Exception {
		boolean flag = userSearchService.updateUserData(userData);
		if (flag) {
			return new ResponseEntity<String>("Success", (HttpStatus.OK));
		} else {
			return new ResponseEntity<String>("Failure", (HttpStatus.OK));
		}
	}
	
	@PostMapping(value = "/update_ppuser")
	public ResponseEntity<String> updatePPUserData(@RequestBody @Valid PPUserInputDTO ppUserData) throws Exception {
		boolean flag = userSearchService.updatePPUserData(ppUserData);
		if (flag) {
			return new ResponseEntity<String>("Success", (HttpStatus.OK));
		} else {
			return new ResponseEntity<String>("Failure", (HttpStatus.OK));
		}
	}
	
	@PostMapping(value = "/search_user")
	public ResponseEntity<List<AbstractUserDAO>> searchUserData(@RequestBody @Valid UserInputDTO userData) throws Exception {
		List<AbstractUserDAO> list = userSearchService.searchUserData(userData);
		return new ResponseEntity<List<AbstractUserDAO>>(list, (HttpStatus.OK));
	}
	
	@PostMapping(value = "/search_ppuser")
	public ResponseEntity<List<AbstractPPUserDAO>> searchPPUserData(@RequestBody @Valid PPUserInputDTO ppUserData) throws Exception {
		List<AbstractPPUserDAO> list = userSearchService.searchPPUserData(ppUserData);
		return new ResponseEntity<List<AbstractPPUserDAO>>(list, (HttpStatus.OK));
	}
	
}
