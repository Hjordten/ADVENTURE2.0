public class MeleeWeapon extends Weapon {


    public MeleeWeapon(String name, int weaponDamage) {
        super(name, weaponDamage);
    }

    @Override
    public String toString() {
        return super.toString() + " " + "Weapon damage: " + " " +  getWeaponDamage();
    }
}
