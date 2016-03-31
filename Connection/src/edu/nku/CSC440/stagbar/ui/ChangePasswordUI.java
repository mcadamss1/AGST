package edu.nku.CSC440.stagbar.ui;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;
import edu.nku.CSC440.stagbar.Application;
import edu.nku.CSC440.stagbar.dataaccess.PermissionLevel;
import edu.nku.CSC440.stagbar.service.UserService;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class ChangePasswordUI {
	private static final String ERROR_CANNOT_SAVE = "Unable to save new user. Try again later.";
	private static final String ERROR_PASSWORD_IS_WRONG = "Old password is wrong. Please retype.";
	private static final String ERROR_PASSWORD_MATCH = "New password does not match the confirm password.";
	private static final String ERROR_REQUIRED_FIELDS = "All fields must be filled.";
	private static final String ERROR_USER_NOT_EXIST = "Username does not exist.";
	private static final String MESSAGE_NEW_USER = "Password for %s has been changed.";
	private static final String TITLE_CANNOT_SAVE = "Change of password failed.";
	private static final String TITLE_NEW_USER = "Congratulations! Your password is changed.";
	private JButton cancelButton;
	private JPasswordField confirmPasswordField;
	private JLabel confirmPasswordLabel;
	private JPanel contentPane;
	private JLabel errorMessage;
	private JPasswordField newPasswordField;
	private JLabel newPasswordLabel;
	private JButton okButton;
	private JPasswordField oldPasswordField;
	private JLabel oldPasswordLabel;
	private UserService userService;
	private JLabel usernameLabel;
	private JTextField usernameTextField;

	public ChangePasswordUI() {
		$$$setupUI$$$();
		userService = UserService.getInstance();
		contentPane.setName("Change Password");
		okButton.addActionListener(e -> onOK());
		cancelButton.addActionListener(e -> onCancel());

		if(Application.getInstance().getUser().getPermissionLevel().equals(PermissionLevel.GUEST)) {
			usernameTextField.setText(Application.getInstance().getUser().getUsername());
			usernameTextField.setEditable(false);
		}
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
		contentPane.setLayout(new GridLayoutManager(3, 1, new Insets(0, 0, 0, 0), -1, -1));
		final JPanel panel1 = new JPanel();
		panel1.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
		contentPane.add(panel1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
		errorMessage = new JLabel();
		errorMessage.setForeground(new Color(-65536));
		errorMessage.setText("");
		panel1.add(errorMessage, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(320, 16), null, 0, false));
		final JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayoutManager(4, 2, new Insets(0, 0, 0, 0), -1, -1));
		contentPane.add(panel2, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
		usernameLabel = new JLabel();
		usernameLabel.setText("Username:");
		usernameLabel.setDisplayedMnemonic('U');
		usernameLabel.setDisplayedMnemonicIndex(0);
		panel2.add(usernameLabel, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
		usernameTextField = new JTextField();
		panel2.add(usernameTextField, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
		oldPasswordLabel = new JLabel();
		oldPasswordLabel.setText("Password:");
		oldPasswordLabel.setDisplayedMnemonic('P');
		oldPasswordLabel.setDisplayedMnemonicIndex(0);
		panel2.add(oldPasswordLabel, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
		oldPasswordField = new JPasswordField();
		panel2.add(oldPasswordField, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
		newPasswordLabel = new JLabel();
		newPasswordLabel.setText("New Password:");
		newPasswordLabel.setDisplayedMnemonic('N');
		newPasswordLabel.setDisplayedMnemonicIndex(0);
		panel2.add(newPasswordLabel, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
		newPasswordField = new JPasswordField();
		panel2.add(newPasswordField, new GridConstraints(2, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
		confirmPasswordLabel = new JLabel();
		confirmPasswordLabel.setText("Confirm Password:");
		confirmPasswordLabel.setDisplayedMnemonic('C');
		confirmPasswordLabel.setDisplayedMnemonicIndex(0);
		panel2.add(confirmPasswordLabel, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
		confirmPasswordField = new JPasswordField();
		panel2.add(confirmPasswordField, new GridConstraints(3, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
		final JPanel panel3 = new JPanel();
		panel3.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
		contentPane.add(panel3, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
		final JPanel panel4 = new JPanel();
		panel4.setLayout(new GridLayoutManager(1, 3, new Insets(0, 0, 0, 0), -1, -1));
		panel3.add(panel4, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
		final Spacer spacer1 = new Spacer();
		panel4.add(spacer1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
		okButton = new JButton();
		okButton.setText("OK");
		panel4.add(okButton, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
		cancelButton = new JButton();
		cancelButton.setText("Cancel");
		panel4.add(cancelButton, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
		usernameLabel.setLabelFor(usernameTextField);
		oldPasswordLabel.setLabelFor(oldPasswordField);
		newPasswordLabel.setLabelFor(newPasswordField);
		confirmPasswordLabel.setLabelFor(confirmPasswordField);
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	private void highlightEmptyFields() {
		usernameLabel.setForeground(usernameTextField.getText().isEmpty() ?
																Color.RED : Color.BLACK);

		oldPasswordLabel.setForeground(0 == oldPasswordField.getPassword().length ?
																	 Color.RED : Color.BLACK);

		newPasswordLabel.setForeground(0 == oldPasswordField.getPassword().length ?
																	 Color.RED : Color.BLACK);

		confirmPasswordLabel.setForeground(0 == confirmPasswordField.getPassword().length ?
																			 Color.RED : Color.BLACK);

	}

	private void onCancel() {
		uiHacks.killMeThenGoToLastPage(contentPane);
	}

	private void onOK() {
		highlightEmptyFields();

// Check all fields are filled.
		if(usernameTextField.getText().isEmpty() || 0 == oldPasswordField.getPassword().length || 0 == newPasswordField.getPassword().length || 0 == confirmPasswordField.getPassword().length) {
			errorMessage.setText(ERROR_REQUIRED_FIELDS);
		}
// Check if new passwords match.
		else if(!Arrays.equals(newPasswordField.getPassword(), confirmPasswordField.getPassword())) {
			errorMessage.setText(ERROR_PASSWORD_MATCH);
			confirmPasswordLabel.setForeground(Color.RED); // Color reset by highlightEmptyFields() on next OK.
			confirmPasswordLabel.setForeground(Color.RED);
			confirmPasswordField.selectAll();
			confirmPasswordField.requestFocusInWindow();
		}
// Check username exists
		else if(!userService.doesUserExist(usernameTextField.getText())) {
			errorMessage.setText(ERROR_USER_NOT_EXIST);
			usernameLabel.setForeground(Color.RED);
			usernameTextField.selectAll();
			usernameTextField.requestFocusInWindow();
		}
// Check if old password entered actually matches user's real password
		else if(!userService.authenticateUser(usernameTextField.getText(), oldPasswordField.getPassword())) {
			errorMessage.setText(ERROR_PASSWORD_IS_WRONG);
			oldPasswordLabel.setForeground(Color.RED);
			oldPasswordField.selectAll();
			oldPasswordField.requestFocusInWindow();
		}
// Save user's new password to database.
		else if(userService.changePassword(usernameTextField.getText(), newPasswordField.getPassword())) {
			userService.changePassword(usernameTextField.getText(), newPasswordField.getPassword());
			// Display confirmation to user
			JOptionPane.showMessageDialog(contentPane, String.format(MESSAGE_NEW_USER, usernameTextField.getText()), TITLE_NEW_USER, JOptionPane.INFORMATION_MESSAGE);

			okButton.setEnabled(false);
			uiHacks.killMeThenGoToLastPage(contentPane);
		}
		else {
			JOptionPane.showMessageDialog(contentPane, ERROR_CANNOT_SAVE, TITLE_CANNOT_SAVE, JOptionPane.ERROR_MESSAGE);
		}
	}

}
