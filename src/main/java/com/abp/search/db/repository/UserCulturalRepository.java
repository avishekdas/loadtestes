package com.abp.search.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.abp.search.db.model.UserCulturalDAO;

public interface UserCulturalRepository extends JpaRepository<UserCulturalDAO, Long> {

	@Query(value="select matrimonyUserId tempid, matrimonyUserId userid, coalesce(b.homeTownText,'')hometown, " + 
			"       coalesce(d.genericName,'')'familytype', " + 
			"	   coalesce(e.genericName,'')'familystatus', " + 
			"	   coalesce(f.incomeRange,'')'familyincome', " + 
			"	   coalesce(g.genericName,'')'familyvalues', " + 
			"       coalesce(h.genericName,'')religion, " + 
			"	   coalesce(i.casteName,'')castename, " + 
			"	   coalesce(b.subCaste,'')subcaste, " + 
			"	   coalesce(j.genericName,'')fathersstatus, " + 
			"	   coalesce(k.genericName,'')fathersoccupationstatus, " + 
			"	   coalesce(l.genericName,'')fathersindustry, " + 
			"	   coalesce(m.genericName,'')mothersstatus, " + 
			"	   coalesce(n.genericName,'')mothersoccupationStatus, " + 
			"	   coalesce(o.genericName,'')mothersindustry " + 
			"from abpm_matrimony_user_ amu " + 
			"left join abpm_profile_personal_dtl b on amu.matrimonyUserId = b.userid " + 
			"left join abpm_generic_ h on b.religionId = h.genericId " + 
			"left join abpm_caste_dtl i on b.casteId = i.casteId " + 
			"left join abpm_profile_family_dtl c on amu.matrimonyUserId = c.userid " + 
			"left join abpm_generic_ d on c.familyTypeId = d.genericId " + 
			"left join abpm_generic_ e on c.familyStatusId = e.genericId " + 
			"left join abpm_incomemaster f on c.familyIncome = f.incomeId " + 
			"left join abpm_generic_ g on c.familyValueId = g.genericId " + 
			"left join abpm_generic_ j on c.fathersStatusId = j.genericId " + 
			"left join abpm_generic_ k on c.fathersOccupationId = k.genericId " + 
			"left join abpm_generic_ l on c.fathersIndustryId = l.genericId " + 
			"left join abpm_generic_ m on c.mothersStatusId = m.genericId " + 
			"left join abpm_generic_ n on c.mothersOccupationId = n.genericId " + 
			"left join abpm_generic_ o on c.mothersIndustryId = o.genericId " + 
			"where amu.matrimonyUserId = ?1", nativeQuery = true)
	UserCulturalDAO getUserCulturalData(@Param("userId") Long userId);
}
