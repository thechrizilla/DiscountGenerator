import java.util.Random;

public class DiscountGenerator {

	public int num20 = 5;
	public int num15 = 10;
	public int num10 = 15;
	public int num5 = 20;

	static Random r = new Random();

	// Returns a valid discount
	public int getDiscount(){
		while(true){	// keep generating a discount until there is a discount that is available
			if(num5 == 0 && num10 == 0 && num15 == 0 && num20 == 0) return -1;
			int discount = generateNum();
			if(discount == 20 && num20 > 0) {
				num20--;
				return 20;
			}
			else if(discount == 15 && num15 > 0) {
				num15--;
				return 15;
			}
			else if(discount == 10 && num10 > 0) {
				num10--;
				return 10;
			}
			else if(discount == 5 && num5 > 0) {
				num5--;
				return 5;
			}
		}
	}
	
	// Controls the distribution. 
	// 20/50 chance of getting 5, 
	// 15/50 chance of getting 10,
	// 10/50 chance of getting 15, 
	// 5/50 chance of getting 20
	public int generateNum(){
		int random = r.nextInt(50);
		if(random < 20) return 5;
		else if(random < 35) return 10;
		else if(random < 45) return 15;
		else if(random < 50) return 20;
		return 0;
	}
	
	
	// Testing method
		public static void main(String[] args){
			DiscountGenerator g = new DiscountGenerator();
			
			int n5 = 0;
			int n10 = 0;
			int n15 = 0;
			int n20 = 0;
			
			for(int i = 0; i < 60; i++){
				int d = g.getDiscount();
				System.out.println(i + ": " + d);
				if(d == 5) n5++;
				if(d == 10) n10++;
				if(d == 15) n15++;
				if(d == 20) n20++;
				if(d == -1) break;
			}
			
			System.out.println("Number of $5 discounts: " + n5);
			System.out.println("Number of $10 discounts: " + n10);
			System.out.println("Number of $15 discounts: " + n15);
			System.out.println("Number of $20 discounts: " + n20);
		}

}
