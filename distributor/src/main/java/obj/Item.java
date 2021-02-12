package obj;

public class Item {
	private int codice;
	private String nome;
	private double coins;
	private int qty;
	
	public Item(int codice, String nome, double coins, int qty) {
		super();
		this.codice = codice;
		this.nome = nome;
		this.coins = coins;
		this.qty = qty;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getCoins() {
		return coins;
	}

	public void setCoins(double coins) {
		this.coins = coins;
	}

	public int getCodice() {
		return codice;
	}

	public void setCodice(int codice) {
		this.codice = codice;
	}
	
	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}
	
	public void decQty() {
		this.qty--;
	}

	@Override
	public String toString() {
		return codice + "\t\t" + qty + "\t\t\t" + nome + "  \t\t\t" + coins + " €";
	}
	
}
