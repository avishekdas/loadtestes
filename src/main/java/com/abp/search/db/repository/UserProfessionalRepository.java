package com.abp.search.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.abp.search.db.model.UserProfessionalDAO;

public interface UserProfessionalRepository extends JpaRepository<UserProfessionalDAO, Long> {

	@Query(value="SELECT a.preModerationContentId tempid, a.userid userid, coalesce(c.genericName,'') occupation, " + 
			"              coalesce(d.genericName,'') designation, " + 
			"			  coalesce(b.companyName,'') company, " + 
			"              coalesce(e.genericName,'')industry, " + 
			"              coalesce(g.incomeRange,'')income " + 
			"FROM abpm_pre_moderation_content a " + 
			"left join abpm_profile_occupation_education_dtl b on a.userid = b.userid " + 
			"left join abpm_generic_ c on a.OccupationId = c.genericId " + 
			"left join abpm_generic_ d on a.DesignationId = d.genericId   " + 
			"left join abpm_generic_ e on a.IndustryId = e.genericId " + 
			"left join abpm_incomemaster g on a.AnnualIncome = g.incomeId " + 
			"WHERE a.userid = ?1", nativeQuery = true)
	UserProfessionalDAO getUserProfessionalData(@Param("userId") Long userId);
}
