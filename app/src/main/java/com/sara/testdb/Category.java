package com.sara.testdb;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by Bassem on 7/14/2016.
 */
@Table(name = "category")
public class Category extends Model {

    @Column(name = "cat_id", unique = true, onUniqueConflict = Column.ConflictAction.REPLACE)
    private int cat_id;

    @Column (name = "cat_name")
    private String cat_name;

    public Category() {
        super();
    }

    public Category(int cat_id, String cat_name) {

        this.cat_id = cat_id;
        this.cat_name = cat_name;
    }

    public int getCat_id() {

        return cat_id;
    }

    public void setCat_id(int cat_id) {
        this.cat_id = cat_id;
    }

    public String getCat_name() {
        return cat_name;
    }

    public void setCat_name(String cat_name) {
        this.cat_name = cat_name;
    }
}
