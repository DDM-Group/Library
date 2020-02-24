package ddm.controller;

import ddm.entity.Info;
import ddm.enums.Category;
import ddm.exception.FileNotFoundException;
import ddm.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Info> getInfoList(@RequestParam Category category) {
        return infoService.getInfoListByCategory(category);
    }

    @GetMapping("/{id}")
    public Info getInfo(@PathVariable int id) throws FileNotFoundException {
        return infoService.getInfo(id);
    }

    @PostMapping
    public Info createInfo(@RequestBody Info info) {
        return infoService.createInfo(info);
    }

    @PutMapping("/{id}")
    public Info updateInfo(@RequestBody Info info, @PathVariable int id) throws FileNotFoundException {
        return infoService.updateInfo(info, id);
    }

    @DeleteMapping("/{id}")
    public int deleteInfo(@PathVariable int id) throws FileNotFoundException {
        return infoService.deleteInfo(id);
    }

}
