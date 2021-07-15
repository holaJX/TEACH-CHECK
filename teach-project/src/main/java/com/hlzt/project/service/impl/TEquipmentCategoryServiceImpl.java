package com.hlzt.project.service.impl;

import com.hlzt.common.utils.DateUtils;
import com.hlzt.common.utils.SecurityUtils;
import com.hlzt.common.utils.StringUtils;
import com.hlzt.common.utils.TreeUtil;
import com.hlzt.common.utils.uuid.IdUtils;
import com.hlzt.project.domain.TEquipmentCategory;
import com.hlzt.project.mapper.TEquipmentCategoryMapper;
import com.hlzt.project.service.ITEquipmentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 建筑消防设施Service业务层处理
 *
 * @author slx
 * @date 2021-04-27
 */
@Service
public class TEquipmentCategoryServiceImpl implements ITEquipmentCategoryService {
    @Autowired
    private TEquipmentCategoryMapper tEquipmentCategoryMapper;

    /**
     * 查询建筑消防设施
     *
     * @param equipmentId 建筑消防设施ID
     * @return 建筑消防设施
     */
    @Override
    public TEquipmentCategory selectTEquipmentCategoryById(Long equipmentId) {
        return tEquipmentCategoryMapper.selectTEquipmentCategoryById(equipmentId);
    }

    /**
     * 查询建筑消防设施列表
     *
     * @param TEquipmentCategory 建筑消防设施
     * @return 建筑消防设施
     */
    @Override
    public List<TEquipmentCategory> selectTEquipmentCategoryList(TEquipmentCategory TEquipmentCategory) {
        return tEquipmentCategoryMapper.selectTEquipmentCategoryList(TEquipmentCategory);
    }

    @Override
    public List<TEquipmentCategory> buildTEquipmentCategoryTreeSelect(List<TEquipmentCategory> TEquipmentCategorys) {
        return TreeUtil.createTree(TEquipmentCategorys, "equipmentId");
    }

    /**
     * 新增建筑消防设施
     *
     * @param TEquipmentCategory 建筑消防设施
     * @return 结果
     */
    @Override
    public int insertTEquipmentCategory(TEquipmentCategory TEquipmentCategory) {
        TEquipmentCategory.setEquipmentId(IdUtils.getNextId());
        TEquipmentCategory.setCreateBy(SecurityUtils.getUsername());
        TEquipmentCategory.setCreateTime(DateUtils.getNowDate());
        return tEquipmentCategoryMapper.insertTEquipmentCategory(TEquipmentCategory);
    }

    /**
     * 修改建筑消防设施
     *
     * @param TEquipmentCategory 建筑消防设施
     * @return 结果
     */
    @Override
    public int updateTEquipmentCategory(TEquipmentCategory TEquipmentCategory) {
        TEquipmentCategory.setUpdateBy(SecurityUtils.getUsername());
        TEquipmentCategory.setUpdateTime(DateUtils.getNowDate());
        return tEquipmentCategoryMapper.updateTEquipmentCategory(TEquipmentCategory);
    }

    /**
     * 批量删除建筑消防设施
     *
     * @param equipmentIds 需要删除的建筑消防设施ID
     * @return 结果
     */
    @Override
    public int deleteTEquipmentCategoryByIds(Long[] equipmentIds) {
        return tEquipmentCategoryMapper.deleteTEquipmentCategoryByIds(equipmentIds);
    }

    /**
     * 删除建筑消防设施信息
     *
     * @param equipmentId 建筑消防设施ID
     * @return 结果
     */
    @Override
    public int deleteTEquipmentCategoryById(Long equipmentId) {
        return tEquipmentCategoryMapper.deleteTEquipmentCategoryById(equipmentId);
    }

    public List<TEquipmentCategory> buildTree(List<TEquipmentCategory> equipmentCategorys) {
        List<TEquipmentCategory> returnList = new ArrayList<>();
        List<Long> tempList = new ArrayList<Long>();
        for (TEquipmentCategory TStandardCategory : equipmentCategorys) {
            tempList.add(TStandardCategory.getEquipmentId());
        }
        for (TEquipmentCategory TStandardCategory : equipmentCategorys) {
            // 如果是顶级节点, 遍历该父节点的所有子节点
            if (!tempList.contains(TStandardCategory.getParentId())) {
                recursionFn(equipmentCategorys, TStandardCategory);
                returnList.add(TStandardCategory);
            }
        }
        if (returnList.isEmpty()) {
            returnList = equipmentCategorys;
        }
        return returnList;
    }

    /**
     * 递归列表
     */
    private void recursionFn(List<TEquipmentCategory> list, TEquipmentCategory t) {
        // 得到子节点列表
        List<TEquipmentCategory> childList = getChildList(list, t);
        t.setChildren(childList);
        for (TEquipmentCategory tChild : childList) {
            if (hasChild(list, tChild)) {
                recursionFn(list, tChild);
            }
        }
    }

    /**
     * 得到子节点列表
     */
    private List<TEquipmentCategory> getChildList(List<TEquipmentCategory> list, TEquipmentCategory t) {
        List<TEquipmentCategory> tlist = new ArrayList<>();
        for (TEquipmentCategory n : list) {
            if (StringUtils.isNotNull(n.getParentId()) && n.getParentId().longValue() == t.getEquipmentId().longValue()) {
                tlist.add(n);
            }
        }
        return tlist;
    }

    /**
     * 判断是否有子节点
     */
    private boolean hasChild(List<TEquipmentCategory> list, TEquipmentCategory t) {
        return getChildList(list, t).size() > 0 ? true : false;
    }

    @Override
    public List<TEquipmentCategory> selectList(TEquipmentCategory TEquipmentCategory) {
        return tEquipmentCategoryMapper.selectTEquipmentCategoryList(TEquipmentCategory);
    }

}
