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

    @Query("select fund_no from chiyouentity order by is_top DESC")
    List<ChiYouTuple> queryAllFundNo();

    @Query("select * from chiyouentity order by is_top DESC")
    List<ChiYouEntity> queryAllFund();

    @Query("select fund_no from chiyouentity where is_top = 1")
    List<String> queryAllTop();

    @Query("update chiyouentity set is_top = 1 where fund_no=:fundNo")
    int changeIsTop(String fundNo);

    @Query("update chiyouentity set is_top = 0 where fund_no=:fundNo")
    int changeNotTop(String fundNo);

    @Query("delete from chiyouentity where fund_no=:fundNo")
    int deleteChiYouInfo(String fundNo);

    @Query("select * from chiyouentity where fund_no = :fundNo")
    ChiYouEntity queryChiYouInfo(String fundNo);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long[] insertFunds(List<ChiYouEntity> entities);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insertFund(ChiYouEntity entity);
}
