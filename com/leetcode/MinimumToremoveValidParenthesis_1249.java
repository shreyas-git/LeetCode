package com.leetcode;

public class MinimumToremoveValidParenthesis_1249 {

	public static void main(String[] args) {
		String  s = "lee(t(c)o)de)";//"))((";//"a)b(c)d";//;
				//Output: "lee(t(c)o)de"
			System.out.println(minRemoveToMakeValid(s));	

	}
	
    public static  String minRemoveToMakeValid(String s) {
        
    	StringBuilder sb = new StringBuilder();
    	int open =0;
    	for(char c:s.toCharArray()) {
    		if(c =='(') {
    			open++;
    		}else if(c == ')') {
    			if(open ==0) continue;
    			open--;
    		}
    		sb.append(c);
    	}
    	
    	
    	//"))((" -> o/p :""  to handle this case 
    	StringBuilder res= new StringBuilder();
    	//sb= "((" and open = 2;
    	for(int i = sb.length()-1;i>=0;i--) {
    		if(sb.charAt(i) =='(') {
    			
    			if(open >0 ) {
    				open--;
    				continue;
    			}
    				
    		}
    		res.append(sb.charAt(i));
    	}
    			
    	
    	return res.reverse().toString();
    }

}
