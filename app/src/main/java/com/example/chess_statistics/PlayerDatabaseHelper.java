package com.example.chess_statistics;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.chess_statistics.model.MatchList;
import com.example.chess_statistics.model.Player;
import com.example.chess_statistics.model.Round;
import com.example.chess_statistics.model.Tourment;
import com.example.chess_statistics.model.Type;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.sql.PreparedStatement;
import java.util.ArrayList;

public class PlayerDatabaseHelper extends SQLiteOpenHelper {

    // Tên cơ sở dữ liệu và phiên bản
    private static final String DATABASE_NAME = "players";
    private static final int DATABASE_VERSION = 1;

    // Tên bảng và các cột
    private static final String TABLE_PLAYERS = "Player";
    private static final String TABLE_TOUR = "tournaments";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";

    private static final String COLUMN_POINT = "point";
    private static final String COLUMN_AVATAR = "avatar";

    private static final String COLUMN_FLAG = "flag";
    private static final String COLUMN_RANK = "rank";
    private static final String COLUMN_WIN = "win";

    private static final String COLUMN_LOST = "lost";

    // Câu lệnh tạo bảng
    private static final String CREATE_PLAYERS_TABLE = "CREATE TABLE if not exists " + TABLE_PLAYERS + "("
            + COLUMN_ID + " INTEGER PRIMARY KEY,"
            + COLUMN_NAME + "TEXT,"
            + COLUMN_POINT + " INTEGER,"
            + COLUMN_AVATAR + "STRING,"
            + COLUMN_FLAG + "STRING,"
            + COLUMN_RANK + " INTEGER,"
            + COLUMN_WIN + "INTEGER,"
            + COLUMN_LOST + "INTEGER"
            + ")";

    private static final String CREATE_TOUR_TABLE = "CREATE TABLE if not exists " + TABLE_TOUR + "("
            + "tour_id" + " INTEGER PRIMARY KEY,"
            + "name" + "STRING,"
            + "ipTour" + "STRING,"
            + "avtTour" + " STRING"
            + ")";

    public PlayerDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @SuppressLint("SQLiteString")
    @Override
    public void onCreate(SQLiteDatabase db) {
        // Tạo bảng players
        db.execSQL(CREATE_PLAYERS_TABLE);
        db.execSQL(CREATE_TOUR_TABLE);

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
    public ArrayList<Player> getAllPlayers() {
        ArrayList<Player> playersList = new ArrayList<>();

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
                player.setAvatar(cursor.getString(3));
                player.setFlag(cursor.getString(4));
                player.setRank(cursor.getInt(5));
                player.setWin(cursor.getInt(6));
                player.setLost(cursor.getInt(7));
                playersList.add(player);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return playersList;
    }

    public ArrayList<Type> getAllType() {
        ArrayList<Type> typeArrayList = new ArrayList<>();

        String selectQuery = "SELECT  * FROM " + "Type";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // Duyệt qua tất cả các hàng và thêm vào danh sách
        if (cursor.moveToFirst()) {
            do {
                Type type = new Type();
                type.setId(Integer.parseInt(cursor.getString(0)));
                type.setName(cursor.getString(1));
                String playerJson = cursor.getString(2);
                ArrayList<Player> players = new Gson().fromJson(playerJson, new TypeToken<ArrayList<Player>>() {}.getType());
                type.setPlayers(players);
                typeArrayList.add(type);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return typeArrayList;
    }


    public ArrayList<Tourment> tournament() {
        ArrayList<Tourment> typeArrayList = new ArrayList<>();

        String selectQuery = "SELECT  * FROM " + "tournaments";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // Duyệt qua tất cả các hàng và thêm vào danh sách
        if (cursor.moveToFirst()) {
            do {
                Tourment tourment = new Tourment();
                tourment.setTour_id(Integer.parseInt(cursor.getString(0)));
                tourment.setNameTour(cursor.getString(1));
                tourment.setIpTour(cursor.getString(2));
                tourment.setAvtTour(cursor.getString(3));
                typeArrayList.add(tourment);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return typeArrayList;
    }

    public ArrayList<Round> filterRound(String idTour){

        ArrayList<Round> rounds = new ArrayList<>();
        String selectQuery = "SELECT * FROM rounds WHERE tour_id = ? " ;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, new String[]{idTour});

        // Duyệt qua tất cả các hàng và thêm vào danh sách
        if (cursor.moveToFirst()) {
            do {
                Round round = new Round();
                round.setId(Integer.parseInt(cursor.getString(0)));
                round.setName_round(cursor.getString(1));
                round.setStartDate(cursor.getString(2));
                round.setEndDate(cursor.getString(3));
                rounds.add(round);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return rounds;

    }

    public ArrayList<MatchList> filterMatchList(String idRound){

        ArrayList<MatchList> matchLists = new ArrayList<>();
        String selectQuery = "SELECT * FROM matchlists WHERE round_id = ? " ;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery,new String[]{idRound});

        // Duyệt qua tất cả các hàng và thêm vào danh sách
        if (cursor.moveToFirst()) {
            do {
                MatchList matchList = new MatchList();
                matchList.setMatchlist_id(Integer.parseInt(cursor.getString(0)));
                matchList.setPlayer1_id(Integer.parseInt(cursor.getString(1)));
                matchList.setPlayer2_id(Integer.parseInt(cursor.getString(2)));
                matchList.setFlag1_id(Integer.parseInt(cursor.getString(3)));
                matchList.setFlag2_id(Integer.parseInt(cursor.getString(4)));
                matchList.setResult1(Integer.parseInt(cursor.getString(5)));
                matchList.setResult2(Integer.parseInt(cursor.getString(6)));
                matchLists.add(matchList);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return matchLists;

    }
}
