package generics_reminder;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestCellApp {
	@Test
	public void test() {
		CellApp app = new CellApp();
		Cell<Integer> input = new Cell<>();
		input.setItem(2022);
		Cell<String> output = app.transformed(input);
		assertEquals("Transformed from: 2022", output.getItem());
	}
}

