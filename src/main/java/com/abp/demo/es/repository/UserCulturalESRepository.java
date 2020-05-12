package com.abp.demo.es.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.abp.demo.es.model.UserCulturalDAO;

@Repository
public interface UserCulturalESRepository extends ElasticsearchRepository<UserCulturalDAO, String> {
	
	List<UserCulturalDAO> findByUserid(String userid);

}
