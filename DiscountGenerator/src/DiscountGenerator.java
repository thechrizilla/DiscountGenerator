import java.util.Random;

public class DiscountGenerator {

	public int num20 = 5;
	public int num15 = 10;
	public int num10 = 15;
	public int num5 = 20;

	static Random r = new Random();

	public DiscountGenerator(){

	}

	public static void main(String[] args){
		DiscountGenerator g = new DiscountGenerator();
		
		for(int i = 0; i < 60; i++){
			System.out.println(i + ": " + g.getDiscount());
		}
	}

	// Returns a valid discount
	public int getDiscount(){
		int discount = 0;

		while(true){	// keep generating a discount until there is a discount that is available
			discount = generateNum();
			if(discount == 20 && num20 > 0) {
				num20--;
				return discount;
			}
			else if(discount == 15 && num15 > 0) {
				num15--;
				return discount;
			}
			else if(discount == 10 && num10 > 0) {
				num10--;
				return discount;
			}
			else if(discount == 5 && num5 > 0) {
				num5--;
				return discount;
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



}
