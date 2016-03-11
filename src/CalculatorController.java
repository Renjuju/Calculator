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

				String pattern = "^([-+/*]\\d+(\\.\\d+)?)*";

				// Create a Pattern object
				Pattern r = Pattern.compile(pattern);

				// Now create matcher object.
				Matcher m = r.matcher(equation);
				if(m.find()) {
					System.out.println("Found");
					System.out.println(m.group(2));
				}

				if(equation.matches("^([-+/*]\\d+(\\.\\d+)?)*")) {
					System.out.println("valid");
				} else {
					System.out.println("invalid");

				}
			}
		};
	}
}
