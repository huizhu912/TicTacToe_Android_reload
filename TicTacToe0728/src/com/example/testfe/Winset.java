package com.example.testfe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import android.app.Activity;
import android.widget.Button;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;

public class Winset extends MainActivity{
	protected List<Map<Integer, String>> winSet; // hashmap of button IDs and values
	protected List<Map<String, Integer>> gameState = new ArrayList<Map<String, Integer>>();
	int rid;

	//protected Map<Integer, String> testMap =  new MainActivity().testMap;
//	protected Map<Integer, String> set0;
//	protected Map<Integer, String> set1;
//	protected Map<Integer, String> set2;
//	protected Map<Integer, String> set3;
//	protected Map<Integer, String> set4;
//	protected Map<Integer, String> set5;
//	protected Map<Integer, String> set6;
//	protected Map<Integer, String> set7;
//	protected Map<Integer, String> set8;
	protected Map<String, Integer> individualSetState;
	//protected MainActivity ma = new MainActivity();
	
	//int[] btIdList = {R.id.button1, R.id.button2, R.id.button3, R.id.button4, R.id.button5, R.id.button6, R.id.button7, R.id.button8, R.id.button9};
	

	public Winset() {
//		Log.d("Hui", "run Winset()");
//		
//		set0 = new HashMap<Integer, String>();
//		set0.put(R.id.button1, Constant.DASH);
//		set0.put(R.id.button2, Constant.DASH);
//		set0.put(R.id.button3, Constant.DASH);
//		
//		set1 = new HashMap<Integer, String>();
//		set1.put(R.id.button4, Constant.DASH);
//		set1.put(R.id.button5, Constant.DASH);
//		set1.put(R.id.button6, Constant.DASH);
//		
//		set2 = new HashMap<Integer, String>();
//		set2.put(R.id.button7, Constant.DASH);
//		set2.put(R.id.button8, Constant.DASH);
//		set2.put(R.id.button9, Constant.DASH);
//		
//		set3 = new HashMap<Integer, String>();
//		set3.put(R.id.button1, Constant.DASH);
//		set3.put(R.id.button4, Constant.DASH);
//		set3.put(R.id.button7, Constant.DASH);
//		
//		set4 = new HashMap<Integer, String>();
//		set4.put(R.id.button2, Constant.DASH);
//		set4.put(R.id.button5, Constant.DASH);
//		set4.put(R.id.button8, Constant.DASH);
//		
//		set5 = new HashMap<Integer, String>();
//		set5.put(R.id.button3, Constant.DASH);
//		set5.put(R.id.button6, Constant.DASH);
//		set5.put(R.id.button9, Constant.DASH);
//		
//		set6 = new HashMap<Integer, String>();
//		set6.put(R.id.button1, Constant.DASH);
//		set6.put(R.id.button5, Constant.DASH);
//		set6.put(R.id.button9, Constant.DASH);
//		
//		set7 = new HashMap<Integer, String>();
//		set7.put(R.id.button3, Constant.DASH);
//		set7.put(R.id.button5, Constant.DASH);
//		set7.put(R.id.button7, Constant.DASH);
//		
//		winSet = new ArrayList<Map<Integer, String>>();
//		winSet.add(set0);
//		winSet.add(set1);
//		winSet.add(set2);
//		winSet.add(set3);
//		winSet.add(set4);
//		winSet.add(set5);
//		winSet.add(set6);
//		winSet.add(set7);
		
//		individualSetState = new HashMap<String, Integer>();
//		individualSetState.put("nCross", 0);
//		individualSetState.put("nCircle", 0);
		
		
//		for (int i = 0; i < 8; i++){
//			gameState.add(individualSetState);
//		}
		

	}
	
	protected List<Map<Integer, String>> getWinSet(){
		List<Map<Integer, String>> winset = new ArrayList<Map<Integer, String>>();
		winSet.add(set0);
		winSet.add(set1);
		winSet.add(set2);
		winSet.add(set3);
		winSet.add(set4);
		winSet.add(set5);
		winSet.add(set6);
		winSet.add(set7);
		return winset;
	}
	
	
	
	//update the testMap key-value pairs every time when a button's value is updated 
	protected void updateTestMap(Map<Integer, String> testmap) {
		Log.d("Hui", "run updateTestMap()");
		
		Button bt;
		for (int key : testmap.keySet()){
			bt = (Button)findViewById(key);
			testmap.put(key, bt.getText().toString());
		}
	}
	
	
	//update the winset key-value pairs every time when a button's value is updated 
	protected void updateWinSet(List<Map<Integer, String>> winset, Map<Integer, String> testmap){
		//Button bt;
		Log.d("Hui", "run updateWinSet()");
		for ( Map<Integer,String> map : winset) {
				for (int key : map.keySet()) {
					//bt = (Button) findViewById(key);
					//map.put(key, bt.getText().toString());
					map.put(key, testmap.get(key));
					Log.d("Hui", "key: " + key + "; " + "value: " + map.get(key));
				}
		}
	}
	
	//update the state for winset with nCross and nCircle key-value pairs
	protected void updateState(List<Map<Integer, String>> winset, List<Map<String, Integer>> gamestate){
		Log.d("Hui", "run updateState()");
		
		int nCross = 0;
		int nCircle = 0;
		gamestate.clear();

		//boolean haveDash = false; 
		
		for (Map<Integer, String> map : winset){
			for (int key : map.keySet()){
				if (map.get(key).equals(Constant.CROSS)){
					nCross++;
				}
				else if (map.get(key).equals(Constant.CIRCLE)){
					nCircle++;
				}
				
			}
			
			individualSetState = new HashMap<String, Integer>();	
			individualSetState.put("nCross", nCross);
			individualSetState.put("nCircle", nCircle);
			Log.d("Hui", "indiv nCross = " + individualSetState.get("nCross") + "; " + "indiv nCircle = " + individualSetState.get("nCircle"));
			gamestate.add(individualSetState);

			nCross = 0;
			nCircle = 0;
			
		}	
		
//		for (Map<String, Integer> map: gameState) {
//			System.out.println("nCross = " + map.get("nCross") + "; "+ "nCircle = " + map.get("nCircle"));
//		}
		
	}
	
	
	protected int checkState(List<Map<String, Integer>> gamestate, int turn){
		Log.d("Hui","checkState()");
		
		boolean flag = false;
		int state = -1;
		
		for (Map<String, Integer> indivMap : gamestate){	
			if ((indivMap.get("nCross") == 3) && (indivMap.get("nCircle") == 0)){
				//printMessage("You win");
				flag = true;
				state = 1;
				break;
			}
			else if ((indivMap.get("nCross") == 0) && (indivMap.get("nCircle") == 3)) {
				//printMessage("You lost");
				flag = true;
				state = 2;
				break;
			}			
		}
		
		if ((turn == 1) && (flag == false)) {
			//turn = 2;
			//printMessage("Get button Id for Circle");
		}
		else if ((turn == 2) && (flag == false)) {
			//turn = 1;
			//printMessage("It's your turn to play");
		}
		return state;
	}	
	
	
	protected int getBtIdForCircle(List<Map<String, Integer>> gamestate, int turn, Map<Integer, String> testmap, List<Map<Integer, String>> winset) {
		Map<String, Integer> map;
		int priorityBtId = -1;
		
		if (turn == 1) {
			turn = 2;
			
			for(int i = 0; i < gamestate.size(); i++){
				map = gamestate.get(i);
				//System.out.println("position = " + i + "; " + "nCross = " + map.get("nCross") + "; "+ "nCircle = " + map.get("nCircle"));
			
				if ((map.get("nCross") == 0) && (map.get("nCircle") == 2)) {
					Log.d("Hui","run getBtIdFromWinSet() for win");
					priorityBtId = getBtIdFromWinSet(winset, i); //for win	
					break;
				}
			}
			
			if ((turn == 2) && (priorityBtId == -1)){	
				for(int i = 0; i < gamestate.size(); i++){
					map = gamestate.get(i);
					Log.d("Hui","position = " + i + "; " + "nCross = " + map.get("nCross") + "; "+ "nCircle = " + map.get("nCircle"));
				
					if ((map.get("nCross") == 2) && (map.get("nCircle") == 0)){
						Log.d("Hui","run getBtIdFromWinSet() for block");
						priorityBtId = getBtIdFromWinSet(winset, i); //for block
						break;
					}
					//turn = 1;
							
				}
			}
			
			if ((turn == 2) && (priorityBtId == -1)) {
					Log.d("Hui","run getRandomBtId()");
					priorityBtId = getRandomBtId(btIdList, testmap); //for fill the placement				
					//turn = 1;
			}
		
			Log.d("Hui","Button ID for Circle: " + priorityBtId);
		}
		return priorityBtId;
	}
	
	
	protected int getBtIdFromWinSet(List<Map<Integer, String>> winset, int p){
		int priorityBtId = -1;
		Map<Integer, String> map = winset.get(p);
		
		for (int key : map.keySet()){
			if (map.get(key).equals(Constant.DASH)){
				priorityBtId = key;
				break;
			}	
		}
			
		return priorityBtId;
	}
	
	
	protected int getRandomBtId(int[] btIdList, Map<Integer, String> testmap){
		int randomId = -2;
		boolean availableBt = false;
		
		
		for (int key : testmap.keySet()){
			if (testmap.get(key).equals(Constant.DASH)) {
				availableBt = true;
			}
		}
		
		if (availableBt == true){
			randomId = btIdList[new Random().nextInt(btIdList.length)];
			
			//testmap.get(randomId)
			if (!(testmap.get(randomId).equals(Constant.DASH))){
				getRandomBtId(btIdList, testmap);
			}	
			else {
				rid = randomId;
			}
		}
		else {
			rid = randomId;
		}
		Log.d("Hui", "randomId = " + randomId);
		return rid;
		
	}
	
	
	
//	updateWinSet(winSet, testMap);
//	if (checkState(winSet) == true) {		
//			System.exit();
//	}

}
			
	
