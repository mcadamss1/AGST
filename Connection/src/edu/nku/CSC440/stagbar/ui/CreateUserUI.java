package edu.nku.CSC440.stagbar.ui;

import edu.nku.CSC440.stagbar.dataaccess.PermissionLevel;
import edu.nku.CSC440.stagbar.service.UserService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class CreateUserUI extends JPanel{
	public static final String ERROR_REQUIRED_FIELDS = "All fields must be filled.";
	public static final String ERROR_PASSWORD_MATCH = "Password does not match the confirm password";
	public static final String ERROR_USER_EXISTS = "A user of that name already exists.";
	public static final String MESSAGE_NEW_USER = "New user: %s has been created";
	public static final String ERROR_CANNOT_SAVE = "Unable to save new user. Try again later.";
	private JTextField usernameTextField;
	private JPasswordField passwordPasswordField;
	private JPasswordField confirmPasswordPasswordField;
	private JComboBox permissionLevelComboBox;
	private JButton okButton;
	private JLabel errorMessage;
	private JPanel contentPane;
	private JLabel usernameLabel;
	private JLabel passwordLabel;
	private JLabel confirmPasswordLabel;
	private JLabel permissionLevelLabel;
	private UserService userService;


	public CreateUserUI() {
		userService = new UserService();

		//TODO: Fill combobox

		okButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				onOK();
			}
		});
	}

	private void onOK() {
		highlightEmptyFields();

		// Check that all fields are filled.
		// TODO: Verify combobox function.
		if(usernameTextField.getText().isEmpty() || 0 == passwordPasswordField.getPassword().length ||
				0 == confirmPasswordPasswordField.getPassword().length || null == permissionLevelComboBox.getSelectedItem()) {
			errorMessage.setText(ERROR_REQUIRED_FIELDS);
		}
		// Check that passwords match
		else if(!Arrays.equals(passwordPasswordField.getPassword(), confirmPasswordPasswordField.getPassword())) {
			errorMessage.setText(ERROR_PASSWORD_MATCH);
		}
		// Check that username is unique in DB
		else if(userService.doesUserExist(usernameTextField.getText())){
			errorMessage.setText(ERROR_USER_EXISTS);
		}
		// Save user to DB
		else if(userService.saveNewUser(usernameTextField.getText(), passwordPasswordField.getPassword(), (PermissionLevel)permissionLevelComboBox.getSelectedItem())) {
			// Display confirmation to user
			JOptionPane.showMessageDialog(this, String.format(MESSAGE_NEW_USER, usernameTextField.getText()));
			okButton.setEnabled(false);
			//TODO: Navigate user away from page.
		}
		else
			JOptionPane.showMessageDialog(this, ERROR_CANNOT_SAVE);
	}

	/** Turns blank fields RED and reverts filled fields to BLACK. */
	private void highlightEmptyFields() {
		if(usernameTextField.getText().isEmpty())
			usernameLabel.setForeground(Color.RED);
		else
			usernameLabel.setForeground(Color.BLACK);

		if(0 == passwordPasswordField.getPassword().length)
			passwordLabel.setForeground(Color.RED);
		else
			passwordLabel.setForeground(Color.BLACK);

		if(0 == confirmPasswordPasswordField.getPassword().length)
			confirmPasswordLabel.setForeground(Color.RED);
		else
			confirmPasswordLabel.setForeground(Color.BLACK);

		if(null == permissionLevelComboBox.getSelectedItem())
			permissionLevelLabel.setForeground(Color.RED);
		else
			permissionLevelLabel.setForeground(Color.BLACK);
	}


	public JPanel getContentPane() {
		return contentPane;
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("CreateUserUI");
		frame.setContentPane(new CreateUserUI().contentPane);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}
