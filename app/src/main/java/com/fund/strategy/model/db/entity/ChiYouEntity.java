package com.fund.strategy.model.db.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class ChiYouEntity {

    public static final int IS_TOP = 1;

    @PrimaryKey
    @ColumnInfo(name = "fund_no")
    @NonNull
    public String fundNo;

    @ColumnInfo(name = "fund_name")
    public String fundName;

    @ColumnInfo(name = "fund_type", defaultValue = "1")
    public int fundType;

    @ColumnInfo(name = "is_top", defaultValue = "0")
    public int isTop;
}
