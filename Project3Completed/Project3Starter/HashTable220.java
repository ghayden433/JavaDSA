
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
        int i = 0;
        //make sure that the item is not already in the hash table
        if (indexOf(key) >= 0) return false;
        //while there is something in the spot, probe the next spot
        while (hashAry[probe(key, i)].isNormal()){
            //if we've looped the whole list its not in there
            if (i > CAPACITY)return false;
            i++;
        }
        //add the key and value to the hash table and increment size
        hashAry[probe(key, i)] = new Record(key, value);
        size++;
        return true;
    }

    /**
     * Attempts to delete a key and returns value if the key/value is removed.
     *
     * @param key key to searched for
     * @return value if key found, null otherwise
     */
    public Integer remove(Integer key) {
        int ind = indexOf(key);
        if (ind >= 0){
            //hold value
            int val = hashAry[ind].getValue();
            //delete record then return the value, also decrement size
            hashAry[ind].deleteRecord();
            size--;
            return val;
        }
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
        int ind = indexOf(key);
        //if the key is found return its value
        if (ind > -1) return hashAry[ind].getValue();
        //otherwise null
        return null;
    }

    /**
     * Return load factor
     *
     * @returns size/capacity
     */
    public double alpha() {
        double s = size;
        double c = CAPACITY;
        return s/c;
    }

    /**
     * Returns the home index for the given key.
     *
     * @param key key to be hashed
     * @return hash value for that key
     */
    private int hash(Integer key) {
        //int^2 to string
        Long lKey = (long)key;
        String sKey = Long.toString(lKey * lKey);
        //find half
        int half = sKey.length() / 2;
        //find middle 3 substring and turn to int and then return
        int result = Integer.parseInt(sKey.substring(half - 1, half + 2));
        return result;
    }
    
    /**
     * second hash function for duble hash probe
     * the math makes sure that it hits every spot 
     *
     * @param key key to be hashed
     * @return hash value for that key
     */
    private int hash2(Integer key) {
        return 997 - (key % 997);
    }

    /**
     * Returns the next index that should be investigated. For example, if my
     * home index is 4 and I am calling a +1 linear probe for the 3rd time, this
     * function should return 7.
     *
     * @param key provides the key
     * @param collision number of collisions so far
     * @return next index to be checked
     */
    private int probe(int key, int collisions) {
        return (hash(key) + (collisions * hash2(key))) % CAPACITY;
        //int probe = (hash(key) + (collisions * hash2(key))) % CAPACITY;
        //return probe;
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
        int i = 0;
        //probe each point
        while (!(hashAry[probe(key, i)].isEmptyFromStart()) && i < CAPACITY){
            if ((int)(hashAry[probe(key, i)].getKey()) == (int)key){
                return probe(key, i);
            }
            i++;
        }
        return -1;
    }
    
    /**
    * get size of the list   
    */
    public int getSize(){
        return size;
    }
    
    /**
    * counts the collisions by searching
    * basically the same as indexOf but returns collisions instead of index
    */
    public int countCollision(Integer key){
        int i = 0;
        //probe each point
        while (!(hashAry[probe(key, i)].isEmptyFromStart()) && i < CAPACITY){
            if (hashAry[probe(key, i)].getKey() == key){
                return i;
            }
            i++;
        }
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
