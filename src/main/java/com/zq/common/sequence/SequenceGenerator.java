package com.zq.common.sequence;

import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.jdbc.support.incrementer.OracleSequenceMaxValueIncrementer;  
import org.springframework.stereotype.Service;  
  
  
@Service  
public class SequenceGenerator {  
    public static final String USER_INFO_SEQUENCES = "USER_INFO_SEQUENCES";  
    public static final String ACCOUNT_SEQUENCES = "ACCOUNT_SEQUENCES";
    public static final String MENU_SEQUENCES = "MENU_SEQUENCES";
    public static final String DICT_SEQUENCES = "DICT_SEQUENCES";
    @Autowired  
    public OracleSequenceMaxValueIncrementer oracleSequenceMaxValueIncrementer;  
   
    public Integer nextRechargeOrderSeq(String IncrementerName){  
        oracleSequenceMaxValueIncrementer.setIncrementerName(IncrementerName);  
        String currval = oracleSequenceMaxValueIncrementer.nextStringValue();  
        return Integer.parseInt(currval);    
    }  
}
