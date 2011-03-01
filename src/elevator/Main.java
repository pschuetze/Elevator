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
            throw new Exception("Usage: java Elevator <Levels> <Elevators>");
        }

        try {
            Globals.levels = Integer.parseInt(args[0]);
        } catch (NumberFormatException numberFormatException) {
            System.out.println("first param: levels must be a valid integer");
            System.exit(1);
        }

        try {
            Globals.elevators = Integer.parseInt(args[1]);
        } catch (NumberFormatException numberFormatException) {
            System.out.println("second param: elevators must be a valid integer");
            System.exit(1);
        }

        System.out.println("Elevators: " + Globals.elevators);
        System.out.println("Levels: " + Globals.levels);

        Building building = new Building(Globals.levels, Globals.elevators);
        

        System.out.print("Ende");

    }
}
