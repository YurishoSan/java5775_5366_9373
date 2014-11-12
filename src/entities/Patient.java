/**
 * 
 */
package entities;

import java.util.Date;

import enums.ServiceClass;

/**
 * Class representing a patient of the medical company
 * 
 * @author Yitzhak Goldstein
 * @author Shalom Tzichtig 
 */
public class Patient extends Human
{
	//region attributes
	private ServiceClass PatientServiceClass;
	private String PatientPhoneNumber;	
	//endregion

	//region contors
	/**
	 * 
	 */
	public Patient()
	{
		super();
	}

	/**
	 * @param humanID
	 * @param humanFirstName
	 * @param humanLastName
	 * @param humanDoB
	 * @param patientServiceClass
	 * @param patientPhoneNumber
	 */
	public Patient(long humanID, String humanFirstName, String humanLastName,
			Date humanDoB, ServiceClass patientServiceClass,
			String patientPhoneNumber)
	{
		super(humanID, humanFirstName, humanLastName, humanDoB);
		PatientServiceClass = patientServiceClass;
		PatientPhoneNumber = patientPhoneNumber;
	}
	//endregion

	//region getters/setters
	/**
	 * @return the patientServiceClass
	 */
	public ServiceClass getPatientServiceClass()
	{
		return PatientServiceClass;
	}

	/**
	 * @param patientServiceClass the patientServiceClass to set
	 */
	public void setPatientServiceClass(ServiceClass patientServiceClass)
	{
		PatientServiceClass = patientServiceClass;
	}

	/**
	 * @return the patientPhoneNumber
	 */
	public String getPatientPhoneNumber()
	{
		return PatientPhoneNumber;
	}

	/**
	 * @param patientPhoneNumber the patientPhoneNumber to set
	 */
	public void setPatientPhoneNumber(String patientPhoneNumber)
	{
		PatientPhoneNumber = patientPhoneNumber;
	}
	//endregion

	//region overrideMethods
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("Patient [PatientServiceClass=");
		builder.append(PatientServiceClass);
		builder.append(", PatientPhoneNumber=");
		builder.append(PatientPhoneNumber);
		builder.append(", HumanID=");
		builder.append(HumanID);
		builder.append(", HumanFirstName=");
		builder.append(HumanFirstName);
		builder.append(", HumanLastName=");
		builder.append(HumanLastName);
		builder.append(", HumanDoB=");
		builder.append(HumanDoB);
		builder.append("]");
		return builder.toString();
	}
	//endregion
}
