package com.abp.demo.db.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.abp.demo.db.model.UserAboutMeDAO;

public interface UserAboutMeRepository extends JpaRepository<UserAboutMeDAO, Long> {

	@Query(value="select b.preModerationAboutMeId tempid, b.userid userid, a.questionDesc question, coalesce(b.aboutDtlDesc,'')answer " + 
			"from abpm_pre_moderation_about_me b  " + 
			"left join abpm_question_master a on b.questionId = a.questionId " + 
			"where b.userid = ?1", nativeQuery = true)
	List<UserAboutMeDAO> getUserAboutMeData(@Param("userId") Long userId);
}
