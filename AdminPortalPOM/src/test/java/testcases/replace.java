package testcases;

public class replace {

	public static void main(String[] args) {
		
		
		String text = "Transaction Processed Successfully. Reference ID: 2183713707";
		String RewardAdjustment_Referen= text.replaceAll("[^0-9]", "");
		System.out.println(RewardAdjustment_Referen);

	}

}
