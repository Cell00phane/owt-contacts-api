package owt.demo.contacts.api.endpoints;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import owt.demo.contacts.api.ApiUtil;
import owt.demo.contacts.api.ContactApi;
import owt.demo.contacts.api.services.ContactsService;
import owt.demo.contacts.model.Contact;

import java.util.List;

@Controller
@Api(value = "Contact", description = "the Contact API")
public class ContactsController implements ContactApi {

    @Autowired
    ContactsService contactsService;

    @ApiOperation(value = "Get all contacts", nickname = "getContacts", notes = "Get the contacts of everyone", response = Contact.class, responseContainer = "List", tags={ "contact", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = Contact.class, responseContainer = "List") })
    @RequestMapping(value = "/contacts",
            produces = { "application/json" },
            method = RequestMethod.GET)
    @Override
    public ResponseEntity<List<Contact>> getContacts() throws Exception {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"firstName\" : \"firstName\", \"lastName\" : \"lastName\", \"address\" : \"address\", \"phoneNumber\" : \"phoneNumber\", \"fullName\" : \"fullName\", \"email\" : \"email\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return ResponseEntity.ok(contactsService.getContacts());
    }

}
