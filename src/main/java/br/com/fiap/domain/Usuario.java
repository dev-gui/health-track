package br.com.fiap.domain;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
public class Usuario implements Serializable{
	private static final long serialVersionUID = 1L;

	/**
	 * Id do usuário
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Integer id;
	
	/**
	 * Nome do usuário
	 */
	private String nome;
	
	/**
	 * Sobrenome
	 */
	private String sobrenome;
	
	/**
	 * Gênero do usuário
	 */
	private char sexo;
	
	/**
	 * Altura do usuário
	 */
	private double altura;
	
	/**
	 * Data de nascimento
	 */
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date nascimento;
	
	/**
	 * Login e email do usuário
	 */
	private String email;
	
	/**
	 * Senha de login
	 */
	private String senha;
	
	@OneToMany(mappedBy="usuarioId")
	private List<Peso> pesos = new ArrayList<>();
	
	@OneToMany(mappedBy="usuarioId")
	private List<Pressao> pressao = new ArrayList<>();
	
	@OneToMany(mappedBy="usuarioId")
	private List<Alimentacao> alimentacao = new ArrayList<>();
	
	@OneToMany(mappedBy="usuarioId")
	private List<Atividade> atividade = new ArrayList<>();
	
	/**
	 * Construção de usuário sem parâmetros
	 */
	public Usuario() {}


	/**
	 * Criação de usuário com parâmetros
	 * @param id
	 * @param nome
	 * @param idade
	 * @param sexo
	 * @param altura
	 * @param data em String 
	 * @param email
	 * @param senha
	 * @throws ParseException
	 */
	public Usuario(Integer id, String nome, String sobrenome, char sexo, double altura, Date data, String email,
			String senha) {
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.sexo = sexo;
		this.altura = altura;
		this.nascimento = data;
		this.email = email;
		this.senha = senha;
	}


	/**
	 * Obter nome
	 * @return nome do usuário
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Incluir/modificar novo nome
	 * @param nome novo
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * Obter sobrenome
	 * @return nome do usuário
	 */
	public String getSobrenome() {
		return sobrenome;
	}

	/**
	 * Incluir/modificar novo sobrenome
	 * @param nome novo
	 */
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	/**
	 * Obter gênero
	 * @return gênero
	 */
	public char getSexo() {
		return sexo;
	}


	/**
	 * Incluir/modificar novo gênero
	 * @param sexo
	 */
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}


	/**
	 * Obter altura
	 * @return altura
	 */
	public double getAltura() {
		return altura;
	}


	/**
	 * Incluir/modificar nova altura
	 * @param altura
	 */
	public void setAltura(double altura) {
		this.altura = altura;
	}


	/**
	 * Obter nascimento
	 * @return data de nascimento em String
	 */
	public Date getNascimento() {
		return nascimento;
	}


	/**
	 * Incluir/modificar nova data de nascimento
	 * @param data
	 * @throws ParseException
	 */
	public void setNascimento(Date data) {
		this.nascimento = data;
	}


	/**
	 * Obter email
	 * @return email
	 */
	public String getEmail() {
		return email;
	}


	/**
	 * Incluir/modificar novo email
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}


	/**
	 * Obter senha
	 * @return senha
	 */
	public String getSenha() {
		return senha;
	}


	/**
	 * incluir/modificar nova senha
	 * @param senha
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}


	/**
	 * Obter id
	 * @return id
	 */
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	

}
