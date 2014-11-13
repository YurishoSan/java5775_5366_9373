/**
 * 
 */
package entities;

/**
 * @author Yurisho
 *
 */
public class PatientAllergy
{
	//region attributes
	private long PatientAllergyID;
	private long PateintID;
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
	 * @param pateintID
	 * @param allergyID
	 */
	public PatientAllergy(long patientAllergyID, long pateintID, long allergyID)
	{
		super();
		PatientAllergyID = patientAllergyID;
		PateintID = pateintID;
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
	 * @return the pateintID
	 */
	public long getPateintID()
	{
		return PateintID;
	}
	/**
	 * @param pateintID the pateintID to set
	 */
	public void setPateintID(long pateintID)
	{
		PateintID = pateintID;
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
		builder.append(", PateintID=");
		builder.append(PateintID);
		builder.append(", AllergyID=");
		builder.append(AllergyID);
		builder.append("]");
		return builder.toString();
	}
	//endregion
}
