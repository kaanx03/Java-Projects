import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        Character hero = new Character("Kaan");
        Character enemy = new Character("Goblin");

        // Item oluştur
        Feature heal = new Feature("Heal +20", 20);
        Item potion = new Item("Healing Potion");
        potion.addFeature(heal);
        hero.getInventory().add(potion);

        System.out.println("=== MINI TERMINAL RPG ===");
        System.out.println("You are fighting a Goblin!");
        System.out.println();

        while (hero.getHealth() > 0 && enemy.getHealth() > 0) {

            System.out.println("Your HP: " + hero.getHealth());
            System.out.println("Goblin HP: " + enemy.getHealth());
            System.out.println();
            System.out.println("1 - Attack");
            System.out.println("2 - Use Potion");
            System.out.println("3 - Show Inventory");
            System.out.print("Choose: ");

            int choice = scanner.nextInt();
            System.out.println();

            // PLAYER TURN
            if (choice == 1) {
                int damage = random.nextInt(16) + 5; // 5-20 arası
                System.out.println("You hit Goblin for " + damage + " damage!");
                enemy.changeHealth(-damage);
            }
            else if (choice == 2) {
                if (hero.getInventory().getItems().isEmpty()) {
                    System.out.println("No items!");
                } else {
                    System.out.println("You used Healing Potion!");
                    hero.changeHealth(potion.use(heal));
                }
            }
            else if (choice == 3) {
                hero.getInventory().displayItems();
            }

            // ENEMY TURN
            if (enemy.getHealth() > 0) {
                int enemyDamage = random.nextInt(11) + 5; // 5-15
                System.out.println("Goblin attacks you for " + enemyDamage + " damage!");
                hero.changeHealth(-enemyDamage);
            }

            System.out.println("----------------------");
        }

        // GAME RESULT
        if (hero.getHealth() <= 0) {
            System.out.println("You died. Game Over.");
        } else {
            System.out.println("You defeated the Goblin! Victory!");
        }

        scanner.close();
    }
}