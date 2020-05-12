package com.abp.demo.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.abp.demo.db.model.PPUserLifestyleDAO;

public interface PPUserLifestyleRepository extends JpaRepository<PPUserLifestyleDAO, Long> {

	@Query(value="select app.partnerPreferenceId tempid, userid, " + 
			"group_concat(distinct ag10.genericdesc) smoking, " + 
			"group_concat(distinct ag8.genericdesc) drinking, " + 
			"group_concat(distinct ag11.genericdesc) 'foodhabit', " + 
			"group_concat(distinct ag6.genericdesc) 'bodytype', " + 
			"group_concat(distinct ag17.genericdesc) knownailment, " + 
			"group_concat(distinct ag18.genericdesc) disablities " + 
			"from abpm_partner_preference app " + 
			"left join abpm_generic_ ag10 on find_in_set(ag10.genericid, smokingIds) > 0 " + 
			"left join abpm_generic_ ag8 on find_in_set(ag8.genericid, drinkingId) > 0 " + 
			"left join abpm_generic_ ag11 on find_in_set(ag11.genericid, foodHabitsIds) > 0 " + 
			"left join abpm_generic_ ag6 on find_in_set(ag6.genericid, bodyTypeIds) > 0 " + 
			"left join abpm_generic_ ag17 on find_in_set(ag17.genericid, knownAilment) > 0 " + 
			"left join abpm_generic_ ag18 on find_in_set(ag18.genericid, disablities) > 0 " + 
			"where userid = ?1", nativeQuery = true)
	PPUserLifestyleDAO getPPUserLifestyleData(@Param("userId") Long userId);
}
