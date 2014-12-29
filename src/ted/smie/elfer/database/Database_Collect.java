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

public class Database_Collect extends SQLiteOpenHelper {
	private static final String DB_NAME = "Elfer.db";
	private static final String TABLE_NAME = "Collect";
	private static final int DB_VERSION = 1;
	
	public Database_Collect(Context context) {
		super(context, DB_NAME, null, DB_VERSION);
	}
	
	/* 第一次调用getWritableDatabase（）或getReadableDatabase()时自动调用 */
	@Override
	public void onCreate(SQLiteDatabase db) {
		// 创建数据库
		String SQL_create_table = "create table " + TABLE_NAME
				+ "(_id integer primary key autoincrement," + "ename string);";
		db.execSQL(SQL_create_table);
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
	}
	
	//添加新的精灵
	public void insertToDB(String nname) {
		SQLiteDatabase db=getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put("ename", nname);
		db.insert(TABLE_NAME, null, values);
		db.close();
		}
	
	//查看精灵
	public List<Map<String, Object>> queryDB() {
		List<Map<String, Object>> mDatalist = new ArrayList<Map<String, Object>>(); 
		SQLiteDatabase db=getReadableDatabase();
		Cursor c=db.query(TABLE_NAME, null, null, null, null, null, null);
		while(c.moveToNext()){
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("ename", c.getString(c.getColumnIndex("ename")));
			map.put("_id", c.getString(c.getColumnIndex("_id")));
			mDatalist.add(map);
		}
		db.close();
		return mDatalist;
	}
	
	//删除精灵
	public void deleteFromDB(int nid){
		SQLiteDatabase db=getWritableDatabase();
		db.delete(TABLE_NAME,"_id"+"="+"'"+nid+"'",null);	
		db.close();
	}
	
}

