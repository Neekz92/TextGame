public class ScorchedLocation extends SocialEncounter {

    public ScorchedLocation() {

    }

    public void setup() {

        System.out.println("You aren't sure what happened here. The land is scorched. Completely desolate. This is a barren hellscape. You cannot even find rest in this place.");
    }

    public void options() {
        playerArray[0].getLocation().endSocialEncounter();
    }
}
