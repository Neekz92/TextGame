public class AncientFrostWraithMinibossTrigger extends SocialEncounter {

    public AncientFrostWraithMinibossTrigger() {

    }

    @Override
    public void setup() {

        distributedRewards = false;


        System.out.println("The temperature plummets as you climb to the top of the Shiverpeak Mountain Summit. You feel an icy gust, and with it comes a voice:");
        System.out.println("\"...Shatter the ice that entombs my spirit, for only my frost can stand against the hellfire that the realm shall suffer...");
        System.out.println("You cannot interact with this monolith. (I also haven't added the item needed to interact with it yet.)");
    }

    @Override
    public void options() {

        playerArray[0].getLocation().endSocialEncounter();
    }
}
