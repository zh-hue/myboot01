package com.cdut.zhong.tm.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserordersExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserordersExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andOrdercodeIsNull() {
            addCriterion("ordercode is null");
            return (Criteria) this;
        }

        public Criteria andOrdercodeIsNotNull() {
            addCriterion("ordercode is not null");
            return (Criteria) this;
        }

        public Criteria andOrdercodeEqualTo(String value) {
            addCriterion("ordercode =", value, "ordercode");
            return (Criteria) this;
        }

        public Criteria andOrdercodeNotEqualTo(String value) {
            addCriterion("ordercode <>", value, "ordercode");
            return (Criteria) this;
        }

        public Criteria andOrdercodeGreaterThan(String value) {
            addCriterion("ordercode >", value, "ordercode");
            return (Criteria) this;
        }

        public Criteria andOrdercodeGreaterThanOrEqualTo(String value) {
            addCriterion("ordercode >=", value, "ordercode");
            return (Criteria) this;
        }

        public Criteria andOrdercodeLessThan(String value) {
            addCriterion("ordercode <", value, "ordercode");
            return (Criteria) this;
        }

        public Criteria andOrdercodeLessThanOrEqualTo(String value) {
            addCriterion("ordercode <=", value, "ordercode");
            return (Criteria) this;
        }

        public Criteria andOrdercodeLike(String value) {
            addCriterion("ordercode like", value, "ordercode");
            return (Criteria) this;
        }

        public Criteria andOrdercodeNotLike(String value) {
            addCriterion("ordercode not like", value, "ordercode");
            return (Criteria) this;
        }

        public Criteria andOrdercodeIn(List<String> values) {
            addCriterion("ordercode in", values, "ordercode");
            return (Criteria) this;
        }

        public Criteria andOrdercodeNotIn(List<String> values) {
            addCriterion("ordercode not in", values, "ordercode");
            return (Criteria) this;
        }

        public Criteria andOrdercodeBetween(String value1, String value2) {
            addCriterion("ordercode between", value1, value2, "ordercode");
            return (Criteria) this;
        }

        public Criteria andOrdercodeNotBetween(String value1, String value2) {
            addCriterion("ordercode not between", value1, value2, "ordercode");
            return (Criteria) this;
        }

        public Criteria andGoodsidIsNull() {
            addCriterion("goodsid is null");
            return (Criteria) this;
        }

        public Criteria andGoodsidIsNotNull() {
            addCriterion("goodsid is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsidEqualTo(Integer value) {
            addCriterion("goodsid =", value, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidNotEqualTo(Integer value) {
            addCriterion("goodsid <>", value, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidGreaterThan(Integer value) {
            addCriterion("goodsid >", value, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidGreaterThanOrEqualTo(Integer value) {
            addCriterion("goodsid >=", value, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidLessThan(Integer value) {
            addCriterion("goodsid <", value, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidLessThanOrEqualTo(Integer value) {
            addCriterion("goodsid <=", value, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidIn(List<Integer> values) {
            addCriterion("goodsid in", values, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidNotIn(List<Integer> values) {
            addCriterion("goodsid not in", values, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidBetween(Integer value1, Integer value2) {
            addCriterion("goodsid between", value1, value2, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidNotBetween(Integer value1, Integer value2) {
            addCriterion("goodsid not between", value1, value2, "goodsid");
            return (Criteria) this;
        }

        public Criteria andReceiveaddressIsNull() {
            addCriterion("receiveaddress is null");
            return (Criteria) this;
        }

        public Criteria andReceiveaddressIsNotNull() {
            addCriterion("receiveaddress is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveaddressEqualTo(String value) {
            addCriterion("receiveaddress =", value, "receiveaddress");
            return (Criteria) this;
        }

        public Criteria andReceiveaddressNotEqualTo(String value) {
            addCriterion("receiveaddress <>", value, "receiveaddress");
            return (Criteria) this;
        }

        public Criteria andReceiveaddressGreaterThan(String value) {
            addCriterion("receiveaddress >", value, "receiveaddress");
            return (Criteria) this;
        }

        public Criteria andReceiveaddressGreaterThanOrEqualTo(String value) {
            addCriterion("receiveaddress >=", value, "receiveaddress");
            return (Criteria) this;
        }

        public Criteria andReceiveaddressLessThan(String value) {
            addCriterion("receiveaddress <", value, "receiveaddress");
            return (Criteria) this;
        }

        public Criteria andReceiveaddressLessThanOrEqualTo(String value) {
            addCriterion("receiveaddress <=", value, "receiveaddress");
            return (Criteria) this;
        }

        public Criteria andReceiveaddressLike(String value) {
            addCriterion("receiveaddress like", value, "receiveaddress");
            return (Criteria) this;
        }

        public Criteria andReceiveaddressNotLike(String value) {
            addCriterion("receiveaddress not like", value, "receiveaddress");
            return (Criteria) this;
        }

        public Criteria andReceiveaddressIn(List<String> values) {
            addCriterion("receiveaddress in", values, "receiveaddress");
            return (Criteria) this;
        }

        public Criteria andReceiveaddressNotIn(List<String> values) {
            addCriterion("receiveaddress not in", values, "receiveaddress");
            return (Criteria) this;
        }

        public Criteria andReceiveaddressBetween(String value1, String value2) {
            addCriterion("receiveaddress between", value1, value2, "receiveaddress");
            return (Criteria) this;
        }

        public Criteria andReceiveaddressNotBetween(String value1, String value2) {
            addCriterion("receiveaddress not between", value1, value2, "receiveaddress");
            return (Criteria) this;
        }

        public Criteria andReceiveusermsgIsNull() {
            addCriterion("receiveusermsg is null");
            return (Criteria) this;
        }

        public Criteria andReceiveusermsgIsNotNull() {
            addCriterion("receiveusermsg is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveusermsgEqualTo(String value) {
            addCriterion("receiveusermsg =", value, "receiveusermsg");
            return (Criteria) this;
        }

        public Criteria andReceiveusermsgNotEqualTo(String value) {
            addCriterion("receiveusermsg <>", value, "receiveusermsg");
            return (Criteria) this;
        }

        public Criteria andReceiveusermsgGreaterThan(String value) {
            addCriterion("receiveusermsg >", value, "receiveusermsg");
            return (Criteria) this;
        }

        public Criteria andReceiveusermsgGreaterThanOrEqualTo(String value) {
            addCriterion("receiveusermsg >=", value, "receiveusermsg");
            return (Criteria) this;
        }

        public Criteria andReceiveusermsgLessThan(String value) {
            addCriterion("receiveusermsg <", value, "receiveusermsg");
            return (Criteria) this;
        }

        public Criteria andReceiveusermsgLessThanOrEqualTo(String value) {
            addCriterion("receiveusermsg <=", value, "receiveusermsg");
            return (Criteria) this;
        }

        public Criteria andReceiveusermsgLike(String value) {
            addCriterion("receiveusermsg like", value, "receiveusermsg");
            return (Criteria) this;
        }

        public Criteria andReceiveusermsgNotLike(String value) {
            addCriterion("receiveusermsg not like", value, "receiveusermsg");
            return (Criteria) this;
        }

        public Criteria andReceiveusermsgIn(List<String> values) {
            addCriterion("receiveusermsg in", values, "receiveusermsg");
            return (Criteria) this;
        }

        public Criteria andReceiveusermsgNotIn(List<String> values) {
            addCriterion("receiveusermsg not in", values, "receiveusermsg");
            return (Criteria) this;
        }

        public Criteria andReceiveusermsgBetween(String value1, String value2) {
            addCriterion("receiveusermsg between", value1, value2, "receiveusermsg");
            return (Criteria) this;
        }

        public Criteria andReceiveusermsgNotBetween(String value1, String value2) {
            addCriterion("receiveusermsg not between", value1, value2, "receiveusermsg");
            return (Criteria) this;
        }

        public Criteria andZipcodeIsNull() {
            addCriterion("zipcode is null");
            return (Criteria) this;
        }

        public Criteria andZipcodeIsNotNull() {
            addCriterion("zipcode is not null");
            return (Criteria) this;
        }

        public Criteria andZipcodeEqualTo(String value) {
            addCriterion("zipcode =", value, "zipcode");
            return (Criteria) this;
        }

        public Criteria andZipcodeNotEqualTo(String value) {
            addCriterion("zipcode <>", value, "zipcode");
            return (Criteria) this;
        }

        public Criteria andZipcodeGreaterThan(String value) {
            addCriterion("zipcode >", value, "zipcode");
            return (Criteria) this;
        }

        public Criteria andZipcodeGreaterThanOrEqualTo(String value) {
            addCriterion("zipcode >=", value, "zipcode");
            return (Criteria) this;
        }

        public Criteria andZipcodeLessThan(String value) {
            addCriterion("zipcode <", value, "zipcode");
            return (Criteria) this;
        }

        public Criteria andZipcodeLessThanOrEqualTo(String value) {
            addCriterion("zipcode <=", value, "zipcode");
            return (Criteria) this;
        }

        public Criteria andZipcodeLike(String value) {
            addCriterion("zipcode like", value, "zipcode");
            return (Criteria) this;
        }

        public Criteria andZipcodeNotLike(String value) {
            addCriterion("zipcode not like", value, "zipcode");
            return (Criteria) this;
        }

        public Criteria andZipcodeIn(List<String> values) {
            addCriterion("zipcode in", values, "zipcode");
            return (Criteria) this;
        }

        public Criteria andZipcodeNotIn(List<String> values) {
            addCriterion("zipcode not in", values, "zipcode");
            return (Criteria) this;
        }

        public Criteria andZipcodeBetween(String value1, String value2) {
            addCriterion("zipcode between", value1, value2, "zipcode");
            return (Criteria) this;
        }

        public Criteria andZipcodeNotBetween(String value1, String value2) {
            addCriterion("zipcode not between", value1, value2, "zipcode");
            return (Criteria) this;
        }

        public Criteria andUserphoneIsNull() {
            addCriterion("userphone is null");
            return (Criteria) this;
        }

        public Criteria andUserphoneIsNotNull() {
            addCriterion("userphone is not null");
            return (Criteria) this;
        }

        public Criteria andUserphoneEqualTo(String value) {
            addCriterion("userphone =", value, "userphone");
            return (Criteria) this;
        }

        public Criteria andUserphoneNotEqualTo(String value) {
            addCriterion("userphone <>", value, "userphone");
            return (Criteria) this;
        }

        public Criteria andUserphoneGreaterThan(String value) {
            addCriterion("userphone >", value, "userphone");
            return (Criteria) this;
        }

        public Criteria andUserphoneGreaterThanOrEqualTo(String value) {
            addCriterion("userphone >=", value, "userphone");
            return (Criteria) this;
        }

        public Criteria andUserphoneLessThan(String value) {
            addCriterion("userphone <", value, "userphone");
            return (Criteria) this;
        }

        public Criteria andUserphoneLessThanOrEqualTo(String value) {
            addCriterion("userphone <=", value, "userphone");
            return (Criteria) this;
        }

        public Criteria andUserphoneLike(String value) {
            addCriterion("userphone like", value, "userphone");
            return (Criteria) this;
        }

        public Criteria andUserphoneNotLike(String value) {
            addCriterion("userphone not like", value, "userphone");
            return (Criteria) this;
        }

        public Criteria andUserphoneIn(List<String> values) {
            addCriterion("userphone in", values, "userphone");
            return (Criteria) this;
        }

        public Criteria andUserphoneNotIn(List<String> values) {
            addCriterion("userphone not in", values, "userphone");
            return (Criteria) this;
        }

        public Criteria andUserphoneBetween(String value1, String value2) {
            addCriterion("userphone between", value1, value2, "userphone");
            return (Criteria) this;
        }

        public Criteria andUserphoneNotBetween(String value1, String value2) {
            addCriterion("userphone not between", value1, value2, "userphone");
            return (Criteria) this;
        }

        public Criteria andPlacedateIsNull() {
            addCriterion("placedate is null");
            return (Criteria) this;
        }

        public Criteria andPlacedateIsNotNull() {
            addCriterion("placedate is not null");
            return (Criteria) this;
        }

        public Criteria andPlacedateEqualTo(Date value) {
            addCriterion("placedate =", value, "placedate");
            return (Criteria) this;
        }

        public Criteria andPlacedateNotEqualTo(Date value) {
            addCriterion("placedate <>", value, "placedate");
            return (Criteria) this;
        }

        public Criteria andPlacedateGreaterThan(Date value) {
            addCriterion("placedate >", value, "placedate");
            return (Criteria) this;
        }

        public Criteria andPlacedateGreaterThanOrEqualTo(Date value) {
            addCriterion("placedate >=", value, "placedate");
            return (Criteria) this;
        }

        public Criteria andPlacedateLessThan(Date value) {
            addCriterion("placedate <", value, "placedate");
            return (Criteria) this;
        }

        public Criteria andPlacedateLessThanOrEqualTo(Date value) {
            addCriterion("placedate <=", value, "placedate");
            return (Criteria) this;
        }

        public Criteria andPlacedateIn(List<Date> values) {
            addCriterion("placedate in", values, "placedate");
            return (Criteria) this;
        }

        public Criteria andPlacedateNotIn(List<Date> values) {
            addCriterion("placedate not in", values, "placedate");
            return (Criteria) this;
        }

        public Criteria andPlacedateBetween(Date value1, Date value2) {
            addCriterion("placedate between", value1, value2, "placedate");
            return (Criteria) this;
        }

        public Criteria andPlacedateNotBetween(Date value1, Date value2) {
            addCriterion("placedate not between", value1, value2, "placedate");
            return (Criteria) this;
        }

        public Criteria andDeliverdateIsNull() {
            addCriterion("deliverdate is null");
            return (Criteria) this;
        }

        public Criteria andDeliverdateIsNotNull() {
            addCriterion("deliverdate is not null");
            return (Criteria) this;
        }

        public Criteria andDeliverdateEqualTo(Date value) {
            addCriterion("deliverdate =", value, "deliverdate");
            return (Criteria) this;
        }

        public Criteria andDeliverdateNotEqualTo(Date value) {
            addCriterion("deliverdate <>", value, "deliverdate");
            return (Criteria) this;
        }

        public Criteria andDeliverdateGreaterThan(Date value) {
            addCriterion("deliverdate >", value, "deliverdate");
            return (Criteria) this;
        }

        public Criteria andDeliverdateGreaterThanOrEqualTo(Date value) {
            addCriterion("deliverdate >=", value, "deliverdate");
            return (Criteria) this;
        }

        public Criteria andDeliverdateLessThan(Date value) {
            addCriterion("deliverdate <", value, "deliverdate");
            return (Criteria) this;
        }

        public Criteria andDeliverdateLessThanOrEqualTo(Date value) {
            addCriterion("deliverdate <=", value, "deliverdate");
            return (Criteria) this;
        }

        public Criteria andDeliverdateIn(List<Date> values) {
            addCriterion("deliverdate in", values, "deliverdate");
            return (Criteria) this;
        }

        public Criteria andDeliverdateNotIn(List<Date> values) {
            addCriterion("deliverdate not in", values, "deliverdate");
            return (Criteria) this;
        }

        public Criteria andDeliverdateBetween(Date value1, Date value2) {
            addCriterion("deliverdate between", value1, value2, "deliverdate");
            return (Criteria) this;
        }

        public Criteria andDeliverdateNotBetween(Date value1, Date value2) {
            addCriterion("deliverdate not between", value1, value2, "deliverdate");
            return (Criteria) this;
        }

        public Criteria andPaymentdateIsNull() {
            addCriterion("paymentdate is null");
            return (Criteria) this;
        }

        public Criteria andPaymentdateIsNotNull() {
            addCriterion("paymentdate is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentdateEqualTo(Date value) {
            addCriterion("paymentdate =", value, "paymentdate");
            return (Criteria) this;
        }

        public Criteria andPaymentdateNotEqualTo(Date value) {
            addCriterion("paymentdate <>", value, "paymentdate");
            return (Criteria) this;
        }

        public Criteria andPaymentdateGreaterThan(Date value) {
            addCriterion("paymentdate >", value, "paymentdate");
            return (Criteria) this;
        }

        public Criteria andPaymentdateGreaterThanOrEqualTo(Date value) {
            addCriterion("paymentdate >=", value, "paymentdate");
            return (Criteria) this;
        }

        public Criteria andPaymentdateLessThan(Date value) {
            addCriterion("paymentdate <", value, "paymentdate");
            return (Criteria) this;
        }

        public Criteria andPaymentdateLessThanOrEqualTo(Date value) {
            addCriterion("paymentdate <=", value, "paymentdate");
            return (Criteria) this;
        }

        public Criteria andPaymentdateIn(List<Date> values) {
            addCriterion("paymentdate in", values, "paymentdate");
            return (Criteria) this;
        }

        public Criteria andPaymentdateNotIn(List<Date> values) {
            addCriterion("paymentdate not in", values, "paymentdate");
            return (Criteria) this;
        }

        public Criteria andPaymentdateBetween(Date value1, Date value2) {
            addCriterion("paymentdate between", value1, value2, "paymentdate");
            return (Criteria) this;
        }

        public Criteria andPaymentdateNotBetween(Date value1, Date value2) {
            addCriterion("paymentdate not between", value1, value2, "paymentdate");
            return (Criteria) this;
        }

        public Criteria andReceivingdateIsNull() {
            addCriterion("receivingdate is null");
            return (Criteria) this;
        }

        public Criteria andReceivingdateIsNotNull() {
            addCriterion("receivingdate is not null");
            return (Criteria) this;
        }

        public Criteria andReceivingdateEqualTo(Date value) {
            addCriterion("receivingdate =", value, "receivingdate");
            return (Criteria) this;
        }

        public Criteria andReceivingdateNotEqualTo(Date value) {
            addCriterion("receivingdate <>", value, "receivingdate");
            return (Criteria) this;
        }

        public Criteria andReceivingdateGreaterThan(Date value) {
            addCriterion("receivingdate >", value, "receivingdate");
            return (Criteria) this;
        }

        public Criteria andReceivingdateGreaterThanOrEqualTo(Date value) {
            addCriterion("receivingdate >=", value, "receivingdate");
            return (Criteria) this;
        }

        public Criteria andReceivingdateLessThan(Date value) {
            addCriterion("receivingdate <", value, "receivingdate");
            return (Criteria) this;
        }

        public Criteria andReceivingdateLessThanOrEqualTo(Date value) {
            addCriterion("receivingdate <=", value, "receivingdate");
            return (Criteria) this;
        }

        public Criteria andReceivingdateIn(List<Date> values) {
            addCriterion("receivingdate in", values, "receivingdate");
            return (Criteria) this;
        }

        public Criteria andReceivingdateNotIn(List<Date> values) {
            addCriterion("receivingdate not in", values, "receivingdate");
            return (Criteria) this;
        }

        public Criteria andReceivingdateBetween(Date value1, Date value2) {
            addCriterion("receivingdate between", value1, value2, "receivingdate");
            return (Criteria) this;
        }

        public Criteria andReceivingdateNotBetween(Date value1, Date value2) {
            addCriterion("receivingdate not between", value1, value2, "receivingdate");
            return (Criteria) this;
        }

        public Criteria andOrderstateIsNull() {
            addCriterion("orderstate is null");
            return (Criteria) this;
        }

        public Criteria andOrderstateIsNotNull() {
            addCriterion("orderstate is not null");
            return (Criteria) this;
        }

        public Criteria andOrderstateEqualTo(String value) {
            addCriterion("orderstate =", value, "orderstate");
            return (Criteria) this;
        }

        public Criteria andOrderstateNotEqualTo(String value) {
            addCriterion("orderstate <>", value, "orderstate");
            return (Criteria) this;
        }

        public Criteria andOrderstateGreaterThan(String value) {
            addCriterion("orderstate >", value, "orderstate");
            return (Criteria) this;
        }

        public Criteria andOrderstateGreaterThanOrEqualTo(String value) {
            addCriterion("orderstate >=", value, "orderstate");
            return (Criteria) this;
        }

        public Criteria andOrderstateLessThan(String value) {
            addCriterion("orderstate <", value, "orderstate");
            return (Criteria) this;
        }

        public Criteria andOrderstateLessThanOrEqualTo(String value) {
            addCriterion("orderstate <=", value, "orderstate");
            return (Criteria) this;
        }

        public Criteria andOrderstateLike(String value) {
            addCriterion("orderstate like", value, "orderstate");
            return (Criteria) this;
        }

        public Criteria andOrderstateNotLike(String value) {
            addCriterion("orderstate not like", value, "orderstate");
            return (Criteria) this;
        }

        public Criteria andOrderstateIn(List<String> values) {
            addCriterion("orderstate in", values, "orderstate");
            return (Criteria) this;
        }

        public Criteria andOrderstateNotIn(List<String> values) {
            addCriterion("orderstate not in", values, "orderstate");
            return (Criteria) this;
        }

        public Criteria andOrderstateBetween(String value1, String value2) {
            addCriterion("orderstate between", value1, value2, "orderstate");
            return (Criteria) this;
        }

        public Criteria andOrderstateNotBetween(String value1, String value2) {
            addCriterion("orderstate not between", value1, value2, "orderstate");
            return (Criteria) this;
        }

        public Criteria andUserremarksIsNull() {
            addCriterion("userremarks is null");
            return (Criteria) this;
        }

        public Criteria andUserremarksIsNotNull() {
            addCriterion("userremarks is not null");
            return (Criteria) this;
        }

        public Criteria andUserremarksEqualTo(String value) {
            addCriterion("userremarks =", value, "userremarks");
            return (Criteria) this;
        }

        public Criteria andUserremarksNotEqualTo(String value) {
            addCriterion("userremarks <>", value, "userremarks");
            return (Criteria) this;
        }

        public Criteria andUserremarksGreaterThan(String value) {
            addCriterion("userremarks >", value, "userremarks");
            return (Criteria) this;
        }

        public Criteria andUserremarksGreaterThanOrEqualTo(String value) {
            addCriterion("userremarks >=", value, "userremarks");
            return (Criteria) this;
        }

        public Criteria andUserremarksLessThan(String value) {
            addCriterion("userremarks <", value, "userremarks");
            return (Criteria) this;
        }

        public Criteria andUserremarksLessThanOrEqualTo(String value) {
            addCriterion("userremarks <=", value, "userremarks");
            return (Criteria) this;
        }

        public Criteria andUserremarksLike(String value) {
            addCriterion("userremarks like", value, "userremarks");
            return (Criteria) this;
        }

        public Criteria andUserremarksNotLike(String value) {
            addCriterion("userremarks not like", value, "userremarks");
            return (Criteria) this;
        }

        public Criteria andUserremarksIn(List<String> values) {
            addCriterion("userremarks in", values, "userremarks");
            return (Criteria) this;
        }

        public Criteria andUserremarksNotIn(List<String> values) {
            addCriterion("userremarks not in", values, "userremarks");
            return (Criteria) this;
        }

        public Criteria andUserremarksBetween(String value1, String value2) {
            addCriterion("userremarks between", value1, value2, "userremarks");
            return (Criteria) this;
        }

        public Criteria andUserremarksNotBetween(String value1, String value2) {
            addCriterion("userremarks not between", value1, value2, "userremarks");
            return (Criteria) this;
        }

        public Criteria andGoodsnumIsNull() {
            addCriterion("goodsnum is null");
            return (Criteria) this;
        }

        public Criteria andGoodsnumIsNotNull() {
            addCriterion("goodsnum is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsnumEqualTo(Integer value) {
            addCriterion("goodsnum =", value, "goodsnum");
            return (Criteria) this;
        }

        public Criteria andGoodsnumNotEqualTo(Integer value) {
            addCriterion("goodsnum <>", value, "goodsnum");
            return (Criteria) this;
        }

        public Criteria andGoodsnumGreaterThan(Integer value) {
            addCriterion("goodsnum >", value, "goodsnum");
            return (Criteria) this;
        }

        public Criteria andGoodsnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("goodsnum >=", value, "goodsnum");
            return (Criteria) this;
        }

        public Criteria andGoodsnumLessThan(Integer value) {
            addCriterion("goodsnum <", value, "goodsnum");
            return (Criteria) this;
        }

        public Criteria andGoodsnumLessThanOrEqualTo(Integer value) {
            addCriterion("goodsnum <=", value, "goodsnum");
            return (Criteria) this;
        }

        public Criteria andGoodsnumIn(List<Integer> values) {
            addCriterion("goodsnum in", values, "goodsnum");
            return (Criteria) this;
        }

        public Criteria andGoodsnumNotIn(List<Integer> values) {
            addCriterion("goodsnum not in", values, "goodsnum");
            return (Criteria) this;
        }

        public Criteria andGoodsnumBetween(Integer value1, Integer value2) {
            addCriterion("goodsnum between", value1, value2, "goodsnum");
            return (Criteria) this;
        }

        public Criteria andGoodsnumNotBetween(Integer value1, Integer value2) {
            addCriterion("goodsnum not between", value1, value2, "goodsnum");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}