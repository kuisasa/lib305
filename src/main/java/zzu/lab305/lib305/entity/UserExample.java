package zzu.lab305.lib305.entity;

import java.util.ArrayList;
import java.util.List;

public class UserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserExample() {
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

        public Criteria andUserSnumIsNull() {
            addCriterion("user_snum is null");
            return (Criteria) this;
        }

        public Criteria andUserSnumIsNotNull() {
            addCriterion("user_snum is not null");
            return (Criteria) this;
        }

        public Criteria andUserSnumEqualTo(String value) {
            addCriterion("user_snum =", value, "userSnum");
            return (Criteria) this;
        }

        public Criteria andUserSnumNotEqualTo(String value) {
            addCriterion("user_snum <>", value, "userSnum");
            return (Criteria) this;
        }

        public Criteria andUserSnumGreaterThan(String value) {
            addCriterion("user_snum >", value, "userSnum");
            return (Criteria) this;
        }

        public Criteria andUserSnumGreaterThanOrEqualTo(String value) {
            addCriterion("user_snum >=", value, "userSnum");
            return (Criteria) this;
        }

        public Criteria andUserSnumLessThan(String value) {
            addCriterion("user_snum <", value, "userSnum");
            return (Criteria) this;
        }

        public Criteria andUserSnumLessThanOrEqualTo(String value) {
            addCriterion("user_snum <=", value, "userSnum");
            return (Criteria) this;
        }

        public Criteria andUserSnumLike(String value) {
            addCriterion("user_snum like", value, "userSnum");
            return (Criteria) this;
        }

        public Criteria andUserSnumNotLike(String value) {
            addCriterion("user_snum not like", value, "userSnum");
            return (Criteria) this;
        }

        public Criteria andUserSnumIn(List<String> values) {
            addCriterion("user_snum in", values, "userSnum");
            return (Criteria) this;
        }

        public Criteria andUserSnumNotIn(List<String> values) {
            addCriterion("user_snum not in", values, "userSnum");
            return (Criteria) this;
        }

        public Criteria andUserSnumBetween(String value1, String value2) {
            addCriterion("user_snum between", value1, value2, "userSnum");
            return (Criteria) this;
        }

        public Criteria andUserSnumNotBetween(String value1, String value2) {
            addCriterion("user_snum not between", value1, value2, "userSnum");
            return (Criteria) this;
        }

        public Criteria andUserPasswordIsNull() {
            addCriterion("user_password is null");
            return (Criteria) this;
        }

        public Criteria andUserPasswordIsNotNull() {
            addCriterion("user_password is not null");
            return (Criteria) this;
        }

        public Criteria andUserPasswordEqualTo(String value) {
            addCriterion("user_password =", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordNotEqualTo(String value) {
            addCriterion("user_password <>", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordGreaterThan(String value) {
            addCriterion("user_password >", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("user_password >=", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordLessThan(String value) {
            addCriterion("user_password <", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordLessThanOrEqualTo(String value) {
            addCriterion("user_password <=", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordLike(String value) {
            addCriterion("user_password like", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordNotLike(String value) {
            addCriterion("user_password not like", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordIn(List<String> values) {
            addCriterion("user_password in", values, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordNotIn(List<String> values) {
            addCriterion("user_password not in", values, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordBetween(String value1, String value2) {
            addCriterion("user_password between", value1, value2, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordNotBetween(String value1, String value2) {
            addCriterion("user_password not between", value1, value2, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserGroupIsNull() {
            addCriterion("user_group is null");
            return (Criteria) this;
        }

        public Criteria andUserGroupIsNotNull() {
            addCriterion("user_group is not null");
            return (Criteria) this;
        }

        public Criteria andUserGroupEqualTo(String value) {
            addCriterion("user_group =", value, "userGroup");
            return (Criteria) this;
        }

        public Criteria andUserGroupNotEqualTo(String value) {
            addCriterion("user_group <>", value, "userGroup");
            return (Criteria) this;
        }

        public Criteria andUserGroupGreaterThan(String value) {
            addCriterion("user_group >", value, "userGroup");
            return (Criteria) this;
        }

        public Criteria andUserGroupGreaterThanOrEqualTo(String value) {
            addCriterion("user_group >=", value, "userGroup");
            return (Criteria) this;
        }

        public Criteria andUserGroupLessThan(String value) {
            addCriterion("user_group <", value, "userGroup");
            return (Criteria) this;
        }

        public Criteria andUserGroupLessThanOrEqualTo(String value) {
            addCriterion("user_group <=", value, "userGroup");
            return (Criteria) this;
        }

        public Criteria andUserGroupLike(String value) {
            addCriterion("user_group like", value, "userGroup");
            return (Criteria) this;
        }

        public Criteria andUserGroupNotLike(String value) {
            addCriterion("user_group not like", value, "userGroup");
            return (Criteria) this;
        }

        public Criteria andUserGroupIn(List<String> values) {
            addCriterion("user_group in", values, "userGroup");
            return (Criteria) this;
        }

        public Criteria andUserGroupNotIn(List<String> values) {
            addCriterion("user_group not in", values, "userGroup");
            return (Criteria) this;
        }

        public Criteria andUserGroupBetween(String value1, String value2) {
            addCriterion("user_group between", value1, value2, "userGroup");
            return (Criteria) this;
        }

        public Criteria andUserGroupNotBetween(String value1, String value2) {
            addCriterion("user_group not between", value1, value2, "userGroup");
            return (Criteria) this;
        }

        public Criteria andUserSpecIsNull() {
            addCriterion("user_spec is null");
            return (Criteria) this;
        }

        public Criteria andUserSpecIsNotNull() {
            addCriterion("user_spec is not null");
            return (Criteria) this;
        }

        public Criteria andUserSpecEqualTo(String value) {
            addCriterion("user_spec =", value, "userSpec");
            return (Criteria) this;
        }

        public Criteria andUserSpecNotEqualTo(String value) {
            addCriterion("user_spec <>", value, "userSpec");
            return (Criteria) this;
        }

        public Criteria andUserSpecGreaterThan(String value) {
            addCriterion("user_spec >", value, "userSpec");
            return (Criteria) this;
        }

        public Criteria andUserSpecGreaterThanOrEqualTo(String value) {
            addCriterion("user_spec >=", value, "userSpec");
            return (Criteria) this;
        }

        public Criteria andUserSpecLessThan(String value) {
            addCriterion("user_spec <", value, "userSpec");
            return (Criteria) this;
        }

        public Criteria andUserSpecLessThanOrEqualTo(String value) {
            addCriterion("user_spec <=", value, "userSpec");
            return (Criteria) this;
        }

        public Criteria andUserSpecLike(String value) {
            addCriterion("user_spec like", value, "userSpec");
            return (Criteria) this;
        }

        public Criteria andUserSpecNotLike(String value) {
            addCriterion("user_spec not like", value, "userSpec");
            return (Criteria) this;
        }

        public Criteria andUserSpecIn(List<String> values) {
            addCriterion("user_spec in", values, "userSpec");
            return (Criteria) this;
        }

        public Criteria andUserSpecNotIn(List<String> values) {
            addCriterion("user_spec not in", values, "userSpec");
            return (Criteria) this;
        }

        public Criteria andUserSpecBetween(String value1, String value2) {
            addCriterion("user_spec between", value1, value2, "userSpec");
            return (Criteria) this;
        }

        public Criteria andUserSpecNotBetween(String value1, String value2) {
            addCriterion("user_spec not between", value1, value2, "userSpec");
            return (Criteria) this;
        }

        public Criteria andUserStatusIsNull() {
            addCriterion("user_status is null");
            return (Criteria) this;
        }

        public Criteria andUserStatusIsNotNull() {
            addCriterion("user_status is not null");
            return (Criteria) this;
        }

        public Criteria andUserStatusEqualTo(Boolean value) {
            addCriterion("user_status =", value, "userStatus");
            return (Criteria) this;
        }

        public Criteria andUserStatusNotEqualTo(Boolean value) {
            addCriterion("user_status <>", value, "userStatus");
            return (Criteria) this;
        }

        public Criteria andUserStatusGreaterThan(Boolean value) {
            addCriterion("user_status >", value, "userStatus");
            return (Criteria) this;
        }

        public Criteria andUserStatusGreaterThanOrEqualTo(Boolean value) {
            addCriterion("user_status >=", value, "userStatus");
            return (Criteria) this;
        }

        public Criteria andUserStatusLessThan(Boolean value) {
            addCriterion("user_status <", value, "userStatus");
            return (Criteria) this;
        }

        public Criteria andUserStatusLessThanOrEqualTo(Boolean value) {
            addCriterion("user_status <=", value, "userStatus");
            return (Criteria) this;
        }

        public Criteria andUserStatusIn(List<Boolean> values) {
            addCriterion("user_status in", values, "userStatus");
            return (Criteria) this;
        }

        public Criteria andUserStatusNotIn(List<Boolean> values) {
            addCriterion("user_status not in", values, "userStatus");
            return (Criteria) this;
        }

        public Criteria andUserStatusBetween(Boolean value1, Boolean value2) {
            addCriterion("user_status between", value1, value2, "userStatus");
            return (Criteria) this;
        }

        public Criteria andUserStatusNotBetween(Boolean value1, Boolean value2) {
            addCriterion("user_status not between", value1, value2, "userStatus");
            return (Criteria) this;
        }

        public Criteria andUserRoleIsNull() {
            addCriterion("user_role is null");
            return (Criteria) this;
        }

        public Criteria andUserRoleIsNotNull() {
            addCriterion("user_role is not null");
            return (Criteria) this;
        }

        public Criteria andUserRoleEqualTo(String value) {
            addCriterion("user_role =", value, "userRole");
            return (Criteria) this;
        }

        public Criteria andUserRoleNotEqualTo(String value) {
            addCriterion("user_role <>", value, "userRole");
            return (Criteria) this;
        }

        public Criteria andUserRoleGreaterThan(String value) {
            addCriterion("user_role >", value, "userRole");
            return (Criteria) this;
        }

        public Criteria andUserRoleGreaterThanOrEqualTo(String value) {
            addCriterion("user_role >=", value, "userRole");
            return (Criteria) this;
        }

        public Criteria andUserRoleLessThan(String value) {
            addCriterion("user_role <", value, "userRole");
            return (Criteria) this;
        }

        public Criteria andUserRoleLessThanOrEqualTo(String value) {
            addCriterion("user_role <=", value, "userRole");
            return (Criteria) this;
        }

        public Criteria andUserRoleLike(String value) {
            addCriterion("user_role like", value, "userRole");
            return (Criteria) this;
        }

        public Criteria andUserRoleNotLike(String value) {
            addCriterion("user_role not like", value, "userRole");
            return (Criteria) this;
        }

        public Criteria andUserRoleIn(List<String> values) {
            addCriterion("user_role in", values, "userRole");
            return (Criteria) this;
        }

        public Criteria andUserRoleNotIn(List<String> values) {
            addCriterion("user_role not in", values, "userRole");
            return (Criteria) this;
        }

        public Criteria andUserRoleBetween(String value1, String value2) {
            addCriterion("user_role between", value1, value2, "userRole");
            return (Criteria) this;
        }

        public Criteria andUserRoleNotBetween(String value1, String value2) {
            addCriterion("user_role not between", value1, value2, "userRole");
            return (Criteria) this;
        }

        public Criteria andUserBooksIsNull() {
            addCriterion("user_books is null");
            return (Criteria) this;
        }

        public Criteria andUserBooksIsNotNull() {
            addCriterion("user_books is not null");
            return (Criteria) this;
        }

        public Criteria andUserBooksEqualTo(String value) {
            addCriterion("user_books =", value, "userBooks");
            return (Criteria) this;
        }

        public Criteria andUserBooksNotEqualTo(String value) {
            addCriterion("user_books <>", value, "userBooks");
            return (Criteria) this;
        }

        public Criteria andUserBooksGreaterThan(String value) {
            addCriterion("user_books >", value, "userBooks");
            return (Criteria) this;
        }

        public Criteria andUserBooksGreaterThanOrEqualTo(String value) {
            addCriterion("user_books >=", value, "userBooks");
            return (Criteria) this;
        }

        public Criteria andUserBooksLessThan(String value) {
            addCriterion("user_books <", value, "userBooks");
            return (Criteria) this;
        }

        public Criteria andUserBooksLessThanOrEqualTo(String value) {
            addCriterion("user_books <=", value, "userBooks");
            return (Criteria) this;
        }

        public Criteria andUserBooksLike(String value) {
            addCriterion("user_books like", value, "userBooks");
            return (Criteria) this;
        }

        public Criteria andUserBooksNotLike(String value) {
            addCriterion("user_books not like", value, "userBooks");
            return (Criteria) this;
        }

        public Criteria andUserBooksIn(List<String> values) {
            addCriterion("user_books in", values, "userBooks");
            return (Criteria) this;
        }

        public Criteria andUserBooksNotIn(List<String> values) {
            addCriterion("user_books not in", values, "userBooks");
            return (Criteria) this;
        }

        public Criteria andUserBooksBetween(String value1, String value2) {
            addCriterion("user_books between", value1, value2, "userBooks");
            return (Criteria) this;
        }

        public Criteria andUserBooksNotBetween(String value1, String value2) {
            addCriterion("user_books not between", value1, value2, "userBooks");
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