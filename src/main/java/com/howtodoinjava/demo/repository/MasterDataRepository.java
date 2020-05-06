package com.howtodoinjava.demo.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.howtodoinjava.demo.model.MasterData;

@Repository
public interface MasterDataRepository extends ElasticsearchRepository<MasterData, String> {
	
	List<MasterData> findByValue(String value);

	MasterData findByDataId(Long dataId);
	
}
