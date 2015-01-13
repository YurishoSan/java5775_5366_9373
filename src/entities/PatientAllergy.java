/**
 * 
 */
package entities;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonAutoDetect.Visibility;

/**
 * Class representing pairs of patients and an allergy they have.
 * 
 * @author Yitzhak Goldstein
 * @author Shalom Tzichtig
 * 
 * @see Patient
 * @see Allergy
 */
@JsonAutoDetect(fieldVisibility=Visibility.ANY)
public class PatientAllergy
{
	//region attributes
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
	public PatientAllergy(long patientID, long allergyID)
	{
		super();
		PatientID = patientID;
		AllergyID = allergyID;
	}
	//endregion
	
	//region getters/setters
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
		result = prime * result + (int) (AllergyID ^ (AllergyID >>> 32));
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
		PatientAllergy other = (PatientAllergy) obj;
		if (AllergyID != other.AllergyID)
			return false;
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
		builder.append("PatientAllergy [PatientID=");
		builder.append(PatientID);
		builder.append(", AllergyID=");
		builder.append(AllergyID);
		builder.append("]");
		return builder.toString();
	}
	
	//endregion
}
