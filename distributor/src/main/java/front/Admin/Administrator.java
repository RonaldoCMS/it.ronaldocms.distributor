package front.Admin;

import front.Distributore;
import front.Input.SimpleIO;
import obj.Item;

public class Administrator {
	
	private Distributore distributore;
	private SimpleIO input = SimpleIO.getInstance();
	private int scelta = 1;
	
	public Administrator(Distributore distributore) {
		this.distributore = distributore;
		
	}
	
	public void adminDarshboard() {
		System.out.println("1. Modifica quantità oggetto");
		System.out.println("2. Modifica nome oggetto");
		System.out.println("3. Modifica codice oggetto");
		System.out.println("4. Modifica costo oggetto");
		System.out.println("5. Aggiungi nuovo oggetto");
		System.out.println("6. Elimina oggetto presente");
		System.out.println("0. Exit");
		adminSwitch();
	}
	
	private void adminSwitch() {
		while(scelta != 0) {
			scelta = input.nextInt();
			switch(scelta) {
				case 1: modQty(); break;
				case 2: modNome(); break;
				case 3: modCode(); break;
				case 4: modMoney(); break;
				case 5: addItem(); break;
				case 6: delItem(); break;
				case 0: return;
				default: 
					System.out.println("Errore, valore non valido");
					adminDarshboard();
					break;
			}
		}
		distributore.getItems().saveItems();
	}
	
	private void addItem() {
		System.out.println("Inserisci codice:\t");
		int codice = input.nextInt();
		
		for (Item e : distributore.getItems().getItems()) {
			if(e.getCodice() == codice) {
				System.out.println("Impossibile proseguire, codice già esistente.");
				return;
			}
		}
		System.out.println("Inserisci nome:\t");
		String nome = input.next();
		
		System.out.println("Inserisci prezzo:\t");
		double prezzo = input.nextDouble();
		
		System.out.println("Inserisci quantità");
		int qty = input.nextInt();
		
		distributore.getItems().getItems().add(new Item(codice, nome, prezzo, qty));
		distributore.getItems().saveItems();
	}

	private void delItem() {
		System.out.println("Inserisci codice:\t");
		int codice = input.nextInt();
		
		for (Item e : distributore.getItems().getItems()) {
			if(e.getCodice() == codice) {
				distributore.getItems().getItems().remove(e);
				System.out.println("Oggetto eliminato");
				distributore.getItems().saveItems();
				return;
			}
		}
		System.out.println("Oggetto non trovato.");
		
	}

	private void modMoney() {
		
		
	}

	private void modCode() {
		int codice = getMessageCode();
		System.out.println("Inserisci nuovo codice:\t");
		int newCodice = input.nextInt();
		
		for (Item e : distributore.getItems().getItems()) {
			if(e.getCodice() == newCodice) {
				System.out.println("Codice già esistente.");
				return;
			}
		}
		
		distributore.getItems().getItem(i -> i.getCodice() == codice).setCodice(newCodice);
		distributore.getItems().saveItems();
		
//		for (Item e : distributore.getItems().getItems()) {
//			if(e.getCodice() == newCodice) {
//				System.out.println("Codice già esistente.");
//				return;
//			}
//		}
//		distributore.getItems().getItems().get(getIndex(codice)).setCodice(newCodice);
		
	}

	private void modNome() {
		int codice = getMessageCode();
		
		System.out.println("Inserisci nuovo nome:\t");
		String nome = input.next();
		
		//distributore.getItems().getItems().get(getIndex(codice)).setNome(nome);
		distributore.getItems().getItem(i -> i.getCodice() == codice).setNome(nome);
		distributore.getItems().saveItems();
		
	}

	private void modQty() {
		int codice = getMessageCode();

		
		System.out.println("Inserisci nuova quantità:\t");
		int qty = input.nextInt();
		
		//distributore.getItems().getItems().get(getIndex(codice)).setQty(qty);
		
		distributore.getItems().getItem(i -> i.getCodice() == codice).setQty(qty);
		distributore.getItems().saveItems();
		
	}

	private int getMessageCode() {
		System.out.println("Inserisci codice oggetto:\t");
		int codice = input.nextInt();
		
		if(codice < 0) {
			System.out.println("Impossibile inserire numero negativo.");
			codice = distributore.getItems().getItems().size() + 1;
			System.out.println("Codice nuovo : " + codice);
		}
		
		return codice;
	}

	private Item searchObj(int code) {
		int i = 0;
		for(Item e : distributore.getItems().getItems()) {
			if(e.getCodice() == code) {
				return e;
			}
		}
		return null;
	}

	private int getIndex(int code) {
		int i = 0;
		for(Item e : distributore.getItems().getItems()) {
			if(e.getCodice() == code) {
				return i;
			}
		}
		System.out.println("Oggetto non trovato");
		return 10000;
	}
}
