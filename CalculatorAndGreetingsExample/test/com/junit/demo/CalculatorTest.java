package com.junit.demo;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
 
public class CalculatorTest {
 
 private Calculator calc;
  
 @Before
 public void setUp() throws Exception {
  calc = new Calculator();
 }
 
 @After
 public void tearDown() throws Exception {
  calc = null;
 }
 
 @Test
 public void FactoryCasBase() {
	 int result = calc.factorial(0);
	 assertEquals(1, result, 0);
 }
 
 @Test
 public void FactoryPositiu() {
	 int result = calc.factorial(2);
	 assertEquals(2, result, 0);
 }
 
 @Test (expected = ArithmeticException.class)
 public void FactoryNegatiu() {
	 calc.factorial(-2);
 }
 
 
 @Test 
 public void testSubstact() {
	 int result = calc.substract(300, 200);
	 assertEquals(100, result, 0);
 }
 
 @Test (expected = ArithmeticException.class)
 public void testSubsExeption() {
	calc.substract(100, 200);
 }
 
 @Test
 public void testSum() {
	 int result = calc.sum(150, 100);
	 assertEquals(250, result, 0);
 }
 
 @Test
 public void testMultiply() {
  double result = calc.multiply(2.5, 100);
  assertEquals(250, result, 0);
 }
 
 @Test
 public void testDivide() {
  double result = calc.divide(100, 10);
  assertEquals(10, result, 0);
   
 }
 
 @Test
 public void testDivideWithTolerance() {
  double result = calc.divide(345, 100);
  assertEquals(3.4, result, 0.1);
   
 }
  
 @Test(expected = ArithmeticException.class)
 public void testDivideByZero() {
  calc.divide(100.5, 0);
 }
}
