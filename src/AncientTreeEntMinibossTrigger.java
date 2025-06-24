public class AncientTreeEntMinibossTrigger extends SocialEncounter {

    public AncientTreeEntMinibossTrigger() {

    }

    @Override
    public void setup() {

        distributedRewards = false;


        System.out.println("In the thickest part of the forest, you come across a shrine surrounded by large trees with human faces wearing twisted smiles carved into them. In front of the largest one, a patch of dirt appears to be disturbed, like something was uprooted here.");
        System.out.println("You cannot interact with this monolith. (I also haven't added the item needed to interact with it yet.)");
    }

    @Override
    public void options() {

        playerArray[0].getLocation().endSocialEncounter();
    }
}
