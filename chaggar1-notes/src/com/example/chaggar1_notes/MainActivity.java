package com.example.chaggar1_notes;

//The structure of this program is based on the Lonely Twitter Model provided in
//the CMPUT 301 Lab 3 Tutorial. A link to the git file may be found at the following
//web address: https://github.com/g-chag/lonelyTwitter.git
 
import java.util.ArrayList;
 
import android.os.Bundle;
import android.app.Activity;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Button;

public class MainActivity extends Activity {
 
	private EditText AddedText;
	private ListView ListOfToDos;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_main);

	    AddedText = (EditText) findViewById(R.id.ToDoInsert);
	    Button AddWithButton = (Button) findViewById(R.id.AddButton);
	    ListOfToDos = (ListView) findViewById(R.id.ListItems);

	    
	    final ArrayList <String> todoItems = new ArrayList <String>();
	    final ArrayAdapter <String> aa;
	    aa = new ArrayAdapter <String> (this, android.R.layout.simple_list_item_1, todoItems);
	    
	    ListOfToDos.setAdapter(aa);
	    OnKeyListener listener = new OnKeyListener(){
	    	
	        public boolean onKey (View v, int keyCode, KeyEvent event){
	            if(keyCode == KeyEvent.KEYCODE_DPAD_CENTER && event.getAction()!=KeyEvent.ACTION_DOWN){
	                todoItems.add(0, AddedText.getText().toString());
	                AddedText.findFocus();
	                AddedText.setText("");
	                aa.notifyDataSetChanged();
	                return true;
	            }
	            
	            else return false;
	    	}
	    };
	}
}
 
