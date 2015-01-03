package ted.smie.elfer;

import ted.smie.elfer.navigator.AboutUs;
import ted.smie.elfer.navigator.Packs;
import ted.smie.elfer.navigator.Setting;

import ted.smie.elfer.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Start extends Activity {
 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.start);

		// 点击开始游戏，跳转到地图界面
		Button next = (Button) findViewById(R.id.button1);
		next.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Start.this, ted.smie.elfer.map.ElfMap.class);
				startActivity(intent);
			}
		});

		/********************抽屉界面的事件处理*******************************/
		// 点击左侧菜单栏里的元素，跳转到相应的界面    设置
		Button slider_set = (Button) this.findViewById(R.id.set);
		slider_set.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Start.this, Setting.class);
				startActivity(intent);
			}
		});

		// 点击左侧菜单栏里的元素，跳转到相应的界面     背包
		Button slider_packet = (Button) this.findViewById(R.id.packet);
		slider_packet.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Start.this, Packs.class);
				startActivity(intent);
			}
		});

		// 点击左侧菜单栏里的元素，跳转到相应的界面      关于我们
		Button slider_aboutUs = (Button) this.findViewById(R.id.aboutUs);
		slider_aboutUs.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Start.this, AboutUs.class);
				startActivity(intent);
			}
		});
		
		// 点击左侧菜单栏里的元素，跳转到相应的界面      退出
		Button slider_exit = (Button) this.findViewById(R.id.exit);
		slider_exit.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				//退出
				finish();
			}
		});
		/********************抽屉界面的事件处理*******************************/

	}

	// 左侧菜单栏的实现
	class PanelSlideListener implements
			android.support.v4.widget.SlidingPaneLayout.PanelSlideListener {
		@Override
		public void onPanelClosed(View view) {
			Start.this.closeOptionsMenu();
		}

		@Override
		public void onPanelOpened(View viw) {
			Start.this.openOptionsMenu();
		}

		@Override
		public void onPanelSlide(View arg0, float arg1) {
		}
	}
}