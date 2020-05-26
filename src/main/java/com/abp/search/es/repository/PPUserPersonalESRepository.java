package com.abp.search.es.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.abp.search.es.model.PPUserPersonalDAO;

@Repository
public interface PPUserPersonalESRepository extends ElasticsearchRepository<PPUserPersonalDAO, String> {
	
	List<PPUserPersonalDAO> findByUserid(String userid);

}
