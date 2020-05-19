package com.fund.strategy.model.db;

import com.fund.strategy.model.db.dao.ChiYouDao;
import com.fund.strategy.model.db.entity.ChiYouEntity;
import com.jingewenku.abrahamcaijin.commonutil.application.AppUtils;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(version = 1, entities = {ChiYouEntity.class})
public abstract class DB extends RoomDatabase {

    private static final String DB_NAME = "my_db";

    private static DB sInstance = null;

    protected DB() {

    }

    public static DB getInstance() {
        if (sInstance == null) {
            synchronized (DB.class) {
                if (sInstance == null) {
                    sInstance = createDatabase();
                }
            }
        }
        return sInstance;
    }

    private static DB createDatabase() {
        return Room.databaseBuilder(AppUtils.getContext(), DB.class, DB_NAME)
                .allowMainThreadQueries()
                .build();
    }

    public abstract ChiYouDao chiyouDao();
}
