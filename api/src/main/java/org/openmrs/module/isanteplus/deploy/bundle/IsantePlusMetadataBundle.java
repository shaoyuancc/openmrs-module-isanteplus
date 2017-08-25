/**
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */

package org.openmrs.module.isanteplus.deploy.bundle;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.GlobalProperty;
import org.openmrs.PatientIdentifierType;
import org.openmrs.api.context.Context;
import org.openmrs.module.coreapps.CoreAppsConstants;
import org.openmrs.module.emrapi.EmrApiConstants;
import org.openmrs.module.haiticore.metadata.HaitiAddressBundle;
import org.openmrs.module.haiticore.metadata.HaitiEncounterTypeBundle;
import org.openmrs.module.haiticore.metadata.HaitiPersonAttributeTypeBundle;
import org.openmrs.module.haiticore.metadata.patientidentifiertypebundles.HaitiBiometricPatientIdentifierTypeBundle;
import org.openmrs.module.haiticore.metadata.patientidentifiertypebundles.HaitiSedishMpiPatientIdentifierTypeBundle;
import org.openmrs.module.metadatadeploy.bundle.AbstractMetadataBundle;
import org.openmrs.module.metadatadeploy.bundle.Requires;
import org.openmrs.module.isanteplus.IsantePlusConstants;
import org.openmrs.util.OpenmrsConstants;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.Map;

;

/**
 * Core iSantPlus metadata bundle
 */
@Component
@Requires( {
		HaitiEncounterTypeBundle.class,
		HaitiPersonAttributeTypeBundle.class,
	    HaitiBiometricPatientIdentifierTypeBundle.class,
	    HaitiSedishMpiPatientIdentifierTypeBundle.class,
		HaitiAddressBundle.class
} )
public class IsantePlusMetadataBundle extends AbstractMetadataBundle {

	protected Log log = LogFactory.getLog(getClass());

	/**
	 * @see AbstractMetadataBundle#install()
	 */
	@Override
	public void install() {

		log.info("Setting Global Properties");

		Map<String, String> properties = new LinkedHashMap<String, String>();
		
		// Set Global properties
		// Set the locales that are allowed
		properties.put(OpenmrsConstants.GLOBAL_PROPERTY_LOCALE_ALLOWED_LIST, "fr, ht, en, en_us, en_gb");
		// Set the default locale
		properties.put(OpenmrsConstants.GLOBAL_PROPERTY_DEFAULT_LOCALE, IsantePlusConstants.DEFAULT_LOCALE);
		// Set the name layout from "short" to "givenfamily" to only ask for two names
		properties.put(OpenmrsConstants.GLOBAL_PROPERTY_LAYOUT_NAME_FORMAT, "givenfamily");
		
		// Set Registration Core global properties for integration with SEDISH MPI demo
		PatientIdentifierType ECID = Context.getPatientService().getPatientIdentifierTypeByUuid(IsantePlusConstants.HaitiCore_ECID_UUID);
		
		if (ECID != null) {
			properties.put(IsantePlusConstants.GP_REGISTRATIONCORE_MPI_PERSONIDENTIFIERID, ECID.getId().toString());
        }
		
		properties.put(IsantePlusConstants.GP_REGISTRATIONCORE_MPI_USERNAME, IsantePlusConstants.GP_REGISTRATIONCORE_MPI_USERNAME_VALUE);
		properties.put(IsantePlusConstants.GP_REGISTRATIONCORE_MPI_PASSWORD, IsantePlusConstants.GP_REGISTRATIONCORE_MPI_PASSWORD_VALUE);
		properties.put(IsantePlusConstants.GP_REGISTRATIONCORE_MPI_PDQ_ENDPOINT, IsantePlusConstants.GP_REGISTRATIONCORE_MPI_PDQ_ENDPOINT_VALUE);
		properties.put(IsantePlusConstants.GP_REGISTRATIONCORE_MPI_PIX_ENDPOINT, IsantePlusConstants.GP_REGISTRATIONCORE_MPI_PIX_ENDPOINT_VALUE);
		properties.put(IsantePlusConstants.GP_REGISTRATIONCORE_MPI_SENDINGAPPLICATION, IsantePlusConstants.GP_REGISTRATIONCORE_MPI_SENDINGAPPLICATION_VALUE);
		properties.put(IsantePlusConstants.GP_REGISTRATIONCORE_MPI_SENDINGFACILITY, IsantePlusConstants.GP_REGISTRATIONCORE_MPI_SENDINGFACILITY_VALUE);
		properties.put(IsantePlusConstants.GP_REGISTRATIONCORE_MPI_RECEIVINGAPPLICATION, IsantePlusConstants.GP_REGISTRATIONCORE_MPI_RECEIVINGAPPLICATION_VALUE);
		properties.put(IsantePlusConstants.GP_REGISTRATIONCORE_MPI_RECEIVINGFACILITY, IsantePlusConstants.GP_REGISTRATIONCORE_MPI_RECEIVINGFACILITY_VALUE);
		

		// EMR API
		// extra patient identifiers
		// properties.put(EmrApiConstants.GP_EXTRA_PATIENT_IDENTIFIER_TYPES, HaitiPatientIdentifierTypes.DOSSIER_NUMBER.uuid() + "," + HaitiPatientIdentifierTypes.HIVEMR_V1.uuid());
		// primary identifier type now installed via metadata mappings
		// properties.put(EmrApiConstants.PRIMARY_IDENTIFIER_TYPE, HaitiPatientIdentifierTypes.ZL_EMR_ID.name());

        // Core Apps
		// Adding a default location
        //properties.put(CoreAppsConstants.GP_DEFAULT_PATIENT_IDENTIFIER_LOCATION, MirebalaisLocations.MIREBALAIS_CDI_PARENT.uuid());

        setGlobalProperties(properties);


	}
}
