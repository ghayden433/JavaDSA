
/**
 * This is where you will implement your hash table.
 * @author Katie Timmerman and Liz Johnson
 *
 */
public class HashTable220 {

    private final int CAPACITY; //Capacity of the table
    private Record[] hashAry; // the array of records
    private int size; //Number of values in the table

    /**
     * This constructor builds a hash table. It then fills the table with a
     * bunch of empty records.
     *
     * @param capacity number of slots in table
     */
    public HashTable220(int capacity) {
        this.CAPACITY = capacity;
        hashAry = new Record[CAPACITY];
        this.size = 0;
        for (int i = 0; i < CAPACITY; i++) {
            Record r = new Record();
            hashAry[i] = r;
        }
    }

    /**
     * Inserts the key/value into the hashtable if there is room and the key
     * isn't already in the table
     *
     * @param key key to be inserted
     * @param value value associated with key
     * @return true if key/value could be inserted, false otherwise
     */
    public boolean insert(Integer key, Integer value) {
        return false;
    }

    /**
     * Attempts to delete a key and returns value if the key/value is removed.
     *
     * @param key key to searched for
     * @return value if key found, null otherwise
     */
    public Integer remove(Integer key) {

        //This method should only be about 7-8 lines
        return null;
    }

    /**
     * Finds an element with a certain key and returns the associated value
     *
     * @param key key to be checked
     * @return value associated with key or, if key not in table, null
     */
    public Integer find(Integer key) {

        //This method should only be about 4-5 lines
        return null;
    }

    /**
     * Return load factor
     *
     * @returns size/capacity
     */
    public double alpha() {
        return 0.0;
    }

    /**
     * Returns the home index for the given key.
     *
     * @param key key to be hashed
     * @return hash value for that key
     */
    private int hash(Integer key) {
        return 0;
    }

    /**
     * Returns the next index that should be investigated. For example, if my
     * home index is 4 and I am calling a +1 linear probe for the 3rd time, this
     * function should return 7.
     *
     * @param homeIndex original hash for the key
     * @param collision number of collisions so far
     * @return next index to be checked
     */
    private int probe(int homeIndex, int collisions) {
        return 0;
    }

    /**
     * This is a private method only to be used internally. It returns the index
     * where the record with the key is stored in the table. It returns -1 if
     * the key is not found in the table.
     *
     * @param key key to be checked
     * @return index where key exists in table or -1 if not in table
     */
    private int indexOf(Integer key) {

        return -1;
    }

    /**
     * Already Complete. Returns a string representation of the hash table
     *
     * @return string representing table
     */
    public String toString() {
        String table = "";
        for (int i = 0; i < this.CAPACITY; i++) {
            table += i + ". " + hashAry[i].toString() + "\n";
        }
        return table;
    }

}
