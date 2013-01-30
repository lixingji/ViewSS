package com.example.listview;

import java.lang.reflect.Array;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {

	private ListView listview;
	private ArrayAdapter<String> adapter;
	private List<String> data; 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		data=MyDataSource.getDataSource();
		adapter=new ArrayAdapter<String>(MainActivity.this,
				      android.R.layout.simple_list_item_single_choice,data);
		listview=(ListView)this.findViewById(R.id.listview);
		listview.setChoiceMode(ListView.CHOICE_MODE_SINGLE);//单选模式
		
		listview.setAdapter(adapter);
		listview.setOnItemLongClickListener(new OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, "Click me", 1).show();
				return false;
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
