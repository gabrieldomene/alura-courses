package org.spark.models;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class OrderFactory {

    public Order geraPedidoComValores() {
        Order order = new Order(2459, geraData("22/12/2016"), geraData("23/12/2016"), new BigDecimal("145.98"));

        Item motoG = geraItem(23,"Moto G");
        Item motoX = geraItem(51,"Moto X");

        order.adicionaItem(motoX);
        order.adicionaItem(motoG);

        return order;

    }

    private Item geraItem(int id, String nome) {
        return new Item(id,nome);
    }

    private Calendar geraData(String dataComString) {
        try {
            Date data = new SimpleDateFormat("dd/MM/yyyy").parse(dataComString);
            Calendar cal = Calendar.getInstance();
            cal.setTime(data);
            return cal;
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

}