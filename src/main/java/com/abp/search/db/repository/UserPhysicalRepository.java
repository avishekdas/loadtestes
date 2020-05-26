package com.abp.search.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.abp.search.db.model.UserPhysicalDAO;

public interface UserPhysicalRepository extends JpaRepository<UserPhysicalDAO, Long> {

	@Query(value="SELECT a.profilePhysicalAttributesDtlId tempid, a.userId userid, coalesce(b.genericName,'') as 'physicalappearance',  " + 
			"        coalesce(substring_index(height,'.',1)*1,0)heightft, " + 
			"		coalesce(substring_index(height,'.',-1)*1,0)heightin, " + 
			"        coalesce(c.genericName,'')complexion,   " + 
			"        coalesce(d.genericName,'')bloodGroup, " + 
			"		coalesce(e.genericName,'')disabilities,   " + 
			"        coalesce(f.genericName,'')'knownailment'	 " + 
			"FROM  abpm_profile_physical_attributes_dtl a " + 
			"left join abpm_generic_ b on a.BodyTypeId = b.genericId " + 
			"left join abpm_generic_ c on a.ComplexionId = c.genericId " + 
			"left join abpm_generic_ d on a.BloodGroupId = d.genericId " + 
			"left join abpm_generic_ e on a.disabilitiesId = e.genericId " + 
			"left join abpm_generic_ f on a.knownAilmentId = f.genericId " + 
			"WHERE a.userId  = ?1", nativeQuery = true)
	UserPhysicalDAO getUserPhysicalData(@Param("userId") Long userId);
}
