package com.abp.demo.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.abp.demo.db.model.UserAstrologyDAO;

public interface UserAstrologyRepository extends JpaRepository<UserAstrologyDAO, Long> {

	@Query(value="SELECT profileAstrologyDtlId tempid, a.userId userid, coalesce(b.genericName,'')nakshatra, " + 
			"       coalesce(c.genericName,'')gothra, " + 
			"  coalesce(d.genericName,'')zodiac, " + 
			"  coalesce(e.genericName,'')rashi, " + 
			"  coalesce(f.genericName,'')gon, " +
			"   date_format(convert_tz( from_unixtime(timeOfBirth/1000), @@session.time_zone,'+05:30'), '%h:%i:%s %p') timeofbirth, " + 
			"  from_unixtime(dateOfBirth/1000,'%d-%m-%Y') 'dateofbirth', " + 
			"  coalesce(placeofbirth,'')'locationofbirth' " + 
			"FROM  abpm_profile_astrology_dtl a " + 
			"left join abpm_generic_ b on a.NakshatraId = b.genericId " + 
			"left join abpm_generic_ c on a.GothraId = c.genericId " + 
			"left join abpm_generic_ d on a.SunSignId = d.genericId " + 
			"left join abpm_generic_ e on a.MoonSignId = e.genericId " + 
			"left join abpm_generic_ f on a.gaanId = f.genericId " +
			"WHERE a.userId  = ?1", nativeQuery = true)
	UserAstrologyDAO getUserActrologyData(@Param("userId") Long userId);
}
