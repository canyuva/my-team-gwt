package com.myTeam.shared;


import java.io.Serializable;

public class CategoryDTO implements Serializable {
    private int pk_cat_id;
    private String cat_name;

    public int getPk_cat_id() {
        return pk_cat_id;
    }

    public void setPk_cat_id(int pk_cat_id) {
        this.pk_cat_id = pk_cat_id;
    }

    public String getCat_name() {
        return cat_name;
    }

    public void setCat_name(String cat_name) {
        this.cat_name = cat_name;
    }
}
