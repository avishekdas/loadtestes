package com.abp.demo.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.abp.demo.db.model.UserPersonalDAO;

public interface UserPersonalRepository extends JpaRepository<UserPersonalDAO, Long> {

	@Query(value="select amu.matrimonyUserId tempid, amu.matrimonyUserId userid, date_format(convert_tz( from_unixtime(a.dob/1000), @@session.time_zone,'+05:30'), '%d-%m-%Y') 'dateofbirth', " + 
			"       concat(coalesce(c.locationName,''),',',coalesce(d.locationName,''),',',coalesce(e.locationName,'')) location, " + 
			"       coalesce(f.genericName,'')'maritalstatus', " + 
			"       coalesce(i.genericName,'')'numberofkids', " + 
			"       coalesce(h.genericName,'')mangalik " + 
			"from abpm_matrimony_user_ amu " + 
			"left join abpm_pre_moderation_content a on amu.matrimonyUserId = a.userid " + 
			"left join abpm_profile_personal_dtl b on amu.matrimonyUserId = b.userid " + 
			"left join abpm_generic_ i on b.numChildrenProspect = i.genericId " + 
			"left join abpm_generic_location c on b.locationid = c.locationId " + 
			"left join abpm_generic_location d on b.stateId = d.locationId " + 
			"left join abpm_generic_location e on b.countryId = e.locationId " + 
			"left join abpm_generic_ f on b.maritalStatusId = f.genericId " + 
			"left join abpm_profile_astrology_dtl g on amu.matrimonyUserId = g.userid " + 
			"left join abpm_generic_ h on g.ManglikFlagId = h.genericId " + 
			"where amu.matrimonyUserId = ?1", nativeQuery = true)
	UserPersonalDAO getUserPersonalData(@Param("userId") Long userId);
}
