package com.howtodoinjava.demo.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.howtodoinjava.demo.model.SampleData;

@Repository
public interface SampleDataRepository extends ElasticsearchRepository<SampleData, String> {
	
	SampleData findByTemp_id(Long temp_id);
	
	List<SampleData> findByRand1(String rand1);

	List<SampleData> findByRand2(String rand2);
	
	List<SampleData> findByRand3(String rand3);
	
	List<SampleData> findByRand4(String rand4);
	
	List<SampleData> findByFixed(String fixed);
}
