package com.hlzt.project.service.impl;

import com.hlzt.common.annotation.DataDictClass;
import com.hlzt.common.utils.DateUtils;
import com.hlzt.common.utils.SecurityUtils;
import com.hlzt.common.utils.uuid.IdUtils;
import com.hlzt.project.domain.TFireProduct;
import com.hlzt.project.mapper.TFireProductMapper;
import com.hlzt.project.service.ITFireProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 消防产品管理Service业务层处理
 * 
 * @author slx
 * @date 2021-06-02
 */
@Service
public class TFireProductServiceImpl implements ITFireProductService {
    @Autowired
    private TFireProductMapper tFireProductMapper;

    /**
     * 查询消防产品管理
     * 
     * @param fireProductId 消防产品管理ID
     * @return 消防产品管理
     */
    @Override
    public TFireProduct selectTFireProductById(Long fireProductId)
    {
        return tFireProductMapper.selectTFireProductById(fireProductId);
    }

    /**
     * 查询消防产品管理列表
     * 
     * @param TFireProduct 消防产品管理
     * @return 消防产品管理
     */
    @Override
    @DataDictClass
    public List<TFireProduct> selectTFireProductList(TFireProduct TFireProduct)
    {
        return tFireProductMapper.selectTFireProductList(TFireProduct);
    }

    /**
     * 新增消防产品管理
     * 
     * @param TFireProduct 消防产品管理
     * @return 结果
     */
    @Override
    public int insertTFireProduct(TFireProduct TFireProduct)
    {
        TFireProduct.setCreateBy(SecurityUtils.getUsername());
        TFireProduct.setCreateTime(DateUtils.getNowDate());
         return tFireProductMapper.insertTFireProduct(TFireProduct);
    }

    /**
     * 修改消防产品管理
     * 
     * @param TFireProduct 消防产品管理
     * @return 结果
     */
    @Override
    public int updateTFireProduct(TFireProduct TFireProduct)
    {
                                                                        TFireProduct.setUpdateBy(SecurityUtils.getUsername());
                TFireProduct.setUpdateTime(DateUtils.getNowDate());
                return tFireProductMapper.updateTFireProduct(TFireProduct);
    }

    /**
     * 批量删除消防产品管理
     * 
     * @param fireProductIds 需要删除的消防产品管理ID
     * @return 结果
     */
    @Override
    public int deleteTFireProductByIds(Long[] fireProductIds)
    {
        return tFireProductMapper.deleteTFireProductByIds(fireProductIds);
    }

    /**
     * 删除消防产品管理信息
     * 
     * @param fireProductId 消防产品管理ID
     * @return 结果
     */
    @Override
    public int deleteTFireProductById(Long fireProductId)
    {
        return tFireProductMapper.deleteTFireProductById(fireProductId);
    }

    /**
     * 保存消防设施
     * @param TFireProduct
     */
    @Override
    public void saveTFireProduct(TFireProduct TFireProduct) {
        boolean editFlag = false;
        List<TFireProduct> TFireProductList = tFireProductMapper.selectTFireProductList(
                new TFireProduct()
                        .setManufacturer(TFireProduct.getManufacturer())
                        .setSpecification(TFireProduct.getSpecification())
        );

        for (TFireProduct fireProduct : TFireProductList) {
            if (fireProduct.getManufacturer() != null && fireProduct.getSpecification() != null ) {
                if (fireProduct.getManufacturer().equals(TFireProduct.getManufacturer()) &&
                        fireProduct.getEquipType().equals(TFireProduct.getEquipType()) &&
                        fireProduct.getSpecification().equals(TFireProduct.getSpecification())) {
                    editFlag = true;
                    TFireProduct.setFireProductId(fireProduct.getFireProductId());
                }
            }
        }
        if (!editFlag) {
            TFireProduct.setFireProductId(IdUtils.getNextId());
            if (!"null".equals(TFireProduct.getManufacturer()) && !"null".equals(TFireProduct.getSpecification())) {
                tFireProductMapper.insertTFireProduct(TFireProduct);
            }
        } else {
            if (!"null".equals(TFireProduct.getManufacturer()) && !"null".equals(TFireProduct.getSpecification())) {
                tFireProductMapper.updateTFireProduct(TFireProduct);
            }
        }
    }
}
