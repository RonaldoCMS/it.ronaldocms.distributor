package front.Input;

import java.io.*;
import java.text.*;

public class SimpleIO {
	
	private static SimpleIO instance = new SimpleIO();
	
  private SimpleIO() {
	  //Potevo anche evitare di creare un costruttore vuoto
  }
  
  public static SimpleIO getInstance() {
	  return instance;
  }
    
  public int nextInt() {
    String testo = new String();
    int val = 0;
    try {
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
      testo = in.readLine();
      val = NumberFormat.getInstance().parse(testo).intValue();  
    }
    catch(ParseException pe) //Errore in caso che l'utente inserisca caratteri non numerici 
    {
      System.out.println("Attenzione errore di conversione numerica");
      val = 0 ;
    }
    catch(IOException e) {
      System.out.println("Attenzione errore nella lettura da tastiera");
      val = 0;
    }
    return val;
  }
  
  public double nextDouble() {
	  String testo = new String();
	  double val = 0;
	    try {
	        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	        testo = in.readLine();
	        if(testo.contains(".")) {
	        	System.err.println("Inserire la virgola, non il punto.\n Riprova grazie.");
	        	try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        }
	        else {
	        	val = NumberFormat.getInstance().parse(testo).doubleValue();
	        }
	        
	      }
	      catch(ParseException pe) {
	        System.out.println("Attenzione errore di conversione numerica");
	        val = 0;
	      }
	      catch(IOException e) {
	        System.out.println("Attenzione errore nella lettura da tastiera");
	        val = 0;
	      }
	    return val;
  }
    
  public String next() {
    InputStreamReader isr;
    BufferedReader tastiera;
    isr = new InputStreamReader(System.in);
    tastiera = new BufferedReader(isr);
    String r=null;
	
    try {
      r = tastiera.readLine();
    }
    catch(java.io.IOException e) {
      System.out.println("Attenzione errore nella lettura da tastiera");
    }
    return r;
  }

}