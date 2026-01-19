package src;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Generic data pool that encapsulates storage and provides operations:
 * - add/remove
 * - listAll
 * - findById
 * - filter (Predicate)
 * - search (Predicate alias)
 * - sort (Comparator)
 *
 * This class follows data abstraction: internal list is private and callers receive copies.
 */
public class DataPool<T extends Identifiable> {
    private final List<T> items = new ArrayList<>();

    public DataPool() {}

    public void add(T item) {
        Objects.requireNonNull(item);
        if (findById(item.getId()).isEmpty()) items.add(item);
    }

    public boolean removeById(String id) {
        return items.removeIf(i -> Objects.equals(i.getId(), id));
    }

    public Optional<T> findById(String id) {
        return items.stream().filter(i -> Objects.equals(i.getId(), id)).findFirst();
    }

    public List<T> listAll() {
        return new ArrayList<>(items); // defensive copy
    }

    public List<T> filter(Predicate<T> predicate) {
        return items.stream().filter(predicate).collect(Collectors.toList());
    }

    // search is an alias for filter to reflect different intent
    public List<T> search(Predicate<T> predicate) {
        return filter(predicate);
    }

    public List<T> sort(Comparator<T> comparator, boolean ascending) {
        Comparator<T> cmp = ascending ? comparator : comparator.reversed();
        return items.stream().sorted(cmp).collect(Collectors.toList());
    }

    public int size() {
        return items.size();
    }
}