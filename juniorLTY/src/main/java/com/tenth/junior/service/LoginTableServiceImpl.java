package com.tenth.junior.service;

import com.tenth.junior.bean.LoginTable;
import com.tenth.junior.repository.LoginTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpServletRequest;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
@Service
public class LoginTableServiceImpl implements LoginTableService{
    @Autowired
    private LoginTableRepository loginTableRepository;


    @Override
    public List<LoginTable> getAllLoginTable() {
        return loginTableRepository.findAll();
    }

    @Override//获取当前日志数
    public Integer getLogTanumber(){
        return 1 + loginTableRepository.getLogTaNumber();
    }

    @Override//获取当前时间
    public Date presentTime(){
        Date day=new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        df.format(day);
        return day;
    }

    @Override//获取用户ip地址
    /**
     * @Description: 获取客户端IP地址
     */
    public String getIPAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
            if(ip.equals("127.0.0.1")){
                //根据网卡取本机配置的IP
                InetAddress inet=null;
                try {
                    inet = InetAddress.getLocalHost();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                ip= inet.getHostAddress();
            }
        }
        // 多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
        if(ip != null && ip.length() > 15){
            if(ip.indexOf(",")>0){
                ip = ip.substring(0,ip.indexOf(","));
            }
        }
        return ip;
    }


    @Override
    public LoginTable addLoginTable(LoginTable loginTable) {
        return loginTableRepository.save(loginTable);
    }

    @Override
    public Optional<LoginTable>  findByID(Integer id) {
        return loginTableRepository.findById(id);
    }

    @Override
    public LoginTable updateLoginTable(LoginTable loginTable) {
        return loginTableRepository.save(loginTable);
    }

    @Override
    public  void deleteLoginTable(LoginTable loginTable){
        loginTableRepository.deleteById(loginTable.getLogID());
    }
}

