package com.tenth.junior.service;

import com.tenth.junior.bean.Material;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public interface MaterialService {
    /**
     * 得到所有的资料数据
     * @return aimlist
     */
    List<Material> getAllMaterial();

    /**
     * 添加资料
     * @param material
     * @return
     */
    Material addMaterial(Material material);

    /**
     * 通过id找到对应的资料
     * @param ID
     * @return
     */
    Optional<Material> findByID(Integer ID);

    /**
     * 修改资料
     * @param material
     * @return
     */
    Material UpdateMaterial(Material material);

    /**
     * 删除id对应的资料
     * @param material
     */
    void deleteMaterial(Material material);

    /**
     * 得到所有资料
     * @return aimlist
     */
    List<Material> getAllMat();

    /**
     * 通过类型找资料
     * @param type
     * @return
     */
    List<Material> queryByMaterialType(String type);

    /**
     *
     * @param aimList
     * @param category
     * @return aimlist
     */
    List<Material> findByCategory(List<Material> aimList,String category);

    /**
     * 通过类型找资料
     * @param aimList
     * @param type
     * @return aimlist
     */
    List<Material> findByType(List<Material> aimList,String type);

}
