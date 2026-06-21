package generics_reminder;


public class Cell<E> {
	private E item;
	
	public Cell() {
		this.item = null;
	}
	
	public E getItem() {
		return this.item;
	}
	
	public void setItem(E item) {
		this.item = item;
	}
}

