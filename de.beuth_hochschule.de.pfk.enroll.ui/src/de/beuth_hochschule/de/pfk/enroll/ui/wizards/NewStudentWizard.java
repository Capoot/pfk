package de.beuth_hochschule.de.pfk.enroll.ui.wizards;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.SWT;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;

import de.beuth_hochschule.de.pfk.enroll.ui.Activator;
import de.beuth_hochschule.de.pfk.enroll.ui.views.EnrollViewPart;
import de.beuth_hochschule.pfk.enroll.core.service.EnrollService;

public class NewStudentWizard extends Wizard implements INewWizard {

	private StudentPage page = new StudentPage("Student Data");

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		setNeedsProgressMonitor(false);
		setWindowTitle("New Student");
	}

	@Override
	public boolean performFinish() {
		
		EnrollService service = Activator.getDefault().getEnrollService();
		
		try {
			service.createStudent(page.getLastName(), page.getFirstName(), page.getMatNr());
		} catch(Exception e) {
			MessageDialog.open(
					MessageDialog.ERROR,
					PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
					"Error",
					e.getMessage(),
					SWT.NONE);
			return false;
		}
		
		EnrollViewPart.refreshCurrentInstance(2);
		return true;
	}

	@Override
	public void addPages() {
		addPage(page);
	}
}
