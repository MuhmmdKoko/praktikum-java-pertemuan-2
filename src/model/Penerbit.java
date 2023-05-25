package model;
public class Penerbit {
    private int id;
    private String penerbit;

    public Penerbit(int id, String penerbit) {
        this.id = id;
        this.penerbit = penerbit;
    }

    public Penerbit() {
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPenerbit() {
        return penerbit;
    }

    public void setPenerbit(String penerbit) {
        this.penerbit = penerbit;
    }
}
