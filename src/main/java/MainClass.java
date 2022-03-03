import front.Distributore;
import front.Admin.Administrator;
import front.Input.SimpleIO;
import obj.Item;

public class MainClass {

	private Distributore distributore;
	private Administrator admin;
	private SimpleIO input = SimpleIO.getInstance();
	private int value;
	private double soldi;

	private final int code;

	private MainClass() {
		distributore = new Distributore();
		admin = new Administrator(distributore);
		code = 999;
	}

	private void darshboard() {

		System.out.println("Codice\t\tQuantità\t\tNome\t\t\t\tPrezzo");
		for (Item e : distributore.getManager().getItems()) {
			System.out.println(e.toString());
		}

		itemSwitch();
	}
	
	private void itemSwitch() {
		System.out.println("Inserisci codice:\t");
		value = input.nextInt();

		if (value == code) {
			admin.adminDarshboard();
			darshboard();
		} else {

			try {
				
				System.out.println("Inserire denaro:\t");
				soldi = input.nextDouble();

				if (distributore.getManager().getItem(e -> e.getCodice() == value).getQty() <= 0) {
					System.out.println("Prodotto finito. ");
				}

				else {

					if (distributore.getManager().getItem(e -> e.getCodice() == value).getCoins() <= soldi) {
						double resto = soldi - distributore.getManager().getItem(e -> e.getCodice() == value).getCoins();
						distributore.getManager().getItem(e -> e.getCodice() == value).decQty();
						System.out.println("Resto : " + String.format("%.2f", resto) + " €");// Double.toString(resto).format("%d",
																								// args)
					}

					else {
						System.out.println("Soldi insufficienti.");
					}

				}

				Thread.sleep(1000);
			}

			catch (NullPointerException e) {
				System.out.println("Codice non disponibile");
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			} finally {
				clear();
				distributore.getManager().saveItems();
				darshboard();

			}
		}
	}

	private void clear() {
		for (int i = 0; i < 1000; i++) {
			System.out.println();
		}
	}

	public static void main(String[] args) {
		MainClass main = new MainClass();
		main.darshboard();
	}
}
