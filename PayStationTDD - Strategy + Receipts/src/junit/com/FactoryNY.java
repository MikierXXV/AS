package junit.com;

public class FactoryNY implements PayStationFactory {

	@Override
	public Receipt creaRebut(int n) {
		// TODO Auto-generated method stub
		return new StandardReceipt(n);
	}

	@Override
	public RateStrategy creaStrategy() {
		// TODO Auto-generated method stub
		return new LinearRateStrategy();
	}

}
