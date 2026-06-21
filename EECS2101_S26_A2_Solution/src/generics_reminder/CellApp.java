package generics_reminder;

public class CellApp { 
	public Cell<String> transformed(Cell<Integer> input) {
		Cell<String> result = new Cell<String>();
		result.setItem("Transformed from: " + input.getItem());
		return result;
	}
}

