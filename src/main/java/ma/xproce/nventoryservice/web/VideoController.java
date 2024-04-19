package ma.xproce.nventoryservice.web;

import jakarta.validation.Valid;
import ma.xproce.nventoryservice.dao.entites.Video;
import ma.xproce.nventoryservice.dao.repositories.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class VideoController {
    @Autowired
    private VideoRepository videoRepository;
    @GetMapping("/index")
    public String index(Model model , @RequestParam(name="page", defaultValue = "0") int page ,
                        @RequestParam(name="size", defaultValue ="5" ) int size,
                        @RequestParam(name = "Keyword", defaultValue = "") String Keyword) {
        Page<Video> pageVideos = videoRepository.findByNameContainsIgnoreCase(Keyword, PageRequest.of(page, size));
        model.addAttribute("listVideo", pageVideos.getContent());
        model.addAttribute("pages", new int[pageVideos.getTotalPages()]);
        model.addAttribute("currentPage", page);
        model.addAttribute("Keyword", Keyword);
        return "videos";
    }
    @GetMapping("/deleteVideo")
    public String delete(@RequestParam(name="id") Long id ,String Keyword , int page ){
        videoRepository.deleteById(id);
        return "redirect:/index?page="+page+"&Keyword="+Keyword;
    }
    @GetMapping("/formVideo")
    public String formVideo( Model model){
        model.addAttribute("Video", new Video());
        return "formVideo";
    }

    @PostMapping(path = "/save")
    public String save( Model model, @Valid Video video, BindingResult bindingResult , @RequestParam (defaultValue = "0")int page ,
                       @RequestParam(defaultValue = "")
                       String Keyword){
        if(bindingResult.hasErrors())return "formVideo";
       videoRepository.save(video);
        return "redirect:/index?page="+page+"&Keyword="+Keyword;
    }

    @GetMapping("/editVideo")
    public String editVideo( Model model ,Long id , String Keyword,int page ){
      Video video =videoRepository.findById(id).orElse(null);
        if(video==null) throw  new RuntimeException("Video interoperable");
        model.addAttribute("Video", video);
        model.addAttribute("page",page);
        model.addAttribute("Keyword",Keyword);

        return "editVideo";
    }



    }
