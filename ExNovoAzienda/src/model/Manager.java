package model;

import java.util.Date;

public class Manager extends Dipendente {
    private String areaDiResponsabilita;

    public Manager() {
        super();
    }

    public Manager(int id, String nome, String cognome, Date dataDiNascita, double stipendio,
            String areaDiResponsabilita) {
        super(id, nome, cognome, dataDiNascita, stipendio);
        this.areaDiResponsabilita = areaDiResponsabilita;
    }

    @Override
    public String toString() {
        return super.toString() + "," + areaDiResponsabilita;
    }

    public String getAreaDiResponsabilita() {
        return areaDiResponsabilita;
    }

    public void setAreaDiResponsabilita(String areaDiResponsabilita) {
        this.areaDiResponsabilita = areaDiResponsabilita;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((areaDiResponsabilita == null) ? 0 : areaDiResponsabilita.hashCode());
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
        Manager other = (Manager) obj;
        if (areaDiResponsabilita == null) {
            if (other.areaDiResponsabilita != null)
                return false;
        } else if (!areaDiResponsabilita.equals(other.areaDiResponsabilita))
            return false;
        return true;
    }

}
