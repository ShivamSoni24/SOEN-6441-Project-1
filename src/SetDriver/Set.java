package SetDriver;

import java.util.*;

public class Set<T extends Identifiable> {

    private Map<Integer, T> elements;

    public Set() {
        elements = new HashMap<>();
    }

    public boolean add(T element) {
        if (elements.containsKey(element)) {
            return false;
        }

        elements.put(element.getID(), element);
        return true;
    }

    public T remove(int id) {
        return elements.remove(id);
    }

    public boolean peek(int id) {
        return elements.containsKey(id);
    }

    public int size() {
        return elements.size();
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof Set<?> otherSet) {
            if (otherSet.size() == size()) {
                for (T element : elements.values()) {
                    if (!otherSet.peek(element.getID())) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public void display() {
        System.out.println(elements.values());
    }
}
