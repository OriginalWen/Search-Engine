package com.uptodate;

import java.util.ArrayList;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class Synonyms{
	private ResourceBundle synonymsBundle=null;
	//Load in synonyms bundle in constructor and also store the synonyms table for successively used
	Synonyms(String ResourceName){
		try{
			synonymsBundle = ResourceBundle.getBundle(ResourceName);
		}catch(MissingResourceException me){
			System.out.println("Please place synonyms.properties under classpath.");
		}catch(NullPointerException ne){
			System.out.println("Check if the base name is null");
		}
		try{
			StoreSymPairs(synonymsBundle);
		}catch(MissingResourceException me){
			System.out.println("Please check is there any update in synonyms.properties, the default number of synonyms pairs are 26");
		}
	}
	Synonyms(){
		System.out.println("Please indicate the name of resource bundle, we load in synonyms.properties by default.");
		try{
			synonymsBundle = ResourceBundle.getBundle("synonyms");
		}catch(MissingResourceException me){
			System.out.println("Please place synonyms.properties under classpath.");
		}catch(NullPointerException ne){
			System.out.println("Check if the base name is null");
		}
		try{
			StoreSymPairs(synonymsBundle);
		}catch(MissingResourceException me){
			System.out.println("Please check is there any update in synonyms.properties, the default number of synonyms pairs are 26");
		}
	}
	//SynsTable stores the collection of synonyms
	private ArrayList<ArrayList<String>> SynsTable=new ArrayList<ArrayList<String>>();
	public ArrayList<ArrayList<String>> getSynsTable(){
		return SynsTable;
	}
	//SearchTerms stores all the synonyms words.
	//If the search term does not have synonyms, store the term itself only.
	private ArrayList<String> SearchTerms=new ArrayList<String>();
	public ArrayList<String> getSearchTerms(){
		return SearchTerms;
	}
	//Function for loading synonyms bundle into SynsTable
	public void StoreSymPairs(ResourceBundle sb){
		for(int i=0;i<26;i++){
			String[] SymPair=sb.getString("synonym.group."+Integer.toString(i+1)).split(",");
			ArrayList<String> ListSynsPair=new ArrayList<String>();
			for(String j:SymPair){
				ListSynsPair.add(j);
			}
			SynsTable.add(ListSynsPair);
		}
	}
	//index of current synonyms pairs in the table.
	int index;
	//Store synonyms of search term into SearchTerms
	public void SetSearchTerms(String st){
		SearchTerms.clear();
		SearchTerms.add(st);
		for(index=0;index<SynsTable.size();index++){
			if(SynsTable.get(index).contains(st.trim())) {
				SearchTerms.clear();
				SearchTerms.addAll(SynsTable.get(index));
				break;
			}			
		}		
	}
	//Keep most recent searched words in the front to save searching time
	public void MaintainTable(){
		SynsTable.add(0,(ArrayList<String>)SearchTerms.clone());
		if(SynsTable.size()-1!=index) SynsTable.remove(index+1);
	}
}
