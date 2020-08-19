package owt.demo.contacts.api.endpoints;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import owt.demo.contacts.api.ApiUtil;
import owt.demo.contacts.api.SkillApi;
import owt.demo.contacts.api.services.SkillsService;
import owt.demo.contacts.model.Skill;

import java.util.List;

@Controller
@Api(value = "Skill", description = "the Skill API")
public class SkillsController implements SkillApi {

    @Autowired
    SkillsService skillsService;

    @ApiOperation(value = "Get all skills", nickname = "getSkills", notes = "Get all available skills", response = Skill.class, responseContainer = "List", tags={ "skill", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = Skill.class, responseContainer = "List") })
    @RequestMapping(value = "/skills",
            produces = { "application/json" },
            method = RequestMethod.GET)
    @Override
    public ResponseEntity<List<Skill>> getSkills() throws Exception {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"skill\" : \"skill\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return ResponseEntity.ok(skillsService.getSkills());
    }

    @Override
    public ResponseEntity<Object> addSkill(Skill body) throws Exception {
        return ResponseEntity.created(skillsService.saveSkill(body)).build();
    }
}
