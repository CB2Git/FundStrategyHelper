package com.fund.strategy.model.db.dao;

import com.fund.strategy.model.db.entity.ChiYouEntity;
import com.fund.strategy.model.db.entity.ChiYouTuple;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface ChiYouDao {

    @Query("select fund_no from chiyouentity")
    List<ChiYouTuple> queryAllFundNo();

    @Query("select * from chiyouentity")
    List<ChiYouEntity> queryAllFund();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long[] insertFunds(List<ChiYouEntity> entities);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insertFund(ChiYouEntity entity);
}
