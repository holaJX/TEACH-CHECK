package com.hlzt.project.mapper;

import java.util.List;

import com.hlzt.project.domain.TCompanyCategory;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;
import com.hlzt.project.domain.TPlaceCategory;

/**
 * 部位类别Mapper接口
 * 
 * @author slx
 * @date 2021-07-02
 */
public interface TPlaceCategoryMapper extends Mapper<TPlaceCategory>{
    /**
     * 查询部位类别
     * 
     * @param placeId 部位类别ID
     * @return 部位类别
     */
    public TPlaceCategory selectTPlaceCategoryById(Long placeId);

    /**
     * 查询部位类别子列表
     * @param placeId
     * @return
     */
    public List<TPlaceCategory> selectChildrenTPlaceCategoryById(Long placeId);

    /**
     * 查询部位类别列表
     * 
     * @param tPlaceCategory 部位类别
     * @return 部位类别集合
     */
    public List<TPlaceCategory> selectTPlaceCategoryList(TPlaceCategory tPlaceCategory);

    /**
     * 新增部位类别
     * 
     * @param tPlaceCategory 部位类别
     * @return 结果
     */
    public int insertTPlaceCategory(TPlaceCategory tPlaceCategory);

    /**
     * 修改部位类别
     * 
     * @param tPlaceCategory 部位类别
     * @return 结果
     */
    public int updateTPlaceCategory(TPlaceCategory tPlaceCategory);

    /**
     * 修改子元素关系
     * @param places
     * @return
     */
    public int updateTPlaceCategoryChildren(@Param("places") List<TPlaceCategory> places);

    /**
     * 删除部位类别
     * 
     * @param placeId 部位类别ID
     * @return 结果
     */
    public int deleteTPlaceCategoryById(Long placeId);

    /**
     * 批量删除部位类别
     * 
     * @param placeIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteTPlaceCategoryByIds(Long[] placeIds);
}
