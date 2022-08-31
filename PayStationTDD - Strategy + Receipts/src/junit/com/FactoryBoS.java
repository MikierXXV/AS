package junit.com;

public class FactoryBoS implements PayStationFactory {

	@Override
	public Receipt creaRebut(int n) {
		// TODO Auto-generated method stub
		return new BarCodeReceipt(n);
	}

	@Override
	public RateStrategy creaStrategy() {
		// TODO Auto-generated method stub
		return new ProgressiveRateStrategy();
	}

}
