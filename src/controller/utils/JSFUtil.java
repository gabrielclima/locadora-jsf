package controller.utils;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

public class JSFUtil {

	public static void retornarMensagemErro(String mensagem, String detalhe, String idComponentePagina) {
		retornarMensagem(FacesMessage.SEVERITY_ERROR, mensagem, detalhe, idComponentePagina);
	}

	public static void retornarMensagemFatal(String mensagem, String detalhe, String idComponentePagina) {
		retornarMensagem(FacesMessage.SEVERITY_FATAL, mensagem, detalhe, idComponentePagina);
	}

	public static void retornarMensagemAviso(String mensagem, String detalhe, String idComponentePagina) {
		retornarMensagem(FacesMessage.SEVERITY_WARN, mensagem, detalhe, idComponentePagina);
	}

	public static void retornarMensagemInfo(String mensagem, String detalhe, String idComponentePagina) {
		retornarMensagem(FacesMessage.SEVERITY_INFO, mensagem, detalhe, idComponentePagina);
	}

	private static void retornarMensagem(Severity status, String mensagem, String detalhe, String idComponentePagina) {
		FacesContext contexto = FacesContext.getCurrentInstance();
		contexto.addMessage(idComponentePagina, new FacesMessage(status, mensagem, detalhe));
	}

}
