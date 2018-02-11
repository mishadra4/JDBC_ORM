package com.md.transformer;


import com.md.model.Annotation.Column;
import com.md.model.Annotation.PrimaryKeyComposite;
import com.md.model.Annotation.Table;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Transformer<T> {
    private final Class<T> tClass;

    public Transformer(Class<T> tClass){
        this.tClass = tClass;
    }

    public Object fromResultSetToEntity(ResultSet resultSet) throws SQLException{
        Object entity = null;
        try {
            entity = tClass.getConstructor().newInstance();
            if (tClass.isAnnotationPresent(Table.class)) {
                Field [] fields = tClass.getDeclaredFields();
                for (Field field : fields){
                    if(field.isAnnotationPresent(Column.class)) {
                        Column column = (Column) field.getAnnotation(Column.class);
                        String name = column.name();
                        int length = column.length();
                        field.setAccessible(true);
                        Class fieldType = field.getType();
                        if (fieldType == String.class){
                            field.set(entity,resultSet.getString(name));
                        } else if (fieldType == Integer.class){
                            field.set(entity,resultSet.getInt(name));
                        } else if (fieldType == Date.class){
                            field.set(entity,resultSet.getDate(name));
                        }
                    } else if(field.isAnnotationPresent(PrimaryKeyComposite.class)){
                        field.setAccessible(true);
                        Class fieldType = field.getType();
                        Object FK=fieldType.getConstructor().newInstance();
                        field.set(entity, FK);
                        Field[] fieldsInner = fieldType.getDeclaredFields();
                        for (Field fieldInner : fieldsInner){
                            if (fieldInner.isAnnotationPresent(Column.class)){
                                Column column = (Column) fieldInner.getAnnotation(Column.class);
                                String name = column.name();
                                int length = column.length();
                                fieldInner.setAccessible(true);
                                Class fieldInnerType = fieldInner.getType();
                                if (fieldInnerType == String.class) {
                                    fieldInner.set(FK, resultSet.getString(name));
                                } else if (fieldInnerType == Integer.class) {
                                    fieldInner.set(FK, resultSet.getInt(name));
                                } else if (fieldInnerType == Date.class) {
                                    fieldInner.set(FK, resultSet.getDate(name));
                                }
                            }
                        }
                    }
                }

            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}
