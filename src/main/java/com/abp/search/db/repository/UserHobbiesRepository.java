package com.abp.search.db.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.abp.search.db.model.UserHobbiesDAO;

public interface UserHobbiesRepository extends JpaRepository<UserHobbiesDAO, Long> {

	@Query(value="select profileLifestyleDtlId tempid, a.userId userId, group_concat(distinct b.genericName)favouritehobbies, " + 
			"       coalesce(FavouriteHobbiesRating,'')ratings " + 
			"FROM abpm_profile_lifestyle_dtl a " + 
			"left join abpm_generic_ b  " + 
			"on find_in_set(b.genericid,a.FavouriteHobbiesTypeIds) > 0 " + 
			"WHERE a.userId = ?1", nativeQuery = true)
	List<UserHobbiesDAO> getUserHobbiesData(@Param("userId") Long userId);
}
