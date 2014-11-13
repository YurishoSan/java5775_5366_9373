/**
 * 
 */
package entities;

import enums.Permit;

/**
 * @author Yurisho
 *
 */
public class Password
{
	//region attributes
	private long PasswordUserID;
	private String PasswordWord;
	private Permit PasswordPermit;
	//endregion
	
	//region contors
	/**
	 * 
	 */
	public Password()
	{
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param passwordUserID
	 * @param passwordWord
	 * @param passwordPermit
	 */
	public Password(long passwordUserID, String passwordWord,
			Permit passwordPermit)
	{
		super();
		PasswordUserID = passwordUserID;
		PasswordWord = passwordWord;
		PasswordPermit = passwordPermit;
	}
	//endregion
	
	//region getters/setters
	/**
	 * @return the passwordUserID
	 */
	public long getPasswordUserID()
	{
		return PasswordUserID;
	}

	/**
	 * @param passwordUserID the passwordUserID to set
	 */
	public void setPasswordUserID(long passwordUserID)
	{
		PasswordUserID = passwordUserID;
	}

	/**
	 * @return the passwordWord
	 */
	public String getPasswordWord()
	{
		return PasswordWord;
	}

	/**
	 * @param passwordWord the passwordWord to set
	 */
	public void setPasswordWord(String passwordWord)
	{
		PasswordWord = passwordWord;
	}

	/**
	 * @return the passwordPermit
	 */
	public Permit getPasswordPermit()
	{
		return PasswordPermit;
	}

	/**
	 * @param passwordPermit the passwordPermit to set
	 */
	public void setPasswordPermit(Permit passwordPermit)
	{
		PasswordPermit = passwordPermit;
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
				+ (int) (PasswordUserID ^ (PasswordUserID >>> 32));
		result = prime * result
				+ ((PasswordWord == null) ? 0 : PasswordWord.hashCode());
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
		Password other = (Password) obj;
		if (PasswordUserID != other.PasswordUserID)
			return false;
		if (PasswordWord == null)
		{
			if (other.PasswordWord != null)
				return false;
		} else if (!PasswordWord.equals(other.PasswordWord))
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
		builder.append("Password [PasswordUserID=");
		builder.append(PasswordUserID);
		builder.append(", PasswordWord=");
		builder.append(PasswordWord);
		builder.append(", PasswordPermit=");
		builder.append(PasswordPermit);
		builder.append("]");
		return builder.toString();
	}
	//endregion
}
