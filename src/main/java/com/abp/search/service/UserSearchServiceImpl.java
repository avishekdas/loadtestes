package com.abp.search.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.abp.search.db.model.PPUserEducationDAO;
import com.abp.search.db.model.PPUserFamilyDAO;
import com.abp.search.db.model.PPUserLifestyleDAO;
import com.abp.search.db.model.PPUserPersonalDAO;
import com.abp.search.db.model.UserAboutMeDAO;
import com.abp.search.db.model.UserAstrologyDAO;
import com.abp.search.db.model.UserCulturalDAO;
import com.abp.search.db.model.UserEducationDAO;
import com.abp.search.db.model.UserHobbiesDAO;
import com.abp.search.db.model.UserLifestyleDAO;
import com.abp.search.db.model.UserPersonalDAO;
import com.abp.search.db.model.UserPhysicalDAO;
import com.abp.search.db.model.UserProfessionalDAO;
import com.abp.search.db.repository.PPUserEducationRepository;
import com.abp.search.db.repository.PPUserFamilyRepository;
import com.abp.search.db.repository.PPUserLifestyleRepository;
import com.abp.search.db.repository.PPUserPersonalRepository;
import com.abp.search.db.repository.UserAboutMeRepository;
import com.abp.search.db.repository.UserAstrologyRepository;
import com.abp.search.db.repository.UserCulturalRepository;
import com.abp.search.db.repository.UserEducationRepository;
import com.abp.search.db.repository.UserHobbiesRepository;
import com.abp.search.db.repository.UserLifestyleRepository;
import com.abp.search.db.repository.UserPersonalRepository;
import com.abp.search.db.repository.UserPhysicalRepository;
import com.abp.search.db.repository.UserProfessionalRepository;
import com.abp.search.dto.PPUserInputDTO;
import com.abp.search.dto.UserAboutMeDTO;
import com.abp.search.dto.UserHobbyDTO;
import com.abp.search.dto.UserInputDTO;
import com.abp.search.es.model.AbstractPPUserDAO;
import com.abp.search.es.model.AbstractUserDAO;
import com.abp.search.es.repository.PPUserEducationESRepository;
import com.abp.search.es.repository.PPUserFamilyESRepository;
import com.abp.search.es.repository.PPUserLifestyleESRepository;
import com.abp.search.es.repository.PPUserPersonalESRepository;
import com.abp.search.es.repository.UserAboutMeESRepository;
import com.abp.search.es.repository.UserAstrologyESRepository;
import com.abp.search.es.repository.UserCulturalESRepository;
import com.abp.search.es.repository.UserEducationESRepository;
import com.abp.search.es.repository.UserHobbiesESRepository;
import com.abp.search.es.repository.UserLifestyleESRepository;
import com.abp.search.es.repository.UserPersonalESRepository;
import com.abp.search.es.repository.UserPhysicalESRepository;
import com.abp.search.es.repository.UserProfessionalESRepository;
import com.abp.search.mapper.CustomObjectMapper;

@Component
@Scope("prototype")
public class UserSearchServiceImpl implements UserSearchService {

	//Remove prototype after migration
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserSearchServiceImpl.class);

	@Autowired
	private UserAboutMeRepository aboutMeRepository;
	@Autowired
	private UserAstrologyRepository userAstrologyRepository;
	@Autowired
	private UserCulturalRepository userCulturalRepository;
	@Autowired
	private UserEducationRepository userEducationRepository;
	@Autowired
	private UserHobbiesRepository userHobbiesRepository;
	@Autowired
	private UserLifestyleRepository userLifestyleRepository;
	@Autowired
	private UserPersonalRepository userPersonalRepository;
	@Autowired
	private UserPhysicalRepository userPhysicalRepository;
	@Autowired
	private UserProfessionalRepository userProfessionalRepository;
	@Autowired
	private PPUserEducationRepository pPUserEducationRepository;
	@Autowired
	private PPUserFamilyRepository pPUserFamilyRepository;
	@Autowired
	private PPUserLifestyleRepository pPUserLifestyleRepository;
	@Autowired
	private PPUserPersonalRepository pPUserPersonalRepository;

	@Autowired
	private UserAboutMeESRepository userAboutMeESRepository;
	@Autowired
	private UserAstrologyESRepository userAstrologyESRepository;
	@Autowired
	private UserCulturalESRepository userCulturalESRepository;
	@Autowired
	private UserEducationESRepository userEducationESRepository;
	@Autowired
	private UserHobbiesESRepository userHobbiesESRepository;
	@Autowired
	private UserLifestyleESRepository userLifestyleESRepository;
	@Autowired
	private UserPersonalESRepository userPersonalESRepository;
	@Autowired
	private UserPhysicalESRepository userPhysicalESRepository;
	@Autowired
	private UserProfessionalESRepository userProfessionalESRepository;
	@Autowired
	private PPUserEducationESRepository pPUserEducationESRepository;
	@Autowired
	private PPUserFamilyESRepository pPUserFamilyESRepository;
	@Autowired
	private PPUserLifestyleESRepository pPUserLifestyleESRepository;
	@Autowired
	private PPUserPersonalESRepository pPUserPersonalESRepository;

	@Autowired
	private CustomObjectMapper mapper;
	
	@Autowired
	private SearchQueryBuilder searchQueryBuilder;

	@Override
	public void saveUserDataFromDB(Long userId, boolean checkIfExists) {

		LOGGER.debug("Processing start for userId:" + userId);

		// Pull personal values
		List<UserAboutMeDAO> userAboutMeDAOList = aboutMeRepository.getUserAboutMeData(userId);
		UserAstrologyDAO userAstrologyDAO = userAstrologyRepository.getUserActrologyData(userId);
		UserCulturalDAO userCulturalDAO = userCulturalRepository.getUserCulturalData(userId);
		UserEducationDAO userEducationDAO = userEducationRepository.getUserEducationData(userId);
		List<UserHobbiesDAO> userHobbiesDAOList = userHobbiesRepository.getUserHobbiesData(userId);
		UserLifestyleDAO userLifestyleDAO = userLifestyleRepository.getUserLifestyleData(userId);
		UserPersonalDAO userPersonalDAO = userPersonalRepository.getUserPersonalData(userId);
		UserPhysicalDAO userPhysicalDAO = userPhysicalRepository.getUserPhysicalData(userId);
		UserProfessionalDAO userProfessionalDAO = userProfessionalRepository.getUserProfessionalData(userId);

		// Pull PP values
		PPUserEducationDAO pPUserEducationDAO = pPUserEducationRepository.getPPUserEducationData(userId);
		PPUserFamilyDAO pPUserFamilyDAO = pPUserFamilyRepository.getPPUserFamilyData(userId);
		PPUserLifestyleDAO pPUserLifestyleDAO = pPUserLifestyleRepository.getPPUserLifestyleData(userId);
		PPUserPersonalDAO pPUserPersonalDAO = pPUserPersonalRepository.getPPUserPersonalData(userId);

		if (checkIfExists) {
			deleteUserDataFromDB(userId);
		}

		for (UserAboutMeDAO userAboutMeDAO : userAboutMeDAOList) {
			com.abp.search.es.model.UserAboutMeDAO esUserAboutMeDAO = mapper.mapUserAboutMeDBToES(userAboutMeDAO);
			if (esUserAboutMeDAO != null) {
				userAboutMeESRepository.save(esUserAboutMeDAO);
			}
		}

		com.abp.search.es.model.UserAstrologyDAO esUserAstrology = mapper.mapUserAstrologyDBToES(userAstrologyDAO);
		if (esUserAstrology != null) {
			userAstrologyESRepository.save(esUserAstrology);
		}

		com.abp.search.es.model.UserCulturalDAO esUserCultural = mapper.mapUserCulturalDBToES(userCulturalDAO);
		if (esUserCultural != null) {
			userCulturalESRepository.save(esUserCultural);
		}

		com.abp.search.es.model.UserEducationDAO esUserEducation = mapper.mapUserEducationDBToES(userEducationDAO);
		if (esUserEducation != null) {
			userEducationESRepository.save(esUserEducation);
		}

		for (UserHobbiesDAO userHobbiesDAO : userHobbiesDAOList) {
			com.abp.search.es.model.UserHobbiesDAO esUserHobbies = mapper.mapUserHobbiesDBToES(userHobbiesDAO);
			if (userHobbiesDAO != null) {
				userHobbiesESRepository.save(esUserHobbies);
			}
		}

		com.abp.search.es.model.UserLifestyleDAO esUserLifestyle = mapper.mapUserLifestyleDBToES(userLifestyleDAO);
		if (esUserLifestyle != null) {
			userLifestyleESRepository.save(esUserLifestyle);
		}

		com.abp.search.es.model.UserPersonalDAO esUserPersonal = mapper.mapUserPersonalDBToES(userPersonalDAO);
		if (esUserPersonal != null) {
			userPersonalESRepository.save(esUserPersonal);
		}

		com.abp.search.es.model.UserPhysicalDAO esUserPhysical = mapper.mapUserPhysicalDBToES(userPhysicalDAO);
		if (esUserPhysical != null) {
			userPhysicalESRepository.save(esUserPhysical);
		}

		com.abp.search.es.model.UserProfessionalDAO esUserProfessional = mapper
				.mapUserProfessionalDBToES(userProfessionalDAO);
		if (esUserProfessional != null) {
			userProfessionalESRepository.save(esUserProfessional);
		}

		com.abp.search.es.model.PPUserEducationDAO pPUserEducation = mapper
				.mapPPUserEducationDBToES(pPUserEducationDAO);
		if (pPUserEducation != null) {
			pPUserEducationESRepository.save(pPUserEducation);
		}

		com.abp.search.es.model.PPUserFamilyDAO pPUserFamily = mapper.mapPPUserFamilyDBToES(pPUserFamilyDAO);
		if (pPUserFamily != null) {
			pPUserFamilyESRepository.save(pPUserFamily);
		}

		com.abp.search.es.model.PPUserLifestyleDAO pPUserLifestyle = mapper
				.mapPPUserLifestyleDBToES(pPUserLifestyleDAO);
		if (pPUserLifestyle != null) {
			pPUserLifestyleESRepository.save(pPUserLifestyle);
		}

		com.abp.search.es.model.PPUserPersonalDAO pPUserPersonal = mapper.mapPPUserPersonalDBToES(pPUserPersonalDAO);
		if (pPUserPersonal != null) {
			pPUserPersonalESRepository.save(pPUserPersonal);
		}

		LOGGER.debug("Processing complete for userId:" + userId);
	}

	public boolean updateUserData(UserInputDTO userData) {
		boolean successFlag = false;
		Long userid = userData.getUserid();

		deleteUserAboutMe(userid);
		insertUserAboutMe(userid, userData.getUserAboutMes());

		com.abp.search.es.model.UserAstrologyDAO tempAstrologyObj = deleteUserAstrology(userid);
		insertUserAstrology(tempAstrologyObj, userid, userData.getNakshatra(), userData.getGothra(),
				userData.getZodiac(), userData.getRashi(), userData.getGon(), userData.getTimeofbirth(),
				userData.getDateofbirth(), userData.getLocationofbirth());

		com.abp.search.es.model.UserCulturalDAO tempCulturalObj = deleteUserCultural(userid);
		insertUserCultural(tempCulturalObj, userid, userData.getHometown(), userData.getFamilytype(),
				userData.getFamilystatus(), userData.getFamilyincome(), userData.getFamilyvalues(),
				userData.getReligion(), userData.getCastename(), userData.getSubcaste(), userData.getFathersstatus(),
				userData.getFathersoccupationstatus(), userData.getFathersindustry(), userData.getMothersstatus(),
				userData.getMothersoccupationstatus(), userData.getMothersindustry());

		com.abp.search.es.model.UserEducationDAO tempEducationObj = deleteUserEducation(userid);
		insertUserEducation(tempEducationObj, userid, userData.getHighestqualification(),
				userData.getHighestspecialization(), userData.getHighestothersspecialization(),
				userData.getHighesteducationinstituteval(), userData.getEducation2(), userData.getSpecialization2(),
				userData.getSpecialization2othersval(), userData.getEducation2instituteval(),
				userData.getEducation3id(), userData.getSpecialization3(), userData.getSpecialization3othersval(),
				userData.getEducation3instituteval(), userData.getSchoolname());

		deleteUserHobbies(userid);
		insertUserHobbies(userid, userData.getHobbies());

		com.abp.search.es.model.UserLifestyleDAO tempLifestyleObj = deleteUserLifestyle(userid);
		insertUserLifestyle(tempLifestyleObj, userid, userData.getSmoking(), userData.getDrinking(),
				userData.getFoodpreferences(), userData.getHouselivingin(), userData.getChildren(),
				userData.getVehicletypeowned(), userData.getVehiclenumber(), userData.getPets());

		com.abp.search.es.model.UserPersonalDAO tempPersonalObj = deleteUserPersonal(userid);
		insertUserPersonal(tempPersonalObj, userid, userData.getDateofbirth(), userData.getLocation(),
				userData.getMaritalstatus(), userData.getNumberofkids(), userData.getMangalik());

		com.abp.search.es.model.UserPhysicalDAO tempPhysicalObj = deleteUserPhysical(userid);
		insertUserPhysical(tempPhysicalObj, userid, userData.getPhysicalappearance(), userData.getHeightft(),
				userData.getHeightin(), userData.getComplexion(), userData.getBloodgroup(), userData.getDisabilities(),
				userData.getKnownailment());

		com.abp.search.es.model.UserProfessionalDAO tempProfessionalObj = deleteUserProfessional(userid);
		insertUserProfessional(tempProfessionalObj, userid, userData.getOccupation(), userData.getDesignation(),
				userData.getCompany(), userData.getIndustry(), userData.getIncome());

		return successFlag;
	}

	public boolean updatePPUserData(PPUserInputDTO ppUserData) {
		boolean successFlag = false;
		Long userid = ppUserData.getUserid();

		com.abp.search.es.model.PPUserEducationDAO tempPPUserEducationObj = deletePPUserEducation(userid);
		insertPPUserEducation(tempPPUserEducationObj, userid, ppUserData.getMinimumeducation(), ppUserData.getIncome(),
				ppUserData.getOccupation(), ppUserData.getIndustry());

		com.abp.search.es.model.PPUserFamilyDAO tempPPUserFamilyObj = deletePPUserFamily(userid);
		insertPPUserFamily(tempPPUserFamilyObj, userid, ppUserData.getFamilytype(), ppUserData.getFamilyorigin(),
				ppUserData.getFamilyincome(), ppUserData.getReligion(), ppUserData.getMothertongue(),
				ppUserData.getCaste(), ppUserData.getSubcaste(), ppUserData.getGothra(), ppUserData.getGaan());

		com.abp.search.es.model.PPUserLifestyleDAO tempPPUserLifestyleObj = deletePPUserLifestyle(userid);
		insertPPUserLifestyle(tempPPUserLifestyleObj, userid, ppUserData.getSmoking(), ppUserData.getDrinking(),
				ppUserData.getFoodhabit(), ppUserData.getBodytype(), ppUserData.getKnownailment(),
				ppUserData.getDisablities());

		com.abp.search.es.model.PPUserPersonalDAO tempPPUserPersonalObj = deletePPUserPersonal(userid);
		insertPPPUserPersonal(tempPPUserPersonalObj, userid, ppUserData.getAgefrom(), ppUserData.getAgeto(),
				ppUserData.getHeight(), ppUserData.getHeightfrom(), ppUserData.getHeightto(),
				ppUserData.getMaritalstatus(), ppUserData.getLocationname(), ppUserData.getManglik(),
				ppUserData.getProfilecreatedby(), ppUserData.getAboutpartner());

		return successFlag;
	}

	private void insertUserAboutMe(Long userid, List<UserAboutMeDTO> abtMeList) {
		if ((abtMeList != null && !abtMeList.isEmpty())) {
			String answer = null;
			String question = null;
			com.abp.search.es.model.UserAboutMeDAO entity = null;
			for (UserAboutMeDTO abtMe : abtMeList) {
				answer = abtMe.getAnswer();
				question = abtMe.getQuestion();
				if (!"".equalsIgnoreCase(answer)) {
					entity = new com.abp.search.es.model.UserAboutMeDAO();
					entity.setUserid(userid);
					entity.setAnswer(answer);
					entity.setQuestion(question);
					userAboutMeESRepository.save(entity);
				}
			}
		}
	}

	private void insertUserHobbies(Long userid, List<UserHobbyDTO> hobbiesList) {
		if ((hobbiesList != null && !hobbiesList.isEmpty())) {
			String favouritehobbie = null;
			String ratings = null;
			com.abp.search.es.model.UserHobbiesDAO entity = null;
			for (UserHobbyDTO hobby : hobbiesList) {
				favouritehobbie = hobby.getFavouritehobbies();
				ratings = hobby.getRatings();
				if (!"".equalsIgnoreCase(favouritehobbie)) {
					entity = new com.abp.search.es.model.UserHobbiesDAO();
					entity.setUserid(userid);
					entity.setFavouritehobbies(favouritehobbie);
					entity.setRatings(ratings);
					userHobbiesESRepository.save(entity);
				}
			}
		}
	}

	private void insertUserAstrology(com.abp.search.es.model.UserAstrologyDAO entity, Long userid, String nakshatra,
			String gothra, String zodiac, String rashi, String gon, String timeofbirth, String dateofbirth,
			String locationofbirth) {
		if (entity == null) {
			entity = new com.abp.search.es.model.UserAstrologyDAO();
		}
		if (nakshatra != null && !"".equalsIgnoreCase(nakshatra)) {
			entity.setNakshatra(nakshatra);
		}
		if (gothra != null && !"".equalsIgnoreCase(gothra)) {
			entity.setGothra(gothra);
		}
		if (zodiac != null && !"".equalsIgnoreCase(zodiac)) {
			entity.setZodiac(zodiac);
		}
		if (rashi != null && !"".equalsIgnoreCase(rashi)) {
			entity.setRashi(rashi);
		}
		if (gon != null && !"".equalsIgnoreCase(gon)) {
			entity.setGon(gon);
		}
		if (timeofbirth != null && !"".equalsIgnoreCase(timeofbirth)) {
			entity.setTimeofbirth(timeofbirth);
		}
		if (dateofbirth != null && !"".equalsIgnoreCase(dateofbirth)) {
			entity.setDateofbirth(dateofbirth);
		}
		if (locationofbirth != null && !"".equalsIgnoreCase(locationofbirth)) {
			entity.setLocationofbirth(locationofbirth);
		}

		if (userid != null && userid != 0 && entity != null) {
			entity.setUserid(userid);
		}

		userAstrologyESRepository.save(entity);
	}

	private void insertUserCultural(com.abp.search.es.model.UserCulturalDAO entity, Long userid, String hometown,
			String familytype, String familystatus, String familyincome, String familyvalues, String religion,
			String castename, String subcaste, String fathersstatus, String fathersoccupationstatus,
			String fathersindustry, String mothersstatus, String mothersoccupationstatus, String mothersindustry) {
		if (entity == null) {
			entity = new com.abp.search.es.model.UserCulturalDAO();
		}
		if (hometown != null && !"".equalsIgnoreCase(hometown)) {
			entity.setHometown(hometown);
		}
		if (familytype != null && !"".equalsIgnoreCase(familytype)) {
			entity.setFamilytype(familytype);
		}
		if (familystatus != null && !"".equalsIgnoreCase(familystatus)) {
			entity.setFamilystatus(familystatus);
		}
		if (familyincome != null && !"".equalsIgnoreCase(familyincome)) {
			entity.setFamilyincome(familyincome);
		}
		if (familyvalues != null && !"".equalsIgnoreCase(familyvalues)) {
			entity.setFamilyvalues(familyvalues);
		}
		if (religion != null && !"".equalsIgnoreCase(religion)) {
			entity.setReligion(religion);
		}
		if (castename != null && !"".equalsIgnoreCase(castename)) {
			entity.setCastename(castename);
		}
		if (subcaste != null && !"".equalsIgnoreCase(subcaste)) {
			entity.setSubcaste(subcaste);
		}
		if (fathersstatus != null && !"".equalsIgnoreCase(fathersstatus)) {
			entity.setFathersstatus(fathersstatus);
		}
		if (fathersoccupationstatus != null && !"".equalsIgnoreCase(fathersoccupationstatus)) {
			entity.setFathersoccupationstatus(fathersoccupationstatus);
		}
		if (fathersindustry != null && !"".equalsIgnoreCase(fathersindustry)) {
			entity.setFathersindustry(fathersindustry);
		}
		if (mothersstatus != null && !"".equalsIgnoreCase(mothersstatus)) {
			entity.setCastename(mothersstatus);
		}
		if (mothersoccupationstatus != null && !"".equalsIgnoreCase(mothersoccupationstatus)) {
			entity.setMothersoccupationstatus(mothersoccupationstatus);
		}
		if (mothersindustry != null && !"".equalsIgnoreCase(mothersindustry)) {
			entity.setMothersindustry(mothersindustry);
		}

		if (userid != null && userid != 0 && entity != null) {
			entity.setUserid(userid);
		}

		userCulturalESRepository.save(entity);
	}

	private void insertUserEducation(com.abp.search.es.model.UserEducationDAO entity, Long userid,
			String highestqualification, String highestspecialization, String highestothersspecialization,
			String highesteducationinstituteval, String education2, String specialization2,
			String specialization2othersval, String education2instituteval, String education3id, String specialization3,
			String specialization3othersval, String education3instituteval, String schoolname) {
		if (entity == null) {
			entity = new com.abp.search.es.model.UserEducationDAO();
		}
		if (highestqualification != null && !"".equalsIgnoreCase(highestqualification)) {

			entity.setHighestqualification(highestqualification);
		}
		if (highestspecialization != null && !"".equalsIgnoreCase(highestspecialization)) {

			entity.setHighestspecialization(highestspecialization);
		}
		if (highestothersspecialization != null && !"".equalsIgnoreCase(highestothersspecialization)) {

			entity.setHighestothersspecialization(highestothersspecialization);
		}
		if (highesteducationinstituteval != null && !"".equalsIgnoreCase(highesteducationinstituteval)) {

			entity.setHighesteducationinstituteval(highesteducationinstituteval);
		}
		if (education2 != null && !"".equalsIgnoreCase(education2)) {

			entity.setEducation2(education2);
		}
		if (specialization2 != null && !"".equalsIgnoreCase(specialization2)) {

			entity.setSpecialization2(specialization2);
		}
		if (specialization2othersval != null && !"".equalsIgnoreCase(specialization2othersval)) {

			entity.setSpecialization2othersval(specialization2othersval);
		}
		if (education2instituteval != null && !"".equalsIgnoreCase(education2instituteval)) {

			entity.setEducation2instituteval(education2instituteval);
		}
		if (education3id != null && !"".equalsIgnoreCase(education3id)) {

			entity.setEducation3id(education3id);
		}
		if (specialization3 != null && !"".equalsIgnoreCase(specialization3)) {

			entity.setSpecialization3(specialization3);
		}
		if (specialization3othersval != null && !"".equalsIgnoreCase(specialization3othersval)) {

			entity.setSpecialization3othersval(specialization3othersval);
		}
		if (education3instituteval != null && !"".equalsIgnoreCase(education3instituteval)) {

			entity.setEducation3instituteval(education3instituteval);
		}
		if (schoolname != null && !"".equalsIgnoreCase(schoolname)) {

			entity.setSchoolname(schoolname);
		}

		if (userid != null && userid != 0 && entity != null) {
			entity.setUserid(userid);
		}

		userEducationESRepository.save(entity);
	}

	private void insertUserLifestyle(com.abp.search.es.model.UserLifestyleDAO entity, Long userid, String smoking,
			String drinking, String foodpreferences, String houselivingin, String children, String vehicletypeowned,
			Long vehiclenumber, String pets) {
		if (entity == null) {
			entity = new com.abp.search.es.model.UserLifestyleDAO();
		}
		if (smoking != null && !"".equalsIgnoreCase(smoking)) {
			entity.setSmoking(smoking);
		}
		if (drinking != null && !"".equalsIgnoreCase(drinking)) {
			entity.setDrinking(drinking);
		}
		if (foodpreferences != null && !"".equalsIgnoreCase(foodpreferences)) {
			entity.setFoodpreferences(foodpreferences);
		}
		if (houselivingin != null && !"".equalsIgnoreCase(houselivingin)) {
			entity.setHouselivingin(houselivingin);
		}
		if (children != null && !"".equalsIgnoreCase(children)) {
			entity.setChildren(children);
		}
		if (vehicletypeowned != null && !"".equalsIgnoreCase(vehicletypeowned)) {
			entity.setVehicletypeowned(vehicletypeowned);
		}
		if (vehiclenumber != null && vehiclenumber != 0) {
			entity.setVehiclenumber(vehiclenumber);
		}
		if (pets != null && !"".equalsIgnoreCase(pets)) {
			entity.setVehicletypeowned(pets);
		}

		if (userid != null && userid != 0 && entity != null) {
			entity.setUserid(userid);
		}

		userLifestyleESRepository.save(entity);
	}

	private void insertUserPersonal(com.abp.search.es.model.UserPersonalDAO entity, Long userid, String dateofbirth,
			String location, String maritalstatus, String numberofkids, String mangalik) {
		if (entity == null) {
			entity = new com.abp.search.es.model.UserPersonalDAO();
		}
		if (dateofbirth != null && !"".equalsIgnoreCase(dateofbirth)) {
			entity.setDateofbirth(dateofbirth);
		}
		if (location != null && !"".equalsIgnoreCase(location)) {
			entity.setLocation(location);
		}
		if (maritalstatus != null && !"".equalsIgnoreCase(maritalstatus)) {
			entity.setMaritalstatus(maritalstatus);
		}
		if (numberofkids != null && !"".equalsIgnoreCase(numberofkids)) {
			entity.setNumberofkids(numberofkids);
		}
		if (mangalik != null && !"".equalsIgnoreCase(mangalik)) {
			entity.setMangalik(mangalik);
		}

		if (userid != null && userid != 0 && entity != null) {
			entity.setUserid(userid);
		}

		userPersonalESRepository.save(entity);
	}

	private void insertUserPhysical(com.abp.search.es.model.UserPhysicalDAO entity, Long userid,
			String physicalappearance, int heightft, int heightin, String complexion, String bloodgroup,
			String disabilities, String knownailment) {
		if (entity == null) {
			entity = new com.abp.search.es.model.UserPhysicalDAO();
		}
		if (physicalappearance != null && !"".equalsIgnoreCase(physicalappearance)) {
			entity.setPhysicalappearance(physicalappearance);
		}
		if (heightft != 0) {
			entity.setHeightft(heightft);
		}
		if (heightin != 0) {
			entity.setHeightin(heightin);
		}
		if (complexion != null && !"".equalsIgnoreCase(complexion)) {
			entity.setComplexion(complexion);
		}
		if (bloodgroup != null && !"".equalsIgnoreCase(bloodgroup)) {
			entity.setBloodgroup(bloodgroup);
		}
		if (disabilities != null && !"".equalsIgnoreCase(disabilities)) {
			entity.setDisabilities(disabilities);
		}
		if (knownailment != null && !"".equalsIgnoreCase(knownailment)) {
			entity.setKnownailment(knownailment);
		}

		if (userid != null && userid != 0 && entity != null) {
			entity.setUserid(userid);
		}

		userPhysicalESRepository.save(entity);
	}

	private void insertUserProfessional(com.abp.search.es.model.UserProfessionalDAO entity, Long userid,
			String occupation, String designation, String company, String industry, String income) {
		if (entity == null) {
			entity = new com.abp.search.es.model.UserProfessionalDAO();
		}
		if (occupation != null && !"".equalsIgnoreCase(occupation)) {
			entity.setOccupation(occupation);
		}
		if (designation != null && !"".equalsIgnoreCase(designation)) {
			entity.setDesignation(designation);
		}
		if (company != null && !"".equalsIgnoreCase(company)) {
			entity.setCompany(company);
		}
		if (industry != null && !"".equalsIgnoreCase(industry)) {
			entity.setIndustry(industry);
		}
		if (income != null && !"".equalsIgnoreCase(income)) {
			entity.setIncome(income);
		}

		if (userid != null && userid != 0 && entity != null) {
			entity.setUserid(userid);
		}

		userProfessionalESRepository.save(entity);
	}

	private void insertPPUserEducation(com.abp.search.es.model.PPUserEducationDAO entity, Long userid,
			String minimumeducation, String income, String occupation, String industry) {
		if (entity == null) {
			entity = new com.abp.search.es.model.PPUserEducationDAO();
		}
		if (minimumeducation != null && !"".equalsIgnoreCase(minimumeducation)) {
			entity.setMinimumeducation(minimumeducation);
		}
		if (income != null && !"".equalsIgnoreCase(income)) {
			entity.setIncome(income);
		}
		if (occupation != null && !"".equalsIgnoreCase(occupation)) {
			entity.setOccupation(occupation);
		}
		if (industry != null && !"".equalsIgnoreCase(industry)) {
			entity.setIndustry(industry);
		}

		if (userid != null && userid != 0 && entity != null) {
			entity.setUserid(userid);
		}

		pPUserEducationESRepository.save(entity);
	}

	private void insertPPUserFamily(com.abp.search.es.model.PPUserFamilyDAO entity, Long userid, String familytype,
			String familyorigin, String familyincome, String religion, String mothertongue, String caste,
			String subcaste, String gothra, String gaan) {
		if (entity == null) {
			entity = new com.abp.search.es.model.PPUserFamilyDAO();
		}
		if (familytype != null && !"".equalsIgnoreCase(familytype)) {
			entity.setFamilytype(familytype);
		}
		if (familyorigin != null && !"".equalsIgnoreCase(familyorigin)) {
			entity.setFamilyorigin(familyorigin);
		}
		if (familyincome != null && !"".equalsIgnoreCase(familyincome)) {
			entity.setFamilyincome(familyincome);
		}
		if (religion != null && !"".equalsIgnoreCase(religion)) {
			entity.setReligion(religion);
		}
		if (mothertongue != null && !"".equalsIgnoreCase(mothertongue)) {
			entity.setMothertongue(mothertongue);
		}
		if (caste != null && !"".equalsIgnoreCase(caste)) {
			entity.setCaste(caste);
		}
		if (subcaste != null && !"".equalsIgnoreCase(subcaste)) {
			entity.setSubcaste(subcaste);
		}
		if (gothra != null && !"".equalsIgnoreCase(gothra)) {
			entity.setGothra(gothra);
		}
		if (gaan != null && !"".equalsIgnoreCase(gaan)) {
			entity.setGaan(gaan);
		}

		if (userid != null && userid != 0 && entity != null) {
			entity.setUserid(userid);
		}

		pPUserFamilyESRepository.save(entity);
	}

	private void insertPPUserLifestyle(com.abp.search.es.model.PPUserLifestyleDAO entity, Long userid, String smoking,
			String drinking, String foodhabit, String bodytype, String knownailment, String disablities) {
		if (entity == null) {
			entity = new com.abp.search.es.model.PPUserLifestyleDAO();
		}
		if (smoking != null && !"".equalsIgnoreCase(smoking)) {
			entity.setSmoking(smoking);
		}
		if (drinking != null && !"".equalsIgnoreCase(drinking)) {
			entity.setDrinking(drinking);
		}
		if (foodhabit != null && !"".equalsIgnoreCase(foodhabit)) {
			entity.setFoodhabit(foodhabit);
		}
		if (bodytype != null && !"".equalsIgnoreCase(bodytype)) {
			entity.setBodytype(bodytype);
		}
		if (knownailment != null && !"".equalsIgnoreCase(knownailment)) {
			entity.setKnownailment(knownailment);
		}
		if (disablities != null && !"".equalsIgnoreCase(disablities)) {
			entity.setDisablities(disablities);
		}

		if (userid != null && userid != 0 && entity != null) {
			entity.setUserid(userid);
		}

		pPUserLifestyleESRepository.save(entity);
	}

	private void insertPPPUserPersonal(com.abp.search.es.model.PPUserPersonalDAO entity, Long userid, String agefrom,
			String ageto, String height, String heightfrom, String heightto, String maritalstatus, String locationname,
			String manglik, String profilecreatedby, String aboutpartner) {
		if (entity == null) {
			entity = new com.abp.search.es.model.PPUserPersonalDAO();
		}
		if (agefrom != null && !"".equalsIgnoreCase(agefrom)) {
			entity.setAgefrom(agefrom);
		}
		if (ageto != null && !"".equalsIgnoreCase(ageto)) {
			entity.setAgeto(ageto);
		}
		if (height != null && !"".equalsIgnoreCase(height)) {
			entity.setHeight(height);
		}
		if (heightfrom != null && !"".equalsIgnoreCase(heightfrom)) {
			entity.setHeightfrom(heightfrom);
		}
		if (heightto != null && !"".equalsIgnoreCase(heightto)) {
			entity.setHeightto(heightto);
		}
		if (maritalstatus != null && !"".equalsIgnoreCase(maritalstatus)) {
			entity.setMaritalstatus(maritalstatus);
		}
		if (locationname != null && !"".equalsIgnoreCase(locationname)) {
			entity.setLocationname(locationname);
		}
		if (manglik != null && !"".equalsIgnoreCase(manglik)) {
			entity.setManglik(manglik);
		}
		if (profilecreatedby != null && !"".equalsIgnoreCase(profilecreatedby)) {
			entity.setProfilecreatedby(profilecreatedby);
		}
		if (aboutpartner != null && !"".equalsIgnoreCase(aboutpartner)) {
			entity.setAboutpartner(aboutpartner);
		}

		if (userid != null && userid != 0 && entity != null) {
			entity.setUserid(userid);
		}

		pPUserPersonalESRepository.save(entity);
	}

	public void deleteUserDataFromDB(Long userId) {

		deleteUserAboutMe(userId);

		deleteUserAstrology(userId);

		deleteUserCultural(userId);

		deleteUserEducation(userId);

		deleteUserHobbies(userId);

		deleteUserLifestyle(userId);

		deleteUserPersonal(userId);

		deleteUserPhysical(userId);

		deleteUserProfessional(userId);

		deletePPUserEducation(userId);

		deletePPUserFamily(userId);

		deletePPUserLifestyle(userId);

		deletePPUserPersonal(userId);
	}

	private com.abp.search.es.model.PPUserPersonalDAO deletePPUserPersonal(Long userId) {
		com.abp.search.es.model.PPUserPersonalDAO tempObj = null;
		List<com.abp.search.es.model.PPUserPersonalDAO> ppUsrPersonalList = pPUserPersonalESRepository
				.findByUserid(String.valueOf(userId));
		for (com.abp.search.es.model.PPUserPersonalDAO ppUsrPersonal : ppUsrPersonalList) {
			pPUserPersonalESRepository.delete(ppUsrPersonal);
			break;
		}
		return tempObj;
	}

	private com.abp.search.es.model.PPUserLifestyleDAO deletePPUserLifestyle(Long userId) {
		com.abp.search.es.model.PPUserLifestyleDAO tempObj = null;
		List<com.abp.search.es.model.PPUserLifestyleDAO> ppUsrLifestyleList = pPUserLifestyleESRepository
				.findByUserid(String.valueOf(userId));
		for (com.abp.search.es.model.PPUserLifestyleDAO ppUsrLifestyle : ppUsrLifestyleList) {
			pPUserLifestyleESRepository.delete(ppUsrLifestyle);
			break;
		}
		return tempObj;
	}

	private com.abp.search.es.model.PPUserFamilyDAO deletePPUserFamily(Long userId) {
		com.abp.search.es.model.PPUserFamilyDAO tempObj = null;
		List<com.abp.search.es.model.PPUserFamilyDAO> ppUsrFamilyList = pPUserFamilyESRepository
				.findByUserid(String.valueOf(userId));
		for (com.abp.search.es.model.PPUserFamilyDAO ppUsrFamily : ppUsrFamilyList) {
			pPUserFamilyESRepository.delete(ppUsrFamily);
			break;
		}
		return tempObj;
	}

	private com.abp.search.es.model.PPUserEducationDAO deletePPUserEducation(Long userId) {
		com.abp.search.es.model.PPUserEducationDAO tempObj = null;
		List<com.abp.search.es.model.PPUserEducationDAO> ppUsrEduList = pPUserEducationESRepository
				.findByUserid(String.valueOf(userId));
		for (com.abp.search.es.model.PPUserEducationDAO ppUsrEdu : ppUsrEduList) {
			pPUserEducationESRepository.delete(ppUsrEdu);
			break;
		}
		return tempObj;
	}

	private com.abp.search.es.model.UserProfessionalDAO deleteUserProfessional(Long userId) {
		com.abp.search.es.model.UserProfessionalDAO tempObj = null;
		List<com.abp.search.es.model.UserProfessionalDAO> usrProfList = userProfessionalESRepository
				.findByUserid(String.valueOf(userId));
		for (com.abp.search.es.model.UserProfessionalDAO usrProf : usrProfList) {
			userProfessionalESRepository.delete(usrProf);
			break;
		}
		return tempObj;
	}

	private com.abp.search.es.model.UserPhysicalDAO deleteUserPhysical(Long userId) {
		com.abp.search.es.model.UserPhysicalDAO tempObj = null;
		List<com.abp.search.es.model.UserPhysicalDAO> usrPhysicalList = userPhysicalESRepository
				.findByUserid(String.valueOf(userId));
		for (com.abp.search.es.model.UserPhysicalDAO usrPhysical : usrPhysicalList) {
			userPhysicalESRepository.delete(usrPhysical);
			break;
		}
		return tempObj;
	}

	private com.abp.search.es.model.UserPersonalDAO deleteUserPersonal(Long userId) {
		com.abp.search.es.model.UserPersonalDAO tempObj = null;
		List<com.abp.search.es.model.UserPersonalDAO> usrPersonalList = userPersonalESRepository
				.findByUserid(String.valueOf(userId));
		for (com.abp.search.es.model.UserPersonalDAO usrPersonal : usrPersonalList) {
			userPersonalESRepository.delete(usrPersonal);
			break;
		}
		return tempObj;
	}

	private com.abp.search.es.model.UserLifestyleDAO deleteUserLifestyle(Long userId) {
		com.abp.search.es.model.UserLifestyleDAO tempObj = null;
		List<com.abp.search.es.model.UserLifestyleDAO> usrLifestyleList = userLifestyleESRepository
				.findByUserid(String.valueOf(userId));
		for (com.abp.search.es.model.UserLifestyleDAO usrLifestyle : usrLifestyleList) {
			userLifestyleESRepository.delete(usrLifestyle);
			break;
		}
		return tempObj;
	}

	private com.abp.search.es.model.UserHobbiesDAO deleteUserHobbies(Long userId) {
		com.abp.search.es.model.UserHobbiesDAO tempObj = null;
		List<com.abp.search.es.model.UserHobbiesDAO> usrHobbyList = userHobbiesESRepository
				.findByUserid(String.valueOf(userId));
		for (com.abp.search.es.model.UserHobbiesDAO usrHobby : usrHobbyList) {
			userHobbiesESRepository.delete(usrHobby);
			break;
		}
		return tempObj;
	}

	private com.abp.search.es.model.UserEducationDAO deleteUserEducation(Long userId) {
		com.abp.search.es.model.UserEducationDAO tempObj = null;
		List<com.abp.search.es.model.UserEducationDAO> usrEduList = userEducationESRepository
				.findByUserid(String.valueOf(userId));
		for (com.abp.search.es.model.UserEducationDAO usrEdu : usrEduList) {
			userEducationESRepository.delete(usrEdu);
			break;
		}
		return tempObj;
	}

	private com.abp.search.es.model.UserCulturalDAO deleteUserCultural(Long userId) {
		com.abp.search.es.model.UserCulturalDAO tempObj = null;
		List<com.abp.search.es.model.UserCulturalDAO> usrCulturalList = userCulturalESRepository
				.findByUserid(String.valueOf(userId));
		for (com.abp.search.es.model.UserCulturalDAO usrCultural : usrCulturalList) {
			userCulturalESRepository.delete(usrCultural);
			break;
		}
		return tempObj;
	}

	private com.abp.search.es.model.UserAstrologyDAO deleteUserAstrology(Long userId) {
		com.abp.search.es.model.UserAstrologyDAO tempObj = null;
		List<com.abp.search.es.model.UserAstrologyDAO> usrAstroList = userAstrologyESRepository
				.findByUserid(String.valueOf(userId));
		for (com.abp.search.es.model.UserAstrologyDAO usrAstro : usrAstroList) {
			tempObj = usrAstro;
			userAstrologyESRepository.delete(usrAstro);
			break;
		}
		return tempObj;
	}

	private void deleteUserAboutMe(Long userId) {
		List<com.abp.search.es.model.UserAboutMeDAO> usrAbtMeList = userAboutMeESRepository
				.findByUserid(String.valueOf(userId));
		for (com.abp.search.es.model.UserAboutMeDAO usrAbtMe : usrAbtMeList) {
			userAboutMeESRepository.delete(usrAbtMe);
		}
	}

	@Override
	public List<AbstractUserDAO> searchUserData(UserInputDTO userData) {
		List<AbstractUserDAO> userIdList = searchQueryBuilder.searchUserData(userData);
		
		return userIdList;
	}

	@Override
	public List<AbstractPPUserDAO> searchPPUserData(PPUserInputDTO ppUserData) {
		List<AbstractPPUserDAO> userIdList = searchQueryBuilder.searchPPUserData(ppUserData);
		
		return userIdList;
	}
}
