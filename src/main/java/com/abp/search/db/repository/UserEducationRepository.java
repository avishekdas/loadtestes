package com.abp.search.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.abp.search.db.model.UserEducationDAO;

public interface UserEducationRepository extends JpaRepository<UserEducationDAO, Long> {

	@Query(value="SELECT profileOccupationEducationDtlId tempid, a.userId userid, coalesce(b.genericName,'')highestqualification," + 
			"       coalesce(c.genericName,'')highestspecialization," + 
			"	   coalesce(a.highestSpecializationOthersVal,'')'highestothersspecialization'," + 
			"	   coalesce(highestEducationInstituteVal,'')highesteducationinstituteval," + 
			"	   coalesce(d.genericName,'')education2, " + 
			"	   coalesce(e.genericName,'')specialization2," + 
			"	   coalesce(a.Specialization2OthersVal,'')specialization2othersval," + 
			"	   coalesce(a.Education2InstituteVal,'')education2instituteval," + 
			"	   coalesce(f.genericName,'')education3id," + 
			"	   coalesce(g.genericName,'')specialization3," + 
			"	   coalesce(a.Specialization3OthersVal,'')specialization3othersval," + 
			"	   coalesce(a.Education3InstituteVal,'')education3instituteval," + 
			"	   coalesce(a.SchoolName1,'')schoolname " + 
			"FROM abpm_profile_occupation_education_dtl a " + 
			"left join abpm_generic_ b on a.highestEducationId = b.genericId " + 
			"left join abpm_generic_ c on a.highestSpecializationId = c.genericId " + 
			"left join abpm_generic_ d on a.Education2Id = d.genericId " + 
			"left join abpm_generic_ e on a.Specialization2Id = e.genericId " + 
			"left join abpm_generic_ f on a.Education3Id = f.genericId " + 
			"left join abpm_generic_ g on a.Specialization3Id = g.genericId " + 
			"WHERE a.userId = ?1", nativeQuery = true)
	UserEducationDAO getUserEducationData(@Param("userId") Long userId);
}
