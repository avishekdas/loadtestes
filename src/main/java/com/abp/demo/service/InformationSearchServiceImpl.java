package com.abp.demo.service;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.abp.demo.db.repository.MasterDataRepository;
import com.abp.demo.db.repository.SampleDataRepository;
import com.abp.demo.es.model.MasterData;
import com.abp.demo.es.model.SampleData;

@Service
public class InformationSearchServiceImpl implements InformationSearchService {

	private static final Logger LOGGER = LoggerFactory.getLogger(InformationSearchServiceImpl.class);

	@Autowired
	MasterDataRepository masterDataRepository;
	@Autowired
	SampleDataRepository sampleDataRepository;
	@Autowired
	private SearchQueryBuilder searchQueryBuilder;
	@Resource
	private Environment env;

	@Override
	public MasterData elasticSearchMasterData(MasterData data) {
		masterDataRepository.save(data);
		return data;
	}

	@Override
	public List<MasterData> elasticSearchMasterData(String searchString) {

		List<MasterData> dataAll = searchQueryBuilder.searchMasterDataByValue(searchString);
		return dataAll;
	}

	@Override
	public List<MasterData> elasticSearchMasterData(String searchType, String searchString) {

		List<MasterData> dataAll = searchQueryBuilder.searchMasterDataByValue(searchType, searchString);
		return dataAll;
	}

	@Override
	public String masterDataDelete(String tempId) {
		MasterData deleteMasterData = masterDataRepository.findByDataId(Long.parseLong(tempId));
		masterDataRepository.delete(deleteMasterData);
		return tempId;
	}

	@Override
	public SampleData elasticSearchSampleData(SampleData data) {
		sampleDataRepository.save(data);
		return data;
	}

	@Override
	public List<SampleData> elasticSearchSampleData(String searchString) {

		List<SampleData> dataAll = searchQueryBuilder.searchSampleDataByValue(searchString);
		return dataAll;
	}

	@Override
	public List<SampleData> elasticSearchSampleData(String searchType, String searchString) {

		List<SampleData> dataAll = searchQueryBuilder.searchSampleDataByValue(searchType, searchString);
		return dataAll;
	}

	@Override
	public String sampleDataDelete(String tempId) {
		SampleData deleteMasterData = sampleDataRepository.findByTempId(Long.parseLong(tempId));
		sampleDataRepository.delete(deleteMasterData);
		return tempId;
	}

}
