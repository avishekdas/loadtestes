package com.abp.demo.db.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.abp.demo.db.model.UserDAO;

public interface UserRepository extends JpaRepository<UserDAO, Long> {

	@Query(value="SELECT distinct(createdby) userid " + 
			"FROM abpm_user_session_dtl " + 
			"WHERE fromTime >= unix_timestamp(date_sub(curdate(), interval 90 day)) * 1000 " + 
			"AND createdby <> 0 LIMIT ?1", nativeQuery = true)
	List<UserDAO> getUserList(@Param("count") int count);
}
