package br.com.doadores.model;

import java.time.LocalDate;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name = "doador")
public class Doador {

   @Id
   @GeneratedValue
   private Long id;

   private String nome;

   private String cpf;
   
   private String rg;
   
   @Temporal(TemporalType.DATE)
   private Calendar data_nasc;
   
   private String sexo;
   
   private String mae;
   
   private String pai;
   
   private String email;
   
   private String cep;
   
   private String endereco;
   
   private Long numero;
   
   private String bairro;
   
   private String cidade;
   
   private String estado;
   
   private String telefone_fixo;
   
   private String celular;
   
   private Double altura;
   
   private Long peso;
   
   private String tipo_sanguineo;
   
   
   public Doador() {
	   
   }


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
	public String getRg() {
		return rg;
	}


	public void setRg(String rg) {
		this.rg = rg;
	}


	public Calendar getData_nasc() {
		return data_nasc;
	}


	public void setData_nasc(Calendar data_nasc) {
		this.data_nasc = data_nasc;
	}


	public String getSexo() {
		return sexo;
	}


	public void setSexo(String sexo) {
		this.sexo = sexo;
	}


	public String getMae() {
		return mae;
	}


	public void setMae(String mae) {
		this.mae = mae;
	}


	public String getPai() {
		return pai;
	}


	public void setPai(String pai) {
		this.pai = pai;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getCep() {
		return cep;
	}


	public void setCep(String cep) {
		this.cep = cep;
	}


	public String getEndereco() {
		return endereco;
	}


	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}


	public Long getNumero() {
		return numero;
	}


	public void setNumero(Long numero) {
		this.numero = numero;
	}


	public String getBairro() {
		return bairro;
	}


	public void setBairro(String bairro) {
		this.bairro = bairro;
	}


	public String getCidade() {
		return cidade;
	}


	public void setCidade(String cidade) {
		this.cidade = cidade;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public String getTelefone_fixo() {
		return telefone_fixo;
	}


	public void setTelefone_fixo(String telefone_fixo) {
		this.telefone_fixo = telefone_fixo;
	}


	public String getCelular() {
		return celular;
	}


	public void setCelular(String celular) {
		this.celular = celular;
	}


	public Double getAltura() {
		return altura;
	}


	public void setAltura(Double altura) {
		this.altura = altura;
	}


	public Long getPeso() {
		return peso;
	}


	public void setPeso(Long peso) {
		this.peso = peso;
	}


	public String getTipo_sanguineo() {
		return tipo_sanguineo;
	}


	public void setTipo_sanguineo(String tipo_sanguineo) {
		this.tipo_sanguineo = tipo_sanguineo;
	}
	   
}
