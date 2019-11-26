/*
 * BarrierProcess: receive registration and check with database.
 */
public class BarrierProcess {

    private ParkingDB db;

    public BarrierProcess (ParkingDB database) {
        db = database;
    }

    /*
     * ScanPlate: check database for registration
     */
    public boolean scanPlate(int regNum) {
        System.out.println("\nYour registration is " + regNum);
        System.out.println("\nChecking database...");
        boolean check = db.checkDB(regNum);
        if (check) {
            System.out.println("Match found.");
            return true;
        }
        System.out.println("No match found.");
        return false;
    }
}
