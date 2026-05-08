package br.edu.cursosifpb.model;
import br.edu.cursosifpb.enumerate.Bimestres;
import br.edu.cursosifpb.enumerate.Series;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Bimestre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Series serie;
    private Bimestres bimestre;
    private int nota1;
    private int nota2;
    private float media;

    public Bimestre() {}

    public Bimestres getBimestre() {
        return bimestre;
    }
    public void setBimestre(Bimestres bimestre) {
        this.bimestre = bimestre;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Series getSerie() {
        return serie;
    }
    public void setSerie(Series serie) {
        this.serie = serie;
    }
    public int getNota1() {
        return nota1;
    }
    public void setNota1(int nota1) {
        this.nota1 = nota1;
    }
    public int getNota2() {
        return nota2;
    }
    public void setNota2(int nota2) {
        this.nota2 = nota2;
    }
    public float getMedia() {
        return media;
    }
    public void setMedia(float media) {
        this.media = media;
    }
}
