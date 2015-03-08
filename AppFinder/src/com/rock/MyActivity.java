package com.rock;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class MyActivity extends Activity {

	private ListView listView;
	private Activity thiz = this;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.mylayout);
		initChildComponents();

	}

	private void initChildComponents() {
		Button btn = (Button) findViewById(R.id.button1);
		btn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
//				MyActivity.this.searchApp();
				MyActivity.this.unistallApp();
				Toast.makeText(MyActivity.this, "hello world 123!!!",
						Toast.LENGTH_LONG).show();
			}
		});

		listView = (ListView) findViewById(R.id.listview);

	}
	private void startApp(){
		Intent youdao = getPackageManager().getLaunchIntentForPackage("com.youdao.note");
		startActivity(youdao);
	}
	private void searchApp() {
		PackageManager packageManager = getPackageManager();
		List<PackageInfo> packs = getPackageManager().getInstalledPackages(0);
		String data[] = new String[packs.size()];
		int i = 0;
		for (PackageInfo pack : packs) {
			if (pack.applicationInfo != null){
				 
				String appName = packageManager.getApplicationLabel(pack.applicationInfo).toString();
				data[i++] = appName + "        " + pack.packageName;// pack.packageName;
				System.out.println(appName + ":" +pack.packageName);
			}
		}
		// String data[] =
		// {"java","scala","clojure","groovy","c#","c","c++","go","python","rubby","perl","php","object-c"};
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(thiz,
				android.R.layout.simple_list_item_1, data);
		listView.setAdapter(adapter);
	}
	
	
	private void unistallApp(){
		Uri packageURI = Uri.parse("package:"+"com.youdao.note");
		Intent uninstallIntent = new Intent(Intent.ACTION_DELETE, packageURI);
		startActivity(uninstallIntent);
	}
	
	
	
	
}
