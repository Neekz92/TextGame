public class Encounter {

    Scenario scenario = new Scenario();
    int amountOfParticipants = 0;
    Player[] playerArray = new Player[amountOfParticipants];  //  Player objects are referenced in the encounter object. The encounter object is created inside the location object.

    public void add(Player player) {
        amountOfParticipants ++;
        Player[] playerArrayClone = new Player[amountOfParticipants];

        for (int i = 0; i < playerArray.length; i++) {
            playerArrayClone[i] = playerArray[i];
        }
        playerArrayClone[amountOfParticipants - 1] = player;
        playerArray = playerArrayClone;
        scenario.player = player;
    }

    public Encounter() {

    }
}
