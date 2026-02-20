Scanner scan = new Scanner(System.in);
double balance = 0.0;
String[] transactionHistory = new String[5];
int transactionCounter = 0;

void main(){

    //  Tek kullanıcılı ATM UYGULAMASI
    /*

        1. BAŞLAT
        2. BAKİYE, ŞİFRE, İŞLEM GEÇMİŞİ DİZİSİ DEĞİŞKENLERİNİ TANIMLA
        3. KULLANICIYA WHİLE LOOP İLE GİRİŞ DOĞRULAMASI YAPTIR
        4. KULLANICI GİRİŞ DOĞRULAMASINI 3 İŞLEMDE GEÇEMEZSE İF İLE DÖNGÜYÜ KIR
        5. GİRİŞ YAPILDIKTAN SONRA İSACTİVE BOOLEANI İLE DEVAM EDEN WHİLE DÖNGÜSÜ KIR
        KULLANICININ YAPABİLECEĞİ İŞLEMLERİ VE ÇIKIŞ YAPMA OPSİYONU SUN.
        6. Yapılacak işlemler bakiye sorgulama, para yatırma, para çekme, önceki işlemleri görüntüleme,çıkış
        bunu switch döngüsü ile yönlendirme yaparak kontrol et.
        7. Kullanıcının yaptığı işlemleri bir arrayde tutacağımız için bu arrayin boyutu sabit olacak bunu o yüzden
        sürekli olarak optimize edeceğiz atıyorum 5 tane alanlık bi işlem geçmişi olan bi array açıp onun içinde shifting yapacağız.
        yapılacak işlemler için fonksiyonlar kullanacağız.
        8. BİTTİ
     */
    String password = "password";
    boolean notLogged = true;
    String userEnteredPassword;
    int passTryLeft = 3;
    boolean isActive = true;
    int userOperationChoice;

    while(notLogged){

        System.out.print("Enter the password :");
        userEnteredPassword = scan.nextLine();
        passTryLeft--;

        if(passTryLeft == 0){
            isActive = false;
            break;
        }
        if(password.equals(userEnteredPassword)){
            notLogged = false;
        }else{
            System.out.println("Wrong password try again ("+(passTryLeft)+" try left)");

        }
    }

    while(isActive){
        System.out.println("1:Show Balance\n2:Add Balance\n3:Deposit Money\n4:Show Previous Transactions\n0:Exit");
        System.out.print("Enter an operation to perform : ");
        userOperationChoice = scan.nextInt();
        switch (userOperationChoice){
            case 0 -> isActive = false;
            case 1 -> System.out.printf("%.2f\n",balance);
            case 2 -> addBalance();
            case 3 -> depositMoney();
            case 4 -> showPrevTransactions();

        }
    }
}
void addBalance(){
    System.out.print("Enter an amount you want to add : ");
    double amount = scan.nextDouble();
    balance += amount;
    System.out.println((int)amount+"$ is added to your account!");
    addTransaction(amount,'+');
}

void depositMoney(){
    System.out.println("Enter an amount to deposit : ");
    double amount = scan.nextDouble();
    if(balance<amount){
        System.out.println("Unsufficient Balance..");
    }else{
        System.out.println((int)amount+"$ is deposited from your account!");
        balance-=amount;
        addTransaction(amount,'-');
    }
}


void addTransaction(double amount,char operation){
    if(transactionHistory[4]== null){
        switch (operation){
            case '+' -> transactionHistory[transactionCounter] = amount+"$ is added to account.";
            case '-' -> transactionHistory[transactionCounter] = amount+"$ is deposited.";
        }
        transactionCounter++;
    }else{
        for (int i = 0; i < transactionHistory.length-2; i++) {
            transactionHistory[i] = transactionHistory[i+1];
        }
        switch (operation){
            case '+' -> transactionHistory[transactionHistory.length-1] = amount+"$ is added to account.";
            case '-' -> transactionHistory[transactionHistory.length-1] = amount+"$ is deposited.";
        }
    }

}

void showPrevTransactions(){
        System.out.println("* * * * * * * * * * * * * * * * ");
    for (int i = 0; i < transactionCounter; i++) {
        System.out.println((i+1)+". "+transactionHistory[i]);
    }
        System.out.println("* * * * * * * * * * * * * * * * ");
}






