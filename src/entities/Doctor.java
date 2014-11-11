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
	private long DoctorID;
	private String DoctorFirstName;
	private String DoctorLastName;
	private Date DoctorDoB; //Date of birth
	private Date DoctorDoJ; //Date of joining company
	private float DoctorSalary;
	private String DoctorPhoneNumber;
	
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
}
