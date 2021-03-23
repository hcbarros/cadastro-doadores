package br.com.doadores.repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.doadores.model.Doador;

public interface DoadorRepository extends JpaRepository<Doador, Long> {
	
	
	@Query(value = "select estado, count(*) AS quantidade FROM doador "
			+ "GROUP BY estado ORDER BY quantidade DESC", nativeQuery = true)
	List<Object[]> candidatosPorEstado();
	
	
	
	@Query(value = "SELECT (CASE "
			+ "WHEN FLOOR(DATEDIFF(DAY,data_nasc,CURRENT_DATE)/365.25) >= 0 AND FLOOR(DATEDIFF(DAY,data_nasc,CURRENT_DATE)/365.25) <= 10 THEN '0 a 10' "
			+ "WHEN FLOOR(DATEDIFF(DAY,data_nasc,CURRENT_DATE)/365.25) >= 11 AND FLOOR(DATEDIFF(DAY,data_nasc,CURRENT_DATE)/365.25) <= 20 THEN '11 a 20' "
			+ "WHEN FLOOR(DATEDIFF(DAY,data_nasc,CURRENT_DATE)/365.25) >= 21 AND FLOOR(DATEDIFF(DAY,data_nasc,CURRENT_DATE)/365.25) <= 30 THEN '21 a 30' "
			+ "WHEN FLOOR(DATEDIFF(DAY,data_nasc,CURRENT_DATE)/365.25) >= 31 AND FLOOR(DATEDIFF(DAY,data_nasc,CURRENT_DATE)/365.25) <= 40 THEN '31 a 40' "
			+ "WHEN FLOOR(DATEDIFF(DAY,data_nasc,CURRENT_DATE)/365.25) >= 41 AND FLOOR(DATEDIFF(DAY,data_nasc,CURRENT_DATE)/365.25) <= 50 THEN '41 a 50' "
			+ "WHEN FLOOR(DATEDIFF(DAY,data_nasc,CURRENT_DATE)/365.25) >= 51 AND FLOOR(DATEDIFF(DAY,data_nasc,CURRENT_DATE)/365.25) <= 60 THEN '51 a 60' "
			+ "WHEN FLOOR(DATEDIFF(DAY,data_nasc,CURRENT_DATE)/365.25) >= 61 AND FLOOR(DATEDIFF(DAY,data_nasc,CURRENT_DATE)/365.25) <= 70 THEN '61 a 70' "
			+ "WHEN FLOOR(DATEDIFF(DAY,data_nasc,CURRENT_DATE)/365.25) >= 71 AND FLOOR(DATEDIFF(DAY,data_nasc,CURRENT_DATE)/365.25) <= 80 THEN '71 a 80' "
			+ "ELSE 'acima de 80 anos' END) AS faixa_idade, "
			+ "SUM(peso/(altura*altura))/count(*) as imc_medio "
			+ "FROM doador GROUP BY faixa_idade", nativeQuery = true)
	List<Object[]> imcMedioPorFaixaEtaria();
	
	
	
	@Query(value = "SELECT sexo, CAST(SUM(CASE WHEN (peso/(altura*altura)) > 30 AND sexo = 'Masculino' "
			+ "THEN 1 ELSE 0 END) AS DECIMAL)*100/count(*) "
			+ "FROM doador WHERE sexo = 'Masculino' UNION "
			+ "SELECT sexo, CAST(SUM(CASE WHEN (peso/(altura*altura)) > 30 "
			+ "THEN 1 ELSE 0 END) AS DECIMAL)*100/count(*) "
			+ "FROM doador WHERE sexo = 'Feminino'", nativeQuery = true)
	List<Object[]> percentualObesosPorSexo();
	
	
	
	@Query(value = "select tipo_sanguineo, AVG(FLOOR(DATEDIFF(DAY,data_nasc,CURRENT_DATE)/365.25)) AS media_idade "
			+ "FROM doador GROUP BY tipo_sanguineo", nativeQuery = true)
	List<Object[]> mediaIdadePorTipoSanguineo();
	
	
	
	@Query(value = "SELECT LEFT('A+', 2), "
			+ "SUM(CASE WHEN FLOOR(DATEDIFF(DAY,data_nasc,CURRENT_DATE)/365.25) >= 16 AND "
			+ "FLOOR(DATEDIFF(DAY,data_nasc,CURRENT_DATE)/365.25) <= 69 AND peso > 50 AND "
			+ "(tipo_sanguineo = 'A+' OR tipo_sanguineo = 'A-' OR tipo_sanguineo = 'O+' OR "
			+ "tipo_sanguineo = 'O-') THEN 1 ELSE 0 END) FROM doador UNION "
			
			+ "SELECT LEFT('A-', 2), "
			+ "SUM(CASE WHEN FLOOR(DATEDIFF(DAY,data_nasc,CURRENT_DATE)/365.25) >= 16 AND "
			+ "FLOOR(DATEDIFF(DAY,data_nasc,CURRENT_DATE)/365.25) <= 69 AND peso > 50 AND "
			+ "(tipo_sanguineo = 'A-' OR tipo_sanguineo = 'O-') THEN 1 ELSE 0 END) FROM doador UNION "
			
			+ "SELECT LEFT('B+', 2), "
			+ "SUM(CASE WHEN FLOOR(DATEDIFF(DAY,data_nasc,CURRENT_DATE)/365.25) >= 16 AND "
			+ "FLOOR(DATEDIFF(DAY,data_nasc,CURRENT_DATE)/365.25) <= 69 AND peso > 50 AND "
			+ "(tipo_sanguineo = 'B+' OR tipo_sanguineo = 'B-' OR tipo_sanguineo = 'O+' OR "
			+ "tipo_sanguineo = 'O-') THEN 1 ELSE 0 END) FROM doador UNION "
			
			+ "SELECT LEFT('B-', 2), "
			+ "SUM(CASE WHEN FLOOR(DATEDIFF(DAY,data_nasc,CURRENT_DATE)/365.25) >= 16 AND "
			+ "FLOOR(DATEDIFF(DAY,data_nasc,CURRENT_DATE)/365.25) <= 69 AND peso > 50 AND "
			+ "(tipo_sanguineo = 'B-' OR tipo_sanguineo = 'O-') THEN 1 ELSE 0 END) FROM doador UNION "
			
			+ "SELECT LEFT('AB+', 3), "
			+ "SUM(CASE WHEN FLOOR(DATEDIFF(DAY,data_nasc,CURRENT_DATE)/365.25) >= 16 AND "
			+ "FLOOR(DATEDIFF(DAY,data_nasc,CURRENT_DATE)/365.25) <= 69 AND peso > 50 AND "
			+ "(tipo_sanguineo = 'A+' OR tipo_sanguineo = 'B+' OR tipo_sanguineo = 'O+' OR "
			+ "tipo_sanguineo = 'AB+' OR tipo_sanguineo = 'A-' OR tipo_sanguineo = 'B-' OR "
			+ "tipo_sanguineo = 'O-' OR tipo_sanguineo = 'AB-') THEN 1 ELSE 0 END) FROM doador UNION "
			
			+ "SELECT LEFT('AB-', 3), "
			+ "SUM(CASE WHEN FLOOR(DATEDIFF(DAY,data_nasc,CURRENT_DATE)/365.25) >= 16 AND "
			+ "FLOOR(DATEDIFF(DAY,data_nasc,CURRENT_DATE)/365.25) <= 69 AND peso > 50 AND "
			+ "(tipo_sanguineo = 'A-' OR tipo_sanguineo = 'B-' OR tipo_sanguineo = 'O-' OR "
			+ "tipo_sanguineo = 'AB-') THEN 1 ELSE 0 END) FROM doador UNION "
			
			+ "SELECT LEFT('O+', 2), "
			+ "SUM(CASE WHEN FLOOR(DATEDIFF(DAY,data_nasc,CURRENT_DATE)/365.25) >= 16 AND "
			+ "FLOOR(DATEDIFF(DAY,data_nasc,CURRENT_DATE)/365.25) <= 69 AND peso > 50 AND "
			+ "(tipo_sanguineo = 'O+' OR tipo_sanguineo = 'O-') THEN 1 ELSE 0 END) FROM doador UNION "
			
			+ "SELECT LEFT('O-', 2), "
			+ "SUM(CASE WHEN FLOOR(DATEDIFF(DAY,data_nasc,CURRENT_DATE)/365.25) >= 16 AND "
			+ "FLOOR(DATEDIFF(DAY,data_nasc,CURRENT_DATE)/365.25) <= 69 AND peso > 50 AND "
			+ "tipo_sanguineo = 'O-' THEN 1 ELSE 0 END) FROM doador", nativeQuery = true)
	
	List<Object[]> doadoresPorTipoSanguineoReceptor();
		
}