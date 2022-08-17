//package Calculator;
//import java.util.Stack;
//public class infixtopostfix {
//	String[] postfix;
//
//	static String[] convert(String s)
//	  {
//	    String[] strarr= new String[s.length()+1];
//	    String b="";
//	    int j=0,i=0;
//	    for(i=0;i<s.length();i++)
//	    {
//	      if(s.charAt(i)>='0' && s.charAt(i)<='9'|| s.charAt(i)>='a' && s.charAt(i)<='z' || s.charAt(i)>='A' && s.charAt(i)<='Z')
//	      {
//	        b+=s.charAt(i);
//	      }
//	      else {
//	        if(!b.equals(""))
//	          strarr[j++]=b;
//	        strarr[j++]=Character.toString((s.charAt(i)));
//	        b=""; 
//	      }
//	    }
//	    if(!b.equals(""))
//	      strarr[j++]=b;
//	    strarr[j]="#";
//	    return strarr;
//	  }
//
//	  static String[] inpo(String[] infix)
//	    {
//	      int i=0,j=0;
//	      Stack<String> opstack=new Stack<>();
//	      String post[]=new String[infix.length];
//	      while(infix[i]!="#")
//	      {
//	         if(infix[i].charAt(0)>='0' && infix[i].charAt(0)<='9'|| infix[i].charAt(0)>='a' && infix[i].charAt(0)<='z'||infix[i].charAt(0)>='A' && infix[i].charAt(0)<='Z' )
//	            post[j++]=infix[i];
//	          else
//	          {
//	            if(infix[i].equals(")"))
//	            {
//	              while(!opstack.peek().equals("("))
//	              {
//	                post[j++]=opstack.pop();
//	              }
//	              opstack.pop(); //for (
//	            }
//	            else //operator or (
//	            {
//	              while(!opstack.empty() && precedence( opstack.peek().charAt(0) ) >= precedence(infix[i].charAt(0)) )
//	              {
//	                if(opstack.peek().equals("(") || infix[i].equals("("))
//	                  break;
//	                post[j++]=opstack.pop(); 
//	              }
//	              opstack.push(infix[i]);
//	            }
//	          }
//	          i++;
//	      }
//	      while(!opstack.empty())
//	      {
//	        post[j++]=opstack.pop();
//	      }
//	      post[j]="#";
//	      return post;
//	    }
//	
//	
//	static int precedence(char symbol)
//	  {
//		  if(symbol == '^')
//			  return(3);
//		  else if(symbol == '*' || symbol == '/')
//			  return(2);
//		  else if(symbol == '+' || symbol == '-')     
//			  return(1);
//		  else
//			  return(0);
//	    }
//	
//	public  String evaluate(String w)
//	{
//		infixtopostfix obj=new infixtopostfix();
//		String[] a=inpo(obj.convert(w));
//		int i=0;
//		String str="";
//		while(!a[i].equals("#"))
//		{
////		System.out.println(a[i]);
//		str+=a[i];
//		str+=" ";
//		i++;
//		}
////		System.out.println(str);
//		return str;
//	}
//	public static void main(String args[])
//	{
//		infixtopostfix obj=new infixtopostfix();
//		String[] a=inpo(obj.convert("(1+2)*34-27^100"));
//		int i=0;
//		while(!a[i].equals("#"))
//		{
//		System.out.println(a[i]);
//		i++;
//		}
//		
//	}
//}

package Calculator;

import java.util.Stack;

public class infixtopostfix {
	String[] postfix;
	public static String[] convert(String s)
	  {
	    String[] strarr= new String[s.length()+1];
	    String b="";
	    int j=0,i=0;
	    for(i=0;i<s.length();i++)
	    {
	      if(s.charAt(i)>='0' && s.charAt(i)<='9' || s.charAt(i)>='a' && s.charAt(i)<='z' || s.charAt(i)>='A'&&s.charAt(i)<='Z')
	      {
	        b+=s.charAt(i);
	      }
	      else {
	        if(!b.equals(""))
	          strarr[j++]=b;
	        strarr[j++]=Character.toString((s.charAt(i)));
	        b=""; 
	      }
	    }
	    if(!b.equals(""))
	      strarr[j++]=b;
	    strarr[j]="#";
	    return strarr;
	  }
	
	static String[] inpo(String[] infix)
    {
      int i=0,j=0;
      Stack<String> opstack=new Stack<>();
      String post[]=new String[infix.length];
      while(infix[i]!="#")
      {
         if(infix[i].charAt(0)>='0' && infix[i].charAt(0)<='9' || infix[i].charAt(0)>='a' && infix[i].charAt(0)<='z' || infix[i].charAt(0)>='A'&& infix[i].charAt(0)<='Z')
            post[j++]=infix[i];
          else
          {
            if(infix[i].equals(")"))
            {
              while(!opstack.peek().equals("("))
              {
                post[j++]=opstack.pop();
              }
              opstack.pop(); //for (
            }
            else //operator or (
            {
              if(infix[i].equals("^"))
              {}
              else
              {
                while(!opstack.empty() && precedence( opstack.peek().charAt(0) ) >= precedence(infix[i].charAt(0)) )
                {
                  if(opstack.peek().equals("(") || infix[i].equals("("))
                    break;
                  post[j++]=opstack.pop(); 
                }
              }
              opstack.push(infix[i]);
            }
          }
          i++;
      }
      while(!opstack.empty())
      {
        post[j++]=opstack.pop();
      }
      post[j]="#";
      return post;
    }

  static double evaluate(String[] a)
  {
    Stack<Double> cd=new Stack<>();
    for(String var:a)
    {
    	if(var.equals("#"))
    	{
    		break;
    	}
      if(var.charAt(0)>='0' && var.charAt(0)<='9' )
      {
        double num=Integer.parseInt(var);
        cd.push(num);
      }     
      else
      {
        double n1,n2;
        if(var.equals("+"))
        {
          n1=cd.pop();
          n2=cd.pop();
          cd.push(n1+n2);
        }
        else if(var.equals("-"))
        {
          n2=cd.pop();
          n1=cd.pop();
          cd.push(n1-n2);
        }
        else if(var.equals("*"))
        {
          n2=cd.pop();
          n1=cd.pop();
          cd.push(n1*n2);
        }
        else if(var.equals("/"))
        {
          n2=cd.pop();
          n1=cd.pop();
          cd.push(n1/n2);
        }
        else if(var.equals("^")) 
        {                         
          n2=cd.pop();
          n1=cd.pop();
          cd.push(Math.pow((double)n1,(double)n2));
        }
      }
    }

    return cd.pop();
  }
	
	static int precedence(char symbol)
	  {
		  if(symbol == '^')
			  return(3);
		  else if(symbol == '*' || symbol == '/')
			  return(2);
		  else if(symbol == '+' || symbol == '-')     
			  return(1);
		  else
			  return(0);
	    }
	
	public static String Xevaluate(String a[])
	{
		int i=0;
		String str="";
		while(!a[i].equals("#"))
		{
		//System.out.println(a[i]);
		str+=a[i];
		str+=" ";
		i++;
		}

		return str;
	}

//	 public static void main(String arg[])
//	 {
//	   String[] pass=convert("1+9*7");//string to str arr
//	    String[] arr=inpo(pass);//postfix in terms of str arr
//	    String post = Xevaluate(arr);//to find upto postfix as a string
//	    
//	    System.out.println(post);//str 
//	    boolean check=false;
//	    for(int i=0;i<post.length();i++)
//	    {
//	    	if(post.charAt(i)>='a' && post.charAt(i)<='z' || post.charAt(i)>='A'&& post.charAt(i)<='Z')
//	    	{
//	    		check=true;
//	    	}
//	    }
//	    
//	    if(!check) {
//	    double result=evaluate(arr);//final result
//	    System.out.println(result);
//	    }
//	 }
}


