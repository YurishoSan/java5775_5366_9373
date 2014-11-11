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
}
