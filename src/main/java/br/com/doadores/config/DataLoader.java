package br.com.doadores.config;

import java.io.FileReader;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

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
				
				String data_nasc = (String) obj.get("data_nasc");
				String[] data = data_nasc.split("/");
				int dia = Integer.parseInt(data[0]);
				int mes = Integer.parseInt(data[1]);
				int ano = Integer.parseInt(data[2]);
				Calendar calendar = new GregorianCalendar(ano, mes, dia);

				
				Doador d = new Doador((String)obj.get("nome"), (String)obj.get("cpf"),
						calendar, (String) obj.get("sexo"),
						(String) obj.get("mae"), (String) obj.get("pai"), 
						(String) obj.get("email"), (String) obj.get("cep"), 
						(String) obj.get("endereco"), (long) obj.get("numero"),
						(String) obj.get("bairro"), (String) obj.get("cidade"),
						(String) obj.get("estado"), (String) obj.get("telefone_fixo"),
						(String) obj.get("celular"), (double) obj.get("altura"),
						(long) obj.get("peso"), (String) obj.get("tipo_sanguineo"));
				
				repository.save(d);
			}
			
			List<Object[]> list = repository.idadeDoadores();
			
			list.forEach(x -> {
				
				System.out.println(x[0]+"  "+x[1]);
			});
			
			
			//System.out.println(System.getProperty("user.dir"));					
		};
	}

}
