package ru.alexandrstal.gsa.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Status {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    String code;

    @NotNull
    String name;

    @JsonIgnore
    @NotNull
    @OneToOne(cascade = CascadeType.PERSIST)
    Node node;

    public Status() {
    }

    public Status(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
        node.setStatus(this);
    }
}
