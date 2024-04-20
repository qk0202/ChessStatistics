package com.example.chess_statistics;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.chess_statistics.Model.Player;

import java.util.ArrayList;
import java.util.List;

public class PlayerDatabaseHelper extends SQLiteOpenHelper {

    // Tên cơ sở dữ liệu và phiên bản
    private static final String DATABASE_NAME = "players_database";
    private static final int DATABASE_VERSION = 1;

    // Tên bảng và các cột
    private static final String TABLE_PLAYERS = "players";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_POINT = "point";
    private static final String COLUMN_PREF = "pref";

    // Câu lệnh tạo bảng
    private static final String CREATE_PLAYERS_TABLE = "CREATE TABLE " + TABLE_PLAYERS + "("
            + COLUMN_ID + " INTEGER PRIMARY KEY,"
            + COLUMN_NAME + " TEXT,"
            + COLUMN_POINT + " INTEGER,"
            + COLUMN_PREF + " TEXT"
            + ")";

    public PlayerDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Tạo bảng players
        db.execSQL(CREATE_PLAYERS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop bảng nếu tồn tại
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PLAYERS);
        // Tạo lại bảng
        onCreate(db);
    }

    // Thêm một người chơi vào cơ sở dữ liệu
    public void addPlayer(Player player) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, player.getName());
        values.put(COLUMN_POINT, player.getPoint());
        values.put(COLUMN_PREF, player.getType());

        // Chèn hàng mới
        db.insert(TABLE_PLAYERS, null, values);
        db.close();
    }

    // Cập nhật thông tin của một người chơi
    public void updatePlayer(Player player) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, player.getName());
        values.put(COLUMN_POINT, player.getPoint());
        values.put(COLUMN_PREF, player.getType());

        // Cập nhật hàng
        db.update(TABLE_PLAYERS, values, COLUMN_ID + " = ?",
                new String[]{String.valueOf(player.getId())});
        db.close();
    }

    // Xóa một người chơi khỏi cơ sở dữ liệu
    public void deletePlayer(Player player) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_PLAYERS, COLUMN_ID + " = ?",
                new String[]{String.valueOf(player.getId())});
        db.close();
    }

    // Lấy tất cả người chơi từ cơ sở dữ liệu
    public List<Player> getAllPlayers() {
        List<Player> playersList = new ArrayList<>();

        String selectQuery = "SELECT  * FROM " + TABLE_PLAYERS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // Duyệt qua tất cả các hàng và thêm vào danh sách
        if (cursor.moveToFirst()) {
            do {
                Player player = new Player();
                player.setId(Integer.parseInt(cursor.getString(0)));
                player.setName(cursor.getString(1));
                player.setPoint(cursor.getInt(2));
                player.setType(cursor.getString(3));
                playersList.add(player);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return playersList;
    }
}