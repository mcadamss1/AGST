package edu.nku.CSC440.stagbar.ui;

import edu.nku.CSC440.stagbar.dataaccess.PermissionLevel;
import edu.nku.CSC440.stagbar.service.UserService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class CreateUserUI {
	public static final String ERROR_CANNOT_SAVE = "Unable to save new user. Try again later.";
	public static final String ERROR_PASSWORD_MATCH = "Password does not match the confirm password.";
	public static final String ERROR_REQUIRED_FIELDS = "All fields must be filled.";
	public static final String ERROR_USER_EXISTS = "A user of that name already exists.";
	public static final String MESSAGE_NEW_USER = "New user %s has been created.";
	public static final String TITLE_CANNOT_SAVE = "User Creation Failed";
	public static final String TITLE_NEW_USER = "User Created";
	private JLabel confirmPasswordLabel;
	private JPasswordField confirmPasswordPasswordField;
	private JPanel contentPane;
	private JLabel errorMessage;
	private JButton okButton;
	private JLabel passwordLabel;
	private JPasswordField passwordPasswordField;
	private JComboBox permissionLevelComboBox;
	private JLabel permissionLevelLabel;
	private UserService userService;
	private JLabel usernameLabel;
	private JTextField usernameTextField;

	public CreateUserUI() {
		$$$setupUI$$$();
		userService = UserService.getInstance();

		contentPane.setName("Create User");

		okButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					onOK();
				} catch (HeadlessException | ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
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
		contentPane.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(3, 1, new Insets(10, 10, 10, 10), -1, -1));
		final JPanel panel1 = new JPanel();
		panel1.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
		contentPane.add(panel1, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
		errorMessage = new JLabel();
		errorMessage.setForeground(new Color(-65536));
		errorMessage.setText("");
		panel1.add(errorMessage, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(320, 16), null, 0, false));
		final JPanel panel2 = new JPanel();
		panel2.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(4, 2, new Insets(0, 0, 0, 0), -1, -1));
		contentPane.add(panel2, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
		usernameLabel = new JLabel();
		usernameLabel.setText("Username:");
		usernameLabel.setDisplayedMnemonic('U');
		usernameLabel.setDisplayedMnemonicIndex(0);
		panel2.add(usernameLabel, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
		usernameTextField = new JTextField();
		panel2.add(usernameTextField, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
		passwordLabel = new JLabel();
		passwordLabel.setText("Password:");
		passwordLabel.setDisplayedMnemonic('P');
		passwordLabel.setDisplayedMnemonicIndex(0);
		panel2.add(passwordLabel, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
		passwordPasswordField = new JPasswordField();
		panel2.add(passwordPasswordField, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
		confirmPasswordLabel = new JLabel();
		confirmPasswordLabel.setText("Confirm Password:");
		confirmPasswordLabel.setDisplayedMnemonic('C');
		confirmPasswordLabel.setDisplayedMnemonicIndex(0);
		panel2.add(confirmPasswordLabel, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
		confirmPasswordPasswordField = new JPasswordField();
		panel2.add(confirmPasswordPasswordField, new com.intellij.uiDesigner.core.GridConstraints(2, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
		permissionLevelLabel = new JLabel();
		permissionLevelLabel.setText("Permission Level:");
		permissionLevelLabel.setDisplayedMnemonic('L');
		permissionLevelLabel.setDisplayedMnemonicIndex(11);
		panel2.add(permissionLevelLabel, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
		panel2.add(permissionLevelComboBox, new com.intellij.uiDesigner.core.GridConstraints(3, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
		final JPanel panel3 = new JPanel();
		panel3.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 2, new Insets(0, 0, 0, 0), -1, -1));
		contentPane.add(panel3, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
		okButton = new JButton();
		okButton.setText("OK");
		okButton.setMnemonic('O');
		okButton.setDisplayedMnemonicIndex(0);
		panel3.add(okButton, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
		final com.intellij.uiDesigner.core.Spacer spacer1 = new com.intellij.uiDesigner.core.Spacer();
		panel3.add(spacer1, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
		usernameLabel.setLabelFor(usernameTextField);
		passwordLabel.setLabelFor(passwordPasswordField);
		confirmPasswordLabel.setLabelFor(confirmPasswordPasswordField);
		permissionLevelLabel.setLabelFor(permissionLevelComboBox);
	}

	/** @noinspection ALL */
	public JComponent $$$getRootComponent$$$() { return contentPane; }

	private void createUIComponents() {
		permissionLevelComboBox = new JComboBox(PermissionLevel.values());
		permissionLevelComboBox.setSelectedIndex(-1);
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	/** Turns blank fields RED and reverts filled fields to BLACK. */
	private void highlightEmptyFields() {
		usernameLabel.setForeground(usernameTextField.getText().isEmpty() ?
																Color.RED : Color.BLACK);

		passwordLabel.setForeground(0 == passwordPasswordField.getPassword().length ?
																Color.RED : Color.BLACK);

		confirmPasswordLabel.setForeground(0 == confirmPasswordPasswordField.getPassword().length ?
																			 Color.RED : Color.BLACK);

		permissionLevelLabel.setForeground(null == permissionLevelComboBox.getSelectedItem() ?
																			 Color.RED : Color.BLACK);
	}

	private void onOK() throws HeadlessException, ClassNotFoundException {
		highlightEmptyFields();

		// Check that all fields are filled.
		if(usernameTextField.getText().isEmpty() || 0 == passwordPasswordField.getPassword().length ||
				0 == confirmPasswordPasswordField.getPassword().length || null == permissionLevelComboBox.getSelectedItem()) {
			errorMessage.setText(ERROR_REQUIRED_FIELDS);
		}
		// Check that passwords match
		else if(!Arrays.equals(passwordPasswordField.getPassword(), confirmPasswordPasswordField.getPassword())) {
			errorMessage.setText(ERROR_PASSWORD_MATCH);
			passwordLabel.setForeground(Color.RED); // Color reset by highlightEmptyFields() on next OK.
			confirmPasswordLabel.setForeground(Color.RED);
			confirmPasswordPasswordField.selectAll();
			confirmPasswordPasswordField.requestFocusInWindow();
		}
		// Check that username is unique in DB
		else if(userService.doesUserExist(usernameTextField.getText())) {
			errorMessage.setText(ERROR_USER_EXISTS);
			usernameLabel.setForeground(Color.RED);
			usernameTextField.selectAll();
			usernameTextField.requestFocusInWindow();
		}
		// Save user to DB
		else if(userService.saveNewUser(usernameTextField.getText(), passwordPasswordField.getPassword(), (PermissionLevel)permissionLevelComboBox.getSelectedItem())) {
			// Display confirmation to user
			JOptionPane.showMessageDialog(contentPane, String.format(MESSAGE_NEW_USER, usernameTextField.getText()), TITLE_NEW_USER, JOptionPane.INFORMATION_MESSAGE);

			//TODO: Navigate user away from page.
			okButton.setEnabled(false);
			uiHacks.killMeThenGoToLastPage(contentPane);
		}
		else {
			JOptionPane.showMessageDialog(contentPane, ERROR_CANNOT_SAVE, TITLE_CANNOT_SAVE, JOptionPane.ERROR_MESSAGE);
		}
	}

}
