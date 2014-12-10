/**
 * 
 */
package model.backend;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.widget.Toast;

/**
 * @author Yurisho
 *
 */
public class asyncTask extends AsyncTask<Void, Void, Void>
{
	private ProgressDialog progressDialog;
	private Activity activity;
	private Exception exp;
	private Run back, post;
	
	/**
	 * 
	 * @param activity
	 * @param progressDialog
	 * @param back
	 * @param post
	 */
	public asyncTask(Activity activity, ProgressDialog progressDialog, Run back, Run post)
	{
		super();
		this.activity = activity;
		this.back = back;
		this.post = post;
		this.progressDialog = progressDialog;
	}

	/* (non-Javadoc)
	 * @see android.os.AsyncTask#doInBackground(java.lang.Object[])
	 */
	@Override
	protected Void doInBackground(Void... params)
	{
		try
		{
			back.run();
		}
		catch (Exception exp)
		{
			this.exp = exp;
			
			if (exp.getMessage().contains("Read timed out"))
				this.exp = new Exception("No response from server. Try again.");
			else if (exp.getMessage().contains("@@@"))
			{
				String s = exp.getMessage();
				s = s.replaceAll("[^@]*@@@|###[^@]*", "");
				this.exp = new Exception(s);
			}
			else
				this.exp = exp;
		}
		
		return null;
	}

	/* (non-Javadoc)
	 * @see android.os.AsyncTask#onPreExecute()
	 */
	@Override
	protected void onPreExecute()
	{
		try
		{
			progressDialog = ProgressDialog.show(activity, "please wait", "טוען נתונים...", true);
		}
		catch (Exception exp)
		{
			exp.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see android.os.AsyncTask#onPostExecute(java.lang.Object)
	 */
	@Override
	protected void onPostExecute(Void result)
	{
		try
		{
			if (progressDialog.isShowing())
				progressDialog.dismiss();
			if (exp != null)
				Toast.makeText(activity, exp.getMessage(), Toast.LENGTH_SHORT).show();
			else
				post.run();
		}
		catch (Exception exp)
		{
			exp.printStackTrace();
		}
	}
	
	

}
