import java.math.BigInteger;
import java.util.Stack;
//LeetCode Add Binary
class Solution {
	public String addBinary(String a, String b) {
		BigInteger a1 = new BigInteger(a, 2);
		BigInteger b1 = new BigInteger(b, 2);
		return a1.add(b1).toString(2);
	}
}
