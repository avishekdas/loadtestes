package com.abp.demo.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.abp.demo.db.model.PPUserEducationDAO;

public interface PPUserEducationRepository extends JpaRepository<PPUserEducationDAO, Long> {

	@Query(value="select app.partnerPreferenceId tempid, userid, " + 
			"group_concat(distinct ag3.genericdesc) 'minimumeducation', " + 
			"group_concat(distinct ai1.incomeRange) income, " + 
			"group_concat(distinct ag4.genericdesc) occupation, " + 
			"group_concat(distinct ag5.genericdesc) industry " + 
			"from abpm_partner_preference app " + 
			"left join abpm_generic_ ag3 on find_in_set(ag3.genericid, minimumEducation) > 0 " + 
			"left join abpm_incomemaster ai1 on find_in_set(ai1.incomeId, income) > 0 " + 
			"left join abpm_generic_ ag4 on find_in_set(ag4.genericid, occupationIds) > 0 " + 
			"left join abpm_generic_ ag5 on find_in_set(ag5.genericid, industryIds) > 0 " + 
			"where userid = ?1", nativeQuery = true)
	PPUserEducationDAO getPPUserEducationData(@Param("userId") Long userId);
}
