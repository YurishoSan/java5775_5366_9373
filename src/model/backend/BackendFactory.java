package model.backend;

import android.content.Context;

import model.datasource.*;

enum Mode
{
	LISTS,
	SQL,
	SERVICE
}

public final class BackendFactory
{

	static Backend instance = null;
	
	public static Mode mode = Mode.SERVICE;
	
	
	public final static Backend getInstance(Context context)
	{
		if (mode == Mode.LISTS)
		{
			if (instance == null)
				instance = new DatabaseList();
			return instance;
		}
		
		else if (mode == Mode.SQL)
		{
			if (instance == null)
				instance = new DatabaseSqlite(context);
			return instance;
		}
		
		else if (mode == Mode.SERVICE)
		{
			if (instance == null)
				instance = new DatabaseService();
			return instance;
		}
		else
			return null;
	}

}
