package br.com.fiap.si.managedbean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import br.com.fiap.si.bean.Funcionario;
import br.com.fiap.si.dao.FuncionarioDAO;

public class FuncionarioMB {

	//Propriedades de entrada
	private Funcionario funcionario;

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	//Propriedade de saida (placeholder)
	private List<Funcionario> listaFuncionarios;

	public List<Funcionario> getListaFuncionarios() {
		return listaFuncionarios;
	}
	
	//Metodo construtor
	public FuncionarioMB(){
		funcionario = new Funcionario();
		listaFuncionarios = new ArrayList<Funcionario>();
	}
	
	//Metodos action controller
	public String incluir(){
		
		try{
			FuncionarioDAO dao = new FuncionarioDAO();
			dao.insert(funcionario);
			
			return listar();
			
		}catch(Exception e){
			return failToString();
		}
	}
	
	public String listar(){
		
		try{
			FuncionarioDAO dao = new FuncionarioDAO();
			listaFuncionarios = dao.getAll();
			
			return allToString();
			
		}catch(Exception e){
			return failToString();
		}
		
	}
	
	public String pesquisar(){
		
		try{
			FuncionarioDAO dao = new FuncionarioDAO();
			listaFuncionarios = dao.getFuncionarioByPk(funcionario.getCpf());
			
			return allToString();
			
		}catch(Exception e){
			return failToString();
		}
		
	}
	
	private String allToString() {
		return "all";
	}
	
	private String failToString() {
		return "fail";
	}
	
}
