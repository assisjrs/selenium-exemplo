package br.com.concrete.consumo.transacao;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;


/**
 * Created by assis on 14/03/17.
 */
@Entity
public class Transacao {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @NotEmpty
    private String usuario;

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date data;

    @NotNull
    @Column(scale = 5, precision = 2)
    private Double valor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final Transacao transacao = (Transacao) o;

        return id.equals(transacao.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "Transacao{" +
                "id=" + id +
                ", usuario='" + usuario + '\'' +
                ", data=" + data +
                ", valor=" + valor +
                '}';
    }
}
