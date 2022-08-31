package junit.com;

import org.junit.*;
import static org.junit.Assert.*;

/** Test cases for the Pay Station system.
 
   This source code is from the book 
     "Flexible, Reliable Software:
       Using Patterns and Agile Development"
     published 2010 by CRC Press.
   Author: 
     Henrik B Christensen 
     Department of Computer Science
     Aarhus University
   
   Please visit http://www.baerbak.com/ for further information.

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at
 
       http://www.apache.org/licenses/LICENSE-2.0
 
   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.

*/
public class TestPayStation {
  PayStation ps;
  Receipt rec;
  /** Fixture for pay station testing. */
  @Before
  public void setUp() {
    ps = new PayStationImpl();
    rec = new ReceiptImpl();
  }
  
  
  @Test 
  public void shoudDisplay16min() throws IllegalCoinException{
	  payfor16min();
  }
  
  @Test 
  public void cleanningAfterBuy() throws IllegalCoinException{
	  payfor16min();
	  assertEquals("Shoud return value equal to 16 min", 0, ps.readDisplay());
	  ps.addPayment(5);
	  rec = ps.buy();
	  assertEquals("Shoud return value equal to 16 min", 5/5*2, rec.value());
  }

  @Test
  public void payfor16min() throws IllegalCoinException {
	  ps.addPayment(5);
	  ps.addPayment(10);
	  ps.addPayment(25);
	  rec = ps.buy();
	  assertEquals("Shoud return value equal to 16 min", (5+10+25)/5*2, rec.value());
  }
  
  @Test 
  public void shouldDisplay14min() throws IllegalCoinException {
	  ps.addPayment(10);
	  ps.addPayment(25);
	  assertEquals("Shoud display 14 min, 10 and 25 cents", (10+25)/5*2, ps.readDisplay());
  }
  
  @Test
  public void cancel() throws IllegalCoinException {
	  ps.addPayment(25);
	  ps.cancel();
	  assertEquals("Shoud cancel transaction", 0, ps.readDisplay());
	  
	  payfor16min();
  }
  
  
  @Test
  public void empty() throws IllegalCoinException, EmptyException {
	  payfor16min();
	  payfor16min();
	  payfor16min();
	  assertEquals("Shoud display empty playstation", 120, ps.empty());
	  assertEquals("Shoud remove coins", 0, ps.coinsInMachine());
  }
  
  @Test(expected=EmptyException.class)
  public void callempty() throws EmptyException {
	ps.empty();
  }
  
  /**
   * Entering 5 cents should make the display report 2 minutes 
   * parking time.
  */
  @Test
  public void shouldDisplay2MinFor5Cents() throws IllegalCoinException {
    ps.addPayment( 5 );
    assertEquals( "Should display 2 min for 5 cents", 
                  2, ps.readDisplay() ); 
  }

  /**
   * Entering 25 cents should make the display report 10 minutes
   * parking time.
  */
  @Test
  public void shouldDisplay10MinFor25Cents() throws IllegalCoinException {
    ps.addPayment( 25 );
    assertEquals( "Should display 10 min for 25 cents", 
                  25 / 5 * 2, ps.readDisplay() );
    // 25 cent in 5 cent coins each giving 2 minutes parking
  }

  /** 
   * Verify that illegal coin values are rejected.
  */
  @Test(expected=IllegalCoinException.class)
  public void shouldRejectIllegalCoin() throws IllegalCoinException {
    ps.addPayment(17);
  }

}
