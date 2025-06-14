public class PerfectParry extends Skill {

    public PerfectParry() {
        name = "Perfect-Parry";
    }

    @Override
    public Item copy() {
        Item perfectParry = new PerfectParry();
        perfectParry.name = "Perfect-Parry";
        perfectParry.rarity = "Skill:";
        return perfectParry;
    }
}
