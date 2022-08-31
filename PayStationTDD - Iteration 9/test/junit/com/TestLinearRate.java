package junit.com;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

public class TestLinearRate {
	  RateStrategy r;
	  /** Fixture for pay station testing. */
	  @Before
	  public void setUp() {
	    r = new LinearRateStrategy();
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

	  /**
	   * Entering 25 cents should make the display report 10 minutes
	   * parking time.
	  */
	  @Test
	  public void shouldDisplay10MinFor25Cents() throws IllegalCoinException {
	    //ps.addPayment( 25 );
	    assertEquals( "Should display 10 min for 25 cents", 
	                  25 / 5 * 2, r.calculaTime(25) );
	    // 25 cent in 5 cent coins each giving 2 minutes parking
	  }

	  /**
	   * Entering 10 and 25 cents should be valid and 
	   * return 14 minutes parking 
	  */
	  @Test
	  public void shouldDisplay14MinFor10And25Cents()
	          throws IllegalCoinException {
	    //ps.addPayment( 10 );
	    //ps.addPayment( 25 );
	    assertEquals( "Should display 14 min for 10+25 cents",
	                  (10+25) / 5 * 2, r.calculaTime(35));
	  }


}
