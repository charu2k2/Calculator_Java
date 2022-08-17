package Calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.*;
//import
public class Time extends JFrame implements ActionListener {
	
	JTextField input;
	JLabel from,to,res;
	JButton convert;
	JRadioButton ms,s,m,hr,d,w,month,y,dec,cen,ms1,s1,m1,hr1,d1,w1,month1,y1,dec1,cen1;
//	JPanel panel=new JPanel();
	
	public Time(){
		input= new JTextField(10);
		
		from=new JLabel("From\n");
		to = new JLabel("To");
		res= new JLabel("RESULT    ");
		
		res.setBackground(Color.blue);
		convert = new JButton("Convert");
		
		ms=new JRadioButton("millisecond");
		s=new JRadioButton("seconds");
		m=new JRadioButton("minutes");
		hr=new JRadioButton("hours");
		d=new JRadioButton("days");
		w=new JRadioButton("weeks");
		month=new JRadioButton("months");
		y=new JRadioButton("years");
		dec=new JRadioButton("decades");
		cen=new JRadioButton("century");
		
		ms1=new JRadioButton("millisecond");
		s1=new JRadioButton("seconds");
		m1=new JRadioButton("minutes");
		hr1=new JRadioButton("hours");
		d1=new JRadioButton("days");
		w1=new JRadioButton("weeks");
		month1=new JRadioButton("months");
		y1=new JRadioButton("years");
		dec1=new JRadioButton("decades");
		cen1=new JRadioButton("century");
		
		
		ButtonGroup fromgrp = new ButtonGroup();
		fromgrp.add(ms);
		fromgrp.add(s);
		fromgrp.add(m);
		fromgrp.add(hr);
		fromgrp.add(d);
		fromgrp.add(w);
		fromgrp.add(month);
		fromgrp.add(y);
		fromgrp.add(dec);
		fromgrp.add(cen);
		
		ButtonGroup togrp = new ButtonGroup();
		togrp.add(ms1);
		togrp.add(s1);
		togrp.add(m1);
		togrp.add(hr1);
		togrp.add(d1);
		togrp.add(w1);
		togrp.add(month1);
		togrp.add(y1);
		togrp.add(dec1);
		togrp.add(cen1);
		
		
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
		fromto.add(ms);
		fromto.add(s);
		fromto.add(m);
		fromto.add(hr);
		fromto.add(d);
		fromto.add(w);
		fromto.add(month);
		fromto.add(y);
		fromto.add(dec);
		fromto.add(cen);

		fromto1.add(res);
		fromto1.add(to);
		
		fromto1.add(ms1);
		fromto1.add(s1);
		fromto1.add(m1);
		fromto1.add(hr1);
		fromto1.add(d1);
		fromto1.add(w1);
		fromto1.add(month1);
		fromto1.add(y1);
		fromto1.add(dec1);
		fromto1.add(cen1);

		ms.addActionListener(this);
		s.addActionListener(this);
		m.addActionListener(this);
		hr.addActionListener(this);
		d.addActionListener(this);
		w.addActionListener(this);
		month.addActionListener(this);
		y.addActionListener(this);
		dec.addActionListener(this);
		cen.addActionListener(this);
		
		ms1.addActionListener(this);
		s1.addActionListener(this);
		m1.addActionListener(this);
		hr1.addActionListener(this);
		d1.addActionListener(this);
		w1.addActionListener(this);
		month1.addActionListener(this);
		y1.addActionListener(this);
		dec1.addActionListener(this);
		cen1.addActionListener(this);
		
		setTitle("time");
		setLayout(new GridLayout(1,2,10,10));
		setVisible(true);
		setBounds(700,10,650,400);	
		//setSize(650,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	
	public void actionPerformed(ActionEvent ae) {
		double val=Double.parseDouble(input.getText());
		double inHours=tohour(val);
		double converted=fromhour(inHours);
//		System.out.println(converted);
		res.setText(converted+"");
	}
	
	double tohour(double val)
	  {
	    if(s.isSelected())
	    {
	      return val/3600;
	    }
	    else if(ms.isSelected())
	    {
	      return val/3600000;
	    }
	    else if(m.isSelected())
	    {
	      return val/60;
	    }
	    else if(d.isSelected())
	    {
	      return val*24;
	    }
	    else if(w.isSelected())
	    {
	      return val*168;
	    }
	    else if(month.isSelected())
	    {
	      return val*730.001;
	    }
	    else if(y.isSelected())
	    {
	      return val*8760;
	    }
	    else if(dec.isSelected())
	    {
	      return val*87600;
	    }
	    else if(cen.isSelected())
	    {
	      return val*876000;
	    }
	    else
	      return val;
	  }
	  double fromhour(double val)
	  {
	    if(s1.isSelected())
	    {
	      return val*3600;
	    }
	    else if(ms1.isSelected())
	    {
	      return val*3600000;
	    }
	    else if(m1.isSelected())
	    {
	      return val*60;
	    }
	    else if(d1.isSelected())
	    {
	      return val/24;
	    }
	    else if(w1.isSelected())
	    {
	      return val/168;
	    }
	    else if(month1.isSelected())
	    {
	      return val/730.001;
	    }
	    else if(y1.isSelected())
	    {
	      return val/8760;
	    }
	    else if(dec1.isSelected())
	    {
	      return val/87600;
	    }
	    else if(cen1.isSelected())
	    {
	      return val/876000;
	    }
	    else
	      return val;
	  }
}