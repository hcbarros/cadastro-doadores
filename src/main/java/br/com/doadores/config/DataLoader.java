package br.com.doadores.config;

import java.io.FileReader;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.boot.CommandLineRunner;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.doadores.model.Doador;
import br.com.doadores.repository.DoadorRepository;

@Configuration
@Profile("prod")
public class DataLoader {
		
	@Bean
	CommandLineRunner baseLoad(DoadorRepository repository) {
		 
		return (args) -> {
			
			JSONParser jsonParser = new JSONParser();
			JSONArray jsonArray = (JSONArray) jsonParser.parse(new FileReader("data.json"));

			Iterator<JSONObject> iterator = jsonArray.iterator();
			while(iterator.hasNext()) {
				
				JSONObject obj = (JSONObject) iterator.next();
				
				LocalDate l = LocalDate.parse((String) obj.get("data_nasc"), 
						DateTimeFormatter.ofPattern("dd/MM/yyyy"));		
				
				Calendar data_nasc = new GregorianCalendar(l.getYear(), l.getMonthValue() - 1, l.getDayOfMonth());
								
				Doador doador = new Doador();
							
				doador.setNome((String) obj.get("nome"));
				doador.setCpf((String) obj.get("cpf"));
				doador.setData_nasc(data_nasc);
				doador.setSexo((String) obj.get("sexo"));
				doador.setMae((String) obj.get("mae"));
				doador.setPai((String) obj.get("pai"));
				doador.setEmail((String) obj.get("email"));
				doador.setCep((String) obj.get("cep"));
				doador.setEndereco((String) obj.get("endereco"));
				doador.setNumero((long) obj.get("numero"));
				doador.setBairro((String) obj.get("bairro"));
				doador.setCidade((String) obj.get("cidade"));
				doador.setEstado((String) obj.get("estado"));
				doador.setTelefone_fixo((String) obj.get("telefone_fixo"));
				doador.setCelular((String) obj.get("celular"));
				doador.setAltura((double) obj.get("altura"));
				doador.setPeso((long) obj.get("peso"));
				doador.setTipo_sanguineo((String) obj.get("tipo_sanguineo"));													
				
				
				repository.save(doador);
			}
		
			
			//System.out.println(System.getProperty("user.dir"));					
		};
	}

}
