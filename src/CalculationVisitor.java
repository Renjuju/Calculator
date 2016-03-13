/**
 * Created by renju on 3/9/16.
 */
public class CalculationVisitor implements Visitor {

	@Override
	public Double addVisit(Double first, Double second) {
		return first + second;
	}

	@Override
	public Double subVisit(Double first, Double second) {
		return first - second;
	}

	@Override
	public Double multVisit(Double first, Double second) {
		return first * second;
	}

	@Override
	public Double divideVisit(Double first, Double second) {
		return first / second;
	}
}
