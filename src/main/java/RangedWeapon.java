abstract class RangedWeapon extends Weapon {

    private int weaponUses;

    public RangedWeapon(String name, int weaponDamage, int weaponUses) {
        super(name, weaponDamage);
        this.weaponUses = weaponUses;
    }

    public int getWeaponUses() {
        return weaponUses;
    }

    @Override
    public boolean canAttack() {
        if (weaponUses <= 0) {
            System.out.println("You have no ammo left.");
            return false;
        } else {
            weaponUses--;
        }
        return super.canAttack();
    }

    @Override
    public String toString() {
        return super.toString() + " " + "Weapon damage: " + getWeaponDamage() + ", " + "Weapon user ammo: " + weaponUses;
    }
}
