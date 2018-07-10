package com.tenth.junior.service;
import com.tenth.junior.bean.User;
import jdk.nashorn.internal.runtime.regexp.joni.constants.StringType;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserService {
    /**
     * 得到所有的user数据
     * @return aimlist
     */
    List<User> getAllUser();

    /**
     * 添加一条user数据
     * @param user 需要添加的数据
     * @return 添加的数据
     */
    User addUser(User user);

    /**
     * 通过主键userid来找user
     * @param userid 目标的id
     * @return 目标数据
     */
    Optional<User> findByID(Integer userid);

    /**
     * 更新数据
     * @param user 更新的数据
     * @return
     */
    User updateUser(User user);

    /**
     * 删除一条user数据
     * @param user
     */
    void deleteUser(User user);

    /**
     * 通过username找到user
     * @param user_name 用户的姓名
     * @return 找到的user
     */
    User findByName(String user_name);


}
