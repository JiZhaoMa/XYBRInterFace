package com.ruoyi.domain;

/*
 *
 * @author: majizhao
 * @date: 2024/3/13 10:53
 * @return: null
 * @throws:
 **/
public class InterFaceOrder {
    private String 星源产品编码; // 产品编码
    private String 星源生产PO; // 星源订单号
    private int 下单数量; // 订单数量
    private String 整机组装; //整机组装过站数量
    private String 老化前; //老化前过站数量
    private String 老化; //老化过站数量
    private String 老化后; //老化后过站数量
    private String 入库; //入库数量
    private String 日期;

    public String get星源产品编码() {
        return 星源产品编码;
    }

    public void set星源产品编码(String 星源产品编码) {
        this.星源产品编码 = 星源产品编码;
    }

    public String get星源生产PO() {
        return 星源生产PO;
    }

    public void set星源生产PO(String 星源生产PO) {
        this.星源生产PO = 星源生产PO;
    }

    public int get下单数量() {
        return 下单数量;
    }

    public void set下单数量(int 下单数量) {
        this.下单数量 = 下单数量;
    }

    public String get整机组装() {
        return 整机组装;
    }

    public void set整机组装(String 整机组装) {
        this.整机组装 = 整机组装;
    }

    public String get老化前() {
        return 老化前;
    }

    public void set老化前(String 老化前) {
        this.老化前 = 老化前;
    }

    public String get老化() {
        return 老化;
    }

    public void set老化(String 老化) {
        this.老化 = 老化;
    }

    public String get老化后() {
        return 老化后;
    }

    public void set老化后(String 老化后) {
        this.老化后 = 老化后;
    }

    public String get入库() {
        return 入库;
    }

    public void set入库(String 入库) {
        this.入库 = 入库;
    }

    public String get日期() {
        return 日期;
    }

    public void set日期(String 日期) {
        this.日期 = 日期;
    }
}
