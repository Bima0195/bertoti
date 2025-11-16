package com.example.mercado;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class MercadoPequejaApplicationTests implements CommandLineRunner {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void run(String... args) {
		try {
			jdbcTemplate.execute("SELECT 1");
			System.out.println("✅ Conexão com o banco de dados bem-sucedida!");
		} catch (Exception e) {
			System.out.println("❌ Erro ao conectar com o banco de dados:");
			e.printStackTrace();
		}
	}
}

