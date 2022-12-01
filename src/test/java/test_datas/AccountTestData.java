package test_datas;

import pojos.Account;
import pojos.payloads.AccountPayload;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AccountTestData {
    public static AccountPayload getTestDataForAccountPayload() {
        AccountPayload account = new AccountPayload();
        //account.setId(135531);
        account.setUserId(135531);
        account.setUserName("azaksaban");
        account.setFirstName("Saban");
        account.setLastName("AZAK");
        account.setEmail("azak@saban.com");
        account.setSsn("111-22-333");
        account.setMobilePhoneNumber("226-222-3344");
        account.setAddress("Bilmem nire");
        //account.setCreateDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        return account;
    }

    public static Account getTestDataForAccount(int id,String ssn) {
        Account account = new Account();
        account.setId(id);
        account.setUserId(135531);
        account.setUserName("azaksaban");
        account.setFirstName("Saban");
        account.setLastName("AZAK");
        account.setEmail("azak@saban.com");
        account.setSsn(ssn);
        account.setMobilePhoneNumber("226-222-3344");
        account.setAddress("Bilmem nire");

        return account;
    }

}
