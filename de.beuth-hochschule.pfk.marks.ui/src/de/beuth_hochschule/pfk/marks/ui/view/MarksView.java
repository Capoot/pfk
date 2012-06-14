package de.beuth_hochschule.pfk.marks.ui.view;

import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.part.ViewPart;

import de.beuth_hochschule.pfk.enroll.core.service.EnrollService;
import de.beuth_hochschule.pfk.enroll.core.service.EnrollmentChangedListener;
import de.beuth_hochschule.pfk.marks.core.service.MarksService;
import de.beuth_hochschule.pfk.marks.ui.Activator;

public class MarksView extends ViewPart implements EnrollmentChangedListener {

	private static MarksView INSTANCE;
	
	public static void refreshCurrentInstance() {
		INSTANCE.refreshTable();
	}

	private TableViewer viewer;
	
	public MarksView() {
		INSTANCE = this;
		EnrollService service = Activator.getDefault().getEnrollService();
		service.addEnrollmentChangedListener(this);
	}

	@Override
	public void createPartControl(Composite parent) {
		parent.setLayout(new FillLayout());
		viewer = new TableViewer(parent, SWT.SINGLE | SWT.BORDER);
		Table table = viewer.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		TableColumn studentColumn = new TableColumn(table, SWT.LEFT, 0);
		studentColumn.setText("Student");
		studentColumn.setWidth(200);
		TableColumn courseColumn = new TableColumn(table, SWT.LEFT, 1);
		courseColumn.setText("Course");
		courseColumn.setWidth(200);
		TableColumn markColumn = new TableColumn(table, SWT.LEFT, 2);
		markColumn.setText("Mark");
		markColumn.setWidth(100);
		viewer.setContentProvider(new MarksViewContentProvider());
		viewer.setLabelProvider(new MarksViewLabelProvider());
		
		refreshTable();
	}

	private void refreshTable() {
		MarksService marksService = Activator.getDefault().getMarksService();
		viewer.setInput(new MarksViewTableInput(marksService));
	}

	@Override
	public void setFocus() {
	}

	@Override
	public void enrollmentChanged() {
		refreshTable();
	}
}
