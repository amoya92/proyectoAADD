package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import java.util.Date;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import modelo.Temporada;
import controlador.Controlador;

@ManagedBean(name = "beanCrearPartido")
@SessionScoped
public class BeanVerTemporada {

	@ManagedProperty(value = "#{param.id}")
	private String id;

	
}
