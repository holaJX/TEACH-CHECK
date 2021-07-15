package com.hlzt.project.service;

import com.hlzt.project.domain.TFireProduct;

import java.util.List;

/**
 * 消防产品管理Service接口
 * 
 * @author slx
 * @date 2021-06-02
 */
public interface ITFireProductService {
    /**
     * 查询消防产品管理
     * 
     * @param fireProductId 消防产品管理ID
     * @return 消防产品管理
     */
    public TFireProduct selectTFireProductById(Long fireProductId);

    /**
     * 查询消防产品管理列表
     * 
     * @param TFireProduct 消防产品管理
     * @return 消防产品管理集合
     */
    public List<TFireProduct> selectTFireProductList(TFireProduct TFireProduct);

    /**
     * 新增消防产品管理
     * 
     * @param TFireProduct 消防产品管理
     * @return 结果
     */
    public int insertTFireProduct(TFireProduct TFireProduct);

    /**
     * 修改消防产品管理
     * 
     * @param TFireProduct 消防产品管理
     * @return 结果
     */
    public int updateTFireProduct(TFireProduct TFireProduct);

    /**
     * 批量删除消防产品管理
     * 
     * @param fireProductIds 需要删除的消防产品管理ID
     * @return 结果
     */
    public int deleteTFireProductByIds(Long[] fireProductIds);

    /**
     * 删除消防产品管理信息
     * 
     * @param fireProductId 消防产品管理ID
     * @return 结果
     */
    public int deleteTFireProductById(Long fireProductId);

    /**
     * 保存消防设施
     * @param TFireProduct
     */
    public void saveTFireProduct(TFireProduct TFireProduct);
}
