import java.util.Scanner;
public class UI {

    private Player player = new Player();

    private Adventure adventure = new Adventure(player);
    private Scanner sc = new Scanner(System.in);

    public void startUI() {

        boolean stop = false;

        System.out.println("""
                Welcome to our text adventure
                                
                ------------------------------------------
                To navigate within the rooms use the following commands:
                    
                Enter go north if you wish to go north
                Enter go south if you wish to go south
                Enter go east if you wish to go east
                Enter go west if you wish to go west
                    
                -------------------------------------------
                Acces commands:
                    
                Enter inventory if you wish to see current item inventory
                Enter look to see current room and items in the room
                Enter take item if you wish to take an item in your inventory
                Enter drop item if you wish to drop an item in your inventory
                Enter health if you wish to see current player health
                Enter equip if you wish to equip a weapon from your inventory
                Enter attack to attack an enemy                        
                Enter help for list of options and useful information
                -------------------------------------------
                """);

        while (stop == false) {
            String userInput = sc.nextLine().toLowerCase();

            String[] userInputs = userInput.split(" ");
            String command = userInputs[0];
            String userChoice = "";
            if (userInputs.length > 1) {
                userChoice = userInputs[1];
            }


            try {

                switch (command) {
                    case "go":
                        boolean succes = adventure.go(userChoice);
                        if (succes) {
                            System.out.println("You have gone: " + userChoice);
                        } else {
                            System.out.println("You cannot go that way");
                        }
                        break;
                    case "equip":
                        System.out.println("Enter the name of the weapon you wanna equip: ");
                        System.out.println(player.inventoryShow());
                        String weaponEquip = sc.nextLine().toLowerCase();
                        player.weaponEquip(weaponEquip);
                        System.out.println("You have now equiped: " + weaponEquip);
                        break;
                    case "inventory":
                        System.out.println(player.inventoryShow());
                        System.out.println("Enter command: ");
                        break;
                    case "take":
                        System.out.println("Enter the number of the item you wanna remove");
                        for (int i = 0; i < player.getCurrentRoom().getItems().size(); i++) {
                            System.out.println(i + ":" + player.getCurrentRoom().getItems().get(i));
                        }
                        int itemtakeNumber = sc.nextInt();
                        sc.nextLine();
                    {
                        if (itemtakeNumber <= player.getCurrentRoom().getItems().size()) {
                            System.out.println("");

                            Item item = player.getCurrentRoom().getItems().get(itemtakeNumber);
                            player.getCurrentRoom().getItems().remove(itemtakeNumber);
                            player.addItem(item);
                            System.out.println("You have taken: " + item);
                        }
                    }
                    System.out.println("Enter command: ");
                    break;
                    case "drop":
                        //TODO create fail safe for entering other than int
                        System.out.println("Enter the number of the item you wanna drop");
                        for (int i = 0; i < player.getPlayerInventory().size(); i++) {
                            System.out.println(i + ":" + player.getPlayerInventory().get(i));
                        }
                        int itemDropNumber = sc.nextInt();
                        player.getCurrentRoom().addItem(player.getPlayerInventory().get(itemDropNumber));
                        player.getPlayerInventory().remove(itemDropNumber);
                        break;
                    case "health":
                        player.playerHealth();
                        System.out.println("Enter command: ");
                        break;
                    case "eat":
                        if (player.getPlayerInventory() != null) {
                            System.out.println("Please enter the name of the food you wish to eat");
                            String foodName = sc.nextLine().toLowerCase();
                            player.eat(foodName);
                        } else {
                            System.out.println("You currently dont have any items in your bag");
                        }
                        System.out.println("Enter command: ");
                        break;
                    case "attack":
                        player.attackEnemy();
                        break;
                    case "help":
                        System.out.println("""
                                -------------------------------------------
                                Typing "Look" and pressing enter --> Your character looks around the current room the person is in, highlighting usable object.
                                Typing "Exit" and pressing enter --> Closes the program. Your progress wont be saved!
                                Typing North and pressing enter --> Checks to see if you can move north. Informing the player if its doable.
                                Typing East and pressing enter --> Checks to see if you can move East. Informing the player if its doable.
                                Typing West and pressing enter --> Checks to see if you can move West. Informing the player if its doable.
                                Typing South and pressing enter --> Checks to see if you can move south. Informing the player if its doable.
                                -------------------------------------------
                                        """);
                        System.out.println("Enter command: ");
                        break;
                    case "look":
                        System.out.println(player.look());
                        System.out.println("Enter command: ");
                        break;
                    case "exit":
                        System.out.println("Closing adventure.");
                        stop = true;
                        break;
                    default:
                        System.out.println("Invalid input, please try again");
                }
            } catch(Exception e){
                System.out.println("please enter a valid number from the list.");
                System.out.println(e.getMessage());
            }
        }
    }
}