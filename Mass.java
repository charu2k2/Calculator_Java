package Calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.*;
//import
public class Mass extends JFrame implements ActionListener {
	
	JTextField input;
	JLabel from,to,res;
	JButton convert;
	JRadioButton t,mg,g,kg,p,o,t1,mg1,g1,kg1,p1,o1;
//	JPanel panel=new JPanel();
	
	public Mass(){
		input= new JTextField(10);
		
		from=new JLabel("From\n");
		to = new JLabel("To");
		res= new JLabel("RESULT    ");
		
		res.setBackground(Color.blue);
		convert = new JButton("Convert");
		
		t=new JRadioButton("Tonne");
		mg=new JRadioButton("milligram");
		g=new JRadioButton("gram");
		kg=new JRadioButton("kg");
		p=new JRadioButton("pounds");
		o=new JRadioButton("ounce");
		
		t1=new JRadioButton("Tonne");
		mg1=new JRadioButton("milligram");
		g1=new JRadioButton("gram");
		kg1=new JRadioButton("kg");
		p1=new JRadioButton("pounds");
		o1=new JRadioButton("ounce");

		
		ButtonGroup fromgrp = new ButtonGroup();
		fromgrp.add(t);
		fromgrp.add(mg);
		fromgrp.add(g);
		fromgrp.add(kg);
		fromgrp.add(p);
		fromgrp.add(o);
		
		ButtonGroup togrp = new ButtonGroup();
		togrp.add(t1);
		togrp.add(mg1);
		togrp.add(g1);
		togrp.add(kg1);
		togrp.add(p1);
		togrp.add(o1);
		
		
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
		fromto.add(t);
		fromto.add(mg);
		fromto.add(g);
		fromto.add(kg);
		fromto.add(p);
		fromto.add(o);
		
		
		fromto1.add(res);
		fromto1.add(to);
		fromto1.add(t1);
		fromto1.add(mg1);
		fromto1.add(g1);
		fromto1.add(kg1);
		fromto1.add(p1);
		fromto1.add(o1);
		
		t.addActionListener(this);
		mg.addActionListener(this);
		g.addActionListener(this);
		kg.addActionListener(this);
		p.addActionListener(this);
		o.addActionListener(this);
		
		t1.addActionListener(this);
		mg1.addActionListener(this);
		g1.addActionListener(this);
		kg1.addActionListener(this);
		p1.addActionListener(this);
		o1.addActionListener(this);
		
		setTitle("mass");
		setLayout(new GridLayout(1,2,10,10));
		setVisible(true);
		setBounds(700,10,650,400);	
		//setSize(650,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	
	public void actionPerformed(ActionEvent ae) {
		double val=Double.parseDouble(input.getText());
		double inKG=tokg(val);
		double converted=fromkg(inKG);
//		System.out.println(converted);
		res.setText(converted+"");
	}
	
	double tokg(double val)
	  {
	    if(t.isSelected())
	    {
	      return val*1000;
	    }
	    else if(g.isSelected())
	    {
	      return val*0.001;
	    }
	    else if(mg.isSelected())
	    {
	      return val*0.000001;
	    }
	    else if(p.isSelected())
	    {
	      return val*0.45359237;
	    }
	    else if(o.isSelected())
	    {
	      return val*0.0283495;
	    }
	    else
	    {
	      return val;
	    }
	  }
	  double fromkg(double val)
	  {
	    if(t1.isSelected())
	    {
	      return val*0.001;
	    }
	    else if(g1.isSelected())
	    {
	      return val*1000;
	    }
	    else if(mg1.isSelected())
	    {
	      return val*1000000;
	    }
	    else if(p1.isSelected())
	    {
	      return val*2.204620823516057;
	    }
	    else if(o1.isSelected())
	    {
	      return val*35.273933176256910826;
	    }
	    else
	    {
	      return val;
	    }
	  }

}
