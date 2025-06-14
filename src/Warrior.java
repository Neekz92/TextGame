public class Warrior extends Player {

    Skill skill;
    Skill selectedSkill;

    int amountOfSkills = 0;

    Skill[] skillList = new Skill[amountOfSkills];
    Skill[] allSkills = new Skill[2];

    String shield = null;

    public Warrior(GameEngine gameEngine, String name) {
        super(gameEngine, name);
        setHp(15);
        currentHp = getHp();
        attack = 5;
        defense = 5;
        luck = 0;

        weapon = new Sword();

        Skill shieldBashCombo = new ShieldBashCombo();
        Skill perfectParry = new PerfectParry();

        allSkills[0] = shieldBashCombo;
        allSkills[1] = perfectParry;

        addSkill(allSkills[random.nextInt(0,2)]);
    }

    public void combatOptions() {
        System.out.println("[ 1 ] Basic Attack");
        System.out.println("[ 2 ] Use a skill");
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
                        System.out.println("Select a skill");
                        showSkills();
                        selectedSkill = skillSelect();

                        if (selectedSkill == null) {
                            combatOptions();
                            continue;
                        }

                        if (selectedSkill.name == "Shield-Bash Combo") {
                            System.out.println("Shield Bash Combo");
                            showTargetOptions();
                            shieldBash();
                            stamina--;
                            selectMove = false;
                            break;
                        }
                        else if (selectedSkill.name == "Perfect-Parry") {
                            System.out.println(this + " takes a defensive stance.");
                            perfectParry();
                            stamina--;
                            selectMove = false;
                            break;
                        }
                        // Add more skills here





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

    public void showSkills() {

        for (int i = 0; i < amountOfSkills; i++) {
            System.out.println("[ " + (i + 1) + " ] " + skillList[i].name);
        }
        System.out.println("[ 0 ] Exit");
    }

    public Skill skillSelect() {

        int input = scanner.nextInt() - 1;  //  If the input is 1, that needs to correspond to the first position in the encounter.playerArray which is [0]. It's n - 1
        scanner.nextLine();

        if (input == -1) {
            return null;
        }

        return skillList[input];
    }

    public void addSkill(Skill skill) {

        amountOfSkills ++;
        Skill[] skillListClone = new Skill[amountOfSkills];
        for (int i = 0; i < skillList.length; i++) {
            skillListClone[i] = skillList[i];
        }
        skillListClone[amountOfSkills - 1] = skill;
        skillList = skillListClone;
    }

    @Override
    public String toString() {
        return super.toString() + " the Warrior";
    }


    @Override
    public void basicAttackDescription() {
        System.out.println(this + " swings their sword at " + targetSelect());
    }


    public void shieldBash() {

        updateStats();

        Player[] shieldBashTargets = new Player[2];
        Player shieldBashTarget1 = null;
        Player shieldBashTarget2 = null;

        System.out.println("Select first target");
        shieldBashTarget1 = targetSelect();


        if (encounter.countAmountOfEnemies() == 1) { //  Only need 1 target if there is only 1 enemy present
            System.out.println(name + " tries to bash " + shieldBashTarget1.getName());

            int roll = rollAttack();
            if (roll + (finalAttack / 5) > 10 + (shieldBashTarget1.finalDefense / 5)) {
                shieldBashTarget1.stunTimer = 2;
                shieldBashTarget1.isStunned = true;
                System.out.println(shieldBashTarget1 + " is dazed from the shield bash!");
                return;
            }
        }

        else {  //  Encounter has more than 1 enemy
            System.out.println("Select second target");
            boolean mustChooseADifferentTarget = true;
            while (mustChooseADifferentTarget) {
                shieldBashTarget2 = targetSelect();

                int roll = rollAttack();

                if (shieldBashTarget1.equals(shieldBashTarget2)) {
                    System.out.println("Must choose a different target.");

                }
                else {
                    System.out.println(name + " tries to bash " + shieldBashTarget1.getName() + " and " + shieldBashTarget2.getName());
                    targetedEnemy = shieldBashTarget1;
                    if (roll + (finalAttack / 5) > 10 + (shieldBashTarget1.finalDefense / 5)) {
                        shieldBashTarget1.stunTimer = 2;
                        shieldBashTarget1.isStunned = true;
                        System.out.println(shieldBashTarget1 + " is dazed from the shield bash!");
                        System.out.println("");
                    }

                    roll = rollAttack();

                    targetedEnemy = shieldBashTarget2;
                    if (roll + (finalAttack / 5)  > 10 + (shieldBashTarget2.finalDefense / 5)) {
                        shieldBashTarget2.stunTimer = 2;
                        shieldBashTarget2.isStunned = true;
                        System.out.println(shieldBashTarget2 + " is dazed from the shield bash!");
                    }
                    mustChooseADifferentTarget = false;
                }
            }
        }
    }

    public void perfectParry() {

        parryStance = true;
    }
}
