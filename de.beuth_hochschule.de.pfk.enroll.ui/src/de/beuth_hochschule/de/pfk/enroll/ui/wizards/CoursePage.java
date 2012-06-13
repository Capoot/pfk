package de.beuth_hochschule.de.pfk.enroll.ui.wizards;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;

import de.beuth_hochschule.de.pfk.enroll.ui.util.FormsUtility;

public class CoursePage extends WizardPage implements Listener {

	private Text titleText;
	private Text freeSlotsText;

	protected CoursePage(String pageName) {
		super(pageName);
	}

	@Override
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		container.setLayout(new GridLayout(3, false));
		
		titleText = FormsUtility.createLabeledText("Title", container, 2);
		freeSlotsText = FormsUtility.createLabeledText("Number of free slots", container, 2);
		titleText.addListener(SWT.Modify, this);
		freeSlotsText.addListener(SWT.Modify, this);
		
		setControl(container);
		setPageComplete(false);
		setMessage("Please enter the new student's data");
		setTitle("Create a new Student");
	}

	@Override
	public void handleEvent(Event event) {
		boolean freeSlotsValid = false;
		try {
			Integer.parseInt(freeSlotsText.getText());
			freeSlotsValid = true;
		} catch(NumberFormatException e) {
			// ignored
		}
		setPageComplete(!titleText.getText().isEmpty()
				&& freeSlotsValid);
	}

	public String getTitleText() {
		return titleText.getText();
	}
	
	public int getFreeSlots() {
		return Integer.parseInt(freeSlotsText.getText());
	}
}
