/**
 * 
 */
package entities;

/**
 * Class representing a prescription on a medicine during a treatment.
 * 
 * @author Yitzhak Goldstein
 * @author Shalom Tzichtig
 * 
 * @see Medicine
 * @see Treatment
 */
public class Prescription
{
	//region attributes
	
	private long PrescriptionID;
	private long PrescriptionTreatmentID;
	private long PrescriptionMedicineID;
	
	//endregion

	//region contors
	
	public Prescription()
	{
		super();
	}

	public Prescription(long prescriptionID, long prescriptionTreatmentID,
			long prescriptionMedicineID)
	{
		super();
		PrescriptionID = prescriptionID;
		PrescriptionTreatmentID = prescriptionTreatmentID;
		PrescriptionMedicineID = prescriptionMedicineID;
	}

	//endregion

	//region getters/setters
	
	public long getPrescriptionID()
	{
		return PrescriptionID;
	}

	public void setPrescriptionID(long prescriptionID)
	{
		PrescriptionID = prescriptionID;
	}

	public long getPrescriptionTreatmentID()
	{
		return PrescriptionTreatmentID;
	}

	public void setPrescriptionTreatmentID(long prescriptionTreatmentID)
	{
		PrescriptionTreatmentID = prescriptionTreatmentID;
	}

	public long getPrescriptionMedicineID()
	{
		return PrescriptionMedicineID;
	}

	public void setPrescriptionMedicineID(long prescriptionMedicineID)
	{
		PrescriptionMedicineID = prescriptionMedicineID;
	}
	//endregion

	//region overrideMethods
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ (int) (PrescriptionID ^ (PrescriptionID >>> 32));
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
		Prescription other = (Prescription) obj;
		if (PrescriptionID != other.PrescriptionID)
			return false;
		return true;
	}
	
	@Override
	public String toString()
	{
		return "Prescription [PrescriptionID=" + PrescriptionID
				+ ", PrescriptionTreatmentID=" + PrescriptionTreatmentID
				+ ", PrescriptionMedicineID=" + PrescriptionMedicineID + "]";
	}
	//endregion
	
}
