import javax.management.Query;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorController {
	private CalculatorView view;
	private CalculatorModel model;

	public CalculatorController() {
		view = new CalculatorView();
		view.setEqualsButtonAction(setEqualsButton());
		view.setVisible(true);
	}

	public ActionListener setEqualsButton() {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
//				^([-+/*]\d+(\.\d+)?)*
				String equation = view.getTextField().getText();

				String pattern = "(-?)(\\d+)(\\+|-|\\*|/)(-?)(\\d+)";

				// Create a Pattern object
				Pattern r = Pattern.compile(pattern);

				// Now create matcher object.
				Matcher m = r.matcher(equation);
				if(m.find()) {
					System.out.println(m.group());
				}

				if(equation.matches(pattern)) {
					String[] splitStrings = (equation.split("((?<=[+-/*])|(?=[+-/*]))"));
					int first = Integer.parseInt(splitStrings[0]);
					String op = splitStrings[1];
					int second = Integer.parseInt(splitStrings[2]);
					if(op.equals("+")) {
						System.out.println(first + op + second);
						model.add(first, second);
						Integer value = model.getCalculatedValue();
						view.setTextField(value.toString());
					}
					Double val = Double.parseDouble(equation);
					view.setTextField(val.toString());

				} else {
					System.out.println("invalid");

				}
			}
		};
	}
}
