package edu.nku.CSC440.stagbar.ui.dataEntry;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;
import edu.nku.CSC440.stagbar.dataaccess.data.DrinkEntry;
import edu.nku.CSC440.stagbar.dataaccess.data.MixedDrink;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DrinkPaneUI {
	private final Map<MixedDrink, DrinkEntryRowUI> rowUIMap;
	private JPanel contentPane;
	private JPanel rowPane;

	public DrinkPaneUI() {
		$$$setupUI$$$();
		rowUIMap = new HashMap<>();
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
		contentPane.setLayout(new GridLayoutManager(3, 1, new Insets(0, 5, 0, 5), -1, -1));
		final JPanel panel1 = new JPanel();
		panel1.setLayout(new GridLayoutManager(1, 2, new Insets(0, 0, 0, 0), -1, -1));
		contentPane.add(panel1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
		final JLabel label1 = new JLabel();
		label1.setFont(new Font(label1.getFont().getName(), Font.BOLD, 14));
		label1.setText("Mixed Drinks");
		panel1.add(label1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
		final Spacer spacer1 = new Spacer();
		panel1.add(spacer1, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
		final JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayoutManager(1, 2, new Insets(0, 0, 0, 0), -1, -1));
		contentPane.add(panel2, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
		final Spacer spacer2 = new Spacer();
		panel2.add(spacer2, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, new Dimension(30, -1), null, 0, false));
		final JPanel panel3 = new JPanel();
		panel3.setLayout(new GridLayoutManager(2, 1, new Insets(0, 0, 0, 0), -1, -1));
		panel2.add(panel3, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
		final JPanel panel4 = new JPanel();
		panel4.setLayout(new GridLayoutManager(1, 3, new Insets(0, 0, 0, 0), -1, -1));
		panel3.add(panel4, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
		final JLabel label2 = new JLabel();
		label2.setFont(new Font(label2.getFont().getName(), Font.BOLD, label2.getFont().getSize()));
		label2.setHorizontalAlignment(2);
		label2.setText("Name");
		panel4.add(label2, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
		final JLabel label3 = new JLabel();
		label3.setFont(new Font(label3.getFont().getName(), Font.BOLD, label3.getFont().getSize()));
		label3.setHorizontalAlignment(0);
		label3.setHorizontalTextPosition(11);
		label3.setText("Amount(oz)");
		panel4.add(label3, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_EAST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
		final Spacer spacer3 = new Spacer();
		panel4.add(spacer3, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_FIXED, 1, null, new Dimension(150, -1), null, 0, false));
		panel3.add(rowPane, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_NORTH, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
	}

	public void addEntryRow(MixedDrink drink) {
		DrinkEntryRowUI entryRow = new DrinkEntryRowUI(drink);
		rowUIMap.put(drink, entryRow);
		rowPane.add(entryRow.getContentPane());
	}

	private void createUIComponents() {
		rowPane = new JPanel();
		rowPane.setLayout(new BoxLayout(rowPane, BoxLayout.Y_AXIS));
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public Set<DrinkEntry> getEntries() {
		boolean failure = false;
		Set<DrinkEntry> entries = new HashSet<>();
		for(DrinkEntryRowUI entryRow : rowUIMap.values()) {
			try {
				entries.add(entryRow.getEntry());
			} catch(IllegalStateException e) {
				failure = true;
			}
		}
		if(failure) throw new IllegalStateException("Mixed Drink");

		return entries;
	}

	public void removeEntryRow(MixedDrink drink) {
		DrinkEntryRowUI entryRow = rowUIMap.remove(drink);
		rowPane.remove(entryRow.getContentPane());
	}

	@Override
	public String toString() {
		return "Mixed Drink Pane";
	}

}
