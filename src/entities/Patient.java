/**
 * 
 */
package entities;

import java.util.Date;









import enums.Gender;
import enums.ServiceClass;

/**
 * Class representing a patient of the medical company
 * 
 * @author Yitzhak Goldstein
 * @author Shalom Tzichtig 
 * 
 * @see enums.ServiceClass
 */
public class Patient
{
	//region attributes
	private long HumanID;
	private String HumanFirstName;
	private String HumanLastName;
	private Gender HumanGender;
	private Date HumanDoB; //Date of birth
	private String EmailAdress;
	private ServiceClass PatientServiceClass; // level of service the company provides to the patient
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
	 * @param humanGender
	 * @param humanDoB
	 * @param emailAdress
	 * @param patientServiceClass
	 * @param patientPhoneNumber
	 */
	public Patient(long humanID, String humanFirstName, String humanLastName,
			Gender humanGender, Date humanDoB, String emailAdress,
			ServiceClass patientServiceClass, String patientPhoneNumber)
	{
		super();
		HumanID = humanID;
		HumanFirstName = humanFirstName;
		HumanLastName = humanLastName;
		HumanGender = humanGender;
		HumanDoB = humanDoB;
		EmailAdress = emailAdress;
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
	 * @return the humanID
	 */
	public long getHumanID()
	{
		return HumanID;
	}

	/**
	 * @param humanID the humanID to set
	 */
	public void setHumanID(long humanID)
	{
		HumanID = humanID;
	}

	/**
	 * @return the humanFirstName
	 */
	public String getHumanFirstName()
	{
		return HumanFirstName;
	}

	/**
	 * @param humanFirstName the humanFirstName to set
	 */
	public void setHumanFirstName(String humanFirstName)
	{
		HumanFirstName = humanFirstName;
	}

	/**
	 * @return the humanLastName
	 */
	public String getHumanLastName()
	{
		return HumanLastName;
	}

	/**
	 * @param humanLastName the humanLastName to set
	 */
	public void setHumanLastName(String humanLastName)
	{
		HumanLastName = humanLastName;
	}

	/**
	 * @return the humanGender
	 */
	public Gender getHumanGender()
	{
		return HumanGender;
	}

	/**
	 * @param humanGender the humanGender to set
	 */
	public void setHumanGender(Gender humanGender)
	{
		HumanGender = humanGender;
	}

	/**
	 * @return the humanDoB
	 */
	public Date getHumanDoB()
	{
		return HumanDoB;
	}

	/**
	 * @param humanDoB the humanDoB to set
	 */
	public void setHumanDoB(Date humanDoB)
	{
		HumanDoB = humanDoB;
	}

	/**
	 * @return the emailAdress
	 */
	public String getEmailAdress()
	{
		return EmailAdress;
	}

	/**
	 * @param emailAdress the emailAdress to set
	 */
	public void setEmailAdress(String emailAdress)
	{
		EmailAdress = emailAdress;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (HumanID ^ (HumanID >>> 32));
		return result;
	}

	//region overrideMethods
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Patient other = (Patient) obj;
		if (HumanID != other.HumanID)
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("Patient [HumanID=");
		builder.append(HumanID);
		builder.append(", HumanFirstName=");
		builder.append(HumanFirstName);
		builder.append(", HumanLastName=");
		builder.append(HumanLastName);
		builder.append(", HumanGender=");
		builder.append(HumanGender);
		builder.append(", HumanDoB=");
		builder.append(HumanDoB);
		builder.append(", EmailAdress=");
		builder.append(EmailAdress);
		builder.append(", PatientServiceClass=");
		builder.append(PatientServiceClass);
		builder.append(", PatientPhoneNumber=");
		builder.append(PatientPhoneNumber);
		builder.append("]");
		return builder.toString();
	}

	//endregion
}
