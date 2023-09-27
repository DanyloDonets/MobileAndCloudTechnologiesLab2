package swtwork;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class lb2 {
	private Text solution1Text;
	private Text solution2Text;
	private Text solution3Text;
	private Boolean x;
	private Boolean y;
	private Boolean z;
	
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			lb2 window = new lb2();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		Shell shlLab = new Shell();
		shlLab.setSize(191, 248);
		shlLab.setText("Lab2");
		
		solution1Text = new Text(shlLab, SWT.BORDER);
		solution1Text.setBounds(92, 122, 76, 21);
		
		solution2Text = new Text(shlLab, SWT.BORDER);
		solution2Text.setBounds(92, 149, 76, 21);
		
		Label labelX = new Label(shlLab, SWT.NONE);
		labelX.setBounds(7, 24, 16, 15);
		labelX.setText("X");
		
		solution3Text = new Text(shlLab, SWT.BORDER);
		solution3Text.setBounds(92, 178, 76, 21);
		
		Label labelY = new Label(shlLab, SWT.NONE);
		labelY.setText("Y");
		labelY.setBounds(7, 41, 16, 15);
		
		Label labelZ = new Label(shlLab, SWT.NONE);
		labelZ.setText("Z");
		labelZ.setBounds(7, 58, 16, 15);
		
		
		
		Button checkX = new Button(shlLab, SWT.CHECK);
		checkX.setBounds(28, 23, 16, 16);
		
		Button checkY = new Button(shlLab, SWT.CHECK);
		checkY.setBounds(28, 41, 16, 16);
		
		Button checkZ = new Button(shlLab, SWT.CHECK);
		checkZ.setBounds(28, 61, 16, 16);
		
		
		Button clearBtn = new Button(shlLab, SWT.NONE);
		clearBtn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				checkX.setSelection(false);
				checkY.setSelection(false);
				checkZ.setSelection(false);
				solution1Text.setText("");
				solution2Text.setText("");
				solution3Text.setText("");
			}
		});
		clearBtn.setBounds(69, 36, 75, 25);
		clearBtn.setText("Clear");
		
		Button countBtn = new Button(shlLab, SWT.NONE);
		countBtn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				x = checkX.getSelection();
				y = checkY.getSelection();
				z = checkZ.getSelection();
				solution1Text.setText(task1().toString());
				solution2Text.setText(task2().toString());
				solution3Text.setText(task3().toString());
			}
		});
		countBtn.setBounds(39, 83, 75, 25);
		countBtn.setText("Count");
		
		Label task1Label = new Label(shlLab, SWT.NONE);
		task1Label.setBounds(7, 122, 55, 15);
		task1Label.setText("X or Y and !Z");
		
		Label task2Label = new Label(shlLab, SWT.NONE);
		task2Label.setBounds(7, 155, 55, 15);
		task2Label.setText("!X and !Y");
		
		Label task3Label = new Label(shlLab, SWT.NONE);
		task3Label.setBounds(7, 184, 55, 15);
		task3Label.setText("!(X and Z) or Y");
		
		Label lblWriteXY = new Label(shlLab, SWT.NONE);
		lblWriteXY.setBounds(7, 3, 137, 15);
		lblWriteXY.setText("Write X Y Z (true or false)");

		shlLab.open();
		shlLab.layout();
		while (!shlLab.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
	
	private Boolean task1() {
		Boolean result;
		result = x || (y && !z);
		return result;
	}
	
	private Boolean task2() {
		Boolean result;
		result = !x && !y;
		return result;
	}
	
	private Boolean task3() {
		Boolean result;
		result = !(x && z) || y;
		return result;
	}
	
}
