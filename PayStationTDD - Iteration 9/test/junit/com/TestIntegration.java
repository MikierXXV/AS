package junit.com;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TestIntegration {
	
	
	private PayStation  NY;
	private PayStation BOS;
	
	@Before
	  public void setUp() {
	    NY = new PayStationImpl(new LinearRateStrategy());
	    BOS = new PayStationImpl(new ProgressiveRateStrategy());
	  }
	
	/**
	   * Entering 5 cents should make the display report 2 minutes 
	   * parking time.
	  */
	  @Test
	  public void shouldDisplay2MinFor5CentsNY() throws IllegalCoinException {
	    NY.addPayment( 5 );
	    assertEquals( "Should display 2 min for 5 cents", 
	                  5/5*2 , NY.readDisplay() ); 
	  }
	  
	  /**
	   * Entering 5 cents should make the display report 2 minutes 
	   * parking time.
	  */
	  @Test
	  public void shouldDisplay2MinFor5CentsBOS() throws IllegalCoinException {
	    BOS.addPayment( 5 );
	    assertEquals( "Should display 2 min for 5 cents", 
	                  5/5*2 , BOS.readDisplay() ); 
	  }


	  /**
	   * Entering 25 cents should make the display report 10 minutes
	   * parking time.
	  */
	  @Test
	  public void shouldDisplay10MinFor25CentsNY() throws IllegalCoinException {
	    NY.addPayment( 25 );
	    assertEquals( "Should display 10 min for 25 cents", 
	                  25/5*2, NY.readDisplay() );
	    // 25 cent in 5 cent coins each giving 2 minutes parking
	  }

	  /**
	   * Entering 25 cents should make the display report 10 minutes
	   * parking time.
	  */
	  @Test
	  public void shouldDisplay10MinFor25CentsBOS() throws IllegalCoinException {
	    BOS.addPayment( 25 );
	    assertEquals( "Should display 10 min for 25 cents", 
	                  25/5*2, BOS.readDisplay() );
	    // 25 cent in 5 cent coins each giving 2 minutes parking
	  }
	  
	  /** 
	   * Verify that illegal coin values are rejected.
	  */
	  @Test(expected=IllegalCoinException.class)
	  public void shouldRejectIllegalCoinNY() throws IllegalCoinException {
	    NY.addPayment(17);
	  }
	  
	  /** 
	   * Verify that illegal coin values are rejected.
	  */
	  @Test(expected=IllegalCoinException.class)
	  public void shouldRejectIllegalCoinBOS() throws IllegalCoinException {
	    BOS.addPayment(17);
	  }

	  /**
	   * Entering 10 and 25 cents should be valid and 
	   * return 14 minutes parking 
	  */
	  @Test
	  public void shouldDisplay14MinFor10And25CentsNY()
	          throws IllegalCoinException {
	    NY.addPayment( 10 );
	    NY.addPayment( 25 );
	    assertEquals( "Should display 14 min for 10+25 cents",
	                  35/5*2, NY.readDisplay() );
	  }
	  /**
	   * Entering 10 and 25 cents should be valid and 
	   * return 14 minutes parking 
	  */
	  @Test
	  public void shouldDisplay14MinFor10And25CentsBOS()
	          throws IllegalCoinException {
	    BOS.addPayment( 10 );
	    BOS.addPayment( 25 );
	    assertEquals( "Should display 14 min for 10+25 cents",
	                  35/5*2, BOS.readDisplay() );
	  }


}
