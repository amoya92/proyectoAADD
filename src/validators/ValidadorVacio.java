package validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("campoVacio")
public class ValidadorVacio implements Validator{

	@Override
	public void validate(FacesContext contex, UIComponent comp, Object value) throws ValidatorException{
		
		if(((String) value).length() == 0){
			FacesMessage mensaje = new FacesMessage();
			mensaje.setSummary("Error campo vacio.");
			mensaje.setDetail("Error de campo: no puede estar vacio.");
			mensaje.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(mensaje);
		}
	}
}
