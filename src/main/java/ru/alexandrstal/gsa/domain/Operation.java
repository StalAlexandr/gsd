package ru.alexandrstal.gsa.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Operation {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String code;

    @NotNull
    private String name;

    @OneToMany(mappedBy = "operation")
    Set<Operation2Document> documentSet = new HashSet<>();

    @OneToMany(mappedBy = "operation")
    Set<Operation2Letter> letterSet = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
