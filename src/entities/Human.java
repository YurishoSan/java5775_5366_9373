/**
 * 
 */
package entities;

import java.util.Date;

/**
 * Class representing a human.
 * 
 * @author Yitzhak Goldstein
 * @author Shalom Tzichtig
 * 
 * @see Patient
 * @see Doctor
 */

abstract class Human
{
	//region attributes
	protected long HumanID;
	protected String HumanFirstName;
	protected String HumanLastName;
	protected Date HumanDoB; //Date of birth
	//endregion

	//region contors
	/**
	 * 
	 */
	public Human()
	{
		super();
	}
	
	/**
	 * @param humanID
	 * @param humanFirstName
	 * @param humanLastName
	 * @param humanDoB
	 */
	public Human(long humanID, String humanFirstName, String humanLastName,
			Date humanDoB)
	{
		super();
		HumanID = humanID;
		HumanFirstName = humanFirstName;
		HumanLastName = humanLastName;
		HumanDoB = humanDoB;
	}
	//endregion
	
	//region getters/setters
	/**
	 * @return the humanID
	 */
	public long getHumanID()
	{
		return HumanID;
	}
	
	/**
	 * @param humanID the humanID to set
	 */
	public void setHumanID(long humanID)
	{
		HumanID = humanID;
	}
	
	/**
	 * @return the humanFirstName
	 */
	public String getHumanFirstName()
	{
		return HumanFirstName;
	}
	
	/**
	 * @param humanFirstName the humanFirstName to set
	 */
	public void setHumanFirstName(String humanFirstName)
	{
		HumanFirstName = humanFirstName;
	}
	
	/**
	 * @return the humanLastName
	 */
	public String getHumanLastName()
	{
		return HumanLastName;
	}
	
	/**
	 * @param humanLastName the humanLastName to set
	 */
	public void setHumanLastName(String humanLastName)
	{
		HumanLastName = humanLastName;
	}
	
	/**
	 * @return the humanDoB
	 */
	public Date getHumanDoB()
	{
		return HumanDoB;
	}
	
	/**
	 * @param humanDoB the humanDoB to set
	 */
	public void setHumanDoB(Date humanDoB)
	{
		HumanDoB = humanDoB;
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
		result = prime * result + (int) (HumanID ^ (HumanID >>> 32));
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
		Human other = (Human) obj;
		if (HumanID != other.HumanID)
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
		builder.append("Human [HumanID=");
		builder.append(HumanID);
		builder.append(", HumanFirstName=");
		builder.append(HumanFirstName);
		builder.append(", HumanLastName=");
		builder.append(HumanLastName);
		builder.append(", HumanDoB=");
		builder.append(HumanDoB);
		builder.append("]");
		return builder.toString();
	}
	//endregion
}
