public class StaminaPotionMerchant extends SocialEncounter {

    int price = random.nextInt(5,15);

    public StaminaPotionMerchant() {

        description = "Stamina Potion";
    }

    public void setup() {

        System.out.println("A voice calls out to you.");
        System.out.println("\"Excuse me, traveler. You appear weary from your expedition. Luckily, you've met me, a wandering merchant that sells a brew which can restore your strength. Only " + price + " gold pieces. What say you?\"");
        System.out.println("The man is wearing a large traveling bag with different vials and flasks poking out. He leads a mule carrying similar looking wares.");
    }

    @Override
    public void options() {

        System.out.println(playerArray[0] + " 's gold: " + playerArray[0].getGold());
        System.out.println("[ 1 ] Buy a Stamina Potion for " + price + " gold");
        System.out.println("[ 2 ] Ignore him and rest.");
//        System.out.println("[ 3 ] Murder the Potion Merchant");

        boolean selectChoice = true;
        while (selectChoice) {
            try {
                int input = scanner.nextInt();
                scanner.nextLine();

                switch (input) {
                    case 1:
                        if (playerArray[0].getGold() >= price) {
                            System.out.println("You purchased a Stamina Potion for " + price + " gold!");
                            playerArray[0].setGold(playerArray[0].getGold() - price);
                            playerArray[0].inventory.addItem(new StaminaPotion());
                            selectChoice = false;
                            playerArray[0].getLocation().endSocialEncounter();
                            return;
                        }
                        else {
                            System.out.println("The merchant scoffs.");
                            System.out.println("If you have no coin then begone from me.");
                            selectChoice = false;
                            playerArray[0].getLocation().endSocialEncounter();
                            return;
                        }
                    case 2:
                        System.out.println("\"Find a different traveler to con.\"");
                        System.out.println("You send the merchant on his way, and you find a comfortable place to catch your breath.");
                        playerArray[0].rest();
                        selectChoice = false;
                        playerArray[0].getLocation().endSocialEncounter();
                        return;

                        // Don't actually keep case 3 LOL
                    case 3:
                        System.out.println("\"I've had enough of your worthless potions. Prepare to meet oblivion.");
                        System.out.println(playerArray[0] + " grabs the potion merchant by the skull, crushing their eyes with their thumbs.");
                        System.out.println("");

                        System.out.println("He cries out, \"NO! PLEASE DON'T DO THIS!! I JUST LOST MY WIFE, IF I'M KILLED, MY SON WILL BE ALONE!!\"");
                        System.out.println("");

                        System.out.println("\"Begone from this world, con-man.\"");
                        System.out.println("The potion merchant's head explodes, blood and brain matter litter the ground that you walk.");
                        System.out.println("");

                        System.out.println("\"Father, I've returned with some herbs for our new brew-! ...Father??\"");
                        System.out.println("A small child emerges from the bushes. He appears to be in shock as he sees his father's corpse lying motionless on the ground.");
                        System.out.println("Tears roll down his cheeks and he says, \"Father, I cannot find you... He must have returned home without me...\"");
                        System.out.println("The crying child races toward [ City One ] in a state of delirium and shock.");
                        System.out.println("");

                        selectChoice = false;

                        // Don't actually keep case 3 LOL

                        for (int i = 0; i < playerArray[0].gameEngine.map.locationArray.length; i++) {
                            if (playerArray[0].gameEngine.map.locationArray[i].contains(this)) {
                                playerArray[0].gameEngine.map.locationArray[i].remove(this);
                            }
                        }

                        playerArray[0].getLocation().endSocialEncounter();
                }

            } catch (Exception e) {
                System.out.println("Invalid option.");
                scanner.nextLine();
            }
        }
    }
}
