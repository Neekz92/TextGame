public class MinibossTreeEntAttack extends CombatEncounter {

    public MinibossTreeEntAttack() {

        xpBonus = 40;
        description = "Tree Ent Attack Miniboss Encounter";
    }

    @Override
    public void setup() {

        playerArray[1].allowedBossToSpawn = 1;
        playerArray[0].allowedBossToSpawn = 2;
        distributedRewards = false;
        addItem(legendaryPotion);
        addItem(legendaryArmor);
        addItem(legendarySword);
        addItem(legendaryStaff);
        addItem(legendaryBow);

        System.out.println("");
        System.out.println("**********");
        System.out.println("**********");
        System.out.println("**********");
        System.out.println(playerArray[1] + " faces off against " + playerArray[0]);
        System.out.println("**********");
        System.out.println("**********");
        System.out.println("**********");
        System.out.println("");

    }
}