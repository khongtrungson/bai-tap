package TH10.bai2;

public class Troll extends Character{
    public Troll(WeaponBehavior weapon) {
        super(weapon);
    }

    public Troll() {
    }

    @Override
    public void fight() {
        System.out.println("troll fight");
        getWeapon().useWeapon();
    }
}
