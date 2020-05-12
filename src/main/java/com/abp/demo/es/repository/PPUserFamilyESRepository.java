package com.abp.demo.es.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.abp.demo.es.model.PPUserFamilyDAO;

@Repository
public interface PPUserFamilyESRepository extends ElasticsearchRepository<PPUserFamilyDAO, String> {
	
	List<PPUserFamilyDAO> findByUserid(String userid);

}
