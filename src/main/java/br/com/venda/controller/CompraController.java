package br.com.venda.controller;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.venda.model.bean.Compra;
import br.com.venda.model.dao.IClienteDao;
import br.com.venda.model.dao.ICompraDao;
import br.com.venda.model.dao.IProdutoDao;

/**
 * classe controlador da compra
 * @author fernando
 *
 */
@Controller
public class CompraController {

	@Autowired
	private ICompraDao compraDao;

	@Autowired
	private IClienteDao clienteDao;

	@Autowired
	private IProdutoDao produtoDao;
	
	/**
	 * metodo que carrega o formulario
	 * @param map
	 * @return
	 */
	@RequestMapping("compra")
	public String setupForm(Map<String, Object> map) {
		map.put("compra", new Compra());
		map.put("compras", this.compraDao.findAll());
		map.put("clientes", this.clienteDao.findAll());
		map.put("produtos", this.produtoDao.findAll());

		return "form-compra";
	}
	
	/**
	 * metodo que recebe a acao do formulario
	 * @param compra
	 * @param result
	 * @param action
	 * @param map
	 * @return
	 */
	@RequestMapping(value="compra.do", method=RequestMethod.POST)
	public String doAction(@ModelAttribute Compra compra, BindingResult result,
			@RequestParam String action, Map<String, Object> map) {
		
		Compra compraResult = new Compra();
		
		switch (action.toLowerCase()) {
		
		case "add":
			compra.setData(new Date());
			compra.setHora(new Date());
			this.compraDao.save(compra);
			break;
			
		case "edit":
			this.compraDao.update(compra);
			break;
			
		case "search":
			Compra compraSearch = this.compraDao.find(compra.getId());
			compraResult = compraSearch!=null ? compraSearch : compraResult;
			break;
			
		/**
		 * apenas o administrador
		 */
		case "delete":
			this.compraDao.delete(compra);
			break;
		}
		
		map.put("compra", compraResult);
		map.put("compras", this.compraDao.findAll());
		map.put("clientes", this.clienteDao.findAll());
		map.put("produtos", this.produtoDao.findAll());
		
		return "form-compra";
	}
	
}
