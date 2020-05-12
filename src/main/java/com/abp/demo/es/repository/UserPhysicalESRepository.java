package com.abp.demo.es.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.abp.demo.es.model.UserPhysicalDAO;

@Repository
public interface UserPhysicalESRepository extends ElasticsearchRepository<UserPhysicalDAO, String> {
	
	List<UserPhysicalDAO> findByUserid(String userid);

}
