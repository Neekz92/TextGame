public class StaminaPotionMerchant extends SocialEncounter {

    int price = random.nextInt(5,15);

    public StaminaPotionMerchant() {

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
                }

            } catch (Exception e) {
                System.out.println("Invalid option.");
            }
        }
    }
}
