 import java.util.*;

class ATMInterface {
    Scanner sc = new Scanner(System.in);
    Random random = new Random();
    float balance = random.nextFloat() * 10000000.0f;  // Generates a random float balance between 0 and 10,000,000
    int Pin = 1234;  // Default pin number

    void menu() {
        System.out.println("WELCOME TO THE ATM");
        System.out.println("ATM MENU");
        System.out.println("PLEASE SELECT ONE OF THE FOLLOWING");
        System.out.println("1. CHECK BALANCE");
        System.out.println("2. DEPOSIT MONEY");
        System.out.println("3. WITHDRAW MONEY");
        System.out.println("4. CHANGE PIN");
        System.out.println("5. CANCEL TRANSACTION");
    }

    void startOperation() {
        int choice;
        menu();
        System.out.println("Enter your choice:");
        choice = sc.nextInt();
        switch (choice) {
            case 1:
                checkBalance();
                break;
            case 2:
                depositMoney();
                break;
            case 3:
                withdrawMoney();
                break;
            case 4:
                changePin();
                break;
            case 5:
                System.out.println("Transaction Cancelled");
                return;
            default:
                System.out.println("Invalid Input");
        }
    }

    void checkBalance() {
        if (checkPin()) {
            System.out.printf("Your current balance is: Rs. %.2f%n", balance);  // Formatting balance to 2 decimal places
            System.out.println("Transaction Completed");
        } else {
            System.out.println("Wrong PIN Entered\nTransaction Cancelled");
        }
    }

    void depositMoney() {
        System.out.println("Enter the deposit amount: ");
        float deposit = sc.nextFloat();
        if (checkPin()) {
            balance += deposit;
            System.out.println("Amount deposited successfully in your account.");
            System.out.println("Transaction Completed");
        } else {
            System.out.println("Wrong PIN Entered\nTransaction Cancelled");
        }
    }

    void withdrawMoney() {
        if (checkPin()) {
            System.out.println("Enter the withdrawal amount: \nPlease enter in multiples of 500:");
            int withdraw = sc.nextInt();
            if (withdraw % 500 != 0) {
                System.out.println("Please enter an amount in multiples of 500.");
                return;
            }
            if (withdraw > balance) {
                System.out.println("Insufficient Balance in your Account.");
            } else {
                balance -= withdraw;
                System.out.println("Amount withdrawal successful");
            }
            System.out.println("Would you like to display the Balance? (y/n)");
            if (sc.next().charAt(0) == 'y') {
                checkBalance();
            } else {
                System.out.println("Transaction Completed");
            }
        } else {
            System.out.println("Wrong PIN Entered\nTransaction Cancelled");
        }
    }

    void changePin() {
        if (checkPin()) {
            System.out.println("ENTER YOUR NEW PIN: ");
            int newPin = sc.nextInt();
            System.out.println("CONFIRM YOUR PIN: ");
            int confirmPin = sc.nextInt();
            if (newPin == confirmPin) {
                Pin = newPin;
                System.out.println("PIN changed successfully.");
                System.out.println("Transaction Completed");
            } else {
                System.out.println("PIN mismatch! Transaction Cancelled");
            }
        } else {
            System.out.println("Wrong PIN Entered\nTransaction Cancelled");
        }
    }

    boolean checkPin() {
        System.out.println("Enter your PIN:");
        int enteredPin = sc.nextInt();
        return enteredPin == Pin;
    }

    public static void main(String[] args) {
        ATMInterface atm = new ATMInterface();
        atm.startOperation();
    }
}