package ted.smie.elfer.map;

import ted.smie.elfer.R;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BaiduMap.OnMarkerClickListener;
import com.baidu.mapapi.map.BaiduMapOptions;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.MyLocationConfiguration;
import com.baidu.mapapi.map.MyLocationConfiguration.LocationMode;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.model.LatLng;

public class ElfMap extends ActionBarActivity {

	private static final String LTAG = ElfMap.class.getSimpleName();
	private MapView mMapView;
	private BaiduMap mBaiduMap;
	private Marker ma, mb, mc, md;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		SDKInitializer.initialize(getApplicationContext());
		LatLng p = new LatLng(22.352921, 113.596621);
		mMapView = new MapView(this,
				new BaiduMapOptions().mapStatus(new MapStatus.Builder().target(
						p).build()));
		setContentView(mMapView);

		mBaiduMap = mMapView.getMap();
		mBaiduMap.setMapType(BaiduMap.MAP_TYPE_SATELLITE);
		mBaiduMap.setMyLocationEnabled(true);
		MyLocationData locData = new MyLocationData.Builder()
				.latitude(22.352911).longitude(113.596621).build();
		mBaiduMap.setMyLocationData(locData);
		BitmapDescriptor mcm = BitmapDescriptorFactory
				.fromResource(R.drawable.ic_launcher);
		MyLocationConfiguration config = new MyLocationConfiguration(
				LocationMode.NORMAL, true, mcm);
		mBaiduMap.setMyLocationConfigeration(config);

		LatLng library = new LatLng(22.349821, 113.595543);
		LatLng market = new LatLng(22.35618, 113.592003);
		LatLng bank = new LatLng(22.352821, 113.595615);
		LatLng gym = new LatLng(22.355788, 113.587332);
		BitmapDescriptor bitmapa = BitmapDescriptorFactory
				.fromResource(R.drawable.ic_launcher);
		OverlayOptions optiona = new MarkerOptions().position(library)
				.icon(bitmapa).zIndex(9).draggable(true);
		ma = (Marker) (mBaiduMap.addOverlay(optiona));
		OverlayOptions optionb = new MarkerOptions().position(market)
				.icon(bitmapa).zIndex(9).draggable(true);
		mb = (Marker) (mBaiduMap.addOverlay(optionb));
		OverlayOptions optionc = new MarkerOptions().position(bank)
				.icon(bitmapa).zIndex(9).draggable(true);
		mc = (Marker) (mBaiduMap.addOverlay(optionc));
		OverlayOptions optiond = new MarkerOptions().position(gym)
				.icon(bitmapa).zIndex(9).draggable(true);
		md = (Marker) (mBaiduMap.addOverlay(optiond));

		mBaiduMap.setOnMarkerClickListener(new OnMarkerClickListener() {

			@Override
			public boolean onMarkerClick(Marker m) {
				Intent intent = new Intent(ElfMap.this,
						com.zbar.lib.CaptureActivity.class);
				Bundle b = new Bundle();
				if (m == ma) {
					b.putString("buttonId", "1");
				} else if (m == mb) {
					b.putString("buttonId", "2");
				} else if (m == mc) {
					b.putString("buttonId", "3");
				} else if (m == md) {
					b.putString("buttonId", "4");
				}
				intent.putExtras(b);
				startActivity(intent);
				return false;
			}
		});

	}

	@Override
	protected void onPause() {
		super.onPause();
		// activity 暂停时同时暂停地图控件
		mMapView.onPause();
	}

	@Override
	protected void onResume() {
		super.onResume();
		// activity 恢复时同时恢复地图控件
		mMapView.onResume();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		// activity 销毁时同时销毁地图控件
		mMapView.onDestroy();
	}

}
