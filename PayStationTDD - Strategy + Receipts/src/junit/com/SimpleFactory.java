package junit.com;

public class SimpleFactory implements PayStationFactory {

	@Override
	public Receipt creaRebut(int n) {
		return new StandardReceipt(n); 	

	}

	@Override
	public RateStrategy creaStrategy() {
		return new One2OneRateStrategy();

	}

	
}
