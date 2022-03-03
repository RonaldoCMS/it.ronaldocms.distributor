package front;

import obj.ItemManager;

public class Distributore {

	ItemManager manager;

	public Distributore(ItemManager items) {
		super();
		this.manager = items;
	}
	
	public Distributore() {
		manager = new ItemManager();
	}

	public ItemManager getManager() {
		return manager;
	}

	public void setItems(ItemManager items) {
		this.manager = items;
	}
	
	
	
}
