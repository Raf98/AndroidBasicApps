package com.example.bdsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try
        {
            SQLiteDatabase dataBase = openOrCreateDatabase("app", MODE_PRIVATE, null);

            //dataBase.execSQL("CREATE TABLE IF NOT EXISTS people(name VARCHAR, age INT(3))");
            //dataBase.execSQL("DROP TABLE people");

            dataBase.execSQL("CREATE TABLE IF NOT EXISTS people(id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR, age INT(3))");



            //dataBase.execSQL("INSERT INTO people(name, age) VALUES('Mariana', 18)");
            //dataBase.execSQL("INSERT INTO people(name, age) VALUES('Pedro', 50)");
            //dataBase.execSQL("INSERT INTO people(name, age) VALUES('Mario', 40)");

            //dataBase.execSQL("UPDATE people SET age = 19, name = 'Mariana Silva' WHERE name = 'Mariana'");

            //dataBase.execSQL("UPDATE people SET age = 19, name = 'Mariana Silva' WHERE id = 1");
            //for(int i=4; i<=12; i++)
            //{
            //    dataBase.execSQL("DELETE FROM people WHERE id =" + i);
            //}


            //query significa consulta
            //String query =
            //                "SELECT name, age FROM people " +
            //                "WHERE age >= 35 OR age = 18";

            //String query =
            //                "SELECT name, age FROM people " +
            //                "WHERE name IN('Maria', 'Jamilton')";

            //String query =
            //                "SELECT name, age FROM people " +
            //                "WHERE age BETWEEN 30 AND 35";

            //String query =
            //        "SELECT name, age FROM people " +
            //                "WHERE name LIKE '%ar%'";

            String query =
                    "SELECT * FROM people "+
                            //"WHERE 1=1 ORDER BY age ASC LIMIT 5";
                            "WHERE 1=1 ORDER BY age";

            Cursor cursor = dataBase.rawQuery(query, null);

            int indexName = cursor.getColumnIndex(  "name");
            int indexAge = cursor.getColumnIndex(  "age");
            int indexId = cursor.getColumnIndex(  "id");

            //volta para a primeira tupla/linha da tabela
            cursor.moveToFirst();

            while(cursor != null)
            {
                Log.i("RESULTADO - id ",  cursor.getString(indexId) + "; nome " + cursor.getString(indexName) + "; idade: " + cursor.getString(indexAge));

                //vai para a proxima tupla/linha da tabela
                cursor.moveToNext();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
