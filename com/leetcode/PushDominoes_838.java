package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
There are n dominoes in a line, and we place each domino vertically upright. In the beginning, we simultaneously push some of the dominoes either to the left or to the right.

After each second, each domino that is falling to the left pushes the adjacent domino on the left. Similarly, the dominoes falling to the right push their adjacent dominoes standing on the right.

When a vertical domino has dominoes falling on it from both sides, it stays still due to the balance of the forces.

For the purposes of this question, we will consider that a falling domino expends no additional force to a falling or already fallen domino.

You are given a string dominoes representing the initial state where:

dominoes[i] = 'L', if the ith domino has been pushed to the left,
dominoes[i] = 'R', if the ith domino has been pushed to the right, and
dominoes[i] = '.', if the ith domino has not been pushed.
Return a string representing the final state.
 */
public class PushDominoes_838 {

	public static void main(String[] args) {
		String dominoes = ".L.R...LR..L..";
		System.out.println(pushDominoes(dominoes));

	}
	

	  public static  Character STANDING = '.';
	   public static Character LEFT = 'L';
	   public  static Character RIGHT = 'R';
	  
	  
	    public static String pushDominoes(String dominoes) {
	        char[] out = new char[dominoes.length()];
	      
	      for(int i=0; i< dominoes.length();i++){
	        out[i] = STANDING;
	      }
	      
	      // fill up poistions of left and right
	      List<Direction> position = new ArrayList<>();
	      
	      for(int i=0;i<dominoes.length();i++){
	        if(dominoes.charAt(i) == LEFT || dominoes.charAt(i) == RIGHT){
	          Direction dir = new Direction(dominoes.charAt(i),i);
	          position.add(dir);
	        }
	      }

	      for(int i=0;i<position.size();i++){
	        if(position.get(i).dir == LEFT){
	          pushLeft(out,position.get(i).pos);
	        }else if(position.get(i).dir == RIGHT){
	          // case 1 : if R is the last character in the Position list
	          if(i == position.size()-1){
	            pushRight(out,position.get(i).pos,out.length);
	          }else if(position.get(i+1).dir == RIGHT){
	              pushRight(out,position.get(i).pos,position.get(i+1).pos);
	          }else if( position.get(i+1).dir == LEFT){
	            pushRightLeft(out,position.get(i).pos,position.get(i+1).pos);
	            i= i+1;// move to the 
	          }
	        }
	      }
	      
	        StringBuilder sb = new StringBuilder();
	      
	      for(char res:out){
	        sb.append(res);
	      }
	      return sb.toString();
	    }
	  public static void pushRightLeft(char []out,int pushRightIndex,int pushLeftIndex ){
	    while(pushRightIndex < pushLeftIndex){
	      out[pushRightIndex++] = RIGHT;
	      out[pushLeftIndex--] = LEFT;
	    }
	  }
	  
	  public static void pushRight(char []out,int pushRightIndex,int pushTillIndex){
	    for(int i =pushRightIndex;i<pushTillIndex;i++){
	      out[i] = RIGHT;  
	    }
	  }
	  
	  public static void pushLeft(char [] out,int pushLeftIndex){
	    for(int i=pushLeftIndex;i>=0 && out[i]==STANDING;i--){
	      out[i] = LEFT;
	    }
	  }
	  

}

class Direction{
    char dir;
    int pos;
    public Direction(char c,int pos){
      this.dir = c;this.pos=pos;
    }
    
  }