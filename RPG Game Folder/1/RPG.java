void main(){

 /*
    Metin Tabanlı RYO (RPG) Savaş Oyunu

    Şu An Nasıl Yapacaksın? Karakterin canı (HP) ve düşmanın canı için değişkenler tanımla.
    Savaş bitene kadar dönen bir while döngüsü kur. if-else ile oyuncuya "Saldır (1) veya İyileş (2)" seçenekleri sun.
    Rastgele sayılar (Random) üreterek hasar miktarını belirle.
  */

    int charHealth = 100;
    int enemyHealth = 100;
    int charSkillPoint;
    int enemyDamage;
    int critChance;
    String charChoice;
    int charLvl= 1;
    boolean isGameRunning;
    Random rnd = new Random();
    Scanner scan = new Scanner(System.in);
    String[] animations = {"""
============================================

           HERO IS HEALING

                O
               /|\\
               / \\

             +  +  +
           +    +    +
             +  +  +


--------------------------------------------

""","""
============================================

              HERO ATTACKS

       O  ------->        ( `A´ )
      /|\\                <  /|\\  >
      / \\                    / \\

              *  *  *
             *  SLASH  *
              *  *  *


--------------------------------------------
""","""
============================================

              ENEMY ATTACKS

       ( `A´ )  ------->   O
      <  /|\\  >           /|\\
         / \\             / \\

          >>>  CLAW ATTACK  <<<


--------------------------------------------""" };

    System.out.println("=======================================");
    System.out.println("    WELCOME TO BATTLE ARENA v1.0");
    System.out.println("=======================================");
    System.out.println();

    do {
        charSkillPoint = rnd.nextInt(10*charLvl);
        enemyDamage = rnd.nextInt(5*(charLvl));
        critChance = rnd.nextInt(100);
        if(critChance>90){
            charSkillPoint *=2;
            System.out.println(" * * * CRIT ACTIVATED!!! * * * ");
        }

        System.out.print("Select an ability (0->Healing 1->Attack) : ");
        charChoice = scan.nextLine();

        // Character Attack & Heal Choice
        switch (charChoice){
            case "0" ->{
                charHealth += charSkillPoint;
                System.out.println(animations[0]);
                displayHealth(charHealth,enemyHealth);
            }
            case "1"->{
                enemyHealth -= charSkillPoint;
                System.out.println(animations[1]);
                displayHealth(charHealth,enemyHealth);
            }

            default -> System.out.println("Something went wrong");
        }
        // Enemy Attack
        charHealth -= enemyDamage;
        System.out.println(animations[2]);
        displayHealth(charHealth,enemyHealth);


        isGameRunning = (charHealth>0) || (enemyHealth<0);

        if(charHealth<=0){
            System.out.println("YOU LOSE!");
        } else if (enemyHealth<=0) {
            System.out.println("YOU WIN!");
        }

    }while (isGameRunning);



}
    void displayHealth(int chr,int enemy){
        String[] healthBars = {"","#", "##", "###", "####", "#####", "######", "#######", "########", "#########", "##########"};

        String chrBar = healthBars[chr/10];
        String enemyBar = healthBars[enemy/10];
        System.out.printf("HERO HP  : [%-10s] %3d/100\n", chrBar, chr);
        System.out.printf("ENEMY HP : [%-10s] %3d/100\n", enemyBar, enemy);
    }
