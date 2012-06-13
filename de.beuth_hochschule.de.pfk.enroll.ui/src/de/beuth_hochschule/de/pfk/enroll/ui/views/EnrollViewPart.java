package de.beuth_hochschule.de.pfk.enroll.ui.views;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

import de.beuth_hochschule.de.pfk.enroll.ui.Activator;
import de.beuth_hochschule.pfk.enroll.core.service.EnrollService;

public class EnrollViewPart extends ViewPart {

	private TreeViewer tree;
	private static EnrollViewPart INSTANCE;
	
	public static void refreshCurrentInstance(int lvl) {
		INSTANCE.refreshTree(lvl);
	}

	public EnrollViewPart() {
		INSTANCE = this;
	}

	@Override
	public void createPartControl(Composite parent) {
		parent.setLayout(new FillLayout());
		tree = new TreeViewer(parent, SWT.None);
		tree.setContentProvider(new EnrollViewContentProvider());
		tree.setLabelProvider(new EnrollViewLabelProvider());
		refreshTree(2);
	}

	private void refreshTree(int lvl) {
		EnrollService s = Activator.getDefault().getEnrollService();
		tree.setInput(new EnrollViewTreeInput(s.listStudents(), s.listCourses()));
		tree.expandToLevel(lvl);
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

}
