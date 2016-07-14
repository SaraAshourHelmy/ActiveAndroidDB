package com.sara.testdb;

import android.util.Log;

import com.activeandroid.query.Delete;
import com.activeandroid.query.Select;
import com.activeandroid.query.Update;

import java.util.List;

/**
 * Created by Bassem on 7/14/2016.
 */
public class ItemDB {

    public static void InsertItems(List<Item> lst_items) {

        try {
            for (Item item : lst_items) {

                item.save();
            }

            Log.e("item_db", "inserted");
        } catch (Exception e) {
            Log.e("item_db_error", e + "");
        }

    }

    public static List<Item> GetAllItems() {
        return new Select().from(Item.class).execute();
    }

    public static void deleteItem(int id) {
// sol1
        //SQLiteUtils.rawQuery(Item.class, "delete from item where item_id=?",
        //      new String[]{String.valueOf(id)});

        //sol2
        new Delete().from(Item.class).where("item_id=?", id).execute();
    }

    public static void DeleteItems(String ids) {

        // delete multiple rows
        new Delete().from(Item.class).where("item_id in " + ids).execute();
    }

    public static void UpdateItem(String name) {

        new Update(Item.class).set("item_name=?", name).where("item_id=4").execute();
    }

    public static String SelectCustomItem() {
        // must set Id when select specific columns
        String result = "";
        List<Item> lst_item =
                new Select(new String[]{"Id,item_name"}).from(Item.class).execute();

        for (Item item : lst_item) {

            result += item.getItem_name() + "\n";
        }
        return result;
    }

    public static List<Item> SelectItems(int cat_id) {

        // upper or lower to make text case insensitive
        return new Select().from(Item.class).join(Category.class)
                .on("item.category=category.Id").where("category.cat_id in " + "(1,2)")
                .orderBy("lower(item_name) desc").limit(3).execute();
    }
}
