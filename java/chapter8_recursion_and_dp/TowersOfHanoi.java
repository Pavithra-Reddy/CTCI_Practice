package chapter8_recursion_and_dp;

public class TowersOfHanoi {

	public static void main(String[] args) {
        moveDisks(5, 'A', 'C', 'B');
	}
	
	static void moveDisks(int n, char src, char dest, char temp)
    {
        if (n == 1)
        {
            System.out.println("Move " + n +" from " +  src + " to " + dest);
            return;
        }
        moveDisks(n-1, src, temp, dest);
        System.out.println("Move " + n +" from " +  src + " to " + dest);
        moveDisks(n-1, temp, dest, src);
    }
}
