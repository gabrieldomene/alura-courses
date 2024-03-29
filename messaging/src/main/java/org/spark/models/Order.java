package org.spark.models;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer codigo;
    private Calendar dataPedido;
    private Calendar dataPagamento;
    private BigDecimal valorTotal;

    @XmlElementWrapper(name="itens")
    @XmlElement(name="item")
    private Set<Item> itens = new LinkedHashSet<>();


    Order() {
    }

    public Order(Integer codigo, Calendar dataPedido, Calendar dataPagamento, BigDecimal valorTotal) {
        this.codigo = codigo;
        this.dataPedido = dataPedido;
        this.dataPagamento = dataPagamento;
        this.valorTotal = valorTotal;
    }

    public void adicionaItem(Item item) {
        this.itens.add(item);
    }

    public Integer getCodigo() {
        return codigo;
    }

    public Calendar getDataPedido() {
        return dataPedido;
    }

    public Calendar getDataPagamento() {
        return dataPagamento;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public Set<Item> getItens() {
        return Collections.unmodifiableSet(this.itens);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
        Order other = (Order) obj;
        if (codigo == null) {
            if (other.codigo != null)
                return false;
        } else if (!codigo.equals(other.codigo))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Pedido [codigo=" + codigo + ", dataPedido=" + dataPedido + ", dataPagamento=" + dataPagamento
                + ", valorTotal=" + valorTotal + ", itens=" + itens + "]";
    }



}