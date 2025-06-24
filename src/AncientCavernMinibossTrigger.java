public class AncientCavernMinibossTrigger extends SocialEncounter {

    public AncientCavernMinibossTrigger() {

    }

    @Override
    public void setup() {

        distributedRewards = false;


        System.out.println("You wander into a dark cavern, guided only by torchlight. You step over the bones of countless people that have long-since been sent to the underworld.");
        System.out.println("At the end of the cave, you find a mural depicting a legion of armed corpses marching on the three Kingdoms. The mural has a section of it missing, perhaps stolen.");
        System.out.println("\"...Return the fragment, and you shall invite our mercy for when we rise...\")");
        System.out.println("You cannot interact with this monolith. (I also haven't added the item needed to interact with it yet.)");
    }

    @Override
    public void options() {

        playerArray[0].getLocation().endSocialEncounter();
    }
}
