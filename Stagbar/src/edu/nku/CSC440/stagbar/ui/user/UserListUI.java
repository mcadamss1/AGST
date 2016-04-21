package edu.nku.CSC440.stagbar.ui.user;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import edu.nku.CSC440.stagbar.dataaccess.data.PermissionLevel;
import edu.nku.CSC440.stagbar.dataaccess.data.User;
import edu.nku.CSC440.stagbar.dataaccess.databaseConnection.Connect;

import java.awt.*;
import javax.swing.*;

public class UserListUI {
    private JPanel contentPane;
    private JRadioButton adminRadio;
    private JRadioButton guestRadio;
    private JLabel userLabel;
    private boolean iAmAdmin; //true if this user is Admin, otherwise false
    private User user;

    public UserListUI(User user) {
        if (null == user) throw new IllegalArgumentException("User cannot be null.");
        this.user = user;
        $$$setupUI$$$();
        userLabel.setText(user.getUsername());
        adminRadio.setText("Admin");
        guestRadio.setText("Guest");
        adminRadio.addItemListener(e -> adminRadioSelection());
        guestRadio.addItemListener(e -> guestRadioSelection());
    }

    private void adminRadioSelection() {
        if (iAmAdmin == false && adminRadio.isSelected()) { //if user is originally Guest and needs to be converted to Admin status,
            guestRadio.setSelected(false); //immediately unselect the other button
            iAmAdmin = true; //guest becomes admin
            Connect.getInstance().updateUserPermissions(user.getUsername(), PermissionLevel.ADMIN); }
    }

    private void guestRadioSelection() {
        if (iAmAdmin == true && guestRadio.isSelected()) { //if user is originally Admin and needs to be converted to Guest status,
            adminRadio.setSelected(false); //immediately unselect the other button
            iAmAdmin = false; //admin becomes guest
            Connect.getInstance().updateUserPermissions(user.getUsername(), PermissionLevel.GUEST); }
    }

    public JPanel getContentPane() { return contentPane;  }

    private void createUIComponents() {
        adminRadio = new JRadioButton();
        guestRadio = new JRadioButton();
        if (user.getPermissionLevel().equals(PermissionLevel.ADMIN)) { //Admin RButton is selected by default if user is Admin
            adminRadio.setSelected(true);
            guestRadio.setSelected(false);
            iAmAdmin = true; }
        else if (user.getPermissionLevel().equals(PermissionLevel.GUEST)) { //Guest RButton is selected by default if user is Guest
            adminRadio.setSelected(false);
            guestRadio.setSelected(true);
            iAmAdmin = false; }
    }

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
        contentPane.setLayout(new GridLayoutManager(1, 3, new Insets(0, 0, 0, 0), -1, -1));
        userLabel = new JLabel();
        userLabel.setText("Label");
        contentPane.add(userLabel, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        adminRadio.setText("RadioButton");
        contentPane.add(adminRadio, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        guestRadio.setText("RadioButton");
        contentPane.add(guestRadio, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return contentPane;
    }
}
