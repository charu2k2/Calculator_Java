package Calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class CalcGUI
{
	public static void main(String args[])
	{
		GUI1 obj = new GUI1();
	}
}
 class GUI1 extends JFrame implements ActionListener
{
	JTextField t1;
	JLabel li,lt,lp,ll,l,lti,lpi;
	//JButton bmat;
	JRadioButton b,b1,b2,b3,b4,b5,b6,b_1,b_2,b_3,b_4,b_5,b_6,b7,b8,b9,b10,b11,b12,b13;
	//JPanel panel=new JPanel();
	public GUI1()
	{
		t1 =new JTextField(20);
		t1.setText("\"Enter your expression here\"");
		
		li=new JLabel("ARITHMETIC CALCULATOR");
		li.setForeground(Color.WHITE);
		
		lt=new JLabel(">> Trigonometric calculations :");
		lti=new JLabel(">> Inverse Trigonometric calculations:"); 
		lp=new JLabel(">> Root calculations:");
		ll=new JLabel(">> Logarithmic calculations:");
		lpi=new JLabel(">> Expression:");
		l= new JLabel("Result will be displayed here");
		
		
		b=new JRadioButton("Evaluate expression");
		
		b1=new JRadioButton("sin");
		b2=new JRadioButton("cos");
		b3=new JRadioButton("tan");
		b4=new JRadioButton("cosec");
		b5=new JRadioButton("sec");
		b6=new JRadioButton("cot");
		
		b_1=new JRadioButton("sin -1");
		b_2=new JRadioButton("cos -1");
		b_3=new JRadioButton("tan -1");
		b_4=new JRadioButton("cosec -1");
		b_5=new JRadioButton("sec -1");
		b_6=new JRadioButton("cot -1");
		
		b7=new JRadioButton("Square root");
		b8=new JRadioButton("Square");
		b9=new JRadioButton("Cube root");
		b10=new JRadioButton("Cube");
		
		b11=new JRadioButton("log");
		b12=new JRadioButton("ln");
		
		b13=new JRadioButton("Postfix");
		
		JPanel introp=new JPanel();
		introp.setLayout(new FlowLayout(FlowLayout.CENTER,200,5));
		introp.setBackground(Color.RED);
		this.add(introp);
		
		JPanel panel=new JPanel(new GridLayout());
		panel.setLayout(new FlowLayout(FlowLayout.CENTER,10,5));
		this.add(panel,BorderLayout.CENTER);
		
		panel.setBackground(Color.GRAY);
		
		JPanel p = new JPanel();	
		this.add(p);
		
		JPanel p_0 = new JPanel();
		this.add(p_0);
		
		JPanel p1 = new JPanel();
		this.add(p1);
		
		JPanel p2=new JPanel();
		this.add(p2);
		
		JPanel p3=new JPanel();
		this.add(p3);
		
		JPanel p4=new JPanel();
		this.add(p4);
		
		JPanel pn = new JPanel();
		pn.setLayout(new FlowLayout(FlowLayout.CENTER,250,5));
		this.add(pn);
		pn.setBackground(Color.ORANGE);
		
		
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(b1);
		bg.add(b2);
		bg.add(b3);
		bg.add(b4);
		bg.add(b5);
		bg.add(b6);
		bg.add(b_1);
		bg.add(b_2);
		bg.add(b_3);
		bg.add(b_4);
		bg.add(b_5);
		bg.add(b_6);
		bg.add(b7);
		bg.add(b8);
		bg.add(b9);
		bg.add(b10);
		bg.add(b11);
		bg.add(b12);
		bg.add(b13);
		bg.add(b);
		
		introp.add(li);
		
		panel.add(t1);
		
		p.add(lt);
		p.add(b1);
		p.add(b2);
		p.add(b3);
		p.add(b4);
		p.add(b5);
		p.add(b6);
		
		p_0.add(lti);
		p_0.add(b_1);
		p_0.add(b_2);
		p_0.add(b_3);
		p_0.add(b_4);
		p_0.add(b_5);
		p_0.add(b_6);
		
		p1.add(lp);
		p1.add(b7);
		p1.add(b8);
		p1.add(b9);
		p1.add(b10);
		
		p2.add(ll);
		p2.add(b11);
		p2.add(b12);
		
		p3.add(lpi);
		p3.add(b13);
		
		p4.add(b);
		pn.add(l);
		

		
		//b.addActionListener(this);//interface
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		
		b_1.addActionListener(this);
		b_2.addActionListener(this);
		b_3.addActionListener(this);
		b_4.addActionListener(this);
		b_5.addActionListener(this);
		b_6.addActionListener(this);
		
		b7.addActionListener(this);
		b8.addActionListener(this);
		b9.addActionListener(this);
		b10.addActionListener(this);
		
		b11.addActionListener(this);
		b12.addActionListener(this);
		
		b13.addActionListener(this);
		
		b.addActionListener(this);
		
		
		
		setTitle("ARITHMETIC CALCULATOR");
		this.setLayout(new FlowLayout());
		setVisible(true);
		this.setBounds(700,10,650,400);		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	public void actionPerformed(ActionEvent ae)
	{
		infixtopostfix itp=new infixtopostfix();
		String str = t1.getText();
		double result;
		
		if(b1.isSelected())
		{
//			int res = evaluateon(str);
			double res = itp.evaluate(itp.inpo(itp.convert(str)));
			double rad =Math.toRadians(res);
			result=Math.sin(rad);
			l.setText(result+"");
		}
		else if(b2.isSelected())
		{
//			int res = evaluateon(str);
			double res = itp.evaluate(itp.inpo(itp.convert(str)));
			double rad =Math.toRadians(res);
			result=Math.cos(rad);
			l.setText(result+"");
		}
		else if(b3.isSelected())	
		{
//			int res = evaluateon(str);
			double res = itp.evaluate(itp.inpo(itp.convert(str)));
			double rad =Math.toRadians(res);
			result=Math.tan(rad);
			l.setText(result+"");
		}
		else if(b4.isSelected())
		{
//			int res = evaluateon(str);
			double res = itp.evaluate(itp.inpo(itp.convert(str)));
			double rad =Math.toRadians(res);
			result=(1/Math.sin(rad));
			l.setText(result+"");
		}
		else if(b5.isSelected())
		{
//			int res = evaluateon(str);
			double res = itp.evaluate(itp.inpo(itp.convert(str)));
			double rad =Math.toRadians(res);
			result=(1/Math.cos(rad));
			l.setText(result+"");
		}
		else if(b6.isSelected())
		{
//			int res = evaluateon(str);
			double res = itp.evaluate(itp.inpo(itp.convert(str)));
			double rad =Math.toRadians(res);
			result=(1/Math.tan(rad));
			l.setText(result+"");
		}
		
		else if(b_1.isSelected())
		{
			double res = itp.evaluate(itp.inpo(itp.convert(str)));
			result=Math.asin(res);
			l.setText(result+"");
		}
		else if(b_2.isSelected())
		{
			double res = itp.evaluate(itp.inpo(itp.convert(str)));
			result=Math.acos(res);
			l.setText(result+"");
		}
		else if(b_3.isSelected())	
		{
			double res = itp.evaluate(itp.inpo(itp.convert(str)));
			result=Math.atan(res);
			l.setText(result+"");
		}
		else if(b_4.isSelected())
		{
			double res = itp.evaluate(itp.inpo(itp.convert(str)));
			result=(Math.asin((double)1/res));
			l.setText(result+"");
		}
		else if(b_5.isSelected())
		{
			double res = itp.evaluate(itp.inpo(itp.convert(str)));
			result=(Math.acos((double)1/res));
			l.setText(result+"");
		}
		else if(b_6.isSelected())
		{
			double res = itp.evaluate(itp.inpo(itp.convert(str)));
			result=(Math.atan((double)1/res));
			l.setText(result+"");
		}	
		else if(b7.isSelected())
		{
			double res = itp.evaluate(itp.inpo(itp.convert(str)));
			result=Math.sqrt(res);
			l.setText(result+"");
			
		}
		else if(b8.isSelected())
		{
			double res = itp.evaluate(itp.inpo(itp.convert(str)));
			result=res*res;
			l.setText(result+"");
		}
		else if(b9.isSelected())
		{
			double res = itp.evaluate(itp.inpo(itp.convert(str)));
			result=Math.cbrt(res);
			l.setText(result+"");
		}
		else if(b10.isSelected())
		{
			double res = itp.evaluate(itp.inpo(itp.convert(str)));
			result=res*res*res;
			l.setText(result+"");
		}
		else if(b11.isSelected())
		{
			double res = itp.evaluate(itp.inpo(itp.convert(str)));
			result=Math.log10(res);
			l.setText(result+"");			
		}
		else if(b12.isSelected())
		{
			double res = itp.evaluate(itp.inpo(itp.convert(str)));
			result=Math.log(res);
			l.setText(result+"");	
		}
		
		else if(b13.isSelected())
		{
			l.setText(itp.Xevaluate(itp.inpo(itp.convert(str))));
		}
		
		else if(b.isSelected())
		{
			double res = itp.evaluate(itp.inpo(itp.convert(str)));
			l.setText(res+"");
		}		
		else
		{
			double res = itp.evaluate(itp.inpo(itp.convert(str)));
			l.setText(res+"");
		}		
	}
}
