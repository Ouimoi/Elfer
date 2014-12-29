package ted.smie.elfer.database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database_User extends SQLiteOpenHelper {
	private static final String DB_NAME = "Elfer.db";
	private static final String TABLE_NAME = "User";
	private static final int DB_VERSION = 1;
	
	public Database_User(Context context) {
		super(context, DB_NAME, null, DB_VERSION);
	}
	
	/*第一次调用getWritableDatabase（）或getReadableDatabase()时自动调用 */
	@Override
	public void onCreate(SQLiteDatabase db) {
		//创建数据库
		String SQL_create_table="create table "+TABLE_NAME+"(id String,name string,"+"faction string);";
		db.execSQL(SQL_create_table);
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
	}
	
	//为数据库添加用户信息
	public void insertToDB(String nname,String nfaction) {
		SQLiteDatabase db=getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put("name", nname);
		values.put("faction", nfaction);
		values.put("id", "11");
		db.insert(TABLE_NAME, null, values);
		db.close();
		}
	
	//查询用户信息
	public List<Map<String, Object>> queryDB() {
		List<Map<String, Object>> mDatalist = new ArrayList<Map<String, Object>>(); 
		SQLiteDatabase db=getReadableDatabase();
		Cursor c=db.query(TABLE_NAME, null, null, null, null, null, null);
		while(c.moveToNext()){
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("name", c.getString(c.getColumnIndex("name")));
			map.put("faction", c.getString(c.getColumnIndex("faction")));
			mDatalist.add(map);
		}
		db.close();
		return mDatalist;
	}
	
	//修改用户信息        
	public void updateAContact(String nname,String nfaction) {
		SQLiteDatabase db=getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put("name", nname);
		values.put("faction", nfaction);
		db.update(TABLE_NAME, values,"id"+"="+"11" ,null);
		db.close();
		
	}
	
}

