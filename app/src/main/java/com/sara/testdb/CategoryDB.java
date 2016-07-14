package com.sara.testdb;

import android.util.Log;

import com.activeandroid.query.Select;

import java.util.List;

/**
 * Created by Bassem on 7/14/2016.
 */
public class CategoryDB {

    public static void InsertCategories(List<Category> lst_category) {

        try {

            for (Category category : lst_category) {

                category.save();
            }
            Log.e("category_db", "inserted");
        } catch (Exception e) {
            Log.e("db_error", e + "");
        }
    }

    public static Category GetCategoryDB(int id) {

        return new Select().from(Category.class)
                .where("cat_id=?", id).executeSingle();
    }

    public static List<Category> GetAllCategory() {
        return new Select().from(Category.class).execute();
    }



}
