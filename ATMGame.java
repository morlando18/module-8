import java.util.Date;
import java.util.Scanner;

//10.7 use the code you developed for the previous question 9.7
public class ATMGame {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		//creating 10 accounts
		Account[] account = new Account[10];
		for(int i = 0; i < 10; i++){
			account[i] = new Account(i,100,0);
			//account[i].setId(count++);
			//account[i].setBalance(100);
		}
		// asking for an id
		System.out.print("Enter an id: ");
		int id = input.nextInt();
		//checking on id
		while(id < 0 || id > 9){
			System.out.print("Please enter an id between 0 and 9");
			id = input.nextInt();
		}
		// ATM game while always true
		while(true){
			System.out.println();
			System.out.println("Main menu");
			System.out.println("1: check balance");
			System.out.println("2: withdraw");
			System.out.println("3: deposit");
			System.out.println("4: exit");
			System.out.print("Enter a choice: ");
			int choice = input.nextInt();
			if(choice == 1){
				System.out.println("The balance is " + account[id].getBalance());
			}else if (choice == 2){
				System.out.print("Enter an amount to withdraw: ");
				double withdrawed = input.nextDouble();
				account[id].withdraw(withdrawed);
			}else if (choice == 3){
				System.out.print("Enter an amout to deposit: ");
				double deposited = input.nextDouble();
				account[id].deposit(deposited);
			}else if (choice == 4){
				System.out.println();
				System.out.print("Enter an id: ");
				id = input.nextInt();
				while(id < 0 || id > 9){
					System.out.print("Please enter an id between 0 and 9");
					id = input.nextInt();
				}
			}
		}
		
	}
}
class Account{
	private int id ;
	private double balance ;
	private double annualInterestRate ;
	private Date dateCreated;
	
	public Account(){
		id = 0;
		balance = 0;
		annualInterestRate = 0;
	}
	public Account(int id, double balance, double annualInterestRate){
		this.id = id;
		this.balance = balance;
		this.annualInterestRate = annualInterestRate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public double getAnnualInterestRate() {
		return annualInterestRate ;
	}
	public void setAnnualInterestRate(double annualInterestRate) {
		this.annualInterestRate = annualInterestRate;
	}
	public String getDateCreated() {
		dateCreated = new Date();
		return dateCreated.toString();
	}
	public double getMonthlyInterestRate(double annualInterestRate){
		//return monthly interest RATE
		return annualInterestRate / 12;
	}
	public double getMonthlyInterest(){
		//returns monthly interest 
		return balance * (getMonthlyInterestRate(annualInterestRate) / 100) ;
	}
	public double withdraw(double withdrawed){
		//withdraws a specified amount from the account
		return balance -= withdrawed;
	}
	public double deposit(double deposited){
		//Deposits a specified amount to the account.
		return balance += deposited;
	}
	
}