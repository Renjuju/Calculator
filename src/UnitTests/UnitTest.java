package UnitTests;

import org.junit.Assert;
import org.junit.Test;

import Client.CalculatorClient;
import CompositeServer.CalculatorServer;
import Visitor.CalculationVisitor;
import mvc.CalculatorController;

public class UnitTest {

	@Test
	public void ensureCalculatorControllerDoesntThrowException() {
		CalculatorController controller = new CalculatorController();
	}

	@Test
	public void ensureCalculatorServerRuns() {
		CalculatorServer server = new CalculatorServer(34);
	}

	@Test
	public void ensureCalculationClientRuns() {
		CalculatorClient cli = new CalculatorClient("test", 34);
	}

	@Test
	public void visitableTest() {
		CalculationVisitor visitor = new CalculationVisitor();
		double val = visitor.addVisit(1.0, 2.0);
		Assert.assertEquals(3.0, val, 3.0);
	}
}
