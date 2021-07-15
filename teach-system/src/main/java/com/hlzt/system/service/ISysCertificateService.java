package com.hlzt.system.service;

import java.util.List;
import com.hlzt.system.domain.SysCertificate;

/**
 * 资格证信息Service接口
 * 
 * @author dengyy
 * @date 2021-04-21
 */
public interface ISysCertificateService 
{
    /**
     * 查询资格证信息
     * 
     * @param certificateId 资格证信息ID
     * @return 资格证信息
     */
    public SysCertificate selectSysCertificateById(Long certificateId);

    /**
     * 查询资格证信息列表
     * 
     * @param sysCertificate 资格证信息
     * @return 资格证信息集合
     */
    public List<SysCertificate> selectSysCertificateList(SysCertificate sysCertificate);

    /**
     * 新增资格证信息
     * 
     * @param sysCertificate 资格证信息
     * @return 结果
     */
    public int insertSysCertificate(SysCertificate sysCertificate);

    /**
     * 修改资格证信息
     * 
     * @param sysCertificate 资格证信息
     * @return 结果
     */
    public int updateSysCertificate(SysCertificate sysCertificate);

    /**
     * 批量删除资格证信息
     * 
     * @param certificateIds 需要删除的资格证信息ID
     * @return 结果
     */
    public int deleteSysCertificateByIds(Long[] certificateIds);

    /**
     * 删除资格证信息信息
     * 
     * @param certificateId 资格证信息ID
     * @return 结果
     */
    public int deleteSysCertificateById(Long certificateId);

    public List<SysCertificate> selectSysCertificateByUserId(Long userId);
}
