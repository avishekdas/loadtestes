package com.abp.search.es.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.abp.search.es.model.UserHobbiesDAO;

@Repository
public interface UserHobbiesESRepository extends ElasticsearchRepository<UserHobbiesDAO, String> {
	
	List<UserHobbiesDAO> findByUserid(String userid);

}
