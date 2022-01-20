package ss.week4;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MapUtil {

    /**
     * Checks whether a java.util.Map<K,V> f passed as a parameter is an injection
     *
     * @param map
     * @param <K>
     * @param <V>
     * @return returns true if for all v in the value set of the map f,
     * there exists exactly one key k in the map’s key set, such that v == f.get(k).
     */
    public static <K, V> boolean isOneOnOne(Map<K, V> map) {
        map.keySet().size();
        Set<V> set = new HashSet<>(map.values());
        if (set.size() == map.keySet().size()) {
            return true;
        }
        return false;
    }

    /**
     *  checks wheterh parameter map f is surjective
     * @param map
     * @param range
     * @param <K>
     * @param <V>
     * @return
     */
    public static <K, V> boolean isSurjectiveOnRange(Map<K, V> map, Set<V> range) {
         // TODO: implement 4.13
        Object [] values = range.toArray();
        int count = 0;
        for (int i = 0; i < range.size(); i++){
            if (map.containsValue(values[i])){
                count++;
            }

        }
        if (range.size() == count){
            return true;
        }
         return false;
    }

    /**
     * Given Map <K,V>, object terutrn a map of type Map<V, Set<k>>
     *
     * @param map
     * @param <K>
     * @param <V>
     * @return
     */

    public static <K, V> Map<V, Set<K>> inverse(Map<K, V> map) {
         // TODO: implement 4.14
         Map<V, Set<K>> inverseMap = new HashMap<>(); // The requested map

        for (K x : map.keySet()) {
            V value = map.get(x); // get the value of the corresponding key
            if (inverseMap.containsKey(value)) { // if the value already is in inverseMap
                Set<K> newFullSet = inverseMap.get(value); //get the set with the key
                newFullSet.add(x); // add the key to the set
                inverseMap.put(value,newFullSet); // put both in the inverserMap
            } else{  // if it is not found in inverseMap
                HashSet<K> newSetEmpty = new HashSet<>(); //make a new set and add key
                newSetEmpty.add(x);
                inverseMap.put(value, newSetEmpty);
            }
        }
         return inverseMap;
    }

    /**
     *
     * @param map
     * @param <K>
     * @param <V>
     * @return
     */

    public static <K, V> Map<V, K> inverseBijection(Map<K, V> map) {
         // TODO: implement 4.14
        Map<V,K> inverseMap = new HashMap<>(); // Create the requested object

        HashSet<V> testSet = new HashSet<>(); // Import all values into new set<V> testSet
        testSet.addAll(map.values());

        if (isOneOnOne(map) && isSurjectiveOnRange(map, testSet)) {
            for (K x : map.keySet()) {
                V value = map.get(x);
                inverseMap.put(value,x);
            }
        }
        return inverseMap;
    }

    /**
     *
     * @param f
     * @param g
     * @param <K>
     * @param <V>
     * @param <W>
     * @return
     */
    public static <K, V, W> boolean compatible(Map<K, V> f, Map<V, W> g) {
         // TODO: implement 4.15

        HashSet<V> fSet = new HashSet<>();
        HashSet<V> gSet = new HashSet<>();

        fSet.addAll(f.values());
        gSet.addAll(g.keySet());

        return gSet.containsAll(fSet);

    }

    /**
     *
     * @param f
     * @param g
     * @param <K>
     * @param <V>
     * @param <W>
     * @return
     */
    public static <K, V, W> Map<K, W> compose(Map<K, V> f, Map<V, W> g) {
         // TODO: implement 4.15
        Map<K,W> composeMap = new HashMap<>(); // Create requested object

        if(compatible(f,g)) {
            for (K x : f.keySet()) {
                composeMap.put(x, g.get(f.get(x)));
            }
            return composeMap;
        }
        return null;

    }
}
