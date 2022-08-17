package Calculator;


import javax.swing.*;
import java.awt.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.*;

public class Length extends JFrame implements ActionListener {
	
	JTextField input;
	JLabel from,to,res;
	JButton convert;
	JRadioButton mm,cm,m,km,inch,mile,yard,foot,mm1,cm1,m1,km1,inch1,mile1,yard1,foot1;
//	JPanel panel=new JPanel();
	
	public Length(){
		input= new JTextField(10);
		
		from=new JLabel("From\n");
		to = new JLabel("To");
		res= new JLabel("RESULT    ");
		
		res.setBackground(Color.blue);
		convert = new JButton("Convert");
		
		mm=new JRadioButton("mm");
		cm=new JRadioButton("cm");
		m=new JRadioButton("m");
		km=new JRadioButton("km");
		inch=new JRadioButton("inch");
		mile=new JRadioButton("mile");
		yard=new JRadioButton("yard");
		foot=new JRadioButton("foot");
		
		mm1=new JRadioButton("mm");
		cm1=new JRadioButton("cm");
		m1=new JRadioButton("m");
		km1=new JRadioButton("km");
		inch1=new JRadioButton("inch");
		mile1=new JRadioButton("mile");
		yard1=new JRadioButton("yard");
		foot1=new JRadioButton("foot");
		
		ButtonGroup fromgrp = new ButtonGroup();
		fromgrp.add(mm);
		fromgrp.add(cm);
		fromgrp.add(m);
		fromgrp.add(km);
		fromgrp.add(inch);
		fromgrp.add(mile);
		fromgrp.add(yard);
		fromgrp.add(foot);
		
		ButtonGroup togrp = new ButtonGroup();
		togrp.add(mm1);
		togrp.add(cm1);
		togrp.add(m1);
		togrp.add(km1);
		togrp.add(inch1);
		togrp.add(mile1);
		togrp.add(yard1);
		togrp.add(foot1);
		
		
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
		fromto.add(mm);
		fromto.add(cm);
		fromto.add(m);
		fromto.add(km);
		fromto.add(inch);
		fromto.add(mile);
		fromto.add(yard);
		fromto.add(foot);

		fromto1.add(res);
		fromto1.add(to);
		fromto1.add(mm1);
		fromto1.add(cm1);
		fromto1.add(m1);
		fromto1.add(km1);
		fromto1.add(inch1);
		fromto1.add(mile1);
		fromto1.add(yard1);
		fromto1.add(foot1);

		
		mm.addActionListener(this);
		cm.addActionListener(this);
		km.addActionListener(this);
		m.addActionListener(this);
		inch.addActionListener(this);
		mile.addActionListener(this);
		yard.addActionListener(this);
		foot.addActionListener(this);
		
		mm1.addActionListener(this);
		cm1.addActionListener(this);
		m1.addActionListener(this);
		km1.addActionListener(this);
		inch1.addActionListener(this);
		mile1.addActionListener(this);
		yard1.addActionListener(this);
		foot1.addActionListener(this);
		
		
		setTitle("length");
		setLayout(new GridLayout(1,2,10,10));
		setVisible(true);
		//setSize(650,400);
		setBounds(700,10,650,400);	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	
	public void actionPerformed(ActionEvent ae) {
		double val=Double.parseDouble(input.getText());
		double inMeters=tometer(val);
		double converted=frommeter(inMeters);
//		System.out.println(converted);
		res.setText(converted+"");
	}
	
	public double tometer(double val)
	  {
	      if(mm.isSelected())
	      {
	        return val*0.001;
	      }
	      else if(cm.isSelected())
	      {
	        return val*0.01;
	      }
	      else if(km.isSelected())
	      {
	        return val*1000;
	      }
	      else if(inch.isSelected())
	      {
	        return val*0.0254;
	      }
	      else if(mile.isSelected())
	      {
	        return val*1609.3444;
	      }
	      else if(yard.isSelected())
	      {
	        return val*0.9144;
	      }
	      else if(foot.isSelected())
	      {
	        return val*0.3048;
	      }
	      else 
	        return val;
	  }

	  public double frommeter(double val)
	  {
	      if(mm1.isSelected())
	      {
	        return val*1000;
	      }
	      else if(cm1.isSelected())
	      {
	        return val*100;
	      }
	      else if(km1.isSelected())
	      {
	        return val*0.001;
	      }
	      else if(inch1.isSelected())
	      {
	        return val*39.370078740158;
	      }
	      else if(mile1.isSelected())
	      {
	        return val*0.000621371192;
	      }
	      else if(yard1.isSelected())
	      {
	        return val*1.0936132983;
	      }
	      else if(foot1.isSelected())
	      {
	        return val*3.280839895;
	      }
	      else 
	        return val;
	  }
}