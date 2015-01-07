/**
 * 
 */
package entities;

import java.io.Serializable;
import java.util.Date;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonAutoDetect.Visibility;

import entities.enums.Gender;
import entities.enums.ServiceClass;

/**
 * Class representing a patient of the medical company
 * 
 * @author Yitzhak Goldstein
 * @author Shalom Tzichtig 
 * 
 * @see entities.enums.ServiceClass
 */
@JsonAutoDetect(fieldVisibility=Visibility.ANY)
public class Patient implements Serializable
{
	private static final long serialVersionUID = 1281384021264625797L;
	
	//region attributes
	private long PatientID;
	private String PatientFirstName;
	private String PatientLastName;
	private Gender PatientGender;
	private Date PatientDoB; //Date of birth
	private String PatientEmailAdress;
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
	 * @param patientID
	 * @param patientFirstName
	 * @param patientLastName
	 * @param patientGender
	 * @param patientDoB
	 * @param patientemailAdress
	 * @param patientServiceClass
	 * @param patientPhoneNumber
	 */
	public Patient(long patientID, String patientFirstName, String patientLastName,
			Gender patientGender, Date patientDoB, String patientEmailAdress,
			ServiceClass patientServiceClass, String patientPhoneNumber)
	{
		super();
		PatientID = patientID;
		PatientFirstName = patientFirstName;
		PatientLastName = patientLastName;
		PatientGender = patientGender;
		PatientDoB = patientDoB;
		PatientEmailAdress = patientEmailAdress;
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
	 * @return the patientID
	 */
	public long getPatientID()
	{
		return PatientID;
	}

	/**
	 * @param patientID the patientID to set
	 */
	public void setPatientID(long patientID)
	{
		PatientID = patientID;
	}

	/**
	 * @return the patientFirstName
	 */
	public String getPatientFirstName()
	{
		return PatientFirstName;
	}

	/**
	 * @param patientFirstName the patientFirstName to set
	 */
	public void setPatientFirstName(String patientFirstName)
	{
		PatientFirstName = patientFirstName;
	}

	/**
	 * @return the patientLastName
	 */
	public String getPatientLastName()
	{
		return PatientLastName;
	}

	/**
	 * @param patientLastName the patientLastName to set
	 */
	public void setPatientLastName(String patientLastName)
	{
		PatientLastName = patientLastName;
	}

	/**
	 * @return the patientGender
	 */
	public Gender getPatientGender()
	{
		return PatientGender;
	}

	/**
	 * @param patientGender the patientGender to set
	 */
	public void setPatientGender(Gender patientGender)
	{
		PatientGender = patientGender;
	}

	/**
	 * @return the patientDoB
	 */
	public Date getPatientDoB()
	{
		return PatientDoB;
	}

	/**
	 * @param patientDoB the patientDoB to set
	 */
	public void setPatientDoB(Date patientDoB)
	{
		PatientDoB = patientDoB;
	}

	/**
	 * @return the patientemailAdress
	 */
	public String getPatientEmailAdress()
	{
		return PatientEmailAdress;
	}

	/**
	 * @param patientEmailAdress the patientEmailAdress to set
	 */
	public void setPatientEmailAdress(String patientEmailAdress)
	{
		PatientEmailAdress = patientEmailAdress;
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
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (PatientID ^ (PatientID >>> 32));
		return result;
	}
	
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
		if (PatientID != other.PatientID)
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
		builder.append("Patient [PatientID=");
		builder.append(PatientID);
		builder.append(", PatientFirstName=");
		builder.append(PatientFirstName);
		builder.append(", PatientLastName=");
		builder.append(PatientLastName);
		builder.append(", PatientGender=");
		builder.append(PatientGender);
		builder.append(", PatientDoB=");
		builder.append(PatientDoB);
		builder.append(", PatientEmailAdress=");
		builder.append(PatientEmailAdress);
		builder.append(", PatientServiceClass=");
		builder.append(PatientServiceClass);
		builder.append(", PatientPhoneNumber=");
		builder.append(PatientPhoneNumber);
		builder.append("]");
		return builder.toString();
	}

	//endregion
}
