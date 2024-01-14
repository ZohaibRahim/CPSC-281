/**
 An interesting strategy for hashing with open addressing is known as cuckoo
 hashing. Two independent hash functions are computed for each key, and an
 element is always stored in one of the two cells indicated by those hash functions.
 When a new element is inserted, if either of those two cells is available, it is
 placed there. Otherwise, it is placed into one of its choice of locations, evicting
 another entry. The evicted entry is then placed in its alternate choice of cells,
 potentially evicting yet another entry. This continues until an open cell is found,
 or an infinite loop is detected (in which case, two new hash functions are chosen
 and all entries are deleted and reinserted). It can be shown that as long as the
 load factor of the table remains below 0.5, then an insertion succeeds in expected
 constant time. Notice that a search can be performed in worst-case constant time,
 because it can only be stored in one of two possible locations. Give a complete
 map implementation based on this strategy.
 */

import java.util.Arrays;
import java.util.HashMap;
public class CuckooHashMap<K, V> {
    private int size; // The size of the hash table
    private K[] keys; // Array to store keys
    private V[] values; // Array to store values

    @SuppressWarnings("unchecked")
    public CuckooHashMap(int size) {
        this.size = size;
        this.keys = (K[]) new Object[size]; // Initialize keys array
        this.values = (V[]) new Object[size]; // Initialize values array
    }

    // First hash function
    private int hash1(K key) {
        return key.hashCode() % size; // Calculate hash using modulo operation
    }

    // Second hash function
    private int hash2(K key) {
        return (key.hashCode() / size) % size; // Calculate hash using modulo operation
    }

    // Insert a key-value pair into the hash table
    public void put(K key, V value) {
        if (key == null) throw new IllegalArgumentException("Key cannot be null"); // Validate input

        int hash1 = hash1(key); // Calculate first hash
        int hash2 = hash2(key); // Calculate second hash

        // If the first location is available, store the key-value pair there
        if (keys[hash1] == null) {
            keys[hash1] = key;
            values[hash1] = value;
        } else if (keys[hash2] == null) { // If the second location is available, store the key-value pair there
            keys[hash2] = key;
            values[hash2] = value;
        } else { // If both locations are occupied, perform cuckoo hashing
            K evictedKey = key;
            V evictedValue = value;

            for (int i = 0; i < size; i++) {
                K tempKey = keys[hash1];
                V tempValue = values[hash1];
                keys[hash1] = evictedKey;
                values[hash1] = evictedValue;
                evictedKey = tempKey;
                evictedValue = tempValue;

                hash1 = hash2(evictedKey);

                if (keys[hash1] == null) {
                    keys[hash1] = evictedKey;
                    values[hash1] = evictedValue;
                    break;
                }
            }
        }
    }

    // Get the value associated with a key
    public V get(K key) {
        int hash1 = hash1(key); // Calculate first hash
        int hash2 = hash2(key); // Calculate second hash

        // Check if the key is present in the first location
        if (keys[hash1] != null && keys[hash1].equals(key)) {
            return values[hash1];
        } else if (keys[hash2] != null && keys[hash2].equals(key)) { // Check if the key is present in the second location
            return values[hash2];
        }

        return null; // Key not found
    }

    // Remove a key-value pair from the hash table
    public void remove(K key) {
        int hash1 = hash1(key); // Calculate first hash
        int hash2 = hash2(key); // Calculate second hash

        // Check if the key is present in the first location
        if (keys[hash1] != null && keys[hash1].equals(key)) {
            keys[hash1] = null;
            values[hash1] = null;
        } else if (keys[hash2] != null && keys[hash2].equals(key)) { // Check if the key is present in the second location
            keys[hash2] = null;
            values[hash2] = null;
        }
    }

    // Provide a string representation of the hash map
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            if (keys[i] != null) {
                sb.append(keys[i]).append(": ").append(values[i]).append("\n");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        CuckooHashMap<Integer, Integer> map = new CuckooHashMap<>(10);

        int[] keys = {20, 50, 53, 75, 100, 67, 105, 3, 36, 39};
        for (int key : keys) {
            map.put(key, key);
            System.out.println("After inserting " + key + ":\n" + map);
        }

        System.out.println("Value for key 50: " + map.get(50));

        map.remove(50);

        System.out.println("After removing key 50:\n" + map);
    }
}

/*
OUTPUT:

After inserting 20:
20: 20

After inserting 50:
20: 20
50: 50

After inserting 53:
20: 20
53: 53
50: 50

After inserting 75:
20: 20
53: 53
50: 50
75: 75

After inserting 100:
100: 100
20: 20
53: 53
50: 50
75: 75

After inserting 67:
100: 100
20: 20
53: 53
50: 50
67: 67
75: 75

After inserting 105:
100: 100
20: 20
53: 53
50: 50
67: 67
75: 75

After inserting 3:
100: 100
20: 20
3: 3
53: 53
67: 67
75: 75

After inserting 36:
3: 3
20: 20
36: 36
53: 53
67: 67
75: 75

After inserting 39:
3: 3
20: 20
36: 36
53: 53
67: 67
75: 75
39: 39

Value for key 50: null
After removing key 50:
3: 3
20: 20
36: 36
53: 53
67: 67
75: 75
39: 39
 */