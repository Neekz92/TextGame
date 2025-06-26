public class MinibossUndeadAttack extends CombatEncounter {

    public MinibossUndeadAttack() {

        xpBonus = 40;
        description = "Undead Attack Miniboss Encounter";
    }

    @Override
    public void setup() {

        playerArray[6].allowedBossToSpawn = 1;
        playerArray[0].allowedBossToSpawn = 2;
        playerArray[1].allowedBossToSpawn = 2;
        playerArray[2].allowedBossToSpawn = 2;
        playerArray[3].allowedBossToSpawn = 2;
        playerArray[4].allowedBossToSpawn = 2;
        playerArray[5].allowedBossToSpawn = 2;

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
        System.out.println(playerArray[6] + " faces off against " + playerArray[0]);
        System.out.println("**********");
        System.out.println("**********");
        System.out.println("**********");
        System.out.println("");
    }
}
