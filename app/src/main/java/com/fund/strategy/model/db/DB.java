package com.fund.strategy.model.db;

import com.fund.strategy.model.db.dao.ChiYouDao;
import com.fund.strategy.model.db.entity.ChiYouEntity;
import com.jingewenku.abrahamcaijin.commonutil.application.AppUtils;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(version = 2, entities = {ChiYouEntity.class})
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
                .addMigrations(MIGRATION_1_2)
                .allowMainThreadQueries()
                .build();
    }

    private static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            database.execSQL("ALTER TABLE `ChiYouEntity` ADD COLUMN `is_top` INTEGER NOT NULL DEFAULT 0");
        }
    };

    public abstract ChiYouDao chiyouDao();
}
