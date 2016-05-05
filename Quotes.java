package com.uptodate;

import java.util.ArrayList;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class Quotes{
	private ResourceBundle quotesBundle=null;
	//Load in quotes in constructor
	Quotes(String ResourceName){
		try{
			quotesBundle = ResourceBundle.getBundle(ResourceName);
		}catch(MissingResourceException me){
			System.out.println("Please place quotes.properties under classpath.");
		}catch(NullPointerException ne){
			System.out.println("Check if the base name is null");
		}
	}
	Quotes(){
		System.out.println("Please indicate the name of resource bundle, we load in quotes.properties by default.");
		try{
			quotesBundle = ResourceBundle.getBundle("quotes");
		}catch(MissingResourceException me){
			System.out.println("Please place quotes.properties under classpath.");
		}catch(NullPointerException ne){
			System.out.println("Check if the base name is null");
		}
	}
	//input: search terms
	//output: each unit in the ArrayList is combine of quote number(key) and matched word
	public ArrayList<String> Search(ArrayList<String> sts){
		ArrayList<String> result=new ArrayList<String>();
		try{
			for(int i=0;i<100;i++){
				for(String j:sts){
					if(quotesBundle.getString("quote."+Integer.toString(i+1)).contains(j)){
						result.add("quote."+Integer.toString(i+1)+" "+j);
					}
				}
			}
		}catch(MissingResourceException me){
			System.out.println("Check if quotes.properties is updeted, the default number of quotes are 100");
		}
		return result;
	}
	
	public void PrintSolution(ArrayList<String> outputs){
		for(String output:outputs){
			System.out.println(output);
		}
		if(outputs.size()==0) System.out.println("There is no such search term found in quotes");
	}
}
