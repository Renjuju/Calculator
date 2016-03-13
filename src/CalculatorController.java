import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.swing.JButton;

public class CalculatorController {
	private CalculatorView view;
	private CalculatorModel model;

	public CalculatorController() {
		view = new CalculatorView();
		model = new CalculatorModel();
		view.setEqualsButtonAction(setEqualsButton());
		view.setOperatorButtonActions(setOperatorButtons());
	}

	public void start() {
		view.setVisible(true);
	}

	private ActionListener setOperatorButtons() {
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

	private boolean isNumber(String val) {
		try {
			Double x = Double.parseDouble(val);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	private void calculate(String equation) {
		List<String> signList = new ArrayList<String>();
		List<String> numberList = new ArrayList<String>();

		StringTokenizer st = new StringTokenizer(equation, "+-*/", true);

		while (st.hasMoreTokens()) {
			String token = st.nextToken();
			if (isNumber(token)) {
				numberList.add(token);
			} else {
				signList.add(token);
			}
		}

		for (String s : numberList) {
			System.out.println("number: " + s);
		}

		for (String s : signList) {
			System.out.println("sign: " + s);
		}
		if (numberList.size() < 2) {
			return;
		}
		Double first = Double.parseDouble(numberList.get(0));
		String operation = signList.get(0);
		Double second = Double.parseDouble(numberList.get(1));
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

	private ActionListener setEqualsButton() {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				String equation = view.getTextField().getText();
				String pattern = "(-?)(\\d+)(\\+||\\*|/)(-?)(\\d+)";
				calculate(equation);
				if (equation.matches(pattern)) {
					calculate(equation);
				} else {
					// System.out.println("invalid");
				}
			}
		};
	}
}
