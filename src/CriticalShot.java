public class CriticalShot extends Stunt {

    public CriticalShot() {

        name = "Critical-Shot";
    }

    @Override
    public Item copy() {
        Item criticalShot = new CriticalShot();
        criticalShot.name = "Critical-Shot";
        criticalShot.rarity = "Stunt:";
        return criticalShot;
    }
}
