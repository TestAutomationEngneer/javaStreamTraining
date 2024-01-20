package jacksonOperations;

import java.util.Date;

public class Movie {
    private String title;
    private Date date;
    private int rating;
    private boolean oscarPrized;
    private double budget;

    public Movie(String title, Date date, int rating, boolean oscarPrized, double budget) {
        this.title = title;
        this.date = date;
        this.rating = rating;
        this.oscarPrized = oscarPrized;
        this.budget = budget;
    }

    public Movie() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
        this.oscarPrized = oscarPrized;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", date=" + date +
                ", rating=" + rating +
                ", oscarPrized=" + oscarPrized +
                ", budget=" + budget +
                '}';
    }
}
