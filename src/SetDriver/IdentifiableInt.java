package SetDriver;
public class IdentifiableInt implements Identifiable {
    private int id;
    private int val;

    public IdentifiableInt(int id, int val) {
        this.id = id;
        this.val = val;
    }

    @Override
    public int getID() {
        return id;
    }

    @Override
    public String toString() {
        return "IdentifiableInt{" +
                "id=" + id +
                ", val='" + val + '\'' +
                '}';
    }
}
