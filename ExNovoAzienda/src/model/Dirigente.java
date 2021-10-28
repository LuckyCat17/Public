package model;

import java.util.Date;

public class Dirigente extends Manager {
    private String livelloFunzionale;

    public String getLivelloFunzionale() {
        return livelloFunzionale;
    }

    public void setLivelloFunzionale(String livelloFunzionale) {
        this.livelloFunzionale = livelloFunzionale;
    }

    public Dirigente() {
        super();
    }

    public Dirigente(int id, String nome, String cognome, Date dataDiNascita, double stipendio,
            String areaDiResponsabilita, String livelloFunzionale) {
        super(id, nome, cognome, dataDiNascita, stipendio, areaDiResponsabilita);
        this.livelloFunzionale = livelloFunzionale;
    }

    @Override
    public String toString() {
        return super.toString() + "," + livelloFunzionale;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((livelloFunzionale == null) ? 0 : livelloFunzionale.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Dirigente other = (Dirigente) obj;
        if (livelloFunzionale == null) {
            if (other.livelloFunzionale != null)
                return false;
        } else if (!livelloFunzionale.equals(other.livelloFunzionale))
            return false;
        return true;
    }

}
