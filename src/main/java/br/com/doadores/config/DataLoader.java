package br.com.doadores.config;

import java.io.FileReader;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;

import br.com.doadores.model.Doador;
import br.com.doadores.model.ERole;
import br.com.doadores.model.Role;
import br.com.doadores.model.User;
import br.com.doadores.repository.DoadorRepository;
import br.com.doadores.repository.RoleRepository;
import br.com.doadores.repository.UserRepository;
import br.com.doadores.service.auth.AuthService;

@Configuration
@Profile("prod")
public class DataLoader {
		
	@Autowired
	PasswordEncoder passwordEncoder;
	
	
	@Bean
	CommandLineRunner baseLoad(DoadorRepository doadorRepository,
							   RoleRepository roleRepository, 
							   UserRepository userRepository) {
		 
		return (args) -> {
			
			Set<Role> roles = new HashSet<>();
			roles.add(new Role(ERole.USER));
			roles.add(new Role(ERole.ADMIN));
			
			roleRepository.saveAll(roles);
			
			
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
				doador.setRg((String) obj.get("rg"));
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
				
				
				doadorRepository.save(doador);
			}
		
			
			User user = new User("henriquecbarros", passwordEncoder.encode("henrique123"));
			user.setRoles(roles);
			
			userRepository.save(user);
						
		};
	}

}
