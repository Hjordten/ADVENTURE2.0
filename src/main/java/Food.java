public class Food extends Item {
    private int healthValue;

    public Food(String name, int healthValue) {
        super(name);
        this.healthValue = healthValue;
    }

    public String toString () {
        return super.toString() + "(HP: " + healthValue + ")";
    }
    public int getHealthValue() {
        return healthValue;
    }

}
