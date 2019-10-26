package com.ngyb.greendao.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 作者：南宫燚滨
 * 描述：
 * 邮箱：nangongyibin@gmail.com
 * 日期：2019/9/19 15:56
 */
//体育课
@Entity
public class PEClazz {

    @Id
    private Long id;

    private int credit;

    private String name;

    @Generated(hash = 532639763)
    public PEClazz(Long id, int credit, String name) {
        this.id = id;
        this.credit = credit;
        this.name = name;
    }

    @Generated(hash = 1506391997)
    public PEClazz() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCredit() {
        return this.credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
