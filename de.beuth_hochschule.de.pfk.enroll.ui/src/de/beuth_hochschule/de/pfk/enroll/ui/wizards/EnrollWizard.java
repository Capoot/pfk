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
import de.beuth_hochschule.pfk.enroll.core.businessLogic.Course;
import de.beuth_hochschule.pfk.enroll.core.businessLogic.Student;
import de.beuth_hochschule.pfk.enroll.core.service.EnrollService;

public class EnrollWizard extends Wizard implements INewWizard {

	private EnrollPage page = new EnrollPage("Enroll Page");
	
	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		setNeedsProgressMonitor(false);
		setWindowTitle("Enroll");
	}

	@Override
	public boolean performFinish() {
		
		EnrollService service = Activator.getDefault().getEnrollService();
		
		try {
			Student s = service.getStudent(page.getMatNr());
			Course c = service.getCourse(page.getCourseId());
			service.enroll(s, c);
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
