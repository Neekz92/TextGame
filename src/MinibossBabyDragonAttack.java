public class MinibossBabyDragonAttack extends CombatEncounter {

    public MinibossBabyDragonAttack() {

        xpBonus = 40;
    }

    @Override
    public void setup() {

        distributedRewards = false;
        addItem(legendaryPotion);
        addItem(legendaryArmor);
        addItem(legendarySword);
        addItem(legendaryStaff);
        addItem(legendaryBow);

        System.out.println("*** Encounter Phase ***");
        displayParticipants();
        System.out.println("########################");
        System.out.println(playerArray[1] + "'s stamina: " + playerArray[0].stamina);
        System.out.println("What do you do?");
    }
}