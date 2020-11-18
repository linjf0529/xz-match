package com.xz.match.entity;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author chenwf
 * @date 2020/11/18
 */  
public class ReserveSublistExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ReserveSublistExample() {
        oredCriteria = new ArrayList<>();
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
            criteria = new ArrayList<>();
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

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andReserveIdIsNull() {
            addCriterion("reserveId is null");
            return (Criteria) this;
        }

        public Criteria andReserveIdIsNotNull() {
            addCriterion("reserveId is not null");
            return (Criteria) this;
        }

        public Criteria andReserveIdEqualTo(Long value) {
            addCriterion("reserveId =", value, "reserveId");
            return (Criteria) this;
        }

        public Criteria andReserveIdNotEqualTo(Long value) {
            addCriterion("reserveId <>", value, "reserveId");
            return (Criteria) this;
        }

        public Criteria andReserveIdGreaterThan(Long value) {
            addCriterion("reserveId >", value, "reserveId");
            return (Criteria) this;
        }

        public Criteria andReserveIdGreaterThanOrEqualTo(Long value) {
            addCriterion("reserveId >=", value, "reserveId");
            return (Criteria) this;
        }

        public Criteria andReserveIdLessThan(Long value) {
            addCriterion("reserveId <", value, "reserveId");
            return (Criteria) this;
        }

        public Criteria andReserveIdLessThanOrEqualTo(Long value) {
            addCriterion("reserveId <=", value, "reserveId");
            return (Criteria) this;
        }

        public Criteria andReserveIdIn(List<Long> values) {
            addCriterion("reserveId in", values, "reserveId");
            return (Criteria) this;
        }

        public Criteria andReserveIdNotIn(List<Long> values) {
            addCriterion("reserveId not in", values, "reserveId");
            return (Criteria) this;
        }

        public Criteria andReserveIdBetween(Long value1, Long value2) {
            addCriterion("reserveId between", value1, value2, "reserveId");
            return (Criteria) this;
        }

        public Criteria andReserveIdNotBetween(Long value1, Long value2) {
            addCriterion("reserveId not between", value1, value2, "reserveId");
            return (Criteria) this;
        }

        public Criteria andReserveDateIsNull() {
            addCriterion("reserveDate is null");
            return (Criteria) this;
        }

        public Criteria andReserveDateIsNotNull() {
            addCriterion("reserveDate is not null");
            return (Criteria) this;
        }

        public Criteria andReserveDateEqualTo(String value) {
            addCriterion("reserveDate =", value, "reserveDate");
            return (Criteria) this;
        }

        public Criteria andReserveDateNotEqualTo(String value) {
            addCriterion("reserveDate <>", value, "reserveDate");
            return (Criteria) this;
        }

        public Criteria andReserveDateGreaterThan(String value) {
            addCriterion("reserveDate >", value, "reserveDate");
            return (Criteria) this;
        }

        public Criteria andReserveDateGreaterThanOrEqualTo(String value) {
            addCriterion("reserveDate >=", value, "reserveDate");
            return (Criteria) this;
        }

        public Criteria andReserveDateLessThan(String value) {
            addCriterion("reserveDate <", value, "reserveDate");
            return (Criteria) this;
        }

        public Criteria andReserveDateLessThanOrEqualTo(String value) {
            addCriterion("reserveDate <=", value, "reserveDate");
            return (Criteria) this;
        }

        public Criteria andReserveDateLike(String value) {
            addCriterion("reserveDate like", value, "reserveDate");
            return (Criteria) this;
        }

        public Criteria andReserveDateNotLike(String value) {
            addCriterion("reserveDate not like", value, "reserveDate");
            return (Criteria) this;
        }

        public Criteria andReserveDateIn(List<String> values) {
            addCriterion("reserveDate in", values, "reserveDate");
            return (Criteria) this;
        }

        public Criteria andReserveDateNotIn(List<String> values) {
            addCriterion("reserveDate not in", values, "reserveDate");
            return (Criteria) this;
        }

        public Criteria andReserveDateBetween(String value1, String value2) {
            addCriterion("reserveDate between", value1, value2, "reserveDate");
            return (Criteria) this;
        }

        public Criteria andReserveDateNotBetween(String value1, String value2) {
            addCriterion("reserveDate not between", value1, value2, "reserveDate");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNull() {
            addCriterion("startTime is null");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNotNull() {
            addCriterion("startTime is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimeEqualTo(String value) {
            addCriterion("startTime =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(String value) {
            addCriterion("startTime <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(String value) {
            addCriterion("startTime >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(String value) {
            addCriterion("startTime >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(String value) {
            addCriterion("startTime <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(String value) {
            addCriterion("startTime <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLike(String value) {
            addCriterion("startTime like", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotLike(String value) {
            addCriterion("startTime not like", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(List<String> values) {
            addCriterion("startTime in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(List<String> values) {
            addCriterion("startTime not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(String value1, String value2) {
            addCriterion("startTime between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(String value1, String value2) {
            addCriterion("startTime not between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("endTime is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("endTime is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(String value) {
            addCriterion("endTime =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(String value) {
            addCriterion("endTime <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(String value) {
            addCriterion("endTime >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(String value) {
            addCriterion("endTime >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(String value) {
            addCriterion("endTime <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(String value) {
            addCriterion("endTime <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLike(String value) {
            addCriterion("endTime like", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotLike(String value) {
            addCriterion("endTime not like", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<String> values) {
            addCriterion("endTime in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<String> values) {
            addCriterion("endTime not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(String value1, String value2) {
            addCriterion("endTime between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(String value1, String value2) {
            addCriterion("endTime not between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andReserveLimitIsNull() {
            addCriterion("reserveLimit is null");
            return (Criteria) this;
        }

        public Criteria andReserveLimitIsNotNull() {
            addCriterion("reserveLimit is not null");
            return (Criteria) this;
        }

        public Criteria andReserveLimitEqualTo(Integer value) {
            addCriterion("reserveLimit =", value, "reserveLimit");
            return (Criteria) this;
        }

        public Criteria andReserveLimitNotEqualTo(Integer value) {
            addCriterion("reserveLimit <>", value, "reserveLimit");
            return (Criteria) this;
        }

        public Criteria andReserveLimitGreaterThan(Integer value) {
            addCriterion("reserveLimit >", value, "reserveLimit");
            return (Criteria) this;
        }

        public Criteria andReserveLimitGreaterThanOrEqualTo(Integer value) {
            addCriterion("reserveLimit >=", value, "reserveLimit");
            return (Criteria) this;
        }

        public Criteria andReserveLimitLessThan(Integer value) {
            addCriterion("reserveLimit <", value, "reserveLimit");
            return (Criteria) this;
        }

        public Criteria andReserveLimitLessThanOrEqualTo(Integer value) {
            addCriterion("reserveLimit <=", value, "reserveLimit");
            return (Criteria) this;
        }

        public Criteria andReserveLimitIn(List<Integer> values) {
            addCriterion("reserveLimit in", values, "reserveLimit");
            return (Criteria) this;
        }

        public Criteria andReserveLimitNotIn(List<Integer> values) {
            addCriterion("reserveLimit not in", values, "reserveLimit");
            return (Criteria) this;
        }

        public Criteria andReserveLimitBetween(Integer value1, Integer value2) {
            addCriterion("reserveLimit between", value1, value2, "reserveLimit");
            return (Criteria) this;
        }

        public Criteria andReserveLimitNotBetween(Integer value1, Integer value2) {
            addCriterion("reserveLimit not between", value1, value2, "reserveLimit");
            return (Criteria) this;
        }

        public Criteria andReserveNumberIsNull() {
            addCriterion("reserveNumber is null");
            return (Criteria) this;
        }

        public Criteria andReserveNumberIsNotNull() {
            addCriterion("reserveNumber is not null");
            return (Criteria) this;
        }

        public Criteria andReserveNumberEqualTo(Integer value) {
            addCriterion("reserveNumber =", value, "reserveNumber");
            return (Criteria) this;
        }

        public Criteria andReserveNumberNotEqualTo(Integer value) {
            addCriterion("reserveNumber <>", value, "reserveNumber");
            return (Criteria) this;
        }

        public Criteria andReserveNumberGreaterThan(Integer value) {
            addCriterion("reserveNumber >", value, "reserveNumber");
            return (Criteria) this;
        }

        public Criteria andReserveNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("reserveNumber >=", value, "reserveNumber");
            return (Criteria) this;
        }

        public Criteria andReserveNumberLessThan(Integer value) {
            addCriterion("reserveNumber <", value, "reserveNumber");
            return (Criteria) this;
        }

        public Criteria andReserveNumberLessThanOrEqualTo(Integer value) {
            addCriterion("reserveNumber <=", value, "reserveNumber");
            return (Criteria) this;
        }

        public Criteria andReserveNumberIn(List<Integer> values) {
            addCriterion("reserveNumber in", values, "reserveNumber");
            return (Criteria) this;
        }

        public Criteria andReserveNumberNotIn(List<Integer> values) {
            addCriterion("reserveNumber not in", values, "reserveNumber");
            return (Criteria) this;
        }

        public Criteria andReserveNumberBetween(Integer value1, Integer value2) {
            addCriterion("reserveNumber between", value1, value2, "reserveNumber");
            return (Criteria) this;
        }

        public Criteria andReserveNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("reserveNumber not between", value1, value2, "reserveNumber");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIsNull() {
            addCriterion("createdTime is null");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIsNotNull() {
            addCriterion("createdTime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeEqualTo(Long value) {
            addCriterion("createdTime =", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotEqualTo(Long value) {
            addCriterion("createdTime <>", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeGreaterThan(Long value) {
            addCriterion("createdTime >", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("createdTime >=", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeLessThan(Long value) {
            addCriterion("createdTime <", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeLessThanOrEqualTo(Long value) {
            addCriterion("createdTime <=", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIn(List<Long> values) {
            addCriterion("createdTime in", values, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotIn(List<Long> values) {
            addCriterion("createdTime not in", values, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeBetween(Long value1, Long value2) {
            addCriterion("createdTime between", value1, value2, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotBetween(Long value1, Long value2) {
            addCriterion("createdTime not between", value1, value2, "createdTime");
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