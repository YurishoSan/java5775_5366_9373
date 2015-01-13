/**
 * 
 */
package entities;

import java.io.Serializable;
import java.util.Date;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonAutoDetect.Visibility;

/**
 * Class representing a treatment of a patient by a doctor.
 * 
 * @author Yitzhak Goldstein
 * @author Shalom Tzichtig
 * 
 * @see Patient
 * @see Doctor
 */
@JsonAutoDetect(fieldVisibility=Visibility.ANY)
public class Treatment implements Serializable
{
	private static final long serialVersionUID = 3494624214489624333L;
	
	//region attributes
	private long TreatmentID;
	private long TreatmentDoctorID;
	private long TreatmentPatientID;
	private Date TreatmentDate;
	private String TreatmentLocation;
	private String TreatmentSummary;
	private boolean TreatmentDone; // false = treatment is appointment, true = treatment is over.
	
	//endregion

	//region contors	
	/**
	 * 
	 */
	public Treatment()
	{
		super();
	}
	
	/**
	 * @param treatmentID
	 * @param treatmentDoctorID
	 * @param treatmentPatientID
	 * @param treatmentDate
	 * @param treatmentLocation
	 * @param treatmentSummary
	 * @param treatmentDone
	 */
	public Treatment(long treatmentID, long treatmentDoctorID,
			long treatmentPatientID, Date treatmentDate,
			String treatmentLocation, String treatmentSummary,
			boolean treatmentDone)
	{
		super();
		TreatmentID = treatmentID;
		TreatmentDoctorID = treatmentDoctorID;
		TreatmentPatientID = treatmentPatientID;
		TreatmentDate = treatmentDate;
		TreatmentLocation = treatmentLocation;
		TreatmentSummary = treatmentSummary;
		TreatmentDone = treatmentDone;
	}
	//endregion

	//region getters/setters

	/**
	 * @return the treatmentID
	 */
	public long getTreatmentID()
	{
		return TreatmentID;
	}

	/**
	 * @param treatmentID the treatmentID to set
	 */
	public void setTreatmentID(long treatmentID)
	{
		TreatmentID = treatmentID;
	}

	/**
	 * @return the treatmentDoctorID
	 */
	public long getTreatmentDoctorID()
	{
		return TreatmentDoctorID;
	}

	/**
	 * @param treatmentDoctorID the treatmentDoctorID to set
	 */
	public void setTreatmentDoctorID(long treatmentDoctorID)
	{
		TreatmentDoctorID = treatmentDoctorID;
	}

	/**
	 * @return the treatmentPatientID
	 */
	public long getTreatmentPatientID()
	{
		return TreatmentPatientID;
	}

	/**
	 * @param treatmentPatientID the treatmentPatientID to set
	 */
	public void setTreatmentPatientID(long treatmentPatientID)
	{
		TreatmentPatientID = treatmentPatientID;
	}

	/**
	 * @return the treatmentDate
	 */
	public Date getTreatmentDate()
	{
		return TreatmentDate;
	}

	/**
	 * @param treatmentDate the treatmentDate to set
	 */
	public void setTreatmentDate(Date treatmentDate)
	{
		TreatmentDate = treatmentDate;
	}

	/**
	 * @return the treatmentLocation
	 */
	public String getTreatmentLocation()
	{
		return TreatmentLocation;
	}

	/**
	 * @param treatmentLocation the treatmentLocation to set
	 */
	public void setTreatmentLocation(String treatmentLocation)
	{
		TreatmentLocation = treatmentLocation;
	}

	/**
	 * @return the treatmentSummary
	 */
	public String getTreatmentSummary()
	{
		return TreatmentSummary;
	}

	/**
	 * @param treatmentSummary the treatmentSummary to set
	 */
	public void setTreatmentSummary(String treatmentSummary)
	{
		TreatmentSummary = treatmentSummary;
	}

	/**
	 * @return the treatmentDone
	 */
	public boolean isTreatmentDone()
	{
		return TreatmentDone;
	}

	/**
	 * @param treatmentDone the treatmentDone to set
	 */
	public void setTreatmentDone(boolean treatmentDone)
	{
		TreatmentDone = treatmentDone;
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
		result = prime * result + (int) (TreatmentID ^ (TreatmentID >>> 32));
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
		Treatment other = (Treatment) obj;
		if (TreatmentID != other.TreatmentID)
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
		builder.append("Treatment [TreatmentID=");
		builder.append(TreatmentID);
		builder.append(", TreatmentDoctorID=");
		builder.append(TreatmentDoctorID);
		builder.append(", TreatmentPatientID=");
		builder.append(TreatmentPatientID);
		builder.append(", TreatmentDate=");
		builder.append(TreatmentDate);
		builder.append(", TreatmentLocation=");
		builder.append(TreatmentLocation);
		builder.append(", TreatmentSummary=");
		builder.append(TreatmentSummary);
		builder.append(", TreatmentDone=");
		builder.append(TreatmentDone);
		builder.append("]");
		return builder.toString();
	}
	//endregion
}
