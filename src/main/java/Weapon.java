public class Weapon extends Item {

    private int weaponDamage;
    public Weapon(String name, int weaponDamage) {
        super(name);
        this.weaponDamage = weaponDamage;
    }

    public int getWeaponDamage() {
        return weaponDamage;
    }

    public boolean canAttack(){
        return true;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

