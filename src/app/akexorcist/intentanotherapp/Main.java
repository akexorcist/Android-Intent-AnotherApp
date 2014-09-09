package app.akexorcist.intentanotherapp;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Main extends Activity {
	Button buttonFacebook, buttonEvernote, buttonYoutube;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		buttonFacebook = (Button)findViewById(R.id.buttonFacebook);
		buttonFacebook.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				String packageName = "com.facebook.katana";
				startApp(packageName);
			}
		});
		
		buttonYoutube = (Button)findViewById(R.id.buttonYoutube);
		buttonYoutube.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				String packageName = "com.google.android.youtube";
				startApp(packageName);
			}
		});
		
		buttonEvernote = (Button)findViewById(R.id.buttonEvernote);
		buttonEvernote.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				String packageName = "com.evernote";
				startApp(packageName);
			}
		});
	}
	
	public void startApp(String packageName) {
		try {
			Intent intent = getPackageManager().getLaunchIntentForPackage(packageName);
			intent.addCategory(Intent.CATEGORY_LAUNCHER);
			startActivity(intent);
		} catch (NullPointerException e) {
			Intent intent = new Intent(Intent.ACTION_VIEW);
			intent.setData(Uri.parse("market://details?id=" + packageName));
			startActivity(intent);
		}
	}
}
