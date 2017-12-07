package validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("validadorClave")
public class ValidadorClave implements Validator{

	@Override
	public void validate(FacesContext contex, UIComponent comp, Object value) throws ValidatorException{
		
		if(((String) value).length() <= 4){
			FacesMessage mensaje = new FacesMessage();
			mensaje.setSummary("Error tamaño clave");
			mensaje.setDetail("Error de clave: debe ser mayor de 4 caracteres");
			mensaje.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(mensaje);
		}
	}
}
