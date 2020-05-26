package com.abp.search.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.abp.search.db.model.UserLifestyleDAO;

public interface UserLifestyleRepository extends JpaRepository<UserLifestyleDAO, Long> {

	@Query(value="SELECT profileLifestyleDtlId tempid, a.userId userid, coalesce(b.genericName,'')smoking, " + 
			"		coalesce(c.genericName,'')drinking, " + 
			"		coalesce(d.genericName,'')'foodPreferences', " + 
			"		coalesce(e.genericName,'')'houselivingin', " + 
			"		coalesce(g.genericName,'')children, " + 
			"		coalesce(f.genericName,'')vehicleTypeOwned, " + 
			"		coalesce(VehicleNumber,0)vehicleNumber, " + 
			"		coalesce(h.genericName,'')pets " + 
			"FROM abpm_profile_lifestyle_dtl a " + 
			"left join abpm_generic_ b on a.SmokingStatusId = b.genericId " + 
			"left join abpm_generic_ c on a.DrinkingStatusId = c.genericId " + 
			"left join abpm_generic_ d on a.FoodHabitsId = d.genericId " + 
			"left join abpm_generic_ e on a.LivingInHouseTypeId = e.genericId " + 
			"left join abpm_generic_ f on a.VehicleTypeOwnedId = f.genericId " + 
			"left join abpm_generic_ g on a.NumberOfKids = g.genericId " + 
			"left join abpm_generic_ h on a.Petsid = h.genericId " + 
			"WHERE a.userId = ?1", nativeQuery = true)
	UserLifestyleDAO getUserLifestyleData(@Param("userId") Long userId);
}
