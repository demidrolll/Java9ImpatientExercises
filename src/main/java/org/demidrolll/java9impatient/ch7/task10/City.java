package org.demidrolll.java9impatient.ch7.task10;

/**
 * @author Dmitry Ivzhenko (dmitry.ivjenko@softclub.by)
 */
public enum City {
    BREST("Brest"),
    MINSK("Minsk"),
    GRODNO("Grodno"),
    GOMEL("Gomel"),
    VITEBSK("Vitebsk"),
    MOGILEV("Mogilev"),
    ;

    private String name;

    City(String name) {
        this.name = name;
    }
}
