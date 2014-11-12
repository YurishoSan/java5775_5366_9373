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
	/**
	 * 
	 */
	public Prescription()
	{
		super();
	}

	/**
	 * @param prescriptionID
	 * @param prescriptionTreatmentID
	 * @param prescriptionMedicineID
	 */
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
	/**
	 * @return the prescriptionID
	 */
	public long getPrescriptionID()
	{
		return PrescriptionID;
	}

	/**
	 * @param prescriptionID the prescriptionID to set
	 */
	public void setPrescriptionID(long prescriptionID)
	{
		PrescriptionID = prescriptionID;
	}

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
		result = prime * result
				+ (int) (PrescriptionID ^ (PrescriptionID >>> 32));
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
		if (PrescriptionID != other.PrescriptionID)
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
		builder.append("Prescription [PrescriptionID=");
		builder.append(PrescriptionID);
		builder.append(", PrescriptionTreatmentID=");
		builder.append(PrescriptionTreatmentID);
		builder.append(", PrescriptionMedicineID=");
		builder.append(PrescriptionMedicineID);
		builder.append("]");
		return builder.toString();
	}
	//endregion
}
