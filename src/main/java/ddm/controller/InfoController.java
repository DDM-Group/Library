package ddm.controller;

import ddm.entity.Info;
import ddm.enums.Category;
import ddm.enums.InfoStatus;
import ddm.exception.DataNotFoundException;
import ddm.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/info")
public class InfoController {

    private final InfoService infoService;

    @Autowired
    public InfoController(InfoService infoService) {
        this.infoService = infoService;
    }

    @GetMapping
    public List<Info> getInfoList(@RequestParam Category category,
                                  @RequestParam(required = false, defaultValue = "AVAILABLE") InfoStatus status) {
        return infoService.getInfoListByCategory(category, status);
    }

    @GetMapping("/{id}")
    public Info getInfo(@PathVariable int id,
                        @RequestParam(required = false, defaultValue = "AVAILABLE") InfoStatus status) throws DataNotFoundException {
        return infoService.getInfo(id, status);
    }

    @PostMapping(consumes = (MediaType.APPLICATION_JSON_VALUE))
    public Info createInfo(@RequestBody Info info) {
        return infoService.createInfo(info);
    }

    @PutMapping("/{id}")
    public Info updateInfo(@RequestBody Info info, @PathVariable int id) throws DataNotFoundException {
        return infoService.updateInfo(info, id);
    }

    @DeleteMapping("/{id}")
    public int deleteInfo(@PathVariable int id) throws DataNotFoundException {
        return infoService.deleteInfo(id);
    }

}
