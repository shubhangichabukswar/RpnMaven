package main.java;


class Stack  
{  
   private float[] A;  
   private int top,Size;  
   public Stack(int max)  
   {  
          Size=max;  
     A=new float[Size];  
     top=-1;  
   }  
   public void push(float key)  
   {  
          A[++top]=key;  
   }  
   public float pop()  
   {  
     return(A[top--]);  
   }  
}  

public class RPNCalc {
       
       public float String_to_float(String temp)
       {
              float result=0;
              int power=1;
              for(int i=temp.length()-1;i>=0;i--)
              {
                     char ch=temp.charAt(i); 
                     result=(ch-'0')*power+result;
                     power*=10;
              }
              return result;
       }
       
       public int getFactorial(int value)
       {
              int result=1;
              for(int i=1;i<=value;i++)
                     result*=i;
              return result;
       }
       
       public float exponential(float Operand1, float Operand2)
       {
              float result=1;
              for(float index=1;index<=Operand1;index++)
              result*=Operand2;
              return result;
       }
       
       public float operation(char ch, float Operand1, float Operand2)
       {
              float res=0;
              switch(ch)  
        {  
          case '+':res=Operand1+Operand2;  
             break;  
          case '-':res=Operand2-Operand1;  
             break;  
          case '*':res=Operand1*Operand2;  
             break;  
          case '/':res=Operand2/Operand1;  
             break; 
          case '^':res=exponential(Operand1,Operand2);
                           break;
           
        }  
              return res;   
       }
       
   public float calculate(String expression)  
   {  
     
     float result=0;    
     Stack Operand_Stack=new Stack(expression.length());   
    
     for(String token : expression.split(" ")) 
     {  
       //System.out.println("Token: "+token);
  
        char ch=token.charAt(0);  
        if(ch>='0'&&ch<='9')  
        {  
               Operand_Stack.push(String_to_float(token)); 
        }
            else  
            {  
               float Operand1=Operand_Stack.pop(), Operand2=0;
                      
                if(ch=='!')
                      result=getFactorial((int)Operand1);
                else if(ch=='%')
                      result=Operand1/100;  
                else
                      Operand2=Operand_Stack.pop();
                
                if(ch!='!' && ch!='%')
                      result=operation(ch,Operand1,Operand2);
                
                Operand_Stack.push(result);  
            }  
        }  
     result=Operand_Stack.pop();  
        return(result);  
  }  
}  
