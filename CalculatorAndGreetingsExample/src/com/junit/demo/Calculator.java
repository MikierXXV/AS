package com.junit.demo;


public class Calculator {
	
		public int factorial (int n) {
			if (equaltozero(n)) return 1;
			else if (n > 0) {
				int res = generalcase(n);
				return res;
			}
			else throw arithmeticThrow();
		}
		
		private int recursivecase(int n) {
			if (n < 2) return 1;
			return n * recursivecase(n-1);
		}
		
		private ArithmeticException arithmeticThrow() {
			return new ArithmeticException();
		}
		private int generalcase(int n) {
			for (int i = n; i > 1; --i) {
				n *= (i-1);
			}
			return n;
		}
		private boolean equaltozero(int n) {
			return n == 0;
		}
		public int substract(int a, int b) {
			if (a > b) return a - b;
			else throw arithmeticThrow();
		}

		public int sum(int a, int b) {
			return a + b;
		}
	
		 public double multiply(double a, double b) {
			 return a * b;
		 }
		  
		 public double divide(double a, double b) { 
			  if(b == 0) {
			   throw arithmeticThrow();
			  }
			  return a / b;
		 } 
}
