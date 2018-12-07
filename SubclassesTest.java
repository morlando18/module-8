import java.util.Date;

//11.3
/*
*No need to do the UML drawing part, but it may help visualize the problem for you
*Use the code you developed for the previous assignment question 9.7
*As well as implementing the subclasses, provide a test main method in the main 
 class SubclassesTest that demonstrates the use of your classes and methods.
*/

/*/
(Subclasses of Accounts) In Programming Exercise 9.7, the Accounts class was
defined to model a bank Accounts. An Accounts has the properties Accounts number,
balance, annual interest rate, and date created, and methods to deposit and withdraw
funds. Create two subclasses for checking and saving Accountss. A checking
Accounts has an overdraft limit, but a savings Accounts cannot be overdrawn.
Draw the UML diagram for the classes and then implement them. Write
a test program that creates objects of Accounts, SavingsAccounts, and
CheckingAccounts and invokes their toString() methods.
/*/
public class SubclassesTest {
	public static void main(String[] args){
		// making objects 
		Accounts accounts1 = new Accounts(1, 100, 0);
		CheckingAccounts checking = new CheckingAccounts();
		SavingsAccounts savings = new SavingsAccounts();
		 
		// withdrawing
		checking.withdraw(20);
		System.out.println(checking);
		savings.withdraw(20);
		System.out.println(savings);
		System.out.println(accounts1);
	}	
}

class CheckingAccounts extends Accounts{
	public CheckingAccounts(){
		super();
	}
	// limit on withdraw
	public double withdraw(double withdrawed){
		if(withdrawed >= 10){
			withdrawed = 10;
		} 
		
		double balance = super.getBalance();
		return balance -= withdrawed;
	}
	
	public String toString(){
		return "In CheckingAccount Class: Maximum withdraw is $10";
	}
	
}
class SavingsAccounts extends Accounts{
	//cannot overdrawn
	public double withdraw(double withdrawed){
		withdrawed = 0;
		double balance = super.getBalance();
		return balance -= withdrawed;
		
	}
	public String toString(){
		
		return "No withdraw allowed.  Total money withdrawed is $0 from savings Accounts";
	}
}
class Accounts{
	private int id ;
	private double balance ;
	private double annualInterestRate ;
	private Date dateCreated;
	
	public Accounts(){
		id = 0;
		balance = 0;
		annualInterestRate = 0;
	}
	public Accounts(int id, double balance, double annualInterestRate){
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
		//withdraws a specified amount from the Accounts
		return balance -= withdrawed;
	}
	public double deposit(double deposited){
		//Deposits a specified amount to the Accounts.
		return balance += deposited;
	}
	public String toString(){
		
		return "In Accountss class";
	}
}





