package hu.bandur.mvc.config;


import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.hibernate.dialect.HSQLDialect;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = "hu.bandur.mvc")
@EnableJpaRepositories(basePackages = {"hu.bandur.mvc.domain.repository","hu.bandur.mvc.dao"})
@EnableTransactionManagement
public class RootApplicationContextConfig {

   @Bean
   public DataSource dataSource() {
      EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
      EmbeddedDatabase db = builder
         .setType(EmbeddedDatabaseType.HSQL)
         .addScript("db/sql/create-table.sql")
         .addScript("db/sql/insert-data.sql")
         .build();
      return db;
   }
  
   @Bean
   public NamedParameterJdbcTemplate getJdbcTemplate() {
      return new NamedParameterJdbcTemplate(dataSource());
   }
   
   @Bean
   public JpaVendorAdapter jpaVendorAdapter() {
       HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
       adapter.setShowSql(true);
       adapter.setGenerateDdl(true);
       adapter.setDatabase(Database.HSQL);
       adapter.setDatabasePlatform("org.hibernate.dialect.HSQLDialect");
       return adapter;
   }

   @Bean
   public LocalContainerEntityManagerFactoryBean entityManagerFactory(
           DataSource dataSource, JpaVendorAdapter jpaVendorAdapter) {

       Properties props = new Properties();
       props.setProperty("hibernate.format_sql", String.valueOf(true));
       
       LocalContainerEntityManagerFactoryBean emf =
               new LocalContainerEntityManagerFactoryBean();
       emf.setDataSource(dataSource);
       emf.setPackagesToScan("hu.bandur.mvc");
       emf.setJpaVendorAdapter(jpaVendorAdapter);
       emf.setJpaProperties(props);

       return emf;
   }

   @Bean
   public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
       return new JpaTransactionManager(emf);
   }

   @Bean
   public BeanPostProcessor persistenceTranslation() {
       return new PersistenceExceptionTranslationPostProcessor();
   }
}
