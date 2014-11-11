/**
 * 
 */
package entities;

import java.util.Date;

/**
 * @author Yitzhak Goldstein
 * @author Shalom Tzichtig
 * 
 */
public class Patient
{
	//region attributes
	
	private long PatientID;
	private String PatientFirstName;
	private String PatientLastName;
	private String PatientServiceClass; // TODO: make service class enum.
	private String PatientPhoneNumber;
	private Date PatientDoB; // Date of birth
	
	//endregion

	//region contors
	
	public Patient()
	{
		super();
	}

	public Patient(long patientID, String patientFirstName,
			String patientLastName, String patientServiceClass,
			String patientPhoneNumber, Date patientDoB)
	{
		super();
		PatientID = patientID;
		PatientFirstName = patientFirstName;
		PatientLastName = patientLastName;
		PatientServiceClass = patientServiceClass;
		PatientPhoneNumber = patientPhoneNumber;
		PatientDoB = patientDoB;
	}

	//endregion

	//region getters/setters
	
	public long getPatientID()
	{
		return PatientID;
	}

	public void setPatientID(long patientID)
	{
		PatientID = patientID;
	}

	public String getPatientFirstName()
	{
		return PatientFirstName;
	}

	public void setPatientFirstName(String patientFirstName)
	{
		PatientFirstName = patientFirstName;
	}

	public String getPatientLastName()
	{
		return PatientLastName;
	}

	public void setPatientLastName(String patientLastName)
	{
		PatientLastName = patientLastName;
	}

	public String getPatientServiceClass()
	{
		return PatientServiceClass;
	}

	public void setPatientServiceClass(String patientServiceClass)
	{
		PatientServiceClass = patientServiceClass;
	}

	public String getPatientPhoneNumber()
	{
		return PatientPhoneNumber;
	}

	public void setPatientPhoneNumber(String patientPhoneNumber)
	{
		PatientPhoneNumber = patientPhoneNumber;
	}

	public Date getPatientDoB()
	{
		return PatientDoB;
	}

	public void setPatientDoB(Date patientDoB)
	{
		PatientDoB = patientDoB;
	}
	//endregion

	//region overrideMethods
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (PatientID ^ (PatientID >>> 32));
		return result;
	}

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
		builder.append(", PatientServiceClass=");
		builder.append(PatientServiceClass);
		builder.append(", PatientPhoneNumber=");
		builder.append(PatientPhoneNumber);
		builder.append(", PatientDoB=");
		builder.append(PatientDoB);
		builder.append("]");
		return builder.toString();
	}
	//endregion
}
