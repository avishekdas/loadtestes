package com.abp.search.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.abp.search.db.model.PPUserFamilyDAO;

public interface PPUserFamilyRepository extends JpaRepository<PPUserFamilyDAO, Long> {

	@Query(value="select app.partnerPreferenceId tempid, userid, " + 
			"group_concat(distinct ag7.genericdesc) 'familytype', " + 
			"group_concat(distinct ag16.genericdesc) 'familyorigin', " + 
			"group_concat(distinct ai2.incomeRange) 'familyincome', " + 
			"group_concat(distinct ag1.genericdesc) religion, " + 
			"group_concat(distinct ag2.genericdesc) 'mothertongue', " + 
			"group_concat(distinct casteName) caste, " + 
			"subcaste, " + 
			"group_concat(distinct ag12.genericdesc) gothra, " + 
			"group_concat(distinct ag15.genericdesc) gaan " + 
			"from abpm_partner_preference app " + 
			"left join abpm_generic_ ag7 on find_in_set(ag7.genericid, familyTypeIds) > 0 " + 
			"left join abpm_generic_ ag16 on find_in_set(ag16.genericid, familyOriginPartnerPrefId) > 0 " + 
			"left join abpm_incomemaster ai2 on find_in_set(ai2.incomeId, familyIncome) > 0 " + 
			"left join abpm_generic_ ag1 on find_in_set(ag1.genericid, religionIds) > 0 " + 
			"left join abpm_generic_ ag2 on find_in_set(ag2.genericid, motherTongueIds) > 0 " + 
			"left join abpm_generic_ ag12 on find_in_set(ag12.genericid, gothraIds) > 0 " + 
			"left join abpm_generic_ ag15 on find_in_set(ag15.genericid, gaanIds) > 0 " + 
			"left join abpm_caste_dtl acd on find_in_set(acd.casteid, casteIds) > 0 " + 
			"where userid = ?1", nativeQuery = true)
	PPUserFamilyDAO getPPUserFamilyData(@Param("userId") Long userId);
}
