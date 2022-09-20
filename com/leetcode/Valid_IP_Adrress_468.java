package com.leetcode;

/*
Given a string queryIP, return "IPv4" if IP is a valid IPv4 address, "IPv6" if IP is a valid IPv6 address or "Neither" if IP is not a correct IP of any type.

A valid IPv4 address is an IP in the form "x1.x2.x3.x4" where 0 <= xi <= 255 and xi cannot contain leading zeros. For example, "192.168.1.1" and "192.168.1.0" are valid IPv4 addresses while "192.168.01.1", "192.168.1.00", and "192.168@1.1" are invalid IPv4 addresses.

A valid IPv6 address is an IP in the form "x1:x2:x3:x4:x5:x6:x7:x8" where:

1 <= xi.length <= 4
xi is a hexadecimal string which may contain digits, lowercase English letter ('a' to 'f') and upper-case English letters ('A' to 'F').
Leading zeros are allowed in xi.
For example, "2001:0db8:85a3:0000:0000:8a2e:0370:7334" and "2001:db8:85a3:0:0:8A2E:0370:7334" are valid IPv6 addresses, while "2001:0db8:85a3::8A2E:037j:7334" and "02001:0db8:85a3:0000:0000:8a2e:0370:7334" are invalid IPv6 addresses.

 

Example 1:

Input: queryIP = "172.16.254.1"
Output: "IPv4"
Explanation: This is a valid IPv4 address, return "IPv4".
Example 2:

Input: queryIP = "2001:0db8:85a3:0:0:8A2E:0370:7334"
Output: "IPv6"
Explanation: This is a valid IPv6 address, return "IPv6".
Example 3:

Input: queryIP = "256.256.256.256"
Output: "Neither"
Explanation: This is neither a IPv4 address nor a IPv6 address.
 

Constraints:

queryIP consists only of English letters, digits and the characters '.' and ':
 */
public class Valid_IP_Adrress_468 {

	public static void main(String[] args) {
		
		System.out.println(validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334"));

	}
	
public  static String validIPAddress(String queryIP) {
        
        // if . is there then it is IPV4 or Neither
		// if : is there then it will be IPV6
	
		// first count the number of . and :
	
		int count_dot= 0;
		int count_colon=0;
		
		for(int i=0;i<queryIP.length();i++) {
			if(queryIP.charAt(i)=='.') count_dot++;
			if(queryIP.charAt(i) == ':') count_colon++;
		}	
			if(count_dot==3) {
				
				String[] str = queryIP.split("\\.");
				
				if(str.length ==4) {
					if(validateIPV4(str)) return "IPV4";
				}
				
			}
			
			if(count_colon==7) {
				String[] str = queryIP.split("\\:");
				if(str.length == 8){
					if(validateIPV6(str)) return "IPV6";;
				}
				
			}
		
		
		return "Neither";
	
    }

private static boolean validateIPV6(String[] str) {
	
	for(String s:str) {
		if(s.length()>4 || s.length() <=0) return false;
		for(char c:s.toCharArray()) {
			if((c>='a' && c<='f' )  || 
			   (c>='A' && c<='F')	||
			   (c>='0' && c<='9')
				)continue;
			return false;
		}
	}
	return true;
}

private static boolean validateIPV4(String[] str) {
	
	for(String s:str) {
		if(s.startsWith("0") && s.length()>1) return false;
		if(Integer.valueOf(s)>255) return false;
		if(s.length() > 3) return false;
		if(s.length() < 1) return false;
	}
	return true;
}
	
	

}
