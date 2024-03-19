package net.weg.topcar.view;

public class EntradaInteiro extends Entrada<Long>{

    @Override
    public Long leia() {
        return sc.nextLong();
    }
}
