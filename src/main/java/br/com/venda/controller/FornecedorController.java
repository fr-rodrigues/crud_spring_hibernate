package br.com.venda.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.venda.model.bean.Fornecedor;
import br.com.venda.model.dao.IFornecedorDao;

/**
 * Classe controlador do fornecedor
 * @author fernando
 *
 */
@Controller
public class FornecedorController {
	
	@Autowired
	private IFornecedorDao fornecedorDao;
	
	/**
	 * metodo que redireciona para o formulario fornecedor
	 * @param map
	 * @return
	 */
	@RequestMapping("fornecedor")
	public String setupForm(Map<String, Object> map){
		map.put("fornecedor", new Fornecedor());
		map.put("fornecedores", this.fornecedorDao.findAll());
		
		return "form-fornecedor";
	}
	
	/**
	 * recebe a acao do formulario
	 * @param fornecedor
	 * @param result
	 * @param action
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/fornecedor.do", method=RequestMethod.POST)
	public String doAction(@ModelAttribute Fornecedor fornecedor, BindingResult result,
			@RequestParam String action, Map<String, Object> map){
		
		Fornecedor fornecedorResult = new Fornecedor();
		
		switch (action.toLowerCase()) {
		
		case "add":
			this.fornecedorDao.save(fornecedor);
			break;
			
		case "edit":
			this.fornecedorDao.update(fornecedor);
			break;
		
		case "search":
			Fornecedor fornecedorSearch = this.fornecedorDao.find(fornecedor.getId());
			fornecedorResult = fornecedorSearch!=null ? fornecedorSearch : fornecedorResult;
			break;
			
		/**
		 * apenas o administrador
		 */
		case "delete":
			this.fornecedorDao.delete(fornecedor);
		}
		
		map.put("fornecedor", fornecedorResult);
		map.put("fornecedores", this.fornecedorDao.findAll());
		
		return "form-fornecedor";
	}

}
