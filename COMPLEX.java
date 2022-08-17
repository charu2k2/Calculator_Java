package Calculator;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;
class COMPLEX implements ActionListener{
	JFrame compfram;
	JButton addb,subb,mulb,divb,conb,invb,polb,modb,sqrtb,Clear;
	JTextField resultt,complex1t,complex2t;
	JLabel complex1l,complex2l,resultl;
	JLabel comptitle;
	COMPLEX(){
		compfram=new JFrame("COMPLEX CALCULATOR");
		//compfram.setSize(500,500);
		compfram.setBounds(700,10,500,500);	
		comptitle=new JLabel("COMPLEX CALCULATOR",JLabel.CENTER);
		comptitle.setOpaque(true);
		comptitle.setForeground(Color.WHITE);
		comptitle.setFont(new Font("Arial", Font.BOLD, 14));
		comptitle.setBackground(Color.RED);
		comptitle.setBounds(5,5,475,40);
		complex1l=new JLabel("COMPLEX 1 : ",JLabel.CENTER);
		complex1l.setFont(new Font("Dubai", Font.BOLD, 14));
		complex1l.setBounds(5,55,130,40);
		complex1t=new JTextField("");
		complex1t.setFont(new Font("Arial", Font.BOLD, 20));
		complex1t.setBounds(140,55,335,40);
		complex1t.setHorizontalAlignment(JTextField.CENTER);
		complex2l=new JLabel("COMPLEX 2 : ",JLabel.CENTER);
		complex2l.setFont(new Font("Dubai", Font.BOLD, 14));
		complex2l.setBounds(5,105,130,40);
		complex2t=new JTextField("");
		complex2t.setFont(new Font("Arial", Font.BOLD, 20));
		complex2t.setBounds(140,105,335,40);
		complex2t.setHorizontalAlignment(JTextField.CENTER);
		resultl=new JLabel("RESULT : ",JLabel.CENTER);
		resultl.setFont(new Font("Dubai", Font.BOLD, 14));
		resultl.setBounds(5,155,130,40);
		resultt=new JTextField("");
		resultt.setFont(new Font("Arial", Font.BOLD, 20));
		resultt.setBounds(140,155,335,40);
		resultt.setHorizontalAlignment(JTextField.CENTER);
		addb=new JButton("ADD");
		subb=new JButton("SUBTRACT");
		mulb=new JButton("MULTIPLY");
		divb=new JButton("DIVIDE");
		conb=new JButton("CONJUGATE");
		invb=new JButton("INVERSE");
		sqrtb=new JButton("SQRT");
		modb=new JButton("MOD");
		polb=new JButton("POLAR");
		Clear=new JButton("CLEAR");
		addb.setBounds(30,260,100,30);
		subb.setBounds(140,260,100,30);
		mulb.setBounds(250,260,100,30);
		divb.setBounds(360,260,100,30);
		sqrtb.setBounds(30,320,100,30);
		modb.setBounds(140,320,100,30);
		invb.setBounds(250,320,100,30);
		polb.setBounds(360,320,100,30);
		conb.setBounds(30,400,190,30);
		Clear.setBounds(260,400,200,30);
		addb.addActionListener(this);
		subb.addActionListener(this);
		mulb.addActionListener(this);
		divb.addActionListener(this);
		conb.addActionListener(this);
		invb.addActionListener(this);
		sqrtb.addActionListener(this);
		modb.addActionListener(this);
		polb.addActionListener(this);
		Clear.addActionListener(this);
		compfram.add(comptitle);
		compfram.add(complex1l);
		compfram.add(complex1t);
		compfram.add(complex2l);
		compfram.add(complex2t);
		compfram.add(resultl);
		compfram.add(resultt);
		compfram.add(addb);
		compfram.add(subb);
		compfram.add(mulb);
		compfram.add(divb);
		compfram.add(invb);
		compfram.add(modb);
		compfram.add(conb);
		compfram.add(sqrtb);
		compfram.add(polb);
		compfram.add(Clear);
		compfram.setLayout(null);
		compfram.setVisible(true);
		compfram.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public double parts(String x,int req){
		String real="",image="";
		int signflag=0;
		//System.out.println(x.charAt(0));
		for(int i=0;i<x.length()-1;++i){
			char temp=x.charAt(i);
			if(i!=0&&(temp=='+'||temp=='-'))
				signflag=1;
			if(signflag==0)
				real+=temp;
			else
				image+=temp;
		}
		if(signflag==0){
			image=real;
			real="";
		}
		/**if(real.equals(""))
			System.out.println("Hi");
		else
			System.out.println(real);
		if(image.equals(""))
			System.out.println("BYE");
		else
			System.out.println(image+"j");**/
		
		if(req==1)
			if(real.equals(""))
				return Double.valueOf(0);
			else
				return Double.valueOf(real);
		else
			if(image.equals(""))
				return Double.valueOf(0);
			else
				return Double.valueOf(image);
		
	}
	public String compaddsub(String x,String y,int opflag){
		double r1=0,r2=0,i1=0,i2=0;
		char img='i';
		if(Character.isAlphabetic(x.charAt(x.length()-1)))
			img=x.charAt(x.length()-1);
		else if(Character.isAlphabetic(y.charAt(y.length()-1)))
			img=y.charAt(y.length()-1);
		//System.out.println(img);
		if(x.indexOf(img)==-1)
			x+="+"+String.valueOf(0.0)+img;
		if(y.indexOf(img)==-1)
			y+="+"+String.valueOf(0.0)+img;
		if(x.charAt(0)!='+'&& x.charAt(0)!='-')
			x="+"+x;
		if(y.charAt(0)!='+'&& y.charAt(0)!='-')
			y="+"+y;
		//System.out.println(x);
		//System.out.println(y);
		String ans="";
		r1=this.parts(x,1);
		i1=this.parts(x,2);
		r2=this.parts(y,1);
		i2=this.parts(y,2);
		if(opflag==1){
			ans+=this.decplaces(String.valueOf(r1+r2),4);
			if((i1+i2)>=0)
				ans+='+'+this.decplaces(String.valueOf(i1+i2),4);
			else
				ans+=this.decplaces(String.valueOf(i1+i2),4);
		}
		if(opflag==2){
			ans+=this.decplaces(String.valueOf(r1-r2),4);
			if(i1-i2>=0)
				ans+='+'+this.decplaces(String.valueOf(i1-i2),4);
			else
				ans+=this.decplaces(String.valueOf(i1-i2),4);
		}
		ans+=img;
		//System.out.println(ans);
		return ans;
	}
	public String compmul(String x,String y){
		double r1=0,r2=0,i1=0,i2=0;
		char img='i';
		if(Character.isAlphabetic(x.charAt(x.length()-1)))
			img=x.charAt(x.length()-1);
		else if(Character.isAlphabetic(y.charAt(y.length()-1)))
			img=y.charAt(y.length()-1);
		//System.out.println(img);
		if(x.indexOf(img)==-1)
			x+="+"+String.valueOf(0.0)+img;
		if(y.indexOf(img)==-1)
			y+="+"+String.valueOf(0.0)+img;
		if(x.charAt(0)!='+'&& x.charAt(0)!='-')
			x="+"+x;
		if(y.charAt(0)!='+'&& y.charAt(0)!='-')
			y="+"+y;
		//System.out.println(x);
		//System.out.println(y);
		String ans="";
		r1=this.parts(x,1);
		i1=this.parts(x,2);
		r2=this.parts(y,1);
		i2=this.parts(y,2);
		double real=0,im=0;
		real+=(r1*r2);
		real+=(i1*i2*-1);
		im+=(r1*i2);
		im+=(i1*r2);
		//System.out.println(real+" "+im+" "+img);
		ans+=this.decplaces(String.valueOf(real),4);
		if(im>=0)
			ans+="+"+this.decplaces(String.valueOf(im),4);
		else
			ans+=this.decplaces(String.valueOf(im),4);;
		ans+=img;
		//System.out.println(ans);
		return ans;
	}
	public String compconjugate(String x){
		double r1=0,i1=0;
		char img='i';
		if(Character.isAlphabetic(x.charAt(x.length()-1)))
			img=x.charAt(x.length()-1);
		if(x.indexOf(img)==-1)
			x+="+"+String.valueOf(0.0)+img;
		if(x.charAt(0)!='+'&& x.charAt(0)!='-')
			x="+"+x;
		String ans="";
		r1=this.parts(x,1);
		i1=this.parts(x,2);
		i1=0-i1;
		ans+=r1;
		if(i1>=0)
			ans+="+"+i1;
		else
			ans+=i1;
		ans+=img;
		return ans;
	}
		public String decplaces(String s,int places){
		String a="",b="";
		int pos=s.indexOf('.');
		if(pos==-1){
			return s;
		}
		else{
			a=s.substring(0,pos+1);
			b=s.substring(pos+1);
			if(b.length()>places){
				if(b.indexOf('E')!=-1 || b.indexOf('e')!=-1)
					b=b;
				else
					b=b.substring(0,places);
			}
			return a+b;
		}
		
	}
	public String modulus(String x){
		double r1=0,i1=0;
		char img='i';
		if(Character.isAlphabetic(x.charAt(x.length()-1)))
			img=x.charAt(x.length()-1);
		if(x.indexOf(img)==-1)
			x+="+"+String.valueOf(0.0)+img;
		if(x.charAt(0)!='+'&& x.charAt(0)!='-')
			x="+"+x;
		String ans="";
		r1=this.parts(x,1);
		i1=this.parts(x,2);
		ans+=this.decplaces(String.valueOf(Math.sqrt(Math.pow(r1,2)+Math.pow(i1,2))),4);
		//System.out.println(ans);
		return ans;
		
	}
	public String compinverse(String x){
		int err=0;
		try{
		if(Double.valueOf(x)==0)
			return "Inverse Does not exist";
		}
		catch(Exception e){
			err++;
		}
		String numer=this.compconjugate(x);
		String deno=this.decplaces(String.valueOf(Math.pow(Double.valueOf(this.modulus(x)),2)),4);
		return "("+numer+")"+"/"+deno;
	}
	public String compsqrt(String x){
		double r1=0,i1=0;
		char img='i';
		char isign='-';
		if(Character.isAlphabetic(x.charAt(x.length()-1)))
			img=x.charAt(x.length()-1);
		if(x.indexOf(img)==-1){
			double val=Double.valueOf(x);
			if(val>=0)
				return this.decplaces(""+Math.sqrt(val),4);
			else
				return this.decplaces(""+Math.sqrt(0-val),4)+img;
		}
		if(x.charAt(0)!='+'&& x.charAt(0)!='-')
			x="+"+x;
		String ans="";
		r1=this.parts(x,1);
		i1=this.parts(x,2);
		//System.out.println(i1);
		if((r1>=0 && i1>0)||(r1<0 && i1<0))
			isign='+';
		String part1="",part2="";
		part1+=this.decplaces(String.valueOf(Math.sqrt((Double.valueOf(this.modulus(x))+r1)/2)),4);
		part2+=this.decplaces(String.valueOf(Math.sqrt((Double.valueOf(this.modulus(x))-r1)/2)),4);
		return "+or-( "+part1+isign+part2+img+" )";
	}
	public String compdivide(String x,String y){
		int err=0;
		try{
			if(Double.valueOf(y)==0)
				return "Can't Divide by Zero";
		}
		catch(Exception e){
			err++;
		}
		char img='i';
		if(Character.isAlphabetic(x.charAt(x.length()-1)))
			img=x.charAt(x.length()-1);
		else if(Character.isAlphabetic(y.charAt(y.length()-1)))
			img=y.charAt(y.length()-1);
		//System.out.println(img);
		if(x.indexOf(img)==-1)
			x+="+"+String.valueOf(0.0)+img;
		if(y.indexOf(img)==-1)
			y+="+"+String.valueOf(0.0)+img;
		if(x.charAt(0)!='+'&& x.charAt(0)!='-')
			x="+"+x;
		if(y.charAt(0)!='+'&& y.charAt(0)!='-')
			y="+"+y;
		y=this.compinverse(y);
		String den=y.substring(y.indexOf('/')+1);
		//System.out.println(y.substring(1,y.indexOf('/')-1));
		String ans=this.compmul(x,y.substring(1,y.indexOf('/')-1));
		return "("+ans+")"+"/"+den;
		
	}
	public String polar(String x){
		double r1=0,i1=0,rdup,idup;
		char img='i';
		if(Character.isAlphabetic(x.charAt(x.length()-1)))
			img=x.charAt(x.length()-1);
		if(x.indexOf(img)==-1)
			x+="+"+String.valueOf(0.0)+img;
		if(x.charAt(0)!='+'&& x.charAt(0)!='-')
			x="+"+x;
		String ans="";
		r1=this.parts(x,1);
		rdup=r1;
		i1=this.parts(x,2);
		idup=i1;
		String r=this.modulus(x);
		if(r1<0)
			rdup=0-r1;
		if(i1<0)
			idup=0-i1;
		double angle=Math.atan(idup/rdup);
		angle=(angle*180*7)/22;
		//System.out.println(angle);
		if(r1<0 && i1>=0)
			angle=180-angle;
		else if(r1<0&& i1<0)
			angle=angle-180;
		else if(r1>=0&& i1<0)
			angle=0-angle;
		String ang=this.decplaces(String.valueOf(angle),2);
		//System.out.println(ang);
		char sym='+';
		if(ang.charAt(0)=='-'){
			sym='-';
			ang=ang.substring(1);
		}
		//System.out.println(ang);
		return r+"*"+"( cos"+ang+" "+sym+img+"sin"+ang+" )";

	}
	public void actionPerformed(ActionEvent ae){
		String action=ae.getActionCommand();
		if(action.equals("CLEAR")){
			complex1t.setText("");
			complex2t.setText("");
			resultt.setText("");
		}
		else if(action.equals("ADD")){
			String x=complex1t.getText();
			String y=complex2t.getText();
			resultt.setText(this.compaddsub(x,y,1));
		}
		else if(action.equals("SUBTRACT")){
			String x=complex1t.getText();
			String y=complex2t.getText();
			resultt.setText(this.compaddsub(x,y,2));
		}
		else if(action.equals("MULTIPLY")){
			String x=complex1t.getText();
			String y=complex2t.getText();
			resultt.setText(this.compmul(x,y));
		}
		else if(action.equals("SQRT")){
			String x=complex1t.getText();
			resultt.setText(this.compsqrt(x));
		}
		else if(action.equals("DIVIDE")){
			String x=complex1t.getText();
			String y=complex2t.getText();
			resultt.setText(this.compdivide(x,y));
		}
		else if(action.equals("MOD")){
			String x=complex1t.getText();
			resultt.setText(this.modulus(x));
		}
		else if(action.equals("INVERSE")){
			String x=complex1t.getText();
			resultt.setText(this.compinverse(x));
		}
		else if(action.equals("POLAR")){
			String x=complex1t.getText();
			resultt.setText(this.polar(x));
		}
		else if(action.equals("CONJUGATE")){
			String x=complex1t.getText();
			resultt.setText(this.compconjugate(x));
		}
		
	}
	public static void main(String args[]){
		Scanner x=new Scanner(System.in);
		COMPLEX ubj=new COMPLEX();
		//System.out.println(ubj.modulus(x.nextLine()));
	}
}