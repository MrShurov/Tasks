import org.apache.commons.cli.*;

import java.util.HashMap;
import java.util.Map;

class BattleGround {

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

    public static void main(String[] args) {
        CommandLineParser parser = new PosixParser();
        HelpFormatter formatter = new HelpFormatter();
        CommandLine cmd;
        Options options = new Options();
        String commandName = "";
        Character fighter1;
        Character fighter2;

        Option command = new Option("command",true, "Enter command");
        command.setRequired(true);
        options.addOption(command);

        Option fighter1Option = new Option("fighter1", "firstFighter", true, "Enter name of first fighter");
        options.addOption(fighter1Option);

        Option fighter2Option = new Option("fighter2", "secondFighter", true, "Enter name of second fighter");
        options.addOption(fighter2Option);

        try {
            cmd = parser.parse(options, args);
            commandName = cmd.getOptionValue("command");
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            formatter.printHelp("Parameters", options);
            System.exit(1);
        }

        if(commandName.equals("Fight")){
            options.getOption("firstFighter").setRequired(true);
            options.getOption("secondFighter").setRequired(true);
            try {
                cmd = parser.parse(options, args);
                fighter1 = getFighter(cmd.getOptionValue("firstFighter"));
                fighter2 = getFighter(cmd.getOptionValue("secondFighter"));
                battle(fighter1, fighter2);
            } catch (ParseException e) {
                System.out.println(e.getMessage());
                formatter.printHelp("Parameters", options);
                System.exit(1);
            }
        } else if(commandName.equals("ShowHistory")){
            System.out.println("History in development");
        }
    }

    private static Character getFighter(String name) {
        Map<String, Character> map = new HashMap<>();
        map.put("Warrior", new Warrior());
        map.put("Archer", new Archer());
        map.put("Mage", new Mage());
        map.put("Robber", new Robber());
        map.put("Zombie", new Zombie());
        return map.getOrDefault(name, new Human(name));
    }
}



