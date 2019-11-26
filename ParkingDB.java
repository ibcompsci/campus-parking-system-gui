/*
 * ParkingDB: declare array and initialise it with 5 elements.
 * Populate array with with random numbers.
 */
 
public class ParkingDB {

    int[] dbArray; // declare an array

    public ParkingDB() { // constructor
        dbArray = new int[5]; // initialise array
        dbArray[0] = 12345; // populate array
        dbArray[1] = 36527;
        dbArray[2] = 87674;
        dbArray[3] = 34563;
        dbArray[4] = 65379;
    }
    
    /*
     * CheckDB: check numbers against dbArray. If found, return
     * true. If not, return false.
     */
    public boolean checkDB(int regNum) {
        for (int i = 0; i < dbArray.length; i++) {
            if (regNum == (dbArray[i])) {
                return true;
            }
        }
        return false;
    }
}
