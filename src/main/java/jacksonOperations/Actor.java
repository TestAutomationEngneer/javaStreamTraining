package jacksonOperations;

public class Actor {
    private String firstName;
    private String lastName;
    private int rating;
    private boolean oscarPrized;
    private double salary;
    private String city;

    public Actor(String firstName, String lastName, int rating, boolean oscarPrized, double salary, String city) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.rating = rating;
        this.oscarPrized = oscarPrized;
        this.salary = salary;
        this.city = city;
    }

    public Actor() {

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public boolean isOscarPrized() {
        return oscarPrized;
    }

    public void setOscarPrized(boolean oscarPrized) {
        oscarPrized = oscarPrized;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Actor{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", rating=" + rating +
                ", isOscarPrized=" + oscarPrized +
                ", salary=" + salary +
                ", city='" + city + '\'' +
                '}';
    }
}
