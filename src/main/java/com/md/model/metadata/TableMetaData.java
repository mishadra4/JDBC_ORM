package com.md.model.metadata;


import java.util.LinkedList;
import java.util.List;

public class TableMetaData {
    private String tableName;
    private String DBName;
    List<ColumnMetaData> columnMetaData = new LinkedList<ColumnMetaData>();
    private List<ForeignKeyMetaData> foreignKeyList = new LinkedList<ForeignKeyMetaData>();

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getDBName() {
        return DBName;
    }

    public void setDBName(String DBName) {
        this.DBName = DBName;
    }

    public List<ColumnMetaData> getColumnMetaData() {
        return columnMetaData;
    }

    public void setColumnMetaData(List<ColumnMetaData> columnMetaData) {
        this.columnMetaData = columnMetaData;
    }

    public List<ForeignKeyMetaData> getForeignKeyList() {
        return foreignKeyList;
    }

    public void setForeignKeyList(List<ForeignKeyMetaData> foreignKeyList) {
        this.foreignKeyList = foreignKeyList;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TABLE: "+tableName+"\n");
        for (ColumnMetaData column : columnMetaData) {
            stringBuilder.append(column+"\n");
        }
        for(ForeignKeyMetaData fk : foreignKeyList){
            stringBuilder.append(fk+"\n");
        }
        return stringBuilder.toString();
    }
}
