package maktab58_HW3_abiri;

public class Dinner extends Foods{
    public Dinner() {

    }
    public Dinner(int id, String name, int price, int count) {
        super(id, name, price, count);
    }
    @Override
    public String toString() {
        return "Dinners{" +
                "id=" + this.getId() +
                ", name='" + this.getName() + '\'' +
                ", price=" + this.getPrice() +
                ", count=" + this.getCount() +
                '}';
    }
}
