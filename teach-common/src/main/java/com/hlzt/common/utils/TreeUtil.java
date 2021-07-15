package com.hlzt.common.utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @author hlzt-slx
 */
public class TreeUtil<T> {
    /**
     * 默认ID字段
     */
    private static final String DEFAULT_ID = "id";
    /**
     * 默认内部 parentId字段，必须有parentId字段
     */
    private static final String DEFAULT_PARENT_ID = "parentId";
    /**
     * 默认子级 内部 children 字段，必须有 children 字段
     */
    private static final String DEFAULT_CHILDREN = "children";
    /**
     * 顶级节点的 父级id，必须为 0
     */
    private static final Object TOP_PARENT_ID = 0;

    /**
     * 都采用默认配置 构建树形结构
     *
     * @param list
     * @return
     */
    public static <T> List<T> createTree(List<T> list) {
        return createTree(list, DEFAULT_ID, DEFAULT_PARENT_ID, DEFAULT_CHILDREN);
    }

    /**
     * 只有 实体主键不同 构建树形结构
     *
     * @param list
     * @param idName
     * @return
     */
    public static <T> List<T> createTree(List<T> list, String idName) {
        return createTree(list, idName, DEFAULT_PARENT_ID, DEFAULT_CHILDREN);
    }

    /**
     * 构建树形结构数据
     *
     * @param list      要转换的集合
     * @param idName    实体id字段名
     * @param pIdName   实体父级id字段名
     * @param childName 实体子集集合字段名
     * @return
     */
    public static <T> List<T> createTree(List<T> list, String idName, String pIdName, String childName) {
        List<T> result = new ArrayList<T>();
        List<String> tempList = new ArrayList<>();
        try {
            for (T t : list) {
                Class<?> aClass = t.getClass();
                Field id = aClass.getDeclaredField(idName);
                id.setAccessible(true);
                Object o = id.get(t);
                tempList.add(String.valueOf(o));
                /*if (String.valueOf(o).equals(String.valueOf(TOP_PARENT_ID))) {
                    result.add(t);
                }*/
            }

            for (T t : list) {
                Class<?> aClass = t.getClass();
                Field parentId = aClass.getSuperclass().getDeclaredField(pIdName);
                parentId.setAccessible(true);
                Object o = parentId.get(t);
                // 如果是顶级节点, 遍历该父节点的所有子节点
                if (!tempList.contains(String.valueOf(o))) {
                    recursiveTree(t, list, idName, pIdName, childName);
                    result.add(t);
                }
            }
            if (result.isEmpty()) {
                result = list;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    private static <T> T recursiveTree(T parent, List<T> list, String idName, String pIdName, String childName) throws Exception {
        List<T> children = new ArrayList<T>();
        Class<?> pClass = parent.getClass();
        Field id = pClass.getDeclaredField(idName);
        id.setAccessible(true);
        Object o = id.get(parent);
        for (T t : list) {
            Class<?> aClass = t.getClass();
            Field parentId = aClass.getSuperclass().getDeclaredField(pIdName);
            parentId.setAccessible(true);
            Object o1 = parentId.get(t);
            if (String.valueOf(o).equals(String.valueOf(o1))) {
                t = recursiveTree(t, list, idName, pIdName, childName);
                children.add(t);
            }
        }
        Field child = pClass.getSuperclass().getDeclaredField(childName);
        child.setAccessible(true);
        child.set(parent, children);
        return parent;
    }
}
