package TH10.bai2;

public abstract class Character {
    private WeaponBehavior weapon;

    public Character(WeaponBehavior weapon) {
        this.weapon = weapon;
    }
    public Character() {
    }

    public WeaponBehavior getWeapon() {
        return weapon;
    }

    public abstract void fight();

    public void setWeapon(WeaponBehavior w){
        this.weapon = w;
    }
}
