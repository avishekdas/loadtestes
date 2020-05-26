package com.abp.search.es.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.abp.search.es.model.UserPersonalDAO;

@Repository
public interface UserPersonalESRepository extends ElasticsearchRepository<UserPersonalDAO, String> {
	
	List<UserPersonalDAO> findByUserid(String userid);

}
