//package edu.nku.CSC440.stagbar.ui;
//
//import com.intellij.uiDesigner.core.GridConstraints;
//import com.intellij.uiDesigner.core.GridLayoutManager;
//import com.intellij.uiDesigner.core.Spacer;
//import edu.nku.CSC440.stagbar.service.UserService;
//import edu.nku.CSC440.stagbar.Application;
//import edu.nku.CSC440.stagbar.dataaccess.User;
//import java.util.LinkedList;
//import java.util.Set;
//import java.util.HashSet;
//
//import javax.swing.*;
//import java.awt.*;
//
//
//public class DeleteUserUI {
//	private static final String PLEASE_CHECK_BOX = "Please delete at least one user, or hit Cancel button.";
//	private static final String MESSAGE_SUCCESS = "The deletion of user(s) is successful.";
//	private JPanel contentPane;
//	private JPanel scrollPanel;
//	private JButton cancelButton;
//	private JButton okButton;
//	private JLabel deleteUser;
//	private JCheckBox userCheckBox;
//	private UserService userService;
//	private final LinkedList<JCheckBox> checkBoxes;
//	private Set<User> allUsers;
//
//	private Application application;
//	private User user;
//
//	public DeleteUserUI(User user) {
//		//if(null == user) throw new IllegalArgumentException("User cannot be null.");
//		this.user = user;
//		checkBoxes = new LinkedList<JCheckBox>();
//		for(User user : userService.getAllUsers()) {
//			allUsers.add(user);
//		}
//		addUserRows();
//		userService = UserService.getInstance();
//		contentPane.setName("Delete User(s)");
//		okButton.addActionListener(e -> onOK());
//		cancelButton.addActionListener(e -> onCancel());
//		userCheckBox.addActionListener(e -> onChecked(JCheckBox));
//		$$$setupUI$$$();
//	}
//
//	/**
//	 * Method generated by IntelliJ IDEA GUI Designer
//	 * >>> IMPORTANT!! <<<
//	 * DO NOT edit this method OR call it in your code!
//	 *
//	 * @noinspection ALL
//	 */
//	private void $$$setupUI$$$() {
//		contentPane = new JPanel();
//		contentPane.setLayout(new GridLayoutManager(2, 1, new Insets(0, 0, 0, 0), -1, -1));
//		final JScrollPane scrollPane1 = new JScrollPane();
//		contentPane.add(scrollPane1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
//		scrollPanel = new JPanel();
//		scrollPanel.setLayout(new GridLayoutManager(2, 3, new Insets(5, 5, 5, 5), -1, -1));
//		scrollPane1.setViewportView(scrollPanel);
//		deleteUser = new JLabel();
//		deleteUser.setText("Delete User");
//		deleteUser.setDisplayedMnemonic('D');
//		deleteUser.setDisplayedMnemonicIndex(0);
//		scrollPanel.add(deleteUser, new GridConstraints(0, 0, 1, 3, GridConstraints.ANCHOR_NORTH, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
//		userCheckBox = new JCheckBox();
//		userCheckBox.setText("");
//		scrollPanel.add(userCheckBox, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
//		final JPanel panel1 = new JPanel();
//		panel1.setLayout(new GridLayoutManager(1, 3, new Insets(0, 0, 0, 0), -1, -1));
//		contentPane.add(panel1, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
//		cancelButton = new JButton();
//		cancelButton.setText("Cancel");
//		panel1.add(cancelButton, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
//		final Spacer spacer1 = new Spacer();
//		panel1.add(spacer1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
//		okButton = new JButton();
//		okButton.setText("OK");
//		okButton.setMnemonic('O');
//		okButton.setDisplayedMnemonicIndex(0);
//		panel1.add(okButton, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
//	}
//
//	/** @noinspection ALL */
//	public JComponent $$$getRootComponent$$$() { return contentPane; }
//
//	public void addUserRows() {
//		for(User user : allUsers) {
//			scrollPanel.add(userCheckBox.getText(user.getUsername()));
//		}
//	}
//
//	private void onCancel() {
//		uiHacks.killMeThenGoToLastPage(contentPane);
//	}
//
//	private void onChecked(JCheckBox userCheckBox) {
//		this.checkBoxes.add(userCheckBox);
//	}
//
//	public JPanel getContentPane() {
//		return contentPane;
//	}
//
//	private void onOK() {
//		if(checkBoxes != null) {
//			StringBuilder sb = new StringBuilder();
//			sb.append("Deleted Users: ");
//			Set<String> usernames = new HashSet<String>();
//
//			for(JCheckBox userCheckBox : checkBoxes) {
//				usernames.add(userCheckBox.getText());
//				if(userCheckBox.isSelected()) {
//					sb.append(userCheckBox.getText()).append(' ');
//				}
//			}
//
//			for(String user : usernames) {
//				userService.deleteUser(user);
//			}
//			// Display confirmation to user
//			JOptionPane.showMessageDialog(contentPane, String.format(MESSAGE_SUCCESS), JOptionPane.INFORMATION_MESSAGE);
//
//			//TODO: Navigate user away from page.
//			okButton.setEnabled(false);
//			uiHacks.killMeThenGoToLastPage(contentPane);
//		}
//		else {
//			JOptionPane.showMessageDialog(contentPane, PLEASE_CHECK_BOX, JOptionPane.ERROR_MESSAGE);
//		}
//	}
//
//}
//
//
