import org.apache.commons.cli.*;

import java.util.HashMap;
import java.util.Map;

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
            System.out.println(counter + " round:");
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

        Option input = new Option("fighter1", "firstFighter", true, "Enter name of first fighter");
        input.setRequired(true);
        options.addOption(input);

        Option output = new Option("fighter2", "secondFighter", true, "Enter name of second fighter");
        output.setRequired(true);
        options.addOption(output);

        CommandLineParser parser = new PosixParser();
        HelpFormatter formatter = new HelpFormatter();
        CommandLine cmd;

        try {
            cmd = parser.parse(options, args);
            fighterName1 = cmd.getOptionValue("firstFighter");
            fighterName2 = cmd.getOptionValue("secondFighter");
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            formatter.printHelp("Parameters", options);
            System.exit(1);
        }
    }

    private static Character getFighter(String name) {
        Map<String, Character> map = new HashMap<>();
        map.put("Warrior",new Warrior());
        map.put("Archer",new Archer());
        map.put("Mage",new Mage());
        map.put("Robber",new Robber());
        map.put("Zombie",new Zombie());
        return map.getOrDefault(name,new Human(name));
    }
}



