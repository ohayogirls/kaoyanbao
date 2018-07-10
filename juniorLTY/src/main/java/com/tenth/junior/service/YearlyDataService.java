package com.tenth.junior.service;

import com.tenth.junior.bean.YearlyData;
import com.tenth.junior.bean.YearlyDataPK;

import java.util.List;
import java.util.Optional;

public interface YearlyDataService {
    /**
     * 得到全部的历年数据
     * @return 目标list
     */
    List<YearlyData> findAllYearlyData();

    /**
     * 添加一条历年数据
     * @param yearlyData 要添加的数据
     * @return 目标
     */
    YearlyData addYearlyData(YearlyData yearlyData);

    /**
     * 更新一条历年数据
     * @param yearlyData 更新的数据
     * @return 目标
     */
    YearlyData updateYearlyData(YearlyData yearlyData);

    /**
     * 通过主键找到一条历年数据
     * @param pk 联合主键
     * @return 找到的历年数据
     */
    Optional<YearlyData> findByID(YearlyDataPK pk);

    /**
     * 通过主键删除一条历年数据
     * @param pk 联合主键
     */
    void deleteYearlyData(YearlyDataPK pk);

    /**
     * 通过学校的id找历年数据
     * @param id 学校id
     * @return 找到的数据的list
     */
    List<YearlyData> findBySchoolID(Integer id);
}
