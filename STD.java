package Calculator;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;
class STD implements ActionListener{
	JFrame stdf;
	//JPanel hbop;
	JLabel qnum,stdtitle,cl,sl,ml,dl,dl2,sodl,vl,stdl;
	JTextField quest,ct,st,mt,dt,dt2,sodt,vt,stdt;
	JButton Clr,comp;
	STD(){
		stdf=new JFrame();
		//hbop=new JPanel();
		//stdf.setSize(500,500);
		stdf.setBounds(700,10,500,500);	
		stdtitle=new JLabel("STANDARD DEVIATION CALCULATOR",JLabel.CENTER);
		stdtitle.setOpaque(true);
		stdtitle.setForeground(Color.WHITE);
		stdtitle.setFont(new Font("Arial", Font.BOLD, 14));
		stdtitle.setBackground(Color.RED);
		stdtitle.setBounds(5,5,475,40);
		qnum=new JLabel("NUMBERS : ",JLabel.CENTER);
		qnum.setFont(new Font("Dubai", Font.BOLD, 14));
		qnum.setBounds(5,50,130,40);
		quest=new JTextField("");
		quest.setFont(new Font("Arial", Font.BOLD, 14));
		quest.setBounds(140,50,335,40);
		quest.setHorizontalAlignment(JTextField.CENTER);
		cl=new JLabel("COUNT  : ",JLabel.CENTER);
		ct=new JTextField("");
		ct.setFont(new Font("Dubai", Font.BOLD, 14));
		ct.setHorizontalAlignment(JTextField.CENTER);
		sl=new JLabel("SUM : ",JLabel.CENTER);
		st=new JTextField("");
		st.setFont(new Font("Dubai", Font.BOLD, 14));
		st.setHorizontalAlignment(JTextField.CENTER);
		ml=new JLabel("MEAN  : ",JLabel.CENTER);
		mt=new JTextField("");
		mt.setFont(new Font("Dubai", Font.BOLD, 14));
		mt.setHorizontalAlignment(JTextField.CENTER);
		cl.setBounds(5,100,55,40);
		ct.setBounds(65,100,65,40);
		sl.setBounds(150,100,55,40);
		st.setBounds(210,100,65,40);
		ml.setBounds(290,100,55,40);
		mt.setBounds(350,100,65,40);
		dl=new JLabel("DIFFERENCES : ",JLabel.CENTER);
		dl.setFont(new Font("Dubai", Font.BOLD, 14));
		dl.setBounds(5,150,130,40);
		dt=new JTextField("");
		dt.setFont(new Font("Arial", Font.BOLD, 14));
		dt.setHorizontalAlignment(JTextField.CENTER);
		dt.setBounds(140,150,335,40);
		dl2=new JLabel("DIFFERENCES^2 : ",JLabel.CENTER);
		dl2.setFont(new Font("Dubai", Font.BOLD, 14));
		dl2.setBounds(5,200,130,40);
		dt2=new JTextField("");
		dt2.setFont(new Font("Arial", Font.BOLD, 14));
		dt2.setBounds(140,200,335,40);
		dt2.setHorizontalAlignment(JTextField.CENTER);
		vl=new JLabel("VARIANCE : ",JLabel.CENTER);
		vl.setFont(new Font("Dubai", Font.BOLD, 14));
		vl.setBounds(5,250,100,40);
		vt=new JTextField("");
		vt.setFont(new Font("Arial", Font.BOLD, 14));
		vt.setBounds(100,250,100,40);
		vt.setHorizontalAlignment(JTextField.CENTER);
		stdl=new JLabel("STANDARD DEVIATION : ");
		stdl.setFont(new Font("Dubai", Font.BOLD, 14));
		stdl.setBounds(5,300,200,40);
		stdt=new JTextField("");
		stdt.setFont(new Font("Arial", Font.BOLD, 14));
		stdt.setBounds(215,300,100,40);
		stdt.setHorizontalAlignment(JTextField.CENTER);
		Clr=new JButton("Clear");
		comp=new JButton("Compute");
		Clr.setBounds(65,350,168,30);
		comp.setBounds(252,350,168,30);
		Clr.addActionListener(this);
		comp.addActionListener(this);
		stdf.add(qnum);
		stdf.add(stdtitle);
		stdf.add(quest);
		stdf.add(cl);
		stdf.add(ct);
		stdf.add(sl);
		stdf.add(st);
		stdf.add(ml);
		stdf.add(mt);
		stdf.add(dl);
		stdf.add(dt);
		stdf.add(dl2);
		stdf.add(dt2);
		stdf.add(vl);
		stdf.add(vt);
		stdf.add(stdl);
		stdf.add(stdt);
		stdf.add(Clr);
		stdf.add(comp);
		stdf.setLayout(null);
		stdf.setVisible(true);
		stdf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public String decplaces(String s){
		String a="",b="";
		int pos=s.indexOf('.');
		if(pos==-1){
			return s;
		}
		else{
			//System.out.println(s);
			a=s.substring(0,pos+1);
			b=s.substring(pos+1);
			//System.out.println(a+"----"+b);
			if(b.length()>4){
				if(b.indexOf('E')!=-1 || b.indexOf('e')!=-1)
					b=b;
				else
					b=b.substring(0,4);
			}
			return a+b;
		}
		
	}
	public void actionPerformed(ActionEvent ae){
		String action=ae.getActionCommand();
		if(action.equals("Clear")){
			quest.setText("");
			st.setText("");
			ct.setText("");
			mt.setText("");
			dt.setText("");
			dt2.setText("");
			vt.setText("");
			stdt.setText("");
		}
		else if(action.equals("Compute")){
			String s=quest.getText();
			String[] nums=s.split(",");
			int count=nums.length;
			double sum=0;
			double[] numd=new double[count];
			double[] numpd=new double[count];
			for(int i=0;i<count;++i){
				//System.out.println(nums[i]);
				sum+=Double.valueOf(nums[i]);
				//System.out.println(sum);
			}
			double mean=sum/count;
			double smean=0;
			String diff="",diff2="";
			for(int i=0;i<count;++i){
				numd[i]=Double.valueOf(nums[i])-mean;
				diff+=this.decplaces(String.valueOf(numd[i]))+", ";
				numpd[i]+=Math.pow(numd[i],2);
				smean+=numpd[i];
				diff2+=this.decplaces(String.valueOf(numpd[i]))+", ";
			}
			diff=diff.substring(0,diff.length()-2);
			diff2=diff2.substring(0,diff2.length()-2);
			double var=smean/count;
			double dev=Math.sqrt(var);
			//System.out.println(dev);
			//System.out.println(sum);
			ct.setText(String.valueOf(count));
			st.setText(this.decplaces(String.valueOf(sum)));
			mt.setText(this.decplaces(String.valueOf(mean)));
			dt.setText(diff);
			dt2.setText(diff2);
			vt.setText(this.decplaces(String.valueOf(var)));
			stdt.setText(this.decplaces(String.valueOf(dev)));
			
		}
	}
	public static void main(String args[]){
		STD ob=new STD();
		/**Scanner x=new Scanner(System.in);
		System.out.println(ob.calculate(x.nextLine()));**/
	}
}