package Calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.*;
//import
public class Temperature extends JFrame implements ActionListener {
	
	JTextField input;
	JLabel from,to,res;
	JButton convert;
	JRadioButton c,f,k,c1,f1,k1;
//	JPanel panel=new JPanel();
	
	public Temperature(){
		input= new JTextField(10);
		
		from=new JLabel("From\n");
		to = new JLabel("To");
		res= new JLabel("RESULT    ");
		
		res.setBackground(Color.blue);
		convert = new JButton("Convert");
		
		c=new JRadioButton("celcius");
		f=new JRadioButton("fahrenheit");
		k=new JRadioButton("kelvin");
		
		c1=new JRadioButton("celcius");
		f1=new JRadioButton("fahrenheit");
		k1=new JRadioButton("kelvin");
		

		
		ButtonGroup fromgrp = new ButtonGroup();
		fromgrp.add(c);
		fromgrp.add(f);
		fromgrp.add(k);
		
		ButtonGroup togrp = new ButtonGroup();
		togrp.add(c1);
		togrp.add(f1);
		togrp.add(k1);
		
		
//		JPanel panel=new JPanel(new GridLayout());
//		panel.setLayout((LayoutManager) new FlowLayout(FlowLayout.CENTER,10,5));
//		this.add(panel,BorderLayout.CENTER);
//		panel.setBackground(Color.GRAY);
		
		JPanel fromto =new JPanel(new GridLayout());
		fromto.setLayout((LayoutManager) new GridLayout(0,1));
		this.add(fromto);
//		fromto.setBackground(Color.yellow);
		
//		JPanel chumma1 =new JPanel(new)
		JPanel fromto1 =new JPanel(new GridLayout());
		fromto1.setLayout((LayoutManager) new GridLayout(0,1));
		this.add(fromto1);
//		fromto1.setBackground(Color.yellow);
		
		fromto.add(input);
		fromto.add(from);//label
		fromto.add(c);
		fromto.add(f);
		fromto.add(k);
		
		
		fromto1.add(res);
		fromto1.add(to);
		fromto1.add(c1);
		fromto1.add(f1);
		fromto1.add(k1);
		
		c.addActionListener(this);
		f.addActionListener(this);
		k.addActionListener(this);
		
		
		c1.addActionListener(this);
		f1.addActionListener(this);
		k1.addActionListener(this);
		
		setTitle("Temperature");
		setLayout(new GridLayout(1,2,10,10));
		setVisible(true);
		//setSize(650,400);
		setBounds(700,10,650,400);	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	
	public void actionPerformed(ActionEvent ae) {
		double val=Double.parseDouble(input.getText());
		//double inKG=tokelvin(val);
		double converted=convert(val);
//		System.out.println(converted);
		res.setText(converted+"");
		
		
	}
	
	double convert(double val)
	  {
		if(c.isSelected())
		{
			if(f1.isSelected())
				return (val*9/5 +32);
			else if(k1.isSelected())
				return (val+273.15);
		}
		else if(f.isSelected())
		{
			if(c1.isSelected())
				return ((val-32)*5/9);
			else if(k1.isSelected())
				return ((val-32)*5/9 +32);
		}
		else if(k.isSelected())
		{
			if(c1.isSelected())
				return (val-273.15);
			else if(f1.isSelected())
				return ((val-273.15)*9/5)+32;
//			else if(k1.isSelected())
//				return ((val-32)*(5/9) +32);
		}
		return val;
		
	  }
	}