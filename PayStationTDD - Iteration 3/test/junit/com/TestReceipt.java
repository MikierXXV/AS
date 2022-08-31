package junit.com;

import org.junit.*;
import static org.junit.Assert.*;

public class TestReceipt {
	
	Receipt r;
	
	@Before
	public void setUp() {
		r = new ReceiptImpl();
		
	}
	
	@Test
	public void shoudSaveValue() {
		r.buy(5);
		assertEquals("should return 2 min paytime", r.value(), 2);
	}

}
