package com.abp.search.es.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.abp.search.es.model.UserLifestyleDAO;

@Repository
public interface UserLifestyleESRepository extends ElasticsearchRepository<UserLifestyleDAO, String> {
	
	List<UserLifestyleDAO> findByUserid(String userid);

}
