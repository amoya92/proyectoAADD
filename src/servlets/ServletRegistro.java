package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controlador.Controlador;
import modelo.Usuario;

/**
 * Servlet implementation class ServletRegistro
 */
@WebServlet(urlPatterns = { "/ServletRegistro" }, initParams = { @WebInitParam(name = "Autor", value = "Antonio") })
public class ServletRegistro extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletRegistro() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("static-access")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String usuario = request.getParameter("usuario");
		String telefono = request.getParameter("telefono");
		String mail = request.getParameter("email");
		String contrasena = request.getParameter("clave");
		String contrasena2 = request.getParameter("clave2");
		
		if(!contrasena.equals(contrasena2)) response.sendError(response.SC_UNAUTHORIZED, "Contraseñas diferentes.");
		
		Usuario usu = Controlador.getUnicaInstancia().obtenerUsuario(usuario);
		
		if(usu != null){
			response.sendError(response.SC_UNAUTHORIZED, "El usuario ya existe");
		}
		
		usu = Controlador.getUnicaInstancia().registrarUsuario(usuario, contrasena, mail, telefono);
		
		HttpSession session = request.getSession();
		session.setAttribute("usuarioActual", Controlador.getUnicaInstancia().obtenerUsuario(usuario));
		
		
		response.getWriter().append("<html>")
							.append("<head><title>Usuario registrado</title></head>")
							.append("<body> Se ha registrado el usuario:" + usu.getUsuario() + "<br/>")
							.append("--> autor:" + getServletConfig().getInitParameter("Autor"))
							.append("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
