package Calculator;
import javax.swing.*;
import java.awt.*;//Layout
import java.awt.event.*;//action listener
import java.util.*;

public class MainGUI {

	public static void main(String[] args) {
		
		GUI obj = new GUI();
	}

}
class GUI extends JFrame implements ActionListener
{
	JLabel li,l1;
	JRadioButton b1,b2,b3,b4,b5,b6;
	public GUI()
	{
		JPanel introp=new JPanel();
		introp.setLayout(new FlowLayout(FlowLayout.CENTER,200,5));
		introp.setBackground(Color.RED);
		this.add(introp);
		
		JPanel pn = new JPanel();
		pn.setLayout(new FlowLayout(FlowLayout.CENTER,250,5));
		this.add(pn);
		pn.setBackground(Color.ORANGE);
		
		JPanel pope = new JPanel();
		pope.setLayout(new GridLayout(6,0));
		this.add(pope);
		pn.setBackground(Color.ORANGE);
		
		li=new JLabel("CLICK AND SOLVE");
		li.setFont(new Font("Serif",Font.BOLD,18));
		li.setForeground(Color.WHITE);
		
		l1=new JLabel(" -  A MATH TOOL ");
		
		b1=new JRadioButton("ARITHMETIC CALCULATOR");
		b2=new JRadioButton("COMPLEX NUMBERS CALCULATOR");
		b3=new JRadioButton("LCM AND GCD CALCULATOR");
		b4=new JRadioButton("STANDARD DEVIATION CALCULATOR");
		b5=new JRadioButton("MATRIX CALCULATOR");
		b6=new JRadioButton("UNIT CONVERTER");
		
		ButtonGroup bg=new ButtonGroup();
		bg.add(b1);
		bg.add(b2);
		bg.add(b3);
		bg.add(b4);
		bg.add(b5);
		bg.add(b6);
		
		introp.add(li);
		pn.add(l1);
		pope.add(b1);
		pope.add(b2);
		pope.add(b3);
		pope.add(b4);
		pope.add(b5);
		pope.add(b6);

		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		
		this.setLayout(new FlowLayout());
		setVisible(true);
		this.setBounds(700,10,650,300);		
		this.setTitle("CALCULATOR");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(b1.isSelected())
		{
			new GUI1();
		}
		else if(b2.isSelected())
		{
			new COMPLEX();
		}
		else if(b3.isSelected())
		{
			new GCD();
		}
		else if(b4.isSelected())
		{
			new STD();
		}
		else if(b5.isSelected())
		{
			new GUI2();
		}
		else if(b6.isSelected())
		{
			new Converter();
		}
	}
}
