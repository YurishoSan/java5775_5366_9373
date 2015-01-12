/**
 * 
 */
package entities;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonAutoDetect.Visibility;

/**
 * Class representing a prescription on a medicine during a treatment.
 * 
 * @author Yitzhak Goldstein
 * @author Shalom Tzichtig
 * 
 * @see Medicine
 * @see Treatment
 */
@JsonAutoDetect(fieldVisibility=Visibility.ANY)
public class Prescription
{
	//region attributes
	
	private long PrescriptionTreatmentID;
	private long PrescriptionMedicineID;
	private Date PrescriptionMedicineExperationDate;
	
	//endregion

	//region contors
	/**
	 * 
	 */
	public Prescription()
	{
		super();
	}

	/**
	 * @param prescriptionTreatmentID
	 * @param prescriptionMedicineID
	 * @param prescriptionMedicineExperationDate
	 */
	public Prescription(long prescriptionTreatmentID,
			long prescriptionMedicineID, Date prescriptionMedicineExperationDate)
	{
		super();
		PrescriptionTreatmentID = prescriptionTreatmentID;
		PrescriptionMedicineID = prescriptionMedicineID;
		PrescriptionMedicineExperationDate = prescriptionMedicineExperationDate;
	}

	//endregion

	//region getters/setters

	/**
	 * @return the prescriptionTreatmentID
	 */
	public long getPrescriptionTreatmentID()
	{
		return PrescriptionTreatmentID;
	}

	/**
	 * @param prescriptionTreatmentID the prescriptionTreatmentID to set
	 */
	public void setPrescriptionTreatmentID(long prescriptionTreatmentID)
	{
		PrescriptionTreatmentID = prescriptionTreatmentID;
	}

	/**
	 * @return the prescriptionMedicineID
	 */
	public long getPrescriptionMedicineID()
	{
		return PrescriptionMedicineID;
	}

	/**
	 * @param prescriptionMedicineID the prescriptionMedicineID to set
	 */
	public void setPrescriptionMedicineID(long prescriptionMedicineID)
	{
		PrescriptionMedicineID = prescriptionMedicineID;
	}
	
	/**
	 * @return the prescriptionMedicineExperationDate
	 */
	public Date getPrescriptionMedicineExperationDate()
	{
		return PrescriptionMedicineExperationDate;
	}

	/**
	 * @param prescriptionMedicineExperationDate the prescriptionMedicineExperationDate to set
	 */
	public void setPrescriptionMedicineExperationDate(
			Date prescriptionMedicineExperationDate)
	{
		PrescriptionMedicineExperationDate = prescriptionMedicineExperationDate;
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
		result = prime
				* result
				+ (int) (PrescriptionMedicineID ^ (PrescriptionMedicineID >>> 32));
		result = prime
				* result
				+ (int) (PrescriptionTreatmentID ^ (PrescriptionTreatmentID >>> 32));
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
		Prescription other = (Prescription) obj;
		if (PrescriptionMedicineID != other.PrescriptionMedicineID)
			return false;
		if (PrescriptionTreatmentID != other.PrescriptionTreatmentID)
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
		builder.append("Prescription [PrescriptionTreatmentID=");
		builder.append(PrescriptionTreatmentID);
		builder.append(", PrescriptionMedicineID=");
		builder.append(PrescriptionMedicineID);
		builder.append(", PrescriptionMedicineExperationDate=");
		builder.append(PrescriptionMedicineExperationDate);
		builder.append("]");
		return builder.toString();
	}
	
	//endregion
}
