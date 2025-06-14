public class ShieldBashCombo extends Skill {

    public ShieldBashCombo() {
        name = "Shield-Bash Combo";
    }

    @Override
    public Item copy() {
        Item shieldBashCombo = new ShieldBashCombo();
        shieldBashCombo.name = "Shield-Bash Combo";
        shieldBashCombo.rarity = "(Skill)";
        return shieldBashCombo;
    }
}
