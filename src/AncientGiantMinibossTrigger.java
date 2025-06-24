public class AncientGiantMinibossTrigger extends SocialEncounter {

    public AncientGiantMinibossTrigger() {

    }

    @Override
    public void setup() {

        distributedRewards = false;


        System.out.println("Atop the crest of the Stormpeak Mountain Summit, you come across a massive statue of a humanoid with an enormous hammer. He was the King of the Giants.");
        System.out.println("You cannot interact with this monolith. (I also haven't added the item needed to interact with it yet.)");
    }

    @Override
    public void options() {

        playerArray[0].getLocation().endSocialEncounter();
    }
}