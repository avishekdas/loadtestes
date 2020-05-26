package com.abp.search.es.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.abp.search.es.model.UserAboutMeDAO;

@Repository
public interface UserAboutMeESRepository extends ElasticsearchRepository<UserAboutMeDAO, String> {
	
	List<UserAboutMeDAO> findByUserid(String userid);

}
