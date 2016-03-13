
public class CalculatorModel implements Visitable {
	private Double calculatedValue;
	private CalculationVisitor visitor = new CalculationVisitor();

	public void add(Double first, Double second) {
		calculatedValue = visitor.addVisit(first, second);
	}

	public void subtract(Double first, Double second) {
		calculatedValue = visitor.subVisit(first, second);
	}

	public void multiply(Double first, Double second) {
		calculatedValue = visitor.multVisit(first, second);
	}

	public void divide(Double first, Double second) {
		calculatedValue = visitor.divideVisit(first, second);
	}

	public Double getCalculatedValue() {
		return this.calculatedValue;
	}

	@Override
	public Double accept(Visitor visitor) {
		return null;
	}
}
