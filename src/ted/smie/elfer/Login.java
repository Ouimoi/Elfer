package ted.smie.elfer;

import ted.smie.elfer.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Login extends Activity { 

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);

		// 点击按钮，进入真正的开始界面
		EditText name=(EditText)findViewById(R.id.editText1);
		Button real_start = (Button) findViewById(R.id.button1);
		real_start.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				//将昵称写入数据库
				//
				//
				//
				//
				//
				//
				Intent intent = new Intent(Login.this, Start.class);
				startActivity(intent);
			}
		});
	}
	

}
