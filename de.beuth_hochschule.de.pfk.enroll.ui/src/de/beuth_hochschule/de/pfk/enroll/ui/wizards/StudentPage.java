package de.beuth_hochschule.de.pfk.enroll.ui.wizards;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;

import de.beuth_hochschule.de.pfk.enroll.ui.util.FormsUtility;

public class StudentPage extends WizardPage implements Listener {

	private Text nameText;
	private Text firstNameText;
	private Text matNrText;

	protected StudentPage(String title) {
		super(title);
	}

	@Override
	public void createControl(Composite parent) {
		
		Composite container = new Composite(parent, SWT.NONE);
		container.setLayout(new GridLayout(3, false));
		
		nameText = FormsUtility.createLabeledText("Name", container, 2);
		firstNameText = FormsUtility.createLabeledText("Firstname", container, 2);
		matNrText = FormsUtility.createLabeledText("Matriculation no.", container, 2);
		nameText.addListener(SWT.Modify, this);
		firstNameText.addListener(SWT.Modify, this);
		matNrText.addListener(SWT.Modify, this);
		
		setControl(container);
		setPageComplete(false);
		setMessage("Please enter the new student's data");
		setTitle("Create a new Student");
	}

	@Override
	public void handleEvent(Event event) {
		boolean matNrValid = false;
		try {
			Integer.parseInt(matNrText.getText());
			matNrValid = true;
		} catch(NumberFormatException e) {
			// ignored
		}
		setPageComplete(!nameText.getText().isEmpty()
				&& !firstNameText.getText().isEmpty()
				&& matNrValid);
	}
	
	public String getFirstName() {
		return firstNameText.getText();
	}
	
	public String getLastName() {
		return nameText.getText();
	}
	
	public int getMatNr() {
		return Integer.parseInt(matNrText.getText());
	}
}

	
