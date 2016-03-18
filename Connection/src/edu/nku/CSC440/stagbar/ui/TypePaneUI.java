package edu.nku.CSC440.stagbar.ui;

import edu.nku.CSC440.stagbar.dataaccess.Alcohol;
import edu.nku.CSC440.stagbar.dataaccess.CustomAlcoholType;
import edu.nku.CSC440.stagbar.dataaccess.Entry;

import javax.swing.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TypePaneUI {
	Map<Integer, EntryRowUI> rowUIMap;
	private JPanel contentPane;
	private JPanel rowPane;
	private CustomAlcoholType type;
	private JLabel typeLabel;

	public TypePaneUI(CustomAlcoholType type) {
		this.type = type;
		typeLabel.setText(type.getName());
		rowUIMap = new HashMap<>();
	}

	public void addEntryRow(Alcohol alcohol) {
		EntryRowUI entryRow = new EntryRowUI(alcohol);
		rowUIMap.put(alcohol.getAlcoholId(), entryRow);
		rowPane.add(entryRow.getContentPane());
	}

	private void createUIComponents() {
		rowPane = new JPanel();
		rowPane.setLayout(new BoxLayout(rowPane, BoxLayout.Y_AXIS));
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public Set<Entry> getEntries() {
		boolean failure = false;
		Set<Entry> entries = new HashSet<>();
		for(EntryRowUI entryRow : rowUIMap.values()) {
			try {
				entries.add(entryRow.getEntry());
			} catch(IllegalStateException e) {
				failure = true;
			}
		}
		if(failure) throw new IllegalStateException(type.toString());

		return entries;
	}

	public CustomAlcoholType getType() {
		return type;
	}

	public void removeEntryRow(int alcoholId) {
		EntryRowUI entryRow = rowUIMap.remove(alcoholId);
		rowPane.remove(entryRow.getContentPane());
	}

	@Override
	public String toString() {
		return type + " Pane";
	}

}