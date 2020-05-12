package com.abp.demo.es.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.abp.demo.es.model.UserLifestyleDAO;

@Repository
public interface UserLifestyleESRepository extends ElasticsearchRepository<UserLifestyleDAO, String> {
	
	List<UserLifestyleDAO> findByUserid(String userid);

}
