package model;
public class Petugas {
    private int id;
    private String namaPetugas;
    private String username;
    private String password;

    public Petugas() {
        
    }
    public Petugas(int id, String namaPetugas) {
        this.id = id;
        this.namaPetugas = namaPetugas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNamaPetugas() {
        return namaPetugas;
    }

    public void setNamaPetugas(String namaPetugas) {
        this.namaPetugas = namaPetugas;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Petugas(int id, String namaPetugas, String username, String password) {
        this.id = id;
        this.namaPetugas = namaPetugas;
        this.username = username;
        this.password = password;
    }
}
