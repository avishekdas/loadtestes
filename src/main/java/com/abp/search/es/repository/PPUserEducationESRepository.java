package com.abp.search.es.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.abp.search.es.model.PPUserEducationDAO;

@Repository
public interface PPUserEducationESRepository extends ElasticsearchRepository<PPUserEducationDAO, String> {
	
	List<PPUserEducationDAO> findByUserid(String userid);

}
