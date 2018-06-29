package com.org.springboot.model.db;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Setter
@Getter
@ToString
public class WashProductInfoDO {

    private Long id;

    private String memberId;

    private Date memberTransDate;

    private String terminalId;

    private String productId;

    private String functionId;

    private String memberOrderId;

    private String industryType;

    private String idHolder;

    private String idCardNo;

    private String idCardType;

    private String cntMember;

    private String loanTime;

    private String overdueDay;

    private String overdueAmt;

    private Integer cnt1;

    private Integer cnt0;

    private String cumDefaultDays;

    private String tag;

    private String tradeNo;

    private String isFee;

    private String code;

    private String message;

    private String transId;

    private Integer queryTime;

    private String result;

    private String errormsg;

    private String mark;

    private Date startDay;

    private Date lastDay;

    private String maxMoney;

    private Integer cntBadMember;

    private Integer cntGoodMember;

    private Integer abnormal;

    private String active;

    private Date createTime;

    private Date updateTime;

    private Date firstDay;

    private String maxDays;

    private String tagDesc;
}