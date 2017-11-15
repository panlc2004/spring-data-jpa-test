package com.plc.springjpa.test.util;

import org.hibernate.engine.query.spi.sql.NativeSQLQueryReturn;
import org.hibernate.engine.query.spi.sql.NativeSQLQueryScalarReturn;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.hibernate.type.Type;
import org.hibernate.type.TypeResolver;


public abstract class QueryHelper {

    /**
     * 查询返回值类型列表
     */
    private List<NativeSQLQueryReturn> resultScalarsList = new ArrayList<NativeSQLQueryReturn>();

    /**
     * 查询参数值列表
     */
    protected List<Object> paramList = new ArrayList<Object>();

    /**
     * 排序字段
     */
    private Map<String,String> orderByMap = new LinkedHashMap<String,String>();

    /**
     * 组装返回值类型
     * @param returnPropertyName
     * @param returnType
     */
    public void appendScalar(String returnPropertyName,Type returnType){
        this.resultScalarsList.add(new NativeSQLQueryScalarReturn(returnPropertyName,returnType));
    }

    /**
     * 获取参数类型数组
     * @return
     */
    public Type[] getParamTypes() {
        Type[] paramType = null;
        if(paramList.size() > 0){
            paramType = new Type[paramList.size()];
            for(int i=0;i<paramList.size();i++){
                paramType[i] = new TypeResolver().heuristicType(paramList.get(i).getClass().getName());
            }
        }
        return paramType;
    }

    /**
     * 获取参数值数组
     * @return
     */
    public Object[] getParamValues() {
        return this.paramList.toArray();
    }

    /**
     * 获取返回值类型集合
     * @return
     */
    public List<NativeSQLQueryReturn> getReturnList(){
        return this.resultScalarsList;
    }

    /**
     * 排序列表
     * @param columnName
     * @param ascOrDesc
     */
    public void appendOrderBy(String columnName,String ascOrDesc){
        orderByMap.put(columnName,ascOrDesc);
    }

    /**
     * 获取排序字段字符串
     * @return
     */
    protected String getOrderByStr(){
        StringBuffer orderByBuf = new StringBuffer();
        for(Map.Entry<String,String> entry:orderByMap.entrySet()){

            if(orderByBuf.length()>0){
                orderByBuf.append(",");
            }

            orderByBuf.append(entry.getKey());
            if(entry.getValue() != null && entry.getValue().length()>0){
                orderByBuf.append(" " + entry.getValue());
            }
        }

        if(orderByBuf.length()>0){
            return " ORDER BY " + orderByBuf.toString();
        }
        else{
            return "";
        }
    }

}
