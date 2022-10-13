//TODO move take item & drop item to player class

import java.util.ArrayList;

public class Player {

    Map map = new Map();

    private ArrayList<Item> playerInventory = new ArrayList<>();

    private String playerName;

    private Room currentRoom = map.getStarterRoom();

    private int playerHealthPoints = 100;

    private Weapon weaponEquipped;

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public void setPlayerName(String PlayerName) {
        this.playerName = playerName;
    }
    public String look() {
        return currentRoom.toString();
    }

    public int getPlayerHealthPoints() {
        return playerHealthPoints;
    }

    public ArrayList<Item> getPlayerInventory() {
        return playerInventory;
    }

    public boolean eat(String foodName) {
        for (Item item : playerInventory) {
            if (item instanceof Food) {
                if (foodName.equals(item.getName())) {
                    System.out.println(playerInventory);
                    Food selectedFood = (Food) item;
                    playerHealthPoints += selectedFood.getHealthValue();
                    playerInventory.remove(item);
                    break;
                }

            }
        } return false;
    }

    public boolean weaponEquip(String weaponName) {
        for (Item item : playerInventory) {
            if (item instanceof Weapon) {
                if (item.getName().equals(weaponName)) {
                    Weapon selectedWeapon = (Weapon) item;
                    weaponEquipped = selectedWeapon;
                    playerInventory.remove(selectedWeapon);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean move(String direction) {
        Room requestedRoom = null;

        if (direction.charAt(0) == 'n') {
            requestedRoom = currentRoom.getNorth();
        } else if (direction.charAt(0) == 'e') {
            requestedRoom = currentRoom.getEast();
        } else if (direction.charAt(0) == 's') {
            requestedRoom = currentRoom.getSouth();
        } else if (direction.charAt(0) == 'w') {
            requestedRoom = currentRoom.getWest();
        }

        if (requestedRoom != null) {
            currentRoom = requestedRoom;
            return true;
        } else {
            return false;
        }
    }

    public void attackHealthPlayer(int damage) {
        playerHealthPoints -= damage;
    }

    public boolean attackEnemy() {
        if (currentRoom.enemyCheck() == false) {
            System.out.println("There are no enemies to fight.");
        } else if (weaponEquipped == null) {
            System.out.println("You don't have a weapon equipped");
        } else if (weaponEquipped.canAttack() == false) {
            System.out.println("Fleeing from enemy");
        } else {
            Enemy enemy = currentRoom.getEnemy();
            System.out.println("You encounter " + enemy.getEnemyName());
            enemy.attackHealthEnemy(this.weaponEquipped.getWeaponDamage());
            attackHealthPlayer(enemy.getEnemyWeaponDamage());
            System.out.println("Fight is ongoing." + "Player HP: " + playerHealthPoints + " " + "Enemy HP: " + enemy.getEnemyHealth());
            if (playerHealthPoints <= 0 && enemy.getEnemyHealth() <= 0) {
                System.out.println("Both the enemy and you hit each other with a deadly blow at the same time, and you now lay on the floor dead. #PrayForHorande");
                System.exit(0);
            } else if (playerHealthPoints <= 0) {
                System.out.println("You have been slain by: " + enemy.getEnemyName());
                System.exit(0);
            } else if (enemy.getEnemyHealth() <= 0) {
                System.out.println("You have slain: " + enemy.getEnemyName());
                currentRoom.removeEnemy(enemy);
            }
        } return false;
    }

    public boolean takeItem (String itemName) {
        for (Item item : currentRoom.getItems()) {
            if (item.getName().equals(itemName)) {
                playerInventory.add(item);
                currentRoom.getItems().remove(item);
                return true;
            }
        } return false;
    }

    public boolean dropItem (String itemName) {
        for (Item item : playerInventory) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                playerInventory.remove(item);
                currentRoom.getItems().add(item);
            } return true;
        } return false;
    }
}
