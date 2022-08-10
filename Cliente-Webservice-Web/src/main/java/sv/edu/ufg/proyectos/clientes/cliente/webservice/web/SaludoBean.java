/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sv.edu.ufg.proyectos.clientes.cliente.webservice.web;

import java.io.Serializable;
import java.net.URL;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import sv.edu.ufg.proyectos.clientes.cliente.webservice.web.client.WebServiceTest;
import sv.edu.ufg.proyectos.clientes.cliente.webservice.web.client.WebServiceTestService;

/**
 *
 * @author xtecuan
 */

@Named(value="saludoBean")
@ViewScoped
public class SaludoBean implements Serializable{

    public static final String WSDL = "http://blitzthinkw2:8080/EjemploWebServiceIntelliJIDEA/WebServiceTestService?wsdl";
    private WebServiceTestService servicio;
    private WebServiceTest port;

    private String apodo;
    private String saludo;

    public String getApodo() {
        return apodo;
    }

    public void setApodo(String apodo) {
        this.apodo = apodo;
    }

    public String getSaludo() {
        return saludo;
    }

    public void setSaludo(String saludo) {
        this.saludo = saludo;
    }
    
    

    @PostConstruct
    public void init() {
        try {
            servicio = new WebServiceTestService(new URL(WSDL));
            port = servicio.getWebServiceTestPort();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void saludar(){
        if(apodo!=null && apodo.length()>0 && !apodo.equals("")){
            this.saludo = port.test(apodo);
        }
    }

}
