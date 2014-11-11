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
}
