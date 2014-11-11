/**
 * 
 */
package entities;

import java.util.Date;

/**
 * @author Yitzhak Goldstein
 * @author Shalom Tzichtig
 * 
 */
public class Doctor
{
	//region attributes
	
	private long DoctorID;
	private String DoctorFirstName;
	private String DoctorLastName;
	private Date DoctorDoB; //Date of birth
	private Date DoctorDoJ; //Date of joining company
	private float DoctorSalary;
	private String DoctorPhoneNumber;
	
	//endregion
	
	//region contors
	
	public Doctor()
	{
		super();
	}

	public Doctor(long doctorID, String doctorFirstName, String doctorLastName,
			Date doctorDoB, Date doctorDoJ, float doctorSalary,
			String doctorPhoneNumber)
	{
		super();
		DoctorID = doctorID;
		DoctorFirstName = doctorFirstName;
		DoctorLastName = doctorLastName;
		DoctorDoB = doctorDoB;
		DoctorDoJ = doctorDoJ;
		DoctorSalary = doctorSalary;
		DoctorPhoneNumber = doctorPhoneNumber;
	}

	//endregion
	
	//region getters/setters
	
	public long getDoctorID()
	{
		return DoctorID;
	}

	public void setDoctorID(long doctorID)
	{
		DoctorID = doctorID;
	}

	public String getDoctorFirstName()
	{
		return DoctorFirstName;
	}

	public void setDoctorFirstName(String doctorFirstName)
	{
		DoctorFirstName = doctorFirstName;
	}

	public String getDoctorLastName()
	{
		return DoctorLastName;
	}

	public void setDoctorLastName(String doctorLastName)
	{
		DoctorLastName = doctorLastName;
	}

	public Date getDoctorDoB()
	{
		return DoctorDoB;
	}

	public void setDoctorDoB(Date doctorDoB)
	{
		DoctorDoB = doctorDoB;
	}

	public Date getDoctorDoJ()
	{
		return DoctorDoJ;
	}

	public void setDoctorDoJ(Date doctorDoJ)
	{
		DoctorDoJ = doctorDoJ;
	}

	public float getDoctorSalary()
	{
		return DoctorSalary;
	}

	public void setDoctorSalary(float doctorSalary)
	{
		DoctorSalary = doctorSalary;
	}

	public String getDoctorPhoneNumber()
	{
		return DoctorPhoneNumber;
	}

	public void setDoctorPhoneNumber(String doctorPhoneNumber)
	{
		DoctorPhoneNumber = doctorPhoneNumber;
	}
	//endregion
	
	//region overrideMethods
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (DoctorID ^ (DoctorID >>> 32));
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
		Doctor other = (Doctor) obj;
		if (DoctorID != other.DoctorID)
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("Doctor [DoctorID=");
		builder.append(DoctorID);
		builder.append(", DoctorFirstName=");
		builder.append(DoctorFirstName);
		builder.append(", DoctorLastName=");
		builder.append(DoctorLastName);
		builder.append(", DoctorDoB=");
		builder.append(DoctorDoB);
		builder.append(", DoctorDoJ=");
		builder.append(DoctorDoJ);
		builder.append(", DoctorSalary=");
		builder.append(DoctorSalary);
		builder.append(", DoctorPhoneNumber=");
		builder.append(DoctorPhoneNumber);
		builder.append("]");
		return builder.toString();
	}
	
	//endregion
}
