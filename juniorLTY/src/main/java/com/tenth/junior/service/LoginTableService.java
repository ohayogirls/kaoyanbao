package com.tenth.junior.service;
import com.tenth.junior.bean.LoginTable;
import org.springframework.data.jpa.repository.Query;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

public interface LoginTableService {
    /**
     * 得到所有的登陆记录
     * @return aimlist
     */
    List<LoginTable> getAllLoginTable();

    /**
     * 增加登录记录
     * @param loginTable
     * @return 增加的记录
     */
    LoginTable addLoginTable(LoginTable loginTable);

    /**
     * 通过id找到登陆记录
     * @param id
     * @return
     */
    Optional<LoginTable> findByID(Integer id);

    /**
     * 修改登陆记录
     * @param loginTable
     * @return
     */
    LoginTable updateLoginTable(LoginTable loginTable);

    /**
     * 删除登陆记录
     * @param loginTable
     */
    void deleteLoginTable(LoginTable loginTable);

    /**
     * 得到数量
     * @return 数量
     */
     Integer getLogTanumber();

    /**
     * 得到当前时间
     * @return 当前时间
     */
     Date presentTime();

    /**
     * 得到ip地址
     * @param request
     * @return ip地址
     */
     String getIPAddr(HttpServletRequest request);
}
