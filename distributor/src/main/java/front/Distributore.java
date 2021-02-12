package front;

import obj.ItemManager;

public class Distributore {

	ItemManager items;

	public Distributore(ItemManager items) {
		super();
		this.items = items;
	}
	
	public Distributore() {
		items = new ItemManager();
	}

	public ItemManager getItems() {
		return items;
	}

	public void setItems(ItemManager items) {
		this.items = items;
	}
	
	
	
}
