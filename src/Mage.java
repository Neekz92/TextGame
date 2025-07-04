public class Mage extends Player {

    Spell spell;
    Spell selectedSpell;

    int amountOfSpells;
    Spell[] spellBook = new Spell[amountOfSpells];
    Spell[] allSpells = new Spell[3];


    public Mage(GameEngine gameEngine, String name) {

        super(gameEngine, name);
        setHp(20);
        currentHp = getHp();
        attack = 15;
        defense = 5;
        luck = 5;

        Spell chainLightning = new ChainLightning();
        Spell heal = new Heal();
        Spell haste = new Haste();
        allSpells[0] = chainLightning;
        allSpells[1] = heal;
        allSpells[2] = haste;

        addSpell(allSpells[random.nextInt(0,3)]);

        weapon = new Staff();
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
            System.out.println("[ " + (i + 1) + " ] " + spellBook[i].name);
        }
        System.out.println("[ 0 ] Exit");
    }

    public Spell spellSelect() {

        boolean selectSpell = true;
        while (selectSpell) {
            try {
                int input = scanner.nextInt() - 1;  //  If the input is 1, that needs to correspond to the first position in the encounter.playerArray which is [0]. It's n - 1
                scanner.nextLine();

                if (input == -1) {
                    return null;
                }
                selectSpell = false;
                return spellBook[input];
            } catch (Exception e) {
                System.out.println("Try again.");
            }
        }
        return null;
    }

    public void chainLightning() {

        updateStats();
        int roll = rollAttack();

        if (roll == 20) {
            System.out.println("NATURAL 20!");
            int damage = random.nextInt(1, (finalAttack / 10) + 1);  // Damage works by rolling a random number from 1 to Attack stat, and adding it to Attack stat / 4. Then subtract (enemy defense / 4)
            if (damage <= 0) {  //  Damage can't be below 0. Can't heal them with an attack lol
                damage = 1;
            }

            damage += attackSkillBuff;
            damage -= targetedEnemy.defenseSkillBuff;

            if (damage <= 1) {
                damage = 5;
            }
            damage *= 2;

            targetedEnemy.currentHp -= damage;
            System.out.println(targetedEnemy + " is struck by Chain Lightning and took " + damage + " damage!");
            System.out.println("");
            targetedEnemy.deathCheck();
            return;
        }

        if (roll + (finalAttack / 5) >= 10 + (targetedEnemy.finalDefense / 5)) {
            System.out.println("SUCCESS! Rolled a " + roll + " + " + (finalAttack / 5));
            int damage = random.nextInt(1, (finalAttack / 10) + 1);
            if (damage <= 1) {
                damage = 1;
            }

            damage += attackSkillBuff;
            damage -= targetedEnemy.defenseSkillBuff;

            if (damage <= 1) {
                damage = 5;
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

    public void heal() {

        System.out.println("Select a target");
        showTargetOptions();
        targetSelect();
        int restoreAmount = random.nextInt(1, 5 + (finalLuck));
        System.out.println(targetedEnemy + " restores " + restoreAmount + " HP!");
        System.out.println("");
        targetedEnemy.updateStats();
        targetedEnemy.currentHp += restoreAmount;
        targetedEnemy.adjustHp();
    }

    public void haste() {

        System.out.println("Select a target");
        showTargetOptions();
        targetSelect();
        targetedEnemy.hasteTimer = (finalLuck / 5);
        System.out.println(targetedEnemy + " begins moving with arcane speed!");
        System.out.println("");
    }

    private void combatOptions() {
        System.out.println("[ 1 ] Basic Attack");
        System.out.println("[ 2 ] Cast a Spell");
        System.out.println("[ 3 ] Run Away");
    }

    @Override
    public void combat() {

        combatOptions();


        boolean selectMove = true;
        while (selectMove) {
            int input = scanner.nextInt();
            scanner.nextLine();

            switch (input) {
                case 1:
                    System.out.println("Select a Target");
                    showTargetOptions();
                    basicAttack();
                    selectMove = false;
                    break;

                case 2:
                    if (stamina >= 1) {
                        System.out.println("Select a spell.");
                        showSpells();
                        selectedSpell = spellSelect();
                        if (selectedSpell == null) {
                            combatOptions();
                            continue;
                        }

                        if (selectedSpell.name == "Chain-Lightning") {
                            System.out.println("Crackling lightning erupts from " + this + "!");
                            stamina--;
                            for (int i = encounter.playerArray.length - 1; i >= 0; i--) {
                                if (encounter.playerArray[i] instanceof Enemy) {
                                    targetedEnemy = encounter.playerArray[i];
                                    chainLightning();
                                    System.out.println("");
                                }
                            }
                        }

                        else if (selectedSpell.name == "Heal") {
                            System.out.println("A warm pulse of wound-mending magic surges from " + this);
                            heal();
                            stamina--;
                        }

                        else if (selectedSpell.name == "Haste") {
                            haste();
                            stamina--;
                        }


                        selectMove = false;
                        break;
                    }
                    else {
                        System.out.println("Not enough stamina.");
                        break;
                    }
                case 3:
                    run();
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
