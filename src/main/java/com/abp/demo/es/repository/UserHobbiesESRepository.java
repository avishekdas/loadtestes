package com.abp.demo.es.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.abp.demo.es.model.UserHobbiesDAO;

@Repository
public interface UserHobbiesESRepository extends ElasticsearchRepository<UserHobbiesDAO, String> {
	
	List<UserHobbiesDAO> findByUserid(String userid);

}
