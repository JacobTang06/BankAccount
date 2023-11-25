import java.util.HashMap;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner info = new Scanner(System.in);
		System.out.println("Hey there! Welcome to Wells Fargo!\n");
		System.out.println("- Press 1 to create a bank account");
		System.out.println("- Press 2 to withdraw money from an existing bank account");
		System.out.println("- Press 3 to deposit money into an existing bank account");
		System.out.println("- Press 4 to close an existing bank account");
		System.out.println("- Press 5 to view your bank account details");
		System.out.println("- Press 6 to exit");
		
		HashMap<String, BankAccount> bankAccts = new HashMap<String, BankAccount>();
		
		String input = info.next();
		
		try {
			while(!input.contains("6")) {
				int numberPressed = Integer.parseInt(input);
				while(numberPressed < 1 || numberPressed > 6) {
					System.out.println("Number is out of range. Please re-enter a valid number");
					numberPressed = info.nextInt();
				}
				switch (numberPressed) {
					case 1:
						info.nextLine();
						System.out.println(
								"Please enter the following information to complete the creation of a new bank account.");
						System.out.println("Full Name:");
						String name = info.nextLine();
						System.out.println("Address:");
						String address = info.nextLine();
						System.out.println("Phone Number (3334445555) :");
						long phoneNumber = info.nextLong();
						info.nextLine();
						System.out.println("Date of Birth (11/22/2021) :");
						String dob = info.nextLine();
						System.out.println("Minimum Deposit:");
						double minDeposit = info.nextInt();
						while (minDeposit <= 0) {
							System.out.println("Please re-enter a valid minimum deposit");
							minDeposit = info.nextInt();
						}
						BankAccount account1 = new BankAccount(name, address, phoneNumber, dob, minDeposit);
						account1.setTotalMoney(minDeposit);
						bankAccts.put(name.toUpperCase(), account1);
						break;
					case 2:
						if(bankAccts.isEmpty()) {
							System.out.println("There are no bank accounts in this database. Please create a bank account before requesting to withdraw money.");
							break;
						}
						System.out.println("What is the name of the bank account that you would like to withdraw money from?");
						String acctName1 = info.nextLine();
						System.out.println("How much money would you like to withdraw?");
						double withdrawAmt = info.nextDouble();
						if(bankAccts.containsKey(acctName1.toUpperCase())) {
							BankAccount account2 = bankAccts.get(acctName1.toUpperCase());
							account2.withdraw(withdrawAmt);
							//System.out.println("Your checkings account now contains $" + account.getTotalMoney());
						}
						break;
					case 3:
						if(bankAccts.isEmpty()) {
							System.out.println("There are no bank accounts in this database. Please create a bank account before requesting to deposit money.");
							break;
						}
						System.out.println("What is the name of the bank account that you would like to deposit money into?");
						String acctName2 = info.nextLine();
						System.out.println("How much money would you like to deposit?");
						double depositAmt = info.nextDouble();
						if(bankAccts.containsKey(acctName2.toUpperCase())) {
							BankAccount account = bankAccts.get(acctName2.toUpperCase());
							account.deposit(depositAmt);
							//System.out.println("Your checkings account now contains $" + account.getTotalMoney());
						}
						else {
							System.out.println("No such account exists.");
						}
						break;
					case 4:
						if(bankAccts.isEmpty()) {
							System.out.println("There are no bank accounts in this database. Please create a bank account before requesting to close one.");
							break;
						}
						System.out.println("What is the name of the bank account that you want to close?");
						String acctName3 = info.nextLine();
						if(bankAccts.containsKey(acctName3.toUpperCase())) {
							bankAccts.remove(acctName3.toUpperCase());
							System.out.println("Bank Account closed");
						}
						else {
							System.out.println("No such account exists.");
						}
						break;
					case 5:
						if(bankAccts.isEmpty()) {
							System.out.println("There are no bank accounts in this database. Please create a bank account before requesting to view your account details.");
							break;
						}
						System.out.println("Please enter the name of your bank account");
						String acctName4 = info.nextLine();
						if(bankAccts.containsKey(acctName4.toUpperCase())) {
							BankAccount account = bankAccts.get(acctName4.toUpperCase());
							System.out.println("Total Money in Account: $" + account.getTotalMoney());
							System.out.println("Name under Account: " + account.getName());
							System.out.println("Date of Birth: " + account.getDateOfBirth());
							String number = Long.toString(account.getPhoneNumber());
							System.out.println("Phone Number: (" + number.substring(0, 3) + ")" + number.substring(3, 6) + "-" + number.substring(6, 10));
							System.out.println("Home Address: " + account.getAddress());
						}
						else {
							System.out.println("Bank Account does not exist");
						}
						break;	
				}
				System.out.println("What else can I do for you?");
				System.out.println("- Press 1 to create a bank account");
				System.out.println("- Press 2 to withdraw money from an existing bank account");
				System.out.println("- Press 3 to deposit money into an existing bank account");
				System.out.println("- Press 4 to close an existing bank account");
				System.out.println("- Press 5 to view your bank account details");
				System.out.println("- Press 6 to exit");
				info.nextLine();
				
				input = info.nextLine();
			}
			info.close();
			
		}
		catch (NumberFormatException e) {
			System.out.println(input + " is not a valid integer value");
		}
		

	}

}
