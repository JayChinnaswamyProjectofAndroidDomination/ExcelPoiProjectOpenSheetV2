import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;


public class PanelButton extends JButton  implements ActionListener
{
	DateTestingPanel myPanel;
	
	public PanelButton(DateTestingPanel p, String text){
		super(text);
		myPanel = p;
		addActionListener(this);
	}

	
	public void actionPerformed(ActionEvent e) {
		System.out.println("I pushed the button...");
		System.out.println("The day is..."+ myPanel.getDayFieldText());
		System.out.println("The hour is..." + myPanel.getHourFieldText());
		System.out.println("The minute is..." + myPanel.getMinuteFieldText());
		

		
		ArrayList<String> classInfo = myPanel.getEKO().getTheClass("AnyMonth", "AnyDate",
				myPanel.getDayFieldText(),
				myPanel.getHourFieldText(),
				myPanel.getMinuteFieldText()
				);
		
		
		myPanel.setClassActivty(classInfo.get(0));
		myPanel.setTheColor(classInfo.get(1));
	}

}
