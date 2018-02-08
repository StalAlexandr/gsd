package ru.alexandrstal.gsa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.stereotype.Component;
import ru.alexandrstal.gsa.service.NodeService;

import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootApplication
    public class Application {


        public static void main(String[] args) throws SQLException {
            ConfigurableApplicationContext context =  SpringApplication.run(Application.class, args);
            DataSource dataSource = context.getBean(DataSource.class); // <-- here
            Resource resource = new ClassPathResource("init-schema.sql");
            ScriptUtils.executeSqlScript(dataSource.getConnection(), resource);

         //   nodeService.init();
        }

}
