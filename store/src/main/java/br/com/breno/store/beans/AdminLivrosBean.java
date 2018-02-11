package br.com.breno.store.beans;

import java.io.IOException;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.Part;
import javax.transaction.Transactional;

import br.com.breno.store.daos.AutorDao;
import br.com.breno.store.daos.LivroDao;
import br.com.breno.store.infra.FileSaver;
import br.com.breno.store.models.Autor;
import br.com.breno.store.models.Livro;

//CDI
@Named
@RequestScoped
public class AdminLivrosBean {
	
	private Livro livro = new Livro();	
	
	@Inject
	private LivroDao livroDao;
	
	@Inject 
	private AutorDao autorDao;
	
	@Inject
	private FacesContext context;	
	
	private Part capaLivro;	
		
	public void limparCampos() {
		this.livro = new Livro();		
	}

	@Transactional
	public String salvar() throws IOException {		
		
		livroDao.salvar(livro);
		
		FileSaver fileSaver = new FileSaver();
		livro.setCapaPath(fileSaver.write(capaLivro, "livros"));		
					
		limparCampos();		
				
		context.getExternalContext()
			.getFlash().setKeepMessages(true);
		
		context.addMessage(null, new FacesMessage("Livro cadastrado com sucesso!"));
		
		return "/livros/lista?faces-redirect=true";	
		
	}	

	public List<Autor> getAutores(){
		return  autorDao.listar();
		
	}
	
	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public Part getCapaLivro() {
		return capaLivro;
	}

	public void setCapaLivro(Part capaLivro) {
		this.capaLivro = capaLivro;
	}

}
