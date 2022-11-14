package pro.goforit.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pro.goforit.myCachePackage.anno.Cache;
import pro.goforit.dto.SearchDTO;
import pro.goforit.myCachePackage.anno.CacheDelete;

/**
 * @author: Double>J
 * @email: zjj20001031@foxmail.com
 * @editTime: 2022/10/24 8:31
 * @desc:
 **/
@RestController
public class TestApi {



    @GetMapping("aaa")
    @Cache(key = "#dto.username+'_'+#dto.date.toLocaleString()")
    public String get(@RequestBody SearchDTO dto){
        return "1111";
    }


    @GetMapping("bbb")
    @CacheDelete(key = "aaa*")
    public String d(){
        return "111;";
    }



}
