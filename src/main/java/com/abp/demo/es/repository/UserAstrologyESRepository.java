package com.abp.demo.es.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.abp.demo.es.model.UserAstrologyDAO;

@Repository
public interface UserAstrologyESRepository extends ElasticsearchRepository<UserAstrologyDAO, String> {
	
	List<UserAstrologyDAO> findByUserid(String userid);

}
