package com.abp.demo.es.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.abp.demo.es.model.UserProfessionalDAO;

@Repository
public interface UserProfessionalESRepository extends ElasticsearchRepository<UserProfessionalDAO, String> {
	
	List<UserProfessionalDAO> findByUserid(String userid);

}
