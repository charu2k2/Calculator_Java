package Calculator;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;
public class lcmgcd
{
	public static void main(String args[])
	{
	GCD obj=new GCD();
	}
}
class GCD extends JFrame implements ActionListener{
	JFrame GCDf;
	JTextField jf,ans;
	JLabel title,res,query;
	JRadioButton r1,r2;
	JButton find,clear;
	GCD(){
		GCDf=new JFrame();
		ButtonGroup grp=new ButtonGroup();
		r1=new JRadioButton("LCM");
		r2=new JRadioButton("GCD",true);
		title=new JLabel("LCM & GCD CALCULATOR",JLabel.CENTER);
		title.setOpaque(true);
		title.setForeground(Color.WHITE);
		title.setFont(new Font("Arial", Font.BOLD, 14));
		title.setBackground(Color.RED);
		title.setBounds(5,5,375,40);
		query=new JLabel("NUMBERS: ",JLabel.CENTER);
		//query.setHorizontalAlignment(JLabel.CENTER);
		query.setForeground(Color.BLACK);
		query.setFont(new Font("Arial", Font.BOLD, 14));
		query.setBounds(5,55,80,40);
		jf=new JTextField();
		jf.setFont(new Font("Dubai", Font.BOLD, 14));
		jf.setBounds(110,55,250,40);
		r1.setBounds(5,105,50,40);
		r2.setBounds(70,105,50,40);
		find = new JButton("Calculate");
		clear = new JButton("Clear"); 
		clear.setBounds(140,105,100,40);
		find.setBounds(260,105,100,40);
		find.addActionListener(this);
		clear.addActionListener(this);
		res=new JLabel("RESULT: ");
		res.setHorizontalAlignment(SwingConstants.CENTER);
		res.setBounds(5,160,100,40);
		ans=new JTextField();
		ans.setEditable(false);
		ans.setHorizontalAlignment(JTextField.CENTER);
		ans.setBounds(115,160,100,40);
		ans.setFont(new Font("Arial", Font.BOLD, 14));
		ans.setBackground(Color.WHITE);
		grp.add(r1);
		grp.add(r2);
		GCDf.add(title);
		GCDf.add(query);
		GCDf.add(jf);
		GCDf.add(r1);
		GCDf.add(r2);
		GCDf.add(find);
		GCDf.add(res);
		GCDf.add(ans);
		GCDf.add(clear);
        //GCDf.setSize(400,400);
		GCDf.setLayout(null);
		GCDf.setVisible(true);
		GCDf.setTitle("LCM & GCD CALCULATOR");
		GCDf.setBounds(700,10,400,400);	
		GCDf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent ae){
		String action=ae.getActionCommand();
		if(action.equals("Calculate")){
			int gflag=0;
			if(r1.isSelected()){
				gflag=1;
			}
			String operands=jf.getText();
			if(operands==null){
                	
			}
			else{
				String[] nos=operands.split(" ");
				int iter=nos.length;
				int finalans=Integer.valueOf(nos[0]);
				//int temp=Integer.valueOf(nos[0]);
				for(int i=1;i<iter;++i){
					int temp=finalans;
					finalans=gcd(Integer.valueOf(nos[i]),finalans);
					if(gflag==1){
						finalans=(temp*Integer.valueOf(nos[i]))/finalans;
					}
					if(finalans==1 && gflag==0){
						break;
					}
				}
				
				ans.setText(String.valueOf(finalans));
			}
		}
		else if(action.equals("Clear")){
			ans.setText("");
			jf.setText("");
		}
	}
	public static int gcd(int a,int b){
		if(b!=0){
			return gcd(b,a%b); 
		}
		else{
			return a;
		}
	}

	public static void main(String args[]){
		GCD obj =new GCD();
		/**Scanner sc=new Scanner(System.in);
		if(sc.nextInt()==10){
			System.exit(0);
		}**/
		//System.out.println(obj.gcd(sc.nextInt(),sc.nextInt()));
	}
}
