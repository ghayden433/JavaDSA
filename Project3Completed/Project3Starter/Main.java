import java.util.ArrayList;

/**
 * This is the driver class.
 * Note that it should NEVER interact with the Record class.
 *
 * HashTable220.java is your implementation Hash Table.
 * Record.java is a record object that is stored in the hash table.
 *
 * Links between classes
 * The hash table has an array of Records.
 * Each Record holds a (key, value) pair
 *
 * @author Katie Timmerman and Liz Johnson
 */
public class Main {

    public static void main(String[] args) {
        //testingHashTable();
        runAnalysis();
    }

    /**
     * Code to test your HashTable 220 implementation
     */
    private static void testingHashTable() {
        HashTable220 myTable0 = new HashTable220(10);
        System.out.println("Testing adding elements");
        myTable0.insert(9,90);
        myTable0.insert(18,180);
        myTable0.insert(28,280);
        myTable0.insert(20,200);
        myTable0.insert(30,300);
        System.out.println("Should be: 28, 20, 30, five EmptyFromStart, 18, 9");
        System.out.println(myTable0);
        System.out.println("Find 28 (should be 280): "+myTable0.find(28));
        System.out.println("Remove 20 (should be 200): "+myTable0.remove(20));
        System.out.println("Should be: 28, EmptyAfterRemoval, 30, five EmptyFromStart, 18, 9");
        System.out.println(myTable0);
        System.out.println("Find 30 (should be 300): "+myTable0.find(30));
        myTable0.insert(40,400);
        System.out.println("Should be: 28, 40, 30, five EmptyFromStart, 18, 9");
        System.out.println(myTable0);

        System.out.println("Load factor (should be 0.5): "+myTable0.alpha());
        myTable0.insert(53,530);
        myTable0.insert(63,630);
        myTable0.insert(13,130);
        myTable0.insert(23,230);
        System.out.println("Should be: 28, 40, 30, 53, 63, 13, 23, EmptyFromStart, 18, 9");
        System.out.println(myTable0);
        myTable0.remove(63);

        if (myTable0.insert(23,230))

            System.out.println("PROBLEM - You inserted 23 twice");

        System.out.println("Should be: 28, 40, 30, 53, emptyAfterRemoval, 13, 23, EmptyFromStart, 18, 9");
        System.out.println(myTable0);

        HashTable220 myTable1 = new HashTable220(11);
        System.out.println("Testing adding and removing elements");
        myTable1.insert(17,170);
        myTable1.insert(3,30);
        myTable1.insert(9,90);
        myTable1.insert(39,390);
        myTable1.insert(5,50);
        myTable1.insert(6,60);
        myTable1.insert(28,280);
        myTable1.insert(22,220);
        System.out.println("Remove 39 (should be 390): "+myTable1.remove(39));
        System.out.println("Find 6 (should be 60): "+myTable1.find(6));
        if (myTable1.insert(6,60))
            System.out.println("PROBLEM - You inserted 6 twice");
        myTable1.insert(33,330);
        myTable1.insert(56,560);
        myTable1.insert(16,160);
        myTable1.insert(77,770);
        System.out.println("Should be: 22, 33, 56, 3, 77, 5, 17, 16, 6, 9, 28");
        System.out.println(myTable1);
        System.out.println("Remove 33 (should be 330): "+myTable1.remove(33));
        if (myTable1.insert(77,770))
            System.out.println("PROBLEM - You inserted 7 twice");


    }

    /**
     * Function to do analysis
     */
    private static void runAnalysis() {
        System.out.println("Your analysis goes here.");
        HashTable220 analysisTable = new HashTable220(1009);
        //where to stop and do the average
        int[] stops = new int[] {100, 200, 300, 400, 500, 600, 700, 800, 900, 999, 1008};
        //store the collected data from each stop
        int[][] rawResults = new int[11][20];
        int[] totalCollisions = new int [11];
        int i = 0;
        Integer rando;
        
        for (int j = 0; j < stops.length; j++){
            //put the next x items in according to the list stops
            while (analysisTable.getSize() < stops[j]){
                //random number between 1000 and 999999
                rando = (int)(1000 + (Math.random() * 998999));
                analysisTable.insert(rando, rando);
            }
            
            //add and remove 20 random items and count their collisions
            int k = 0;
            while (k < 20){
                rando = (int)(1000 + (Math.random() * 998999));
                //prevent adding two of the same key
                if (analysisTable.find(rando) == null){
                    //add to hash table
                    analysisTable.insert(rando, rando);
                    //count the collisions and store the counts for later analysis, also store the total collisions for easier division later
                    rawResults[j][k] = analysisTable.countCollision(rando);
                    totalCollisions[j] += analysisTable.countCollision(rando);
                    //remove the item
                    analysisTable.remove(rando);
                    k++;
                }
            }
        }
        
        for (int h = 0; h < 11; h++){
            String result = "";
            for (int t = 0; t < 20; t++){
                result = result + rawResults[h][t] + ", ";
            }
            
            System.out.println("record number: " + (stops[h]));
            System.out.println(result);
            double c = totalCollisions[h];
            double a = 20;
            System.out.println("average collisions:" + (c/a));
            System.out.println("//////////");
        }

    }

}
