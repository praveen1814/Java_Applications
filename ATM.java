package oops_Project;

import java.util.Random;
import java.util.Scanner;

public class ATM {

	public static void main(String[] args) throws InvalidPinException 
	{
		Scanner scan=new Scanner(System.in);
		Generate generate=new Generate();
		Currentac current=new Currentac();
		Savingsac save=new Savingsac();
		System.out.println("Welcome to SBI ATM.");
		System.out.println("Insert your card.");
		System.out.println("Please wait for a while we are reading your card...............");
		System.out.println("* Generate your PIN by selecting * Choose * Word");
		String pingen=scan.next();
		if(pingen.equalsIgnoreCase("Choose"))
		{
			generate.setpin();
			System.out.println("Enter Your PIN");
			int pinenter=scan.nextInt();
			if(pinenter>=1000 &&pinenter<=9999)
			{
				generate.welcome();
				System.out.println("Choose Your Account Type \n* CurrentAccount\n* SavingsAccount");
				String str=scan.next();
				if(str.equalsIgnoreCase("CurrentAccount"))
				{
					System.out.println("In CurrentAccount Contain");
					System.out.println("Choose your option\n* BalanceEnquire\n* CashDeposit\n* CashWithdrowl\n* PINchange\n* Details");
					String option=scan.next();
					if(option.equalsIgnoreCase("balanceenquire"))
					{
						current.accountbalance();
					}
					else if(option.equalsIgnoreCase("Cashdeposit"))
					{
						current.diposit();
					}
					else if (option.equalsIgnoreCase("CashWithdrowl"))
					{
						current.cashwithdraw();
					}
					else if (option.equalsIgnoreCase("Pinchange"))
					{
						generate.changePin();
					}
					else if (option.equalsIgnoreCase("Details"))
					{
						generate.details();
					}
					else
					{
						System.err.println("Invalid Option");
					}
				}
				else if(str.equalsIgnoreCase("Savingsaccount"))	
				{
					System.out.println("Choose your option\n* BalanceEnquire\n* CashDeposit\n* CashWithdrowl\n* PINchange\n* Details");
					String option=scan.next();
					if(option.equalsIgnoreCase("balanceenquire"))
					{
						save.accountbalance();
					}
					else if(option.equalsIgnoreCase("Cashdeposit"))
					{
						save.diposit();
					}
					else if (option.equalsIgnoreCase("CashWithdrowl"))
					{
						save.cashwithdraw();
					}
					else if (option.equalsIgnoreCase("Pinchange"))
					{
						generate.changePin();
					}
					else if (option.equalsIgnoreCase("Details"))
					{
						generate.details();
					}
					else
					{
						System.err.println("Invalid Option");
					}
				}
				else
				{
					System.out.println("Invalid Account Type");
				}	
			}
			else
			{
				System.err.println("Invalid PIN Number.........");
				throw new InvalidPinException();
			}
				scan.close();
			
		}
	}
}
class accountdetails
{
	final long acno=45865821458l;
	final String branch="SBI Branch";
	final String name="Praveen Kumar";
	String phno="9876543210";
	void welcome()
	{
		System.out.println("Hello! "+name);
	}
	void details()
	{
		System.out.println(branch);
		System.out.println(name);
		System.out.println("Your account number is "+acno);
		System.out.println("Your Mobile Number "+phno);
	}
}
class Generate extends accountdetails
{
	Scanner scan=new Scanner(System.in);
	Random random=new Random();
	public void setpin()
	{
		
		System.out.println("Enter your moblie number");
		String mobile=scan.next();
		if(phno.equals(mobile))
		{
			int otp=random.nextInt(100000,999999);
			System.out.println("Your Otp is "+otp);
			System.out.println("Enter your otp");
			int getotp=scan.nextInt();
			if(otp==getotp)
			{
				System.out.println("Enter your new PIN");
				int pin1=scan.nextInt();
				System.out.println("Re-enter your new PIN");
				int pin2=scan.nextInt();
				if(pin1==pin2)
				{
					System.out.println("Your pin sucessfully updated");
				}
				else
				{
					System.err.println("Your are entered pin does't match");
				}
				
			 }
			 else
			 {
				System.err.println("Your entered Otp does't match");
			 }
		 }
		else
		{
			System.err.println("Your are entered Invalid mobile number");
		}
	
	}
	public void changePin()
	{
		System.out.println("Enter your moblie number.");
		String mobile=scan.next();
		if(phno.equals(mobile))
		{
			int otp=random.nextInt(100000,999999);
			System.out.println(""+otp);
			System.out.println("enter otp");
			int getotp=scan.nextInt();
			if(otp==getotp)
			{
				System.out.println("Enter your new PIN");
				int pin1=scan.nextInt();
				System.out.println("Re-enter your new PIN");
				int pin2=scan.nextInt();
				if(pin1==pin2)
				{
					System.out.println("Your pin sucessfully updated");
				}
				else
				{
					System.err.println("Your are entered pin does't match");
				}
			 }
			 else
			 {
				System.err.println("Your entered Otp does't match");
			 }
		 }
		else
		{
			System.err.println("Your are entered Invalid mobile number");
		}
	}
}
abstract class CurrentAccount
{
	Scanner sc=new Scanner(System.in);
	double balance=20000;
	void accountbalance()
	{
		System.out.println("Your Account balance is "+balance);
	}
	void diposit()
	{
		System.out.println("Enter your amount to deposit.");
		double deposit=sc.nextDouble();
		if(deposit>=2000)
		{
			System.out.println("Your amount sucessfully deposited.");
			System.out.println("Available balance is "+(deposit+balance));
		}
		else
		{
			System.err.println("Minimum deposit amount is 2000 to deposit");
		}
	}
	void cashwithdraw()
	{
		
		System.out.println("enter withdraw amount");
		double withdraw=sc.nextDouble();
		if(balance>=withdraw)
		{
			System.out.println("Sucessfully withdrowl.");
			System.out.println("Your Available balance is "+(balance-withdraw));
		}
		else
		{
			System.err.println("Insufficient balance");
		}
	}
}
abstract class SavingsAccount
{
	Scanner sc=new Scanner(System.in);
	double balance=20000;
	void accountbalance()
	{
		System.out.println("Your Account balance is "+balance);
	}
	void diposit()
	{
		System.out.println("Enter your amount to deposit.");
		double deposit=sc.nextDouble();
		if(deposit>=200)
		{
			System.out.println("Your amount sucessfully deposited.");
			System.out.println("Available balance is "+(deposit+balance));
		}
		else
		{
			System.err.println("Minimum deposit amount is 200 to deposit");
		}
	}
	void cashwithdraw()
	{
		
		System.out.println("enter withdraw amount");
		double withdraw=sc.nextDouble();
		if(balance>=withdraw)
		{
			System.out.println("Sucessfully withdrowl.");
			System.out.println("Your Available balance is "+(balance-withdraw));
		}
		else
		{
			System.err.println("Insufficient balance");
		}
	}
}
class Currentac extends CurrentAccount
{
	
}
class Savingsac extends SavingsAccount
{
	
}
class InvalidPinException extends Exception
{
	InvalidPinException()
	{
		super();
	}
}


