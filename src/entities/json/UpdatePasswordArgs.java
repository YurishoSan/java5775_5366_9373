/**
 * 
 */
package entities.json;

import entities.Password;

/**
 * Class used to pass arguments in DatabaseService and API-DB.
 *
 */
public class UpdatePasswordArgs
{
	public Password oldPassword;
	public String newPassword;

	/**
	 * 
	 */
	public UpdatePasswordArgs()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param oldPassword
	 * @param newPassword
	 */
	public UpdatePasswordArgs(Password oldPassword, String newPassword)
	{
		super();
		this.oldPassword = oldPassword;
		this.newPassword = newPassword;
	}
	
	
}
