package org.openmrs.module.isanteplus;

/**
 * This file must always be updated every time apps or/and extensions are added
 * or edited to /src/main/webapp/isantepluspatientdashboard_app.json and
 * /src/main/webapp/isantepluspatientdashboard_extension.json
 * 
 * @author k-joseph
 * 
 */
public class IsantePlusConstants {

	public static String VISITFORMHISTORY_EXTENSIONPOINT_ID = "isanteplus.formHistory";

	public static String LABHISTORY_EXTENSIONPOINT_ID = "isanteplus.labHistory";

	public static String FORMHISTORY_EXTENSIONPOINT_ID = "isanteplus.formsHistory";

	public static String GROWTHCHARTS_EXTENSIONPOINT_ID = "isanteplus.growthCharts";

	public static String WEIGHTSGRAPH_EXTENSIONPOINT_ID = "isanteplus.patientDashboard.secondColumnFragments.weightGraph";

	public static String LASTVIRALLOADTEST_EXTENSIONPOINT_ID = "isanteplus.patientDashboard.secondColumnFragments.lastViralLoadTest";

	public static String ISANTEFORMS_EXTENSIONPOINT_ID = "isanteplus.patientDashboard.firstColumnFragments.isantePlusForms";

	public static String DEFAULT_MOSTRECENTVITALS_APP_EXTENSIONPOINT_ID = "coreapps.mostRecentVitals";

	public static String MOSTRECENTVITALS_EXTENSIONPOINT_ID = "isanteplus.patientDashboard.firstColumnFragments.mostRecentVitals";

	/**
	 * Add a name whenever a new iSante form file is added or one existing is
	 * renamed
	 */
	private static String ISANTEPLUS_FORMFILE_NAMES_SEPARATEDBYCOMMAS = "Adh.xml,Lab.xml,OBGYN.xml,FOBGYN.xml,Tacc.xml,PsyA.xml,PsyP.xml,OrdM.xml,Ordpd.xml,ArretVIH.xml,PVisitAdult.xml,PVisitPed.xml,ConsPed.xml,PCons.xml,PConsPed.xml,Cons.xml,Vacc.xml,VisitSuivi.xml,VisitSuiviPed.xml,Imagerie.xml,RegistrationSocial.xml,RegistrationPoa.xml,RegistrationEmerContact.xml,RegistrationDiscContact.xml";

	public static String[] ISANTEPLUS_FORMFILE_NAMES = ISANTEPLUS_FORMFILE_NAMES_SEPARATEDBYCOMMAS.split(",");

	public static final String DRUGSHISTORY_EXTENSIONPOINT_ID = "isanteplus.drugsHistory";

	public static String BMIGRAPH_EXTENSIONPOINT_ID = "isanteplus.patientDashboard.secondColumnFragments.bmiGraph";

	public static final String DEFAULT_LOCALE = "fr";
	
	public static final String SCHEDULER_USER_UUID = "0a3493e8-21f8-11e3-8ad1-1b02b898d14d";
	
	public static final String SCHEDULER_USERNAME = "scheduler";
	
	public static final String VITALS_FORM_UUID = "a000cb34-9ec1-4344-a1c8-f692232f6edd";
	
	public static final String VITALS_FORM_ENCOUNTERTYPE_UUID = "67a71486-1a54-468f-ac3e-7091a9a79584";
	
	public static final String VITALS_FORM_NAME = "Vitals";

}
