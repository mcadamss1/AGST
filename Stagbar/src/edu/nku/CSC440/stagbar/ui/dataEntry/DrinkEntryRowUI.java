package edu.nku.CSC440.stagbar.ui.dataEntry;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;
import edu.nku.CSC440.stagbar.dataaccess.data.DrinkEntry;
import edu.nku.CSC440.stagbar.dataaccess.data.MixedDrink;
import edu.nku.CSC440.stagbar.ui.common.ImprovedFormattedTextField;

import javax.swing.*;
import java.awt.*;
import java.text.NumberFormat;

public class DrinkEntryRowUI {
	private JFormattedTextField amountFormattedTextField;
	private JPanel contentPane;
	private MixedDrink drink;
	private JLabel drinkLabel;

	public DrinkEntryRowUI(MixedDrink drink) {
		if(null == drink) throw new IllegalArgumentException("Drink cannot be null.");

		this.drink = drink;
		$$$setupUI$$$();
		drinkLabel.setText(drink.getName());
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
		contentPane.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(2, 3, new Insets(0, 0, 0, 0), -1, -1));
		drinkLabel = new JLabel();
		drinkLabel.setText("Label");
		contentPane.add(drinkLabel, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 2, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
		amountFormattedTextField.setFocusLostBehavior(3);
		contentPane.add(amountFormattedTextField, new com.intellij.uiDesigner.core.GridConstraints(0, 2, 2, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
		final com.intellij.uiDesigner.core.Spacer spacer1 = new com.intellij.uiDesigner.core.Spacer();
		contentPane.add(spacer1, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, 1, null, new Dimension(150, -1), null, 0, false));
	}

	private void createUIComponents() {
		NumberFormat integerNumberInstance = NumberFormat.getIntegerInstance();
		amountFormattedTextField = new ImprovedFormattedTextField(integerNumberInstance, null);
		amountFormattedTextField.setHorizontalAlignment(SwingConstants.RIGHT);
		amountFormattedTextField.setFocusLostBehavior(JFormattedTextField.PERSIST);
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public DrinkEntry getEntry() {
		int amount;
		drinkLabel.setForeground(Color.BLACK);

		try {
			amount = Integer.parseInt(amountFormattedTextField.getText());
		} catch(NumberFormatException e) {
			drinkLabel.setForeground(Color.RED);
			throw new IllegalStateException(e);
		}

		return new DrinkEntry(drink, amount);
	}


}
