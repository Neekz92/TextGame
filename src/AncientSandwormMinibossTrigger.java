public class AncientSandwormMinibossTrigger extends SocialEncounter {

    public AncientSandwormMinibossTrigger() {

    }

    @Override
    public void setup() {

        distributedRewards = false;


        System.out.println("While traveling atop the scorching sands of the desert, you come across a massive drum. Though, the drum only seems to respond acoustically to a certain material.");
        System.out.println("You cannot interact with this monolith. (I also haven't added the item needed to interact with it yet.)");
    }

    @Override
    public void options() {

        playerArray[0].getLocation().endSocialEncounter();
    }
}