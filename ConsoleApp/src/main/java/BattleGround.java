import org.apache.commons.cli.*;

public class BattleGround {

    private static String fighterName1;
    private static String fighterName2;

    public static void main(String[] args) {
        parseCommandLine(args);
        Character fighter1 = getFighter(fighterName1);
        Character fighter2 = getFighter(fighterName2);
        battle(fighter1,fighter2);
    }

    private static void battle(Character one, Character two) {
        boolean loop = true;
        int counter = 0;
        do {
            counter++;
            System.out.println(counter + " Раунд:");
            if (one.isAlive()) {
                one.attack(two);
            }
            if (two.isAlive()) {
                two.attack(one);
            }
            if (!one.isAlive() || !two.isAlive()) {
                loop = false;
            }
        } while (loop);
    }

    private static void parseCommandLine(String[] args) {
        Options options = new Options();

        Option input = new Option("fighter1", "firstFighter", true, "first fighter");
        input.setRequired(true);
        options.addOption(input);

        Option output = new Option("fighter2", "secondFighter", true, "second fighter");
        output.setRequired(true);
        options.addOption(output);

        CommandLineParser parser = new DefaultParser();
        HelpFormatter formatter = new HelpFormatter();
        CommandLine cmd;

        try {
            cmd = parser.parse(options, args);
            fighterName1 = cmd.getOptionValue("firstFighter");
            fighterName2 = cmd.getOptionValue("secondFighter");
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            formatter.printHelp("utility-name", options);
            System.exit(1);
        }
    }

    private static Character getFighter(String name) {
        switch (name) {
            case "Warrior":
                return new Warrior();
            case "Archer":
                return new Archer();
            case "Mage":
                return new Mage();
            case "Robber":
                return new Robber();
            case "Zombie":
                return new Zombie();
            default:
                return new Human(name);
        }
    }
}



