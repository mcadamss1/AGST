package edu.nku.CSC440.stagbar.ui.menu;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import edu.nku.CSC440.stagbar.ui.common.uiHacks;
import edu.nku.CSC440.stagbar.ui.mixedDrink.CreateMixedDrinkUI;
import edu.nku.CSC440.stagbar.ui.mixedDrink.EditMixedDrinkUI;

import javax.swing.*;
import java.awt.*;

public class MixedDrinkMenuUI {
	private JPanel contentPane;
	private JButton editDrinkButton;
	private JButton goBackButton;
	private JButton newDrinkButton;
	private JButton retireReinstateDrinkButton;

	public MixedDrinkMenuUI() {
		contentPane.setName("Mixed Drink Menu");

		newDrinkButton.addActionListener(e -> onNewDrink());
		editDrinkButton.addActionListener(e -> onEditDrink());
		retireReinstateDrinkButton.addActionListener(e -> onRetireReinstateDrink());
		goBackButton.addActionListener(e -> onGoBack());
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
		contentPane = new JPanel();
		contentPane.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(4, 1, new Insets(10, 10, 10, 10), -1, -1));
		contentPane.setPreferredSize(new Dimension(250, 155));
		newDrinkButton = new JButton();
		newDrinkButton.setText("New Drink");
		contentPane.add(newDrinkButton, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
		goBackButton = new JButton();
		goBackButton.setText("Go Back");
		contentPane.add(goBackButton, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_SOUTH, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
		retireReinstateDrinkButton = new JButton();
		retireReinstateDrinkButton.setText("Retire/Reinstate Drink");
		contentPane.add(retireReinstateDrinkButton, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
		editDrinkButton = new JButton();
		editDrinkButton.setText("Edit Drink");
		contentPane.add(editDrinkButton, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	private void onEditDrink() {
		EditMixedDrinkUI editMixedDrinkUI = new EditMixedDrinkUI();
		uiHacks.goToPanel(contentPane, editMixedDrinkUI.getContentPane());
	}

	private void onGoBack() {
		uiHacks.killMeThenGoToLastPage(contentPane);
	}

	private void onNewDrink() {
		CreateMixedDrinkUI createMixedDrinkUI = new CreateMixedDrinkUI();
		uiHacks.goToPanel(contentPane, createMixedDrinkUI.getContentPane());
	}

	private void onRetireReinstateDrink() {
		//TODO: Navigate to retire/reinstate drink panel.
	}

	{
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
		$$$setupUI$$$();
	}

}
