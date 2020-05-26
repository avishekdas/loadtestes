package com.abp.search.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.abp.search.db.model.PPUserPersonalDAO;

public interface PPUserPersonalRepository extends JpaRepository<PPUserPersonalDAO, Long> {

	@Query(value="select app.partnerPreferenceId tempid, userid, agefrom, ageto, height, heightfrom, heightto, " + 
			"group_concat(distinct ag9.genericdesc) 'maritalstatus', " + 
			"group_concat(distinct agl.locationName) 'locationname', " + 
			"ag13.genericdesc manglik, " + 
			"group_concat(distinct ag14.genericdesc) profilecreatedby, " + 
			"aboutpartner " +
			"from abpm_partner_preference app " + 
			"left join abpm_generic_location agl on find_in_set(agl.locationId, locationNameIds) > 0 " + 
			"left join abpm_generic_ ag9 on find_in_set(ag9.genericid, maritalStatusIds) > 0 " + 
			"left join abpm_generic_ ag13 on ag13.genericid = manglikId " + 
			"left join abpm_generic_ ag14 on find_in_set(ag14.genericid, profileCreatedby) > 0 " + 
			"where userid = ?1", nativeQuery = true)
	PPUserPersonalDAO getPPUserPersonalData(@Param("userId") Long userId);
}
