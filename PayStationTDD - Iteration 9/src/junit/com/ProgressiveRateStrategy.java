package junit.com;

public class ProgressiveRateStrategy implements RateStrategy {

	@Override
	public int calculaTime(int insertedSoFar) {
		// TODO Auto-generated method stub
		//60*5/2
		if (insertedSoFar <= 150) return insertedSoFar/5*2;
		//60 una hora, 200 + 150 -> cuota 10*3
		else if (insertedSoFar <= 350) return 60 + (insertedSoFar - 150)/10*3;
		//120 dues hores, cuota -> 5*1
		else return 120 + (insertedSoFar - 350)/5*1;
	}

}
