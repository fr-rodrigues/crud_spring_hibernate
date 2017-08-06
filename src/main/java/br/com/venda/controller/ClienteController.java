package br.com.venda.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.venda.model.bean.Cliente;
import br.com.venda.model.dao.IClienteDao;

/**
 * Classe controlador do cliente
 * 
 * @author fernando
 *
 */
@Controller
public class ClienteController {

	@Autowired
	private IClienteDao clienteDao;

	/**
	 * carrega a pagina do cliente
	 * @param map
	 * @return
	 */
	@RequestMapping("cliente")
	public String setupForm(Map<String, Object> map) {
		map.put("cliente", new Cliente());
		map.put("clientes", this.clienteDao.findAll());

		return "form-cliente";
	}

	/**
	 * recebe a acao do fomulario
	 * @param cliente
	 * @param result
	 * @param action
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/cliente.do", method=RequestMethod.POST)
	public String doActions(@ModelAttribute Cliente cliente,
			BindingResult result, @RequestParam String action,
			Map<String, Object> map) {
		
		Cliente clienteResult = new Cliente();
		
		switch (action.toLowerCase()) {
		
		case "add":
			this.clienteDao.save(cliente);
			clienteResult = new Cliente();
			break;
		
		case "edit":
			this.clienteDao.update(cliente);
			clienteResult = cliente;
			break;

		case "search":
			Cliente clienteSearch = this.clienteDao.find(cliente.getId());
			/**
			 * verifica se o cliente a pesquisar existe
			 */
			clienteResult = clienteSearch!=null ? clienteSearch : new Cliente();
			break;
			
		/**
		 * apenas o administrador
		 */
		case "delete":
			this.clienteDao.delete(cliente);
			clienteResult = new Cliente();
			break;		
		}
		
		map.put("cliente", clienteResult);
		map.put("clientes", this.clienteDao.findAll());
		
		return "form-cliente";
	}
}