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
public class Treatment
{
	//region attributes
	
	private long TreatmentID;
	private long TreatmentDoctorID;
	private long TreatmentPatientID;
	private Date TreatmentDate;
	private String TreatmentSummary;
	
	//endregion
	//region contors
	
	public Treatment()
	{
		super();
	}
	
	public Treatment(long treatmentID, long treatmentDoctorID,
			long treatmentPatientID, Date treatmentDate, String treatmentSummary)
	{
		super();
		TreatmentID = treatmentID;
		TreatmentDoctorID = treatmentDoctorID;
		TreatmentPatientID = treatmentPatientID;
		TreatmentDate = treatmentDate;
		TreatmentSummary = treatmentSummary;
	}
	
	//endregion
	//region getters/setters

	public long getTreatmentID()
	{
		return TreatmentID;
	}

	public void setTreatmentID(long treatmentID)
	{
		TreatmentID = treatmentID;
	}

	public long getTreatmentDoctorID()
	{
		return TreatmentDoctorID;
	}

	public void setTreatmentDoctorID(long treatmentDoctorID)
	{
		TreatmentDoctorID = treatmentDoctorID;
	}

	public long getTreatmentPatientID()
	{
		return TreatmentPatientID;
	}

	public void setTreatmentPatientID(long treatmentPatientID)
	{
		TreatmentPatientID = treatmentPatientID;
	}

	public Date getTreatmentDate()
	{
		return TreatmentDate;
	}

	public void setTreatmentDate(Date treatmentDate)
	{
		TreatmentDate = treatmentDate;
	}

	public String getTreatmentSummary()
	{
		return TreatmentSummary;
	}

	public void setTreatmentSummary(String treatmentSummary)
	{
		TreatmentSummary = treatmentSummary;
	}
	//endregion
}
