public class Taunt extends Skill {

    public Taunt() {

        name = "Taunt";
    }

    @Override
    public Item copy() {
        Item taunt = new Taunt();
        taunt.name = "Shield-Bash Combo";
        taunt.rarity = "(Skill)";
        return taunt;
    }
}
