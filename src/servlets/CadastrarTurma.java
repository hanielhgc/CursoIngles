package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Turma;
import persistence.TurmaDao;

@WebServlet("/CadastrarTurma")
public class CadastrarTurma extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CadastrarTurma() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String cod = request.getParameter("codigo");
		String lvl = request.getParameter("nivel");
		String prof = request.getParameter("professor");
		String hr = request.getParameter("horario");
		String sala = request.getParameter("sala");
		int qtde = Integer.parseInt(request.getParameter("quantidade"));
		String sts = request.getParameter("status");

		Turma turma = new Turma(cod, lvl, prof, hr, sala, qtde, sts);
		TurmaDao tdao = new TurmaDao();

		tdao.inserir(turma);

		RequestDispatcher rd = request.getRequestDispatcher("Index.html");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
