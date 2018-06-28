package com.example.nastisch.cakeroom;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.example.nastisch.cakeroom.Model.Customer;
import com.example.nastisch.cakeroom.Model.Product;

public class CakeRoomDB extends SQLiteOpenHelper {

    private static String database_name = "cakeroom.db";
    private static int database_edition = 1;
    private static String table_1 = "tbCompany";
    private static String table_2 = "tbCustomer";
    private static String table_3 = "tbStore";
    private static String table_4 = "tbStaff";
    private static String table_5 = "tbProduct";
    private static String table_6 = "tbOrder";
    private static String table_7 = "tbShopping_Cart";
    private static String table_8 = "tbPayment";
    private static String table_9 = "tbC_Address_Details";
    private static String table_10 = "tbC_Card_Details";
    private static String table_11 = "tbStore_Zip";
    private static String table_12 = "tbStore_Suburb";
    private static String table_13 = "tbStaff_Position";
    private static String table_14 = "tbCustomer_Store";
    private static String table_15 = "tbStaff_Manager";
    private static String table_16 = "tbP_Category";
    private static String table_17 = "tbOrder_Details";
    private static String table_18 = "tbProduct_Store";
    private static String table_19 = "tbLoyalty_Points";
    private static String table_20 = "tbLP_Product";
    private static String table_21 = "tbSharing";

    private static String col_c_id = "Customer ID";
    private static String col_p_id = "Product ID";
    private static String col_p_name = "Product Name";
    private Context context;
    private SQLiteDatabase sqLiteDatabase;


    public CakeRoomDB(Context context) {
        super(context, database_name, null, database_edition);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL("create table " + table_1 +
                    "(company_id integer PRIMARY KEY AUTOINCREMENT," +
                    "company_name varchar(50)," +
                    "store_id int(10)," +
                    "FOREIGN KEY(store_id) REFERENCES tbStore(store_id) ON UPDATE CASCADE)");
            Toast.makeText(context, "Company Table CREATED", Toast.LENGTH_LONG).show();

            db.execSQL("create table " + table_2 + " " +
                    "(c_id integer PRIMARY KEY AUTOINCREMENT," +
                    "c_fname varchar(50)," +
                    "c_lname varchar(50)," +
                    "c_zip varchar(10)," +
                    "c_card_number int(20)," +
                    "cus_store_id int(10)," +
                    "ord_id int(10)," +
                    "ord_det_id int(10)," +
                    "lp_points int(10)," +
                    "FOREIGN KEY(c_zip) REFERENCES tbC_Address_Details(c_zip) ON UPDATE CASCADE, " +
                    "FOREIGN KEY(c_card_number) REFERENCES tbC_Card_Details(c_card_number) ON UPDATE CASCADE, " +
                    "FOREIGN KEY(cus_store_id) REFERENCES tbCustomer_Store(cus_store_id) ON UPDATE CASCADE, " +
                    "FOREIGN KEY(ord_id) REFERENCES tbOrder(ord_id) ON UPDATE CASCADE, " +
                    "FOREIGN KEY(ord_det_id) REFERENCES tbOrder_Details(ord_det_id) ON UPDATE CASCADE, " +
                    "FOREIGN KEY(lp_points) REFERENCES tbLoyalty_Points(lp_points) ON UPDATE CASCADE)");
            Toast.makeText(context, "Customer Table CREATED", Toast.LENGTH_LONG).show();

            db.execSQL("create table " + table_3 + " " +
                    "(store_id integer PRIMARY KEY AUTOINCREMENT," +
                    "store_zip int(10)," +
                    "staff_id int(10)," +
                    "cus_store_id int(10)," +
                    "store_phone int(50)," +
                    "store_suburb varchar(50)," +
                    "FOREIGN KEY(store_zip) REFERENCES tbStore_Zip(store_zip) ON UPDATE CASCADE, " +
                    "FOREIGN KEY(staff_id) REFERENCES tbStaff(staff_id) ON UPDATE CASCADE, " +
                    "FOREIGN KEY(cus_store_id) REFERENCES tbCustomer_Store(cus_store_id) ON UPDATE CASCADE, " +
                    "FOREIGN KEY(store_suburb) REFERENCES tbStore_Suburb(store_suburb) ON UPDATE CASCADE)");
            Toast.makeText(context, "Store Table CREATED", Toast.LENGTH_LONG).show();

            db.execSQL("create table " + table_4 + " " +
                    "(staff_id integer PRIMARY KEY AUTOINCREMENT," +
                    "staff_fname varchar(50)," +
                    "staff_lname varchar(50)," +
                    "staff_position varchar(50)," +
                    "staff_salary money," +
                    "store_id int(10)," +
                    "sm_type varchar(50)," +
                    "FOREIGN KEY(staff_position) REFERENCES tbStaff_Position(staff_position) ON UPDATE CASCADE, " +
                    "FOREIGN KEY(store_id) REFERENCES tbStore(store_id) ON UPDATE CASCADE, " +
                    "FOREIGN KEY(sm_type) REFERENCES tbStaff_Manager(sm_type) ON UPDATE CASCADE)");
            Toast.makeText(context, "Staff Table CREATED", Toast.LENGTH_LONG).show();

            db.execSQL("create table " + table_5 + " " +
                    "(p_id integer PRIMARY KEY AUTOINCREMENT," +
                    "p_name varchar(50)," +
                    "p_price money," +
                    "p_description varchar(50)," +
                    "lp_prod_id int(10)," +
                    "p_category varchar(50)," +
                    "p_ingredients varchar(50)," +
                    "p_aval_quantity int(10)," +
                    "FOREIGN KEY(lp_prod_id) REFERENCES tbLP_Product(lp_prod_id) ON UPDATE CASCADE, " +
                    "FOREIGN KEY(p_category) REFERENCES tbP_Category(p_category) ON UPDATE CASCADE)");
            Toast.makeText(context, "Product Table CREATED", Toast.LENGTH_LONG).show();

            db.execSQL("create table " + table_6 + " " +
                    "(ord_id integer PRIMARY KEY AUTOINCREMENT," +
                    "ord_det_id int(10)," +
                    "c_id int(10)," +
                    "ord_date date," +
                    "ord_total_amount money," +
                    "ord_quantity int(10)," +
                    "FOREIGN KEY(ord_det_id) REFERENCES tbOrder_Details(ord_det_id) ON UPDATE CASCADE, " +
                    "FOREIGN KEY(c_id) REFERENCES tbCustomer(c_id) ON UPDATE CASCADE)");
            Toast.makeText(context, "Order Table CREATED", Toast.LENGTH_LONG).show();

            db.execSQL("create table " + table_7 + " " +
                    "(sh_cart_id integer PRIMARY KEY AUTOINCREMENT," +
                    "sh_c_item_quantity int(10)," +
                    "sh_c_item_on_hold boolean," +
                    "ord_det_id int(10)," +
                    "ord_total_amount money," +
                    "ord_quantity int(10)," +
                    "FOREIGN KEY(ord_det_id) REFERENCES tbOrder_Details(ord_det_id) ON UPDATE CASCADE, " +
                    "FOREIGN KEY(pay_id) REFERENCES tbPayment(pay_id) ON UPDATE CASCADE)");
            Toast.makeText(context, "Shopping Cart Table CREATED", Toast.LENGTH_LONG).show();

            db.execSQL("create table " + table_8 + " " +
                    "(pay_id integer PRIMARY KEY AUTOINCREMENT," +
                    "sh_cart_id int(10)," +
                    "pay_amount money," +
                    "pay_method varchar(50)," +
                    "c_card_number int(20)," +
                    "FOREIGN KEY(sh_cart_id) REFERENCES tbShopping_Cart(sh_cart_id) ON UPDATE CASCADE, " +
                    "FOREIGN KEY(c_card_number) REFERENCES tbC_Card_Details(c_card_number) ON UPDATE CASCADE)");
            Toast.makeText(context, "Payment Table CREATED", Toast.LENGTH_LONG).show();

            db.execSQL("create table " + table_9 + " " +
                    "(c_zip integer PRIMARY KEY AUTOINCREMENT," +
                    "c_street varchar(50)," +
                    "c_city varchar(50)," +
                    "c_state varchar(50)," +
                    "c_id int(10)," +
                    "c_suburb varchar(50)," +
                    "FOREIGN KEY(c_id) REFERENCES tbCustomer(c_id) ON UPDATE CASCADE)");
            Toast.makeText(context, "Customer Address Details Table CREATED", Toast.LENGTH_LONG).show();

            db.execSQL("create table " + table_10 + " " +
                    "(c_card_number integer PRIMARY KEY AUTOINCREMENT," +
                    "c_card_full_name varchar(100)," +
                    "c_card_type varchar(20)," +
                    "c_card_expiry_date date," +
                    "c_id int(10)," +
                    "c_card_cvv int(3)," +
                    "FOREIGN KEY(c_id) REFERENCES tbCustomer(c_id) ON UPDATE CASCADE)");
            Toast.makeText(context, "Customer Card Details Table CREATED", Toast.LENGTH_LONG).show();

            db.execSQL("create table " + table_11 + " " +
                    "(store_zip integer PRIMARY KEY AUTOINCREMENT," +
                    "store_street varchar(50)," +
                    "store_building varchar(10)," +
                    "store_id int(10)," +
                    "FOREIGN KEY(store_id) REFERENCES tbStore(store_id) ON UPDATE CASCADE)");
            Toast.makeText(context, "Store Zip Table CREATED", Toast.LENGTH_LONG).show();

            db.execSQL("create table " + table_12 + " " +
                    "(store_suburb varchar PRIMARY KEY AUTOINCREMENT," +
                    "store_street varchar(50)," +
                    "store_id int(10)," +
                    "FOREIGN KEY(store_id) REFERENCES tbStore(store_id) ON UPDATE CASCADE)");
            Toast.makeText(context, "Store Suburb Table CREATED", Toast.LENGTH_LONG).show();

            db.execSQL("create table " + table_13 + " " +
                    "(staff_position varchar PRIMARY KEY AUTOINCREMENT," +
                    "staff_id int(10)," +
                    "staff_is_manager boolean," +
                    "staffp_description varchar(250)," +
                    "FOREIGN KEY(staff_id) REFERENCES tbStaff(staff_id) ON UPDATE CASCADE)");
            Toast.makeText(context, "Staff Position Table CREATED", Toast.LENGTH_LONG).show();

            db.execSQL("create table " + table_14 + " " +
                    "(cus_store_id integer PRIMARY KEY AUTOINCREMENT," +
                    "c_id int(10)," +
                    "c_reg_date date," +
                    "store_id int(10)," +
                    "FOREIGN KEY(c_id) REFERENCES tbCustomer(c_id) ON UPDATE CASCADE, " +
                    "FOREIGN KEY(store_id) REFERENCES tbStore(store_id) ON UPDATE CASCADE)");
            Toast.makeText(context, "Customer Store Table CREATED", Toast.LENGTH_LONG).show();

            db.execSQL("create table " + table_15 + " " +
                    "(sm_type varchar PRIMARY KEY AUTOINCREMENT," +
                    "staff_id int(10)," +
                    "sm_duties varchar(250)," +
                    "FOREIGN KEY(staff_id) REFERENCES tbStaff(staff_id) ON UPDATE CASCADE)");
            Toast.makeText(context, "Staff Manager Table CREATED", Toast.LENGTH_LONG).show();

            db.execSQL("create table " + table_16 + " " +
                    "(p_category varchar PRIMARY KEY AUTOINCREMENT," +
                    "p_id int(10)," +
                    "FOREIGN KEY(p_id) REFERENCES tbProduct(p_id) ON UPDATE CASCADE)");
            Toast.makeText(context, "Product Category Table CREATED", Toast.LENGTH_LONG).show();

            db.execSQL("create table " + table_17 + " " +
                    "(ord_det_id integer PRIMARY KEY AUTOINCREMENT," +
                    "p_id int(10)," +
                    "ord_id int(10)," +
                    "c_id int(10)," +
                    "ord_det_pickup_date date," +
                    "ord_det_return_date date," +
                    "FOREIGN KEY(p_id) REFERENCES tbProduct(p_id) ON UPDATE CASCADE, " +
                    "FOREIGN KEY(c_id) REFERENCES tbCustomer(c_id) ON UPDATE CASCADE, " +
                    "FOREIGN KEY(ord_id) REFERENCES tbOrder(ord_id) ON UPDATE CASCADE)");
            Toast.makeText(context, "Order Details Table CREATED", Toast.LENGTH_LONG).show();

            db.execSQL("create table " + table_18 + " " +
                    "(pr_store_id integer PRIMARY KEY AUTOINCREMENT," +
                    "store_id int(10)," +
                    "p_id int(10)," +
                    "p_status boolean," +
                    "FOREIGN KEY(p_id) REFERENCES tbProduct(p_id) ON UPDATE CASCADE, " +
                    "FOREIGN KEY(store_id) REFERENCES tbStore(store_id) ON UPDATE CASCADE)");
            Toast.makeText(context, "Product Store Table CREATED", Toast.LENGTH_LONG).show();

            db.execSQL("create table " + table_19 + " " +
                    "(lp_id integer PRIMARY KEY AUTOINCREMENT," +
                    "lp_name varchar(50)," +
                    "lp_description varchar(250)," +
                    "lp_points int(10)," +
                    "lp_tcs varchar(3000)," +
                    "lp_prod_id int(10)," +
                    "FOREIGN KEY(lp_prod_id) REFERENCES tbLP_Product(lp_prod_id) ON UPDATE CASCADE)");
            Toast.makeText(context, "Loyalty Points Table CREATED", Toast.LENGTH_LONG).show();

            db.execSQL("create table " + table_20 + " " +
                    "(lp_prod_id integer PRIMARY KEY AUTOINCREMENT," +
                    "p_id int(10)," +
                    "lp_id int(10)," +
                    "FOREIGN KEY(p_id) REFERENCES tbProduct(p_id) ON UPDATE CASCADE, " +
                    "FOREIGN KEY(lp_id) REFERENCES tbLoyalty_Points(lp_id) ON UPDATE CASCADE)");
            Toast.makeText(context, "Loyalty Points Product Table CREATED", Toast.LENGTH_LONG).show();

            db.execSQL("create table " + table_21 + " " +
                    "(shar_id integer PRIMARY KEY AUTOINCREMENT," +
                    "p_id int(10)," +
                    "soc_network_id int(10)," +
                    "email_type_id int(10)," +
                    "FOREIGN KEY(p_id) REFERENCES tbProduct(p_id) ON UPDATE CASCADE)");
            Toast.makeText(context, "Sharing Table CREATED", Toast.LENGTH_LONG).show();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("drop table if exists " + table_1);
        db.execSQL("drop table if exists " + table_2);
        db.execSQL("drop table if exists " + table_3);
        db.execSQL("drop table if exists " + table_4);
        db.execSQL("drop table if exists " + table_5);
        db.execSQL("drop table if exists " + table_6);
        db.execSQL("drop table if exists " + table_7);
        db.execSQL("drop table if exists " + table_8);
        db.execSQL("drop table if exists " + table_9);
        db.execSQL("drop table if exists " + table_10);
        db.execSQL("drop table if exists " + table_11);
        db.execSQL("drop table if exists " + table_12);
        db.execSQL("drop table if exists " + table_13);
        db.execSQL("drop table if exists " + table_14);
        db.execSQL("drop table if exists " + table_15);
        db.execSQL("drop table if exists " + table_16);
        db.execSQL("drop table if exists " + table_17);
        db.execSQL("drop table if exists " + table_18);
        db.execSQL("drop table if exists " + table_19);
        db.execSQL("drop table if exists " + table_20);
        db.execSQL("drop table if exists " + table_21);
        onCreate(db);

    }

    public void Open() {
        sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.execSQL("PRAGMA foreign_keys = ON;");
    }


    public void Close() {
        sqLiteDatabase.close();
    }

    public boolean insert_Product(Product product) {
        Cursor cursor = getAllProducts();
        if (cursor != null) {
            while (cursor.moveToNext()) {
                String p_name = cursor.getString(1);
                double p_price = cursor.getDouble(2);
                String p_description = cursor.getString(3);
                int lp_prod_id = cursor.getInt(4);
                String p_category = cursor.getString(5);
                String p_ingredients = cursor.getString(6);
                int p_avail_quantity = cursor.getInt(7);

                if (product.getpName().equals(p_name) && product.getpPricePerEach()==(p_price) && product.getpDescription().equals(p_description)
                        && product.getpLoyalty().equals(lp_prod_id) && product.getpCategory().equals(p_category)
                        && product.getpIngredients().equals(p_ingredients) && product.getpAvailQuantity()==(p_avail_quantity)) {
                    Toast.makeText(context, p_name + " " + " already exists", Toast.LENGTH_SHORT).show();
                    return false;
                }            }        }
        ContentValues cv = new ContentValues();
        cv.put("p_name", product.getpName());
        cv.put("p_price", product.getpPricePerEach());
        cv.put("p_description", product.getpDescription());
        cv.put("lp_prod", product.getpLoyalty());
        cv.put("p_category", product.getpCategory());
        cv.put("p_ingredients", product.getpIngredients());
        cv.put("p_aval_quantity", product.getpAvailQuantity());
        long status = sqLiteDatabase.insert(table_5, null, cv);
        if (status != -1) {
            return true;
        }
        return false;
    }

    public boolean insert_Customer(Customer customer) {

        ContentValues cv = new ContentValues();
        cv.put("c_fname", customer.getcFName());
        cv.put("c_lname", customer.getcLName());
        cv.put("c_zip", customer.getcZIP());
        cv.put("c_card_number", customer.getcCardNumber());
        cv.put("cus_store_id", customer.getStoreID());
        cv.put("ord_id", customer.getOrdID());
        cv.put("ord_det_id", customer.getOrdDetID());
        cv.put("lp_points", customer.getLpID());

        Long status = sqLiteDatabase.insert(table_2, null, cv);
        if (status != -1) {
            return true;
        } else {
            return false;
        }
    }

    public Cursor getAllProducts (){
        Cursor cursor;
        cursor = sqLiteDatabase.rawQuery("select * from " + table_5, null);

        return cursor;
    }

    public Cursor getAllCustomers (){
        Cursor cursor;
        cursor = sqLiteDatabase.rawQuery("select * from " + table_2, null);

        return cursor;
    }

    public Cursor fetchProduct_Store (String filter) {
        Cursor cursor;
        String query = "select a.p_id, c.pr_store_id from tbProduct a LEFT JOIN tbProduct_Store b ON a.p_id = b.p_id LEFT JOIN tbStore c ON c.store_id = b.store_id where c.store_zip=?";
        cursor = sqLiteDatabase.rawQuery(query, new String[]{filter});
        return cursor;
    }

    public Cursor getCustomerById(Customer c_id) {
        Cursor cursor = sqLiteDatabase.query(table_2, null,col_c_id + "=?",
                new String[] {String.valueOf(c_id)}, null, null, null);
        if (cursor!=null) {
            cursor.moveToFirst();
        }
        return cursor;
    }

    public Cursor getProductByName(Product p_name) {
        Cursor cursor = sqLiteDatabase.query(table_5, null,col_p_name + "=?",
                new String[] {p_name+""}, null, null, null);
        if (cursor!=null) {
            cursor.moveToFirst();
        }
        return cursor;
    }

    public int updateProductInfo (Product product) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("p_name", product.getpName());
        contentValues.put("p_category", product.getpCategory());
        contentValues.put("p_avail_quantity", product.getpAvailQuantity());
        contentValues.put("lp_prod", product.getpLoyalty());
        contentValues.put("p_description", product.getpDescription());
        contentValues.put("p_ingredients", product.getpIngredients());
        contentValues.put("p_price", product.getpPricePerEach());

        return sqLiteDatabase.update(table_5, contentValues, col_p_id+"=?", new String[]{String.valueOf(product.getpID())});
    }

    public int deleteProduct (Product p_id) {
        return sqLiteDatabase.delete(table_5, col_p_id+"=?", new String[] {String.valueOf(p_id)});
    }

    public int deleteCustomer (Customer c_id) {
        return sqLiteDatabase.delete(table_2, col_c_id+"=?", new String[] {String.valueOf(c_id)});
    }


}