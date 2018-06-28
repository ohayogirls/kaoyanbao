package com.tenth.junior.service;

import com.tenth.junior.bean.LoginTable;
import com.tenth.junior.repository.LoginTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

