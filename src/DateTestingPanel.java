import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class DateTestingPanel extends JPanel implements ActionListener {
	
	int panelW, panelH;
	Color c;
	
	PanelButton b;
	JLabel dayLabel, hourLabel, minuteLabel, whatClassLabel;
	JTextField dayField, hourField, minuteField, whatClassField;
	JPanel dayPanel, hourPanel, minutePanel, whatClassPanel;
	
	ExcelKnowledgeObject EKO;	
	public DateTestingPanel (int w, int h){
		panelW =w; 
		panelH = h;
		c = new Color (75+(int)(Math.random()* 100),150+(int)(Math.random()* 100), 150+ (int)(Math.random()* 100));
		this.setBackground(c);
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS) );
		
		
		//setUpLabels
		dayLabel = new JLabel("Day");
		hourLabel = new JLabel("Hour");
		minuteLabel = new JLabel("Minute");
		whatClassLabel = new JLabel("Class//Activity");
		
		//setUpFields
		dayField = new JTextField("What Day");
		hourField = new JTextField("What Hour");
		minuteField = new JTextField("What Minute");
		whatClassField = new JTextField("What Class//Activity");
		
		
		//setUpOrganizingPanels
		
		dayPanel = new JPanel();
		hourPanel = new JPanel();
		minutePanel = new JPanel();
		whatClassPanel = new JPanel();
		//setColor

		dayPanel.setBackground(c);
		hourPanel.setBackground(c);
		minutePanel.setBackground(c);
		whatClassPanel.setBackground(c);
		
		dayPanel.add(dayLabel);
		dayPanel.add(dayField);
		hourPanel.add(hourLabel);
		hourPanel.add(hourField);
		minutePanel.add(minuteLabel);
		minutePanel.add(minuteField);
		whatClassPanel.add(whatClassLabel);
		whatClassPanel.add(whatClassField);
		
		this.add(dayPanel);
		this.add(hourPanel);
		this.add(minutePanel);
		this.add(whatClassPanel);
		
		b = new PanelButton(this, "Push To see what class it is");
		this.add(b);
		
		EKO = new ExcelKnowledgeObject();
		
	}
	
	
	//whenTheButton is Pressed do something...
	public void actionPerformed(ActionEvent e) {
	
		
		System.out.println("the command is " + e.getActionCommand());
		
	}
	
	
	public String getDayFieldText(){
		return dayField.getText();
	}
	
	public String getHourFieldText(){
		return hourField.getText();
	}
	
	public String getMinuteFieldText(){
		return minuteField.getText();
	}
	
	public ExcelKnowledgeObject getEKO(){
		return EKO;
	}
	
	public void setClassActivty(String whatActivity){
		whatClassField.setText(whatActivity);
	}
	
	public void setTheColor(String whatColor){
		
		Color newColor = new Color(165, 160, 120);
		
		if(whatColor.matches("Red")){
			newColor = Color.RED;
			
		}
		
		if(whatColor.matches("Blue")){
			newColor = Color.BLUE;
			
		}
		
		if(whatColor.matches("Yellow")){
			newColor = Color.YELLOW;
			
		}
		
		if(whatColor.matches("Green")){
			newColor = Color.GREEN;
			
		}
		
		if(whatColor.matches("Orange")){
			newColor = Color.ORANGE;
			
		}
		
		
		if(whatColor.matches("Brown")){
			newColor = new Color (140, 75, 30);
			
		}
		
		
		if(whatColor.matches("Plum")){
			newColor = new Color (165, 14, 173);
			
		}
		dayPanel.setBackground(newColor);
		hourPanel.setBackground(newColor);
		minutePanel.setBackground(newColor);
		whatClassPanel.setBackground(newColor);
		this.setBackground(newColor);
		c = newColor;
		
		
		
	}
	

}
