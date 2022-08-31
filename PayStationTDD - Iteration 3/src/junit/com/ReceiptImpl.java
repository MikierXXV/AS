package junit.com;

public class ReceiptImpl implements Receipt {
	int val;

	@Override
	public int value() {
		// TODO Auto-generated method stub
		return val;
	}
	
	public void buy(int coin) {
		val = coin / 5*2;
	}
	
	public ReceiptImpl() {
		
	}
}
