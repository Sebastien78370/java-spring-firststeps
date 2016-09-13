package com.springapp.mvc.firststeps;

import java.io.Serializable;

/**
 * Created by sktifa on 13/09/2016.
 */
public abstract class AbstractAnimal implements Animal, Serializable {
    private String name;
    private String nature;
    private String previewUrl;

    public AbstractAnimal(String name, String nature) {
        this.name = name;
        this.nature = nature;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public String getPreviewUrl() {
        return previewUrl;
    }

    public void setPreviewUrl(String previewUrl) {
        this.previewUrl = previewUrl;
    }
}
