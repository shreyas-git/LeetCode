package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class RobotBoundedInCircle_1041 {

	public static void main(String[] args) {
		String ins = "GGLLGG";
		System.out.println(isRobotBounded(ins));
	}
	
	public static boolean isRobotBounded(String instructions) {
        // store the directions in MAP 
		Map<Character,Map<Character,Character>>  dirMap = new HashMap();
      
        Map<Character,Character> north = new HashMap<>();
        north.put('L','W');
        north.put('R', 'E');
        
       
        Map<Character,Character> west = new HashMap<>();
        west.put('L','S');
        west.put('R', 'N');
        
        Map<Character,Character> south = new HashMap<>();
        south.put('L','E');
        south.put('R', 'W');
        
        Map<Character,Character> east = new HashMap<>();
        east.put('L','N');
        east.put('R', 'S');
        
 
        dirMap.put('N', north);
        dirMap.put('W', west);
        dirMap.put('S', south);
        dirMap.put('E', east);
        
        char dir = 'N';
        int x = 0,y=0;
        
        
        for(int i=0;i<instructions.length();i++) {
        	if(instructions.charAt(i) == 'G') {
        		if(dir == 'N') {
        			y++;
        		}else if(dir =='S') {
        			y--;
        		}else if(dir == 'W') {
        			x--;
        		}else if(dir == 'E') {
        			x++;
        		}
        	}else if(instructions.charAt(i) == 'L') {
        		// change my direction
        		dir = dirMap.get(dir).get('L');
        		
        	}else if(instructions.charAt(i) == 'R') {
        		dir = dirMap.get(dir).get('R');
        	}
        }
        
        if(x==0 && y==0) {
        	return true;
        }
       return false;
    }

}
