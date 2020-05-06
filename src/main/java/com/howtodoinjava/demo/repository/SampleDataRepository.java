package com.howtodoinjava.demo.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.howtodoinjava.demo.model.SampleData;

@Repository
public interface SampleDataRepository extends ElasticsearchRepository<SampleData, String> {
	
	List<SampleData> findByValue(String value);

	SampleData findByDataId(Long dataId);
	
}
