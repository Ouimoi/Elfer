package ted.smie.elfer;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

public class Login extends Activity {
	private SharedPreferences preferences;
	private Editor editor;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		
		//屏幕长亮
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON); 
		
		// 使用SharedPreferences来记录程序的使用次数
		preferences = getSharedPreferences("loginRec", Context.MODE_PRIVATE);
		editor = preferences.edit();
		// 判断是不是首次登录
		if (preferences.getBoolean("firststart", false)) {
			Intent intent = new Intent(Login.this, Start.class);
			startActivity(intent);
			finish();
		}
		else{
		// 点击按钮，进入真正的开始界面
		EditText name = (EditText) findViewById(R.id.editText1);
		Button real_start = (Button) findViewById(R.id.button1);
		real_start.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				// 将昵称写入数据库
				//
				//
				//
				//
				//
				//
				Intent intent = new Intent(Login.this, Start.class);
				// 将登录标志位设置为false，下次登录时不在显示首次登录界面
				editor.putBoolean("firststart", true);
				editor.commit();
				startActivity(intent);
			}
		});}
	}

}
