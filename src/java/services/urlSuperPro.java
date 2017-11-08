/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;

/**
 *
 * @author miguel
 */
@WebServlet(name = "urlSuperPro", urlPatterns = {"/urlSuperPro"})
public class urlSuperPro extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String paterno = request.getParameter("paterno");
        String materno = request.getParameter("materno");
        String telefono = request.getParameter("telefono");
        String tipopersona = request.getParameter("tipopersona");
        int id=Integer.parseInt(tipopersona);

        System.out.println("Hey el nombre es " + nombre);
        System.out.println("Hey el paterno es " + paterno);
        System.out.println("Hey el materno es " + materno);
        System.out.println("Telefono: "+telefono);
        System.out.println("Tipo de Persona: "+tipopersona);

        UsuarioDAO persona = new UsuarioDAO();
        persona.saveUsuario(nombre, paterno, materno, telefono,id);

        JSONObject json = new JSONObject();
        json.put("resultado", true);
        response.setContentType("application/json utf-8");
        PrintWriter out = response.getWriter();
        out.print(json.toString());
        destroy();
    }

}
