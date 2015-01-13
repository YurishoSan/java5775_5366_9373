/**
 * 
 */
package entities;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonAutoDetect.Visibility;

/**
 * Class representing an allergy a person can have, and a medicine can cause.
 * 
 * @author Yitzhak Goldstein
 * @author Shalom Tzichtig
 */
@JsonAutoDetect(fieldVisibility=Visibility.ANY)
public class Allergy implements Serializable
{
	private static final long serialVersionUID = -4618679877862667599L;
	
	//region attributes
	private long AllergyID;
	private String AllergyName;
	private String AllergyNotes; //extra notes and info
	//endregion
	
	//region contors
	/**
	 * 
	 */
	public Allergy()
	{
		super();
	}
	/**
	 * @param allergyID
	 * @param allergyName
	 * @param allergyNotes
	 */
	public Allergy(long allergyID, String allergyName, String allergyNotes)
	{
		super();
		AllergyID = allergyID;
		AllergyName = allergyName;
		AllergyNotes = allergyNotes;
	}
	//endregion
	
	//region getters/setters
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
	/**
	 * @return the allergyName
	 */
	public String getAllergyName()
	{
		return AllergyName;
	}
	/**
	 * @param allergyName the allergyName to set
	 */
	public void setAllergyName(String allergyName)
	{
		AllergyName = allergyName;
	}
	/**
	 * @return the allergyNotes
	 */
	public String getAllergyNotes()
	{
		return AllergyNotes;
	}
	/**
	 * @param allergyNotes the allergyNotes to set
	 */
	public void setAllergyNotes(String allergyNotes)
	{
		AllergyNotes = allergyNotes;
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
		Allergy other = (Allergy) obj;
		if (AllergyID != other.AllergyID)
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
		builder.append("Allergy [AllergyID=");
		builder.append(AllergyID);
		builder.append(", AllergyPatientID=");
		builder.append(", AllergyName=");
		builder.append(AllergyName);
		builder.append(", AllergyNotes=");
		builder.append(AllergyNotes);
		builder.append("]");
		return builder.toString();
	}
	//endregion
}
