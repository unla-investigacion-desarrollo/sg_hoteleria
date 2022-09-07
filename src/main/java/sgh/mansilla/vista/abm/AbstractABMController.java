package sgh.mansilla.vista.abm;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import sgh.mansilla.modelo.datos.persona.Pasajero;
import sgh.mansilla.modelo.negocio.ABM;

public abstract class AbstractABMController<ID, ENTITY> {

	protected final String viewBaseLocation;

	@Autowired
	protected ABM<ID, ENTITY> abm;

	@Autowired
	protected MessageSource messageSource;

	protected Logger logger = LoggerFactory.getLogger(this.getClass());

	public AbstractABMController(String viewBaseLocation) {
		this.viewBaseLocation = viewBaseLocation;
	}

	protected void setAbm(ABM<ID, ENTITY> abm) {
		this.abm = abm;
	}

	/**
	 * This method will list all existing users.
	 */
	@RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
	public String listEntities(ModelMap model) {

		List<ENTITY> entities = abm.listar();

		logger.info("Tengo {} usuarios registrados", entities.size());
		
		model.addAttribute("entities", entities);
		model.addAttribute("loggedinuser", getPrincipal());
	
		return viewBaseLocation + "/list";
	}

	/**
	 * This method will provide the medium to add a new user.
	 */
	@RequestMapping(value = { "/new"}, method = RequestMethod.GET)
	public String newEntity(ModelMap model) {
		ENTITY entity = createEntity();

		model.addAttribute("entity", entity);
		model.addAttribute("edit", false);
		model.addAttribute("loggedinuser", getPrincipal());
		return viewBaseLocation + "/form";
	}

	/**
	 * Factory method for entities
	 * @return
	 */
	protected abstract ENTITY createEntity();

	/**
	 * This method will be called on form submission, handling POST request for
	 * saving user in database. It also validates the user input
	 */
	@RequestMapping(value = { "/new" }, method = RequestMethod.POST)
	public String saveEntity(@Valid ENTITY tipoConsumo, BindingResult result, ModelMap model,
			@RequestParam(required = false) Integer idEstadia) {
		try{
	
			if (result.hasErrors()) {
				return viewBaseLocation + "/form";
			}
	
			abm.guardar(tipoConsumo);
	
			if(idEstadia != null){
				model.addAttribute("idEstadia", idEstadia);
			}
	
			model.addAttribute("success", "La creaci&oacuten se realiz&oacute correctamente.");
			
		} catch(Exception e) {
			model.addAttribute("success", "La creaci&oacuten no pudo realizarse.");
		}
		model.addAttribute("loggedinuser", getPrincipal());
		return "redirect:list";
	}

	/**
	 * This method will provide the medium to update an existing user.
	 */
	@RequestMapping(value = { "/edit-{id}" }, method = RequestMethod.GET)
	public String editEntity(@PathVariable ID id, ModelMap model,
			@RequestParam(required = false) Integer idEstadia) {
		ENTITY entity = abm.buscarPorId(id);
		model.addAttribute("entity", entity);
		model.addAttribute("edit", true);

		if(idEstadia != null){
			model.addAttribute("idEstadia", idEstadia);
		}

		model.addAttribute("loggedinuser", getPrincipal());
		return viewBaseLocation + "/form";
	}

	/**
	 * This method will be called on form submission, handling POST request for
	 * updating user in database. It also validates the user input
	 */
	@RequestMapping(value = { "/edit-{id}" }, method = RequestMethod.POST)
	public String updateEntity(@Valid ENTITY entity, BindingResult result,
			ModelMap model, @PathVariable ID id,@RequestParam(required = false) Integer idEstadia) {
		try{
			if(idEstadia != null){
				model.addAttribute("idEstadia", idEstadia);
			}

			if (result.hasErrors()) {
				return viewBaseLocation + "/form";
			}

			abm.actualizar(entity);

			model.addAttribute("success", "La modificaci&oacuten se realiz&oacute correctamente.");
		} catch (Exception exception) {
			model.addAttribute("success", "La modificaci&oacuten no pudo realizarse.");
		}

		model.addAttribute("loggedinuser", getPrincipal());
		//return viewBaseLocation + "/list";
		return "redirect:list";

	}

	/**
	 * This method will delete an user by it's SSOID value.
	 */
	@RequestMapping(value = { "/delete-{id}" }, method = RequestMethod.GET)
	public String deleteUser(@PathVariable ID id, ModelMap model, @RequestParam(required = false) Integer idEstadia) {
		try{
			abm.eliminarPorId(id);
			model.addAttribute("success", "La eliminaci&oacuten se realiz&oacute correctamente.");
			if(idEstadia != null){
				model.addAttribute("idEstadia", idEstadia);
			}
		}
		catch (Exception exception) {
			model.addAttribute("success", "No se pudo completar la solicitud. Comuniquese con el administrador del sistema.");
		}


		return "redirect:list";
	}

	/**
	 * This method returns the principal[user-name] of logged-in user.
	 */
	protected String getPrincipal() {
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			userName = ((UserDetails) principal).getUsername();
		} else {
			userName = principal.toString();
		}
		return userName;
	}



}