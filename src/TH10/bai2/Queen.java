package TH10.bai2;

public class Queen extends Character{
    @Override
    public void fight() {
        System.out.println("queen fight");
        getWeapon().useWeapon();
    }

    public Queen(WeaponBehavior weapon) {
        super(weapon);
    }

    public Queen() {
    }
}
