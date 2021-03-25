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
			+ "WHEN (DATEDIFF(DAY,data_nasc,CURRENT_DATE)/365.25) >= 0 AND (DATEDIFF(DAY,data_nasc,CURRENT_DATE)/365.25) < 11 THEN '0 a 10' "
			+ "WHEN (DATEDIFF(DAY,data_nasc,CURRENT_DATE)/365.25) >= 11 AND (DATEDIFF(DAY,data_nasc,CURRENT_DATE)/365.25) < 21 THEN '11 a 20' "
			+ "WHEN (DATEDIFF(DAY,data_nasc,CURRENT_DATE)/365.25) >= 21 AND (DATEDIFF(DAY,data_nasc,CURRENT_DATE)/365.25) < 31 THEN '21 a 30' "
			+ "WHEN (DATEDIFF(DAY,data_nasc,CURRENT_DATE)/365.25) >= 31 AND (DATEDIFF(DAY,data_nasc,CURRENT_DATE)/365.25) < 41 THEN '31 a 40' "
			+ "WHEN (DATEDIFF(DAY,data_nasc,CURRENT_DATE)/365.25) >= 41 AND (DATEDIFF(DAY,data_nasc,CURRENT_DATE)/365.25) < 51 THEN '41 a 50' "
			+ "WHEN (DATEDIFF(DAY,data_nasc,CURRENT_DATE)/365.25) >= 51 AND (DATEDIFF(DAY,data_nasc,CURRENT_DATE)/365.25) < 61 THEN '51 a 60' "
			+ "WHEN (DATEDIFF(DAY,data_nasc,CURRENT_DATE)/365.25) >= 61 AND (DATEDIFF(DAY,data_nasc,CURRENT_DATE)/365.25) < 71 THEN '61 a 70' "
			+ "WHEN (DATEDIFF(DAY,data_nasc,CURRENT_DATE)/365.25) >= 71 AND (DATEDIFF(DAY,data_nasc,CURRENT_DATE)/365.25) < 81 THEN '71 a 80' "
			+ "ELSE 'acima de 81 anos' END) AS faixa_idade, "
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
	
	
	
	@Query(value = "select tipo_sanguineo, AVG(DATEDIFF(DAY,data_nasc,CURRENT_DATE)/365.25) AS media_idade "
			+ "FROM doador GROUP BY tipo_sanguineo", nativeQuery = true)
	List<Object[]> mediaIdadePorTipoSanguineo();
	
	
	
	@Query(value = "SELECT LEFT('A+', 2), "
			+ "SUM(CASE WHEN (DATEDIFF(DAY,data_nasc,CURRENT_DATE)/365.25) >= 16 AND "
			+ "(DATEDIFF(DAY,data_nasc,CURRENT_DATE)/365.25) < 70 AND peso > 50 AND "
			+ "(tipo_sanguineo = 'A+' OR tipo_sanguineo = 'A-' OR tipo_sanguineo = 'O+' OR "
			+ "tipo_sanguineo = 'O-') THEN 1 ELSE 0 END) FROM doador UNION "
			
			+ "SELECT LEFT('A-', 2), "
			+ "SUM(CASE WHEN (DATEDIFF(DAY,data_nasc,CURRENT_DATE)/365.25) >= 16 AND "
			+ "(DATEDIFF(DAY,data_nasc,CURRENT_DATE)/365.25) < 70 AND peso > 50 AND "
			+ "(tipo_sanguineo = 'A-' OR tipo_sanguineo = 'O-') THEN 1 ELSE 0 END) FROM doador UNION "
			
			+ "SELECT LEFT('B+', 2), "
			+ "SUM(CASE WHEN (DATEDIFF(DAY,data_nasc,CURRENT_DATE)/365.25) >= 16 AND "
			+ "(DATEDIFF(DAY,data_nasc,CURRENT_DATE)/365.25) < 70 AND peso > 50 AND "
			+ "(tipo_sanguineo = 'B+' OR tipo_sanguineo = 'B-' OR tipo_sanguineo = 'O+' OR "
			+ "tipo_sanguineo = 'O-') THEN 1 ELSE 0 END) FROM doador UNION "
			
			+ "SELECT LEFT('B-', 2), "
			+ "SUM(CASE WHEN (DATEDIFF(DAY,data_nasc,CURRENT_DATE)/365.25) >= 16 AND "
			+ "(DATEDIFF(DAY,data_nasc,CURRENT_DATE)/365.25) < 70 AND peso > 50 AND "
			+ "(tipo_sanguineo = 'B-' OR tipo_sanguineo = 'O-') THEN 1 ELSE 0 END) FROM doador UNION "
			
			+ "SELECT LEFT('AB+', 3), "
			+ "SUM(CASE WHEN (DATEDIFF(DAY,data_nasc,CURRENT_DATE)/365.25) >= 16 AND "
			+ "(DATEDIFF(DAY,data_nasc,CURRENT_DATE)/365.25) < 70 AND peso > 50 "
			+ "THEN 1 ELSE 0 END) FROM doador UNION "
			
			+ "SELECT LEFT('AB-', 3), "
			+ "SUM(CASE WHEN (DATEDIFF(DAY,data_nasc,CURRENT_DATE)/365.25) >= 16 AND "
			+ "(DATEDIFF(DAY,data_nasc,CURRENT_DATE)/365.25) < 70 AND peso > 50 AND "
			+ "(tipo_sanguineo = 'A-' OR tipo_sanguineo = 'B-' OR tipo_sanguineo = 'O-' OR "
			+ "tipo_sanguineo = 'AB-') THEN 1 ELSE 0 END) FROM doador UNION "
			
			+ "SELECT LEFT('O+', 2), "
			+ "SUM(CASE WHEN (DATEDIFF(DAY,data_nasc,CURRENT_DATE)/365.25) >= 16 AND "
			+ "(DATEDIFF(DAY,data_nasc,CURRENT_DATE)/365.25) < 70 AND peso > 50 AND "
			+ "(tipo_sanguineo = 'O+' OR tipo_sanguineo = 'O-') THEN 1 ELSE 0 END) FROM doador UNION "
			
			+ "SELECT LEFT('O-', 2), "
			+ "SUM(CASE WHEN (DATEDIFF(DAY,data_nasc,CURRENT_DATE)/365.25) >= 16 AND "
			+ "(DATEDIFF(DAY,data_nasc,CURRENT_DATE)/365.25) < 70 AND peso > 50 AND "
			+ "tipo_sanguineo = 'O-' THEN 1 ELSE 0 END) FROM doador", nativeQuery = true)
	
	List<Object[]> doadoresPorTipoReceptor();
		

}