package com.sara.testdb;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ArrayList<Category> lst_category = new ArrayList<>();
    List<Item> lst_item = new ArrayList<>();
    private TextView tv_result;
    private Button btn_select_cat, btn_select_item, btn_delete_item,
            btn_delete_items, btn_update_item, btn_custom_select;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SetupTools();
        SetupData();
    }

    private void SetupTools() {

        tv_result = (TextView) findViewById(R.id.tv_result_db);
        btn_select_cat = (Button) findViewById(R.id.btn_select_cat);
        btn_select_item = (Button) findViewById(R.id.btn_select_item);
        btn_delete_item = (Button) findViewById(R.id.btn_delete_item);
        btn_delete_items = (Button) findViewById(R.id.btn_delete_items);
        btn_update_item = (Button) findViewById(R.id.btn_update_items);
        btn_custom_select = (Button) findViewById(R.id.btn_custom_select);

        btn_select_item.setOnClickListener(this);
        btn_select_cat.setOnClickListener(this);
        btn_delete_item.setOnClickListener(this);
        btn_delete_items.setOnClickListener(this);
        btn_update_item.setOnClickListener(this);
        btn_custom_select.setOnClickListener(this);
    }

    private void SetupData() {

        // set category

        lst_category.add(new Category(1, "chicken"));
        lst_category.add(new Category(2, "sea food"));
        lst_category.add(new Category(3, "Grill"));
        lst_category.add(new Category(4, "Vegetables"));
        CategoryDB.InsertCategories(lst_category);

        // set items

        Item item = new Item();
        item.setItem_id(1);
        item.setItem_name("fried chicken");
        item.setCat_id(1);
        item.setCategory(CategoryDB.GetCategoryDB(1));
        item.setDate(new CustomSerializer().serialize(new Date()));
        lst_item.add(item);

        //--------------------------------
        item = new Item();
        item.setItem_id(2);
        item.setItem_name("chicken rolls");
        item.setCat_id(1);
        item.setDate(new CustomSerializer().serialize(new Date()));
        item.setCategory(CategoryDB.GetCategoryDB(1));

        lst_item.add(item);

        //----------------------------------------

        item = new Item();
        item.setItem_id(3);
        item.setItem_name("salmon");
        item.setCat_id(2);
        item.setCategory(CategoryDB.GetCategoryDB(2));

        lst_item.add(item);

        //-----------------------------------------------

        item = new Item();
        item.setItem_id(4);
        item.setItem_name("tuna");
        item.setCat_id(2);
        item.setCategory(CategoryDB.GetCategoryDB(2));

        lst_item.add(item);

        //------------------------------------------
        item = new Item();
        item.setItem_id(5);
        item.setItem_name("Sea Food Soap");
        item.setCat_id(2);
        item.setCategory(CategoryDB.GetCategoryDB(2));

        lst_item.add(item);

        //-----------------------------------------

        item = new Item();
        item.setItem_id(6);
        item.setItem_name("tuna");
        item.setCat_id(2);
        item.setCategory(CategoryDB.GetCategoryDB(2));

        lst_item.add(item);

        //--------------------------------
        item = new Item();
        item.setItem_id(7);
        item.setItem_name("tomato");
        item.setCat_id(4);
        item.setCategory(CategoryDB.GetCategoryDB(4));

        lst_item.add(item);

        //---------------------------------------

        item = new Item();
        item.setItem_id(8);
        item.setItem_name("Cucumber");
        item.setCat_id(4);
        item.setCategory(CategoryDB.GetCategoryDB(4));

        lst_item.add(item);

        //--------------------

        ItemDB.InsertItems(lst_item);
    }

    @Override
    public void onClick(View v) {

        if (v == btn_select_cat) {
            ViewCat(CategoryDB.GetAllCategory());
        } else if (v == btn_select_item) {
            ViewItem(ItemDB.GetAllItems());
        } else if (v == btn_delete_item) {
            ItemDB.deleteItem(6);
        } else if (v == btn_delete_items) {
            ItemDB.DeleteItems("(1,3,5)");
        } else if (v == btn_update_item) {
            ItemDB.UpdateItem("new Meal");
        } else if (v == btn_custom_select) {
            //tv_result.setText(ItemDB.SelectCustomItem());
            ViewItem(ItemDB.SelectItems(1));
        }
    }

    private void ViewCat(List<Category> categories) {

        StringBuilder str_cat = new StringBuilder();
        for (Category category : categories) {

            str_cat.append(category.getCat_id() + " - " + category.getCat_name() + "\n");
        }
        tv_result.setText(str_cat);
    }

    private void ViewItem(List<Item> items) {

        StringBuilder str_item = new StringBuilder();
        for (Item item : items) {

            str_item.append(item.getItem_id() + " - " +
                    item.getItem_name() + " - " + item.getCategory().getCat_name()
                    + " - " + new CustomSerializer().deserialize(item.getDate()) + "\n");
        }
        tv_result.setText(str_item);
    }
}
