package com.tenth.junior.service;
import com.tenth.junior.bean.LoginTable;
import org.springframework.data.jpa.repository.Query;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

public interface LoginTableService {
    List<LoginTable> getAllLoginTable();

    LoginTable addLoginTable(LoginTable loginTable);

   //LoginTable addLoginTable(LoginTable loginTable);

    Optional<LoginTable> findByID(Integer id);

    LoginTable updateLoginTable(LoginTable loginTable);

    void deleteLoginTable(LoginTable loginTable);

    public Integer getLogTanumber();

    public Date presentTime();

    public String getIPAddr(HttpServletRequest request);
}
