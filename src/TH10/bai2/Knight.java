package TH10.bai2;

public class Knight extends Character{
    @Override
    public void fight() {
        System.out.println("Knight fight");
        getWeapon().useWeapon();
    }

    public Knight(WeaponBehavior weapon) {
        super(weapon);
    }

    public Knight() {
    }
}
