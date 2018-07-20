package com.myTeam.shared;


import lombok.Data;

import java.io.Serializable;

@Data
public class CategoryDTO implements Serializable {
   private int pk_cat_id;
   private String cat_name;
}
