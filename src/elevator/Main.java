/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package elevator;

/**
 *
 * @author martin
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {

        if(args.length != 2){
            System.err.println("Usage: java Elevator <Levels> <Elevators>");
            System.exit(1);
        }

        try {
            Globals.levels = Integer.parseInt(args[0]);
        } catch (NumberFormatException numberFormatException) {
            System.err.println("first param: levels must be a valid integer");
            System.exit(1);
        }

        try {
            Globals.elevators = Integer.parseInt(args[1]);
        } catch (NumberFormatException numberFormatException) {
            System.err.println("second param: elevators must be a valid integer");
            System.exit(1);
        }

        System.out.println("Elevators: " + Globals.elevators);
        System.out.println("Levels: " + Globals.levels);

        Building building = Bootstrap.init(Globals.levels, Globals.elevators);

        System.out.println(building.getElevators());

        System.out.print("Ende");

    }
}
