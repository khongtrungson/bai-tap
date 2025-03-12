package TH10.bai2;

public class Test {
    public static void main(String[] args) {
        King k = new King();
        k.setWeapon(new KnifeBehavior());
        k.fight(); // k đang sử dụng Knife
        k.setWeapon(new SwordBehavior());
        k.fight(); // k đang s dụng Sword
    }
}
