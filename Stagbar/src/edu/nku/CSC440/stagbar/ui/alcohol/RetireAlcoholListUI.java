package edu.nku.CSC440.stagbar.ui.alcohol;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;
import edu.nku.CSC440.stagbar.dataaccess.data.Alcohol;
import javax.swing.*;
import java.awt.*;

public class RetireAlcoholListUI {
    private JPanel contentPane;
    private JCheckBox alcoholCheckBox;
    private Alcohol alcohol;
    private boolean expelliarmus; // set to true if alcohol should be removed

    public RetireAlcoholListUI(Alcohol alcohol) {
        if (null == alcohol) throw new IllegalArgumentException("Alcohol cannot be null.");
        this.alcohol = alcohol;
        $$$setupUI$$$();
        alcoholCheckBox.setText(alcohol.getName());
        alcoholCheckBox.addItemListener(e -> alcoholDeletion());
        expelliarmus = false;
    }

    public JPanel getContentPane() {
        return contentPane;
    }

    private void createUIComponents() {
        alcoholCheckBox = new JCheckBox();
    }

    public int getAlcoholId() {
        return alcohol.getAlcoholId();
    }

    public Alcohol getAlcohol() {
        return alcohol;
    }

    public boolean getDeletionStatus() {
        return expelliarmus;
    }

    private void alcoholDeletion() { // Should user be expelled from the tribe?
        if (alcoholCheckBox.isSelected()) { // Expelliarmus! Bye Felicia!
            expelliarmus = true;
        } else if (!alcoholCheckBox.isSelected()) { // if the checkbox is back to unselected status, then user is safe
            expelliarmus = false;
        }

    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        contentPane = new JPanel();
        contentPane.setLayout(new GridLayoutManager(1, 2, new Insets(0, 0, 0, 0), -1, -1));
        alcoholCheckBox = new JCheckBox();
        alcoholCheckBox.setText("CheckBox");
        contentPane.add(alcoholCheckBox, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer1 = new Spacer();
        contentPane.add(spacer1, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return contentPane;
    }
}
