
    void main() {

    Scanner scan = new Scanner(System.in);
    int userChoice;
    String password;
    double amount;


    Bank bank = new Bank("Kuveyt Türk");
    bank.addCustomer(new Customer(1001,100,"password"));
    bank.addCustomer(new Customer(1002,500,"pass123"));

    System.out.print("Enter your account number: ");
    int accNo = scan.nextInt();
    scan.nextLine();
    Customer customer = bank.findCustomer(accNo);
    if(customer == null){
        System.out.println("Couldn't find the customer.");
    }else{


    while (!customer.isActive() && customer.getPassTryLeft()>0){
        System.out.print(
                """
                        
                        ==============================
                                SECURE LOGIN         \s
                        ==============================
                        Please enter your password
                        ------------------------------
                        ➤ Password:\s"""
        );
        password = scan.nextLine();
        customer.checkPassword(password);
    }



    while(customer.isActive()){
        System.out.print(
                """
                       \s
                        ==============================
                                BANKING SYSTEM      \s
                        ==============================
                        1 ➤ Display Balance
                        2 ➤ Deposit Money
                        3 ➤ Withdraw Money
                        4 ➤ Display Previous Transactions
                        0 ➤ Exit
                        ==============================
                        Please select an operation:\s"""
        );
        userChoice = scan.nextInt();


        switch (userChoice){
            case 0 -> customer.setActive(false);
            case 1 -> customer.displayBalance();
            case 2 -> {
                System.out.print("Enter an amount to deposit : ");
                amount = scan.nextDouble();
                customer.depositMoney(amount);
            }
            case 3 -> {
                System.out.print("Enter an amount to withdraw : ");
                amount = scan.nextDouble();
                customer.withdrawMoney(amount);

            }
            case 4 -> customer.displayTransactionHistory();
        }
    }
    }

    scan.close();
    }

