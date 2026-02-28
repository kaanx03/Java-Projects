void main(){

    Scanner scan = new Scanner(System.in);
    Store store = new Store();
    Customer customer = new Customer("Kaan",100);
    store.addCustomer(customer);
    boolean isActive = true;
    int choice;
    int pChoice;
    int pQuantity;

    System.out.println("Welcome to Bakkal Amca!");
    while(isActive){
        System.out.println("0:Exit\n1:Display Products\n2:Add Product\n3:Remove Product\n4:Go to checkout");
        System.out.print("Please select an operation :");
        choice = scan.nextInt();
        switch (choice){
            case 0 ->{ isActive = false;}
            case 1 ->{store.displayProducts();}
            case 2->{
                System.out.print("Enter product number you want : ");
                pChoice = scan.nextInt() -1;
                System.out.print("How many you want : ");
                pQuantity = scan.nextInt();

                if(pChoice>=0 && pChoice<10 && pQuantity>0 && pQuantity<=store.getProducts(pChoice).getStock() ){
                    customer.getCart().addItem(store.getProducts(pChoice),pQuantity);
                    store.getProducts(pChoice).setStock(pQuantity);
                    customer.getCart().displayCart();
                }else{
                    System.out.println("Something went wrong..");
                }
            }
            case 3->{
                customer.getCart().displayCart();
                System.out.print("Enter the number of the item to delete : ");
                pChoice = scan.nextInt()-1;
                if(customer.getCart().getItems().size()>pChoice && pChoice>=0){
                    customer.getCart().removeItem(pChoice);
                    System.out.println("Removal Succesful!");
                }
                else{
                    System.out.println("Something went wrong..");
                }
            }
            case 4->{
                double total = customer.getCart().calculateTotal();
                System.out.printf("Total is %.2f\n",total);
                if(customer.getMoney() >= total){
                    customer.setMoney(total);
                    customer.getCart().getItems().clear();
                System.out.printf("Thank you for payment! Here is your change : %.2f\n",customer.getMoney());
                }else{
                    System.out.println("Insufficient Balance..");
                }
            }
        }

    }

    scan.close();

}