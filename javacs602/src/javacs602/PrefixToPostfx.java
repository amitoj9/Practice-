package javacs602;

import java.util.Stack;

public class PrefixToPostfx{
	        public static final String prefixInput ="++A*BCD";
	        //desired postfix output is "ab/c*de+f*-"

	        public static void main (String[] args){
	            System.out.println(pre2postS(prefixInput));
	        }

	        private static boolean isOperator(char c) {
	            char[] operators = {'+', '-', '/', '*'};
	            boolean isOp = false;
	            for (char operator : operators) {
	                if (c == operator) {
	                    isOp = true;
	                    break;
	                }
	            }
	            return isOp;
	        }
	        private static StringBuilder pre2postS(String prefixExp) {
	        	 
	            StringBuilder LEFT_DONE = new StringBuilder("LEFT_DONE");
	     
	            Stack<StringBuilder> operatorStack = new Stack<StringBuilder>();
	            StringBuilder strPostfix = new StringBuilder("");
	     
	            if (prefixExp.equals(" ")) {
	                return null;
	            }
	     
	            for(int i=0;i<prefixExp.length();i++)
	            {

	                if (isOperator(prefixExp.charAt(i))) {
	                    operatorStack.push(new StringBuilder(prefixExp.charAt(i)));
	                } else {
	                    strPostfix.append(String.valueOf(prefixExp.charAt(i)));
	                    while (!operatorStack.empty() && operatorStack.peek().equals(LEFT_DONE)) {
	                        operatorStack.pop();
	                        strPostfix.append(operatorStack.pop());
	                    }
	                    operatorStack.push(LEFT_DONE);
	                }       	
	            }
	            return strPostfix;
	        }
	    }