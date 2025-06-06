public class Mage extends Player {

    Spell spell;
    Spell selectedSpell;

    String staff;
    String grimoire;

    int amountOfSpells;
    Spell[] spellBook = new Spell[amountOfSpells];

    Spell[] allSpells = new Spell[2];

    public Mage(GameEngine gameEngine, String name) {
        super(gameEngine, name);
        setHp(8);
        currentHp = getHp();
        attack = 50000;
        defense = 5;
        luck = 0;
        Spell chainLightning = new ChainLightning();
        addSpell(chainLightning);
    }



    public void addSpell(Spell spell) {

        amountOfSpells ++;
        Spell[] spellBookClone = new Spell[amountOfSpells];
        for (int i = 0; i < spellBook.length; i++) {
            spellBookClone[i] = spellBook[i];
        }
        spellBookClone[amountOfSpells - 1] = spell;
        spellBook = spellBookClone;
    }


    public void showSpells() {

        for (int i = 0; i < amountOfSpells; i++) {
            System.out.println("[ 1 ] " + spellBook[i].name);
        }
    }



    public Spell spellSelect() {

        int input = scanner.nextInt() - 1;  //  If the input is 1, that needs to correspond to the first position in the encounter.playerArray which is [0]. It's n - 1
        scanner.nextLine();

        return spellBook[input];
    }



    public void chainLightning() {

        int roll = rollAttack();

        if (roll == 20) {
            System.out.println("NATURAL 20!");
            int damage = (random.nextInt(1, attack + 1) + (attack / 5) - (targetedEnemy.defense / 5) + 3);  // Damage works by rolling a random number from 1 to Attack stat, and adding it to Attack stat / 4. Then subtract (enemy defense / 4)
            if (damage <= 0) {  //  Damage can't be below 0. Can't heal them with an attack lol
                damage = 1;
            }
            damage *= 2;

            targetedEnemy.currentHp -= damage;
            System.out.println(targetedEnemy + " is struck by Chain Lightning and took " + damage + " damage!");
            targetedEnemy.deathCheck();
            return;
        }

        if (roll + (attack / 5) >= 10 + (targetedEnemy.defense / 5)) {
            int damage = random.nextInt(1, (attack / 5) + 1) + (attack / 5) - (targetedEnemy.defense / 5) + 3;
            if (damage <= 1) {
                damage = 1;
            }
            //targetedEnemy.setHp(targetedEnemy.getHp() - damage);
            targetedEnemy.currentHp -= damage;
            System.out.println(targetedEnemy + " is struck by Chain Lightning and took " + damage + " damage!");
            targetedEnemy.deathCheck();
        }
        else {
            System.out.println(targetedEnemy + " managed to dodge the bolt of Chain Lightning!");
        }
    }


    @Override
    public void combat() {

        System.out.println("[ 1 ] Basic Attack");
        System.out.println("[ 2 ] Cast a Spell");
        System.out.println("[ 3 ] Inventory");
        System.out.println("[ 4 ] Run Away");

        int input = scanner.nextInt();
        scanner.nextLine();

        boolean selectMove = true;
        while (selectMove) {
            switch (input) {
                case 1:
                    System.out.println("Select a Target");
                    showTargetOptions();
                    basicAttack();
                    selectMove = false;
                    break;

                case 2:
                    System.out.println("Select a spell.");
                    showSpells();
                    spellSelect();
                    System.out.println("Crackling lightning erupts from " + this + "!");
                    for (int i = encounter.playerArray.length - 1; i >= 0; i--) {
                        if (encounter.playerArray[i] instanceof Enemy) {
                            targetedEnemy = encounter.playerArray[i];
                            chainLightning();
                            System.out.println("");
                        }
                    }
                    selectMove = false;
                    break;
            }
        }
    }
    @Override
    public String toString() {
        return super.toString() + " the Mage";
    }



    public void basicAttackDescription() {
        System.out.println(this + " launches a bolt of magic at " + targetSelect());
    }
}
