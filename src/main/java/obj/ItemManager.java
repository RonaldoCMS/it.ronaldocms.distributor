package obj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class ItemManager {

	private ArrayList<Item> items;

	private File file;

	public ItemManager(ArrayList<Item> items) {
		super();
		this.items = items;
	}
	
	 public ItemManager() {
		items = new ArrayList<>();
		file = new File("Items.json");
		loadItems();
		System.out.println("Caricamento database... completato!");
		try {
			//Simulo caricamento dati
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	 
	 
	public ArrayList<Item> getItems() {
		return items;
	}

	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}
	
	public Item getItem(Predicate<Item> item) throws NullPointerException {
		for (Item i : items) {
			if(item.test(i)) {
				return i;
			}
		}
		return null;
	}
	
	private void loadItems() {
		
		String str;
		String temp = "";
		
		/*
		 * Prendo informazioni dal file JSON
		 */
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			while((str = br.readLine()) != null) {
				/*Inserisci tutte le informazioni in una variabile di tipo Stringa*/
				temp = temp + str;
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} /* Creo un costruttore che mi permette di creare una lista di oggetti desiderati*/
		java.lang.reflect.Type founderItems = new TypeToken<ArrayList<Item>>() {
			
		}.getType();
		/* Aggiungo tutto dentro alla lista*/
		items = new Gson().fromJson(temp, founderItems);
	}
	
	public void saveItems() {
		
        String temp = new Gson().toJson(items.toArray()); 
        
      try {
    	  /***
    	   * Apro file
    	   * Scrivo file
    	   * Chiudo file
    	   */
			FileWriter fw = new FileWriter(file, false);
			fw.write(temp);
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     
	}
}
