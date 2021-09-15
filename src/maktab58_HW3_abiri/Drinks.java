package maktab58_HW3_abiri;

public class Drinks extends Foods{
    public Drinks() {
    }

    public Drinks(int id, String name, int price, int count) {
        super(id, name, price, count);
    }

    @Override
    public String toString() {
        return "Drinks{" +
                "id=" + this.getId() +
                ", name='" + this.getName() + '\'' +
                ", price=" + this.getPrice() +
                ", count=" + this.getCount() +
                '}';
    }
}
