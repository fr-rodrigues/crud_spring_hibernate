package br.com.venda.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.venda.model.bean.Produto;
import br.com.venda.model.dao.IFornecedorDao;
import br.com.venda.model.dao.IProdutoDao;

/**
 * Classe que controlador do produto
 * @author fernando
 *
 */
@Controller
public class ProdutoController {

	@Autowired
	private IProdutoDao produtoDao;

	@Autowired
	private IFornecedorDao fornecedorDao;

	/**
	 * metodo que carrega o formulario produto
	 * @param map
	 * @return
	 */
	@RequestMapping("produto")
	public String setupForm(Map<String, Object> map) {
		map.put("produto", new Produto());
		map.put("produtos", this.produtoDao.findAll());
		map.put("fornecedores", this.fornecedorDao.findAll());

		return "form-produto";
	}

	@RequestMapping(value="produto.do", method=RequestMethod.POST)
	public String doAction(@ModelAttribute Produto produto,
			BindingResult result, @RequestParam String action,
			Map<String, Object> map) {
		
		Produto produtoResult = new Produto();
		
		switch (action.toLowerCase()) {
		
		case "add":
			this.produtoDao.save(produto);
			break;
			
		case "edit":
			this.produtoDao.update(produto);
			break;
			
		case "search":
			Produto produtoSearch = this.produtoDao.find(produto.getId());
			produtoResult = produtoSearch!=null ? produtoSearch : produtoResult;
			break;
			
		/**
		 * apenas o administrador
		 */
		case "delete":
			this.produtoDao.delete(produto);
			break;
		}
		
		map.put("produto", produtoResult);
		map.put("produtos", this.produtoDao.findAll());
		map.put("fornecedores", this.fornecedorDao.findAll());
		
		return "form-produto";
	}
}
