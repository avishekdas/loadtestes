package com.abp.search.mapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.abp.search.service.MultiThreadedTrigger;

@Component
public class CustomObjectMapper {

	private static final Logger LOGGER = LoggerFactory.getLogger(MultiThreadedTrigger.class);

	public com.abp.search.es.model.UserAboutMeDAO mapUserAboutMeDBToES(com.abp.search.db.model.UserAboutMeDAO inObj) {
		if (inObj != null) {
			try {
				com.abp.search.es.model.UserAboutMeDAO outObj = new com.abp.search.es.model.UserAboutMeDAO();
				outObj.setAnswer(inObj.getAnswer());
				outObj.setQuestion(inObj.getQuestion());
				outObj.setUserid(inObj.getUserid());
				return outObj;
			} catch (Exception e) {
				LOGGER.debug(e.getMessage());
			}
		}
		return null;
	}

	public com.abp.search.es.model.UserAstrologyDAO mapUserAstrologyDBToES(com.abp.search.db.model.UserAstrologyDAO inObj) {
		if (inObj != null) {
			try {
				com.abp.search.es.model.UserAstrologyDAO outObj = new com.abp.search.es.model.UserAstrologyDAO();
				outObj.setDateofbirth(inObj.getDateofbirth());
				outObj.setGon(inObj.getGon());
				outObj.setGothra(inObj.getGothra());
				outObj.setLocationofbirth(inObj.getLocationofbirth());
				outObj.setNakshatra(inObj.getNakshatra());
				outObj.setRashi(inObj.getRashi());
				outObj.setTimeofbirth(inObj.getTimeofbirth());
				outObj.setUserid(inObj.getUserid());
				outObj.setZodiac(inObj.getZodiac());
				return outObj;
			} catch (Exception e) {
				LOGGER.debug(e.getMessage());
			}
		}
		return null;
	}

	public com.abp.search.es.model.UserCulturalDAO mapUserCulturalDBToES(com.abp.search.db.model.UserCulturalDAO inObj) {
		if (inObj != null) {
			try {
				com.abp.search.es.model.UserCulturalDAO outObj = new com.abp.search.es.model.UserCulturalDAO();
				outObj.setCastename(inObj.getCastename());
				outObj.setFamilyincome(inObj.getFamilyincome());
				outObj.setFamilystatus(inObj.getFamilystatus());
				outObj.setFamilytype(inObj.getFamilytype());
				outObj.setFamilyvalues(inObj.getFamilyvalues());
				outObj.setFathersindustry(inObj.getFathersindustry());
				outObj.setFathersoccupationstatus(inObj.getFathersoccupationstatus());
				outObj.setFathersstatus(inObj.getFathersstatus());
				outObj.setHometown(inObj.getHometown());
				outObj.setMothersindustry(inObj.getMothersindustry());
				outObj.setMothersoccupationstatus(inObj.getMothersoccupationstatus());
				outObj.setMothersstatus(inObj.getMothersstatus());
				outObj.setReligion(inObj.getReligion());
				outObj.setSubcaste(inObj.getSubcaste());
				outObj.setUserid(inObj.getUserid());

				return outObj;
			} catch (Exception e) {
				LOGGER.debug(e.getMessage());
			}
		}
		return null;
	}

	public com.abp.search.es.model.UserEducationDAO mapUserEducationDBToES(com.abp.search.db.model.UserEducationDAO inObj) {
		if (inObj != null) {
			try {
				com.abp.search.es.model.UserEducationDAO outObj = new com.abp.search.es.model.UserEducationDAO();
				outObj.setEducation2(inObj.getEducation2());
				outObj.setEducation2instituteval(inObj.getEducation2instituteval());
				outObj.setEducation3id(inObj.getEducation3id());
				outObj.setEducation3instituteval(inObj.getEducation3instituteval());
				outObj.setHighesteducationinstituteval(inObj.getHighesteducationinstituteval());
				outObj.setHighestothersspecialization(inObj.getHighestothersspecialization());
				outObj.setHighestqualification(inObj.getHighestqualification());
				outObj.setHighestspecialization(inObj.getHighestspecialization());
				outObj.setSchoolname(inObj.getSchoolname());
				outObj.setSpecialization2(inObj.getSpecialization2());
				outObj.setSpecialization2othersval(inObj.getSpecialization2othersval());
				outObj.setSpecialization3(inObj.getSpecialization3());
				outObj.setSpecialization3othersval(inObj.getSpecialization3othersval());
				outObj.setUserid(inObj.getUserid());

				return outObj;
			} catch (Exception e) {
				LOGGER.debug(e.getMessage());
			}
		}
		return null;
	}

	public com.abp.search.es.model.UserHobbiesDAO mapUserHobbiesDBToES(com.abp.search.db.model.UserHobbiesDAO inObj) {
		if (inObj != null) {
			try {
				com.abp.search.es.model.UserHobbiesDAO outObj = new com.abp.search.es.model.UserHobbiesDAO();
				outObj.setFavouritehobbies(inObj.getFavouritehobbies());
				outObj.setRatings(inObj.getRatings());
				outObj.setUserid(inObj.getUserid());

				return outObj;
			} catch (Exception e) {
				LOGGER.debug(e.getMessage());
			}
		}
		return null;
	}

	public com.abp.search.es.model.UserLifestyleDAO mapUserLifestyleDBToES(com.abp.search.db.model.UserLifestyleDAO inObj) {
		if (inObj != null) {
			try {
				com.abp.search.es.model.UserLifestyleDAO outObj = new com.abp.search.es.model.UserLifestyleDAO();
				outObj.setChildren(inObj.getChildren());
				outObj.setDrinking(inObj.getDrinking());
				outObj.setFoodpreferences(inObj.getFoodpreferences());
				outObj.setHouselivingin(inObj.getHouselivingin());
				outObj.setPets(inObj.getPets());
				outObj.setSmoking(inObj.getSmoking());
				outObj.setUserid(inObj.getUserid());
				outObj.setVehiclenumber(inObj.getVehiclenumber());
				outObj.setVehicletypeowned(inObj.getVehicletypeowned());

				return outObj;
			} catch (Exception e) {
				LOGGER.debug(e.getMessage());
			}
		}
		return null;
	}

	public com.abp.search.es.model.UserPersonalDAO mapUserPersonalDBToES(com.abp.search.db.model.UserPersonalDAO inObj) {
		if (inObj != null) {
			try {
				com.abp.search.es.model.UserPersonalDAO outObj = new com.abp.search.es.model.UserPersonalDAO();
				outObj.setDateofbirth(inObj.getDateofbirth());
				outObj.setLocation(inObj.getLocation());
				outObj.setMangalik(inObj.getMangalik());
				outObj.setMaritalstatus(inObj.getMaritalstatus());
				outObj.setNumberofkids(inObj.getNumberofkids());
				outObj.setUserid(inObj.getUserid());

				return outObj;
			} catch (Exception e) {
				LOGGER.debug(e.getMessage());
			}
		}
		return null;
	}

	public com.abp.search.es.model.UserPhysicalDAO mapUserPhysicalDBToES(com.abp.search.db.model.UserPhysicalDAO inObj) {
		if (inObj != null) {
			try {
				com.abp.search.es.model.UserPhysicalDAO outObj = new com.abp.search.es.model.UserPhysicalDAO();
				outObj.setBloodgroup(inObj.getBloodgroup());
				outObj.setComplexion(inObj.getComplexion());
				outObj.setDisabilities(inObj.getDisabilities());
				outObj.setHeightft(inObj.getHeightft());
				outObj.setHeightin(inObj.getHeightin());
				outObj.setKnownailment(inObj.getKnownailment());
				outObj.setPhysicalappearance(inObj.getPhysicalappearance());
				outObj.setUserid(inObj.getUserid());

				return outObj;
			} catch (Exception e) {
				LOGGER.debug(e.getMessage());
			}
		}
		return null;
	}

	public com.abp.search.es.model.UserProfessionalDAO mapUserProfessionalDBToES(
			com.abp.search.db.model.UserProfessionalDAO inObj) {
		if (inObj != null) {
			try {
				com.abp.search.es.model.UserProfessionalDAO outObj = new com.abp.search.es.model.UserProfessionalDAO();
				outObj.setCompany(inObj.getCompany());
				outObj.setDesignation(inObj.getDesignation());
				outObj.setIncome(inObj.getIncome());
				outObj.setIndustry(inObj.getIndustry());
				outObj.setOccupation(inObj.getOccupation());
				outObj.setUserid(inObj.getUserid());

				return outObj;
			} catch (Exception e) {
				LOGGER.debug(e.getMessage());
			}
		}
		return null;
	}

	public com.abp.search.es.model.PPUserEducationDAO mapPPUserEducationDBToES(
			com.abp.search.db.model.PPUserEducationDAO inObj) {
		if (inObj != null) {
			try {
				com.abp.search.es.model.PPUserEducationDAO outObj = new com.abp.search.es.model.PPUserEducationDAO();
				outObj.setIncome(inObj.getIncome());
				outObj.setIndustry(inObj.getIndustry());
				outObj.setMinimumeducation(inObj.getMinimumeducation());
				outObj.setOccupation(inObj.getOccupation());
				outObj.setUserid(inObj.getUserid());

				return outObj;
			} catch (Exception e) {
				LOGGER.debug(e.getMessage());
			}
		}
		return null;
	}

	public com.abp.search.es.model.PPUserFamilyDAO mapPPUserFamilyDBToES(com.abp.search.db.model.PPUserFamilyDAO inObj) {
		if (inObj != null) {
			try {
				com.abp.search.es.model.PPUserFamilyDAO outObj = new com.abp.search.es.model.PPUserFamilyDAO();
				outObj.setCaste(inObj.getCaste());
				outObj.setFamilyincome(inObj.getFamilyincome());
				outObj.setFamilyorigin(inObj.getFamilyorigin());
				outObj.setFamilytype(inObj.getFamilytype());
				outObj.setGaan(inObj.getGaan());
				outObj.setGothra(inObj.getGothra());
				outObj.setMothertongue(inObj.getMothertongue());
				outObj.setReligion(inObj.getReligion());
				outObj.setSubcaste(inObj.getSubcaste());
				outObj.setUserid(inObj.getUserid());

				return outObj;
			} catch (Exception e) {
				LOGGER.debug(e.getMessage());
			}
		}
		return null;
	}

	public com.abp.search.es.model.PPUserLifestyleDAO mapPPUserLifestyleDBToES(
			com.abp.search.db.model.PPUserLifestyleDAO inObj) {
		if (inObj != null) {
			try {
				com.abp.search.es.model.PPUserLifestyleDAO outObj = new com.abp.search.es.model.PPUserLifestyleDAO();
				outObj.setBodytype(inObj.getBodytype());
				outObj.setDisablities(inObj.getDisablities());
				outObj.setDrinking(inObj.getDrinking());
				outObj.setFoodhabit(inObj.getFoodhabit());
				outObj.setKnownailment(inObj.getKnownailment());
				outObj.setSmoking(inObj.getSmoking());
				outObj.setUserid(inObj.getUserid());

				return outObj;
			} catch (Exception e) {
				LOGGER.debug(e.getMessage());
			}
		}
		return null;
	}

	public com.abp.search.es.model.PPUserPersonalDAO mapPPUserPersonalDBToES(
			com.abp.search.db.model.PPUserPersonalDAO inObj) {
		if (inObj != null) {
			try {
				com.abp.search.es.model.PPUserPersonalDAO outObj = new com.abp.search.es.model.PPUserPersonalDAO();
				outObj.setAboutpartner(inObj.getAboutpartner());
				outObj.setAgefrom(inObj.getAgefrom());
				outObj.setAgeto(inObj.getAgeto());
				outObj.setHeight(inObj.getHeight());
				outObj.setHeightfrom(inObj.getHeightfrom());
				outObj.setHeightto(inObj.getHeightto());
				outObj.setLocationname(inObj.getLocationname());
				outObj.setManglik(inObj.getManglik());
				outObj.setMaritalstatus(inObj.getMaritalstatus());
				outObj.setProfilecreatedby(inObj.getProfilecreatedby());
				outObj.setUserid(inObj.getUserid());

				return outObj;
			} catch (Exception e) {
				LOGGER.debug(e.getMessage());
			}
		}
		return null;
	}
}
