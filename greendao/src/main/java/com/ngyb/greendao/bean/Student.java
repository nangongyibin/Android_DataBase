package com.ngyb.greendao.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToOne;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;
import com.ngyb.greendao.db.DaoSession;
import com.ngyb.greendao.db.PEClazzDao;
import org.greenrobot.greendao.annotation.NotNull;
import com.ngyb.greendao.db.StudentDao;

/**
 * 作者：南宫燚滨
 * 描述：
 * 邮箱：nangongyibin@gmail.com
 * 日期：2019/9/19 15:56
 */
//学生
@Entity
public class Student {

    @Id
    private Long id ;

    private String name ;

    private String number ;

    private long PE_Id ;

    @ToOne(joinProperty = "PE_Id")
    private PEClazz peClazz;

    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    @Generated(hash = 1943931642)
    private transient StudentDao myDao;

    @Generated(hash = 135747135)
    public Student(Long id, String name, String number, long PE_Id) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.PE_Id = PE_Id;
    }

    @Generated(hash = 1556870573)
    public Student() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return this.number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public long getPE_Id() {
        return this.PE_Id;
    }

    public void setPE_Id(long PE_Id) {
        this.PE_Id = PE_Id;
    }

    @Generated(hash = 571811892)
    private transient Long peClazz__resolvedKey;

    /** To-one relationship, resolved on first access. */
    @Generated(hash = 1522923473)
    public PEClazz getPeClazz() {
        long __key = this.PE_Id;
        if (peClazz__resolvedKey == null || !peClazz__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            PEClazzDao targetDao = daoSession.getPEClazzDao();
            PEClazz peClazzNew = targetDao.load(__key);
            synchronized (this) {
                peClazz = peClazzNew;
                peClazz__resolvedKey = __key;
            }
        }
        return peClazz;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1494332490)
    public void setPeClazz(@NotNull PEClazz peClazz) {
        if (peClazz == null) {
            throw new DaoException(
                    "To-one property 'PE_Id' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.peClazz = peClazz;
            PE_Id = peClazz.getId();
            peClazz__resolvedKey = PE_Id;
        }
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1701634981)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getStudentDao() : null;
    }
}
