package pl.adaroz.springboot2.homework7.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DbConfig {

    private DataSource dataSource;

    @Autowired
    public DbConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public JdbcTemplate getJdbcTemplate() {
        return new JdbcTemplate(dataSource);
    }

//    @EventListener(ApplicationReadyEvent.class)
//    public void init() {
//        getJdbcTemplate().update("create table cars (" +
//                "id int auto_increment primary key, " +
//                "make varchar(50), " +
//                "model varchar(50), " +
//                "year int" +
//                ")");
//        getJdbcTemplate().update("insert into cars (make, model, year) " +
//                "values " +
//                "('Volvo', 'XC90', 2019), " +
//                "('Honda', 'CR-V', 2020), " +
//                "('BMW', '6 GT', 2018), " +
//                "('Fiat', 'Bravo', 2017), " +
//                "('Audi', 'Q7', 2015)"
//        );
//    }

}
