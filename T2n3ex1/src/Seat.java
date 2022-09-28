import java.util.Objects;
public class Seat {
    private int row;
    private int number;
    private String name;

    public Seat(int row, int number, String name) {
        this.row = row;
        this.number = number;
        this.name = name;
    }
    public Seat(int row, int number) {
        this.row = row;
        this.number = number;

    }

    public Seat() {

    }

    @Override
    public String toString() {
        return
                "Row: " + row +
                ", Number: " + number +
                ", Name: " + name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Seat seat = (Seat) o;
        return row == seat.row && number == seat.number;
    }

   @Override
    public int hashCode() {
        return Objects.hash(row, number, name);
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
