import java.util.ArrayList;

public class Room {

    private String roomName;
    private String roomDescription;

    private Room north;
    private Room south;
    private Room east;
    private Room west;

    private ArrayList<Item> items = new ArrayList<>();
    private ArrayList <Enemy> enemyList = new ArrayList<>();

    Item item = new Item();
    public Room(String roomName, String roomDescription) {
        this.roomName = roomName;
        this.roomDescription = roomDescription;
    }

    public String getRoomDescription() {
        return roomDescription;
    }

    public String getRoomName() {
        return roomName;
    }


    public void setEast(Room room) {
        this.east = room;
    }

    public void setNorth(Room room) {
        this.north = room;
    }

    public void setSouth(Room room) {
        this.south = room;
    }

    public void setWest(Room room) {
        this.west = room;
    }

    public Room getEast() {
        return east;
    }

    public Room getWest() {
        return west;
    }

    public Room getNorth() {
        return north;
    }

    public Room getSouth() {
        return south;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void addEnemy(Enemy enemy) {
        enemyList.add(enemy);
    }

    public void addItemsToRoom(Room room, String itemName) {
        room.addItem(new Item(itemName));
    }

    public Enemy getEnemy(){
        return enemyList.get(0);
    }

    public void addFoodToRoom(Room room, String itemName, int healthValue) {
        room.addItem(new Food(itemName, healthValue));
    }

    public void addMeleeWeapon(Room room, String itemName, int weaponDamage) {
        room.addItem(new MeleeWeapon(itemName, weaponDamage));
    }

    public void addRangedWeapon(Room room, String itemName, int weaponDamage, int weaponUses) {
        room.addItem(new RangedWeapon(itemName, weaponDamage, weaponUses) {
        });
    }

    public void addEnemy(Room room, String enemyName, int enemyHealth, String enemyWeapon, int enemyWeaponDamage) {
        room.addEnemy(new Enemy(enemyName, enemyHealth, enemyWeapon, enemyWeaponDamage));
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void showItem() {
        System.out.println(items.toString());
    }


    @Override
    public String toString() {
        return "You are currently in: " + "\n" + "Room number: " + roomName + "\n" + "Room description: " + roomDescription + "\n" + "Current items in the room: " + items + "\n" + enemyList;
    }

    public void removeEnemy(Enemy enemy) {
        enemyList.remove(enemy);
    }

    public boolean enemyCheck(){
        return !enemyList.isEmpty();

    }
}


