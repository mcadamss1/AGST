package edu.nku.CSC440.stagbar.ui;

import javax.swing.*;
import java.awt.*;

/**
 * Temporary measures to ensure functionality
 */
public class uiHacks {

	public static void addNewPanel(JPanel currentPanel, JPanel newPanel) {
		JPanel masterPanel = getMasterPanel(currentPanel);
		masterPanel.add(newPanel);
		((CardLayout)masterPanel.getLayout()).last(masterPanel);
	}

	public static JFrame getContainingFrame(JPanel panel) {
		Component component = panel.getParent();
		while(component.getParent() != null) {
			component = component.getParent();
		}
		return (JFrame)component;
	}

	public static JPanel getMasterPanel(JPanel panel) {
		Component component = panel.getParent();
		while(null != component && !"Master".equals(component.getName())) {
			component = component.getParent();
		}
		return (JPanel)component;
	}

	public static void killMeThenGoToLastPage(JPanel panel) {
		JFrame containingFrame = getContainingFrame(panel);
		JPanel masterPanel = getMasterPanel(panel);
		masterPanel.remove(panel);
		((CardLayout)masterPanel.getLayout()).last(masterPanel);
		containingFrame.pack();
	}

	public static void repack(JPanel panel) {
		getContainingFrame(panel).pack();
	}

	public static void setTitle(JPanel panel) {
		getContainingFrame(panel).setTitle(String.format("STAGBAR - %s", panel.getName()));
	}

	public static void goToPanel(JPanel currentPanel, JPanel newPanel){
		uiHacks.addNewPanel(currentPanel, newPanel);
		uiHacks.setTitle(newPanel);
		uiHacks.repack(newPanel);
	}

}