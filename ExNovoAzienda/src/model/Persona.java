package model;

import java.text.SimpleDateFormat;
import java.util.*;

public class Persona {
    private int id;
    private String nome;
    private String cognome;
    private Date dataDiNascita;

    public Persona() {
    }

    public Persona(int id, String nome, String cognome, Date dataDiNascita) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.dataDiNascita = dataDiNascita;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public Date getDataDiNascita() {
        return dataDiNascita;
    }

    public void setDataDiNascita(Date dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }

    @Override
    public String toString() {
        SimpleDateFormat converti = new SimpleDateFormat("dd/MM/yyyy");
        return id + "," + nome + "," + cognome + "," + converti.format(dataDiNascita);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cognome == null) ? 0 : cognome.hashCode());
        result = prime * result + ((dataDiNascita == null) ? 0 : dataDiNascita.hashCode());
        result = prime * result + id;
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Persona other = (Persona) obj;
        if (cognome == null) {
            if (other.cognome != null)
                return false;
        } else if (!cognome.equals(other.cognome))
            return false;
        if (dataDiNascita == null) {
            if (other.dataDiNascita != null)
                return false;
        } else if (!dataDiNascita.equals(other.dataDiNascita))
            return false;
        if (id != other.id)
            return false;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        return true;
    }

}
