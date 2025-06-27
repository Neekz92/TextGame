public class ScorchedLocation extends SocialEncounter {

    public ScorchedLocation() {

    }

    public String toString() {
        return "Scorched Tile";
    }

    public void setup() {

        System.out.println("");
        System.out.println("You aren't sure what happened here. The land is scorched. Completely desolate. This is a barren hellscape. You cannot even find rest in this place.");
        System.out.println("Analyzing the devastation here, you can tell. This place was destroyed " + location.turnsSinceDragon + " turns ago.");
        System.out.println("");
    }

    public void options() {
        playerArray[0].getLocation().endSocialEncounter();
    }
}
