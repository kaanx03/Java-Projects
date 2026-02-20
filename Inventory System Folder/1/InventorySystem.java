
    String[] productNames = {"Elma","Peçete","Ekmek","Su","Tavuk"};
    double[] productPrices = {2.5,1,3,0.5,10};
    int[] productStocks = {10,10,10,10,10};
    double total =0;
    String[][] customerBasket = new String[5][2];
    int count=0;
    Scanner scan = new Scanner(System.in);



    void main(){
    // Bakkal Amca
    boolean isRunning = true;
    int choice;
    System.out.println("Welcome to Bakkal Amca!");
        while (isRunning) {

            System.out.print("Select an action (0:Exit | 1:Display Products | 2:Go To Checkout : ");
            choice = scan.nextInt();

            switch (choice){
                case 0 -> isRunning = false;
                case 1-> displayProducts();
                case 2 -> goToCheckOut();
            }
        }


    }

void displayProducts(){
    for (int i = 0; i < productNames.length; i++) {
        System.out.printf("%d.%-10s : %10s -> %d\n", (i + 1), productNames[i], String.format("$%.2f", productPrices[i]),productStocks[i]);
    }
    handleSelling();

}
void handleSelling(){
    System.out.print("Enter product number: ");
    int choice = scan.nextInt();

    if(choice>5 || choice<1){
        System.out.println("You've entered a wrong product number..");
    }else{
        choice--;
        System.out.print("How many you want : ");
        int quantity = scan.nextInt();

        if(quantity>productStocks[choice] || quantity<0){
            System.out.println("It either exceeds the limit or below 0");
        }else{
            total += quantity * productPrices[choice];
            productStocks[choice] -= quantity;

            boolean productNotExistInBasket = true;

            for (int i = 0; i < customerBasket.length; i++) {
                if(productNames[choice].equals(customerBasket[i][0])){
                    System.out.println("ÜRÜN SEPETTE VAR");
                    int temp = Integer.parseInt(customerBasket[i][1]) + quantity;
                    customerBasket[i][1] = Integer.toString(temp);
                    productNotExistInBasket = false;
                    break;
                }
            }

            if(productNotExistInBasket){
                System.out.println("ÜRÜN SEPETTE YOKTU YENİ EKLENİYOR");
            customerBasket[count][0] = productNames[choice];
            customerBasket[count][1] = Integer.toString(quantity);
            count++;
            }
        }
    }

    if(total>0){
    System.out.println("\n *** Basket ***");
        for (String[] basket : customerBasket) {
            if (basket[0] != null)
                System.out.println(basket[1] + " pieces of " + basket[0]);
        }
    }
}


void goToCheckOut(){
        boolean paid = false;
    System.out.println("Total is "+total);
    System.out.print("Enter an amount to pay");
    double userPaidAmount = scan.nextDouble();

    if(userPaidAmount<total){
        System.out.println("There is $"+(total-userPaidAmount)+" missing.");
    } else if (userPaidAmount>total) {
        System.out.println("Here is your $"+(userPaidAmount-total));
        paid = true;
    }else{
        System.out.println("Thank you for the shopping!");
        paid = true;
    }
    if(paid){
    Arrays.fill(productStocks, 10);
    Arrays.fill(customerBasket,null);
    }
}