package com.soebes.scms.bo;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Der Kunde, der eine Bestellung plaziert hat.
 *
 * @author Karl Heinz Marbaise
 *
 */
@Entity
@Table(name = TabellenNamen.KUNDE)
public class KundeBO extends BaseBO {
    private String name;
    private String adresse;
    private String telefonnummer;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAdresse() {
        return adresse;
    }
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    public String getTelefonnummer() {
        return telefonnummer;
    }
    public void setTelefonnummer(String telefonnummer) {
        this.telefonnummer = telefonnummer;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((adresse == null) ? 0 : adresse.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result
                + ((telefonnummer == null) ? 0 : telefonnummer.hashCode());
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
        KundeBO other = (KundeBO) obj;
        if (adresse == null) {
            if (other.adresse != null)
                return false;
        } else if (!adresse.equals(other.adresse))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (telefonnummer == null) {
            if (other.telefonnummer != null)
                return false;
        } else if (!telefonnummer.equals(other.telefonnummer))
            return false;
        return true;
    }

}
