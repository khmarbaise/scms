package com.soebes.scms.dao;

import com.soebes.scms.bo.BlogPostBO;
import com.soebes.scms.bo.FilialeBO;
import com.soebes.scms.bo.KundeBO;
import com.soebes.scms.bo.PizzaBO;
import com.soebes.scms.bo.PizzaGroesseBO;
import com.soebes.scms.bo.ZutatBO;

/**
 * This is factory class to create the different DAO instances.
 *
 * @author Karl Heinz Marbase
 *
 */
public final class DAOFactory {

    public static IdDAO<FilialeBO> getFiliale() {
        return new IdDAO<FilialeBO>(FilialeBO.class);
    }

    public static IdDAO<KundeBO> getKunde() {
        return new IdDAO<KundeBO>(KundeBO.class);
    }

    public static IdDAO<PizzaBO> getPizza() {
        return new IdDAO<PizzaBO>(PizzaBO.class);
    }

    public static IdDAO<PizzaGroesseBO> getPizzaGroesse() {
        return new IdDAO<PizzaGroesseBO>(PizzaGroesseBO.class);
    }

    public static IdDAO<ZutatBO> getZutat() {
        return new IdDAO<ZutatBO>(ZutatBO.class);
    }

    public static IdDAO<BlogPostBO> getBestellung() {
        return new IdDAO<BlogPostBO>(BlogPostBO.class);
    }
}
