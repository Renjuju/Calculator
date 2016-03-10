import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorController {
	private CalculatorView view;
	private CalculatorModel model;

	public CalculatorController() {
		view = new CalculatorView();
	}

	public ActionListener setAddButton() {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				
			}
		};
	}
}
