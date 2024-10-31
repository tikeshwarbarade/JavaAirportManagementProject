package Airport;

public class Airpojo {
    private int fno;
    private String airline, batch, source, destination;
    private int fare;
    private double traveld;

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int duration;

    public Airpojo(int fno, String airline, String batch, String source, String destination, int fare, double traveld , int duration) {
        this.fno = fno;
        this.airline = airline;
        this.batch = batch;
        this.source = source;
        this.destination = destination;
        this.fare = fare;
        this.traveld = traveld;
        this.duration = duration;
    }

    public int getFno() {
        return fno;
    }

    public void setFno(int fno) {
        this.fno = fno;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getFare() {
        return fare;
    }

    public void setFare(int fare) {
        this.fare = fare;
    }

    public double getTraveld() {
        return traveld;
    }

    public void setTraveld(double traveld) {
        this.traveld = traveld;
    }

    @Override
    public String toString() {
        return "Airpojo{" +
                "airline='" + airline + '\'' +
                ", batch='" + batch + '\'' +
                ", source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                ", fare=" + fare +
                ", traveld=" + traveld +
                ", fno=" + fno +
                '}';
    }
}