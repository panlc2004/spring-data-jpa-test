package com.plc.springjpa.test.util;

public class HqlQueryHelper extends QueryHelper {
    /**
     * 查询HQL语句
     */
    private StringBuffer hqlBuf = new StringBuffer();


    /**
     * 组装HQL语句
     *
     * @param hql
     */
    public void appendHql(String hql) {
        this.appendHql(hql, null);
    }

    /**
     * 组装SQL语句并加上查询参数
     *
     * @param hql
     * @param param
     */
    public void appendHql(String hql, Object param) {
        hqlBuf.append(hql);
        if (param != null) {
            this.paramList.add(param);
        }
    }

    /**
     * 获取组装HQL
     *
     * @return
     */
    public String getListHql() {
        return this.hqlBuf.toString() + this.getOrderByStr();
    }

    /**
     * 获取组装查询结果数HQL
     *
     * @return
     */
    public String getCountHql() {
        String hql = this.hqlBuf.toString();
        String upperCaseHql = hql.toUpperCase();
        if (upperCaseHql.trim().startsWith("FROM")) {
            hql = "select count(*) " + hql;
        } else {
            int index = upperCaseHql.indexOf("FROM");
            hql = "select count(*) " + hql.substring(index, hql.length());
        }

        return hql;
    }
}
