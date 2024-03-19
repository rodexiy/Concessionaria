package net.weg.topcar.view;

public class EntradaDecimal extends Entrada<Float> {

    @Override
    public Float leia() {
        return sc.nextFloat();
    }
}
