package ru.alexandrstal.gsa.domain;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@JsonSerialize(using = ru.alexandrstal.gsa.domain.serializer.GraphSerializer.class)
public class Graph {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Vertex from;

    @NotNull
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Vertex to;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Vertex getFrom() {
        return from;
    }

    public void setFrom(Vertex from) {
        this.from = from;
        from.getFrom().add(this);
    }

    public Vertex getTo() {
        return to;
    }

    public void setTo(Vertex to) {
        to.getTo().add(this);
        this.to = to;
    }
}
