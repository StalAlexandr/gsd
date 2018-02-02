package ru.alexandrstal.gsa.domain;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class Position {

    @NotNull
    private Integer height;

    @NotNull
    private Integer width;

    @NotNull
    private Integer xposition;

    @NotNull
    private Integer yposition;

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getXposition() {
        return xposition;
    }

    public void setXposition(Integer xposition) {
        this.xposition = xposition;
    }

    public Integer getYposition() {
        return yposition;
    }

    public void setYposition(Integer ypositipn) {
        this.yposition = ypositipn;
    }
}
