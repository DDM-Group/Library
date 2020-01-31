package ddm.controller;

import ddm.entity.Info;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/info")
public class InfoController {


    @GetMapping
    public List<Info> getInfoList (){
        return new ArrayList<>();
    }

    @GetMapping("/{id}")
    public Info getInfo(@PathVariable int id){
        return new Info();
    }

    @PostMapping
    public Info createInfo(@RequestBody Info info ){
        return new Info();
    }

    @PutMapping("/{id}")
    public Info updateInfo(@RequestBody Info info, @PathVariable int id ){
        return new Info();
    }

    @DeleteMapping("/{id}")
    public int deleteInfo(@PathVariable int id){

        return id;
    }



}
