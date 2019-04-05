package randomBS;

public enum FieldOfStudy {
	TotalFieldOfStudy,
	Education,
	VisualAndPerformingArtsAndCommunicationsTechnologies,
	CommunicationsTechnologiesAndTechniciansAndSupportServices,
	VisualAndPerformingArts,
	Humanities,
	AboriginalAndForeignLanguagesLiteraturesAndLinguistics,
	EnglishLanguageAndLiteratureLetters,
	LiberalArtsAndSciencesGeneralStudiesAndHumanities,
	InterdisciplinaryHumanities,
	PhilosophyAndReligiousStudies,
	TheologyAndReligiousVocations,
	History,
	FrenchLanguageAndLiteratureLetters,
	SocialAndBehavioralSciencesAndLaw,
	AreaEthnicCulturalGenderAndGroupStudies,
	CommunicationJournalismAndRelatedPrograms,
	FamilyAndConsumerSciencesHumanSciences,
	LegalProfessionsAndStudies,
	InterdisciplinarySocialAndBehaviouralSciences,
	Psychology,
	SocialSciences,
	BusinessManagementAndPublicAdministration,
	PublicAdministrationAndSocialServiceProfessions,
	BusinessManagementMarketingAndRelatedSupportServices,
	PhysicalAndLifeSciencesAndTechnologies,
	BiologicalAndBiomedicalSciences,
	BiologicalAndPhysicalSciences,
	OtherInterdisciplinaryPhysicalAndLifeSciences,
	PhysicalSciences,
	ScienceTechnologiesTechnicians,
	MathematicsComputerAndInformationSciences,
	ComputerAndInformationSciencesAndSupportServices,
	LibraryScience,
	MathematicsAndStatistics,
	InterdisciplinaryMathematicsComputerAndInformationSciences,
	ArchitectureEngineeringAndRelatedTechnologies,
	ArchitectureAndRelatedServices,
	Engineering,
	EngineeringTechnologiesAndEngineeringRelatedFields,
	HistoricPreservationAndConservation,
	ConstructionTrades,
	MechanicAndRepairTechnologiesTechnicians,
	PrecisionProduction,
	AgricultureNaturalResourcesAndConservation,
	AgricultureAgriculturePperationsAndRelatedSciences,
	NaturalResourcesAndConservation,
	HealthAndRelatedFields,
	ParksRecreationLeisureAndFitnessStudies,
	HealthProfessionsAndRelatedPrograms,
	DentalMedicalAndVeterinaryResidencyPrograms,
	PersonalProtectiveAndTransportationServices,
	PersonalAndCulinaryServices,
	MilitaryScienceLeadershipAndOperationalArt,
	SecurityAndProtectiveServices,
	TransportationAndMaterialsMoving,
	OtherInstructionalPrograms,
	MultidisciplinaryInterdisciplinaryStudiesOther;
	
	public int toval() {
		switch(this.name()) {
			case "TotalFieldOfStudy":
				return 1;
			case "Education":
				return 2;
			case "VisualAndPerformingArtsAndCommunicationsTechnologies":
				return 4;
			case "CommunicationsTechnologiesAndTechniciansAndSupportServices":
				return 5;
			case "VisualAndPerformingArts":
				return 6;
			case "Humanities":
				return 7;
			case "AboriginalAndForeignLanguagesLiteraturesAndLinguistics":
				return 8;
			case "EnglishLanguageAndLiteratureLetters":
				return 9;
			case "LiberalArtsAndSciencesGeneralStudiesAndHumanities":
				return 10;
			case "InterdisciplinaryHumanities":
				return 11;
			case "PhilosophyAndReligiousStudies":
				return 12;
			case "TheologyAndReligiousVocations":
				return 13;
			case "History":
				return 14;
			case "FrenchLanguageAndLiteratureLetters":
				return 15;
			case "SocialAndBehavioralSciencesAndLaw":
				return 16;
			case "AreaEthnicCulturalGenderAndGroupStudies":
				return 17;
			case "CommunicationJournalismAndRelatedPrograms":
				return 18;
			case "FamilyAndConsumerSciencesHumanSciences":
				return 19;
			case "LegalProfessionsAndStudies":
				return 20;
			case "InterdisciplinarySocialAndBehaviouralSciences":
				return 21;
			case "Psychology":
				return 22;
			case "SocialSciences":
				return 23;
			case "BusinessManagementAndPublicAdministration":
				return 24;
			case "PublicAdministrationAndSocialServiceProfessions":
				return 25;
			case "BusinessManagementMarketingAndRelatedSupportServices":
				return 26;
			case "PhysicalAndLifeSciencesAndTechnologies":
				return 27;
			case "BiologicalAndBiomedicalSciences":
				return 28;
			case "BiologicalAndPhysicalSciences":
				return 29;
			case "OtherInterdisciplinaryPhysicalAndLifeSciences":
				return 30;
			case "PhysicalSciences":
				return 31;
			case "ScienceTechnologiesTechnicians":
				return 32;
			case "MathematicsComputerAndInformationSciences":
				return 33;
			case "ComputerAndInformationSciencesAndSupportServices":
				return 34;
			case "LibraryScience":
				return 35;
			case "MathematicsAndStatistics":
				return 36;
			case "InterdisciplinaryMathematicsComputerAndInformationSciences":
				return 37;
			case "ArchitectureEngineeringAndRelatedTechnologies":
				return 38;
			case "ArchitectureAndRelatedServices":
				return 39;
			case "Engineering":
				return 40;
			case "EngineeringTechnologiesAndEngineeringRelatedFields":
				return 41;
			case "HistoricPreservationAndConservation":
				return 42;
			case "ConstructionTrades":
				return 43;
			case "MechanicAndRepairTechnologiesTechnicians":
				return 44;
			case "PrecisionProduction":
				return 45;
			case "AgricultureNaturalResourcesAndConservation":
				return 46;
			case "AgricultureAgriculturePperationsAndRelatedSciences":
				return 47;
			case "NaturalResourcesAndConservation":
				return 48;
			case "HealthAndRelatedFields":
				return 49;
			case "ParksRecreationLeisureAndFitnessStudies":
				return 50;
			case "HealthProfessionsAndRelatedPrograms":
				return 51;
			case "DentalMedicalAndVeterinaryResidencyPrograms":
				return 52;
			case "PersonalProtectiveAndTransportationServices":
				return 53;
			case "PersonalAndCulinaryServices":
				return 54;
			case "MilitaryScienceLeadershipAndOperationalArt":
				return 55;
			case "SecurityAndProtectiveServices":
				return 56;
			case "TransportationAndMaterialsMoving":
				return 57;
			case "OtherInstructionalPrograms":
				return 58;
			case "MultidisciplinaryInterdisciplinaryStudiesOther":
				return 59;
			default:
				return 0;
		}
	}
}