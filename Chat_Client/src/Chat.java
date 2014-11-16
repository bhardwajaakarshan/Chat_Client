import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.ControlListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;

import javax.*;
import javax.sound.*;

import java.awt.*;
import java.awt.event.*;


public class Chat {

	protected Shell shlStudentTeacherChat;
	private static Text text;
	private static Text text_1;
	private final FormToolkit formToolkit = new FormToolkit(Display.getDefault());

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Chat window = new Chat();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	static class Mouse implements MouseListener{
				
		public void mouseDoubleClick(MouseEvent e) {
		}

		public void mouseDown(MouseEvent e) {
			String temp1 = Chat.text.getText();
			String temp2 = Chat.text_1.getText();
			Chat.text.append("\nStudent: " + temp2);	
		}

		public void mouseUp(MouseEvent e) {
			String temp1 = Chat.text.getText();
			String temp2 = Chat.text_1.getText();
			Chat.text_1.setText("");
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlStudentTeacherChat.open();
		shlStudentTeacherChat.layout();
		while (!shlStudentTeacherChat.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlStudentTeacherChat = new Shell();
		shlStudentTeacherChat.setImage(SWTResourceManager.getImage("C:\\Users\\The Mamba\\Pictures\\apple.jpg"));
		shlStudentTeacherChat.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		shlStudentTeacherChat.setSize(450, 300);
		shlStudentTeacherChat.setText("Student Teacher Chat Client");
		
		text = new Text(shlStudentTeacherChat, SWT.READ_ONLY | SWT.WRAP | SWT.V_SCROLL);
		text.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_HIGHLIGHT_SHADOW));
		text.setFont(SWTResourceManager.getFont("Arial", 9, SWT.NORMAL));
		text.setBounds(10, 40, 414, 90);
		
		text_1 = new Text(shlStudentTeacherChat, SWT.BORDER | SWT.WRAP | SWT.V_SCROLL);
		text_1.setFont(SWTResourceManager.getFont("Arial", 9, SWT.NORMAL));
		text_1.setBounds(10, 157, 230, 94);
		
		Button btnSubmit = new Button(shlStudentTeacherChat, SWT.NONE);
		btnSubmit.setFont(SWTResourceManager.getFont("Arial", 9, SWT.NORMAL));
		btnSubmit.setBounds(280, 189, 75, 25);
		btnSubmit.setText("Submit");
		btnSubmit.addMouseListener(new Mouse());
		
		Label lblEnterTextBelow = formToolkit.createLabel(shlStudentTeacherChat, "Enter Text Below", SWT.NONE);
		lblEnterTextBelow.setFont(SWTResourceManager.getFont("Arial", 9, SWT.NORMAL));
		lblEnterTextBelow.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		lblEnterTextBelow.setBounds(10, 136, 93, 15);
		
		Label lblChat = formToolkit.createLabel(shlStudentTeacherChat, "Chat", SWT.NONE);
		lblChat.setFont(SWTResourceManager.getFont("Arial", 9, SWT.NORMAL));
		lblChat.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		lblChat.setBounds(10, 19, 31, 15);

	}
}
