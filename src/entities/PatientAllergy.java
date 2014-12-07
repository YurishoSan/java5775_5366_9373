/**
 * 
 */
package entities;

/**
 * Class representing pairs of patients and an allergy they have.
 * 
 * @author Yitzhak Goldstein
 * @author Shalom Tzichtig
 * 
 * @see Patient
 * @see Allergy
 */
public class PatientAllergy
{
	//region attributes
	private long PatientAllergyID;
	private long PatientID;
	private long AllergyID;
	//endregion
	
	//region contors
	/**
	 * 
	 */
	public PatientAllergy()
	{
		super();
	}
	/**
	 * @param patientAllergyID
	 * @param patientID
	 * @param allergyID
	 */
	public PatientAllergy(long patientAllergyID, long patientID, long allergyID)
	{
		super();
		PatientAllergyID = patientAllergyID;
		PatientID = patientID;
		AllergyID = allergyID;
	}
	//endregion
	
	//region getters/setters
	/**
	 * @return the patientAllergyID
	 */
	public long getPatientAllergyID()
	{
		return PatientAllergyID;
	}
	/**
	 * @param patientAllergyID the patientAllergyID to set
	 */
	public void setPatientAllergyID(long patientAllergyID)
	{
		PatientAllergyID = patientAllergyID;
	}
	/**
	 * @return the patientID
	 */
	public long getPatientID()
	{
		return PatientID;
	}
	/**
	 * @param pateintID the pateintID to set
	 */
	public void setPatientID(long patientID)
	{
		PatientID = patientID;
	}
	/**
	 * @return the allergyID
	 */
	public long getAllergyID()
	{
		return AllergyID;
	}
	/**
	 * @param allergyID the allergyID to set
	 */
	public void setAllergyID(long allergyID)
	{
		AllergyID = allergyID;
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
				+ (int) (PatientAllergyID ^ (PatientAllergyID >>> 32));
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
		PatientAllergy other = (PatientAllergy) obj;
		if (PatientAllergyID != other.PatientAllergyID)
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
		builder.append("PatientAllergy [PatientAllergyID=");
		builder.append(PatientAllergyID);
		builder.append(", PatientID=");
		builder.append(PatientID);
		builder.append(", AllergyID=");
		builder.append(AllergyID);
		builder.append("]");
		return builder.toString();
	}
	//endregion
}
