import java.util.Random;

public class DragonToken {

    int x;
    int y;
    Random random;
    Location location;
    boolean hasEncounter;

    public DragonToken() {

        random = new Random();

        x = 10;
        y = 10;
        hasEncounter = false;
    }

    public void movement() {

        int rng = random.nextInt(1,6);

        boolean dragonMustMove = true;
        while (dragonMustMove) {
            switch (rng) {
                case 1:
                    if (y < 10) {
                        y++;
                        dragonMustMove = false;
                        break;
                    }
                case 2:
                    if (x < 10) {
                        x++;
                        dragonMustMove = false;
                        break;
                    }
                case 3:
                    if (y > 0) {
                        y--;
                        dragonMustMove = false;
                        break;
                    }
                case 4:
                    if (x > 0) {
                        x--;
                        dragonMustMove = false;
                        break;
                    }
                case 5:
                    dragonMustMove = false;
                    break;
            }
        }
    }
}
