package junit.com;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TestProgressiveRate {
	  RateStrategy r;
	  /** Fixture for pay station testing. */
	  @Before
	  public void setUp() {
	    r = new ProgressiveRateStrategy();
	  
	  }
	  
	  /**
	   * Entering 5 cents should make the display report 2 minutes 
	   * parking time.
	  */
	  @Test
	  public void shouldDisplay2MinFor5Cents() throws IllegalCoinException {
	    //ps.addPayment( 5 );
	    assertEquals( "Should display 2 min for 5 cents", 
	                  5 / 5 * 2, r.calculaTime(5) ); 
	  }
	  
	  @Test
	  public void shouldDisplay63MinFor160Cents() throws IllegalCoinException {
		//for(int i = 0; i < 6; i++) ps.addPayment( 25 );
		//ps.addPayment( 10 );
	    assertEquals( "Should display 63 min for 160 cents", 
	                  150/5*2 + 10/10*3, r.calculaTime(160)); 
	  }
	  
	  @Test
	  public void shouldDisplay121MinFor3555Cents() throws IllegalCoinException {
		//for(int i = 0; i < 14; i++) ps.addPayment( 25 );
		//ps.addPayment( 5 );
	    assertEquals( "Should display 63 min for 160 cents", 
	                  150/5*2 + 200/10*3 + 5/5*1, r.calculaTime(355)); 
	  }
	  
}
