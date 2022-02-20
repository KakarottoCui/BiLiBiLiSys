package cilicili.jz2.pojo;

import java.util.ArrayList;
import java.time.ZonedDateTime;
import java.util.List;

public class TokenExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TokenExample() {
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

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andTokenIsNull() {
            addCriterion("token is null");
            return (Criteria) this;
        }

        public Criteria andTokenIsNotNull() {
            addCriterion("token is not null");
            return (Criteria) this;
        }

        public Criteria andTokenEqualTo(String value) {
            addCriterion("token =", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenNotEqualTo(String value) {
            addCriterion("token <>", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenGreaterThan(String value) {
            addCriterion("token >", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenGreaterThanOrEqualTo(String value) {
            addCriterion("token >=", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenLessThan(String value) {
            addCriterion("token <", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenLessThanOrEqualTo(String value) {
            addCriterion("token <=", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenLike(String value) {
            addCriterion("token like", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenNotLike(String value) {
            addCriterion("token not like", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenIn(List<String> values) {
            addCriterion("token in", values, "token");
            return (Criteria) this;
        }

        public Criteria andTokenNotIn(List<String> values) {
            addCriterion("token not in", values, "token");
            return (Criteria) this;
        }

        public Criteria andTokenBetween(String value1, String value2) {
            addCriterion("token between", value1, value2, "token");
            return (Criteria) this;
        }

        public Criteria andTokenNotBetween(String value1, String value2) {
            addCriterion("token not between", value1, value2, "token");
            return (Criteria) this;
        }

        public Criteria andApplytimeIsNull() {
            addCriterion("applytime is null");
            return (Criteria) this;
        }

        public Criteria andApplytimeIsNotNull() {
            addCriterion("applytime is not null");
            return (Criteria) this;
        }

        public Criteria andApplytimeEqualTo(ZonedDateTime value) {
            addCriterion("applytime =", value, "applytime");
            return (Criteria) this;
        }

        public Criteria andApplytimeNotEqualTo(ZonedDateTime value) {
            addCriterion("applytime <>", value, "applytime");
            return (Criteria) this;
        }

        public Criteria andApplytimeGreaterThan(ZonedDateTime value) {
            addCriterion("applytime >", value, "applytime");
            return (Criteria) this;
        }

        public Criteria andApplytimeGreaterThanOrEqualTo(ZonedDateTime value) {
            addCriterion("applytime >=", value, "applytime");
            return (Criteria) this;
        }

        public Criteria andApplytimeLessThan(ZonedDateTime value) {
            addCriterion("applytime <", value, "applytime");
            return (Criteria) this;
        }

        public Criteria andApplytimeLessThanOrEqualTo(ZonedDateTime value) {
            addCriterion("applytime <=", value, "applytime");
            return (Criteria) this;
        }

        public Criteria andApplytimeIn(List<ZonedDateTime> values) {
            addCriterion("applytime in", values, "applytime");
            return (Criteria) this;
        }

        public Criteria andApplytimeNotIn(List<ZonedDateTime> values) {
            addCriterion("applytime not in", values, "applytime");
            return (Criteria) this;
        }

        public Criteria andApplytimeBetween(ZonedDateTime value1, ZonedDateTime value2) {
            addCriterion("applytime between", value1, value2, "applytime");
            return (Criteria) this;
        }

        public Criteria andApplytimeNotBetween(ZonedDateTime value1, ZonedDateTime value2) {
            addCriterion("applytime not between", value1, value2, "applytime");
            return (Criteria) this;
        }

        public Criteria andExpiretimeIsNull() {
            addCriterion("expiretime is null");
            return (Criteria) this;
        }

        public Criteria andExpiretimeIsNotNull() {
            addCriterion("expiretime is not null");
            return (Criteria) this;
        }

        public Criteria andExpiretimeEqualTo(ZonedDateTime value) {
            addCriterion("expiretime =", value, "expiretime");
            return (Criteria) this;
        }

        public Criteria andExpiretimeNotEqualTo(ZonedDateTime value) {
            addCriterion("expiretime <>", value, "expiretime");
            return (Criteria) this;
        }

        public Criteria andExpiretimeGreaterThan(ZonedDateTime value) {
            addCriterion("expiretime >", value, "expiretime");
            return (Criteria) this;
        }

        public Criteria andExpiretimeGreaterThanOrEqualTo(ZonedDateTime value) {
            addCriterion("expiretime >=", value, "expiretime");
            return (Criteria) this;
        }

        public Criteria andExpiretimeLessThan(ZonedDateTime value) {
            addCriterion("expiretime <", value, "expiretime");
            return (Criteria) this;
        }

        public Criteria andExpiretimeLessThanOrEqualTo(ZonedDateTime value) {
            addCriterion("expiretime <=", value, "expiretime");
            return (Criteria) this;
        }

        public Criteria andExpiretimeIn(List<ZonedDateTime> values) {
            addCriterion("expiretime in", values, "expiretime");
            return (Criteria) this;
        }

        public Criteria andExpiretimeNotIn(List<ZonedDateTime> values) {
            addCriterion("expiretime not in", values, "expiretime");
            return (Criteria) this;
        }

        public Criteria andExpiretimeBetween(ZonedDateTime value1, ZonedDateTime value2) {
            addCriterion("expiretime between", value1, value2, "expiretime");
            return (Criteria) this;
        }

        public Criteria andExpiretimeNotBetween(ZonedDateTime value1, ZonedDateTime value2) {
            addCriterion("expiretime not between", value1, value2, "expiretime");
            return (Criteria) this;
        }

        public Criteria andCountAuthIsNull() {
            addCriterion("count_auth is null");
            return (Criteria) this;
        }

        public Criteria andCountAuthIsNotNull() {
            addCriterion("count_auth is not null");
            return (Criteria) this;
        }

        public Criteria andCountAuthEqualTo(Integer value) {
            addCriterion("count_auth =", value, "countAuth");
            return (Criteria) this;
        }

        public Criteria andCountAuthNotEqualTo(Integer value) {
            addCriterion("count_auth <>", value, "countAuth");
            return (Criteria) this;
        }

        public Criteria andCountAuthGreaterThan(Integer value) {
            addCriterion("count_auth >", value, "countAuth");
            return (Criteria) this;
        }

        public Criteria andCountAuthGreaterThanOrEqualTo(Integer value) {
            addCriterion("count_auth >=", value, "countAuth");
            return (Criteria) this;
        }

        public Criteria andCountAuthLessThan(Integer value) {
            addCriterion("count_auth <", value, "countAuth");
            return (Criteria) this;
        }

        public Criteria andCountAuthLessThanOrEqualTo(Integer value) {
            addCriterion("count_auth <=", value, "countAuth");
            return (Criteria) this;
        }

        public Criteria andCountAuthIn(List<Integer> values) {
            addCriterion("count_auth in", values, "countAuth");
            return (Criteria) this;
        }

        public Criteria andCountAuthNotIn(List<Integer> values) {
            addCriterion("count_auth not in", values, "countAuth");
            return (Criteria) this;
        }

        public Criteria andCountAuthBetween(Integer value1, Integer value2) {
            addCriterion("count_auth between", value1, value2, "countAuth");
            return (Criteria) this;
        }

        public Criteria andCountAuthNotBetween(Integer value1, Integer value2) {
            addCriterion("count_auth not between", value1, value2, "countAuth");
            return (Criteria) this;
        }

        public Criteria andMaxCountAuthIsNull() {
            addCriterion("max_count_auth is null");
            return (Criteria) this;
        }

        public Criteria andMaxCountAuthIsNotNull() {
            addCriterion("max_count_auth is not null");
            return (Criteria) this;
        }

        public Criteria andMaxCountAuthEqualTo(Integer value) {
            addCriterion("max_count_auth =", value, "maxCountAuth");
            return (Criteria) this;
        }

        public Criteria andMaxCountAuthNotEqualTo(Integer value) {
            addCriterion("max_count_auth <>", value, "maxCountAuth");
            return (Criteria) this;
        }

        public Criteria andMaxCountAuthGreaterThan(Integer value) {
            addCriterion("max_count_auth >", value, "maxCountAuth");
            return (Criteria) this;
        }

        public Criteria andMaxCountAuthGreaterThanOrEqualTo(Integer value) {
            addCriterion("max_count_auth >=", value, "maxCountAuth");
            return (Criteria) this;
        }

        public Criteria andMaxCountAuthLessThan(Integer value) {
            addCriterion("max_count_auth <", value, "maxCountAuth");
            return (Criteria) this;
        }

        public Criteria andMaxCountAuthLessThanOrEqualTo(Integer value) {
            addCriterion("max_count_auth <=", value, "maxCountAuth");
            return (Criteria) this;
        }

        public Criteria andMaxCountAuthIn(List<Integer> values) {
            addCriterion("max_count_auth in", values, "maxCountAuth");
            return (Criteria) this;
        }

        public Criteria andMaxCountAuthNotIn(List<Integer> values) {
            addCriterion("max_count_auth not in", values, "maxCountAuth");
            return (Criteria) this;
        }

        public Criteria andMaxCountAuthBetween(Integer value1, Integer value2) {
            addCriterion("max_count_auth between", value1, value2, "maxCountAuth");
            return (Criteria) this;
        }

        public Criteria andMaxCountAuthNotBetween(Integer value1, Integer value2) {
            addCriterion("max_count_auth not between", value1, value2, "maxCountAuth");
            return (Criteria) this;
        }

        public Criteria andUssageIsNull() {
            addCriterion("ussage is null");
            return (Criteria) this;
        }

        public Criteria andUssageIsNotNull() {
            addCriterion("ussage is not null");
            return (Criteria) this;
        }

        public Criteria andUssageEqualTo(String value) {
            addCriterion("ussage =", value, "ussage");
            return (Criteria) this;
        }

        public Criteria andUssageNotEqualTo(String value) {
            addCriterion("ussage <>", value, "ussage");
            return (Criteria) this;
        }

        public Criteria andUssageGreaterThan(String value) {
            addCriterion("ussage >", value, "ussage");
            return (Criteria) this;
        }

        public Criteria andUssageGreaterThanOrEqualTo(String value) {
            addCriterion("ussage >=", value, "ussage");
            return (Criteria) this;
        }

        public Criteria andUssageLessThan(String value) {
            addCriterion("ussage <", value, "ussage");
            return (Criteria) this;
        }

        public Criteria andUssageLessThanOrEqualTo(String value) {
            addCriterion("ussage <=", value, "ussage");
            return (Criteria) this;
        }

        public Criteria andUssageLike(String value) {
            addCriterion("ussage like", value, "ussage");
            return (Criteria) this;
        }

        public Criteria andUssageNotLike(String value) {
            addCriterion("ussage not like", value, "ussage");
            return (Criteria) this;
        }

        public Criteria andUssageIn(List<String> values) {
            addCriterion("ussage in", values, "ussage");
            return (Criteria) this;
        }

        public Criteria andUssageNotIn(List<String> values) {
            addCriterion("ussage not in", values, "ussage");
            return (Criteria) this;
        }

        public Criteria andUssageBetween(String value1, String value2) {
            addCriterion("ussage between", value1, value2, "ussage");
            return (Criteria) this;
        }

        public Criteria andUssageNotBetween(String value1, String value2) {
            addCriterion("ussage not between", value1, value2, "ussage");
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