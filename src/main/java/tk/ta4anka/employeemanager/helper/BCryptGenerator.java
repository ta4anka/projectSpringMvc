package tk.ta4anka.employeemanager.helper;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

// Creating the passwords for initial populating our table 'users':  TODO: ==>  DELETE
public class BCryptGenerator {
    public static void main(String[] args) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        for(int i=1 ;i<4; i++){
            System.out.println(bCryptPasswordEncoder.encode("root" + i));
        }
    }
}


