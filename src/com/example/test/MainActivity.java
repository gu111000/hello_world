package com.example.test;


import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.shareboard.SnsPlatform;
import com.umeng.socialize.utils.ShareBoardlistener;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		PlatformConfig.setWeixin("wx967daebe835fbeac", "5bb696d9ccd75a38c8a0bfe0675559b3");
	       //微信 appid appsecret
	PlatformConfig.setSinaWeibo("3921700954","04b48b094faeb16683c32669824ebdad");
	       //新浪微博 appkey appsecret
	PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba"); 
	        // QQ和Qzone appid appkey     
	PlatformConfig.setAlipay("2015111700822536");
	        //支付宝 appid
	PlatformConfig.setYixin("yxc0614e80c9304c11b0391514d09f13bf");
	        //易信 appkey      
	//PlatformConfig.setRenren("201874","28401c0964f04a72a14c812d6132fcef","3bf66e42db1e4fa9829b955cc300b737");
	        //人人 appid appkey appsecret
	PlatformConfig.setTwitter("3aIN7fuF685MuZ7jtXkQxalyi", "MK6FEYG63eWcpDFgRYw4w9puJhzDl0tyuqWjZ3M7XJuuG7mMbO");
	        //Twitter appid appkey
	PlatformConfig.setPinterest("1439206");
	        //Pinterest appid 
	PlatformConfig.setLaiwang("laiwangd497e70d4", "d497e70d4c3e4efeab1381476bac4c5e");
	        //来往 appid appkey
	
	findViewById(R.id.txt).setOnTouchListener(new OnTouchListener() {
		
		@Override
		public boolean onTouch(View v, MotionEvent event) {
			final SHARE_MEDIA[] displaylist = new SHARE_MEDIA[]
                    {
                        SHARE_MEDIA.WEIXIN, SHARE_MEDIA.WEIXIN_CIRCLE,SHARE_MEDIA.SINA,
                        SHARE_MEDIA.QQ, SHARE_MEDIA.QZONE
                    };
            new ShareAction(MainActivity.this).setDisplayList( displaylist )
                    .withText( "呵呵" )
                    .withTitle("title")
                    .withTargetUrl("http://www.baidu.com")
                    .setListenerList(umShareListener,umShareListener)
                    .setShareboardclickCallback(shareBoardlistener)
                    .open();
			return false;
		}
	});
	}
	
	private ShareBoardlistener shareBoardlistener = new ShareBoardlistener() {

		@Override
		public void onclick(SnsPlatform arg0, SHARE_MEDIA arg1) {
			
		}
    };
    
    private UMShareListener umShareListener = new UMShareListener() {
        @Override
        public void onResult(SHARE_MEDIA platform) {
            Toast.makeText(MainActivity.this,platform + " 分享成功啦", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onError(SHARE_MEDIA platform, Throwable t) {
            Toast.makeText(MainActivity.this,platform + " 分享失败啦", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onCancel(SHARE_MEDIA platform) {
            Toast.makeText(MainActivity.this,platform + " 分享取消了", Toast.LENGTH_SHORT).show();
        }
    };

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
