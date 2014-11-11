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
	
	public Doctor()
	{
       this.DoctorID = 0;
	   this.DoctorFirstName="";
	   this.DoctorLastName="";
	   this.DoctorDoB=null;
	   this.DoctorDoJ=null;
	   this.DoctorSalary=0;	
	}
	
	public Doctor(long DoctorID, String DoctorFirstName, String DoctorLastName,
					Date DoctorDoB, Date DoctorDoJ, float DoctorSalary)
	{
		this.DoctorID = DoctorID;
		this.DoctorFirstName=DoctorFirstName;
		this.DoctorLastName=DoctorLastName;
		this.DoctorDoB=DoctorDoB;
		this.DoctorDoJ=DoctorDoJ;
		this.DoctorSalary=DoctorSalary;	
	}
}
