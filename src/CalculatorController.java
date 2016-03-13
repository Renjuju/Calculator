import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class CalculatorController {
	private CalculatorView view;
	private CalculatorModel model;

	public CalculatorController() {
		view = new CalculatorView();
		model = new CalculatorModel();
		view.setEqualsButtonAction(setEqualsButton());
		view.setOperatorButtonActions(setOperatorButtons());
		view.setVisible(true);
	}

	public ActionListener setOperatorButtons() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String operation = ((JButton) e.getSource()).getText();

				if (view.getTextField().getText().trim().equals("") || view.getTextField().getText().endsWith("+")
						|| view.getTextField().getText().endsWith("-") || view.getTextField().getText().endsWith("*")
						|| view.getTextField().getText().endsWith("/")) {
				} else {
					calculate(view.getTextField().getText());
					view.setTextField(view.getTextField().getText() + operation);
				}
			}
		};
	}

	public void calculate(String equation) {
		String[] splitStrings = (equation.split("((?<=[+-/*])|(?=[+-/*]))"));
		if (splitStrings.length < 3) {
			return;
		}
		Double first = Double.parseDouble(splitStrings[0]);
		String operation = splitStrings[1];
		Double second = Double.parseDouble(splitStrings[2]);
		Double value = 0.0;
		switch (operation) {
		case "+":
			model.add(first, second);
			value = model.getCalculatedValue();
			view.setTextField(value.toString());
			break;
		case "-":
			model.subtract(first, second);
			value = model.getCalculatedValue();
			view.setTextField(value.toString());
			break;
		case "/":
			model.divide(first, second);
			value = model.getCalculatedValue();
			view.setTextField(value.toString());
			break;
		case "*":
			model.multiply(first, second);
			value = model.getCalculatedValue();
			view.setTextField(value.toString());
			break;
		}
	}

	public ActionListener setEqualsButton() {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				String equation = view.getTextField().getText();
				String pattern = "(-?)(\\d+)(\\+||\\*|/)(-?)(\\d+)";

				if (equation.matches(pattern)) {
					calculate(equation);
				} else {
					System.out.println("invalid");

				}
			}
		};
	}
}
