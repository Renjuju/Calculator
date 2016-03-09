
public class CalculatorModel {
	private int calculatedValue; 
	
	public void add(int first, int second) {
		calculatedValue = first + second;
	}
	
	public void subtract(int first, int second) { 
		calculatedValue = first + second;
	}

	public void multiply(int first, int second) { 
		calculatedValue = first * second;
	}
	
	public void divide(int first, int second) {
		calculatedValue = first / second;
	}
	
	public int getCalculatedValue() {
		return this.calculatedValue;
	}
}
