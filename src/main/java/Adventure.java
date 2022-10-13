//TODO IF TIME move get methods here.

import java.util.ArrayList;

public class Adventure {

    Map map = new Map();
    Player player = new Player();

    public boolean go(String direction){
        return player.move(direction);
    }

    public void setName (String name) {
        player.setPlayerName(name);
    }
    public ArrayList<Item> inventoryShow() {
    return player.getPlayerInventory();
    }

    public boolean weaponEquip(String weaponEquip) {
        return player.weaponEquip(weaponEquip);
    }

    public Room getCurrentRoom() {
        return player.getCurrentRoom();
    }

    public boolean take(String itemName) {
        return player.takeItem(itemName);
    }

    public boolean drop(String itemName) {
        return player.dropItem(itemName);
    }

    public int playerHealth() {
        return player.getPlayerHealthPoints();
    }

    public ArrayList<Item> getPlayerInventory() {
        return player.getPlayerInventory();
    }

    public boolean eat(String foodName) {
        return player.eat(foodName);
    }

    public boolean attackEnemy() {
        return player.attackEnemy();
    }

    public String look() {
        return player.look();
    }
}