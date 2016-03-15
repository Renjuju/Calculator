package Visitor;
/**
 * Created by renju on 3/9/16.
 */
public interface Visitor {
	public Double addVisit(Double first, Double second);

	public Double subVisit(Double first, Double second);

	public Double multVisit(Double first, Double second);

	public Double divideVisit(Double first, Double second);
}
