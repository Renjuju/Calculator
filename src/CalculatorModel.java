
public class CalculatorModel implements Visitable {
	private int calculatedValue;
	private CalculationVisitor visitor = new CalculationVisitor();
	public void add(int first, int second) {
		calculatedValue = visitor.addVisit(first, second);
	}
	
	public void subtract(int first, int second) {
		calculatedValue = visitor.subVisit(first, second);
	}

	public void multiply(int first, int second) {
		calculatedValue = visitor.multVisit(first, second);
	}
	
	public void divide(int first, int second) {
		calculatedValue = visitor.divideVisit(first, second);
	}
	
	public int getCalculatedValue() {
		return this.calculatedValue;
	}

	@Override
	public Integer accept(Visitor visitor) {
		return null;
	}
}
