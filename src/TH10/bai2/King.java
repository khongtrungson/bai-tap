package TH10.bai2;

public class King extends Character{
    @Override
    public void fight() {
        System.out.println("king fight");
        getWeapon().useWeapon();
    }

    public King(WeaponBehavior weapon) {
        super(weapon);
    }

    public King() {
    }
}
