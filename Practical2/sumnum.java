import java.util.Scanner;
public class sumnum{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter start: "); int x = input.nextInt();
		System.out.print("Enter end: "); int y = input.nextInt();
		if(x > y || x == y) {
			System.out.printf("The start is bigger than the end");
		}
		else{
			int result = 0;
			for (int counter = x; counter <= y; counter++){
				result = result + counter;
			}
			System.out.printf("The result is: %d%n",result);
		}
	}
}