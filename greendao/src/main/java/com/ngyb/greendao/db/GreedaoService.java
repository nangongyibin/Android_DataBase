package com.ngyb.greendao.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;



/**
 * 作者：南宫燚滨
 * 描述:
 * 邮箱：nangongyibin@126.com
 * 时间: 2018/8/18 12:31
 */
public class GreedaoService {
    private DaoMaster daoMaster;
    public DaoSession daoSession;

    public GreedaoService(Context context) {
        // 下面代码仅仅需要执行一次，一般会放在application
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(context, "ngyb.db", null);
        SQLiteDatabase db = helper.getWritableDatabase();
        daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();
    }
}
