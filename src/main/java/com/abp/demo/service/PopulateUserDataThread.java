package com.abp.demo.service;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.Callable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.abp.demo.db.model.PPUserEducationDAO;
import com.abp.demo.db.model.PPUserFamilyDAO;
import com.abp.demo.db.model.PPUserLifestyleDAO;
import com.abp.demo.db.model.PPUserPersonalDAO;
import com.abp.demo.db.model.UserAboutMeDAO;
import com.abp.demo.db.model.UserAstrologyDAO;
import com.abp.demo.db.model.UserCulturalDAO;
import com.abp.demo.db.model.UserEducationDAO;
import com.abp.demo.db.model.UserHobbiesDAO;
import com.abp.demo.db.model.UserLifestyleDAO;
import com.abp.demo.db.model.UserPersonalDAO;
import com.abp.demo.db.model.UserPhysicalDAO;
import com.abp.demo.db.model.UserProfessionalDAO;
import com.abp.demo.db.repository.PPUserEducationRepository;
import com.abp.demo.db.repository.PPUserFamilyRepository;
import com.abp.demo.db.repository.PPUserLifestyleRepository;
import com.abp.demo.db.repository.PPUserPersonalRepository;
import com.abp.demo.db.repository.UserAboutMeRepository;
import com.abp.demo.db.repository.UserAstrologyRepository;
import com.abp.demo.db.repository.UserCulturalRepository;
import com.abp.demo.db.repository.UserEducationRepository;
import com.abp.demo.db.repository.UserHobbiesRepository;
import com.abp.demo.db.repository.UserLifestyleRepository;
import com.abp.demo.db.repository.UserPersonalRepository;
import com.abp.demo.db.repository.UserPhysicalRepository;
import com.abp.demo.db.repository.UserProfessionalRepository;
import com.abp.demo.es.repository.PPUserEducationESRepository;
import com.abp.demo.es.repository.PPUserFamilyESRepository;
import com.abp.demo.es.repository.PPUserLifestyleESRepository;
import com.abp.demo.es.repository.PPUserPersonalESRepository;
import com.abp.demo.es.repository.UserAboutMeESRepository;
import com.abp.demo.es.repository.UserAstrologyESRepository;
import com.abp.demo.es.repository.UserCulturalESRepository;
import com.abp.demo.es.repository.UserEducationESRepository;
import com.abp.demo.es.repository.UserHobbiesESRepository;
import com.abp.demo.es.repository.UserLifestyleESRepository;
import com.abp.demo.es.repository.UserPersonalESRepository;
import com.abp.demo.es.repository.UserPhysicalESRepository;
import com.abp.demo.es.repository.UserProfessionalESRepository;
import com.abp.demo.mapper.CustomObjectMapper;

@Component
@Scope("prototype")
public class PopulateUserDataThread implements Callable<String> {

	private static final Logger LOGGER = LoggerFactory.getLogger(PopulateUserDataThread.class);

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

	private String request;

	public PopulateUserDataThread(String request) {
		this.request = request;
	}

	@Override
	public String call() throws Exception {
		LOGGER.debug("Thread started [" + request + "]");
		return doWork();
	}

	public String doWork() {

//		saveUserDataFromDB(51343L);
		saveUserDataFromDB(Long.parseLong(request));
		return "Request [" + request + "] " + createUUID();
	}

	public void saveUserDataFromDB(Long userId) {

		// Pull personal values
		List<UserAboutMeDAO> userAboutMeDAOList = aboutMeRepository.getUserAboutMeData(userId);
		UserAstrologyDAO userAstrologyDAO = userAstrologyRepository.getUserActrologyData(userId);
		UserCulturalDAO userCulturalDAO = userCulturalRepository.getUserCulturalData(userId);
		UserEducationDAO userEducationDAO = userEducationRepository.getUserEducationData(userId);
		UserHobbiesDAO userHobbiesDAO = userHobbiesRepository.getUserHobbiesData(userId);
		UserLifestyleDAO userLifestyleDAO = userLifestyleRepository.getUserLifestyleData(userId);
		UserPersonalDAO userPersonalDAO = userPersonalRepository.getUserPersonalData(userId);
		UserPhysicalDAO userPhysicalDAO = userPhysicalRepository.getUserPhysicalData(userId);
		UserProfessionalDAO userProfessionalDAO = userProfessionalRepository.getUserProfessionalData(userId);

		// Pull PP values
		PPUserEducationDAO pPUserEducationDAO = pPUserEducationRepository.getPPUserEducationData(userId);
		PPUserFamilyDAO pPUserFamilyDAO = pPUserFamilyRepository.getPPUserFamilyData(userId);
		PPUserLifestyleDAO pPUserLifestyleDAO = pPUserLifestyleRepository.getPPUserLifestyleData(userId);
		PPUserPersonalDAO pPUserPersonalDAO = pPUserPersonalRepository.getPPUserPersonalData(userId);

		for (UserAboutMeDAO userAboutMeDAO : userAboutMeDAOList) {
			com.abp.demo.es.model.UserAboutMeDAO esUserAboutMeDAO = mapper.mapUserAboutMeDBToES(userAboutMeDAO);
			if (esUserAboutMeDAO != null) {
				userAboutMeESRepository.save(esUserAboutMeDAO);
			}
		}

		com.abp.demo.es.model.UserAstrologyDAO esUserAstrology = mapper.mapUserAstrologyDBToES(userAstrologyDAO);
		if (esUserAstrology != null) {
			userAstrologyESRepository.save(esUserAstrology);
		}

		com.abp.demo.es.model.UserCulturalDAO esUserCultural = mapper.mapUserCulturalDBToES(userCulturalDAO);
		if (esUserCultural != null) {
			userCulturalESRepository.save(esUserCultural);
		}

		com.abp.demo.es.model.UserEducationDAO esUserEducation = mapper.mapUserEducationDBToES(userEducationDAO);
		if (esUserEducation != null) {
			userEducationESRepository.save(esUserEducation);
		}

		com.abp.demo.es.model.UserHobbiesDAO esUserHobbies = mapper.mapUserHobbiesDBToES(userHobbiesDAO);
		if (esUserHobbies != null) {
			userHobbiesESRepository.save(esUserHobbies);
		}

		com.abp.demo.es.model.UserLifestyleDAO esUserLifestyle = mapper.mapUserLifestyleDBToES(userLifestyleDAO);
		if (esUserLifestyle != null) {
			userLifestyleESRepository.save(esUserLifestyle);
		}

		com.abp.demo.es.model.UserPersonalDAO esUserPersonal = mapper.mapUserPersonalDBToES(userPersonalDAO);
		if (esUserPersonal != null) {
			userPersonalESRepository.save(esUserPersonal);
		}

		com.abp.demo.es.model.UserPhysicalDAO esUserPhysical = mapper.mapUserPhysicalDBToES(userPhysicalDAO);
		if (esUserPhysical != null) {
			userPhysicalESRepository.save(esUserPhysical);
		}

		com.abp.demo.es.model.UserProfessionalDAO esUserProfessional = mapper
				.mapUserProfessionalDBToES(userProfessionalDAO);
		if (esUserProfessional != null) {
			userProfessionalESRepository.save(esUserProfessional);
		}

		com.abp.demo.es.model.PPUserEducationDAO pPUserEducation = mapper.mapPPUserEducationDBToES(pPUserEducationDAO);
		if (pPUserEducation != null) {
			pPUserEducationESRepository.save(pPUserEducation);
		}

		com.abp.demo.es.model.PPUserFamilyDAO pPUserFamily = mapper.mapPPUserFamilyDBToES(pPUserFamilyDAO);
		if (pPUserFamily != null) {
			pPUserFamilyESRepository.save(pPUserFamily);
		}

		com.abp.demo.es.model.PPUserLifestyleDAO pPUserLifestyle = mapper.mapPPUserLifestyleDBToES(pPUserLifestyleDAO);
		if (pPUserLifestyle != null) {
			pPUserLifestyleESRepository.save(pPUserLifestyle);
		}

		com.abp.demo.es.model.PPUserPersonalDAO pPUserPersonal = mapper.mapPPUserPersonalDBToES(pPUserPersonalDAO);
		if (pPUserPersonal != null) {
			pPUserPersonalESRepository.save(pPUserPersonal);
		}

	}

	private String createUUID() {
		UUID id = UUID.randomUUID();
		return id.toString();
	}
}
