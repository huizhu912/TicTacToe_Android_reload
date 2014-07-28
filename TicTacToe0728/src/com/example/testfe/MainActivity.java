package com.example.testfe;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {
	int id;
	Map<Integer, Integer> map; // hashmap of button IDs and indices
	int p2BtId;
	Map<String, Integer> individualSetState;
	Map<Integer, String> testMap = new HashMap<Integer, String>();
	Winset w;
	List<Map<Integer, String>> winSet;
	List<Map<String, Integer>> gameState;
	int turn = 1;
	
	
	protected Map<Integer, String> set0;
	protected Map<Integer, String> set1;
	protected Map<Integer, String> set2;
	protected Map<Integer, String> set3;
	protected Map<Integer, String> set4;
	protected Map<Integer, String> set5;
	protected Map<Integer, String> set6;
	protected Map<Integer, String> set7;
	protected Map<Integer, String> set8;
	
	
	TextView tv;
	TextView tv2;
	ImageView iv;
	Button button0;
	Button button1;
	Button button2;
	Button button3;
	Button button4;
	Button button5;
	Button button6;
	Button button7;
	Button button8;
	Button btRestart;
	
	int[] btIdList = {R.id.button1, R.id.button2, R.id.button3, R.id.button4, R.id.button5, R.id.button6, R.id.button7, R.id.button8, R.id.button9};


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d("Hui", "run onCreate()");
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	
		
		if (savedInstanceState != null){
			testMap = (Map<Integer, String>) savedInstanceState.getSerializable("hashMap");
			
			for (int key : testMap.keySet()){
				Button bt = (Button)findViewById(key);
				bt.setText(testMap.get(key));
			}
			
//			for (String key : savedInstanceState.keySet()){
//				try {
					//testMap.put(Integer.parseInt(key), savedInstanceState.getString(key));
					//Button bt = (Button) findViewById(Integer.valueOf(key));
					//bt.setText(savedInstanceState.getString(key));	
					
					
					///if (key.matches("position(.*)")){
					///	Button bt = (Button)findViewById(Integer.valueOf(key.replace("position", "")));
					///	bt.setText(savedInstanceState.getString(key));
					///}
					
					
					
//				} catch(NumberFormatException e) {
//					Log.d("Alec", "Not a valid number: " + key);
//				}				
//			}			
		}
		
				
		button0 = (Button)findViewById(R.id.button1);
		button1 = (Button)findViewById(R.id.button2);
		button2 = (Button)findViewById(R.id.button3);
		button3 = (Button)findViewById(R.id.button4);
		button4 = (Button)findViewById(R.id.button5);
		button5 = (Button)findViewById(R.id.button6);
		button6 = (Button)findViewById(R.id.button7);
		button7 = (Button)findViewById(R.id.button8);
		button8 = (Button)findViewById(R.id.button9);
		
		btRestart = (Button)findViewById(R.id.button10);
		btRestart.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				Bundle savedInstanceState = new Bundle();
				savedInstanceState = null;
				createGame(savedInstanceState);
				
			}
			
			
		});
		
		testMap.put(R.id.button1, button0.getText().toString());
		testMap.put(R.id.button2, button1.getText().toString());
		testMap.put(R.id.button3, button2.getText().toString());
		testMap.put(R.id.button4, button3.getText().toString());
		testMap.put(R.id.button5, button4.getText().toString());
		testMap.put(R.id.button6, button5.getText().toString());
		testMap.put(R.id.button7, button6.getText().toString());
		testMap.put(R.id.button8, button7.getText().toString());
		testMap.put(R.id.button9, button8.getText().toString());
		
		setListener(button0);
		setListener(button1);
		setListener(button2);
		setListener(button3);
		setListener(button4);
		setListener(button5);
		setListener(button6);
		setListener(button7);
		setListener(button8);
		
		set0 = new HashMap<Integer, String>();
		set0.put(R.id.button1, Constant.DASH);
		set0.put(R.id.button2, Constant.DASH);
		set0.put(R.id.button3, Constant.DASH);
		
		set1 = new HashMap<Integer, String>();
		set1.put(R.id.button4, Constant.DASH);
		set1.put(R.id.button5, Constant.DASH);
		set1.put(R.id.button6, Constant.DASH);
		
		set2 = new HashMap<Integer, String>();
		set2.put(R.id.button7, Constant.DASH);
		set2.put(R.id.button8, Constant.DASH);
		set2.put(R.id.button9, Constant.DASH);
		
		set3 = new HashMap<Integer, String>();
		set3.put(R.id.button1, Constant.DASH);
		set3.put(R.id.button4, Constant.DASH);
		set3.put(R.id.button7, Constant.DASH);
		
		set4 = new HashMap<Integer, String>();
		set4.put(R.id.button2, Constant.DASH);
		set4.put(R.id.button5, Constant.DASH);
		set4.put(R.id.button8, Constant.DASH);
		
		set5 = new HashMap<Integer, String>();
		set5.put(R.id.button3, Constant.DASH);
		set5.put(R.id.button6, Constant.DASH);
		set5.put(R.id.button9, Constant.DASH);
		
		set6 = new HashMap<Integer, String>();
		set6.put(R.id.button1, Constant.DASH);
		set6.put(R.id.button5, Constant.DASH);
		set6.put(R.id.button9, Constant.DASH);
		
		set7 = new HashMap<Integer, String>();
		set7.put(R.id.button3, Constant.DASH);
		set7.put(R.id.button5, Constant.DASH);
		set7.put(R.id.button7, Constant.DASH);
		
		
		winSet = new ArrayList<Map<Integer, String>>();
		winSet.add(set0);
		winSet.add(set1);
		winSet.add(set2);
		winSet.add(set3);
		winSet.add(set4);
		winSet.add(set5);
		winSet.add(set6);
		winSet.add(set7);
		
		w = new Winset();
		gameState = new ArrayList<Map<String, Integer>>();
		
	}


	
	protected void printMessage(String msg){
		tv = (TextView)findViewById(R.id.textView1);
		tv.setText(msg);
		tv.setTextColor(getResources().getColor(R.color.textColor));
	}
	
	
	protected void uploadImage(int imgId){
		iv = (ImageView)findViewById(R.id.imageView1);
		iv.setImageResource(imgId);
	}
	
	protected String getWinSetString(List<Map<Integer, String>> winset){
		String s = "";
		
		for (Map<Integer, String> map: winset){
			for(int key: map.keySet()){
				s = s + key + " => " + map.get(key) + "; ";
			}
			s = s + " | ";
		}
		
		return s;
	}
	
	protected String getTestMapString(Map<Integer, String> testmap){
		String s = "";
		for(int key: testmap.keySet()){
			s = s + key + " => " + testmap.get(key) + "; ";
		}

		return s;
	}
	
	protected String getGameStateString(List<Map<String, Integer>> gamestate){
		String s = "";
		
		for (Map<String, Integer> map: gamestate){
				s = s + "nCross" + ": " + map.get("nCross") + "; " + "nCircle" + ": " + map.get("nCircle") + "; ";
		}
		
		return s;
	}
	
	
	
	protected void disableButtons(int[] btIdList){
		Button bt;
		for (int btId : btIdList){
			bt = (Button)findViewById(btId);
			bt.setEnabled(false);
		}
	}
	
	
	public void onSaveInstanceState(Bundle savedInstanceState){
		Button bt;
	
		for (int key : btIdList) {
			bt = (Button)findViewById(key);
			//savedInstanceState.putString(String.valueOf(key), bt.getText().toString());
			
			///savedInstanceState.putString(String.format("position%s", String.valueOf(key)), bt.getText().toString());
			
			savedInstanceState.putSerializable("hashMap", (Serializable) testMap);
		}
		
		super.onSaveInstanceState(savedInstanceState);

	}
	
	
	protected void createGame (Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
			
			if (savedInstanceState != null){
				testMap = (Map<Integer, String>) savedInstanceState.getSerializable("hashMap");
				
				for (int key : testMap.keySet()){
					Button bt = (Button)findViewById(key);
					bt.setText(testMap.get(key));
				}
			}
			
			for (int key : testMap.keySet()){
				 Button bt = (Button)findViewById(key);
				 bt.setText(Constant.DASH);
			}		
			
			
			button0 = (Button)findViewById(R.id.button1);
			button1 = (Button)findViewById(R.id.button2);
			button2 = (Button)findViewById(R.id.button3);
			button3 = (Button)findViewById(R.id.button4);
			button4 = (Button)findViewById(R.id.button5);
			button5 = (Button)findViewById(R.id.button6);
			button6 = (Button)findViewById(R.id.button7);
			button7 = (Button)findViewById(R.id.button8);
			button8 = (Button)findViewById(R.id.button9);
			
			btRestart = (Button)findViewById(R.id.button10);
			btRestart.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View arg0) {
					Bundle savedInstanceState = new Bundle();
					savedInstanceState = null;
					createGame(savedInstanceState);
					
				}
				
				
			});
			
			testMap.put(R.id.button1, button0.getText().toString());
			testMap.put(R.id.button2, button1.getText().toString());
			testMap.put(R.id.button3, button2.getText().toString());
			testMap.put(R.id.button4, button3.getText().toString());
			testMap.put(R.id.button5, button4.getText().toString());
			testMap.put(R.id.button6, button5.getText().toString());
			testMap.put(R.id.button7, button6.getText().toString());
			testMap.put(R.id.button8, button7.getText().toString());
			testMap.put(R.id.button9, button8.getText().toString());
			
			setListener(button0);
			setListener(button1);
			setListener(button2);
			setListener(button3);
			setListener(button4);
			setListener(button5);
			setListener(button6);
			setListener(button7);
			setListener(button8);
			
			set0 = new HashMap<Integer, String>();
			set0.put(R.id.button1, Constant.DASH);
			set0.put(R.id.button2, Constant.DASH);
			set0.put(R.id.button3, Constant.DASH);
			
			set1 = new HashMap<Integer, String>();
			set1.put(R.id.button4, Constant.DASH);
			set1.put(R.id.button5, Constant.DASH);
			set1.put(R.id.button6, Constant.DASH);
			
			set2 = new HashMap<Integer, String>();
			set2.put(R.id.button7, Constant.DASH);
			set2.put(R.id.button8, Constant.DASH);
			set2.put(R.id.button9, Constant.DASH);
			
			set3 = new HashMap<Integer, String>();
			set3.put(R.id.button1, Constant.DASH);
			set3.put(R.id.button4, Constant.DASH);
			set3.put(R.id.button7, Constant.DASH);
			
			set4 = new HashMap<Integer, String>();
			set4.put(R.id.button2, Constant.DASH);
			set4.put(R.id.button5, Constant.DASH);
			set4.put(R.id.button8, Constant.DASH);
			
			set5 = new HashMap<Integer, String>();
			set5.put(R.id.button3, Constant.DASH);
			set5.put(R.id.button6, Constant.DASH);
			set5.put(R.id.button9, Constant.DASH);
			
			set6 = new HashMap<Integer, String>();
			set6.put(R.id.button1, Constant.DASH);
			set6.put(R.id.button5, Constant.DASH);
			set6.put(R.id.button9, Constant.DASH);
			
			set7 = new HashMap<Integer, String>();
			set7.put(R.id.button3, Constant.DASH);
			set7.put(R.id.button5, Constant.DASH);
			set7.put(R.id.button7, Constant.DASH);
			
			
			winSet = new ArrayList<Map<Integer, String>>();
			winSet.add(set0);
			winSet.add(set1);
			winSet.add(set2);
			winSet.add(set3);
			winSet.add(set4);
			winSet.add(set5);
			winSet.add(set6);
			winSet.add(set7);
			
			w = new Winset();
			gameState = new ArrayList<Map<String, Integer>>();
		  
	}
	
	
	protected void setListener(Button bt){
			
		bt.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				
				Button bt2;
				id = v.getId(); 
				if ((((Button)v).getText().toString()).equals(Constant.DASH)){
					((Button)v).setText(Constant.CROSS);
				}
				//p1Placement = getIndex(id, map);
				//printMessage("Button " + id + " is clicked");
				
				/// check state of game 
				/// if human player doesn't win 
				/// then it's machine player's turn to play
				
				testMap.put(id, Constant.CROSS);
				tv2 = (TextView)findViewById(R.id.textView2);
				tv2.setText(getTestMapString(testMap));
				
				
//				w.updateTestMap(testMap);
				w.updateWinSet(winSet, testMap);
				//printMessage(getWinSetString(winSet));
				w.updateState(winSet, gameState);
				
				printMessage(String.valueOf(w.checkState(gameState, turn)));
				
				
				if (w.checkState(gameState, turn) == 1) {
					printMessage("You win!");
					uploadImage(R.drawable.win_smiley);
					disableButtons(btIdList);
				}
				else if ((w.checkState(gameState, turn) == 2)){
					printMessage("You lost!");
					uploadImage(R.drawable.devil_smiley);
					disableButtons(btIdList);
				}
				else if (turn == 1) {
					p2BtId = w.getBtIdForCircle(gameState, turn, testMap, winSet);
					printMessage("p2BtId: " + p2BtId);
					
					if (p2BtId == -2){
						printMessage("Stalemate Game Over!");
						disableButtons(btIdList);
					}
					else {
						bt2 = (Button)findViewById(p2BtId);
						bt2.setText(Constant.CIRCLE);
						testMap.put(p2BtId, Constant.CIRCLE);
						
						tv2.setText(getTestMapString(testMap));
						
//						w.updateTestMap(testMap);
						w.updateWinSet(winSet, testMap);
						w.updateState(winSet, gameState);		
						if (w.checkState(gameState, turn) == 1) {
							printMessage("You win");
							uploadImage(R.drawable.win_smiley);
							disableButtons(btIdList);
						}
						else if ((w.checkState(gameState, turn) == 2)){
							printMessage("You lost!");
							uploadImage(R.drawable.devil_smiley);
							disableButtons(btIdList);
						}
						else {
							turn = 1;
						}
					}	
				}
				
			}
		});
	}
	

	
}
