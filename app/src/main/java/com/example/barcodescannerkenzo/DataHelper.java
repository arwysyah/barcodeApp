package com.example.barcodescannerkenzo;






import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
public class DataHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "barcode1.db";
    private static final int DATABASE_VERSION = 1;
    public DataHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        // TODO Auto-generated constructor stub
    }
    @Override public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub




        db.execSQL("DROP TABLE IF EXISTS produk");
        db.execSQL("CREATE TABLE IF NOT EXISTS produk(barcode integer primary key autoincrement, nama_produk text, satuan text,harga integer,stok integer)");
        db.execSQL("INSERT INTO produk (barcode,  nama_produk , satuan,harga ,stok  ) VALUES ('8886008101053', 'aqua','ml','4000','60')");
        db.execSQL("INSERT INTO produk (barcode,  nama_produk , satuan,harga ,stok) VALUES ('8992752011033', 'Vit','ml','4000','100','100')");
        db.execSQL("INSERT INTO produk (barcode, nama_produk, satuan, harga, stok) VALUES ('8996001302088', 'Roma', '20','200', '100','200')");


    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS produk");

        onCreate(db);
    }
}


