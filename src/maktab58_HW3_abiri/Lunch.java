package maktab58_HW3_abiri;

public class Lunch extends Foods{
    public Lunch() {
    }
    public Lunch(int id, String name, int price, int count) {
        super(id, name, price, count);
    }
    @Override
    public String toString() {
        return "Lunches{" +
                "id=" + this.getId() +
                ", name='" + this.getName() + '\'' +
                ", price=" + this.getPrice() +
                ", count=" + this.getCount() +
                '}';
    }
}
