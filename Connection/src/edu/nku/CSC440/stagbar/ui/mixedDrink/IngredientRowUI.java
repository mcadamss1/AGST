package edu.nku.CSC440.stagbar.ui.mixedDrink;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import edu.nku.CSC440.stagbar.dataaccess.Alcohol;
import edu.nku.CSC440.stagbar.dataaccess.MixedDrinkIngredient;
import edu.nku.CSC440.stagbar.ui.common.ImprovedFormattedTextField;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class IngredientRowUI {

	private Alcohol alcohol;
	private JLabel alcoholLabel;
	private JFormattedTextField amountFormattedTextField;
	private JPanel contentPane;

	public IngredientRowUI(Alcohol alcohol) {
		this(alcohol, 0);
	}

	public IngredientRowUI(Alcohol alcohol, double amount) {
		if(null == alcohol) throw new IllegalArgumentException("Alcohol cannot be null.");

		this.alcohol = alcohol;
		$$$setupUI$$$();
		alcoholLabel.setText(alcohol.getName());
		amountFormattedTextField.setText(String.valueOf(amount));
	}

	/** @noinspection ALL */
	public JComponent $$$getRootComponent$$$() { return contentPane; }

	/**
	 * Method generated by IntelliJ IDEA GUI Designer
	 * >>> IMPORTANT!! <<<
	 * DO NOT edit this method OR call it in your code!
	 *
	 * @noinspection ALL
	 */
	private void $$$setupUI$$$() {
		createUIComponents();
		contentPane = new JPanel();
		contentPane.setLayout(new GridLayoutManager(1, 2, new Insets(0, 0, 0, 0), -1, -1));
		alcoholLabel = new JLabel();
		alcoholLabel.setText("Label");
		contentPane.add(alcoholLabel, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
		amountFormattedTextField.setText("0");
		contentPane.add(amountFormattedTextField, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
		alcoholLabel.setLabelFor(amountFormattedTextField);
	}

	private void createUIComponents() {
		NumberFormat decimalNumberInstance = new DecimalFormat();
		amountFormattedTextField = new ImprovedFormattedTextField(decimalNumberInstance, null);
		amountFormattedTextField.setHorizontalAlignment(SwingConstants.RIGHT);
		amountFormattedTextField.setFocusLostBehavior(JFormattedTextField.PERSIST);
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public MixedDrinkIngredient getIngredient() {
		double amount;
		alcoholLabel.setForeground(Color.BLACK);

		try {
			amount = Double.parseDouble(amountFormattedTextField.getText());
		} catch(NumberFormatException e) {
			alcoholLabel.setForeground(Color.RED);
			throw new IllegalStateException(e);
		}

		return new MixedDrinkIngredient(alcohol, amount);
	}

}
