package Calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class Matrix_calc 
{
	public static void main(String args[])
	{
		GUI2 obj = new GUI2();
	}
}

 class GUI2 extends JFrame implements ActionListener
{
	JRadioButton b1,b2,b3;
	JTextField t1,t2,t3,t4,t5,t6;
	JLabel li,l1,l2,l3,l4,l5,l6,lres,lord;
	public GUI2()
	{
		t1=new JTextField(20);
		t2=new JTextField(20);
		t3=new JTextField(20);
		t4=new JTextField(20);
		t5=new JTextField(20);
		t6=new JTextField(20);
		lres=new JLabel("RESULT");
		lord=new JLabel("ORDER OF THE RESULT");
		
		li=new JLabel("MATRIX CALCULATOR");
		li.setForeground(Color.WHITE);
		l1=new JLabel("NO.OF ROWS in matrix 1 :");
		l2=new JLabel("NO.OF COLUMNS in matrix 1 :");
		l3=new JLabel("ELEMENTS of matrix 1 :");
		l4=new JLabel("<html>------------------------------------------<br/>NO.OF ROWS in matrix 2 :</html>");
		l5=new JLabel("NO.OF COLUMNS in matrix 2 :");
		l6=new JLabel("ELEMENTS of matrix 2 :");
		
		
		JPanel introp=new JPanel();
		introp.setLayout(new FlowLayout(FlowLayout.CENTER,200,5));
		introp.setBackground(Color.RED);
		this.add(introp);

		
		ButtonGroup bg=new ButtonGroup();
		
		introp.add(li);
		add(l1);
		add(t1);
		add(l2);
		add(t2);
		add(l3);
		add(t3);
		add(l4);
		add(t4);
		add(l5);
		add(t5);
		add(l6);
		add(t6);

		
		JPanel p1 = new JPanel();
		this.add(p1);
		
		
		b1=new JRadioButton("Addition");
		b2=new JRadioButton("Subtraction");
		b3=new JRadioButton("Multiplication");
		bg.add(b1);
		bg.add(b2);
		bg.add(b3);
		p1.add(b1);
		p1.add(b2);
		p1.add(b3);
		
		JPanel p2 = new JPanel();
		p2.setLayout(new FlowLayout(FlowLayout.CENTER,250,5));
		this.add(p2);
		p2.setBackground(Color.ORANGE);
		p2.add(lres);
		
		JPanel p3 = new JPanel();
		p3.setLayout(new FlowLayout(FlowLayout.CENTER,250,5));
		this.add(p3);
		p3.setBackground(Color.ORANGE);
		p3.add(lord);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		this.setLayout(new FlowLayout());
		setVisible(true);
		this.setBounds(700,10,350,500);	
		this.setTitle("MATRIX CALCULATOR");
		//setSize(650,400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent ae)
	{
		//int [] arr1=new int[100];
		//int [] arr2=new int[100];
		//int [] res=new int[100];
		int i=0,j=0,k=0;
		int r1 = Integer.parseInt(t1.getText());
		int c1=Integer.parseInt(t2.getText());
		String []str_arr1 = new String[r1*c1];
		int [][] arr1=new int[r1][c1];
		String str1=t3.getText();
		for(String s:str1.split(" "))
		{
			str_arr1[i]=s;
			i++;
		}
		for(i=0;i<r1;++i)
		{
			for(j=0;j<c1;++j)
			{
				arr1[i][j]=Integer.parseInt(str_arr1[k]);
				k++;
			}
		}
		
		int r2 = Integer.parseInt(t4.getText());
		int c2=Integer.parseInt(t5.getText());
		String []str_arr2 = new String[r2*c2];
		int [][] arr2=new int[r2][c2];
		String str2=t6.getText();
		i=0;
		for(String s:str2.split(" "))
		{
			str_arr2[i]=s;
			i++;
			
		}
		k=0;
		for(i=0;i<r2;++i)
		{
			for(j=0;j<c2;++j)
			{
				arr2[i][j]=Integer.parseInt(str_arr2[k]);
				k++;
			}
		}
		if(b1.isSelected())
		{
			int[][] res= new int[r1][c1];
			for(i=0;i<r1;++i)
			{
				for(j=0;j<c1;++j)
				{
					res[i][j]=arr1[i][j]+arr2[i][j];
				}
			}
			int []res_arr=new int[r1*c1];
			k=0;
			for (i=0;i<r1;++i)
			{
				for(j=0;j<c1;++j)
				{
					res_arr[k]=res[i][j];
					k++;
				}
			}
			String res_str=Arrays.toString(res_arr);
			lres.setText(res_str);
			lord.setText(r1+"×"+c1);
		}
		else if(b2.isSelected())
		{
			int[][] res= new int[r1][c1];
			for(i=0;i<r1;++i)
			{
				for(j=0;j<c1;++j)
				{
					res[i][j]=arr1[i][j]-arr2[i][j];
				}
			}
			int []res_arr=new int[r1*c1];
			k=0;
			for (i=0;i<r1;++i)
			{
				for(j=0;j<c1;++j)
				{
					res_arr[k]=res[i][j];
					k++;
				}
			}
			String res_str=Arrays.toString(res_arr);
			lres.setText(res_str);
			lord.setText(r1+"×"+c1);
		}
		else if(b3.isSelected())
		{
			int[][] res=new int[r1][c2];
			for(i=0;i<r1;i++)
			{
				for(j=0;j<c2;j++)
				{
					res[i][j]=0;
					for(k=0;k<c1;k++)
					{
						res[i][j]+=arr1[i][k]*arr2[k][j];
					}
				}
			}
			int[] res_arr=new int[r1*c2];
			k=0;
			for (i=0;i<r1;++i)
			{
				for(j=0;j<c2;++j)
				{
					res_arr[k]=res[i][j];
					k++;
				}
			}
			
			String res_str=Arrays.toString(res_arr);
			lres.setText(res_str);
			lord.setText("The order of the resultant matrix is "+r1+"×"+c2);
		}
		
	}
}