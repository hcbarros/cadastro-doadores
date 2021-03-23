package br.com.doadores.repository;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.doadores.model.Doador;

public interface DoadorRepository extends JpaRepository<Doador, Long> {
		
	@Query(value = "select count(*) AS c, estado FROM doador "
			+ "GROUP BY estado ORDER BY c DESC", nativeQuery = true)
	List<Object[]> doadoresPorEstado();
	
	@Query(value = "SELECT SUM(peso/(altura*altura))/count(*) as imc_medio, (CASE "
			+ "WHEN FLOOR(DATEDIFF(DAY,data_nasc,CURRENT_DATE)/365.25) >= 0 AND FLOOR(DATEDIFF(DAY,data_nasc,CURRENT_DATE)/365.25) <= 10 THEN '0 a 10' "
			+ "WHEN FLOOR(DATEDIFF(DAY,data_nasc,CURRENT_DATE)/365.25) >= 11 AND FLOOR(DATEDIFF(DAY,data_nasc,CURRENT_DATE)/365.25) <= 20 THEN '11 a 20' "
			+ "WHEN FLOOR(DATEDIFF(DAY,data_nasc,CURRENT_DATE)/365.25) >= 21 AND FLOOR(DATEDIFF(DAY,data_nasc,CURRENT_DATE)/365.25) <= 30 THEN '21 a 30' "
			+ "WHEN FLOOR(DATEDIFF(DAY,data_nasc,CURRENT_DATE)/365.25) >= 31 AND FLOOR(DATEDIFF(DAY,data_nasc,CURRENT_DATE)/365.25) <= 40 THEN '31 a 40' "
			+ "WHEN FLOOR(DATEDIFF(DAY,data_nasc,CURRENT_DATE)/365.25) >= 41 AND FLOOR(DATEDIFF(DAY,data_nasc,CURRENT_DATE)/365.25) <= 50 THEN '41 a 50' "
			+ "WHEN FLOOR(DATEDIFF(DAY,data_nasc,CURRENT_DATE)/365.25) >= 51 AND FLOOR(DATEDIFF(DAY,data_nasc,CURRENT_DATE)/365.25) <= 60 THEN '51 a 60' "
			+ "WHEN FLOOR(DATEDIFF(DAY,data_nasc,CURRENT_DATE)/365.25) >= 61 AND FLOOR(DATEDIFF(DAY,data_nasc,CURRENT_DATE)/365.25) <= 70 THEN '61 a 70' "
			+ "WHEN FLOOR(DATEDIFF(DAY,data_nasc,CURRENT_DATE)/365.25) >= 71 AND FLOOR(DATEDIFF(DAY,data_nasc,CURRENT_DATE)/365.25) <= 80 THEN '71 a 80' "
			+ "ELSE 'acima de 80 anos' END) AS faixa_idade "
			+ "FROM doador GROUP BY faixa_idade", nativeQuery = true)
	List<Object[]> idadeDoadores();
	
//	@Query(value = "CASE WHEN Quantity > 30 THEN 'The quantity is greater than 30'
//    
//			WHEN Quantity = 30 THEN 'The quantity is 30'
//    ELSE 'The quantity is under 30'
//END AS QuantityText
}