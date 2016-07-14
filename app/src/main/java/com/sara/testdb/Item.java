package com.sara.testdb;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

@Table(name = "item")
public class Item extends Model {

    @Column(name = "test1")
    String test1;
    @Column(name = "test2")
    String test2;

    @Column(name = "item_id", unique = true, onUniqueConflict = Column.ConflictAction.REPLACE)
    private int item_id;
    @Column(name = "item_name")
    private String item_name;
    @Column(name = "cat_id")
    private int cat_id;
    @Column(name = "category", onUpdate = Column.ForeignKeyAction.CASCADE,
            onDelete = Column.ForeignKeyAction.CASCADE)
    private Category category;

    @Column(name = "date")
    private long date;

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public Item() {
        super();
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public int getCat_id() {
        return cat_id;
    }

    public void setCat_id(int cat_id) {
        this.cat_id = cat_id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
