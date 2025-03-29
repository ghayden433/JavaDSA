/**
 * This class is completed for you.
 *
 * Each record holds an integer key, an integer value, and a record type.
 *
 * The record type is stored as an enumerated value.  Enumerated values allow
 * us to create a data type that holds a finite number of options. This allows it
 * to run efficiently and makes it so less error checking needs to be done.
 *
 * You shouldn't need to deal with the enumerated type. Just call the is<Type>()
 * methods to check if the type matches.
 *
 * The only other class that should directly interact with the record class is
 * HashTable220.java
 *
 * This class is complete and should not need updated.
 * @author Katie Timmerman
 */
// There are three types of records in a closed hash:
// Normal records, emptyFromStart records, and emptyAfterRemovals.
// Normal records hold valid key/values
// emptyFromStart records are empty-since-start
// emptyAfterRemoval records are empty-after-removal
enum RecordType {
    normal, emptyFromStart, emptyAfterRemoval
};

public class Record {

    private Integer key;
    private Integer value;
    private RecordType type;

    /**
     * Create an empty record.
     */
    public Record() {
        key = 0;
        type = RecordType.emptyFromStart;
    }

    /**
     * Create a normal record.
     *
     * @param key key
     * @param c value
     */
    public Record(Integer key, Integer c) {
        this.key = key;
        this.value = c;
        type = RecordType.normal;
    }

    /**
     * Convert a record to a emptyAfterRemoval due to removal
     */
    public void deleteRecord() {
        key = 0;
        value = 0;
        type = RecordType.emptyAfterRemoval;
    }

    /**
     * Get the integer key of a record
     *
     * @return key of record
     */
    public Integer getKey() {
        return key;
    }

    /**
     * Get the value of a record
     *
     * @return value of record
     */
    public Integer getValue() {
        return value;
    }

    /**
     * Check if a record is empty-since-start
     *
     * @return true if empty-since-start. False otherwise
     */
    public boolean isEmptyFromStart() {
        return (type == RecordType.emptyFromStart);
    }

    /**
     * Check if a record is a normal record
     *
     * @return true if normal. False otherwise
     */
    public boolean isNormal() {
        return (type == RecordType.normal);
    }

    /**
     * Check if a record is a emptyAfterRemoval (empty-after-removal)
     *
     * @return true if normal. False otherwise
     */
    public boolean isEmptyAfterRemoval() {
        return (type == RecordType.emptyAfterRemoval);
    }

    /**
     * Override the toString operator for printing records
     *
     * @return string representing record
     */
    @Override
    public String toString() {
        if (isEmptyAfterRemoval()) {
            return "<<EmptyAfterRemoval>>";
        } else if (isEmptyFromStart()) {
            return "<<EmptyFromStart>>";
        } else {
            return "Key: " + key + ", Value: " + value;
        }
    }

}
