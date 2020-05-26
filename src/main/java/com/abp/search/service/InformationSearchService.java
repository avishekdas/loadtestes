package com.abp.search.service;

import java.util.List;

import com.abp.search.es.model.MasterData;
import com.abp.search.es.model.SampleData;

public interface InformationSearchService {

	MasterData elasticSearchMasterData(MasterData data);

	List<MasterData> elasticSearchMasterData(String searchString);

	List<MasterData> elasticSearchMasterData(String searchType, String searchString);

	String masterDataDelete(String tempId);

	SampleData elasticSearchSampleData(SampleData data);

	List<SampleData> elasticSearchSampleData(String searchString);

	List<SampleData> elasticSearchSampleData(String searchType, String searchString);

	String sampleDataDelete(String tempId);
}
