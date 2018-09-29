package zzu.lab305.lib305.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BookExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BookExample() {
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

        public Criteria andBookIdIsNull() {
            addCriterion("book_id is null");
            return (Criteria) this;
        }

        public Criteria andBookIdIsNotNull() {
            addCriterion("book_id is not null");
            return (Criteria) this;
        }

        public Criteria andBookIdEqualTo(Integer value) {
            addCriterion("book_id =", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdNotEqualTo(Integer value) {
            addCriterion("book_id <>", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdGreaterThan(Integer value) {
            addCriterion("book_id >", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("book_id >=", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdLessThan(Integer value) {
            addCriterion("book_id <", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdLessThanOrEqualTo(Integer value) {
            addCriterion("book_id <=", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdIn(List<Integer> values) {
            addCriterion("book_id in", values, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdNotIn(List<Integer> values) {
            addCriterion("book_id not in", values, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdBetween(Integer value1, Integer value2) {
            addCriterion("book_id between", value1, value2, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdNotBetween(Integer value1, Integer value2) {
            addCriterion("book_id not between", value1, value2, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookNameIsNull() {
            addCriterion("book_name is null");
            return (Criteria) this;
        }

        public Criteria andBookNameIsNotNull() {
            addCriterion("book_name is not null");
            return (Criteria) this;
        }

        public Criteria andBookNameEqualTo(String value) {
            addCriterion("book_name =", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameNotEqualTo(String value) {
            addCriterion("book_name <>", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameGreaterThan(String value) {
            addCriterion("book_name >", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameGreaterThanOrEqualTo(String value) {
            addCriterion("book_name >=", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameLessThan(String value) {
            addCriterion("book_name <", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameLessThanOrEqualTo(String value) {
            addCriterion("book_name <=", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameLike(String value) {
            addCriterion("book_name like", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameNotLike(String value) {
            addCriterion("book_name not like", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameIn(List<String> values) {
            addCriterion("book_name in", values, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameNotIn(List<String> values) {
            addCriterion("book_name not in", values, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameBetween(String value1, String value2) {
            addCriterion("book_name between", value1, value2, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameNotBetween(String value1, String value2) {
            addCriterion("book_name not between", value1, value2, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookCategoryIsNull() {
            addCriterion("book_category is null");
            return (Criteria) this;
        }

        public Criteria andBookCategoryIsNotNull() {
            addCriterion("book_category is not null");
            return (Criteria) this;
        }

        public Criteria andBookCategoryEqualTo(String value) {
            addCriterion("book_category =", value, "bookCategory");
            return (Criteria) this;
        }

        public Criteria andBookCategoryNotEqualTo(String value) {
            addCriterion("book_category <>", value, "bookCategory");
            return (Criteria) this;
        }

        public Criteria andBookCategoryGreaterThan(String value) {
            addCriterion("book_category >", value, "bookCategory");
            return (Criteria) this;
        }

        public Criteria andBookCategoryGreaterThanOrEqualTo(String value) {
            addCriterion("book_category >=", value, "bookCategory");
            return (Criteria) this;
        }

        public Criteria andBookCategoryLessThan(String value) {
            addCriterion("book_category <", value, "bookCategory");
            return (Criteria) this;
        }

        public Criteria andBookCategoryLessThanOrEqualTo(String value) {
            addCriterion("book_category <=", value, "bookCategory");
            return (Criteria) this;
        }

        public Criteria andBookCategoryLike(String value) {
            addCriterion("book_category like", value, "bookCategory");
            return (Criteria) this;
        }

        public Criteria andBookCategoryNotLike(String value) {
            addCriterion("book_category not like", value, "bookCategory");
            return (Criteria) this;
        }

        public Criteria andBookCategoryIn(List<String> values) {
            addCriterion("book_category in", values, "bookCategory");
            return (Criteria) this;
        }

        public Criteria andBookCategoryNotIn(List<String> values) {
            addCriterion("book_category not in", values, "bookCategory");
            return (Criteria) this;
        }

        public Criteria andBookCategoryBetween(String value1, String value2) {
            addCriterion("book_category between", value1, value2, "bookCategory");
            return (Criteria) this;
        }

        public Criteria andBookCategoryNotBetween(String value1, String value2) {
            addCriterion("book_category not between", value1, value2, "bookCategory");
            return (Criteria) this;
        }

        public Criteria andBookStatusIsNull() {
            addCriterion("book_status is null");
            return (Criteria) this;
        }

        public Criteria andBookStatusIsNotNull() {
            addCriterion("book_status is not null");
            return (Criteria) this;
        }

        public Criteria andBookStatusEqualTo(Boolean value) {
            addCriterion("book_status =", value, "bookStatus");
            return (Criteria) this;
        }

        public Criteria andBookStatusNotEqualTo(Boolean value) {
            addCriterion("book_status <>", value, "bookStatus");
            return (Criteria) this;
        }

        public Criteria andBookStatusGreaterThan(Boolean value) {
            addCriterion("book_status >", value, "bookStatus");
            return (Criteria) this;
        }

        public Criteria andBookStatusGreaterThanOrEqualTo(Boolean value) {
            addCriterion("book_status >=", value, "bookStatus");
            return (Criteria) this;
        }

        public Criteria andBookStatusLessThan(Boolean value) {
            addCriterion("book_status <", value, "bookStatus");
            return (Criteria) this;
        }

        public Criteria andBookStatusLessThanOrEqualTo(Boolean value) {
            addCriterion("book_status <=", value, "bookStatus");
            return (Criteria) this;
        }

        public Criteria andBookStatusIn(List<Boolean> values) {
            addCriterion("book_status in", values, "bookStatus");
            return (Criteria) this;
        }

        public Criteria andBookStatusNotIn(List<Boolean> values) {
            addCriterion("book_status not in", values, "bookStatus");
            return (Criteria) this;
        }

        public Criteria andBookStatusBetween(Boolean value1, Boolean value2) {
            addCriterion("book_status between", value1, value2, "bookStatus");
            return (Criteria) this;
        }

        public Criteria andBookStatusNotBetween(Boolean value1, Boolean value2) {
            addCriterion("book_status not between", value1, value2, "bookStatus");
            return (Criteria) this;
        }

        public Criteria andBookUserIsNull() {
            addCriterion("book_user is null");
            return (Criteria) this;
        }

        public Criteria andBookUserIsNotNull() {
            addCriterion("book_user is not null");
            return (Criteria) this;
        }

        public Criteria andBookUserEqualTo(Integer value) {
            addCriterion("book_user =", value, "bookUser");
            return (Criteria) this;
        }

        public Criteria andBookUserNotEqualTo(Integer value) {
            addCriterion("book_user <>", value, "bookUser");
            return (Criteria) this;
        }

        public Criteria andBookUserGreaterThan(Integer value) {
            addCriterion("book_user >", value, "bookUser");
            return (Criteria) this;
        }

        public Criteria andBookUserGreaterThanOrEqualTo(Integer value) {
            addCriterion("book_user >=", value, "bookUser");
            return (Criteria) this;
        }

        public Criteria andBookUserLessThan(Integer value) {
            addCriterion("book_user <", value, "bookUser");
            return (Criteria) this;
        }

        public Criteria andBookUserLessThanOrEqualTo(Integer value) {
            addCriterion("book_user <=", value, "bookUser");
            return (Criteria) this;
        }

        public Criteria andBookUserIn(List<Integer> values) {
            addCriterion("book_user in", values, "bookUser");
            return (Criteria) this;
        }

        public Criteria andBookUserNotIn(List<Integer> values) {
            addCriterion("book_user not in", values, "bookUser");
            return (Criteria) this;
        }

        public Criteria andBookUserBetween(Integer value1, Integer value2) {
            addCriterion("book_user between", value1, value2, "bookUser");
            return (Criteria) this;
        }

        public Criteria andBookUserNotBetween(Integer value1, Integer value2) {
            addCriterion("book_user not between", value1, value2, "bookUser");
            return (Criteria) this;
        }

        public Criteria andBookCodeimgIsNull() {
            addCriterion("book_codeimg is null");
            return (Criteria) this;
        }

        public Criteria andBookCodeimgIsNotNull() {
            addCriterion("book_codeimg is not null");
            return (Criteria) this;
        }

        public Criteria andBookCodeimgEqualTo(String value) {
            addCriterion("book_codeimg =", value, "bookCodeimg");
            return (Criteria) this;
        }

        public Criteria andBookCodeimgNotEqualTo(String value) {
            addCriterion("book_codeimg <>", value, "bookCodeimg");
            return (Criteria) this;
        }

        public Criteria andBookCodeimgGreaterThan(String value) {
            addCriterion("book_codeimg >", value, "bookCodeimg");
            return (Criteria) this;
        }

        public Criteria andBookCodeimgGreaterThanOrEqualTo(String value) {
            addCriterion("book_codeimg >=", value, "bookCodeimg");
            return (Criteria) this;
        }

        public Criteria andBookCodeimgLessThan(String value) {
            addCriterion("book_codeimg <", value, "bookCodeimg");
            return (Criteria) this;
        }

        public Criteria andBookCodeimgLessThanOrEqualTo(String value) {
            addCriterion("book_codeimg <=", value, "bookCodeimg");
            return (Criteria) this;
        }

        public Criteria andBookCodeimgLike(String value) {
            addCriterion("book_codeimg like", value, "bookCodeimg");
            return (Criteria) this;
        }

        public Criteria andBookCodeimgNotLike(String value) {
            addCriterion("book_codeimg not like", value, "bookCodeimg");
            return (Criteria) this;
        }

        public Criteria andBookCodeimgIn(List<String> values) {
            addCriterion("book_codeimg in", values, "bookCodeimg");
            return (Criteria) this;
        }

        public Criteria andBookCodeimgNotIn(List<String> values) {
            addCriterion("book_codeimg not in", values, "bookCodeimg");
            return (Criteria) this;
        }

        public Criteria andBookCodeimgBetween(String value1, String value2) {
            addCriterion("book_codeimg between", value1, value2, "bookCodeimg");
            return (Criteria) this;
        }

        public Criteria andBookCodeimgNotBetween(String value1, String value2) {
            addCriterion("book_codeimg not between", value1, value2, "bookCodeimg");
            return (Criteria) this;
        }

        public Criteria andBookAuthorIsNull() {
            addCriterion("book_author is null");
            return (Criteria) this;
        }

        public Criteria andBookAuthorIsNotNull() {
            addCriterion("book_author is not null");
            return (Criteria) this;
        }

        public Criteria andBookAuthorEqualTo(String value) {
            addCriterion("book_author =", value, "bookAuthor");
            return (Criteria) this;
        }

        public Criteria andBookAuthorNotEqualTo(String value) {
            addCriterion("book_author <>", value, "bookAuthor");
            return (Criteria) this;
        }

        public Criteria andBookAuthorGreaterThan(String value) {
            addCriterion("book_author >", value, "bookAuthor");
            return (Criteria) this;
        }

        public Criteria andBookAuthorGreaterThanOrEqualTo(String value) {
            addCriterion("book_author >=", value, "bookAuthor");
            return (Criteria) this;
        }

        public Criteria andBookAuthorLessThan(String value) {
            addCriterion("book_author <", value, "bookAuthor");
            return (Criteria) this;
        }

        public Criteria andBookAuthorLessThanOrEqualTo(String value) {
            addCriterion("book_author <=", value, "bookAuthor");
            return (Criteria) this;
        }

        public Criteria andBookAuthorLike(String value) {
            addCriterion("book_author like", value, "bookAuthor");
            return (Criteria) this;
        }

        public Criteria andBookAuthorNotLike(String value) {
            addCriterion("book_author not like", value, "bookAuthor");
            return (Criteria) this;
        }

        public Criteria andBookAuthorIn(List<String> values) {
            addCriterion("book_author in", values, "bookAuthor");
            return (Criteria) this;
        }

        public Criteria andBookAuthorNotIn(List<String> values) {
            addCriterion("book_author not in", values, "bookAuthor");
            return (Criteria) this;
        }

        public Criteria andBookAuthorBetween(String value1, String value2) {
            addCriterion("book_author between", value1, value2, "bookAuthor");
            return (Criteria) this;
        }

        public Criteria andBookAuthorNotBetween(String value1, String value2) {
            addCriterion("book_author not between", value1, value2, "bookAuthor");
            return (Criteria) this;
        }

        public Criteria andBookOutTimeIsNull() {
            addCriterion("book_out_time is null");
            return (Criteria) this;
        }

        public Criteria andBookOutTimeIsNotNull() {
            addCriterion("book_out_time is not null");
            return (Criteria) this;
        }

        public Criteria andBookOutTimeEqualTo(Date value) {
            addCriterion("book_out_time =", value, "bookOutTime");
            return (Criteria) this;
        }

        public Criteria andBookOutTimeNotEqualTo(Date value) {
            addCriterion("book_out_time <>", value, "bookOutTime");
            return (Criteria) this;
        }

        public Criteria andBookOutTimeGreaterThan(Date value) {
            addCriterion("book_out_time >", value, "bookOutTime");
            return (Criteria) this;
        }

        public Criteria andBookOutTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("book_out_time >=", value, "bookOutTime");
            return (Criteria) this;
        }

        public Criteria andBookOutTimeLessThan(Date value) {
            addCriterion("book_out_time <", value, "bookOutTime");
            return (Criteria) this;
        }

        public Criteria andBookOutTimeLessThanOrEqualTo(Date value) {
            addCriterion("book_out_time <=", value, "bookOutTime");
            return (Criteria) this;
        }

        public Criteria andBookOutTimeIn(List<Date> values) {
            addCriterion("book_out_time in", values, "bookOutTime");
            return (Criteria) this;
        }

        public Criteria andBookOutTimeNotIn(List<Date> values) {
            addCriterion("book_out_time not in", values, "bookOutTime");
            return (Criteria) this;
        }

        public Criteria andBookOutTimeBetween(Date value1, Date value2) {
            addCriterion("book_out_time between", value1, value2, "bookOutTime");
            return (Criteria) this;
        }

        public Criteria andBookOutTimeNotBetween(Date value1, Date value2) {
            addCriterion("book_out_time not between", value1, value2, "bookOutTime");
            return (Criteria) this;
        }

        public Criteria andBookReTimeIsNull() {
            addCriterion("book_re_time is null");
            return (Criteria) this;
        }

        public Criteria andBookReTimeIsNotNull() {
            addCriterion("book_re_time is not null");
            return (Criteria) this;
        }

        public Criteria andBookReTimeEqualTo(Date value) {
            addCriterion("book_re_time =", value, "bookReTime");
            return (Criteria) this;
        }

        public Criteria andBookReTimeNotEqualTo(Date value) {
            addCriterion("book_re_time <>", value, "bookReTime");
            return (Criteria) this;
        }

        public Criteria andBookReTimeGreaterThan(Date value) {
            addCriterion("book_re_time >", value, "bookReTime");
            return (Criteria) this;
        }

        public Criteria andBookReTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("book_re_time >=", value, "bookReTime");
            return (Criteria) this;
        }

        public Criteria andBookReTimeLessThan(Date value) {
            addCriterion("book_re_time <", value, "bookReTime");
            return (Criteria) this;
        }

        public Criteria andBookReTimeLessThanOrEqualTo(Date value) {
            addCriterion("book_re_time <=", value, "bookReTime");
            return (Criteria) this;
        }

        public Criteria andBookReTimeIn(List<Date> values) {
            addCriterion("book_re_time in", values, "bookReTime");
            return (Criteria) this;
        }

        public Criteria andBookReTimeNotIn(List<Date> values) {
            addCriterion("book_re_time not in", values, "bookReTime");
            return (Criteria) this;
        }

        public Criteria andBookReTimeBetween(Date value1, Date value2) {
            addCriterion("book_re_time between", value1, value2, "bookReTime");
            return (Criteria) this;
        }

        public Criteria andBookReTimeNotBetween(Date value1, Date value2) {
            addCriterion("book_re_time not between", value1, value2, "bookReTime");
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