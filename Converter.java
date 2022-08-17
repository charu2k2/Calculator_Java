package Calculator;

import java.awt.FlowLayout;
import java.awt.event.*;

import javax.swing.*;
// main class where the frame is created - l,m,t
//public class MAIN {
//	public static void main(String[] args) {
//		Converter cobj= new Converter();
//	}
//}
class Converter extends JFrame implements ActionListener {
	JLabel lz;
//	JButton b;
	JRadioButton b1,b2,b3,b4;
	
	public Converter(){
		
		lz = new JLabel("UNIT CONVERTER");
		
//		b=new JButton("GO");
		b1=new JRadioButton("Length");
		b2=new JRadioButton("Mass");
		b3=new JRadioButton("Time");
		b4=new JRadioButton("Temperature");

		ButtonGroup bg = new ButtonGroup();
		bg.add(b1);
		bg.add(b2);
		bg.add(b3);
		bg.add(b4);
		
		this.add(lz);
		this.add(b1);
		this.add(b2);
		this.add(b3);
		this.add(b4);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		
		setTitle("UNIT CONVERSION");
		setLayout(new FlowLayout());
		setVisible(true);
		//setSize(650,400);
		setBounds(700,10,650,400);	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(b1.isSelected())
		{
			//go to the length frame
			Length lx = new Length();
		}
		else if(b2.isSelected())
		{
			//go to the mass frame
			Mass mx=new Mass();
		}
		else if(b3.isSelected())
		{
			//go to the time frame
			Time tx = new Time();
		}
		else if(b4.isSelected())
		{
			Temperature temx=new Temperature();
		}
	}
}
