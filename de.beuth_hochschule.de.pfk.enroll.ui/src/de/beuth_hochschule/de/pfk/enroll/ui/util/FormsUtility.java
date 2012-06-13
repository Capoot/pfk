package de.beuth_hochschule.de.pfk.enroll.ui.util;

import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

/**
 * Utility helper class for form elements specifically used in the eclipse solr plugin.
 * @author Julian Heise
 */
public class FormsUtility {

	
	/**
	 * Creates a new Combo inside the given parent. The combo's list will be initialized with the values
	 * "", "true" and "false". The combo is read-only and single-selection flagged. No layout data will
	 * be applied. 
	 * @param parent parent composite to create combo in
	 * @return generated combo-box with boolean (text-) values
	 */
	public static Combo createBooleanReadOnlyCombo(Composite parent) {
		return createBooleanCombo(parent, SWT.SINGLE | SWT.READ_ONLY);
	}
	
	/**
	 * Creates a new Combo inside the given parent. The combo's list will be initialized with the values
	 * "", "true" and "false". The combo is modifyable and single-selection flagged. No layout data will
	 * be applied. 
	 * @param parent parent composite to create combo in
	 * @return generated combo-box with boolean (text-) values
	 */
	public static Combo createModifyableBooleanCombo(Composite parent) {
		return createBooleanCombo(parent, SWT.SINGLE);
	}
	
	private static Combo createBooleanCombo(Composite parent, int style) {
		Combo combo = new Combo(parent, style);
		combo.add("");
		combo.add("true");
		combo.add("false");
		return combo;
	}

	public static void selectComboItem(Combo combo, Object value) {
		if(value == null)
			return;
		int index = combo.indexOf(value.toString());
		combo.select(index);
	}

	/**
	 * Sets the text of a Text control to the given value only if it's not null.
	 * @param text
	 * @param value
	 */
	public static void setTextControlText(Text text, Object value) {
		if(value == null)
			return;
		text.setText(value.toString());
	}
	
	public static void putComboItems(Combo combo, Iterable<String> items) {
		if(items == null)
			return;
		for(String s : items) {
			combo.add(s);
		}
	}

	public static String getSelectedComboItem(Combo combo) {
		int index = combo.getSelectionIndex();
		if(index >= combo.getItemCount() || index < 0)
			return null;
		return combo.getItem(index);
	}
	
	public static GridData getNoGrabGridData() {
		return new GridData(SWT.LEFT, SWT.CENTER, false, false);
	}
	
	public static GridData getFillGrabGridData(int colspan) {
		return new GridData(SWT.FILL, SWT.CENTER, true, false, colspan, 1);
	}
	
	public static Text createLabeledText(String labelText, Composite parent) {
		return createLabeledText(labelText, parent, 1);
	}
	
	public static Text createLabeledText(String labelText, Composite parent,
			int colspan) {

		Label label = new Label(parent, SWT.NONE);
		label.setText(labelText);
		label.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
		
		Text text = new Text(parent, SWT.BORDER);
		text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, colspan, 1));
		
		return text;
	}
	
	public static Combo createLabeledCombo(Composite parent, String labelText,
			List<String> items) {
		
		Label label = new Label(parent, SWT.NONE);
		label.setText(labelText);
		label.setLayoutData(getNoGrabGridData());
		
		Combo combo = new Combo(parent, SWT.SINGLE | SWT.READ_ONLY);
		putComboItems(combo, items);
		combo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		
		return combo;
	}
}
