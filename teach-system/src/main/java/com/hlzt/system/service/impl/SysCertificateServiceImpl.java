package com.hlzt.system.service.impl;

import com.hlzt.common.annotation.DataDictClass;
import com.hlzt.common.utils.DateUtils;
import com.hlzt.system.domain.SysCertificate;
import com.hlzt.system.mapper.SysCertificateMapper;
import com.hlzt.system.service.ISysCertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 资格证信息Service业务层处理
 *
 * @author dengyy
 * @date 2021-04-21
 */
@Service
public class SysCertificateServiceImpl implements ISysCertificateService {
    @Autowired
    private SysCertificateMapper sysCertificateMapper;

    /**
     * 查询资格证信息
     *
     * @param certificateId 资格证信息ID
     * @return 资格证信息
     */
    @DataDictClass
    @Override
    public SysCertificate selectSysCertificateById(Long certificateId) {
        return sysCertificateMapper.selectSysCertificateById(certificateId);
    }

    /**
     * 查询资格证信息列表
     *
     * @param sysCertificate 资格证信息
     * @return 资格证信息
     */
    @DataDictClass
    @Override
    public List<SysCertificate> selectSysCertificateList(SysCertificate sysCertificate) {
        return sysCertificateMapper.selectSysCertificateList(sysCertificate);
    }

    /**
     * 新增资格证信息
     *
     * @param sysCertificate 资格证信息
     * @return 结果
     */
    @Override
    public int insertSysCertificate(SysCertificate sysCertificate) {
        sysCertificate.setCreateTime(DateUtils.getNowDate());
        return sysCertificateMapper.insertSysCertificate(sysCertificate);
    }

    /**
     * 修改资格证信息
     *
     * @param sysCertificate 资格证信息
     * @return 结果
     */
    @Override
    public int updateSysCertificate(SysCertificate sysCertificate) {
        sysCertificate.setUpdateTime(DateUtils.getNowDate());
        return sysCertificateMapper.updateSysCertificate(sysCertificate);
    }

    /**
     * 批量删除资格证信息
     *
     * @param certificateIds 需要删除的资格证信息ID
     * @return 结果
     */
    @Override
    public int deleteSysCertificateByIds(Long[] certificateIds) {
        return sysCertificateMapper.deleteSysCertificateByIds(certificateIds);
    }

    /**
     * 删除资格证信息信息
     *
     * @param certificateId 资格证信息ID
     * @return 结果
     */
    @Override
    public int deleteSysCertificateById(Long certificateId) {
        return sysCertificateMapper.deleteSysCertificateById(certificateId);
    }

    @Override
    public List<SysCertificate> selectSysCertificateByUserId(Long userId) {
        SysCertificate sysCertificate = new SysCertificate();
        sysCertificate.setUserId(userId);
        return this.selectSysCertificateList(sysCertificate);
    }
}
