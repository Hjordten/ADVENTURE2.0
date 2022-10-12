public class Enemy {
    private String enemyName;
    private int enemyHealth;
    private String enemyWeapon;
    private int enemyWeaponDamage;


    public Enemy(){

    }

    public Enemy (String enemyName, int enemyHealth, String enemyWeapon, int enemyWeaponDamage) {
        this.enemyName = enemyName;
        this.enemyHealth = enemyHealth;
        this.enemyWeapon = enemyWeapon;
        this.enemyWeaponDamage = enemyWeaponDamage;
    }

    public int getEnemyHealth(){
        return enemyHealth;
    }

    public String getEnemyWeapon(){
        return enemyWeapon;
    }

    public int getEnemyWeaponDamage(){
        return enemyWeaponDamage;
    }

    public String getEnemyName(){
        return enemyName;
    }

    public void attackHealthEnemy(int damage) {
        this.enemyHealth -= damage;
    }



    @Override
    public String toString() {
        return "Enemy name: " + enemyName + "" + "Enemy Health: " + enemyHealth + "" + "Enemy Weapon: " + enemyWeapon + "" + "Enemy Weapon Damage: " + enemyWeaponDamage;
    }
}
