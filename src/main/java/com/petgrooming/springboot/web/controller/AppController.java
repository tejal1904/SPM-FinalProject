package com.petgrooming.springboot.web.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.joda.time.DateTime;
import org.joda.time.DateTimeComparator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.petgrooming.springboot.web.model.Appointment;
import com.petgrooming.springboot.web.model.Client;
import com.petgrooming.springboot.web.model.ClientDog;
import com.petgrooming.springboot.web.model.ClientDogPojo;
import com.petgrooming.springboot.web.model.GroomingOption;
import com.petgrooming.springboot.web.model.TimeSlot;
import com.petgrooming.springboot.web.service.AppointmentService;
import com.petgrooming.springboot.web.service.ClientDogService;
import com.petgrooming.springboot.web.service.ClientService;
import com.petgrooming.springboot.web.service.GroomingOptionService;
import com.petgrooming.springboot.web.service.TimeSlotService; 

@Controller
@RequestMapping("/app")
public class AppController {

	@Autowired
    ClientService clientService;
	
	@Autowired
	GroomingOptionService groomingOptionService;
	
	@Autowired
	TimeSlotService timeSlotService;
	
	@Autowired
	AppointmentService appointmentService;
	
	@Autowired
	ClientDogService clientDogService;
     
    @Autowired
    MessageSource messageSource;
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView registration(ModelMap model) {
    	//mailService.sendMail();
    	Client client = new Client();
    	model.addAttribute(client);
        return new ModelAndView("registration");
    }
 
    /*
     * This method will register a new Client.
     */
    @RequestMapping(params = {"register"}, method = RequestMethod.POST)
    public String registerClien(HttpServletRequest request,
			HttpServletResponse response, Client client, Model model, RedirectAttributes attributes)
    {
    	if(clientService.isNewClient(client)) {
    		clientService.saveNewClient(client);
    		model.addAttribute(client);
    		attributes.addFlashAttribute(client);
    		return "redirect:book";
    	}else {
    		return "registration";
    	}     
    }
 
    /*
     * This method will be called on form submission, handling POST request for
     * saving Client in database. It also validates the user input
     */
    @RequestMapping(params = { "login" }, method = RequestMethod.POST)
    public String loginClient(HttpServletRequest request,
			HttpServletResponse response, Client client, RedirectAttributes attributes, ModelMap model) {
    	client = clientService.getClientByEmail(client);
    	if(client.getEmail().equals("tom.petgroomer@gmail.com") && client.getPassword().equals("tom@123")) {
			List<Appointment> allAppointments = appointmentService.getAllAppointment();
			model.addAttribute(allAppointments);
			return "adminPage";
		}
    	if(!clientService.isNewClient(client)) {
    		
    		attributes.addFlashAttribute(client);
    		attributes.addFlashAttribute("type",  "bookAppointment");
    		return "redirect:book";
    	}else {
    		return "registration";
    	}
    }
    
    @RequestMapping(value="/book", method = RequestMethod.GET)
    public String bookAppointment(ModelMap model, Client client) {
    	System.out.println("in method");
    	System.out.println("client: -> "+client.toString());
    	client = clientService.findClientById(client.getId());
    	List<Appointment> appointmentList = appointmentService.getAllAppointment(client.getId());
    	Appointment appointment = new Appointment();
    	appointment.setStatus(true);
    	appointment.setClient(client);
    	model.addAttribute(client);
    	model.addAttribute(appointmentList);
    	model = populateAppointmentDropDown(model, appointment, client);
    	if(!model.containsAttribute("type")) {
    		model.addAttribute("type", "clientInformation");
    	}
    	return "bookAppointment";
    }
    
    @RequestMapping(value = "/appointmentSave", method = RequestMethod.POST)
    public String appointmentSave(@RequestParam("clientId") String clientId, ModelMap model,Appointment appointment, BindingResult result, RedirectAttributes attributes)
    {
    	System.out.println("in save appointment");
    	Client client = clientService.findClientById(Integer.parseInt(clientId));
    	boolean check = isAfterToday(new DateTime(appointment.getAppointmentDate()));
    	if(!check) {
    		model = populateAppointmentDropDown(model, appointment, client);
    		FieldError timeslotError = new FieldError("appointment","appointmentDate","Appointments can be booked only after today.");
            result.addError(timeslotError);
            model.addAttribute(client);
            model.addAttribute("type", "bookAppointment");
    		return "bookAppointment";
    	}
    	appointment.setClient(client);
    	boolean isValidAppointment = appointmentService.saveAppointment(appointment);
    	if(!isValidAppointment) {
    		 model = populateAppointmentDropDown(model, appointment, client);
    		FieldError timeslotError =new FieldError("appointment","timeslot","This time slot is already taken. Please select another time slot");
            result.addError(timeslotError);
            model.addAttribute(client);
            model.addAttribute("type", "bookAppointment");
    		return "bookAppointment";
    	}else {
    		attributes.addFlashAttribute(client);
    		attributes.addFlashAttribute("type", "showAppointment");
    		return "redirect:book";
    	}
    	  
    }
    
    @SuppressWarnings("rawtypes")
	@RequestMapping(value = "/updateClient", method = RequestMethod.POST)
    public String updateClient(ModelMap model, Client client, BindingResult result, RedirectAttributes attributes) {
    	System.out.println("---------->in update ");  
    	clientService.updateClient(client);
    	model.addAttribute(client);
    	attributes.addFlashAttribute(client);
    	attributes.addFlashAttribute("type", "bookAppointment");
		return "redirect:book";
    }
    
    
    @RequestMapping(value = "/dogDetails", method = RequestMethod.POST)
    public void dogDetails(ModelMap model, @RequestBody List<ClientDogPojo> dogData, BindingResult result, RedirectAttributes attributes, HttpServletResponse response) {
    	System.out.println("---------->in dog details ");  
    	Set<ClientDog> dogSet;
    	Client client = clientService.findClientById(dogData.get(0).getClientId());
    	if(client.getDogSet().size() == 0) {
    		dogSet = new HashSet<>();
    	}else {
    		dogSet = client.getDogSet();
    	}
    	for(ClientDogPojo pojo: dogData) {
    		ClientDog clientDog = new ClientDog();
    		clientDog.setClient(clientService.findClientById(pojo.getClientId()));
    		clientDog.setName(pojo.getName());
    		clientDog.setBreed(pojo.getBreed());
    		clientDog.setDateOfBirth(pojo.getDateOfBirth());
    		clientDog.setClient(client);
    		dogSet.add(clientDog);
    	}
    	client.setDogSet(dogSet);
    	clientService.updateClient(client);
    	attributes.addFlashAttribute(client);
    	System.out.println("dogdata: "+ dogData);
		//return "redirect:book";
    }
    
    @RequestMapping(value = "/editAppointment")
    public String appointmentEdit(ModelMap model, @RequestParam("appointmentId") int aptid,@RequestParam("clientId") int clientid, RedirectAttributes attributes ) throws Exception
    {
    	System.out.println("in edit appointment");
    	Appointment appointment = appointmentService.getAppointmentById(aptid);
    	Client client = clientService.findClientById(clientid);
    	model = populateAppointmentDropDown(model, appointment, client);
    	model.addAttribute(appointment);
    	return "editAppointment";
    }
    
    @RequestMapping(value = "/appointmentUpdate", method = RequestMethod.POST)
    public String appointmentUpdate(ModelMap model,Appointment appointment, BindingResult result, RedirectAttributes attributes)
    {
    	boolean check = appointmentService.updateAppointment(appointment.getAppointmentId(), appointment.getAppointmentDate(), appointment.getTimeslot());
    	if(check) {
    		appointment = appointmentService.getAppointmentById(appointment.getAppointmentId());
    		FieldError timeslotError =new FieldError("appointment","timeslot","Appointment Reschduled");
            result.addError(timeslotError);
    		model = populateAppointmentDropDown(model, appointment, appointment.getClient());
            model.addAttribute(appointment.getClient());
            model.addAttribute(appointment);
            attributes.addFlashAttribute(appointment.getClient());
            attributes.addFlashAttribute("type", "showAppointment");
    		return "redirect:book";
    	}else {
    		FieldError timeslotError =new FieldError("appointment","timeslot","This date and time slot is already taken. Please select another time slot");
            result.addError(timeslotError);
    		model = populateAppointmentDropDown(model, appointment, appointment.getClient());
            model.addAttribute(appointment.getClient());
            model.addAttribute(appointment);
            return "editAppointment";
    	}
    }
    
    @RequestMapping(value = "/deleteAppointment")
    public String appointmentDelete(ModelMap model, @RequestParam("appointmentId") int aptid,@RequestParam("clientId") int clientid, RedirectAttributes attributes ) throws Exception
    {
    	System.out.println("in delete appointment");
    	Appointment appointment = appointmentService.getAppointmentById(aptid);
    	Client client = clientService.findClientById(clientid);
    	appointmentService.deleteAppointment(appointment);
    	model = populateAppointmentDropDown(model, appointment, client);
    	model.addAttribute(appointment);
    	attributes.addFlashAttribute(appointment.getClient());
    	attributes.addFlashAttribute("type", "showAppointment");
		return "redirect:book";
    }
    
    
    @RequestMapping(value = "/editClientDog")
    public String clientDogEdit(ModelMap model, @RequestParam("dogId") int dogid,@RequestParam("clientId") int clientid, RedirectAttributes attributes ) throws Exception
    {
    	System.out.println("in edit clientDog");
    	ClientDog clientDog = clientDogService.getDogById(dogid);
    	Client client = clientService.findClientById(clientid);
    	model.addAttribute(client);
    	model.addAttribute(clientDog);
    	return "editDog";
    }
    
    @RequestMapping(value = "/dogUpdate", method = RequestMethod.POST)
    public String clientDogUpdate(@RequestParam("clientId") int clientid, ModelMap model,ClientDog dog, BindingResult result, RedirectAttributes attributes)
    {
    	Client client = clientService.findClientById(clientid);
    	clientDogService.updateDog(dog, client);
    	attributes.addFlashAttribute(client);
		return "redirect:book";
    }
    
    @RequestMapping(value = "/deleteClientDog")
    public String clientDogDelete(ModelMap model, @RequestParam("dogId") int dogid,@RequestParam("clientId") int clientid, RedirectAttributes attributes ) throws Exception
    {
    	System.out.println("in delete dog");
    	ClientDog dog = clientDogService.getDogById(dogid);
    	Client client = clientService.findClientById(clientid);
    	client.getDogSet().remove(dog);
    	clientService.updateClient(client);
    	attributes.addFlashAttribute(client);
		return "redirect:book";
    }
    
    
    @RequestMapping(value = "/addDogDetails")
    public String addDogDetails(ModelMap model, @RequestParam("clientId") int clientid, RedirectAttributes attributes )
    {
    	System.out.println("in dog details");
    	Client client = clientService.findClientById(clientid);
    	return "dogDetail";
    }

    private static boolean isAfterToday(DateTime date) {
        return DateTimeComparator.getDateOnlyInstance().compare(date, DateTime.now()) > 0;
    }

    private ModelMap populateAppointmentDropDown(ModelMap model, Appointment appointment, Client client) {
    	List<GroomingOption> groomingOptionList = groomingOptionService.getGroomingOptions();
    	List<TimeSlot> timeSlotList = timeSlotService.findAllTimeSlots();
    	model.addAttribute(groomingOptionList);
    	model.addAttribute(timeSlotList);
    	model.addAttribute(appointment);
    	return model;
    }
    
    
}
