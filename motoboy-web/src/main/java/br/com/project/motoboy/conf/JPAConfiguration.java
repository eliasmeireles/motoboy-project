package br.com.project.motoboy.conf;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
public class JPAConfiguration {

	@Bean
	public LocalContainerEntityManagerFactoryBean entityMangerFactory() {
		LocalContainerEntityManagerFactoryBean managerFactoryBean = new LocalContainerEntityManagerFactoryBean();

		JpaVendorAdapter adapter = new HibernateJpaVendorAdapter();

		managerFactoryBean.setJpaVendorAdapter(adapter);

		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		dataSource.setUsername("root");
		dataSource.setPassword("root");
		dataSource.setUrl("jdbc:mysql://localhost:3306/fast_motoboy");
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		managerFactoryBean.setDataSource(dataSource);

		Properties properties = new Properties();

		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		properties.setProperty("hibernate.show_sql", "true");
		properties.setProperty("hibernate.hbm2ddl.auto", "update");
		managerFactoryBean.setJpaProperties(properties);

		managerFactoryBean.setPackagesToScan("br.com.project.motoboy.model");

		return managerFactoryBean;
	}
	
	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
		return new JpaTransactionManager(emf);
	}
}
